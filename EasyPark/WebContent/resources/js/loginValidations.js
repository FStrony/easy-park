$(document).ready(function() {
	$("#msgError").css("display", "none");
});

function validaLogin() {
	if (document.getElementById('formLogin:email').value == "") {
		$('#formLogin\\:LoginEmailGroup').addClass('error');
		$("#spanEmailLogin").css("display", "block");
	}
	if (document.getElementById('formLogin:senha').value == "") {
		$('#formLogin\\:LoginSenhaGroup').addClass('error');
		$("#spanSenhaLogin").css("display", "block");
	}
}

function showMessage() {

	if ($("#SpanError").text() == "Usuário e/ou Senha Inválidos!") {
		$("#msgError").css("display", "block");
	} else {
		$("#msgError").css("display", "none");
	}
}

function onBlurEmail() {
	if (document.getElementById('formLogin:email').value == "") {
		$('#formLogin\\:LoginEmailGroup').addClass('error');
		$("#spanEmailLogin").css("display", "block");
	} else {
		$('#formLogin\\:LoginEmailGroup').removeClass('error');
		$("#spanEmailLogin").css("display", "none");
	}
}

function onBlurSenha() {
	if (document.getElementById('formLogin:senha').value == "") {
		$('#formLogin\\:LoginSenhaGroup').addClass('error');
		$("#spanSenhaLogin").css("display", "block");
	} else {
		$('#formLogin\\:LoginSenhaGroup').removeClass('error');
		$("#spanSenhaLogin").css("display", "none");
	}
}