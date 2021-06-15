package firsttestngpackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmallcaseAssign {

	String driverPath = "C:\\Users\\msedgedriver.exe";
	WebDriver driver;
	FlipkartSearch search;
	FlipkartItem items;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
	}

	@Test
	public void open() throws InterruptedException {
		search =new FlipkartSearch(driver);
		search.searchBar();
	}

	@Test
	public void selectItem() throws InterruptedException {
		items = new FlipkartItem(driver);
		items.printPrice();
		items.addToCart();
		items.incrementItem();
    }
}
