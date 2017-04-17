<#assign pageTitle = "404 - Page Not Found" />
<#include "/common/page_header.ftl" />
<#include "/common/common_header.ftl" />

<div>
    <ul class="breadcrumb">
        <li><a href="/index">首页</a> <span class="divider">/</span></li>
        <li><span>404</span></li>
    </ul>
</div>

<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header well" data-original-title>
            <h2><i class="icon-picture"></i>404</h2>
            <div class="box-icon">
                <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
                <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <img src="${appConfig.imagesUrl}/404_bg.jpg" alt="404" title="404" />
        </div>
    </div><!--/span-->
</div><!--/row-->

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />