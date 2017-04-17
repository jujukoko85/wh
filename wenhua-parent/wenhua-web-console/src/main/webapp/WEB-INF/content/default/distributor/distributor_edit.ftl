<#assign pageTitle = "编辑分销" />
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
    <#if editDistributor??>
        <#assign formAction = "/distributor/distributor_update" />
        <#assign inputId>
        <input id="txt_distributor_id" name="id" type="hidden" value="${editDistributor.id}" />
        </#assign>
    <#else>
        <#assign formAction = "/distributor/distributor_save" />
    </#if>
        <div class="box span12">
            <div class="box-header well">
                <h2><i class="icon-user"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <form class="form-horizontal" id="form_edit_distributor" name="formEditDistributor" action="${formAction}" method="post">
                ${inputId!}
                <p id="message_tip" class="hide"></p>
                <div class="control-group">
                    <label class="control-label" for="txt_distributorname">姓名：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editDistributor.name}">
                	<#else>
	                    <div class="controls">
	                        <input type="text" id="txt_distributor_name" name="name" placeholder="姓名" value="<#if editDistributor??>${editDistributor.name}</#if>">
	                        <span class="help-inline hide" id="help_distributor_name">请输入姓名！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">手机号：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editDistributor.mobile}">
                	<#else>
	                    <div class="controls">
	                    	<input type="text" id="txt_distributor_mobile" name="mobile" placeholder="手机号" value="<#if editDistributor??>${editDistributor.mobile}</#if>">
	                        <span class="help-inline hide" id="help_distributor_mobile">请输入手机号！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">代码：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editDistributor.code}">
                	<#else>
	                    <div class="controls">
	                    	<input type="text" readonly id="txt_distributor_code" name="code" placeholder="代码" value="<#if editDistributor??>${editDistributor.code}</#if>">
	                        <span class="help-inline hide" id="help_distributor_code">请输入代码！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label">性别：</label>
                    <div class="controls">
                        <label class="radio inline" style="width: 50px;margin-left: 18px;">
                            <input type="radio" name="sex"<#if editDistributor?? && editDistributor.sex == 1> checked="checked" <#else> checked="checked" </#if> value="1"> 男
                        </label>
                        <label class="radio inline">
                        	<input type="radio" name="sex"<#if editDistributor?? && editDistributor.sex == 0> checked="checked"</#if> value="0"> 女
                        </label>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">是否过期：</label>
                    <div class="controls">
                        <label class="radio inline" style="width: 50px;margin-left: 18px;">
                            <input type="radio" name="hasRight"<#if editDistributor?? && editDistributor.hasRight == 1> checked="checked"</#if> value="1"> 是
                        </label>
                        <label class="radio inline">
                        	<input type="radio" name="hasRight"<#if editDistributor?? && editDistributor.hasRight == 0> checked="checked" <#else> checked="checked" </#if> value="0"> 否
                        </label>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">合同期限：</label>
                   <div class="controls">
                   <#if readonly>
                        <input type="text" value="${editDistributor.expiredTime?string('yyyy-MM-dd HH:mm:ss')}" readonly />
                   <#else>
                    	<div id="txt_expired_time" class="input-append date form_time">
                            <input name="expiredTime" class="input-medium" type="text" <#if editDistributor??>value="${editDistributor.expiredTime}"</#if> readonly/>
    			            <span class="add-on"><i class="icon-remove"></i></span>
    						<span class="add-on"><i class="icon-th"></i></span>
    			        </div>
                    </#if>
                </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">微信号：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editDistributor.wechat}">
                	<#else>
	                    <div class="controls">
	                    	<input type="text" id="txt_distributor_wechat" name="wechat" placeholder="微信号" value="<#if editDistributor??>${editDistributor.wechat}</#if>">
	                        <span class="help-inline hide" id="help_distributor_wechat">请输入微信号！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">支付宝：</label>
                    <#if readonly>
                		<input type="text" readonly value="${editDistributor.alipay}">
                	<#else>
	                    <div class="controls">
	                    	<input type="text" id="txt_distributor_alipay" name="alipay" placeholder="支付宝" value="<#if editDistributor??>${editDistributor.alipay}</#if>">
	                        <span class="help-inline hide" id="help_distributor_wechat">请输入支付宝！</span>
	                    </div>
	            	</#if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="txt_manager">区域：</label>
                    <#if readonly>
                        <div class="controls">
                            <textarea row="3" type="text" id="txt_distributor_area" name="area" readonly placeholder="区域"><#if editDistributor??>${editDistributor.area}</#if></textarea>
                        </div>
                    <#else>
                        <div class="controls">
                        	<textarea row="3" type="text" id="txt_distributor_area" name="area" placeholder="区域"><#if editDistributor??>${editDistributor.area}</#if></textarea>
                            <span class="help-inline hide" id="help_distributor_area">请输入区域！</span>
                        </div>
                    </#if>
                </div>
                
               
                <div class="control-group">
                    <#if readonly>

                    <#else>
                        <div class="controls">
                            <button type="submit" id="btn_edit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
                            <button type="reset" id="btn_reset" class="btn btn-info">重 置</button>
                        </div>
                    </#if>
                </div>
            </form>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<#assign pageFootScripts>

<script type="text/javascript">

$('.form_time').datetimepicker({
    language:  'zh-CN',
    format: 'yyyy-mm-dd 23:59:59',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    endView: 2,
    minView: 2,
    maxView: 3,
    forceParse: 0
});

(function($) {

	$(function() {
        $('#form_edit_distributor').ajaxForm({
            dataType: 'json',
            success: function(data) {
                if (data.status === 1) {
                    alert(data.message);
                    location.href = "/distributor/distributor_list";
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