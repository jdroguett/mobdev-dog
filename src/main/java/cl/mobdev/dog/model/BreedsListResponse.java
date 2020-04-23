package cl.mobdev.dog.model;

import java.util.ArrayList;
import java.util.List;

public class BreedsListResponse {
	private List<String> breeds;

	public BreedsListResponse() {
		this.breeds = new ArrayList<>();
	}

	public List<String> getBreeds() {
		return breeds;
	}

	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}
}
