<#assign pageTitle = "账户列表" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign formActionList = "/account/account_list" />
<#assign formActionAccountDetail="/account/account_detail_list" />

<div id="content" class="span12">
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
            <div class="box-header well input-append">
             <!-- 查询表单 -->
                <form id="form_query_list" clas="form-search" name="formQueryList" action="${formActionList}" method="get">
					姓名<input type="text" class="input-small search-query" name="accountName" value="${accountName}" />
					总余额<input type="text" readonly value="${totalBalance}" />
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
            </div>
            
            <div class="box-content">
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                    	<th class="span1">序号</th>
                        <th class="span2">户名</th>
                        <th class="span2">余额</th>
                        <th >操作</th>
                    </tr>
                    </thead>
                    <tbody>
	                    <#if (page?? && page.content??)>
		                    <#list page.content as entity>
		                    <tr id="tr_entity_${entity.id}">
		                        <td>${(page.number)*(page.size)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
		                        <td>${entity.accountName}</td>
		                        <td>${entity.balance}</td>
		                        <td>
		                            <a href="${formActionAccountDetail}?currentPage=1&accountId=${entity.id}"><i class="icon-list"></i> 详情</a>
		                        </td>
		                    </tr>
		                    </#list>
		                    <#if page.content?size < 12>
		                        <#list 1..(12 - page.content?size) as idx>
		                        <tr>
		                            <td>&nbsp;</td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                        </tr>
		                        </#list>
							</#if>
	                    </#if><#-- // end if page.content?size -->
                    </tbody>
                </table>
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="${formActionList}?currentPage={p}&accountName=${accountName}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />