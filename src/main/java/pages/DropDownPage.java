package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

	WebDriver driver;
	
	public DropDownPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	@FindBy(how=How.CSS,using = "body:nth-child(2)div.advance-controls:nth-child(4)span:nth-child(3)")WebElement DropDown;
	
	public List<String> getListOfMonthsDropDown(){
		List<String>dropDownValues= new ArrayList<String>();
		
		Select dropDown = new Select(DropDown);
		
		List<WebElement> listofdropDownValues = dropDown .getOptions();
		for(int i=0;i<listofdropDownValues.size();i++) {
			dropDownValues.add(i,listofdropDownValues.get(i).getText());
		}
		return dropDownValues;
		
	}
}
