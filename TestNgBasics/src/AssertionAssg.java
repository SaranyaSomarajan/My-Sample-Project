import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssertionAssg {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	// @BeforeTest

	 @Parameters ("Browser")
	public void beforeMethod(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\saran\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\saran\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\saran\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		driver.get("http://www.qabible.in/payrollapp/site/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyLoginButtonColor() {

		WebElement login = driver.findElement(By.name("login-button"));
		String actualResult = login.getCssValue("background-color");
		String expectedResult = "rgba(6, 173, 243, 1)";
		Assert.assertEquals(actualResult, expectedResult, "color not expected");
		String actualResult1 = login.getCssValue("font-family");
		String expectedResult1 = "Overpass, sans-serif";
		Assert.assertEquals(actualResult1, expectedResult1, "fontType not expected");
		String actualResult2 = login.getCssValue("font-size");
		String expectedResult2 = "14px";
		Assert.assertEquals(actualResult2, expectedResult2, "font size not expected");
	}

	@Test
	public void verifyLoginImageDisply() {
		WebElement loginIcon = driver.findElement(By.xpath("//h1"));
		Boolean actualResult = loginIcon.isDisplayed();
		Boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, "LOGIN ICON NOT DISPLAYED");
	}

	@Test
	public void verifyLoginApplication() {
		WebElement userElement = driver.findElement(By.id("loginform-username"));
		userElement.sendKeys("carol");

		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");

		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "http://www.qabible.in/payrollapp/site/login";
		Assert.assertEquals(actualResult, expectedResult, "Url not expected");

	}

	@Test
	public void verifySearchButton() {
		WebElement userElement = driver.findElement(By.id("loginform-username"));
		userElement.sendKeys("carol");

		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");

		WebElement login = driver.findElement(By.name("login-button"));
		login.click();

		WebElement client = driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
		client.click();
		WebElement search = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		search.click();
		String actualResult = search.getText();
		String expectedResult = "Search";
		Assert.assertEquals(actualResult, expectedResult, "text not expected");

	}

	@AfterMethod
	// @AfterTest

	public void afterMethod() {

		driver.close();

	}
}
