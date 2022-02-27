package omecenTestCucumber.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

@FindBy(how=How.XPATH, using="//input[@placeholder='Username']") private WebElement uName;
public WebElement userName(String username) {
	uName.clear();
	uName.sendKeys(username);
    return uName;
}

@FindBy(how=How.XPATH, using="//input[@placeholder='Password']") private WebElement pWord;
public WebElement pWord(String password) {
	pWord.clear();
	pWord.sendKeys(password);
    return pWord;

}


@FindBy(how=How.XPATH, using="//button[@id='kt_login_signin_submit']") private WebElement signin;
public WebElement signIn() {
	signin.click();
    return signin;
}

	}


