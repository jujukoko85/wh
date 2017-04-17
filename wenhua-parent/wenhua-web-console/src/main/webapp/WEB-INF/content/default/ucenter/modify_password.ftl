<#assign pageTitle = "修改密码" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<div id="content" class="span10">
    <!-- content starts -->
    <div>
        <ul class="breadcrumb">
            <li>
                <a href="/index">首页</a> <span class="divider">/</span>
            </li>
            <li>${pageTitle}</li>
        </ul>
    </div>

    <div class="row-fluid">
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
                <div class="alert"></div>
            <form class="form-horizontal" id="form_modify_password" name="formModifyPassword" method="post" action="/ucenter/a/modify_password">
                <div class="control-group">
                    <label class="control-label" for="txt_current_password">旧的密码：</label>
                    <div class="controls">
                        <input type="password" id="txt_current_password" name="currentPassword" placeholder="旧的密码">
                        <span class="help-inline hide" id="help_current_password">请输入旧的密码！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_new_password1">新的密码：</label>
                    <div class="controls">
                        <input type="password" id="txt_new_password1" name="newPassword1" placeholder="新的密码">
                        <span class="help-inline hide" id="help_new_password1">请输入新的密码！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_new_password2">确认密码：</label>
                    <div class="controls">
                        <input type="password" id="txt_new_password2" name="newPassword2" placeholder="确认密码">
                        <span class="help-inline hide" id="help_new_password2">请确认新的密码！</span>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" id="btn_modify" class="btn btn-primary">确认修改</button>
                        <button type="button" id="btn_cancel" class="btn">取 消</button>
                    </div>
                </div>
            </form>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>


<#assign pageFootScripts>
<script type="text/javascript">
(function($) {

	$(function() {
        $('#form_modify_password').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "/";
                    return;
                } else {
                    //jAlert.addClass('alert-error').removeClass('alert-info').text(data.message).show();
                    alert(data.message);
                    return;
                }
            }
        });
	});

})(jQuery);
</script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />