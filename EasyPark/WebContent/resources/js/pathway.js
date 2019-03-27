$('pathWay #tabs2 a').click(function(e) {
	$(this).tab('show');
	e.prev();
	entDefault();
});
function next() {
	if (valida()) {
		$('div .active').removeClass('active').next().addClass('active');
	}
}

function prev() {
	$('div .active').removeClass('active').prev().addClass('active');
}

$('a[data-toggle="tab"]').on('shown', function(e) {
	e.target; // tab ativada
	e.relatedTarget; // tab anterior
});