package AsmaZafar;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBsics extends BaseTest {
	@Test
	public void WifiSettings() throws MalformedURLException, URISyntaxException 
	{
		//CofigureAppium();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//tearDown();
		//tagName[@attribute='value']
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Title=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Title, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Asma Zafar");
		driver.findElement(By.id("android:id/button1")).click();
	}

}
