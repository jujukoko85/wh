<#-- @ftlvariable name="SPRING_SECURITY_LAST_EXCEPTION" type="java.lang.Exception" -->
<#assign pageTitle = "管理员登录" />
<#assign pageCss>
<style type="text/css">
body {
    padding-bottom: 40px;
}
.tooltip {
    font-size: 12px;
}
</style>
</#assign>
<#include "/common/page_header.ftl" />
<#if (SPRING_SECURITY_LAST_EXCEPTION?? && SPRING_SECURITY_LAST_EXCEPTION.message??)>
<#assign loginInfo = {"alertClass": "alert-error", "message": "${SPRING_SECURITY_LAST_EXCEPTION.message}"} />
<#else>
<#assign loginInfo = {"alertClass": "alert-info", "message": ""} />
</#if>
<#assign defMessage = "请输入您的用户名和密码进行登录！" />
<div class="container-fluid">

<div class="row-fluid">
    <div class="row-fluid">
        <div class="span12 center login-header">
            <h1>泽杉分销系统</h1>
            <h2>上海泽杉电子商务有限公司</h2>
        </div><!--/span-->
    </div><!--/row-->

    <div class="row-fluid">
        <div class="well span5 center login-box">
            <div class="alert ${loginInfo.alertClass}" data-source="${defMessage}">
                <#if loginInfo.message?has_content>
                    <#if loginInfo.message == "Bad credentials">
                    帐号或密码错误！
                    <#else>
                    ${loginInfo.message}
                    </#if>
                <#else>
                ${defMessage}
                </#if>
            </div>
            <form id="form_login" name="formLogin" action="/do_login" method="post" class="form-horizontal">
                <fieldset>
                    <div class="input-prepend" title="输入用户名" data-rel="tooltip">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input autofocus class="input-large span10" name="username" id="txt_username" type="text" placeholder="用户名"/>
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend" title="输入登录密码" data-rel="tooltip">
                        <span class="add-on"><i class="icon-lock"></i></span>
                        <input class="input-large span10" name="password" id="txt_password" type="password" placeholder="登录密码" />
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend">
                        <label class="remember" for="chk_remember">
                        <input type="checkbox" id="chk_remember" style="margin-top: 0px; margin-right: 20px; margin-left: -40px;"/>记住我</label>
                    </div>
                    <div class="clearfix"></div>

                    <p class="center span5">
                        <button type="submit" id="btn_login" class="btn btn-primary">登 录</button>
                    </p>
                </fieldset>
            </form>
        </div><!--/span-->
    </div>

</div><!--/fluid-row-->

</div><!--/.fluid-container-->

<#assign pageFootScripts>
<script  type="text/javascript" src="${appConfig.scriptsUrl}/module/login.js"></script>
</#assign>
<#include "/common/page_footer.ftl" />