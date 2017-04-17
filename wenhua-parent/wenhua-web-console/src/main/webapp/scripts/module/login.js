/*
 * Copyright (c) 2009-2013 上海泽杉电子商务发展有限公司 All rights reserved.
 * @(#) login.js 2013-04-20 19:05
 */

(function($) {

var jAlert, jqSubmit, jqUsername, jqPassword;

function _txtFocus() {
    _alertHandler();
}

function _alertHandler(text, error) {
    if (!jAlert.data('source')) {
        jAlert.data('source', jAlert.html());
    }

    if (error) {
        jAlert.removeClass('alert-info').addClass('alert-error').text(text);
    } else {
        jAlert.text(text ? text : jAlert.data('source')).removeClass('alert-error')
            .addClass('alert-info');
    }
}

function _initInternal() {
    jqUsername = $('#txt_username');
    jqPassword = $('#txt_password');
    jqSubmit = $('#btn_login');
    jAlert = $('div.alert');

    jqUsername.focus(_txtFocus);
    jqPassword.focus(_txtFocus);
    jqSubmit.click(function() {
        var username = $.trim(jqUsername.val()),
            password = $.trim(jqPassword.val());

        if (!username.length) {
            _alertHandler('请输入用户名！', 1);
            return false;
        }
        if (!password.length) {
            _alertHandler('请输入登录密码！', 1);
            return false;
        }
        return true;
    });
}

$(function() {
    _initInternal();
    jqUsername.focus();
});

})(jQuery);