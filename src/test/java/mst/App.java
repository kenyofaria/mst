package mst;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class App {

	@Test
	public void main() throws MalformedURLException {
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		File app = new File("/Users/kenyo/Documents/default-workspace/mst/src/test/resources/app-debug.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	
		AppiumDriver appiumDriver = new AppiumDriver(url, capabilities);
		
		MobileElement login = (MobileElement) appiumDriver.findElement(By.id("br.mobile.software.testing:id/login_input"));
		MobileElement senha = (MobileElement) appiumDriver.findElement(By.id("br.mobile.software.testing:id/senha_input"));
		
		login.setValue("kenyo");
		senha.setValue("123");
		
		MobileElement botao = (MobileElement) appiumDriver.findElement(By.id("br.mobile.software.testing:id/btn_login"));
		botao.click();
		
		List<MobileElement> itens = appiumDriver.findElements(By.id("br.mobile.software.testing:id/title"));
		
		assertEquals("gabriel's inferno part iii", itens.get(0).getText().toLowerCase());
		
	
	}
}
