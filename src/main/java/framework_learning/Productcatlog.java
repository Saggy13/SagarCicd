package framework_learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethod.Abstractcomponent;

public class Productcatlog extends Abstractcomponent

{

WebDriver driver;
	
	public Productcatlog(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver; //This is use to get scope for driver defined under class level.
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> pr;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productby=By.cssSelector(".mb-3");
	By toastmessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getproductlist()
	{
		waitformethod(productby);
		return pr;
	}
	
	public WebElement getproductbyname(String productname)
	{
		WebElement prod = getproductlist().stream().filter(
				product -> product.findElement(By.xpath("//b[text()='ZARA COAT 3']")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addproducttocart(String productname)
	{
		WebElement prod=getproductbyname(productname);
		prod.findElement(By.xpath("//div[@class='card-body']/button/i[@class='fa fa-shopping-cart']")).click();
		waitformethod(toastmessage);
		waitforelementtodisappear(spinner);
		
		

		
	}
	
	}



