$(document).ready(function() {
	$("#form_reset").on("click", "#btn_reset", handleResetPassword);
	$("#form_login").on("click", "#btn_login", handleLogin);
});

// 处理重置密码
function handleResetPassword(event) {
	//alert('123')
	var radioValue = $('input:radio[name="kind"]:checked').val();
	var username = $("#userName").val();
	var oldPassword = $("#oldpassword").val();
	var newPassword = $("#newpassword").val();
	var newPassword1 = $("#newpassword1").val();
	var message = validateRestPassword(username, oldPassword,
		newPassword, newPassword1);
	if (message != '') {
		alert(message);
		event.preventDefault();
		return;
	}
	const data = {
		"username": username,
		"old_password": oldPassword,
		"new_password": newPassword
	};
	post({
		url: "/user/pwd/reset",
		data: data,
		success: function(result) {
			if (result.code == 200) {
				window.location.href = "登录.html";
			} else {
				alert(result.message);
			}
		}
	});
}

// 重置密码表单的校验
function validateRestPassword(username, oldPassword, newPassword, newPassword1) {
	const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!?@#$%^&*])[a-zA-Z\d!?@#$%^&*]{15,}$/;
	var message = '';
	if (username == "") {
		message = "未输入用户名";
	} else if (oldPassword == "") {
		message = "未输入原始密码";
	} else if (newPassword.length < 15 || newPassword1.length < 15) {
		message = "新密码必须大于等于15位";
	} else if (!re.test(newPassword)) {
		message = "密码格式错误，必须包含小写字母、大写字母、数字和特殊字符";
	} else if (newPassword != newPassword1) {
		message = "两次密码输入不一致"
	}
	return message;
}

// 处理登录
function handleLogin(event) {
	//var radioValue = $('input:radio[name="kind"]:checked').val();
	const data = {
		"username": $("#username").val(),
		"password": $("#password").val()
	};
	post({
		url: "/user/login",
		data: data,
		success: function(result) {
			if (result.code == 200) {
				sessionStorage.setItem("username", data.username);
				sessionStorage.setItem("authorization",
					`${result.data.tokenHead} ${result.data.token}`);
				window.location.href = "首页.html";
			} else {
				alert(result.message);
			}
		}
	});
}

function saveCookie(){//保存cookie
	var UName=document.getElementById("username");
	setCookie(UName.id,UName.value,30);
}

//把用户名保存到cookie
function setCookie(name,value,expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie=name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());//创建cookie
}
