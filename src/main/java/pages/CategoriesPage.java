package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoriesPage {

	WebDriver driver;
	
	public CategoriesPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	@FindBy(how=How.NAME,using = "Categorydata")WebElement CategoryTextBox;
	
	public List<String> getListOf(){
		List<String>list= new ArrayList<String>();
		
		List<WebElement> categoryDataElement = driver.findElements(By.xpath(("//a[@title='Remove this category']")));
		for(int i=0;i<categoryDataElement.size();i++) {
			list.add(i,categoryDataElement.get(i).getText());
		}
		return null;
		
	}
}
