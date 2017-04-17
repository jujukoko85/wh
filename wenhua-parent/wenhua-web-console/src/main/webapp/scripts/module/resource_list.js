(function($) {
    var Resource = window.Resource = {},
        jDelModal, 
        jDelModalBody, 
        jDelUid, 
        jDel, 
        currUid, jAlertErr, jAlertErrC, jAlertSuc, _timer,
        jDelForm,
       
        _initialize = function() {
    		
            jDelModal = $('#modal_del_resource');
            
            jDelModalBody = $('#modal-body', jDelModal);
            
            jDelUid = $('#txt_deleted_resource_id');
            
            jDel = $('#btn_del_resource');
            
            jAlertErr = $('#alert_error');
            jAlertSuc = $('#alert_success');
            jAlertErrC = $('p', jAlertErr);
            
            jDelForm = $('#form_del_resource');
            
            _initEvents();
        },

        _delContent = function(resourceName) {
            return ['<p>您确认要<font size="36" color="red">删除</font><br /> <font size="5" color="blue">', resourceName, '</font><br /> 这个资源吗？</p>'].join('');
        },
        
        _delResourceOptions = {
            dataType: 'json',
            success: function(data) {
                var isSuccess = data.status === 1;
                if (isSuccess) { // 删除成功！
                    jAlertSuc.show();
                    $('#tr_resource_' + currUid).remove();
                    $('table.table tbody').append('<tr><td>&nbsp;</td><td></td><td></td></tr>');
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
            jDelForm.submit(function() {
                jDelForm.ajaxSubmit(_delResourceOptions);
                return false;
            });
            jDel.click(function() {
                jDelForm.submit();
                jDelModal.modal('hide');
                return false;
            });
            
            jAlertErr.on('close', _clearTimer);
            jAlertSuc.on('close', _clearTimer);
        };

    Resource.showDelResourceModal = function(btn) {
        var jBtn = $(btn), uid = jBtn.data('resourceId'), resourceName = jBtn.data('resourceName');
        jDelUid.val(uid);
        currUid = uid;

        jDelModalBody.html(_delContent(resourceName));
        jDelModal.modal({backdrop:'static', toggle:true});
        return false;
    };
    
    $(function() {
        _initialize();
    });
})(jQuery);