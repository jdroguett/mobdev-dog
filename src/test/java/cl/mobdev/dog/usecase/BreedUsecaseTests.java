package cl.mobdev.dog.usecase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.mobdev.dog.model.Breed;
import cl.mobdev.dog.service.BreedService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BreedUsecaseTests {
		
	@Mock
	private BreedService breedService;
	
	@Autowired
	private BreedUsecase usecase;
	
	@BeforeEach
    public void setup(){
      usecase = new BreedUsecase(breedService);
    }
	
	@Test
	void shoudGetBreed() {
		
		List<String> images = new ArrayList<String>(Arrays.asList("image1", "image2", "image3"));
		List<String> subbreeds = new ArrayList<String>(Arrays.asList("subbreed1", "subbreed2", "subbreed3")); 
				
		Mockito.when(breedService.getImagesByBreed("miraza")).thenReturn(images);
		Mockito.when(breedService.getSubBreedsByBreed("miraza")).thenReturn(subbreeds);

		Breed breed = usecase.getBreed("miraza");
	
		Assert.assertEquals(breed.getBreed(), "miraza");
		Assert.assertEquals(breed.getSubBreeds().get(0), "subbreed1");
		Assert.assertEquals(breed.getImages().get(0), "image1");
	}
	
	

}
