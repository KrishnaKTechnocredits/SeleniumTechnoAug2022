package saroj.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.testng.internal.ant.AntReporterConfig.Property;

public class PropertyFilesReader {
	Properties prop;

	public PropertyFilesReader(String filePath) {
		prop = new Properties();
		try {
			File file = new File(filePath);
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
