package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\0018R9744\\Desktop\\chromedriver\\chromedriver.exe");  
	      
	       // Instantiate a ChromeDriver class.       
	    WebDriver driver=new ChromeDriver();  
	    
	    driver.get("https://www.google.com/");
	    
	    //Maximize the browser  
        driver.manage().window().maximize(); 

	    driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
	    driver.findElement(By.xpath("//div[contains(@jsmodel,'vWNDde')]")).click();
	    driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
	 
	    
	    driver.close();
	}

}
