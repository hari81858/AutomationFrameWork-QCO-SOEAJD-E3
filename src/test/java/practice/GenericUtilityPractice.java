package practice;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtilities pUtil=new PropertyFileUtilities();
		String value = pUtil.readDataFromPropertyFile("browser");
		System.out.println(value);
		
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Contacts", 1, 2);
		System.out.println(data);
		
		JavaUtility jUtil=new JavaUtility();
		int r = jUtil.getRandomNumber();
		System.out.println(r);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
	}

}
