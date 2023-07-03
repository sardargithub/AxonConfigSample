package AxonConfigurator.Simulationcreations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploadconcept 
{
public static WebDriver driver;
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	/*
	 * DesiredCapabilities caps = DesiredCapabilities.chrome();
	 * 
	 * caps.setCapability(ChromeOptions.CAPABILITY, options);
	 * caps.setCapability("acceptInsecureCerts", caps);
	 */
	 options.addArguments("--remote-allow-origins=*"); 
	driver = new ChromeDriver(options);
	 driver.get("http://axon2-rc.eastus.cloudapp.azure.com/");
	
}
}
