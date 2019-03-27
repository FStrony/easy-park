function valida() {
	if (document.getElementById('formCadEstac:idEmail').value == "") {
		$('#formCadEstac\\:groupEmail').addClass('error');
		$("#spanEmail").css("display", "block");
	} else {
		if (!isEmail(document.getElementById('formCadEstac:idEmail').value)) {
			$('#formCadEstac\\:groupEmail').addClass('error');
			$("#spanEmail").css("display", "block");
		}
	}
	if (document.getElementById('formCadEstac:idSenha').value == "") {
		$('#formCadEstac\\:groupSenha').addClass('error');
		$("#spanSenha").css("display", "block");
	}
	if (document.getElementById('formCadEstac:idCnpj').size != 25) {
		$('#formCadEstac\\:groupCNPJ').addClass('error');
		$("#spanCnpj").css("display", "block");
	}

}

$(function() {
	$("#formCadEstac\\:idCnpj").mask("99.999.999/9999-99");
});

function onBlurEmail() {
	if (document.getElementById('formCadEstac:idEmail').value == "") {
		$('#formCadEstac\\:groupEmail').addClass('error');
		$("#spanEmail").css("display", "block");
	} else {
		if (!isEmail(document.getElementById('formCadEstac:idEmail').value)) {
			$('#formCadEstac\\:groupEmail').addClass('error');
			$("#spanEmail").css("display", "block");
		} else {
			$('#formCadEstac\\:groupEmail').removeClass('error');
			$("#spanEmail").css("display", "none");
		}
	}

}

function onBlurCnpj() {
	if (document.getElementById('formCadEstac:idCnpj').size != 25) {
		$('#formCadEstac\\:groupCNPJ').addClass('error');
		$("#spanCnpj").css("display", "block");
	} else {
		$('#formCadEstac\\:groupCNPJ').removeClass('error');
		$("#spanCnpj").css("display", "none");
	}
}

function onBlurSenha() {
	if (document.getElementById('formCadEstac:idSenha').value == "") {
		$('#formCadEstac\\:groupSenha').addClass('error');
		$("#spanSenha").css("display", "block");
	} else {
		$('#formCadEstac\\:groupSenha').removeClass('error');
		$("#spanSenha").css("display", "none");
	}
}

function isEmail(pVal) {
	reEmail = /^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6}$/;
	return reEmail.test(pVal);
}