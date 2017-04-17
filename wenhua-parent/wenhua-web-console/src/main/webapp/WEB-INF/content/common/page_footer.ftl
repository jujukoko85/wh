<#-- @ftlvariable name="pageFootScripts" type="java.lang.String" -->
<script type="text/javascript" src="${appConfig.scriptsUrl}/libs/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${appConfig.scriptsUrl}/libs/bootstrap.min.js"></script>
<script type="text/javascript" src="${appConfig.scriptsUrl}/libs/jquery-form.min.js"></script>
<script type="text/javascript" src="${appConfig.scriptsUrl}/libs/jquery.history.js"></script>
<script type="text/javascript" src="${appConfig.scriptsUrl}/libs/jquery-ui-1.10.3.custom.min.js"></script>

<script src="${appConfig.scriptsUrl}/bootstrap-datetimepicker.min.js"></script>
<script src="${appConfig.scriptsUrl}/bootstrap-datetimepicker.zh-CN.js"></script>
<#if pageFootScripts??>
${pageFootScripts}
</#if>

</body>
</html>