<#assign pageTitle = "分销列表" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<#assign formActionList = "/distributor/distributor_list" />
<#assign formActionDel = "/distributor/distributor_del" />
<#assign formActionAdd = "/distributor/distributor_add" />
<#assign formActionEdit = "/distributor/distributor_edit" />
<#assign formActionDetail = "/distributor/distributor_detail" />
<#assign formActionAssign = "/distributor/distributor_assign" />

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
					姓名<input type="text" class="input-small search-query" name="name" />
					手机<input type="text" class="input-small search-query" name="mobile" />
					代码<input type="text" class="input-small search-query" name="code" />
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
                        <th class="span2">姓名</th>
                        <th class="span2">手机号</th>
                        <th class="span1">代码</th>
                        <th class="span3 center">合同到期日</th>
                        <th >操作</th>
                    </tr>
                    </thead>
                    <tbody>
	                    <#if (page?? && page.content??)>
		                    <#list page.content as entity>
		                    <tr id="tr_entity_${entity.id}">
		                        <td>${(page.number)*(page.size)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}" name="id" value="${entity.id}" /></td>
		                        <td>${entity.name}</td>
		                        <td>${entity.mobile}</td>
		                        <td>${entity.code!}</td>
		                        <td>${entity.expiredTime?string("yyyy-MM-dd HH:mm:ss")!""}</td>
		                        <td>
		                            <a href="${formActionEdit}?uid=${entity.id}"><i class="icon-pencil"></i> 编辑</a>
		                            <a href="javascript:void(0)"
		                               data-id="${entity.id}" 
		                               data-name="${entity.name}"
		                               data-mobile="${entity.mobile}"
		                               data-code="${entity.code}"
		                               onclick="return Entity.showDelEntityModal(this);">
		                               <i class="icon-trash"></i> 删除
		                            </a>
		                            <a href="${formActionDetail}?uid=${entity.id}"><i class="icon-list"></i> 详情</a>
		                            <a href="${formActionAssign}?uid=${entity.id}"><i class="icon-user"></i> 分配下级</a>
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
		                        </tr>
		                        </#list>
							</#if>
	                    </#if><#-- // end if page.content?size -->
                    </tbody>
                </table>
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="${formActionList}?currentPage={p}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<!-- 删除对话框 -->
<div id="modal_del_entity" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_del_entity" aria-hidden="true">
    <!-- 删除表单 -->
    <form id="form_del_entity" name="formDelName" action="${formActionDel}" method="post">
    <!-- 删除对象ID -->
    <input type="hidden" id="txt_deleted_entity_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_del_entity">删除确认信息</h3>
    </div>
    <!-- 删除对话框主体 -->
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
    	<!-- 确认删除按钮 -->
        <a href="javascript:void(0)" id="btn_del_entity" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<#assign pageFootScripts>
<script type="text/javascript" src="${appConfig.scriptsUrl}/module/distributor/distributor_list.js"></script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />