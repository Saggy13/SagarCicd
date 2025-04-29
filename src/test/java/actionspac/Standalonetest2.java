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

import framework_learning.Landingpage;

public class Standalonetest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String productname="ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("sagarsuryavanshi13@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		Landingpage land= new Landingpage(driver);
		
		Thread.sleep(5000);
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		Thread.sleep(3000);
		WebElement prod = products.stream().filter(
				product -> product.findElement(By.xpath("//b[text()='ZARA COAT 3']")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);
		Thread.sleep(3000);
		prod.findElement(By.xpath("//div[@class='card-body']/button/i[@class='fa fa-shopping-cart']")).click();
		// prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		List <WebElement> cartprodcut=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	  Boolean match= cartprodcut.stream().anyMatch(single->single.getText().equalsIgnoreCase(productname));
	  if(match.TRUE)
	  {
		  System.out.println("value match properly");
	  }
	 
	 
     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".totalRow button")));
	 try
	 {
     driver.findElement(By.cssSelector(".totalRow button")).click();
	 }
	 
	catch (Exception e)
	 {
		System.out.println(e);
	 }
	  
	  Actions act= new Actions(driver);
	  act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results']")));
	  
	  driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();
	  
	//li[@class='ui-menu-item']
	  
	  
		
	  
		
		

		
	}

}
