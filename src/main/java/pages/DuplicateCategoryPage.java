package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuplicateCategoryPage {
	WebDriver driver;

	public DuplicateCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//input[@name='categorydata'")
	WebElement AddCategoryTextBox;
	@FindBy(how = How.XPATH, using = "//input[@valve='Add category'")
	WebElement AddCategoryButton;
	@FindBy(how = How.XPATH, using = "//*[@contains(text(),'The category you want to add alreadyexists')}")
	WebElement DuplicateCategory;

	public void addCategoryTextBox(String text) throws InterruptedException {
		AddCategoryTextBox.sendKeys("Test123");
		Thread.sleep(3000);

	}

	public void clickCategoryButton() {
		AddCategoryButton.click();
	}

	public void waitTime() {
		waitForElement(DuplicateCategory, driver);
	}

	private void waitForElement(WebElement duplicateCategory, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(duplicateCategory));

	}

	public boolean duplicateMessageDisplayed() {

		try {
			wait();
			return true;
		} catch (Exception e) {

			return false;

		}

	}
}
