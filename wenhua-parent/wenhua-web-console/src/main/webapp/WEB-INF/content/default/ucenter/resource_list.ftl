<#assign pageTitle = "资源列表" />
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
                <h2><i class="icon-user"></i> ${pageTitle}</h2>&nbsp;&nbsp;&nbsp;&nbsp;
                <button align="right" type="button" id="btn_add" onclick="location.href='/ucenter/resource_add'" class="btn btn-primary">新 增</button>&nbsp;&nbsp;
            </div>
            <div class="box-content">
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                    	<th>序号</th>
                        <th>名称</th>
                        <th>代码</th>
                        <th>类型</th>
                        <th>URL</th>
                        <th>创建者</th>
                        <th>创建时间</th>
                         <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if (page?? && page.content??)>
                        <#list page.content as resource>
                        <tr id="tr_resource_${resource.id}">
                            <td>${(page.number)*(page.size)+(resource_index+1)}<input type="hidden" id="txt_resource_id_${resource_index}" name="resourceId" value="${resource.id}" /></td>
                            <td>${resource.resourceName}</td>
							<td>${resource.resourceCode}</td>
							<td>${resource.hyResourceType}</td>
							<td>${resource.resourceUrl}</td>
							<td>${resource.created}</td>
							<td>${resource.createdTime!?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>
                                <a href="/ucenter/resource_edit?uid=${resource.id}"><i class="icon-pencil"></i> 编辑</a>
                                <a href="javascript:void(0)" data-resource-id="${resource.id}" data-resource-name="${resource.resourceName}" 
                                onclick="return Resource.showDelResourceModal(this);"><i class="icon-trash"></i> 删除</a>
                            </td>
                        </tr>
                        </#list>
                        <#if page.content?size < 12>
                            <#list 1..(12 - page.content?size) as idx>
                            <tr>
                                <td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
                            </tr>
                            </#list>
                        </#if><#-- // end if page.content?size -->
                    </#if>
                    </tbody>
                </table>
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="/ucenter/resource_list?currentPage={p}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<div id="modal_del_resource" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_del_resource" aria-hidden="true">
    <form id="form_del_resource" name="formDelName" action="/ucenter/resource_del" method="post">
    <input type="hidden" id="txt_deleted_resource_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_del_resource">删除资源确认信息</h3>
    </div>
    <div class="modal-body" id="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="btn_del_resource" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<#assign pageFootScripts>
<script type="text/javascript" src="${appConfig.scriptsUrl}/module/resource_list.js"></script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />