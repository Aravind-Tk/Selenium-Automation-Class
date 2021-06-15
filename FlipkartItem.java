package firsttestngpackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FlipkartItem {

		WebDriver driver;
		String parent; 
		String pincode = "560029";
		String flipkartPrice;
		By item = By.cssSelector("div._4rR01T");
		By price = By.cssSelector("div._30jeq3._16Jk6d");
		By addButton = By.cssSelector("button._2KpZ6l._2U9uOA._3v1-ww");
		By pin = By.cssSelector("input._36yFo0");
		By check = By.cssSelector("span._2P_LDn");
		By incr = By.xpath("//button[@class='_23FHuj'][2]");
		By newPrice = By.cssSelector("div.Ob17DV._3X7Jj1");

		public FlipkartItem(WebDriver driver) {
			this.driver = driver;
			parent = driver.getWindowHandle();
			driver.findElement(item).click();
		}

		public void printPrice() {
			Set<String> windows = driver.getWindowHandles();
			for(String s : windows) {
				if(s!= parent) {
					driver.switchTo().window(s);
				}
			}
			flipkartPrice = driver.findElement(price).getText();
			System.out.println("Price of one item in Flipkart:  " + flipkartPrice);
		}

		public void addToCart() throws InterruptedException {
			driver.findElement(pin).sendKeys(pincode);
			driver.findElement(check).click();
			Thread.sleep(2000);
			driver.findElement(addButton).click();
			Thread.sleep(3000);
		}

		public void incrementItem() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			driver.findElement(incr).click();
			Thread.sleep(1000);
			System.out.println("Price of two items in Flipkart: " + driver.findElement(newPrice).getText());

		}

	}


