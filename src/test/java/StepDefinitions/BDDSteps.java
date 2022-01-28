package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import omecenTestCucumber.PageObjects.InvoicePage;
import omecenTestCucumber.PageObjects.LoginPage;
import omecenTestCucumber.PageObjects.PaymentPage;

public class BDDSteps {

	
	
	WebDriver driver;
	String Browser="chrome";
	LoginPage lp;
	InvoicePage ip;
	PaymentPage pp;
	
	
	@Given("^app is open$")
	public void app_is_open() {


		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}else {System.out.println("diver is null");}
		driver.get("https://inventory.omecen.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@When("^user enter userName and Password$")
	public void user_enter_user_name_and_password() {
		lp= new LoginPage(driver);
		lp.userName("admin");
		lp.pWord("admin_test");	
	}

	@Then("^click on submit button$")
	public void click_on_submit_button() {
		lp= new LoginPage(driver);
		lp.signIn();	
	}

	@When("^user click on invoice page$")
	public void user_click_on_invoice_page() {
		ip=new InvoicePage(driver);
		ip.invoiceLink();
	}

	@Then("^user validate the invoice title$")
	public void user_validate_the_invoice_title() {
		System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Inventory Software");
		
	}

	@And("^user close the app$")
	public void user_close_the_app() {
		driver.quit();
	}

	@When("^user click on payement page$")
	public void user_click_on_payement_page() {
          pp=new PaymentPage(driver);
          pp.paymentLink();
	}

	@Then("^user validate payment title$")
	public void user_validate_payment_title() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Inventory Software");
	}

	@When("^user click on purches page$")
	public void user_click_on_purches_page() {

	}

	@Then("^user validate the purches title$")
	public void user_validate_the_purches_title() {
		
	}




}
