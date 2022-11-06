package gauravSahu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyFileReader {

		Properties prop;

		public MyFileReader(String filePath) {
			prop = new Properties();
			try {
				File file = new File(filePath);
				FileInputStream input = new FileInputStream(file);
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
