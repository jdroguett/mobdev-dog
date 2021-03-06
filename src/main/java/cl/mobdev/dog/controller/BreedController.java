package cl.mobdev.dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.mobdev.dog.model.Breed;
import cl.mobdev.dog.model.Config;
import cl.mobdev.dog.usecase.BreedUsecase;
import cl.mobdev.dog.usecase.ConfigUsecase;

@RestController
public class BreedController {

	@Autowired
	private BreedUsecase breedUsecase;

	@Autowired
	private ConfigUsecase configUsecase;

	@GetMapping("/breeds")
	public List<Breed> getBreeds() {
		return breedUsecase.getBreeds();
	}

	@GetMapping("/breeds/{breedName}")
	public Breed getBreed(@PathVariable String breedName) throws Exception {
		return breedUsecase.getBreed(breedName);
	}

	/**
	 * curl --header "Content-Type: application/json" --request POST --data
	 * '{"url":"https://dog.ceo"}' \ http://localhost:8080/breeds/config
	 * 
	 * @param config
	 * @return
	 */
	@PostMapping("/breeds/config")
	public ResponseEntity<?> setConfig(@RequestBody Config config) {
		configUsecase.setConfigUrl(config.getUrl());
		return new ResponseEntity<>("Config Ok", HttpStatus.OK);
	}
}