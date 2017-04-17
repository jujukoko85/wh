<#assign pageTitle = "编辑部门" />
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
    <#if editDepartment??>
        <#assign formAction = "/department/department_update" />
        <#assign inputId>
        <input id="txt_department_id" name="id" type="hidden" value="${editDepartment.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/department/department_save" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-department"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_department" name="formEditDepartment" action="${formAction}" method="post">
                ${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_departmentname">部门名称：</label>
                    <#if watchDepartment??>
                		<input type="text" readonly value="${watchDepartment.deptName}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_department_name" name="deptName" placeholder="部门名称" value="<#if editDepartment??>${editDepartment.deptName}</#if>">
	                        <span class="help-inline hide" id="help_departmentname">请输入部门名称！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">部门主管：</label>
                    <#if watchDepartment??>
                		<input type="text" readonly value="${watchDepartment.manager}">
                	<#else>
	                    <div class="controls">
	                    	<select name="manager">
		                		<option value="">请选择部门主管</option>
								<#list users as user>
									<option value="${user.loginName}" <#if editDepartment?? && editDepartment.manager == user.loginName> selected = 'true' </#if>> ${user.empName}</option>
								</#list>
							</select>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_parent">上级部门：</label>
                    <#if watchDepartment??>
                		<input type="text" readonly value="${watchDepartment.parent.deptName}">
                	<#else>
	                    <div class="controls">
	                    	<select name="parent">
		                		<option value="">请选择上级部门</option>
								<#list departments as department>
									<option value="${department.id}" <#if editDepartment?? && editDepartment.parent?? && editDepartment.parent.id == department.id> selected = 'true' </#if>> ${department.deptName}</option>
								</#list>
							</select>
	                    </div>
	            	</#if>
                </div>
                <#if watchDepartment??>
                	<!-- 无内容 -->
                <#else>
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
        $('#form_edit_department').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "/department/department_list";
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