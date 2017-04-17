/**
 * 菜单初始化
 */
function sidebar_page_init() {

}

/**
 * 修改订单状态 
 */
function updateOrderState(o) {
	var se = $(o);
	
	/*Ajax.postJson(Path.serverRootUrl + '/guild/a/dismissGuild', {
		params: { 'guildId':guildId },
	    success: function(json) {
	    	if (json.status == AjaxStatus.ok) {
	    		//$.alert(Alert.SUCCESS, json.message);
	    		TipUtils.success();
				_self.loadContent(_self.cache.currTab, _self.cache.currContent);
				MgrApi.guildName('—— ——');
				var _autos = goooUI.autos;
				_autos.reloadAutoModify();
	    		if ($('#content_autoModify').is(':visible')) {
	    			_autos.loadContent(_autos.cache.currTab, _autos.cache.currContent);
		    	}
	    	} else {
	    		Buttons.enable($(_btn));
	    		$.alert(Alert.ERROR, json.message);
	    	}
	    }
	});*/
}

/**
 * 个人信息编辑画面
 */
function edit_information_page_init() {
	
	// 添加新邮件地址
	$("#addEmail").click(function() {
		var $newRow = $("#clone").clone().appendTo($("#table1 tbody")).show();

		// 事件绑定
		$newRow.find("a").click(function() {
			$(this).parent().parent().remove();
		});
		
		// CSS
		if ($newRow.prev().hasClass("alt-row")) {
			$newRow.removeClass("alt-row");
		}
	});

	// 删除邮件地址
	$("a[name='deleteEmail']").click(function(){
		$(this).parent().parent().remove();
	});
	
	// 隐藏克隆用的邮件行
	$("#clone").hide();
	
	// 提交表单
	$("#form1").submit(function(){
		$("#clone").remove();
		return true;
	});
}

/**
 * 更改登录密码画面
 */
function change_password_page_init() {
	
}