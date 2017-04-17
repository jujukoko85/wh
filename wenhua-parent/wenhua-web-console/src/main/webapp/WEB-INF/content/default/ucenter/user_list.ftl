<#-- @ftlvariable name="page" type="org.springframework.data.domain.Page<com.tonglukuaijian.survey.interfaces.user.UserDto>" -->
<#assign pageTitle = "用户列表" />
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
            	<button type="button" id="btn_add" onclick="location.href='/ucenter/user_new'" class="btn btn-primary">新 增</button>&nbsp;&nbsp;
            </div>
            <div class="box-content">
                <div id="alert_success" class="alert alert-block alert-success fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">操作成功！</h4>
                    <p></p>
                </div>
                <div id="alert_error" class="alert alert-block alert-error fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">操作失败！</h4>
                    <p></p>
                </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>用户名</th>
                        <th>工号</th>
                        <th>姓名</th>
                        <th>部门</th>
                        <th>所属角色</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if (page?? && page.content??)>
                        <#list page.content as user>
                        <tr id="tr_user_${user.id}">
                            <td>${(page.number)*(page.size)+(user_index+1)}<input type="hidden" id="txt_user_id_${user_index}" name="userId" value="${user.id}" /></td>
                            <td><a href="/ucenter/ucenter_watch?uid=${user.loginName}">${user.loginName}</a></td>
                            <td>${user.code}</a></td>
                            <td>${user.empName!}</td>
                            <td><#if user.department??>${user.department.deptName}</#if></td>
                            <td>
                                <#if (user.roles?? && user.roles?size > 0)>
                                    <#list user.roles as role>${role.name}<#if role_has_next>，</#if></#list>
                                </#if>
                            </td>
                            <td>
                                <a href="/ucenter/user_edit?uid=${user.id}"><i class="icon-pencil"></i> 编辑</a>
                                <a href="javascript:void(0)" data-user-id="${user.id}" data-login-name="${user.loginName}"
                                   data-emp-name="${user.empName}" onclick="return User.showResetPwdModal(this);"><i class="icon-repeat"></i> 重置密码</a>
                                <a href="javascript:void(0)" data-user-id="${user.id}" data-login-name="${user.loginName}"
                                   data-emp-name="${user.empName}" onclick="return User.showDelUserModal(this);"><i class="icon-trash"></i> 删除</a>
                            </td>
                        </tr>
                        </#list>
                        <#if page.content?size < 12>
                            <#list 1..(12 - page.content?size) as idx>
                            <tr>
                                <td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td></td>
                            </tr>
                            </#list>
                        </#if><#-- // end if page.content?size -->
                    </#if>
                    </tbody>
                </table>
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="/ucenter/user_list?currentPage={p}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<div id="modal_del_user" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_del_user" aria-hidden="true">
    <form id="form_del_user" name="formDelName" action="/ucenter/a/del_user" method="post">
    <input type="hidden" id="txt_deleted_user_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_del_user">删除用户确认信息</h3>
    </div>
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="btn_del_user" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<div id="modal_reset_pwd" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_reset_pwd" aria-hidden="true">
    <form id="form_reset_pwd" name="formResetName" action="/ucenter/a/reset_pwd" method="post">
    <input type="hidden" id="txt_reset_pwd_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_reset_pwd">重置用户密码确认信息</h3>
    </div>
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="btn_reset_pwd" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<div id="modal_reset_pwd_success" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_reset_pwd_success" aria-hidden="true">
    <div class="modal-header">
        <h3 id="lbl_reset_pwd_success">重置用户密码成功信息</h3>
    </div>
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">确定</a>
    </div>
</div>

<#assign pageFootScripts>
<script type="text/javascript" src="${appConfig.scriptsUrl}/module/user_list.js"></script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />