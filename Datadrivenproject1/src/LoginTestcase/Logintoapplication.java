package LoginTestcase;

import java.io.FileInputStream;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Logintoapplication {
	WebDriver driver;
	
	
	String [][] data= null;
			
	
	
	@DataProvider(name="logindata")
	public String[][] Logindataprovider() throws BiffException, IOException {
	data=	readexcel();
		return data;
		
	}
	
	
	public String[][] readexcel() throws BiffException, IOException  {
		FileInputStream excel= new FileInputStream("C:\\Users\\HP\\Documents\\Book1.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet =workbook.getSheet(0);
		int rowCount=sheet.getRows();
		int Columncount=sheet.getColumns();
		
		String [][] testdata= new String[rowCount-1][Columncount];
		
		for(int i =1;i<rowCount;i++) {
			
			for(int j=0;j<Columncount;j++) {
		testdata [i-1][j]=sheet.getCell(j,i).getContents();
				
			}
		}
		return testdata;
		
	}
	
	@BeforeTest
	public void Beforelogin() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\Chrome Driver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		 driver= new ChromeDriver();
	}
	
	//@AfterTest
	public void AfterTest() {
		driver.quit();
	}
	
	@Test(dataProvider = "logindata")
	public void cuandcp1(String uname, String pword) {

		
		driver.get("http://192.168.1.205/Ibiserpv5/");
		WebElement Username=driver.findElement(By.xpath("//*[@id='UserName']"));
		Username.sendKeys(uname);
		WebElement Password=driver.findElement(By.id("Password"));
		Password.sendKeys(pword);
		
		WebElement Loginbutton=driver.findElement(By.xpath("//*[@class='btn btn-default btn-sm pull-right']"));
		Loginbutton.click();
	}
}


