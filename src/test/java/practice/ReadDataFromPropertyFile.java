package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws Throwable {
		
		//Read the documents in the java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Create object of property class
		
		Properties p=new Properties();
		
		//Load the file into properties class
		p.load(fis);
		
		//Provide key and get the value
		
		String value = p.getProperty("url");
		System.out.println(value);
		
		
		       
		
	}

}
