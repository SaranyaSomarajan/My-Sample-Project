import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.netty.util.AsciiString;

public class Assertions {
	@Test
	public void verifyLoginButtonText() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saran\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.qabible.in/payrollapp/site/login");

		driver.manage().window().maximize();
		WebElement loginButton=driver.findElement(By.name("login-button"));
		String actualResult=loginButton.getText();
		String expectedResult="LOIN";
		//Hard Assertion
		//Assert.assertEquals(actualResult, expectedResult,"Login text not expected::::");
		//System.out.println("***************************");
		
		
		//Soft Assertion
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualResult, expectedResult,"Login text not expected");
		System.out.println("***************************");
		softAssert.assertAll();
	}
}
