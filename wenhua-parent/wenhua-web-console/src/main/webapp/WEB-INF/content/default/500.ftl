<#assign pageTitle = "500 - System busy" />
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
                <h2><i class="icon-book"></i> ${pageTitle}</h2>
            </div>
            <div class="box-content">
            <h3>系统繁忙，如果需要，请联系管理员！</h3>
            </div>
        </div>
    </div>
</div>

<#include "/common/common_footer.ftl" />
<#include "/common/page_footer.ftl" />