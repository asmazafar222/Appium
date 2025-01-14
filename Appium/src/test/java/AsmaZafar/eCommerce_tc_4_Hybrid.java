package AsmaZafar;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest{
	@Test
	public void FillForm()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Asma Zafar");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
		driver.findElements(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();	
		try {
		    Thread.sleep(3000); // Pause execution for 3 seconds
		} catch (InterruptedException e) {
		    e.printStackTrace(); // Handle the exception
		}
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List <WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalsum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=productPrices.get(i).getText();
			Double price=getFormattedAmount(amountString);
			totalsum=totalsum+price;
		}
		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double getFormattedSum= getFormattedAmount(displaySum);
		Assert.assertEquals(totalsum, getFormattedSum);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		try {
		    Thread.sleep(5000); // Pause execution for 3 seconds
		} catch (InterruptedException e) {
		    e.printStackTrace(); // Handle the exception
		};		
		Set<String> contextHandles = driver.getContextHandles();
		for(String contextName:contextHandles)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("rahul shetty academy");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	
	}
	
	//driver.getContextHandles();
	


}
