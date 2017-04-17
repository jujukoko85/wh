<#-- @ftlvariable name="appConfig" type="com.tonglukuaijian.survey.context.AppConfigExt" -->
<#assign security = JspTaglibs["/WEB-INF/security.tld"] />

<#-- 
<#assign styleSkinUrl = "${appConfig.stylesUrl}/skins/${appConfig.theme.name}/" />
<#assign imageSkinUrl = "${appConfig.imagesUrl}/skins/${appConfig.theme.name}/" />
 -->

<#macro pageable pageData urlPattern preClass="" afterClass="">
<#-- @ftlvariable name="urlPattern" type="java.lang.String" -->
<#-- @ftlvariable name="pageData" type="org.springframework.data.domain.Page<java.lang.Object>" -->
<#assign firstPageUrl = urlPattern?replace("{p}", "1") />
<#assign lastPageUrl = urlPattern?replace("{p}", "${pageData.totalPages}") />
<#assign currPage = pageData.number + 1 />
<#assign pageCount = pageData.totalPages />
<#assign currPageUrl = urlPattern?replace("{p}","${currPage}") />
<#if (pageCount == 0)>
<#assign pageCount = 1 />
</#if>

<div class="<#if preClass?has_content>${preClass} </#if>pagination<#if afterClass?has_content> ${afterClass}</#if>">
<ul>
    <#if (currPage == 1 || pageCount <= 1)>
    <li class="prev disabled">
        <a href="javascript:void(0)" title="上一页" onclick="return false;"><i
                class="icon-step-backward icon-white"></i></a>
    </li>
    <#else>
    <li class="prev">
        <#assign prevPageUrl = urlPattern?replace("{p}", (currPage - 1)?string) />
        <a href="${prevPageUrl}" title="上一页"><i class="icon-step-backward"></i></a>
    </li>
    </#if>

    <#list 1..pageCount as p>
    <#if (currPage == p)>
    <li class="active">
        <a href="javascript:void(0)" title="第${p}页" onclick="return false;">${p}</a>
    </li>
    <#else>
    <li>
        <#assign tmpPageUrl = urlPattern?replace("{p}","${p}") />
        <a href="${tmpPageUrl}" title="第${p}页">${p}</a>
    </li>
    </#if>
    </#list>

    <#if (currPage == pageCount || pageCount <= 1)>
    <li class="next disabled">
        <a href="javascript:void(0)" title="下一页" onclick="return false;"><i
                class="icon-step-forward icon-white"></i></a>
    </li>
    <#else>
    <li class="next">
        <#assign nextPageUrl = urlPattern?replace("{p}", (currPage + 1)?string) />
        <a href="${nextPageUrl}" title="下一页"><i class="icon-step-forward"></i></a>
    </li>
    </#if>
</ul>
</div>
</#macro>