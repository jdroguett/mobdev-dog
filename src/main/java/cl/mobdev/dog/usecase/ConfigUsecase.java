package cl.mobdev.dog.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mobdev.dog.iservice.IConfigService;

@Service
public class ConfigUsecase {
	
	@Autowired
	private IConfigService configService;

	public void setConfigUrl(String url) {
		configService.setConfigUrl(url);
	}
}
