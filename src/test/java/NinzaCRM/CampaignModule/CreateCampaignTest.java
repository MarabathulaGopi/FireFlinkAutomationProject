package NinzaCRM.CampaignModule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashboardPage;

import ninzaCRM.genericMethodsPractise.BaseClass;
@Listeners
public class CreateCampaignTest extends BaseClass {
	
	@Test(groups = {"SmokeSuite"})
	public void CreateCampaign() throws IOException {
		
		//Assert.fail();
		String CAMPAIGNNAME = fileu.readDataFromExcel("Sheet1", 19, 2);
		String CAMPAIGSTATUS = fileu.readDataFromExcel("Sheet1", 19, 3);
		String ClOSEDATE = fileu.readDataFromExcel("Sheet1", 19, 5);
		String TARGETSIZE = fileu.readDataFromExcel("Sheet1", 19, 6);
		String TARGETAUDIANCE = fileu.readDataFromExcel("Sheet1", 19, 7);
		String DESCRIPTION = fileu.readDataFromExcel("Sheet1", 19, 8);
	
        DashboardPage dp = new DashboardPage(driver);
        dp.clickOnCampains();
        
        CampaignsPage cp=new CampaignsPage(driver);
        cp.clickCreateCampaignButton();
        
        CreateCampaignPage cmp=new CreateCampaignPage(driver);
        cmp.createCampaign(CAMPAIGNNAME, CAMPAIGSTATUS, ClOSEDATE, TARGETSIZE, TARGETAUDIANCE, DESCRIPTION);
        System.out.println("-----CAMPAIGN CREATAED----");

	}
	
	@Test
	public void Sample()
	{
		System.out.println("Sample");
	}

}
