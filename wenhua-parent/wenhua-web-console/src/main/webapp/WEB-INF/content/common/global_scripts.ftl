<#-- Javascript 全局引用 $Id: global_scripts.ftl 30270 2013-05-27 06:40:03Z C636 $ -->
<script type="text/javascript"><#rt />
document.domain='<#rt/>
<#if appConfig.cookieRootDomain?starts_with('.')>
${appConfig.cookieRootDomain?substring(1)}<#rt/>
<#else>
${appConfig.cookieRootDomain}<#rt/>
</#if>
';<#rt/>
var Path=window.Path={<#rt/>
cookieRootDomain:'${appConfig.cookieRootDomain!}',<#rt/>
cookieDomain:'${appConfig.cookieDomain!}',<#rt/>
siteUrl:'${appConfig.siteUrl}',<#rt/>
stylesUrl:'${appConfig.stylesUrl!}',<#rt/>
scriptsUrl:'${appConfig.scriptsUrl!}',<#rt/>
imagesUrl:'${appConfig.imagesUrl!}'<#rt/>
};<#rt/>
</script>
