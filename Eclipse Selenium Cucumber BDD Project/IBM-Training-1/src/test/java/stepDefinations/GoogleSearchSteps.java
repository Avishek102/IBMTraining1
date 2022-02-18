package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver;

	@Given("^User is on google homepage$")
	public void user_is_on_google_homepage() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0018R9744\\Desktop\\chromedriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@When("^Google search bar is visible$")
	public void google_search_bar_is_visible() throws Throwable {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());

	}

	@Then("^User enters name avishek$")
	public void user_enters_name_avishek() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("avishek");

	}
	
	@Then("^User enters \"([^\"]*)\"$")
	public void user_enters(String name) throws Throwable {
	
		driver.findElement(By.name("q")).sendKeys(name);	
	}

	@Then("^User clicks on Search button$")
	public void user_clicks_on_Search_button() throws Throwable {
		
		try
		{
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		}
		catch (ElementClickInterceptedException e) {
			driver.findElement(By.xpath("//div[contains(@jsmodel,'vWNDde')]")).click();
			driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		}
		finally {
			driver.close();
		}
		

	}

}
