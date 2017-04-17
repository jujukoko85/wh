<#-- @ftlvariable name="editUser" type="com.tonglukuaijian.survey.interfaces.user.UserDto" -->
<#-- @ftlvariable name="roles" type="java.util.List<com.tonglukuaijian.survey.interfaces.user.RoleDto>" -->
<#assign pageTitle = "编辑后台用户" />
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
    <#if editUser??>
        <#assign formAction = "/ucenter/a/modify_user" />
        <#assign inputId>
        <input id="txt_user_id" name="id" type="hidden" value="${editUser.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/ucenter/a/add_user" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_user" name="formEditUser" action="${formAction}" method="post">
                ${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_username">用户名：</label>
                    <#if watchUser??>
                		<input type="text" readonly value="${watchUser.loginName}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_username" name="loginName" placeholder="用户名" value="<#if editUser??>${editUser.loginName}</#if>">
	                        <span class="help-inline hide" id="help_username">请输入用户名！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_code">工号：</label>
                    <#if watchUser??>
                		<input type="text" readonly value="${watchUser.code}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_code" name="code" placeholder="工号" value="<#if editUser??>${editUser.code}</#if>">
	                        <span class="help-inline hide" id="help_username">请输入工号！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_emp_name">员工名称：</label>
                    <#if watchUser??>
                		<input type="text" readonly value="${watchUser.empName}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_emp_name" name="empName" placeholder="员工名称" value="<#if editUser??>${editUser.empName}</#if>">
	                        <span class="help-inline hide" id="help_emp_name">请输入员工名称！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_dep_name">所属部门：</label>
                    <#if watchUser??>
                		<input type="text" readonly value="<#if watchUser.department??>${watchUser.department.deptName}</#if>">
                	<#else>
	                    <div class="controls">
	                        <select name="departmentId">
                		<option value="">请选择部门</option>
						<#list departments as department>
							<option value="${department.id}" <#if editUser?? && editUser.departmentId==department.id> selected="true" </#if>> ${department.deptName}</option>
						</#list>
					</select>
	                    </div>
	                </#if>
                </div>
                <#if watchUser??>
                	<!-- 无内容 -->
                <#else>
	                <div class="control-group">
	                    <label class="control-label">用户角色：</label>
	                    <div class="controls">
	                        <#list roles as role>
								<label class="checkbox inline">
									<input type="checkbox" value="${role.id}" name="roleIds" <#if editUser?? && editUser.roles[role.roleCode]??> checked </#if> > ${role.roleName} </input>
								</label>
								<#if role_index == 3>
									<br />
								</#if>
	                        </#list>
	                    </div>
	                </div>
	                <div class="control-group">
	                    <label class="control-label">状态：</label>
	                    <div class="controls">
	                        <label class="radio inline" style="width: 50px;margin-left: 18px;">
	                            <input type="radio" name="hyUserStatus"<#if editUser?? && editUser.hyUserStatus == 1> checked="checked" <#else> checked="checked" </#if> value="1"> 启用
	                        </label>
	                        <label class="radio inline">
	                        	<input type="radio" name="hyUserStatus"<#if editUser?? && editUser.hyUserStatus == 0> checked="checked"</#if> value="0"> 禁用
	                        </label>
	                    </div>
	                </div>
	                <div class="control-group">
	                    <div class="controls">
	                        <button type="submit" id="btn_edit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
	                        <button type="reset" id="btn_reset" class="btn btn-info">重 置</button>
	                    </div>
	                </div>
	        	</#if>
            </form>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<#assign pageFootScripts>

<script type="text/javascript">

(function($) {
	$(function() {
        $('#form_edit_user').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "/ucenter/user_list";
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