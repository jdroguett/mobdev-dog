package cl.mobdev.dog.model;

public class Config {
	
	private String url;

	public Config() {
	}
	
	public Config(String url) {
		this.url = url;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}