package LoginTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Correctusernamenandpassword {

	
	@Test
	
	@Parameters({"Username","Password"})
	public void cuandcp(String uname, String pword) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\Chrome Driver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://192.168.1.205/Ibiserpv5/");
		WebElement Username=driver.findElement(By.xpath("//*[@id='UserName']"));
		Username.sendKeys(uname);
		WebElement Password=driver.findElement(By.id("Password"));
		Password.sendKeys(pword);
		
		WebElement Loginbutton=driver.findElement(By.xpath("//*[@class='btn btn-default btn-sm pull-right']"));
		Loginbutton.click();
	}
}
