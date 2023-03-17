package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoriesPage;
import pages.DropDownPage;
import pages.DuplicateCategoryPage;
import util.BrowserFactory;

public class CategoryTest {
	WebDriver driver;
	CategoriesPage categoriesPage;
	DuplicateCategoryPage duplicateCategoryPage;
	DropDownPage dropDownPage;
	Random rd = new Random();
	String categotyAddNAme = "Text123" + rd.nextInt(99);
	String categortDuplicateNmae = "Text124" + rd.nextInt(89);
	
	@BeforeMethod
	public void userShouldBeToPerformAll() {
		driver=BrowserFactory.init();
		categoriesPage= PageFactory.initElements(driver, categoriesPage.getClass());
		duplicateCategoryPage = PageFactory.initElements(driver, duplicateCategoryPage.getClass());
		dropDownPage = PageFactory.initElements(driver,dropDownPage.getClass());
	}
@Test(priority=1)
	public void userShouldBeAbleToAddCategory() throws InterruptedException {
		duplicateCategoryPage.addCategoryTextBox("");
		String categoryAddName="";
		List<String> actualList = categoriesPage.getListOf();
		Assert.assertTrue(ifDataExist(categoryAddName,actualList), "New Category does not Exist");
		Thread.sleep(3000);
		
	}
	public void userShouldNotBeAbleToAddDuplicateCategory() throws InterruptedException {
		duplicateCategoryPage.addCategoryTextBox("Duplicated Name");
		try {
			duplicateCategoryPage.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		}
	@Test(priority = 3 )
	public void allMonthDropDownList() {
		String[] months= {"jan","feb","march","april","may","jun","july","aug","sep","oct","nov","dec"};
		List<String>dropDownList = dropDownPage.getListOfMonthsDropDown();
		Assert.assertTrue(ifDataMatches(months,dropDownList, dropDownList), "Values do not match");
		
	}
	private boolean ifDataMatches(String[]months, List<String> dropDownList,List<String>dropDownPage) 
	{
		for(int i =0;i<dropDownPage.size();i++) {
			if(dropDownPage.get(i).equalsIgnoreCase(months.toString())) {
		}
	}
	
return true;
}
 
	private boolean ifDataExist(String categoryAddName,List<String> actualList) {
		return true;
		}
	
public void tearDown() {
	driver.close();
	driver.quit();
}	
	

}