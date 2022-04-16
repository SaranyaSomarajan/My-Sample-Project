import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasics {
	

  @Test(dataProvider = "data-provider",dataProviderClass = BasicCommand.class)
  public void f(int a,int b) {
	  int c=a+b;
	  System.out.println(c);
  }
}
