var geocoder;
var map;
var marker;
var autocomplete;
var circle;
markers = [];

function initialize(lat, long) {
	userLatLng = new google.maps.LatLng(lat, long);
	range = $('#apresentacao input[name=txtLatMax]:checked').val();
	range = parseInt(range);
	var mapOptions = {
		center : userLatLng,
		zoom : 15,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("mapa"), mapOptions);

	geocoder = new google.maps.Geocoder();

	// preenche o circulo no mapa
	buscaMapasAjax(range, userLatLng);
	var inputField = document.getElementById('txtEndereco');
	if (inputField == null) {
		inputField = document.getElementById('form:txtEndereco');
	}
	autocomplete = new google.maps.places.Autocomplete(inputField);
	google.maps.event.addListener(autocomplete, 'place_changed', function() {
		var place = autocomplete.getPlace();
		if (place.geometry != undefined) {
			var location = place.geometry.location;
			map.panTo(location);
			map.setZoom(15);
			map.setCenter(place.geometry.location);
			userLatLng = new google.maps.LatLng(place.geometry.location.lat(),place.geometry.location.lng());
			$('.classLatitude').val(place.geometry.location.lat());
			$('.classLongitude').val(place.geometry.location.lng());
			if (range != undefined){
				if (!isNaN(range)) {
					createCircle(map,range);
				}
			}
		}
	});
	find_closest_marker(userLatLng, parseInt($('input[name=txtLatMax]:radio').val()));
	if (range != undefined) {
		if (isNaN(range)) {
			range = 1000;
		}
		createCircle(map, range);
	}
}
function createCircle(map, range) {
	console.log('Criando ');
	if (circle != undefined) {
		console.log("Removendo Circulo Antigo");
		circle.setMap(null);
	}
	if (!isNaN(userLatLng.lat()) && !isNaN(userLatLng.lng()) ) {
		circle = new google.maps.Circle({
			center : userLatLng,
			radius : range,
			map : map,
			fillColor : '#FFFF00',
			fillOpacity : 0.2,
			strokeColor : '#FFFF00',
			strokeOpacity : 1.0
		});
		map.fitBounds(circle.getBounds());
	}
}

function createMarker(){
	address = $('.valorEndereco').val() + ','+ $('.numeroEndereco').val();
	geocoder.geocode({'address' : address},function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					map.setCenter(results[0].geometry.location);
					createCircle(map, 1000);
					userLatLng = new google.maps.LatLng(results[0].geometry.location.lat(),results[0].geometry.location.lng());
					if (marker != null) {
						marker.setMap(null);
					}
					marker = new google.maps.Marker({
						position: userLatLng,
						map: map
					});
				} else {
					alert("Não Foi Possivel buscar a localização: "
							+ status);
				}
			});
	
}

function exibeMapa(lat, long) {

	initialize(lat, long);
}

function deleteOverlays() {
	clearOverlays();
	markers = [];
}

function clearOverlays() {
	setAllMap();
}

function setAllMap() {
	for ( var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
}
function buscarEstacionamentos() {
	address = $('#txtEndereco').val();
	geocoder
			.geocode(
					{
						'address' : address
					},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							map.setCenter(results[0].geometry.location);
							userLatLng = new google.maps.LatLng(
									results[0].geometry.location.lat,
									results[0].geometry.location.lng);
							createCircle(map, parseInt($(
									'input[name=txtLatMax]:radio').val()));
						} else {
							alert("Não Foi Possivel buscar a localização: "
									+ status);
						}
					});
}

function buscaMapasAjax(range, userLatLng) {
	$.getJSON('http://localhost:8080/EasyPark/rest/estacionamentoService', function(data) {
		// percorre o array montado
		$.each(data, function(key, val) {
			// cria os markers com base nos contidos no json.
//			alert(val.detalhes.nome);
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(val.latitude, val.longitude),
				map : map,
				draggable : false
			});
			var infowindow = new google.maps.InfoWindow({
				content : "<b>Estacionamento:</b> " + val.detalhes.nome + "<br/><b>Vlr. Hora: </b>"+val.detalhes.precos.hora+"<br/><b>Horário: </b>" + val.detalhes.horarios.diaUtil
			});

			google.maps.event.addListener(marker, 'click', function() {
				infowindow.open(map, marker);
			});
			markers.push(marker);
		});
		find_closest_marker(userLatLng, range);
	});
}

function rad(x) {
	return x * Math.PI / 180;
}
function find_closest_marker(latLng, raioAlcance) {
	var lat = latLng.lat();
	var lng = latLng.lng();
	var R = 6371; // radius of earth in km
	var distances = [];
	var closest = -1;
	for ( var i = 0; i < markers.length; i++) {
		var mlat = markers[i].position.lat();
		var mlng = markers[i].position.lng();
		var dLat = rad(mlat - lat);
		var dLong = rad(mlng - lng);
		var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(rad(lat))
				* Math.cos(rad(lat)) * Math.sin(dLong / 2)
				* Math.sin(dLong / 2);
		var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		var d = R * c;
		distances[i] = d;
		var range = (raioAlcance / 100) * 0.10;
		if (closest == -1 || d < range) {
			// alert("entrou a primeira vez para setar o centro")
			closest = i;
		} else {
			// alert(" distances[closest]: " + distances[closest] + " minha
			// posição: " + d)
			markers[i].setVisible(false);
		}
	}

}
