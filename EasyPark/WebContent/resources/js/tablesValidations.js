$(function() {
	$("#form\\:exibeTelefones").show();
	$("#form\\:exibeVagasValores").show();
	$("#form\\:exibeHorarioFuncionamento").show();
	RefreshTable();
});

function RefreshTable() {
	if ($("#form\\:exibeTelefones  tr").length <= 1
			|| $("#form\\:exibeTelefones  tr:last td").text() == "") {
		$("#form\\:exibeTelefones").hide();
	} else {
		$("#form\\:exibeTelefones").show();
	}

	if ($("#form\\:exibeVagasValores tr").length <= 1
			|| $("#form\\:exibeVagasValores tr:last td").text() == "") {
		$("#form\\:exibeVagasValores").hide();
	} else {
		$("#form\\:exibeVagasValores").show();
	}

	if ($("#form\\:exibeHorarioFuncionamento tr").length <= 1
			|| $("#form\\:exibeHorarioFuncionamento tr:last td").text() == "") {
		$("#form\\:exibeHorarioFuncionamento").hide();
	} else {
		$("#form\\:exibeHorarioFuncionamento").show();
	}

}