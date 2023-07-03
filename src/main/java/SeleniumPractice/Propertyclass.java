package SeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Run XML file so it will work
public class Propertyclass 
{
public static WebDriver driver;
@Parameters({"t1","t2"})
@Test
public void UsingPropertyFile(String Username,String password) throws IOException
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(options);
	FileInputStream fis=new FileInputStream("..\\Simulationcreations\\src\\main\\java\\SeleniumPractice\\Propertyfile");
	Properties p1=new Properties();
	p1.load(fis);
	driver.get("https://qa-view.prebill-kdvlaw.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath(p1.getProperty("UNTF"))).sendKeys(Username);
	driver.findElement(By.xpath(p1.getProperty("PWTF"))).sendKeys(password);
	driver.findElement(By.xpath(p1.getProperty("Login"))).click();
}
}
