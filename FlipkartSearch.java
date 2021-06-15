package firsttestngpackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FlipkartSearch {

	WebDriver driver;
	String item = "iphone 12";
	By closeButton = By.cssSelector("button._2KpZ6l._2doB4z");
	By searchBar = By.cssSelector("input._3704LK");
	
	public FlipkartSearch(WebDriver driver){
		this.driver = driver;
		driver.findElement(closeButton).click();
	}

	public void searchBar() throws InterruptedException {
		driver.findElement(searchBar).sendKeys(item);
		Thread.sleep(1000);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
}

