package test;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
	
	@DataProvider
	public static Object[][] getData(){
		
		Object[][] data=new Object[3][2];//[row][col].row=no. of times to execute test. col=no. of parameters.
		
		data[0][0]=1;
		data[0][1]=4;
		
		data[1][0]=6;
		data[1][1]=2;
		
		data[2][0]=32;
		data[2][1]=21;
		
		return data;
	}
}
