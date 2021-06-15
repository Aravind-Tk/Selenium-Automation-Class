package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonSearch {
	WebDriver driver;
	By searchBar = By.cssSelector("input#twotabsearchtextbox");
	String item = "iphone 12";
	
	
	public AmazonSearch(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(searchBar).sendKeys(item);
		Thread.sleep(1000);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		
	}
	

}
