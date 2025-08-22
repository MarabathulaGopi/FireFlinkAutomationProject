package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    @FindBy(xpath="//span[.='Create Contact']")
    private WebElement createContactBtn;
    
    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateContactBtn() {
        return createContactBtn;
    }
    
    public void clickCreateContact() {
        getCreateContactBtn().click();
    }
    
}