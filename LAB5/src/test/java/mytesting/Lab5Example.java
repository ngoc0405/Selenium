package mytesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lab5Example {
	private String testUrl = "https://www.google.com/";
	private ChromeDriver driver;
	@BeforeClass
	public void openchorme() {
		System.out.println("open chrome");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void TC_GoogleSearch() throws InterruptedException {
		System.out.println("START TC");
		driver.get(testUrl);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElementByName("q").sendKeys("selenium");
		WebElement element = driver.findElementByName("btnK");
		Thread.sleep(10000);
		element.click();
		System.out.println("FINISH TC");
	}
	@AfterClass
	public void closeChorme() {
		driver.close();
	}
}
