package omecenTestCucumber.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	
	
	protected WebDriver driver;

	public InvoicePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Invoice") private WebElement invoice;
	public WebElement invoiceLink() {
		invoice.click();
		return invoice;
	}
	
}
