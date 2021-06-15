package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmallcaseSecond {


	String driverPath = "C:\\Users\\batma\\\\Documents\\\\learning\\\\automation\\\\edgedriver\\\\msedgedriver.exe";
	WebDriver driver;
	FlipkartSearch flipSearch;
	FlipkartItem flipItems;
	AmazonSearch amazSearch;
	AmazonItem amazItem;
	String url = "https://www.flipkart.com/";
	int compare;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test(priority=0)
	public void open() throws InterruptedException {
		driver.get(url);
		flipSearch =new FlipkartSearch(driver);
		flipSearch.searchBar();
	}

	@Test(priority=1)
	public void selectItem() throws InterruptedException {
		flipItems = new FlipkartItem(driver);
		flipItems.printPrice();
		flipItems.addToCart();
	}	
	
	@Test(priority=2)
	public void AmazonSearch() throws InterruptedException {
		amazSearch =new AmazonSearch(driver);
	}
	
	@Test(priority=3)
	public void AmazonItem() throws InterruptedException {
		amazItem = new AmazonItem(driver);
		amazItem.printPrice();
		amazItem.addToCart();
	}
	
	@Test(priority=4)
	public void comparePrice() {
		compare = (flipItems.flipkartPrice).compareTo(amazItem.amazonPrice);
		if(compare>0) {
			System.out.println("Flipkart has cheaper price than Amazon");
		}
		else if (compare<0) {
			System.out.println("Amazon has cheaper price than Flipkart");
		}
		else {
			System.out.println("Flipkart and Amazon have same price");
		}
		
	}
}
