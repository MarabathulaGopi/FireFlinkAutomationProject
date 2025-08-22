package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	
	
	
	//@FindBy - Identify the web elements
		
	@FindBy(name = "campaignName") private WebElement campaignNameTF;
	@FindBy(name = "expectedCloseDate") private WebElement expectedCloseDateTF;
	@FindBy(name = "targetAudience") private WebElement targetAudienceTF;
	@FindBy(name = "campaignStatus") private WebElement campaignStatusTF;
	@FindBy(name = "description") private WebElement descriptionTF;
	@FindBy(name = "targetSize") private WebElement targetSizeTF;
	@FindBy(xpath = "//button[@type='submit']")	 private WebElement createCampaignBtn;
		
		
	//Rule 3 Create a Constructor	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	

	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}





	public WebElement getExpectedCloseDateTF() {
		return expectedCloseDateTF;
	}





	public WebElement getTargetAudienceTF() {
		return targetAudienceTF;
	}





	public WebElement getCampaignStatusTF() {
		return campaignStatusTF;
	}





	public WebElement getDescriptionTF() {
		return descriptionTF;
	}





	public WebElement getTargetSizeTF() {
		return targetSizeTF;
	}





	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}





	//Create campagin Page
	public void createCampaign(String campaignName1,String campaignStatus,String expectedCloseDate,String targetSize,
			String targetAudience,String description)
	{
		campaignNameTF.sendKeys(campaignName1);
		campaignStatusTF.sendKeys(campaignStatus);
		//expectedCloseDateTF.sendKeys(expectedCloseDate);
		targetSizeTF.sendKeys(targetSize);
		targetAudienceTF.sendKeys(targetAudience);
		//descriptionTF.sendKeys(description);
		createCampaignBtn.click();
	}
	
	
	
	
}
