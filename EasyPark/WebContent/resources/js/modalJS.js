$(function() {
	$('#form\\:horarioInicial').timepicker();
	$('#form\\:horarioFinal').timepicker();
	$('#form\\:modalVaga').on("click", function() {
		$('#modalVagaEValor').modal('show');
	});
	$('#form\\:modalTelefone').on("click", function() {
		$('#modalDetail').modal('show');
	});
	$('#form\\:modalNovoFunc').on("click", function() {
		$('#modalFuncionamento').modal('show');
	});
	$('#form\\:addTelefone').on("click", function() {
		$('#modalDetail').modal('hide');
	});
	$('#form\\:incluirHorarioFuncionamento').on('click', function() {
		$('#modalFuncionamento').modal('hide');
	});
	$('#form\\:incluirVagaEValor').on('click', function() {
		$('#modalVagaEValor').modal('hide');
	});
});

function abreModalValores() {
	$('#modalVagaEValor').modal('show');
}
function abreModalTelefone() {
	limpaCamposTelefone();
	$('#modalDetail').modal('show');
}
function abreModalFuncionamento() {
	$('#modalFuncionamento').modal('show');
}
