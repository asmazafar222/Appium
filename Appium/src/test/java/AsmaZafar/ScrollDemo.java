package AsmaZafar;

import static org.testng.Assert.assertEquals;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException 
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		// No prior idea
		scrollToEndAction();
		
		
	

	}

}
