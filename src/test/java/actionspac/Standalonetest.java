package actionspac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework_learning.Cartpage;
import framework_learning.CheckoutPage;
import framework_learning.Landingpage;
import framework_learning.Productcatlog;

public class Standalonetest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String productname="ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Landingpage land= new Landingpage(driver);
		land.gotoapp();
		land.loginApplication("sagarsuryavanshi13@gmail.com","123456");
		Thread.sleep(5000);
		Productcatlog pr= new Productcatlog(driver);
		List<WebElement> products=pr.getproductlist();
		pr.addproducttocart(productname);
	    pr.addtocart();
		//System.out.println("Run properl");
	    Cartpage cart=new Cartpage(driver);
	    cart.verifyproductdisplay(productname);
	    Boolean match=cart.verifyproductdisplay(productname);
	    System.out.println(match);
	    cart.pagedown();
	    cart.checkoutpagegotocheckout();
		CheckoutPage page= new CheckoutPage(driver);
		page.selectcountry("India");
		page.sumbitorder();

}
	
}
