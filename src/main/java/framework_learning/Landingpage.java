package framework_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethod.Abstractcomponent;

public class Landingpage extends Abstractcomponent
{

 WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver; //This is use to get scope for driver defined under class level.
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	public void loginApplication(String email,String password)
	{
		useremail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		
	}
	
	public void gotoapp()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
