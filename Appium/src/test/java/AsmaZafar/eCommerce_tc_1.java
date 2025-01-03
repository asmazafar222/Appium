package AsmaZafar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{
	@Test
	public void FillForm()
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Asma Zafar");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Thread.sleep(3000);
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
		//Assert.assertEquals(toastMessage,"Please enter your name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	
	}

}
