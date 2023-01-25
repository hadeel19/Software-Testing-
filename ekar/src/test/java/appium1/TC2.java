package appium1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TC2 {
	@Test
	public void test2() throws InterruptedException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		File app = new File("ekar-app-demo.apk");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "hadeelemu");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability("autoAcceptAlerts", true);
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(AppiumBy.accessibilityId("Google Map"));
		driver.findElement(AppiumBy.className("android.view.View"));
		driver.findElement(
				By.xpath("//android.view.View[@content-desc='1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA. ']"))
				.click();
		// front img
		driver.findElement(By.id("in.testdemo.map:id/front_img")).click();

		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		driver.findElements(AppiumBy.xpath("//*[@resource-id='com.google.android.apps.photos:id/image']")).get(1)
				.click();
		driver.findElement(AppiumBy.accessibilityId("Photo taken on Jan 25, 2023 3:44:20 AM")).click();

		// back img
		driver.findElement(By.id("in.testdemo.map:id/back_img")).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.xpath("//*[@resource-id='com.google.android.apps.photos:id/image']")).get(1)
				.click();
		driver.findElement(AppiumBy.accessibilityId("Photo taken on Jan 25, 2023 3:44:20 AM")).click();


		
		// add comment and click next 
		driver.findElement(By.id("in.testdemo.map:id/cmd_txt")).sendKeys("TESTER IS BESTER ");
		driver.findElement(By.id("in.testdemo.map:id/next_btn")).click();
	}
}
