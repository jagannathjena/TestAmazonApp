package gojek_selenuim.gojek_selenuim;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Automator {
	
	private WebDriver driver;

	public Automator(WebDriver driver) {
		this.driver = driver;
	}

	public void setText(String locator, String text) {
		getElement(locator).click();
		getElement(locator).clear();
		getElement(locator).sendKeys(text);
	}

	public void click(String locator) {
		getElement(locator).click();
	}
	
	public boolean isElementDisplayed(String locator) {
		return getElement(locator).isDisplayed();
	}

	public String getTextA(String locator) {
		return getElement(locator).getAttribute("innerText");
	}
	
	public String getText(String locator) {
		return getElement(locator).getText();
	}

	public void hoverOnLabel(String locator) throws InterruptedException {
		Actions action = new Actions(driver);	 
        action.moveToElement(getElement(locator)).build().perform();
        Thread.sleep(3000);

 	}
	
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public void selectCount(String locator, int i) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(i-1);
		
	}

	public List<WebElement> getElements(String locator) {
		return driver.findElements(By.xpath(locator));

	}
}
