import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRIStestClass {
  
	 WebDriver driver;
	    
	    HrisJavaClass loginForm;
	    
	 @Test
	    public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
	        Assert.assertTrue(loginForm
	                .loginWithIncorrectCredentials("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
	    }
	    
	    @Test 
	    public void attempt_Login_With_correct_Password_Should_Render_Error_Message(){
	    	 driver.get("https://hris.qainfotech.com/login.php");
		        driver.findElement(By.cssSelector("i.icon-lock")).click();
	    	Assert.assertTrue(loginForm
	                .loginWithCorrectCredentials("Alokupadhyay", "Alok@321#").getDisplay());
	    }
	    @Test
	    public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field(){
	        loginForm.login("Alokupadhyay", "");
	        // red border in password entry
	        Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
	    }
	    
	    @BeforeClass
	    public void launchBrowser(){
	    	 System.setProperty("webdriver.chrome.driver", "C:\\My_java_prog\\chromedriver_win32\\chromedriver.exe");
	 		driver = new ChromeDriver();
	        driver.get("https://s-hris.qainfotech.com/login.php");
	        //driver.findElement(By.cssSelector("i.icon-lock")).click();
	        loginForm = new HrisJavaClass(driver);
	    }
	    
	    @AfterClass
	    public void closeBrowser(){
	        //driver.quit();
	    }
}
