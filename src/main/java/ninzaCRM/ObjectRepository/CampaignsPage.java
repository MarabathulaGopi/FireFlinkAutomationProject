package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	//@FindBy - Identify the web elements
	@FindBy(xpath = "//select[@class='form-control']") private WebElement campignDropDown;
	@FindBy(xpath = "//input[@placeholder='Search by Campaign Id']") private WebElement campignIdTF;
	@FindBy(xpath = "//span[.='Create Campaign']") private WebElement createCampaignBtn;
	

	//Create a Constructor	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampignDropDown() {
		return campignDropDown;
	}

	public WebElement getCampignIdTF() {
		return campignIdTF;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	
	//Business libraries
	public void clickCreateCampaignButton()
	{
		createCampaignBtn.click();
	}

	
	
	

}
