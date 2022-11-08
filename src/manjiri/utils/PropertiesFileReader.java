package manjiri.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	Properties prop;
	
	public PropertiesFileReader(String filepath){
		prop = new Properties();
		try {
			File file = new File(filepath);
			FileInputStream fstream = new FileInputStream(file);
			prop.load(fstream);
		}
		catch (FileNotFoundException fe){
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
}

	
