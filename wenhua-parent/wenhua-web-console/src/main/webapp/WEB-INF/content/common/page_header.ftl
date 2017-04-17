<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><#if pageAllTitle??>${pageAllTitle}<#else>上海泽杉电子商务有限公司</#if> - ${pageTitle!}</title>
<#if (pageMetaContent??)>
${pageMetaContent}
<#else>
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revlidate" />
<meta http-equiv="expires" content="Web, 26 Feb 1997 08:21:57 GMT" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</#if>
<link type="images/x-icon" rel="icon" href="${appConfig.imagesUrl}/favicon.ico" />
<link type="images/x-icon" rel="shortcut icon" href="${appConfig.imagesUrl}/favicon.ico" />
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/bootstrap-cerulean.css" />
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/bootstrap-responsive.css" />
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/world.css" />
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/charisma-app.css" />

<link rel="stylesheet" href="${appConfig.stylesUrl}/jquery-ui-1.10.3/jquery-ui.min.css" />
<link rel="stylesheet" href="${appConfig.stylesUrl}/bootstrap-datetimepicker.min.css" />
<#if (pageCss??)>${pageCss!}
<#else>
<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/index.css" />
</#if>
<#include "/common/global_scripts.ftl" />
<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript"></script>
</head>

<body<#if (bodyProperties??)> ${bodyProperties!}</#if>>
