package cl.mobdev.dog.iservice;

import java.util.List;

public interface IBreedService {

	/**
	 * Retorna el listado de todas las razas
	 * 
	 * @return
	 */
	List<String> getAllBreeds();

	/**
	 * Retona el listado de todas las imagenes de la raza
	 * 
	 * @param breed
	 * @return
	 */
	List<String> getImagesByBreed(String breed);

	/**
	 * Retona el listado de sub razas de la raza
	 * 
	 * @param breed
	 * @return
	 */
	List<String> getSubBreedsByBreed(String breed);

}