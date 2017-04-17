<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a href="http://www.haiyanchina.com" class="brand" target="_blank"><img 
                    src="${appConfig.imagesUrl}/logo.png" height="40" alt="上海泽杉电子商务有限公司"></a>

            <#-- theme selector starts -->

            <#-- theme selector ends -->

            <#-- user dropdown starts -->
            <div class="btn-group pull-right">
                <a href="#" data-toggle="dropdown" class="btn dropdown-toggle">
                    <i class="icon-user"></i><span class="hidden-phone"> <#if currUser??>${currUser.empName!}</#if></span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/ucenter/modify_password">修改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="/logout">退出登录</a></li>
                </ul>
            </div>
            <#-- user dropdown ends -->

            <#--/.nav-collapse -->
        </div>
    </div>
</div>