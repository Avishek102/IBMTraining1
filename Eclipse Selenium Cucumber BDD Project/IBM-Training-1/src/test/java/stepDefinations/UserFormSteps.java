package stepDefinations;


import java.util.List; 

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserFormSteps {

	WebDriver driver;
	
	@Given("^User is on User Registration homepage$")
	public void user_is_on_User_Registration_homepage() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0018R9744\\Desktop\\chromedriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		driver.get("https://www.janbasktraining.com/register");
		driver.manage().window().maximize();
	}

	@When("^Registration form is visible$")
	public void registration_form_is_visible() throws Throwable {

		Assert.assertTrue(driver.findElement(By.cssSelector(".slider-text2.dark")).isDisplayed());
	}

	@Then("^User enters form details$")
	public void user_enters_form_details(DataTable table) throws Throwable {
		
		 //Initialize data table 
	      List<List<String>> data = table.raw();
	     // System.out.println("Size:"+data.size());
	      //Enter data
	
	      driver.findElement(By.name("reg_name")).sendKeys(data.get(1).get(0));
	      driver.findElement(By.name("reg_mobile")).sendKeys(data.get(1).get(1));
	      driver.findElement(By.name("reg_email")).sendKeys(data.get(1).get(3));     
	      driver.findElement(By.name("reg_con_email")).sendKeys(data.get(1).get(4)); 
	      driver.findElement(By.name("reg_password")).sendKeys(data.get(1).get(5)); 
	      driver.findElement(By.name("reg_con_password")).sendKeys(data.get(1).get(6));
	      
	      Select dropdownB = new Select(driver.findElement(By.name("reg_course"))); 
	      dropdownB.selectByVisibleText(data.get(1).get(2)); 
	 
	}

	@Then("^User accepts terms and submit details$")
	public void user_accepts_terms_and_submit_details() throws Throwable {

		driver.findElement(By.name("reg_tandc")).click();
		driver.findElement(By.name("submit")).click();
		driver.close();
	}


	
}
