package pujaSah.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	Properties prop;
	
	public PropertiesFileReader(String filePath){
		 prop = new Properties();
		try{
			File file = new File(filePath);
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}

	public String getValue(String key){
		return prop.getProperty(key);
	}
}
