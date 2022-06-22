package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class textReader {
	private Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();	
		try {
			//String projectPath = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream("F:\\acceleration\\workspace\\cucumberActiTime\\src\\test\\resources\\configerdFiles\\textfiles\\propfile.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
