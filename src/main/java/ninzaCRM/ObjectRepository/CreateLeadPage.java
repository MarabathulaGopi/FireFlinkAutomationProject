package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	
	//@FindBy - Identify the web elements
	@FindBy(name = "name") private WebElement leadNameTF;
	@FindBy(name = "leadStatus") private WebElement leadStatusTF;
	@FindBy(name = "rating") private WebElement ratingTF;
	@FindBy(name = "company") private WebElement company;
	@FindBy(name = "assignedTo") private WebElement assignedToTF;
	@FindBy(name = "leadSource") private WebElement leadSourceTF;
	@FindBy(name = "address") private WebElement addressTF;
	@FindBy(name = "industry") private WebElement industryTF;
	@FindBy(name = "city") private WebElement cityTF;
	@FindBy(name = "annualRevenue") private WebElement annualRevenueTF;
	@FindBy(name = "country") private WebElement countryTF;
	@FindBy(name = "noOfEmployees") private WebElement numberOfEmployeesTF;
	@FindBy(name = "postalCode") private WebElement postalCodeTF;
	@FindBy(name = "phone") private WebElement phoneTF;
	@FindBy(name = "email") private WebElement emailTF;
	@FindBy(name = "secondaryEmail") private WebElement secondaryEmailTF;
	@FindBy(name = "description") private WebElement descriptionTA;
	@FindBy(xpath = "//*[local-name()='svg' and @data-icon='user'] ") private WebElement selectCampaignBtn;
	@FindBy(id = "search-criteria") private WebElement campaignDropdown;
	@FindBy(id = "search-input") private WebElement campaignIDTF;
	@FindBy(xpath = "//button[.='Select']") private WebElement campaginSelectBtn;
	

		
		
	//Rule 3 Create a Constructor
		
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	public WebElement getLeadNameTF() {
		return leadNameTF;
	}




	public WebElement getLeadStatusTF() {
		return leadStatusTF;
	}




	public WebElement getRatingTF() {
		return ratingTF;
	}




	public WebElement getCompany() {
		return company;
	}




	public WebElement getAssignedToTF() {
		return assignedToTF;
	}




	public WebElement getLeadSourceTF() {
		return leadSourceTF;
	}




	public WebElement getAddressTF() {
		return addressTF;
	}




	public WebElement getIndustryTF() {
		return industryTF;
	}




	public WebElement getCityTF() {
		return cityTF;
	}




	public WebElement getAnnualRevenueTF() {
		return annualRevenueTF;
	}




	public WebElement getCountryTF() {
		return countryTF;
	}




	public WebElement getNumberOfEmployeesTF() {
		return numberOfEmployeesTF;
	}




	public WebElement getPostalCodeTF() {
		return postalCodeTF;
	}




	public WebElement getPhoneTF() {
		return phoneTF;
	}




	public WebElement getEmailTF() {
		return emailTF;
	}




	public WebElement getSecondaryEmailTF() {
		return secondaryEmailTF;
	}




	public WebElement getDescriptionTA() {
		return descriptionTA;
	}




	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}




	public WebElement getCampaignDropdown() {
		return campaignDropdown;
	}




	public WebElement getCampaignIDTF() {
		return campaignIDTF;
	}




	public WebElement getCampaginSelectBtn() {
		return campaginSelectBtn;
	}
	
	//getters
	
	

}
