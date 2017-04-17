<#assign pageTitle = "分销分配" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign formActionAssign = "/distributor/distributor_assign" />
<#assign formActionAssignUpdate = "/distributor/distributor_assign_update" />
<#assign formActionDetail="/distributor/distributor_detail" />

<#assign uid>
<input type="hidden" name="uid" value="${entity.id}" />
</#assign>

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
        <div class="box span9">
        	<div class="box-header well input-append">
                姓名:<input type="text" class="span2" readonly value="${entity.name}" />
             	手机:<input type="text" class="span2" readonly value="${entity.mobile}" />
             	代码:<input type="text" class="span2" readonly value="${entity.code}" />
             	客户数:<input type="text" class="span1" readonly value="${vipCount}" />
            </div>
            <div class="box-header well input-append">
                <form id="form_query_list" clas="form-search" name="formQueryList" action="${formActionAssign}" method="get">
					姓名<input type="text" class="input-small search-query" name="name" />
					手机<input type="text" class="input-small search-query" name="mobile" />
					代码<input type="text" class="input-small search-query" name="code" />
					&nbsp;已分配&nbsp;<input type="radio" name="assigned" value="true" <#if assigned??> <#if assigned> checked </#if> <#else> checked </#if> />
					&nbsp;未分配&nbsp;<input type="radio" name="assigned" value="false" <#if assigned?? && !assigned > checked </#if> />
					${uid}
					&nbsp;&nbsp;<button type="submit" class="btn btn-primary">查询</button>
				</form>
            </div>
            
            <div class="box-content">
            
            	<form id="form_assign" clas="form-search" name="formAssign" action="${formActionAssignUpdate}" method="post">
            		${uid}
	                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
	                    <thead>
	                    <tr>
	                    	<th class="span1">序号</th>
	                    	<th class="span1">全选</th>
	                        <th class="span1">姓名</th>
	                        <th class="span2">手机号</th>
	                        <th class="span1">代码</th>
	                        <th class="span3 center">合同到期日</th>
	                    </tr>
	                    </thead>
	                    <tbody>
		                    <#if (page?? && page.content??)>
			                    <#list page.content as entity>
			                    <tr id="tr_entity_${entity.id}">
			                        <td>${(page.number)*(page.size)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
			                        <td><input type="checkbox" name="assignIds" value="${entity.id}" /></td>
			                        <td>${entity.name}</td>
			                        <td>${entity.mobile}</td>
			                        <td>${entity.code!}</td>
			                        <td>${entity.expiredTime?string("yyyy-MM-dd HH:mm:ss")!""}</td>
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
			                        </tr>
			                        </#list>
								</#if>
		                    </#if><#-- // end if page.content?size -->
	                    </tbody>
	                </table>
                    <div class="controls">
                        <button type="submit" id="btn_edit" class="btn btn-primary">分 配</button>&nbsp;&nbsp;
                        <button type="reset" id="btn_reset" class="btn btn-info">重 置</button>
                    </div>
	            </form>
	                
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="${formActionAssign}?currentPage={p}&uid=${entity.id}&assigned=${assigned}" />
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
        $('#form_assign').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "${formActionDetail}?uid=${entity.id}";
                    return;
                } else {
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