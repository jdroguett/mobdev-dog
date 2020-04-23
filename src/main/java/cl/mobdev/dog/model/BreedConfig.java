package cl.mobdev.dog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent=true) @Getter
public class BreedConfig {
	@JsonProperty
	private @NonNull String breed;
	@JsonProperty
	private @NonNull String url;
	
	public BreedConfig(@NonNull String breed, @NonNull String url) {
		super();
		this.breed = breed;
		this.url = url;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
}
