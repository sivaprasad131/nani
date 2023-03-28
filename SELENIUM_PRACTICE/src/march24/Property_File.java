package march24;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Property_File {

	WebDriver driver;
	
	Properties con;
	@BeforeTest
	public void setup() throws Throwable
	
	{
		
	con = new Properties();
	con.load(new FileInputStream("OR.properties"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(con.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	
	
	@Test
	public void verifyLogin()
	{
		driver.findElement(By.xpath(con.getProperty("objrest"))).click();
		driver.findElement(By.xpath(con.getProperty("objuser"))).sendKeys("admin");
		driver.findElement(By.xpath(con.getProperty("objpwd"))).sendKeys("master");
	    driver.findElement(By.xpath(con.getProperty("objloginbtn"))).click();
	String Expected_Title = "Dashboard « Stock Accounting";
	String Actual_Title = driver.getTitle();
	if(Expected_Title.equalsIgnoreCase(Actual_Title))
	{
	 Reporter.log("Login Success:::::"+Expected_Title+"       "+Actual_Title,true);

	}
	else
	{	
		Reporter.log("Login Fail:::::"+Expected_Title+"       "+Actual_Title,true);
	}	
	
	}
	
@AfterTest
public void teardown()
{
	driver.quit();
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

