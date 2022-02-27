package StepDefinitions;

import java.io.IOException;
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
import omecenTestCucumber.base.BaseClass;

public class BDDSteps extends BaseClass {

	
	
	WebDriver driver;
	LoginPage lp;
	InvoicePage ip;
	PaymentPage pp;
	
	
	@Given("^app is open$")
	public void app_is_open() throws IOException {
		openApp();

	}
	@When("^user enter userName and Password$")
	public void user_enter_user_name_and_password() throws IOException {
		lp= new LoginPage(driver);
		lp.userName(getProperties("uname"));
		lp.pWord(getProperties("pword"));	
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
