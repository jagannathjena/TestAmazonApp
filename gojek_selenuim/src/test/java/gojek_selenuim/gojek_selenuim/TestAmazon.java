package gojek_selenuim.gojek_selenuim;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestAmazon 
{
	private AmazonAppPageObject amazon;
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver3");
		driver = new ChromeDriver();
		amazon = new AmazonAppPageObject(driver);	
	}
	
	@Test(priority=1)
    public void testAmazonLogin() throws IOException, InterruptedException {
    	amazon.launchURL(PropUtils.getLabels("BASE_URL"));
    	amazon.waitForLoad();
    	Thread.sleep(3000);
    	amazon.clickOnSignInOnHomePage();
    	Thread.sleep(3000);
    	amazon.waitForLoad();
    	amazon.clickOnSignInOnPopup();
    	amazon.enterLogInEmail(PropUtils.getLabels("AMAZON_USERNAME"));
    	amazon.waitForLoad();
    	amazon.clickOnContinueBtnAfterUsername();
    	amazon.waitForLoad();
    	amazon.enterPassword(PropUtils.getLabels("AMAZON_PASSWORD"));
    	amazon.clickOnContinueBtnAfterPassword();
    	amazon.waitForLoad();
    	
//    	OTP verification page ?? Created a sample for dummy OTP flow
    	try {
    	if(driver.findElement(By.xpath("//div[@class='a-row a-spacing-small']")).isDisplayed()) {
    		driver.findElement(By.xpath("//div[@class='a-row a-spacing-small']")).click();
    		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1111");
    		driver.findElement(By.xpath("//span[@class='a-button-inner']//span[contains(text(),'Continue')]")).click();
    	}
    	}catch (Exception e) {
			System.out.println("Exception found: "+e);
		}
    	String welcomeText= amazon.getWelcomeTextAfterLogin();
    	System.out.println("welcome Text: "+welcomeText);
    	Assert.assertEquals(welcomeText, "Hello, jagan", "The welcome text after login is not shown"); 	
    }
	
	@Test(priority=2)
	public void testAddToCart() throws IOException, InterruptedException {
		amazon.launchURL(PropUtils.getLabels("BASE_URL"));
		amazon.waitForLoad();
		amazon.hoverOnDepartments();
		amazon.waitForLoad();
		amazon.clickOnElectronics();
		amazon.clickOnHeadphones();
		amazon.clickOn1stAvailableHeadphone();
		amazon.clickOnAddToCartBtn();
		amazon.serchForMacBookPro(PropUtils.getLabels("SEARCH_MAC"));
		amazon.clcikOnSearchBtn();
		amazon.clickOn2ndSearchedItem();
		amazon.selectQuantity(2);
		amazon.clickOnAddToCartBtn();
		
		try{ 
			Thread.sleep(4000);
			amazon.waitForLoad();
			if(amazon.isCartBtnOnSideWinDisplayed()) {
				amazon.clickOnCartBtnOnSideWin();
			}
		}catch (Exception e) {
			System.out.println("exception: "+e);
		}
		
//		close Apple care+
		try{
			amazon.waitForLoad();
			amazon.clickOnAppleCareCloseBtn();
			amazon.clickOnGoToCart();
		}catch (Exception e) {
			System.out.println("Exception found: "+e);
		}
	
		amazon.clickOnDeleteForEarPhone();
		Thread.sleep(3000);
		amazon.waitForLoad();
		amazon.clickOnQtyForMacBookPro();
		Thread.sleep(3000);
		amazon.waitForLoad();
		amazon.selectReqQtyForMacBookPro();
		amazon.clickOnProceedToCheckout();
	}
	
	@AfterClass
	public void afterClass() {
		amazon.closeWindow();
	}
}
