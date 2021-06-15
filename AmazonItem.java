package firsttestngpackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonItem {
	WebDriver driver;
	Actions act;
	String parent;
	String pinCode = "560029";
	String amazonPrice;
	By item = By.cssSelector("a.a-link-normal.a-text-normal");
	By price = By.cssSelector("span#priceblock_ourprice");
	By delivery = By.xpath("//div[text()='Select delivery location']");
	By pin = By.cssSelector("input#GLUXZipUpdateInput");
	//By apply = By.cssSelector("span#GLUXZipUpdate-announce");
	By addTo = By.cssSelector("input#add-to-cart-button");
	By cart = By.cssSelector("input.a-button-input");
	By totalPrice = By.cssSelector("span#sc-subtotal-amount-buybox");
	
	
	public AmazonItem(WebDriver driver) {
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
		System.out.println("Price of one item in Amazon :  " + driver.findElement(price).getText());
	}
	
	public void addToCart() throws InterruptedException {
		act = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)");
		jse.executeScript("document.getElementById('contextualIngressPtLabel_deliveryShortLine').click();");
		driver.findElement(pin).sendKeys(pinCode);
		Thread.sleep(1000);
		driver.findElement(pin).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(addTo).click();
		Thread.sleep(3000);
		//jse.executeScript("document.getElementById('attach-sidesheet-view-cart-button-announce').click();");
		driver.findElement(cart).click();
		amazonPrice = driver.findElement(totalPrice).getText();
		
	}

}
