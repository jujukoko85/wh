(function($) {

	var Role = window.Role = {},
	jAlertSuc, jAlertErr, jAlertErrC, 
	jForm, jDelModal, jDelModelBody, jDelRoleId, 
	jDelBtn, _timer, currDelRoleId,

	_initialize = function() {
		jForm = $('#form_del_role');
		jAlertErr = $('#alert_error');
		jAlertErrC = $('p', jAlertErr);
		jAlertSuc = $('#alert_success');
		jDelBtn = $('#btn_del_role');
		jDelModal = $('#modal_del_role');
		jDelModelBody = $('div.modal-body', jDelModal);
		jDelRoleId = $('#txt_deleted_role_id');
		jUseBtn = $('#btn_use_role');
		
		_initEvents();
	},
	
	_delContent = function(role) {
		return ['<p>您确认要删除 <strong>', role.roleName, '</strong>（',
				role.roleCode, '） 这个角色吗？'].join('');
	},

	_delRoleOptions = {
			dataType : 'json',
			success : function(data) {
				var isSuccess = data.status === 1;
				if (isSuccess) { // 删除成功！
					jAlertSuc.show();
					$('#tr_role_' + currDelRoleId).remove();
                    $('table.table tbody').append('<tr><td>&nbsp;</td><td></td><td></td></tr>');
				} else {
					jAlertErrC.html(data.message);
					jAlertErr.show();
				}
				_timer = setTimeout(function() {
					if (isSuccess) {
						location.reload();
					} else {
						jAlertErr.alert('close');
					}
				}, 6000);
			}
		},
		
	_clearTimer = function() {
		if (_timer) {
			clearTimeout(_timer);
			_timer = null;
		}
	},

	_initEvents = function() {
		jForm.submit(function() {
			$(this).ajaxSubmit(_delRoleOptions);
			return false;
		});

		jDelBtn.click(function() {
			jForm.submit();
			jDelModal.modal('hide');
			return false;
		});

		jAlertErr.on('close', _clearTimer);
		jAlertSuc.on('close', _clearTimer);
	};

	/**
	 * 显示删除确认框。
	 *
	 * @param btn 角色列表项的删除按钮（链接）
	 * @returns {boolean} Return false.
	 */
	Role.showDelRoleModal = function(btn) {
		var jDel = $(btn), role = {
			id : jDel.data('id'),
			roleName : jDel.data('roleName'),
			roleCode : jDel.data('roleCode')
		};
		jDelRoleId.val(role.id);
		currDelRoleId = role.id;
		jDelModelBody.html(_delContent(role));
		jDelModal.modal({backdrop : 'static', toggle : true	});
	};

	$(function() {
		_initialize();
	});

})(jQuery);