package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(dataProvider = "getData")
	public void createSample(String name , int id)
	{
		System.out.println("Name is - "+name+" and id is - "+id);
		System.out.println("---------------------------------");
	}
	
	//Create Customer- Create emp data - DataProvider
	
	@DataProvider
	public Object[][] getData()
	{
		//3row - 3data sets and each has 2 columns - 2 infomation
		Object[][] data = new Object[3][2];
		
		//1st Data set
		data[0][0] = "Chaitra";
		data[0][1] = 12;
		
		//2nd Data set
		data[1][0] = "Sam";
		data[1][1] = 14;
		
		//3rd Data set
		data[2][0] = "Albert";
		data[2][1] = 8;
		
		
		return data;
	}
	

}
