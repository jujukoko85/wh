<#assign pageTitle = "部门列表" />
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
                <button align="right" type="button" id="btn_add" onclick="location.href='/department/department_add'" class="btn btn-primary">新 增</button>&nbsp;&nbsp;
            </div>
            <div class="box-content">
                <div id="alert_success" class="alert alert-block alert-success fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">部门删除成功！</h4>
                    <p></p>
                </div>
                <div id="alert_error" class="alert alert-block alert-error fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">删除部门失败！</h4>
                    <p></p>
                </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                    	<th>序号</th>
                        <th>部门名称</th>
                        <th>部门主管</th>
                        <td>上级部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list departments as department>
                        <tr id="tr_department_${department.id}">
                            <td>${department_index+1}<input type="hidden" id="txt_department_id_${department_index}" name="departmentId" value="${department.id}" /></td>
                            <td>${department.deptName}</td>
                            <td>
                            	<#if department.managerUser??>
                            		<a href="/ucenter/ucenter_watch?uid=${department.manager}">${department.managerUser.empName}</a>
                            	<#else>
                            		${department.manager}
                            	</#if>
                            </td>
                            <td><#if department.parent??>${department.parent.deptName}</#if></td>
                            <td>
                                <a href="/department/department_edit?uid=${department.id}"><i class="icon-pencil"></i> 编辑</a>
                                <a href="javascript:void(0)" data-department-id="${department.id}"
                                data-department-name="${department.deptName}" onclick="return Department.showDelDepartmentModal(this);"><i class="icon-trash"></i> 删除</a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<div id="modal_del_department" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_del_department" aria-hidden="true">
    <form id="form_del_department" name="formDelName" action="/department/department_del" method="post">
    <input type="hidden" id="txt_deleted_department_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_del_department">删除部门确认信息</h3>
    </div>
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="btn_del_department" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<#assign pageFootScripts>
<script type="text/javascript" src="${appConfig.scriptsUrl}/module/department_list.js"></script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />