package stepDefinations;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ElearningPortalSteps {

	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on elearning website homepage$")
	public void user_is_on_website_homepage() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0018R9744\\Desktop\\chromedriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
	}

	@When("^User clicks on Sign up button$")
	public void user_clicks_on_Sign_up_button() throws Throwable {
	    driver.findElement(By.xpath("//a[normalize-space()='Sign up!']")).click();
	}

	@When("^enters details \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void enters_details(String firstname, String lastname, String email, String username, String password, String con_password) throws Throwable {

		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pass1")).sendKeys(password);
		driver.findElement(By.name("pass2")).sendKeys(con_password);
		
		
	}

	@Then("^User clicks on Register button$")
	public void user_clicks_on_Register_button() throws Throwable {
		driver.findElement(By.name("submit")).click();
	}

	@Then("^User verifies successful registration$")
	public void user_verifies_successful_registration() throws Throwable {

		Assert.assertTrue(driver.findElement(By.cssSelector("body > main:nth-child(1) > section:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > p:nth-child(1)")).getText().contains("Your personal settings have been registered"));
	
		driver.close();
	}
	
	/* ------------------------------------------------ */
	
	@Given("^User logs in with creds \"([^\"]*)\"\"([^\"]*)\" and go to Homepage tab$")
	public void user_logs_in_with_creds_and_go_to_Homepage_tab(String arg1, String arg2) throws Throwable {
	    driver.findElement(By.name("login")).sendKeys(arg1);
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    
	    driver.findElement(By.name("submitAuth")).click();
	    
	    driver.findElement(By.xpath("//a[@title='Homepage']")).click(); //go to homepage
	    
	}

	@When("^User clicks on Compose tab$")
	public void user_clicks_on_Compose_tab() throws Throwable {
	    driver.findElement(By.linkText("Compose")).click();
	}

	@When("^User selects mail recepients \"([^\"]*)\"$")
	public void user_selects_mail_recepients(String arg1) throws Throwable {
	   driver.findElement(By.className("select2-search__field")).sendKeys(arg1);
	   Thread.sleep(5000);
	   driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
	   
	   //selectOptionWithText(arg1);
	   
	}

	@When("^User enters mail details \"([^\"]*)\"\"([^\"]*)\"$")
	public void user_enters_mail_details(String arg1, String arg2) throws Throwable {
	   driver.findElement(By.name("title")).sendKeys(arg1);
	}

	@Then("^User clicks on Send message button$")
	public void user_clicks_on_Send_message_button() throws Throwable {
	    driver.findElement(By.name("compose")).click();
	}

	@Then("^User verifies message sent successfully$")
	public void user_verifies_message_sent_successfully() throws Throwable {
	    Assert.assertTrue("Message not sent successfully..",driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().contains("The message has been sent"));
	    driver.close();
	}

	/*------------------------------------*/

	@Then("^User clicks on Edit Profile tab$")
	public void user_clicks_on_Edit_Profile_tab() throws Throwable {
	    driver.findElement(By.xpath("//a[normalize-space()='Edit profile']")).click();
	}

	@Then("^attaches new image and selects language \"([^\"]*)\"$")
	public void attaches_new_image_and_selects_language(String arg1) throws Throwable {
	    
//		 Select dropdownB = new Select(driver.findElement(By.name("language"))); 
//	      dropdownB.selectByVisibleText(arg1); 
	      
	      driver.findElement(By.name("picture")).sendKeys("C:\\Users\\0018R9744\\Pictures\\IBM Training\\BDDvsTDD.png");
	}

	@Then("^enters new details \"([^\"]*)\" \"([^\"]*)\"$")
	public void enters_new_details(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("extra_skype")).sendKeys(arg1);
		driver.findElement(By.name("extra_skype")).sendKeys(arg2);
	}

	@Then("^User clicks on Save Settings$")
	public void user_clicks_on_Save_Settings() throws Throwable {
	    driver.findElement(By.name("apply_change")).click();
	}
	
	@Then("^User verifies settings saved successfully$")
	public void user_verifies_settings_saved_successfully() throws Throwable {
	    Assert.assertTrue("New Profile details not saved properly",driver.getPageSource().contains("Your new profile has been saved"));
	    Assert.assertTrue("New Profile picture not saved properly",driver.getPageSource().contains("Your picture has been uploaded"));
	    
	    driver.close();
	}
	
	
	
	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.className("select2-results__option select2-results__option--highlighted"));
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
}
