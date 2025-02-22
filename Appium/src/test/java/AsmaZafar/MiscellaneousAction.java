package AsmaZafar;

import static org.testng.Assert.assertEquals;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousAction extends BaseTest {
	@Test
	public void Miscellaneous() throws MalformedURLException, URISyntaxException, InterruptedException 
	{
		//adb shell dumpsys window |find "mCurrentFocus"      run this command in terminal and 
		
		//App package and app activity
		Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation LandScape=new DeviceRotation(0,0,180);
		driver.rotate(LandScape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Title=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Title, "WiFi settings");
		//Copy Paste
		//Copy to clipboard -- paste it clipboard
		driver.setClipboardText("Asma Zafar");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	

	}

}
