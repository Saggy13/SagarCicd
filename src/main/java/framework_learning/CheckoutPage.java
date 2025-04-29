package framework_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethod.Abstractcomponent;

public class CheckoutPage extends Abstractcomponent

{
	WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver; //This is use to get scope for driver defined under class level.
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	

	@FindBy(xpath="//button[contains(@class,'ta-item')] [2]")
	WebElement selectedcountry;
	
    By result= By.cssSelector(".ta-results");
	
	public void selectcountry(String countryname)
	{
		Actions act= new Actions(driver);
		act.sendKeys(country, countryname).build().perform();
		waitformethod(result);
		selectedcountry.click();

	}
	
	public void sumbitorder()
	
	{   
		submit.click();
	}

}



