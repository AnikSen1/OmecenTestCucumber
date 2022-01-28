package omecenTestCucumber.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	

	protected WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="(//span[starts-with(text(),'Payments')])[3]") private WebElement payment;
	public WebElement paymentLink() {
		payment.click();
		return payment;
	}

}
