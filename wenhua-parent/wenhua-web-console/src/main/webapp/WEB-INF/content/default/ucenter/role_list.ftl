
<#-- @ftlvariable name="page" type="org.springframework.data.domain.Page<com.tonglukuaijian.survey.interfaces.user.UserDto>" -->
<#assign pageTitle = "角色列表" />
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
            	<button type="button" id="btn_add" onclick="location.href='/ucenter/role_new'" class="btn btn-primary">新 增</button>&nbsp;&nbsp;
            </div>
            <div class="box-content">
                <div id="alert_success" class="alert alert-block alert-success fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">角色删除成功！</h4>
                    <p></p>
                </div>
                <div id="alert_error" class="alert alert-block alert-error fade in hide">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <h4 class="alert-heading">删除角色失败！</h4>
                    <p></p>
                </div>
                <table class="table table-striped table-bordered bootstrap-datatable datatable dataTable">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>角色名称</th>
                        <th>角色代码</th>
                        <th>角色状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if (page?? && page.content??)>
                        <#list page.content as role>
                        <tr id="tr_role_${role.id}">
                            <td>${(page.number)*(page.size)+(role_index+1)}<input type="hidden" id="txt_role_id_${role_index}" name="id" value="${role.id}" /></td>
                            <td>${role.roleName}</td>
                            <td>${role.roleCode}</td>
                            <td><#if role.hyRoleStatus == 1>启用<#elseif role.hyRoleStatus == 0>禁用<#elseif role.hyRoleStatus == -1>删除<#else>未知</#if></td>
                            <td>
                                <a href="/ucenter/role_edit?uid=${role.id}"><i class="icon-pencil"></i> 编辑</a>
                                <a href="javascript:void(0)" data-id="${role.id}" data-role-name="${role.roleName}"
                                   data-role-code="${role.roleCode}" onclick="return Role.showDelRoleModal(this);"><i class="icon-trash"></i> 删除</a>
                                <a href="/ucenter/role_config?uid=${role.id}"><i class="icon-adjust"></i> 配置</a>
                            </td>
                        </tr>
                        </#list>
                        <#if page.content?size < 12>
                            <#list 1..(12 - page.content?size) as idx>
                            <tr>
                                <td>&nbsp;</td><td></td><td></td><td></td><td></td>
                            </tr>
                            </#list>
                        </#if><#-- // end if page.content?size -->
                    </#if>
                    </tbody>
                </table>
                <div class="row-fluid">
                    <div class="span12"></div>
                    <div class="span12 center">
                    <@global.pageable pageData=page urlPattern="/ucenter/role_list?currentPage={p}" />
                    </div>
                </div>
            </div><#--/.box-content-->
        </div><#--/.span12 box-->
    </div><#--/.fluid-row-->
</div>

<div id="modal_del_role" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="lbl_del_role" aria-hidden="true">
    <form id="form_del_role" name="formDelName" action="/ucenter/role_del" method="post">
    <input type="hidden" id="txt_deleted_role_id" name="uid" />
    <div class="modal-header">
        <h3 id="lbl_del_role">删除角色确认信息</h3>
    </div>
    <div class="modal-body">
        <p></p>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="btn_del_role" class="btn btn-primary">确定</a>
        <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
    </div>
    </form>
</div>

<#assign pageFootScripts>
<script type="text/javascript" src="${appConfig.scriptsUrl}/module/role_list.js"></script>
</#assign>
<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />