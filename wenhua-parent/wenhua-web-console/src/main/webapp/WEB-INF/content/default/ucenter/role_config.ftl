<#assign pageTitle = "角色配置" />
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

	<form id="form_role_config_update" name="formRoleConfigUpdate" action="/ucenter/role_config_update" method="post">
    <div class="row-fluid">
        <div class="box span12">
            <div class="box-header well">
            	<h2><i class="icon-user"></i> ${pageTitle}</h2>&nbsp;&nbsp;&nbsp;&nbsp;
            	<button type="submit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;&nbsp;&nbsp;
            	${editRole.roleName}&nbsp;&nbsp;
            	(${editRole.roleCode})&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            <div class="box-content">
            	<div class="control-group">
                    <label class="control-label">资源列表：</label>
                    <div class="controls">
                    	<input type="hidden" name="roleId" value="${editRole.id}" />
                    	<table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
		                    <thead>
		                    <tr>
		                    	<th>序号</th>
		                    	<th>选择</th>
		                        <th>资源名称</th>
		                        <th>资源代码</th>
		                        <th>资源类型</th>
		                        <td>起草人</th>
		                        <td>起草时间</th>
		                    </tr>
		                    </thead>
		                    <tbody>
		                    	<#list resources as resource>
									<tr <#if '菜单' == resource.hyResourceType> class='success' </#if>>
										<td>${resource_index + 1}</td>
										<td><input type="checkbox" name="resourceIds" value="${resource.id}" <#if editRole.resources[resource.resourceCode]??> checked </#if> ></input></td>
										<td>${resource.resourceName}</td>
										<td>${resource.resourceCode}</td>
										<td>${resource.hyResourceType}</td>
										<td>${resource.created}</td>
										<td>${resource.createdTime}</td>
									</tr>
		                        </#list>
		                    </tbody>
		                </table>
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
    <button type="submit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;&nbsp;&nbsp;
    </form>
</div>

<link rel="stylesheet" href="${appConfig.stylesUrl}/ztree/zTreeStyle.css" />
<script src="${appConfig.scriptsUrl}/libs/jquery-1.9.1.min.js"></script>
<script src="${appConfig.scriptsUrl}/ztree/jquery.ztree.core-3.5.min.js"></script>
<script src="${appConfig.scriptsUrl}/ztree/jquery.ztree.excheck-3.5.min.js"></script>

<#assign pageFootScripts>
<script type="text/javascript">
(function($) {

	$(function() {
        $('#form_role_config_update').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "/ucenter/role_list";
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