<#assign pageTitle = "编辑资源" />
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
    <#if editResource??>
        <#assign formAction = "/ucenter/resource_update" />
        <#assign inputId>
        <input id="txt_resource_id" name="id" type="hidden" value="${editResource.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/ucenter/resource_save" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_resource" name="formEditResource" action="${formAction}" method="post">
            	${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_resource_ame">资源名：</label>
                    <div class="controls">
                        <input type="text" id="txt_resource_name" name="resourceName" placeholder="资源名" value="<#if editResource??>${editResource.resourceName}</#if>">
                        <span class="help-inline hide" id="help_resourcename">请输入资源名！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_emp_name">资源代码：</label>
                    <div class="controls">
                        <input type="text" id="txt_resource_code" name="resourceCode" placeholder="资源代码" value="<#if editResource??>${editResource.resourceCode}</#if>">
                        <span class="help-inline hide" id="help_resource_code">请输入资源代码！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_resource_url">资源URL：</label>
                    <div class="controls">
                        <input type="text" id="txt_resource_url" name="resourceUrl" placeholder="资源URL" value="<#if editResource??>${editResource.resourceUrl}</#if>">
                        <span class="help-inline hide" id="help_resource_url">请输入资源URL！</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_parent">资源类型：</label>
                    <div class="controls">
                        <select name="resourceTypeCode">
							<option value="">请选择资源类型</option>
							<#list hyResourceTypes?keys as hyResourceTypeKey>
								<option value="${hyResourceTypeKey}" <#if editResource?? && editResource.hyResourceType == hyResourceTypes[hyResourceTypeKey]> selected='selected'</#if> >${hyResourceTypes[hyResourceTypeKey]}</option>
							</#list>
						</select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_parent">父资源：</label>
                    <div class="controls">
                        <select name="parentResourceId">
							<option value="">请选择父资源</option>
							<#list parentResources as parentResource>
								<option value="${parentResource.id}" <#if editResource?? && editResource.parent.id==parentResource.id> selected='selected'</#if>>${parentResource.resourceName}</option>
							</#list>
						</select>
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