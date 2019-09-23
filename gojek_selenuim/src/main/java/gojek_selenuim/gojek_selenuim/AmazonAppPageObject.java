package gojek_selenuim.gojek_selenuim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class AmazonAppPageObject {
	private WebDriver driver;
	private Automator automator;
	
	

	public AmazonAppPageObject(WebDriver driver) {
		this.driver=driver;
		automator = new Automator(driver);
	}
	
	public void launchURL(String url) {
		driver.get(url);
	}
	
	public void hoverOnSignInOnHomePage() throws IOException, InterruptedException {
		automator.hoverOnLabel(PropUtils.getLocator("SIGNIN_BTN_ON_HOME_PAGE"));
	}
	
	public void clickOnSignInOnHomePage() throws IOException {
		automator.click(PropUtils.getLocator("SIGNIN_BTN_ON_HOME_PAGE"));
	}
	
	public void clickOnSignInOnPopup() throws IOException {
		automator.click(PropUtils.getLocator("SIGNIN_BTN_ON_POPUP"));
	}
	
	public void enterLogInEmail(String text) throws IOException {
		automator.setText(PropUtils.getLocator("USERNAME_EDITBOX"), text);
	}
	
	public void clickOnContinueBtnAfterUsername() throws IOException {
		automator.click(PropUtils.getLocator("CONTINUE_BTN_USERNAME"));
	}
	
	public void enterPassword(String text) throws IOException {
		automator.setText(PropUtils.getLocator("PASSWORD_EDITBOX"), text);
	}
	
	public void clickOnContinueBtnAfterPassword() throws IOException {
		automator.click(PropUtils.getLocator("CONTINUE_BTN_PASSWORD"));
	}
	
	public void clickOnOtpBtn() throws IOException {
		automator.click(PropUtils.getLocator("OTP_BTN"));
	}
	
	public void enterOtp(String text) throws IOException {
		automator.setText(PropUtils.getLocator("SIGNIN_EMAIL"), text);//OTP_EDITBOX
	}
	
	public void clickOnContinueAfterOtp() throws IOException {
		automator.click(PropUtils.getLocator("OTP_CONTINUE_BTN"));
	}
	
	public String getWelcomeTextAfterLogin() throws IOException {
		String welcomeText= automator.getText(PropUtils.getLocator("LOGIN_SUCCESSFUL_WELCOME_TEXT"));
		return welcomeText;
	}
	
	public void hoverOnDepartments() throws IOException, InterruptedException {
		automator.hoverOnLabel(PropUtils.getLocator("DEPARTMENTS"));
	}
	
	public void clickOnElectronics() throws IOException {
		automator.click(PropUtils.getLocator("ELECTRONICS"));
	}
	
	public void clickOnHeadphones() throws IOException {
		automator.click(PropUtils.getLocator("HEADPHONES"));
	}
	
	public void clickOn1stAvailableHeadphone() throws IOException {
		automator.click(PropUtils.getLocator("FIRST_AVAILABLE_HEADPHONE"));
	}
	
	public void clickOnAddToCartBtn() throws IOException {
		automator.click(PropUtils.getLocator("ADD_TO_CART_BTN"));
	}
	
	public void serchForMacBookPro(String text) throws IOException {
		automator.setText(PropUtils.getLocator("SEARCH_EDITBOX"), text);
	}
	
	public void clcikOnSearchBtn() throws IOException {
		automator.click(PropUtils.getLocator("SEARCH_BTN"));
	}
	
	public void clickOn2ndSearchedItem() throws IOException {
		List<WebElement> elements = automator.getElements(PropUtils.getLocator("SEARCH_RESULTS_FOR_MAC_BOOK_PRO"));
		elements.get(1).click();
	}
	
	public void selectQuantity(int i) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropUtils.getLocator("SELECT_QTY_MAC_BOOK_PRO"))));
        automator.selectCount(PropUtils.getLocator("SELECT_QTY_MAC_BOOK_PRO"),i);		
	}
	
	public void clickOnAddToCart() throws IOException {
		automator.click(PropUtils.getLocator("ADD_TO_CART_BTN")); 
	}
	
	public void clickOnGoToCart() throws IOException {
		automator.click(PropUtils.getLocator("GO_TO_CART")); 
	}
	
	public void clickOnAppleCareCloseBtn() throws IOException {
		automator.click(PropUtils.getLocator("CLOSE_APPLE_CARE_POPUP"));
	}

	public boolean isCartBtnOnSideWinDisplayed() throws IOException {
		return automator.isElementDisplayed(PropUtils.getLocator("CART_BTN_ON_SIDE_WIN"));
	}
	
	public void clickOnCartBtnOnSideWin() throws IOException {
		automator.click(PropUtils.getLocator("CART_BTN_ON_SIDE_WIN"));
	}

	
	public void clickOnDeleteForEarPhone() throws IOException {
		automator.click(PropUtils.getLocator("DELETE_EAR_PHONE"));
	}
	
	public void clickOnQtyForMacBookPro() throws IOException {
		automator.click(PropUtils.getLocator("ClICK_QTY_MAC_BOOK_PRO"));
	}
	
	public void selectReqQtyForMacBookPro() throws IOException {
		automator.click(PropUtils.getLocator("SELECT_REQ_QTY_MAC_BOOK_PRO"));
	}
	
	public void clickOnProceedToCheckout() throws IOException {
		automator.click(PropUtils.getLocator("PROCEED_TO_CHECKOUT"));
	}
	
	public void closeWindow() {
		driver.close();
		driver.quit();
	}
	
	/*
	public void enterEmail(String text) throws IOException {
		automator.setText(PropUtils.getLocator("SIGNIN_EMAIL"), text);//CLOSE_APPLE_CARE_POPUP  hoverOnLabel
	}
	*/
	
	public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
