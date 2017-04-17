<#assign pageTitle = "分销详情" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

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
             	姓名:<input type="text" readonly value="${entity.name}" />
             	手机:<input type="text" readonly value="${entity.mobile}" />
             	代码:<input type="text" readonly value="${entity.code}" />
            </div>
            
            <div class="box-content">
            	<div class="span4">
	                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
	                	<caption class="btn-primary">直接下级</caption>
	                    <thead>
	                    <tr>
	                    	<th class="span1">序号</th>
	                        <th class="span1">姓名</th>
	                        <th class="span1">手机号</th>
	                        <th class="span1">代码</th>
	                    </tr>
	                    </thead>
	                    <tbody>
		                    <#if (sons??)>
			                    <#list sons as entity>
			                    <tr id="tr_entity_${entity.id}">
			                        <td>${entity_index+1}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
			                        <td>${entity.name}</td>
			                        <td>${entity.mobile}</td>
			                        <td>${entity.code}</td>
			                    </tr>
			                    </#list>
		                    </#if><#-- // end if page.content?size -->
	                    </tbody>
	                </table>
	        	</div>
	        		
	        	<div class="span4">
	        		<table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
	                	<caption class="btn-primary">间接下级</caption>
	                    <thead>
	                    <tr>
	                    	<th class="span1">序号</th>
	                        <th class="span1">姓名</th>
	                        <th class="span1">手机号</th>
	                        <th class="span1">代码</th>
	                    </tr>
	                    </thead>
	                    <tbody>
		                    <#if (grandsons??)>
			                    <#list grandsons as entity>
			                    <tr id="tr_entity_${entity.id}">
			                        <td>${entity_index+1}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
			                        <td>${entity.name}</td>
			                        <td>${entity.mobile}</td>
			                        <td>${entity.code}</td>
			                    </tr>
			                    </#list>
		                    </#if><#-- // end if page.content?size -->
	                    </tbody>
	                </table>
	        	</div>
	        	
	        	<div class="span2">
	        		<table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
	                	<caption class="btn-primary">直接客户</caption>
	                    <thead>
	                    <tr>
	                    	<th class="span1">序号</th>
	                        <th class="span1">姓名</th>
	                    </tr>
	                    </thead>
	                    <tbody>
		                    <#if (vips??)>
			                    <#list vips as entity>
			                    <tr id="tr_entity_${entity.id}">
			                        <td>${entity_index+1}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
			                        <td>${entity.name}</td>
			                    </tr>
			                    </#list>
		                    </#if><#-- // end if page.content?size -->
	                    </tbody>
	                </table>
	        	</div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />