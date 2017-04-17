<#assign pageTitle = "提现单列表" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign formActionList = "/account/account_receipt_withdraw_list" />
<#assign formActionGenerator="/account/account_receipt_withdraw_generator" />
<#assign formActionDownload="/account/account_receipt_withdraw_download" />

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
                <form id="form_query_list" clas="form-search" name="formQueryList" action="${formActionGenerator}" method="post">
                	起始金额<input type="text" class="input-small search-query" name="ammount" value="0.01"/>
                	未提现总金额<input type="text" class="input-small search-query" readonly value="${totalBalance}"/>
					备注<input type="text" class="input-large search-query" name="comm" />
					<button type="submit" class="btn btn-primary">生成批量提现单</button>
				</form>
            </div>
            
            <div class="box-content">
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                    	<th class="span1">序号</th>
                        <th class="span2">备注</th>
                        <th class="span2">下载次数</th>
                        <th class="span2">总金额</th>
                        <th class="span2">创建者</th>
                        <th class="span3">创建时间</th>
                        <th >操作</th>
                    </tr>
                    </thead>
                    <tbody>
	                    <#if (page?? && page.content??)>
		                    <#list page.content as entity>
		                    <tr id="tr_entity_${entity.id}">
		                        <td>${(page.number)*(page.size)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
		                        <td>${entity.comm}</td>
		                        <td>${entity.downloadTime}</td>
		                        <td>${entity.amount}</td>
		                        <td>${entity.created}</td>
		                        <td>${entity.createdTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		                        <td>
		                            <a href="${formActionDownload}?uid=${entity.id}"><i class="icon-download"></i> 下载</a>
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

<#assign pageFootScripts>
<script type="text/javascript">
(function($) {
	$(function() {
        $('#form_query_list').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "${formActionList}";
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