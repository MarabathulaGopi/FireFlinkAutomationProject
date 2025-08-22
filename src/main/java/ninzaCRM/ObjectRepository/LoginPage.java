package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule No 1
	
	//Rule 2 Idetify the Web elements using @FindBy , @FindAll, @FindBys
	
	//@FindBy - Identify the web elements
	
	@FindBy(id = "username") private WebElement userNameTF;
	@FindBy(id = "inputPassword") private WebElement passwordTF;
	@FindBy(xpath = "//button[.='Sign In']") private WebElement signInBtn;
	

	//Rule 3 Create a Constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public void loginToApp(String username,String password)
	{
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}
	
}
