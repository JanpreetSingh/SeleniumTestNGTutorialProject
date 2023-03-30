package test;


import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void checkProductAvailability() {
		
		System.out.println("Product Available?");
	}
	
	@Test(dependsOnMethods={"checkProductAvailability"})
	public void testSellingProduct() {
		
		System.out.println("Selling the Product");
	}
	
	@Test(dependsOnMethods={"checkProductAvailability", "testSellingProduct"})
	public void emptyCart() {
	
	System.out.println("Empty the cart");
	}
	
		
	
}
