package Com.Google.Selenium.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

	ChromeDriver driver;

	@BeforeMethod
	public void OpenURL() {
		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://192.168.9.143:6060/MGViewer/");
	}

	@Test
	public void Login() {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.id("GSSLogin_loginBtn")).click();
		driver.findElement(By.id("GSSLogin_userNameTxt")).sendKeys("psap01\\\\uds");
		// Find the element that's ID attribute is 'pwd' (Password)
		// Enter Password on the element found by the above desc.
		driver.findElement(By.id("GSSLogin_passwordTxt")).sendKeys("Pa$$w0rd");
		// Now submit the form. WebDriver will find the form for us from the element
		driver.findElement(By.id("GSSLogin_submitLoginBtn")).click();
		System.out.println(" Login Successfully, now it is the time to Log Out.");
	}

	@AfterMethod
	public void CloseBrowser() {
		// Close the driver
		driver.quit();
	}
}
