package cl.mobdev.dog.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import cl.mobdev.dog.iservice.IBreedService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Service
public class BreedService implements IBreedService {

	@Value("${urlDog}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Retorna el listado de todas las razas
	 * 
	 * @return
	 */
	@Override
	public List<String> getAllBreeds() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/json");

		String url = buildUrl("/api/breeds/list/all");

		HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);

		HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		return bodyToBreedsList(response.getBody());
	}

	/**
	 * Retona el listado de todas las imagenes de la raza
	 * 
	 * @param breed
	 * @return
	 */
	@Override
	public List<String> getImagesByBreed(String breed) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/json");

		String url = buildUrl("/api/breed/" + breed + "/images");

		HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);

		HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		return bodyToImagesList(response.getBody());

	}

	/**
	 * Retona el listado de sub razas de la raza
	 * 
	 * @param breed
	 * @return
	 */
	@Override
	public List<String> getSubBreedsByBreed(String breed) {

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/json");

		String url = buildUrl("/api/breed/" + breed + "/list");

		HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);

		HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		return bodyToSubBreedsList(response.getBody());

	}

	private List<String> bodyToBreedsList(String body) {
		List<String> list = new ArrayList<>();
		JSONObject json = new JSONObject(body);
		JSONObject msg = (JSONObject) json.get("message");
		Iterator<String> keys = msg.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			list.add(key);
		}
		return list;
	}

	private List<String> bodyToImagesList(String body) {
		List<String> list = new ArrayList<>();
		JSONObject json = new JSONObject(body);
		JSONArray arr = json.getJSONArray("message");
		for (int i = 0; i < arr.length(); i++) {
			list.add(arr.getString(i));
		}
		return list;
	}

	private List<String> bodyToSubBreedsList(String body) {
		List<String> list = new ArrayList<>();
		JSONObject json = new JSONObject(body);
		JSONArray arr = json.getJSONArray("message");
		for (int i = 0; i < arr.length(); i++) {
			list.add(arr.getString(i));
		}
		return list;
	}

	private String getUrl() {
		String urlNew = System.getProperty("urlDog");
		return urlNew != null ? urlNew : url;
	}

	private String buildUrl(String path) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl()).path(path);
		return builder.toUriString();
	}

}
