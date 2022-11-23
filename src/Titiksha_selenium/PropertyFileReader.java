package Titiksha_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
Properties prop;
public PropertyFileReader(String filePath) {
	prop=new Properties() ;//creating object to read property file
	File file=new File(filePath) ;
	try {
		FileInputStream input=new FileInputStream(file);//to read file we created fileInputStreamFile object
		prop = new Properties();
		prop.load(input);}
	catch(FileNotFoundException e) {
		e.printStackTrace();}
	catch(IOException e) {
		e.printStackTrace();}}
	public String getvalue(String key) {
	return prop.getProperty(key);}
}
