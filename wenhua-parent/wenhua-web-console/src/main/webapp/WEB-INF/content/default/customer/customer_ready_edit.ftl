<#assign pageTitle = "编辑待开发客户" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign locationCityAction = "/location/city" />
<#assign locationAreaAction = "/location/area" />
<#assign customerReadyList = "/customer_ready/customer_ready_list" />

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
    <#if editCustomerReady??>
        <#assign formAction = "/customer_ready/customer_ready_update" />
        <#assign inputId>
        <input id="txt_customer_ready_id" name="uid" type="hidden" value="${editCustomerReady.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/customer_ready/customer_ready_save" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_customer_ready" name="formEditDistributor" action="${formAction}" method="post">
                ${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_name">姓名：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.name}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_customer_ready_name" name="name" placeholder="客户名称" value="<#if editCustomerReady??>${editCustomerReady.name}</#if>">
	                        <span class="help-inline hide" id="help_customer_ready_name">请输入姓名！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_mobile">手机号：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.mobile}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_customer_ready_mobile" name="mobile" placeholder="手机号" value="<#if editCustomerReady??>${editCustomerReady.mobile}</#if>">
	                        <span class="help-inline hide" id="help_customer_ready_mobile">请输入手机号！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_phone">座机号：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.phone}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_customer_ready_phone" name="phone" placeholder="座机号" value="<#if editCustomerReady??>${editCustomerReady.phone}</#if>">
	                        <span class="help-inline hide" id="help_customer_ready_phone">请输入座机号！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_province">省：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.province}">
                	<#else>
	                    <div class="controls" id="div_txt_customer_ready_province">
	                        <select type="text" id="txt_customer_ready_province" name="province">
	                        	<option value="-1">请选择省份</option>
	                        	<#if (provinces??)>
		                    		<#list provinces as province>
		                    			<option value="${province.provinceId}" <#if editCustomerReady?? && editCustomerReady.province == province.provinceId> selected </#if>>${province.province}</option>
		                    		</#list>
								</#if>
	                        </select>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_city">市：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.city}">
                	<#else>
	                    <div class="controls" id="div_txt_customer_ready_city">
	                        <select type="text" id="txt_customer_ready_city" name="city">
	                        	<option value="-1">请选择城市</option>
	                        	<#if (cities??)>
            						<#list cities as city>
            							<option value="${city.cityId}" <#if editCustomerReady?? && editCustomerReady.city == city.cityId> selected </#if>>${city.city}</option>
	                        		</#list>
               					</#if>
	                   		</select>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_area">区：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.area}">
                	<#else>
	                    <div class="controls" id="div_txt_customer_ready_area">
	                        <select type="text" id="txt_customer_ready_area" name="area">
	                        	<option value="-1">请选择区县</option>
	                        	<#if (areas??)>
            						<#list areas as area>
            							<option value="${area.areaId}" <#if editCustomerReady?? && editCustomerReady.area == area.areaId> selected </#if>>${area.area}</option>
	                        		</#list>
               					</#if>
	                    	</select>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_detail">详细地址：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.detail}">
                	<#else>
	                    <div class="controls">
	                        <textarea rows="3" id="txt_customer_ready_detail" name="detail"><#if editCustomerReady??>${editCustomerReady.detail}</#if></textarea>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_user">业务员：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.user}">
                	<#else>
	                    <div class="controls">
	                    	<select type="text" id="txt_customer_ready_user" name="user">
	                        	<option value="-1">请选择业务员</option>
	                        	<#if (users??)>
		                    		<#list users as user>
		                    			<option value="${user.loginName}">${user.empName}</option>
		                    		</#list>
								</#if>
	                    	</select>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_customer_ready_comm">备注：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editCustomerReady.comm}">
                	<#else>
	                    <div class="controls">
	                        <textarea rows="3" id="txt_customer_ready_comm" name="comm" value="<#if editCustomerReady??>${editCustomerReady.comm}</#if>"></textarea>
	                    </div>
	            	</#if>
                </div>
                
                <div class="control-group">
                    <#if readonly>

                    <#else>
                        <div class="controls">
                            <button type="submit" id="btn_edit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
                            <!--
                            <button type="reset" id="btn_reset" class="btn btn-info">重 置</button>
                            -->
                        </div>
                    </#if>
                </div>
            </form>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

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

	$(function() {
        $('#form_edit_customer_ready').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = '${customerReadyList}';
                    return;
                } else {
                    showAlert(data.message);
                    return;
                }
            }
        });
	});

	$('#txt_customer_ready_province').change(function() {
		var provinceId = $('#txt_customer_ready_province').val();
		
		clearCity();
		clearArea();
		
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
	
	$('#div_txt_customer_ready_city').click(function() {
		var provinceId = $('#txt_customer_ready_province').val();
		if(-1 == provinceId) {
			showAlert("请选择省份!");
			return false;
		}
	});
	
	$('#div_txt_customer_ready_area').click(function() {
		var cityId = $('#txt_customer_ready_city').val();
		if(-1 == cityId) {
			showAlert("请选择城市!");
			return false;
		}
	});
	
	showAlert = function(message) {
		var jModal = $('#modal_alert'); 
		var jModelBody = $('#modal_alert_body', jModal);
		jModelBody.html(message);
		jModal.modal({backdrop:'static', toggle:true});
    };
    
    clearArea = function() {
    	$('#txt_customer_ready_area').empty();
  		$('#txt_customer_ready_area').append("<option value='-1'>请选择区县</option>");
    };
    
    clearCity = function() {
		$('#txt_customer_ready_city').empty();
  		$('#txt_customer_ready_city').append("<option value='-1'>请选择城市</option>");
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

})(jQuery);
</script>
</#assign>

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />