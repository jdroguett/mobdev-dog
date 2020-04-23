package cl.mobdev.dog.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cl.mobdev.dog.model.Breed;
import cl.mobdev.dog.service.BreedService;

@Service
public class BreedUsecase {
	@Autowired
	private BreedService service;
	
	@Value("${urlEndpoint}")
    private String urlEndpoint;
	
	
	public BreedUsecase(BreedService service) {
		super();
		this.service = service;
	}

	/**
	 * Retorna un breed
	 * @param breedName
	 * @return
	 */
	public Breed getBreed(String breedName) {
		List<String> images = service.getImagesByBreed(breedName);
		List<String> subBreeds = service.getSubBreedsByBreed(breedName);
		Breed breed = new Breed();
		breed.setBreed(breedName);
		breed.setImages(images);
		breed.setSubBreeds(subBreeds);
		return breed;
	}

	/**
	 * Retorna una lista de Breeds
	 * @return
	 */
	public List<Breed> getBreeds() {
		List<String> breedsList = service.getAllBreeds();
		
		List<Breed> list = breedsList.stream()
					.map(e -> new Breed(e, urlEndpoint + "/breeds/" + e))
					.collect(Collectors.toList());
		return list;
	}
}
