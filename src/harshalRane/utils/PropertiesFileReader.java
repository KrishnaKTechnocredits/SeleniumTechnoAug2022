package harshalRane.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	Properties prop;

	public PropertiesFileReader(String filePath) {
		prop = new Properties(); // to read Properties file keys create object of properties
		try {
			File file = new File(filePath); // path of file
			System.out.println(file.exists());
			FileInputStream input = new FileInputStream(file); // read file
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
