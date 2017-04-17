<#assign pageTitle = "编辑角色" />
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
    <#if editRole??>
        <#assign formAction = "/ucenter/role_update" />
        <#assign inputId>
        <input id="txt_role_id" name="id" type="hidden" value="${editRole.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/ucenter/role_save" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_role" name="formEditRole" action="${formAction}" method="post">
            	${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_role_ame">角色名：</label>
                    <div class="controls">
                        <input type="text" id="txt_role_name" name="roleName" placeholder="角色名" value="<#if editRole??>${editRole.roleName}</#if>">
                        <span class="help-inline hide" id="help_rolename">请输入角色名！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_emp_name">角色代码：</label>
                    <div class="controls">
                        <input type="text" id="txt_role_code" name="roleCode" placeholder="角色代码" value="<#if editRole??>${editRole.roleCode}</#if>">
                        <span class="help-inline hide" id="help_role_code">请输入角色代码！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">状态：</label>
                    <div class="controls">
                        <label class="radio inline" style="width: 50px;margin-left: 18px;">
                            <input type="radio" name="hyRoleStatus"<#if editRole??><#if editRole.hyRoleStatus == 1> checked="checked"</#if><#else> checked="checked"</#if> value="1"> 启用
                        </label>
                        <label class="radio inline">
                        	<input type="radio" name="hyRoleStatus"<#if editRole??><#if editRole.hyRoleStatus == 0> checked="checked"</#if><#else></#if> value="0"> 禁用
                        </label>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" id="btn_edit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
                        <button type="reset" id="btn_reset" class="btn btn-info">重 置</button>
                    </div>
                </div>
            </form>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />