package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestParam {
	public ChromeDriver driver;

    @Parameters({"username","password"})
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(String uName,String pWord) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}

		@AfterMethod(alwaysRun=true)
		public void afterMethod() 
		{
			


		}

	}
