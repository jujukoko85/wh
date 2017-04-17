(function($) {
    var Department = window.Department = {},
        jDelModel, jDelModalBody, jDelUid, jDel,
        currDelUid, jAlertErr, jAlertErrC, jAlertSuc, jForm, _timer,

        _initialize = function() {
            jDelModel = $('#modal_del_department');
            jDelModalBody = $('div.modal-body', jDelModel);
            jDelUid = $('#txt_deleted_department_id');
            jDel = $('#btn_del_department');
            jAlertErr = $('#alert_error');
            jAlertSuc = $('#alert_success');
            jAlertErrC = $('p', jAlertErr);
            jForm = $('#form_del_department');

            _initEvents();
        },

        _delContent = function(department) {
            return ['<p>您确认要删除 <strong>', department.deptName, '</strong> 这个部门吗？</p>'].join('');
        },

        _delDepartmentOptions = {
            dataType: 'json',
            success: function(data) {
                var isSuccess = data.status === 1;
                if (isSuccess) { // 删除成功！
                    jAlertSuc.show();
                    $('#tr_department_' + currDelUid).remove();
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
                jForm.ajaxSubmit(_delDepartmentOptions);
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

    Department.showDelDepartmentModal = function(btn) {
        var jBtn = $(btn), uid = jBtn.data('departmentId'),
            deptName = jBtn.data('departmentName');
        
        jDelUid.val(uid);
        currDelUid = uid;
        jDelModalBody.html(_delContent({ deptName: deptName}));
        jDelModel.modal({backdrop:'static', toggle:true});
        return false;
    };

    $(function() {
        _initialize();
    });
})(jQuery);