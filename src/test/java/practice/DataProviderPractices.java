package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractices {
	
	@Test(dataProvider = "getData")
	public void addProductFromCart(String Name,int Price,int quty,String model)
	{
		System.out.println("Phone name is "+Name+"Price is "+Price+"Quntity is "+quty+"Model is "+model);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object [][] data=new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]=10000;
		data[0][2]=20;
		data[0][3]="A80";
		
		data[1][0]="Iphone";
		data[1][1]=100000;
		data[1][2]=16;
		data[1][3]="i15";
		
		data[2][0]="Nokia";
		data[2][1]=8000;
		data[2][2]=4;
		data[2][3]="n12";
		
		return data;
	}
}
