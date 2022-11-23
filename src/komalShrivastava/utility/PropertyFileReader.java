package komalShrivastava.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	Properties prop;
	
	public PropertyFileReader() {
		File file = new File("src\\komalShrivastava\\properties\\login.properties");
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(file);
			prop.load(fs);
		} catch (IOException ie) {
			System.out.println("Incorrect Property File");
		}
	}

	public String getPropertyValue(String key){
		return prop.getProperty(key);
	}
	
}
