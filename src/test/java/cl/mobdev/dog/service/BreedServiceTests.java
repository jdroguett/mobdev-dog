package cl.mobdev.dog.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.mobdev.dog.iservice.IBreedService;

@SpringBootTest
class BreedServiceTests extends BaseTest{
	@Autowired
	private IBreedService service;
	
	@BeforeEach
	void setUrlTest() {
		System.setProperty("urlDog", "http://localhost:7000");
		System.setProperty("portDog", "7000");
		
	}
	 
	@Test
	void shouldGetAllBreeds() {
		List<String> list = service.getAllBreeds();
		Assert.assertEquals(list.get(0), "pyrenees");
		Assert.assertEquals(list.get(1), "affenpinscher");
	}
	
	@Test
	void shouldGetImagesList() {
		List<String> list = service.getImagesByBreed("miraza");		
		Assert.assertEquals(list.get(0), "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg");
		Assert.assertEquals(list.get(1), "https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg");
	}
	
	@Test
	void shouldGetSubBreedsList() {
		List<String> list = service.getSubBreedsByBreed("miraza");
		Assert.assertEquals(list.get(0), "afghan");
		Assert.assertEquals(list.get(1), "basset");
	}	
}