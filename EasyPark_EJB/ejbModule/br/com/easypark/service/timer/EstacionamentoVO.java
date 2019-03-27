package br.com.easypark.service.timer;

public class EstacionamentoVO {

	private String latitude;
	private String longitude;
	private DetalheEstacionamentoVO detalhes;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public DetalheEstacionamentoVO getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(DetalheEstacionamentoVO detalhes) {
		this.detalhes = detalhes;
	}

}
