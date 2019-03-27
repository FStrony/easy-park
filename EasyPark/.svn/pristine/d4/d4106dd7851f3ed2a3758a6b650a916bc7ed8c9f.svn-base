function valida() {
	var path = $('div.active').attr('id');
	var retorno = true;
	if (path == 'tab1') {
		if (document.getElementById('form:idNomeEstac').value == "") {
			$('#form\\:groupNome').addClass('error');
			$("#spanNome").css("display", "block");
			retorno = false;
		}
		if (document.getElementById('form:idSeguro').value == "") {
			$('#form\\:groupSeguro').addClass('error');
			$("#spanSeguro").css("display", "block");
			retorno = false;
		}

		if (document.getElementById('form:idEmail').value != "") {
			if (!isEmail(document.getElementById('form:idEmail').value)) {
				$('#form\\:groupEmail').addClass('error');
				$("#spanEmail").css("display", "block");
				retorno = false;
			}
		}

	} else if (path == 'tab2') {
		if (document.getElementById('form:txtEndereco').value == "") {
			$('#form\\:groupEndereco').addClass('error');
			$("#spanEndereco").css("display", "block");
			retorno = false;
		}
		if (document.getElementById('form:idNumero').value == "") {
			$('#form\\:groupNumero').addClass('error');
			$("#spanNumero").css("display", "block");
			retorno = false;
		}

	} else if (path == 'tab3') {
		if ($("#form\\:exibeVagasValores  tr").length <= 1
				|| $("#form\\:exibeVagasValores  tr:last td").text() == "") {
			retorno = false;
		}
	} else if (path == 'tab4') {
		if ($("#form\\:exibeHorarioFuncionamento  tr").length <= 1
				|| $("#form\\:exibeHorarioFuncionamento  tr:last td").text() == "") {
			retorno = false;
		}
	}
	return retorno;
}

// VALIDAÇÕES FINAIS ONCLICK
function validaTelefone() {
	if (document.getElementById('form:idTipoTelefone').value == 0) {
		$('#form\\:groupTipoTelefone').addClass('error');
		$("#spanTipoTelefone").css("display", "block");
	}

	if (document.getElementById('form:idNumeroDDD').value == ""
			|| document.getElementById('form:idNumTelefone').value == "") {
		$('#form\\:groupTelefone').addClass('error');
		$("#spanTelefone").css("display", "block");
	}
}

function validaVagasValores() {

	if (document.getElementById('form:idTipoVeiculo').value == 0) {
		$('#form\\:groupTipoVeiculo').addClass('error');
		$("#spanTipoVeiculo").css("display", "block");
	}
	if (document.getElementById('form:idQuantVagas').value == "") {
		$('#form\\:groupQuantidade').addClass('error');
		$("#spanQuantidade").css("display", "block");
	}

	if (document.getElementById('form:idValorDiaria').value == "") {
		$('#form\\:groupDiaria').addClass('error');
		$("#spanValorDiario").css("display", "block");
	}

	if (document.getElementById('form:idValorMensal').value == "") {
		$('#form\\:groupMensal').addClass('error');
		$("#spanValorMensal").css("display", "block");
	}

	if (document.getElementById('form:idValorSemestral').value == "") {
		$('#form\\:groupSemestral').addClass('error');
		$("#spanValorSemestral").css("display", "block");
	}

}

function validaFuncionamento() {
	if (document.getElementById('form:idSelecioneTipoDia').value == 0) {
		$('#form\\:gropDia').addClass('error');
		$("#spanDia").css("display", "block");
	}

	if (document.getElementById('form:horarioInicial').value == "") {
		$('#form\\:groupAbertura').addClass('error');
		$("#spanAbertura").css("display", "block");
	}
	if (document.getElementById('form:horarioFinal').value == "") {
		$('#form\\:groupFechamento').addClass('error');
		$("#spanFechamento").css("display", "block");
	}

}

// ONCHANGE

function onChangeTipoTelefone() {
	if (document.getElementById('form:idTipoTelefone').value == 0) {
		$('#form\\:groupTipoTelefone').addClass('error');
		$("#spanTipoTelefone").css("display", "block");
	} else {
		$('#form\\:groupTipoTelefone').removeClass('error');
		$("#spanTipoTelefone").css("display", "none");
	}
}

function onChangeSeguro() {
	if (document.getElementById('form:idSeguro').value == 0) {
		$('#form\\:groupSeguro').addClass('error');
		$("#spanSeguro").css("display", "block");
	} else {
		$('#form\\:groupSeguro').removeClass('error');
		$("#spanSeguro").css("display", "none");
	}
}

function onChangeTipoVeiculo() {
	if (document.getElementById('form:idTipoVeiculo').value == 0) {
		$('#form\\:groupTipoVeiculo').addClass('error');
		$("#spanTipoVeiculo").css("display", "block");
	} else {
		$('#form\\:groupTipoVeiculo').removeClass('error');
		$("#spanTipoVeiculo").css("display", "none");
	}
}

