package SeleniumPractice;

import java.time.Duration;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectrepositorywithXMLfile 
{
public static WebDriver driver;
@Parameters({"t1","t2"})
@Test
public void UsingXMLfile(String username,String password) throws DocumentException
{
WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
driver=new ChromeDriver();
SAXReader sr=new SAXReader();
Document dc=sr.read("../Simulationcreations/src/main/java/SeleniumPractice/ObjectwithXML.xml");
driver.get("https://qa-view.prebill-kdvlaw.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath(dc.selectSingleNode("//login/UNTF").getText())).sendKeys(username);
driver.findElement(By.xpath(dc.selectSingleNode("//login/PWTF").getText())).sendKeys(password);
driver.findElement(By.xpath(dc.selectSingleNode("//login/Loginbutton").getText())).click();

}
}
