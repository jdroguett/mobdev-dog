package cl.mobdev.dog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent=true) @Getter
public class Config {
	@JsonProperty
	private @NonNull String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
