package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of Generic method to read the data from
 * property file
 * @author anil mittanosala
 *
 */
public class PropertyFileUtilities {
	/**
	 * This method will read the data from property file and return the value 
	 * to the caller
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	

}
