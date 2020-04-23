package cl.mobdev.dog.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Accessors(fluent=true) @Getter
public class Breed {
	@JsonProperty
	private @NonNull String breed;

	@JsonProperty
	private List<String> subBreeds;

	@JsonProperty
	private List<String> images;
	
	@JsonProperty
	private String url;
	
	public Breed() {
	}
	
	public Breed(@NonNull String breed, String url) {
		this.breed = breed;
		this.url = url;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public List<String> getSubBreeds() {
		return subBreeds;
	}

	public void setSubBreeds(List<String> subBreeds) {
		this.subBreeds = subBreeds;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}