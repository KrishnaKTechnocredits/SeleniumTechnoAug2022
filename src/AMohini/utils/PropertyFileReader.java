package AMohini.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
		Properties property; //The Properties can be saved to a streamor loaded from a stream. Each key and its corresponding value inthe property list is a string. 
		
		public PropertyFileReader(String filePath) {
			File file = new File(filePath);
			
			try {
				FileInputStream input = new FileInputStream(file);
				property = new Properties();
				property.load(input);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String getValueForKey(String key) {
			return property.getProperty(key);
		
		
	}

}
