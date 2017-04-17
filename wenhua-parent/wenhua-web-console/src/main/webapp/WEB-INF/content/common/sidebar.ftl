<#-- @ftlvariable name="mainMenus" type="java.util.List<com.tonglukuaijian.survey.interfaces.user.ResDto>" -->
<#-- @ftlvariable name="appConfig" type="com.tonglukuaijian.survey.context.AppConfigExt" -->
<#--assign security = JspTaglibs["/WEB-INF/security.tld"] /-->

<div class="span2 main-menu-span">
    <div class="well nav-collapse sidebar-nav">
        <ul class="nav nav-tabs nav-stacked main-menu">
            <li class="nav-header hidden-tablet">首页</li>
            <li class="active ml0"><a href="/index" class="ajax-link"><span class="hidden-tablet"> 欢迎</span></a></li>
            <#if (mainMenus?? && mainMenus?size > 0)>
	            <#list mainMenus as mainMenu>
		            <li class="nav-header hidden-tablet">${mainMenu.resourceName}</li>
		            <#if (mainMenu.children?? && mainMenu.children?size > 0)>
		            	<#list mainMenu.children as menu>
				            <#if menu??>
				            <li class="ml0"><a id="menu_${menu.resouceCode}" href="${menu.resourceUrl}" <#rt/>
				                               <#lt/>class="ajax-link"><span class="hidden-tablet"> ${menu.resourceName}</span></a></li>
				            </#if>
		            	</#list>
		            </#if>
	            </#list>
            </#if><#--/(mainMenus?? && mainMenus?size > 0) fi-->
        </ul>
    </div>
</div>