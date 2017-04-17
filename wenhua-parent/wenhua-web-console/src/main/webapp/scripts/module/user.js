/*
 * Copyright (c) 2009-2013 上海泽杉电子商务发展有限公司 All rights reserved.
 * @(#) order.js 2013-05-08 16:42
 */

(function($) {

var jBtnSuccess, jBtnFail, jBtnClose, jUpdateApplyMoneyForm, jCalCargoForm, ids , status,jBtnCargoReset,jBtnApplyMoneyReset;

function _initInternal() {

	jBtnSuccess = $('#btn_success');
	jBtnFail = $('#btn_fail');
	jBtnClose = $('#btn_close');
	
	jUpdateApplyMoneyForm = $('#fm_update_apply_money');
	jCalCargoForm = $('#form_cal_cargo');
	jBtnCargoReset = $('#btn_cargo_reset');
	jBtnApplyMoneyReset = $('#btn_apply_money_reset');
}

$(function() {
	_initInternal();
	 
	jBtnSuccess.click(function() {
		$('#status').val('2');
		return true;
	});
	
	jBtnFail.click(function() {
		$('#status').val('3');
		return true;
	});
	
	jBtnCargoReset.click(function() {
		$('#login_name').attr('value','');
		$('#id').attr('value','');
		$('#cargo_no').attr('value','');
		$('#survey_title').attr('value','');
    });
	
	jBtnApplyMoneyReset.click(function() {
		$('#txt_loginName').attr('value','');
		$('#txt_account').attr('value','');
		$('#txt_apply_time_start').attr('value','');
		$('#txt_apply_time_end').attr('value','');
		$('#txt_lastmodified_time_start').attr('value','');
		$('#txt_lastmodified_time_end').attr('value','');
    });
	
	jUpdateApplyMoneyForm.ajaxForm({
		dataType: 'json',
        success: function(data) {
        	if (data.status === 1) {
        		location.href = '/user/applyMoney';
        	} else {
        		alert(data.message);
        	}
        	
        }
    });
	
	//保存物流信息
    _updateCargo = function(id) {
       status=$("#status_"+id).val();
       var logisticsName = $("#sel_logistics_name_"+id).val();
       var cargoNo = $("#cargo_no_"+id).val();
       var cargoCost = $("#cargo_cost_"+id).val();
       if(status!=1){
           alert("状态不是待发货，不能保存！");
           return false;
       }else if(logisticsName == ''){
           alert("请选择物流公司！");
           return false;
       }else if(cargoNo == ''){
           alert("请输入物流单号！");
           return false;
       }else if(!$.isNumeric(cargoCost)){
           alert("物流费用请输入数字！");
           return false;
       }
       $.ajax({
           url: Path.siteUrl + '/user/a/update_survey_cargo/'+id,
           data: {logisticsName:logisticsName,cargoNo:cargoNo,cargoCost:cargoCost},
           dataType: 'json',
           success: function(data) {
               alert(data.message);
               if (data.status === 1) {
                   location.reload();
               } else {
                   alert(data.message);
               }
           }
       });
   }
   
   //全选
   $("#all").click(function(){  
       var isChecked = this.checked;
       $("input[name='cid']").each(function(){
           $(this).attr("checked",isChecked);
       });  
   });
   
   _getIds = function(type){
        var checked = [], checkedAll = [],cidVal,logisticsStatus,logisticsName,cargoNo; 
        $('input[name=cid]:checked').each(function() { 
           cidVal = $(this).val();
           logisticsStatus= $('#status_'+cidVal).val();
           logisticsName = $('#sel_logistics_name_'+cidVal).val();
           cargoNo = $('#cargo_no_'+cidVal).val();
           if(type==0 && logisticsStatus!=0) {     //作废订单 
               checked.push($(this).val()); 
           }else if(type==1 && logisticsStatus==1 && logisticsName!='' && cargoNo!=''){  //发货订单  -- 订单状态为等待发货，且物流公司及单号已保存
               checked.push($(this).val()); 
           }
           checkedAll.push($(this).val()); 
        }); 
        ids = checked.join(",");
        if(checked == '' && checkedAll== ''){
           alert("请选择物流订单！");
           return false;
        }else if(type==1 && checked == '' && checkedAll!= ''){
           alert("订单状态不是等待发货或物流公司及物流单号未保存，请重新选择！");
           return false;
        }else if(type==0 && checked == '' && checkedAll!= ''){
            alert("订单已作废，请重新选择！");
            return false;
         }
        return ids;
   }
   
   //发货
   _updateStatus = function(ids){
       
       if(ids==0){ //批量更新
           ids = _getIds(1);
           if(ids==false){
               return;
           }
       }else{  //单个更新
    	   var logisticsName = $("#sel_logistics_name_"+ids).val(),
    	   	   cargoNo=$("#cargo_no_"+ids).val();
           status = $("#status_"+ids).val();
           if(logisticsName=='' || cargoNo==''){
        	   alert("请先保存物流公司和物流单号！");
        	   return false;
           }
           if(status!=1){
               alert("状态不是待发货，不能发货！");
               return false;
           }
       }
        $.ajax({
           url: Path.siteUrl + '/user/a/update_cargo_status',
           data: { ids:ids},
           dataType: 'json',
           success: function(data) {
               if (data.status === 1) {
                   location.reload();
               } else {
                   alert(data.message);
               }
           }
       });
   }
   
   //更新物流订单状态-作废
   showCancelModal = function(ids) {
       if(ids==0){  //批量更新
           ids = _getIds(0);
           if(ids==false){
               return;
           }
       }else{  //单个更新
           status=$("#status_"+ids).val();
           if(status==0){
               alert("状态为已作废，不能操作！");
               return false;
           }
       }
       $('#txt_cal_cargo_id').val(ids);
       $('#model_cal_cargo').modal({backdrop:'static', toggle:true});
       return false;
   }
   
   jCalCargoForm.ajaxForm({
       dataType: 'json',
       success: function(data) {
           if (data.status === 1) {
               alert(data.message);
               location.href=Path.siteUrl + '/user/surveyCargo'
           } else {
               alert(data.message);
           }
       }
    });
    
// 根据物流单号查询用户调查物流信息
   queryCargoByCargoNo = function() {
	   var loginName = $('#login_name').val();
	   var orderId = $('#id').val();
       var cargoNo = $('#cargo_no').val();
       var title = $('#survey_title').val();
       var logisticsName=$('#logistics_name').val();
       var status = $('#logistics_status').val();
       location.href = "/user/surveyCargo?loginName=" + loginName+"&id="+orderId+"&cargoNo="+cargoNo+
       					"&surveyTitle="+title+"&logisticsName="+logisticsName+"&status="+status;
       
   }
   
   //添加支付宝提现限定
   addLimited = function() {
	   var ex = /^\d+$/; 
	   var maxAmount=$('#maxAmount').val();
   	   var minAmount=$('#minAmount').val();
   	   var maxTimes=$('#maxTimes').val();     
   	   if (!$.isNumeric(maxAmount)) {
   		   alert("最高金额限定必须为数字"); 
   		   return false;           
   	   }
   	   if (!ex.test(maxAmount)) {
   		   alert("最高金额限定必须为正整数");
   		   return false;
   	   } 
   	   if (!$.isNumeric(minAmount)) {
		   alert("最低金额限定必须为数字"); 
		   return false;           
	   }
	   if (!ex.test(minAmount)) {
		   alert("最低限定必须为正整数");
		   return false;
	   } 
	   if (!$.isNumeric(maxTimes)) {
		   alert("提现次数限定必须为数字"); 
		   return false;           
	   }
	   if (!ex.test(maxTimes)) {
		   alert("提现次数限定必须为正整数");
		   return false;
	   } 	  	  
   	   location.href = "/phone/alipayLimited?maxAmount="+maxAmount+
   	   					"&minAmount="+minAmount+"&maxTimes="+maxTimes;
   }

});
})(jQuery);