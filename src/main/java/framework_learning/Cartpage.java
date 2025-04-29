package framework_learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethod.Abstractcomponent;

public class Cartpage extends Abstractcomponent

{
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> producttitle;
	
	//By checkoutt=By.cssSelector(".totalRow button");
	
	public Cartpage(WebDriver driver)
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyproductdisplay(String productname)
	{
		Boolean match=producttitle.stream().anyMatch(single->single.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public void pagedown()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
	}
	
	
	public  void checkoutpagegotocheckout() throws Exception
	{
		
		checkout.click();
		
	}

}

