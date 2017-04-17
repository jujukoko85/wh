<#assign pageTitle = "待开发客户列表" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign formActionList = "/customer_ready/customer_ready_list" />
<#assign formActionAdd = "/customer_ready/customer_ready_add" />
<#assign formActionEdit = "/customer_ready/customer_ready_edit" />
<#assign formActionReady = "/customer_ready/customer_ready_ready" />
<#assign locationCityAction = "/location/city" />
<#assign locationAreaAction = "/location/area" />

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
					名称<input type="text" class="input-small search-query" name="name" value="${queryName}" />
					手机<input type="text" class="input-small search-query" name="mobile" value="${mobile}" />
					座机<input type="text" class="input-small search-query" name="phone" value="${phone}"/>
					省
					<select type="text" class="input-small" id="txt_customer_ready_province" name="province">
                    	<option value="-1">请选择省份</option>
                    	<#if (provinces??)>
                    		<#list provinces as province>
                    			<option value="${province.provinceId}">${province.province}</option>
                    		</#list>
						</#if>
                    </select>
					市
                    <select type="text" class="input-small" id="txt_customer_ready_city" name="city">
                    	<option value="-1">请选择城市</option>
               		</select>
					区
					<select type="text" class="input-small" id="txt_customer_ready_area" name="area">
                    	<option value="-1">请选择区县</option>
                	</select>
					详细地址<input type="text" class="input-normal search-query" name="detail" value="${detail}"/>
					业务员
					<select type="text" class="input-small" id="txt_customer_ready_user" name="user">
                    	<option value="-1">请选择业务员</option>
                    	<#if (users??)>
                    		<#list users as user>
                    			<option value="${user.loginName}">${user.empName}</option>
                    		</#list>
						</#if>
                	</select>
					<button type="submit" class="btn btn-primary">查询</button>
					<button align="right" type="button" id="btn_add" onclick="location.href='${formActionAdd}'" class="btn btn-primary">新 增</button>
				</form>
            </div>
            
            <div class="box-content">
            	<!-- 删除成功提示框 -->
                <div id="alert_success" class="alert alert-block alert-success fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">删除成功！</h4>
                    <p></p>
                </div>
                <!-- 删除失败提示框 -->
                <div id="alert_error" class="alert alert-block alert-error fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">删除失败！</h4>
                    <!-- 删除失败提示框 内容部分 -->
                    <p></p>
                </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                    	<th class="span1">序号</th>
                    	<th class="span2">客户名称</th>
                        <th class="span2">手机号</th>
                        <th class="span2">座机号</th>
                        <th class="span4">详细地址</th>
                        <th class="span2">备注</th>
                        <th class="span2">开发</th>
                        <th class="span2">业务员</th>
                        <th class="span2">修改时间</th>
                        <th >操作</th>
                    </tr>
                    </thead>
                    <tbody>
	                    <#if (page?? && page.content??)>
		                    <#list page.content as entity>
		                    <tr id="tr_entity_${entity.id}">
		                        <td>${(page.number)*(page.size)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
		                        <td>${entity.name}</td>
		                        <td>${entity.mobile!'无'}</td>
		                        <td>${entity.phone!'无'}</td>
		                        <td>${entity.provinceName}-${entity.cityName}-${entity.areaName}-${entity.detail}</td>
		                        <td>${entity.comm}</td>
		                        <td><#if entity.isReady>已开发<#else>未开发</#if></td>
		                        <td>${entity.userEmpName!'未指派'}</td>
		                        <td>${entity.lastModifiedTime?string("yyyy年MM月dd日")}</td>
		                        <td>
		                        	<a href="${formActionEdit}?uid=${entity.id}"><i class="icon-pencil"></i> 编辑</a>
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
                    <@global.pageable pageData=page urlPattern="${formActionList}?currentPage={p}&province=${provinceId}&city=${cityId}&area=${areaId}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<!-- 提醒框 -->
<div id="modal_alert" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_alert" aria-hidden="true">
    <div class="modal-header">
        <h3 id="lbl_alert">提示信息</h3>
    </div>
    <div class="modal-body" id="modal_alert_body">
        <p></p>
    </div>
    <div class="modal-footer">
       <a href="javascript:void(0)" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
</div>

<#assign pageFootScripts>
<script type="text/javascript">

(function($) {

	$('#txt_customer_ready_city').change(function() {
		var cityId = $('#txt_customer_ready_city').val();
		
		clearArea();
		
		$.get(
			'${locationAreaAction}',
			{cityId:cityId}, 
	      	function (data){
	      		$('#txt_customer_ready_area').empty();
	      		$('#txt_customer_ready_area').append("<option value='-1'>请选择区县</option>");
	      		$.each(data.values,function(key,value){
	      			$('#txt_customer_ready_area').append("<option value='" + key + "'>" + value + "</option>");
				});
	      	}   
	      ); 
	});

	$('#txt_customer_ready_province').change(function() {
		var provinceId = $('#txt_customer_ready_province').val();
		
		clearArea();
		clearCity();
		
		$.get(
			'${locationCityAction}',
			{provinceId:provinceId}, 
	      	function (data){
	      		$('#txt_customer_ready_city').empty();
	      		$('#txt_customer_ready_city').append("<option value='-1'>请选择城市</option>");
	      		$.each(data.values,function(key,value){
	      			$('#txt_customer_ready_city').append("<option value='" + key + "'>" + value + "</option>");
				});
	      	}   
	      ); 
	});
	
	showAlert = function(message) {
		var jModal = $('#modal_alert'); 
		var jModelBody = $('#modal_alert_body', jModal);
		jModelBody.html(message);
		jModal.modal({backdrop:'static', toggle:true});
    };
	
	$('#txt_customer_ready_city').change(function() {
		var cityId = $('#txt_customer_ready_city').val();
		
		clearArea();
		
		$.get(
			'${locationAreaAction}',
			{cityId:cityId}, 
	      	function (data){
	      		$('#txt_customer_ready_area').empty();
	      		$('#txt_customer_ready_area').append("<option value='-1'>请选择区县</option>");
	      		$.each(data.values,function(key,value){
	      			$('#txt_customer_ready_area').append("<option value='" + key + "'>" + value + "</option>");
				});
	      	}   
	      ); 
	});
	
	clearArea = function() {
    	$('#txt_customer_ready_area').empty();
  		$('#txt_customer_ready_area').append("<option value='-1'>请选择区县</option>");
    };
    
    clearCity = function() {
		$('#txt_customer_ready_city').empty();
  		$('#txt_customer_ready_city').append("<option value='-1'>请选择城市</option>");
	};

})(jQuery);
</script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />