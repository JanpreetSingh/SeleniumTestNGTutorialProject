package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups={"grpcommon"})
public class LoginTest {
	
	@Parameters("firstName")
	@Test(groups={"grp1"})
	public void testLogin(@Optional("james") String bond) {
	
	String actual=bond;
	String expected="Hello World";
	System.out.println(bond);
	Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider="getData", dataProviderClass=StaticDataProvider.class, dependsOnMethods={"testLogin"}, groups={"grp2"})
	public void testLogin2(int a, int b) {
	
	
	Assert.assertTrue(a>b, a+" :A not greater than B: "+b);
	}
	
	@Test(dependsOnMethods={"testLogin2"})
	public void testLogin3() {
	
	int a=3;
	int b=2;
	
	Assert.assertFalse(a<b, a+" :a not greater than b: "+b);
	}
		
}

