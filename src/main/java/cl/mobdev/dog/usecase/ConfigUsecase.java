package cl.mobdev.dog.usecase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.util.DefaultPropertiesPersister;


@Service
public class ConfigUsecase {

	public void setConfigUrl(String url) {
		try {
		     Properties props = new Properties();
		     props.setProperty("urlDog", url);
		     File f = new File("application.properties");
		     OutputStream out = new FileOutputStream( f );
		     // write into it
		     DefaultPropertiesPersister p = new DefaultPropertiesPersister();
		     p.store(props, out, "Set new url dog ceo");
		     System.setProperty("urlDog", url);
		   } catch (Exception e ) {
		    e.printStackTrace();
		   }
	}
}
