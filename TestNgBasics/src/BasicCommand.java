import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicCommand {
	
	@DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
	 return new Object[][] {{10,20},{30,50},{60,80}};
    }

	
  @Test(groups= {"Critical"})
  //@Parameters ({"Para1", "Para2"})

  public void testCase01() {
	  //int c=a+b;
	  //System.out.println(c);
	  
	  System.out.println("Test 1 executed");
  }
  
  @Test(priority = 2,groups= {"Critical"})
  public void testCase02() {
	  
	  System.out.println("Test 2 executed");
  }
  
  @Test(priority = 1)
  public void testCase03() {
	  
	  System.out.println("Test 3 executed");
  }
  
  @Test(priority = 3)
  public void testCase04() {
	  
	  System.out.println("Test 4 executed");
  }
}