function onChangeDia() {
	if (document.getElementById('form:idSelecioneTipoDia').value == 0) {
		$('#form\\:gropDia').addClass('error');
		$("#spanDia").css("display", "block");
	} else {
		$('#form\\:gropDia').removeClass('error');
		$("#spanDia").css("display", "none");
	}
}

// ONBLUR
function onBlurEndereco() {
	if (document.getElementById('form:txtEndereco').value == "") {
		$('#form\\:groupEndereco').addClass('error');
		$("#spanEndereco").css("display", "block");
	} else {
		$('#form\\:groupEndereco').removeClass('error');
		$("#spanEndereco").css("display", "none");
	}
}

function onBlurNumero() {
	if (document.getElementById('form:idNumero').value == "") {
		$('#form\\:groupNumero').addClass('error');
		$("#spanNumero").css("display", "block");
	} else {
		$('#form\\:groupNumero').removeClass('error');
		$("#spanNumero").css("display", "none");
	}
}

function onBlurQuantidade() {
	if (document.getElementById('form:idQuantVagas').value == "") {
		$('#form\\:groupQuantidade').addClass('error');
		$("#spanQuantidade").css("display", "block");
	} else {
		$('#form\\:groupQuantidade').removeClass('error');
		$("#spanQuantidade").css("display", "none");
	}
}

function onBlurValorDiario() {
	if (document.getElementById('form:idValorDiaria').value == "") {
		$('#form\\:groupDiaria').addClass('error');
		$("#spanValorDiario").css("display", "block");
	} else {
		$('#form\\:groupDiaria').removeClass('error');
		$("#spanValorDiario").css("display", "none");
	}
}

function onBlurValorMensal() {
	if (document.getElementById('form:idValorMensal').value == "") {
		$('#form\\:groupMensal').addClass('error');
		$("#spanValorMensal").css("display", "block");
	} else {
		$('#form\\:groupMensal').removeClass('error');
		$("#spanValorMensal").css("display", "none");
	}
}

function onBlurValorSemestral() {
	if (document.getElementById('form:idValorSemestral').value == "") {
		$('#form\\:groupSemestral').addClass('error');
		$("#spanValorSemestral").css("display", "block");
	} else {
		$('#form\\:groupSemestral').removeClass('error');
		$("#spanValorSemestral").css("display", "none");
	}
}

function onBlurNome() {
	if (document.getElementById('form:idNomeEstac').value == "") {
		$('#form\\:groupNome').addClass('error');
		$("#spanNome").css("display", "block");
	} else {
		$('#form\\:groupNome').removeClass('error');
		$("#spanNome").css("display", "none");
	}
}

function onBlurTelefoneDD() {
	if (document.getElementById('form:idNumeroDDD').value == ""
			|| document.getElementById('form:idNumTelefone').value == "") {
		$('#form\\:groupTelefone').addClass('error');
		$("#spanTelefone").css("display", "block");
	} else {
		$('#form\\:groupTelefone').removeClass('error');
		$("#spanTelefone").css("display", "none");
	}
}

function onBlurHorarioAbertura() {
	if (document.getElementById('form:horarioInicial').value == "") {
		$('#form\\:groupAbertura').addClass('error');
		$("#spanAbertura").css("display", "block");
	} else {
		$('#form\\:groupAbertura').removeClass('error');
		$("#spanAbertura").css("display", "none");
	}
}

function onBlurHorarioFechamento() {
	if (document.getElementById('form:horarioFinal').value == "") {
		$('#form\\:groupFechamento').addClass('error');
		$("#spanFechamento").css("display", "block");
	} else {
		$('#form\\:groupFechamento').removeClass('error');
		$("#spanFechamento").css("display", "none");
	}
}

function onBlurEmail() {
	if (document.getElementById('form:idEmail').value != "") {
		if (!isEmail(document.getElementById('form:idEmail').value)) {
			$('#form\\:groupEmail').addClass('error');
			$("#spanEmail").css("display", "block");
		} else {
			$('#form\\:groupEmail').removeClass('error');
			$("#spanEmail").css("display", "none");
		}

	} else {
		$('#form\\:groupEmail').removeClass('error');
		$("#spanEmail").css("display", "none");
	}
}

// HELPERS

function isEmail(pVal) {
	reEmail = /^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6}$/;
	return reEmail.test(pVal);
}

function limpaCamposTelefone() {
	$("#form\\:idNumeroDDD").val("");
	$("#form\\:idNumTelefone").val("");
	$("#form\\:idTipoTelefone").val("");
	$('#form\\:idTipoTelefone option').each(function() {
		if ($(this).val() == '0') {
			$(this).attr('selected', true);
		}
	});
}