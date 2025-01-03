package AsmaZafar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest{
	@Test
	public void FillForm()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Asma Zafar");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		/*int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++)
		{
			String productName=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
			
	    }*/
		// Find all product names
		List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

		// Iterate through the product list
		for (int i = 0; i < products.size(); i++) {
		    // Get the text of the current product
		    String productName = products.get(i).getText();

		    // Check if the product name matches "Jordan 6 Rings"
		    if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
		        // Click on the "Add to Cart" button for the matching product
		        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		        break; // Exit the loop as the product is found
		    }
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();	
		/*try {
		    Thread.sleep(3000); // Pause execution for 3 seconds
		} catch (InterruptedException e) {
		    e.printStackTrace(); // Handle the exception
		}*/
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String LastPageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(LastPageProduct, "Jordan 6 Rings");
	}

}
