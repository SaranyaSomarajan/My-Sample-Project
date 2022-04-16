import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method exceuted");
	}

	

	@Test
	public void testCase01() {

		System.out.println("Test 1 executed");
	}

	@Test
	public void testCase02() {

		System.out.println("Test 2 executed");
	}

	@Test(priority = 1)
	public void testCase03() {

		System.out.println("Test 3 executed");
	}

	@Test
	  public void testCase04() {
		  
		  System.out.println("Test 4 executed");
	}

	@AfterMethod

	public void afterMethod() {
		System.out.println("AFTER METHOD EXCECUTED");

	}

	@Test
	public void f() {
	}
}
