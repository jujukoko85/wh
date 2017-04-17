(function($) {
    var User = window.User = {},
        jDelModel, jDelModalBody, jDelUid, jDel,
        jResetPwdModel, jResetPwdModalBody, jResetPwdUid, jResetPwd,
        currUid, jAlertErr, jAlertErrC, jAlertSuc, jForm, jFormResetPwd, _timer,

        _initialize = function() {
            jDelModel = $('#modal_del_user');
            jDelModalBody = $('div.modal-body', jDelModel);
            jDelUid = $('#txt_deleted_user_id');
            jDel = $('#btn_del_user');
            
            jResetPwdModel = $('#modal_reset_pwd');
            jResetPwdModalBody = $('div.modal-body', jResetPwdModel);
            jResetPwdUid = $('#txt_reset_pwd_id');
            jResetPwd = $('#btn_reset_pwd');
            
            jResetPwdSuccessModel = $('#modal_reset_pwd_success');
            jResetPwdSuccessModalBody = $('div.modal-body', jResetPwdSuccessModel);
            
            jAlertErr = $('#alert_error');
            jAlertSuc = $('#alert_success');
            jAlertErrC = $('p', jAlertErr);
            jForm = $('#form_del_user');
            jFormResetPwd = $('#form_reset_pwd');
            
            _initEvents();
        },

        _delContent = function(user) {
            return ['<p>您确认要删除 <strong>', user.loginName, '</strong>（', user.empName, '） 这个用户吗？</p>'].join('');
        },
        
        _resetPwdContent = function(user) {
            return ['<p>您确认要重置 <strong>', user.loginName, '</strong>（', user.empName, '） 这个用户的密码吗？</p>'].join('');
        },

        _delUserOptions = {
            dataType: 'json',
            success: function(data) {
                var isSuccess = data.status === 1;
                if (isSuccess) { // 删除成功！
                    jAlertSuc.show();
                    $('#tr_user_' + currUid).remove();
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
        
        _resetPwdOptions = {
                dataType: 'json',
                success: function(data) {
                    var isSuccess = data.status === 1;
                    if (isSuccess) { // 删除成功！
                    	jResetPwdSuccessModalBody.html("<p>密码修改成功！新密码为<font size='10' color='red'>" + data.message + "</font></p>");
                    	jResetPwdSuccessModel.modal({backdrop:'static', toggle:true});
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
                jForm.ajaxSubmit(_delUserOptions);
                return false;
            });
            jFormResetPwd.submit(function() {
            	jFormResetPwd.ajaxSubmit(_resetPwdOptions);
                return false;
            });
            
            jDel.click(function() {
                jForm.submit();
                jDelModel.modal('hide');
                return false;
            });
            
            jResetPwd.click(function() {
            	jFormResetPwd.submit();
            	jResetPwdModel.modal('hide');
                return false;
            });
            
            jAlertErr.on('close', _clearTimer);
            jAlertSuc.on('close', _clearTimer);
        };

    User.showDelUserModal = function(btn) {
        var jBtn = $(btn), uid = jBtn.data('userId'), loginName = jBtn.data('loginName'),
            empName = jBtn.data('empName');
        jDelUid.val(uid);
        currUid = uid;
        jDelModalBody.html(_delContent({ loginName: loginName, empName: empName }));
        jDelModel.modal({backdrop:'static', toggle:true});
        return false;
    };
    
    User.showResetPwdModal = function(btn) {
        var jBtn = $(btn), uid = jBtn.data('userId'), loginName = jBtn.data('loginName'),
            empName = jBtn.data('empName');
        
        jResetPwdUid.val(uid);
        currUid = uid;
        jResetPwdModalBody.html(_resetPwdContent({ loginName: loginName, empName: empName }));
        jResetPwdModel.modal({backdrop:'static', toggle:true});
        
        return false;
    };

    $(function() {
        _initialize();
    });
})(jQuery);