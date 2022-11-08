package asthaSrivastava.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	Properties properties;

	public PropertiesFileReader(String filePath) {
		properties = new Properties();//object of properties file
		try {
			File file = new File(filePath);
			FileInputStream input = new FileInputStream(file); //read input file
			properties.load(input);
		} catch (FileNotFoundException e) { //if file is not found
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
