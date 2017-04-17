(function($) {
    var Entity = window.Entity = {},
        jDelModel, //删除对话框
        jDelModalBody, //删除对话框主体
        jDelUid, //删除对象ID
        jDel, //确认删除按钮
        currDelUid,  
        jAlertErr, //删除失败提示框
        jAlertErrC, //删除失败提示框 内容部分
        jAlertSuc, //删除成功提示框
        jForm, //删除表单
        _timer,

        _initialize = function() {
            jDelModel = $('#modal_del_entity');
            jDelModalBody = $('div.modal-body', jDelModel);
            jDelUid = $('#txt_deleted_entity_id');
            jDel = $('#btn_del_entity');
            jAlertErr = $('#alert_error');
            jAlertSuc = $('#alert_success');
            jAlertErrC = $('p', jAlertErr);
            jForm = $('#form_del_entity');

            _initEvents();
        },

        _delContent = function(entity) {
            return ['<p>您确认要删除 <strong>', entity.name, entity.mobile, entity.code, '</strong> 这个分销吗？</p>'].join(',');
        },

        _delEntityOptions = {
            dataType: 'json',
            success: function(data) {
                var isSuccess = data.status === 1;
                if (isSuccess) { // 删除成功！
                    jAlertSuc.show();
                    $('#tr_entity_' + currDelUid).remove();
                    $('table.table tbody').append('<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td></tr>');
                } else {
                    jAlertErrC.html(data.message);
                    jAlertErr.show();
                }
                _timer = setTimeout(function() {
                    if (isSuccess) {
                        jAlertSuc.alert('close');
                    } else {
                        jAlertErr.alert('close');
                    }
                }, 6000);
            }
        },

        _clearTimer = function() {
            if (_timer) {
                clearTimeout(_timer);
                _timer = null;
            }
        },

        _initEvents = function() {
            jForm.submit(function() {
                jForm.ajaxSubmit(_delEntityOptions);
                return false;
            });
            jDel.click(function() {
                jForm.submit();
                jDelModel.modal('hide');
                return false;
            });
            jAlertErr.on('close', _clearTimer);
            jAlertSuc.on('close', _clearTimer);
        };

    Entity.showDelEntityModal = function(btn) {
        var jBtn = $(btn), 
        uid = jBtn.data('id'),
        name = jBtn.data('name');
        mobile = jBtn.data('mobile');
        code = jBtn.data('code');
        
        jDelUid.val(uid);
        currDelUid = uid;
        jDelModalBody.html(_delContent({ name: name, mobile: mobile, code: code}));
        jDelModel.modal({backdrop:'static', toggle:true});
        return false;
    };

    $(function() {
        _initialize();
    });
})(jQuery);