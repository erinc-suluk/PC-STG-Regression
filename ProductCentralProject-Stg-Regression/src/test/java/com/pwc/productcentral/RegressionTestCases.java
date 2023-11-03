package com.pwc.productcentral;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AuthoringPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.HomePageTemplatePage;
import Pages.LegalPage;
import Pages.LoginPageObjects;

import Pages.ProductListingPage;
import Pages.ProductPage;
import Pages.ResellerPage;
import Pages.SecurityPage;
import Pages.UMSPage;


public class RegressionTestCases extends BasePage {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ProductListingPage plp=new ProductListingPage();
	HomePageTemplatePage hpt=new HomePageTemplatePage();
	ResellerPage rp=new ResellerPage();
	LegalPage lp=new LegalPage();
	SecurityPage sp=new SecurityPage();
	ProductPage pp=new ProductPage();
	AuthoringPage ap=new AuthoringPage();
	UMSPage ums=new UMSPage();
	screenshotUtil ssu=new screenshotUtil();
	private ExtentTest test;
	
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	


	
	@BeforeSuite
	public void setUp() {
		 PropertyConfigurator.configure(".\\log4j.properties");
		 read = new ConfigurationsReader();
		 platform = read.getPlatform();
		 read.platformName();
		 String reportFilePrefix="Regression Automation Report for Product Central";
		 File[] files=new File(".").listFiles((dir,name)->name.startsWith(reportFilePrefix));
		 if(files!=null) {
			 for(File file: files) {
				 file.delete();
			 }
		 }
		 String reportFileName=reportFilePrefix + ".html";
		 htmlReporter = new ExtentHtmlReporter(reportFileName);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "STG");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Regression Test Case********************************************************/
	
	
	@Test
	public void WEB_1() throws Exception{
		  String testName = "Verify the updated color of the title on the tiles is black.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15)); 
		        hp.setTitlesColor(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName); 
		    }
	}
	@Test
	public void WEB_2() throws Exception{
		  String testName = "Verify that two separate pages under Product central/Privacy and Product central/Security page on site navigation.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setVerifySeperatePages(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	
	}
	
	@Test
	public void WEB_3() throws Exception{
		 String testName = "Verify that documentation tile changed to Privacy and Security with an updated description";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 45));
		        plp.setDocumentationTileChanging(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test
	public void WEB_4() throws Exception{
		 String testName = "Verify the collapse icon is responsible for collapsing and expanding left navigation";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setCollapseButton(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	
	}
	@Test
	public void WEB_5() throws Exception{
		 String testName = "Verify left navigation component will appear on the left side";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setLeftNavigationItems2();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_6() throws Exception{
		 String testName = "Verify that when user click on breadcrumb then user go to previous page";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbs();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test
	public void WEB_7() throws Exception{
		 String testName = "Verify that breadcrumb is visible to user";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbsVisibility();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_8() throws Exception{
		String testName = "Verify the description describe the product/site /page itself";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 46));
	        plp.setProductDescription(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_9() throws Exception{
		String testName = "Verify the product title and description are visible to the users of the page/site";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 46));
	        plp.setProductTitleandDescriptionVisibility(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_10() throws Exception{
		String testName = "Verify the system will know which link to present based on the "
				+ "content pages available for the product. For e.g. this could be done via tags "
				+ "(matching the tags between pages and assets, such as the product tag and the document type tag)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setContentPageTags();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test
	public void WEB_11() throws Exception{
		String testName = "Verify 'Download Full Terms' link will download all the content page related assets for the product in a zip file";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setDownloadFullTermsLink();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_12() throws Exception{
		String testName = "Verify homepage can host a maximum of ‘15’ tiles.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesNumber(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_13() throws Exception{
		String testName = "Verify My products tile will contain a ‘login to my products’ tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesHasLoginLink(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test
	public void WEB_14() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to a hyperlink page within the tab";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLegalTile();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test
	public void WEB_15() throws Exception{
		String testName = "Verify that when user click on collapse icon under the left nav,then left nav will collapse and only the icons/image for each item will appear";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_16() throws Exception{
		String testName = "verify promotion banner must contain a page title \"Welcome to Product Central \"";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setPromoTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_17() throws Exception{
		String testName = "Verify the user is able to view the title, description, Image and my product button on the banner";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setPromotionBannerElements();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_18() throws Exception{
		String testName = "Verify the company will host the page title, description ,image ,link/button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setPromotionBannerElements();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test
	public void WEB_19() throws Exception{
		String testName = "Verify that when user click on collapse icon then left navigation component name will be collapsing and after click then expanding";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseExpandButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	@Test
	public void WEB_20() throws Exception{
		String testName = "Verify that all the component present in footer bar";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFooterBar();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_21() throws Exception{
		String testName = "Verify that the description in the tile only be a maximum of 6 lines, anything more than that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setDescriptionOfTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test
	public void WEB_22() throws Exception{
		String testName = "Verify that footer are persistent on all PC pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setVerifyFooter(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_23() throws Exception{
		String testName = "Verify that when user hover over, the mouse icon then tiles color will change to indicate clickability";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setClickability();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_24() throws Exception{
		String testName = "Verify that text is showing with ellipses if the name of the product is too long.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setProductNameLength();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_25() throws Exception{
		String testName = "Verify that The alignment of the all text are vertically centered.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setProductAlignment();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_26() throws Exception{
		String testName = "Verify that The tile height should remain the same as previous";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setTilesHeight();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_27() throws Exception{
		String testName = "Verify that portfolio remains unchanged such as dropdown and behavior";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setPortfolioDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_28() throws Exception{
		String testName = "Verify that hover over remains unchanged";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setPortfolioDropdownHoverOver();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_29() throws Exception{
		String testName = "Verify that the items do not differ between non and logged in users";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelp();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_30() throws Exception{
		String testName = "Verify that icon allow expand and collapse and it moves to the bottom";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelpExpandCollapse();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_31() throws Exception{
		String testName = "verify the users must be able to use the filters to narrow down the search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	

	@Test
	public void WEB_32() throws Exception{
		String testName = "verify as there is no limit on the number of search results that are needed to be displayed, "
				+ "the system needs to display all the search results using pagination";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLimitOfSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_33() throws Exception{
		String testName = "verify on hover over the search result title will turn Orange";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setOrangeSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_34() throws Exception{
		String testName = "verify default state of search results will display in a black text";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setBlackSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_35() throws Exception{
		String testName = "verify all search results are presented as line items";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLineItems();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_36() throws Exception{
		String testName = "Verify sort by is not multi select";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setNotMultiSelectSortingDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_37() throws Exception{
		String testName = "Verify sort by is used to sort the search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setSortingSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_38() throws Exception{
		String testName = "Verify the title of the page is ‘Search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTitleofThePage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_39() throws Exception{
		String testName = "Verify on click of it the user will be navigated to the PC homepage or my products depending on where the user came from";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setNavigateHomepage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_40() throws Exception{
		String testName = "Verify by default it will be blue but on hover over it will turn Orange.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setColorDifferences();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_41() throws Exception{
		String testName = "Verify the’ back to home’ breadcrumb appear on the top left corner of the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setBackoHomeBreadcrumb();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_42() throws Exception{
		String testName = "Verify that the items in the dropdown are multiselect";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setMultiselectDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_43() throws Exception{
		String testName = "Verify that Product filter needs to reflect values to match the PC products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFilterMatchingSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_44() throws Exception{
		String testName = "Verify that there will be two filters present on the global search results page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTwoFilteronGlobalSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_45() throws Exception{
		String testName = "Verify that user entered keyword remains into search bar either user select "
				+ "suggested product name or not & submitted keyword doesn't match any result.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setSearchBarKeywordforNegativeTest();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_46() throws Exception{
		String testName = "Verify product names is present on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 42));
	       lp.setProductsNamePresent();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_47() throws Exception{
		String testName = "Verify tile title, description, and thumbnail is repeated across Products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setTitleDescriptionThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_48() throws Exception{
		String testName = "Verify there will never be a case when there are zero tiles on the page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 8));
	        rp.setZeroTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_49() throws Exception{
		String testName = "Verify on hover over the tile thumbnail should light up";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setLightUpThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_50() throws Exception{
		String testName = "Verify document tiles can have only 3 lines of descriptions, anything more than that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setDescriptionOfTiles2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_51() throws Exception{
		String testName = "Verify page title and description component displays the name of the product";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setMatchingTitleAndDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_52() throws Exception{
		String testName = "Verify that clicking on the tile user will navigate to the content page in the same tab";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 48));
	        rp.setContentPageOpensSameTab();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_53() throws Exception{
		String testName = "Verify that clicking on the breadcrumb user will navigate to the previous/parent page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 48));
	        rp.setBreadcrumbs2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_54() throws Exception{
		String testName = "Verify that breadcrumb is populated on site hierarchy";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 48));
	        rp.setBreadcrumbsHierarchy();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_55() throws Exception{
		String testName = "Verify on click on the product name the user will be navigated to the asset page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setNavigateAssetPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_56() throws Exception{
		String testName = "Verify the component titile and description is visible to user";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setTitleandDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_57() throws Exception{
		String testName = "Verify the user will only select the pages/path for the tiles that need to appear.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setSelectTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_58() throws Exception{
		String testName = "Verify when user hover over the curser on name of the product will turn blue";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setColorChanging();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_59() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to legal product listing page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setLegalProductListingPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_60() throws Exception{
		String testName = "Verify every PC doc category will be mapped to a set pattern as a thumbnail, which will appear on the tile.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setThumbnails();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_61() throws Exception{
		String testName = "Verify on hover over the title and tile image/icon should light up";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setLightUpThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_62() throws Exception{
		String testName = "Verify document tile will contain the following details: Title (legal doc category),"
				+ "Document Description,Image/pattern present on the right side of the tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        lp.setTitleDescriptionThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_63() throws Exception{
		String testName = "verify the use is able to view the Doc name, description, pattern on the tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setTitleDescriptionThumbnail2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_64() throws Exception{
		String testName = "Verify every PC doc category will be mapped to a set pattern as a thumbnails which will appear on the tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setThumbnails();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_65() throws Exception{
		String testName = "Verify view all products button is visible on my product page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setAllProductsButtonVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_66() throws Exception{
		String testName = "Verify this component must contain a link/button for my product page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setAllProductsButtonFunctionality();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_67() throws Exception{
		String testName = "verify the footer must have legal disclaimer along with link and year at the start of the footer ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFooterYear();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_68() throws Exception{
		String testName = "Verify that date format within the content page is MM/DD/YYYY";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setDateFormat();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_69() throws Exception{
		String testName = "Verify that the Related links component (right rail) should be "
				+ "converted to a drop down menu when the screen size is < 1300 px";
	    ExtentTest test = extent.createTest(testName);

	    try {
	    	 Driver.getDriver().get(read1.getCellData("VALUE", 14));
		     plp.setRelatedLinkSize();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_70() throws Exception{
		String testName = "Verify if user is not logged in then My products should not be visible";
	    ExtentTest test = extent.createTest(testName);

	    try {
	    	 Driver.getDriver().get(read1.getCellData("VALUE", 15));
	    	 BasePage.setNotDisplayedMyProduct();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_71() throws Exception{
		String testName = "User clicks on the sort by the filter, the user must see two options in the dropdown I,e 1- A-Z "
				+ "(arranges products in ascending order) 2- Z-A (arranges products in descending order)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 42));
	        lp.setFilterOptions();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_72() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setNavigateContentPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_73() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setDisplayTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_74() throws Exception{
		String testName = "Verify the tiles must always appear in a fixed order.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setFixedOrder();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_75() throws Exception{
		String testName = "Verify there will never be a case when there are zero tiles on the page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setZeroTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_76() throws Exception{
		String testName = "Verify breadcrumbs will be populated based on the site hierarchy.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setBreadcrumbsHierarchy();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_77() throws Exception{
		String testName = "Verify on clicking the collapse icon under the left navigation,"
				+ " the left navigation will collapse and only the icon/ image for which item will appear, and the main content of the site will shift left";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_78() throws Exception{
		String testName = "verify on clicking collapsed the left nav should return to its original state, "
				+ "where the user can see the icon/image and the verbiage for the items in the left nav.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_79() throws Exception{
		String testName = "Verify author can add inline hyperlink";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	       // lpo.setLogin();
	        ap.setPrivacyHubInline();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_80() throws Exception{
		String testName = "Verify that Based on user input, the search box loads/auto suggests results in a drop down dialogue box that matches the keyword and "
				+ "The auto suggestions are the product names that are available in the product listing page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setAutoSuggestion();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_81() throws Exception{
		String testName = "Verify that on selection a result, display the relevant product on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setRelevantProduct();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_82() throws Exception{
		String testName = "Verify document tiles can have only 3 lines of descriptions, anything more than that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 46));
	        plp.setDescriptionOfTiles2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }

	}
	@Test
	public void WEB_83() throws Exception{
		String testName = "Verify that The component will host 15 number tiles, one for each area of the site";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setTilesNumber2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
}
		
	
	}
	@Test
	public void WEB_84() throws Exception{
		 String testName = "Verify title is system authored";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 6));
		        plp.setProductsTitle();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_85() throws Exception{
		 String testName = "Verify the pages will be tagged by the author manually";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 45));
		        plp.setLinksTags();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_86() throws Exception{
		String testName = "Verify that while downloading the full terms the file should be saved with meaningful name";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setDownloadFullTermsLinkName();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_87() throws Exception{
		String testName = "Verify that If page is published without ‘hide from search’, the child content page(s) will be searchable to site visitors. "
				+ "And they can deep link to that published page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 51));
	        plp.setSearchableContentPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_88() throws Exception{
		String testName = "Verify that if the download is done multiple times on the same day, then the file is properly downloaded";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setDownloadFullTermsLink();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_89() throws Exception{
		String testName = "Verify approval workflow are as follows : \"Author ---> Approver --> Publish\"";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 17));
	        lpo.setLogin3();
	        ap.setWorkflowApproval();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_90() throws Exception{
		String testName = "Verify that once user executes this workflow, it should automatically unpublish the page or asset";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin3();
	        ap.setUnpublishWorkflow2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
		
	}
	
	
	@Test
	public void WEB_91() throws Exception{
		String testName = "Verify that as a author or publisher with appropriate license or permissions should be able to trigger this work flow without any approval.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setExpressWorkflowApproval();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_92() throws Exception{
		String testName = "Verify that 'Workflow title' field is mandatory";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setWorkflowApproval2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_93() throws Exception{
		String testName = "Verify the footer must be able to system authored";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 10));
	        lpo.setLogin4();
	        hp.setFooterSystemAuthored();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_94() throws Exception{
		String testName = "Verify user must be able to manually author the content and link of footer";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 27));
	        lpo.setLogin4();
	        ap.setAuthFooter();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_95() throws Exception{
		String testName = "Verify if one user is able to complete/approve the workflow";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 17));
	        lpo.setLogin4();
	        ap.setWorkflowApproval();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_96() throws Exception{
		String testName = "Verify user is able to author image";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 50));
	        lpo.setLogin4();
	        ap.set403Image();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_97() throws Exception{
		String testName = "Verify user is able to author title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 50));
	        lpo.setLogin4();
	        ap.set403Title();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_98() throws Exception{
		String testName = "Verify user is able to author description";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 50));
	        lpo.setLogin4();
	        ap.set403Description();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_99() throws Exception{
		String testName = "Verify that given image for 403 error page is visible error message";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 50));
	        lpo.setLogin4();
	        ap.set403Visibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_100() throws Exception{
		String testName = "Verify user is able to author title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 53));
	        lpo.setLogin4();
	        ap.set500Title();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_101() throws Exception{
		String testName = "Verify user is able to author text";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 53));
	        lpo.setLogin4();
	        ap.set500Description();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_102() throws Exception{
		String testName = "Verify release notes component will continue to allow only 5 items";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 54));
	        lpo.setLogin4();
	        ap.setReleaseNotes2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_103() throws Exception{
		String testName = "Verify that author is able to pick image(HomePage)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 55));
	        lpo.setLogin4();
	        ap.setHomeImage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_104() throws Exception{
		String testName = "Verify that author is able to define description(HomePage)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 55));
	        //lpo.setLogin4();
	        ap.setHomeDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_105() throws Exception{
		String testName = "Verify that the existing workflow notification requirements are also applied for Privacy Hub workflow.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 17));
	        lpo.setLogin4();
	        ap.setPrivacyHubWorkflow();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_106() throws Exception{
		String testName = "Verify that author should be able to configure the accordion";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 56));
	        lpo.setLogin4();
	        ap.setFAQAccordion();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_107() throws Exception{
		String testName = "Verify that an author should be able add links (link url and link text) within the answer fields.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 56));
	        lpo.setLogin4();
	        ap.setFAQAddLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_108() throws Exception{
		String testName = "Verify headings predefined styles (H1 to H6)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 57));
	        lpo.setLogin4();
	        ap.setPrivacyHucHeadingStyle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_109() throws Exception{
		String testName = "Verify body supports tables, hyperlinks, rich text";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 57));
	        lpo.setLogin4();
	        ap.setPrivacyHubBody();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_110() throws Exception{
		String testName = "Verify thtat the FAQ page is a page with accordions of items that an author manually defines (both question and answer text and the order)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 56));
	        lpo.setLogin4();
	        ap.setFAQEditableAreas();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_111() throws Exception{
		String testName = "Verify that the system generated date of the date the page was published";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setPrivacyHubPublishingDate();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_112() throws Exception{
		String testName = "Verify that once user executes this workflow, it should automatically unpublish the page or asset";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setExpressUnpublishWorkflow();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_113() throws Exception{
		String testName = "Verify that as a author or publisher with appropriate license or permissions should be able to trigger this work flow without any approval.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setExpressOptions();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_114() throws Exception{
		String testName = "Verify if a user is able to create a new legal page and can add components to it";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 59));
	        lpo.setLogin4();
	        ap.setCreateLegalPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_115() throws Exception{
		String testName = "Verify the author must be able to manually define the promotion description";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 60));
	        lpo.setLogin4();
	        ap.setEditHeroDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_116() throws Exception{
		String testName = "verify the author must be able to define the link for my products page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 55));
	        lpo.setLogin4();
	        ap.setDefineLinkforMyProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
}
		
	
	}
	@Test
	public void WEB_117() throws Exception{
		String testName = "Verify the need technical product must be able to manually authored";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 60));
	        lpo.setLogin4();
	        ap.setEditTechnicalSupport();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_118() throws Exception{
		 String testName = "Verify the system will allow all roles to preview a given page as a published page regardless of the state or stage in the authoring process";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 55));
		        lpo.setLogin4();
		        ap.setPreviewButton2();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_119() throws Exception{
		 String testName = "Verify unpublish workflow are as follows : \"Author → Approver → Unpublish\"";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 67));
		        lpo.setLogin4();
		        ap.setUnpublishWorkflowApproval();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_120() throws Exception{
		 String testName = "Verify unpublish workflow requires approval from the appropriate approval group or user(s) selected by the Author";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 67));
		        lpo.setLogin4();
		        ap.setUnpublishWorkflowApproval2();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_121() throws Exception{
		 String testName = "Verify the asset section default is sorted by the most recent published date  (for the assets) "
		 		+ "the assets in the section will be sorted by published date, the most recent article will be displayed on top";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 61));
		        lpo.setLogin4();
		        ap.setAssetsDate();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_122() throws Exception{
		 String testName = "Verify that if we reorder them into the site structure then it is reflecting on the related links or not";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 63));
		        lpo.setLogin4();
		        ap.setReorderTiles();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test
	public void WEB_123() throws Exception{
		String testName = "verify in addition, the system will provide both a manually and system-defined publish date, which would be displayed on the published page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 19));
	        lpo.setLogin4();
	        ap.setPublishDate();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_124() throws Exception{
		String testName = "Verify that author should be able to configure the product page once all the child pages are approved and then publish the product page. "
				+ "Until then this product page should be hidden";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 51));
	       // lpo.setLogin4();
	        ap.setHidingFromList();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_125() throws Exception{
		String testName = "Verify author is able to create sitemap page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setSitemapPage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_126() throws Exception{
		String testName = "Verify user is able to navigate to any of the links printed within the sitemap";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 65));
	        lpo.setLogin4();
	        ap.setNavigateLinksSitemap();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_127() throws Exception{
		String testName = "Verify if a user is logged in he should be able to see the products under my products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 65));
	        lpo.setLogin4();
	        ap.setMyProductsinSitemap();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_128() throws Exception{
		String testName = "Verify there is preconfigured text with the author populating some content and is applicable for all 3 banners";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerText();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_129() throws Exception{
		String testName = "Verify product-specific Myproducts banner is set by the AEM Author role and applies to the specific Myproducts page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerforSpecificProduct();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_130() throws Exception{
		String testName = "Verify banner designs are predetermined based on type of outage"
				+"/ Verify that the type of outage or degradation is displayed on the pages as per the below severity.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerTypes(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_131() throws Exception{
		String testName = "Verify the banner is managed within the session, if a new session is started and the banner is still active within AEM the banner should display";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerDisplayed();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
    public void WEB_132() throws Exception{
        String testName = "Verify that when user is logged in or logged out and he/she clicks on PwC Product central logo then homepage is loaded.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setOpenHomePagePwcLogo();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	@Test
	public void WEB_133() throws Exception{
		String testName = "Verify that within the modal when the user clicks on a product they are taken to that product page and the modal closes";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setModalClose();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	
	
	
	@Test
	public void WEB_134() throws Exception{
		String testName = "Verify if the title exceeds 4 lines it should be able to handle via authoring or ellipse will be added.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setTitleOfAssets();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test
	public void WEB_135() throws Exception{
		String testName = "Verify that author/end user should be able to see the icon on the published page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setFooterIconVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_136() throws Exception{
		String testName = "Verify If the user closes the banner then this action is retained during the session, and upon"
				+ " return visit if the outage still persists then the banner will be displayed again"
				+"/ Verify that AEM is receiving the below details from UMS for each outage or degradation notifications.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 89));
	        lpo.setLogin4();
	        ap.setBannerClose(test);
	        test.pass("WEB_136 passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	
	
	@Test
	public void WEB_137() throws Exception{
		String testName = "Verify that the background text is white only";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setHeroPromotionDesign();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_138() throws Exception{
		String testName = "verify the search bar is at the top of the My Products page template"
				+"/ Verify that search box is available on all devices(desktop, tablet, mobile)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMyProductSearchBar(test); 
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_139() throws Exception{
		String testName = "verify the user can select & unselect products just by clicking on it";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setFilterMyProductSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_140() throws Exception{
		String testName = "Verify that search product bar accepts the user input keywords";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setInputKeywords();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_141() throws Exception{
		String testName = "Verify that search product bar is used for searching products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setSearchingProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_142() throws Exception{
		String testName = "Verify any user can use global search";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setUsingGlobalSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_143() throws Exception{
		String testName = "Verify My Products search is only accessible on a My Products page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMyProductSearchAccessibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_144() throws Exception{
		String testName = "Verify field supports special characters";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAcceptingSpecialChar();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_145() throws Exception{
		String testName = "Verify that on click of search product bar, the borders of the search bar lights up ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setSearchBarLight();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_146() throws Exception{
		String testName = "Verify product names is present on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setProductNameVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_147() throws Exception{
		String testName = "Verify that the My Products search is only accessible on a My Products page, which requires login and permission."
				+"/ Verify that user is able to see document category label for each tile under 'Latest' and 'For You' sections on MyProducts pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setSearchProductAccessibility(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_148() throws Exception{
		String testName = "Verify the cards are sorted by published date";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        pp.setAssetsDate();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_149() throws Exception{
		String testName = "Verify the default state is previous control must be disabled";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllResourcesPrevious();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_150() throws Exception{
		String testName = "Verify when the user click on previous will display will bring back the previous 5 assets";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setBringBack5Assets();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_151() throws Exception{
		String testName = "Verify when a filter value is selected the list is refreshed and filter accordingly";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setTagsAccompany();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	/*@Test
	public void WEB_152() throws Exception{
		String testName = "Verify the filter values are populated by the tag taxonomy";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setFilterValuesPopulateTagTaxonomy(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}*/
	@Test
	public void WEB_153() throws Exception{
		String testName = "Verify there is no search as you type/auto suggestion";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setNoAutoSuggestionSearchBar();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_154() throws Exception{
		String testName = "Verify My Products is a page label";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMyProductLabel();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_155() throws Exception{
		String testName = "Verify the footer will stay persistent on all product central pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setFooterPersistance();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_156() throws Exception{
		String testName = "Verify the header should stay persistent on all P.central pages ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        BasePage.setHeaderPersistance(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_157() throws Exception{
		String testName = "Verify the landing on the product central landing page the user must be able to see the following section of the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllSectionsonthePge();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_158() throws Exception{
		String testName = "Verify the user is login he/she should be redirect to the site upon login";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMyProductPageVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_159() throws Exception{
		String testName = "verify On click the user icon logout option must appear";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setLogoutOption();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_160() throws Exception{
		String testName = "verify when the user logs in the initials are displayed in upper case on the top right corner";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setUserInitials2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_161() throws Exception{
		String testName = "Verify footer will be included in all product central pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setFooterPersistance();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_162() throws Exception{
		String testName = "verify the position of the search must appear in the middle of the header";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setSearchButtonPlace();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_163() throws Exception{
		String testName = "verify that pwc product central image position must be on left most corner of page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setLogoPlace();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_164() throws Exception{
		String testName = "Verify mouse cursor changes from a pointer to hand on the link";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setCursorChanging();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_165() throws Exception{
		String testName = "Verify no broken links on footer section.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setNoBrokenLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_166() throws Exception{
		String testName = "Verify the page when user click on the link correct page should be loaded ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setNoBrokenLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	
	@Test
	public void WEB_167() throws Exception{
		String testName = "Verify that if user have access to more than 2 Myproducts pages the tabs navigation will switch to the modal experience";
	    ExtentTest test = extent.createTest(testName);

	    try {
	    	 Driver.getDriver().get(read1.getCellData("VALUE", 15));
	    	 lpo.setLogin2();
	    	 pp.setInsideViewAllProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_168() throws Exception{
		String testName = "Verify all the products will be presented under the My Products label.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setModalTitle(); 
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_169() throws Exception{
		String testName = "Verify that the first product in the Modal is the product being viewed.The remaining are products are alphabetical. ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setProductSorting();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	@Test
	public void WEB_170() throws Exception{
		String testName = "Verify load more is responsible for displaying more assets for the product";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setLoadMoreButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_171() throws Exception{
		String testName = "Verify by default the tiles will be greyed out";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setForYouTitlesColor();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_172() throws Exception{
		String testName = "Verify the user is able to see view less button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setViewLessButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_173() throws Exception{
		String testName = "Verify  on hover over the color must return to the tiles";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setLightUpThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_174() throws Exception{
		String testName = "Verify If the user clicks on the asset/tile it must open in a new tab";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setOpenNewTab();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_175() throws Exception{
		String testName = "Verify that after clicking on the pwc logo it should load the My Product page of the user.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setClickingonLogo();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_176() throws Exception{
		String testName = "Verify the right navigation column space should be turned off or on,";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setRightSpace();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_177() throws Exception{
		String testName = "Verify that the right column consists of product icon";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMyProductIcon();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_178() throws Exception{
		String testName = "Verify that the no hyperlink or clicking";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setHeroPromotionNotClickable();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_179() throws Exception{
		String testName = "verify that the height of both the title and body text should be vertically centered within the white space";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setHeroPromotionContentVericallyCentered();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_180() throws Exception{
		String testName = "Verify 404 page should appear to all Site Visitors that are trying to access a page that does not exist";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.set404Page();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_181() throws Exception{
		String testName = "Verify the message \"404: This page doesn’t exist. "
				+ "If you are looking for information about PwC products, please visit here to learn more.\"";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 82));
	        lpo.setLogin4();
	        pp.set404Page2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_182() throws Exception{
		String testName = "Verify release notes should not be duplicated between the All resources and Release notes components";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setCompareReleaseandAllResourcesElements();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_183() throws Exception{
		String testName = "Verify when user click preference a modal will pop-up";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setPreferencesModal();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_184() throws Exception{
		String testName = "Verify that upon first login, the toggle should be at “off” position and consent unchecked";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setPreferencesToggle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_185() throws Exception{
		String testName = "Verify that when user decide to opt-in they will switch to on, and then check the consent only then the submit button will be active.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setPreferencesConsent();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_186() throws Exception{
		String testName = "verify there should be a gated and non-gated set of footer items";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        pp.setDifferentFooterItems();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_187() throws Exception{
		String testName = "verify the user must be able to view the footer";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        pp.setFooterVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_188() throws Exception{
		String testName = "verify the user is able to use the links and navigate to other pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        pp.setFooterEachLink();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_189() throws Exception{
		String testName = "Verify that for gated content it is mandatory to provide the browser title.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setGatedContent();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_190() throws Exception{
		String testName = "verify users products shall be listed in the on the left side of the search results as buttons";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setListedProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_191() throws Exception{
		String testName = "verify the user is able to select one or more that one document category to filter out results.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setFilterMoreDocument();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	
	@Test
	public void WEB_192() throws Exception{
		String testName = "Verify the hero promotion is responsible for displaying the product title and a brief summary";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setProductTitleandDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_193() throws Exception{
		String testName = "Verify text on the tile will be restricted to three lines only anything after that will be truncated";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllResourcesTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_194() throws Exception{
		String testName = "Verify all resources are dedicated to all applicable product-specific content items";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllResourcesContent();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_195() throws Exception{
		String testName = "Verify more than 4 lines or anything longer that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setForYouTitles(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_196() throws Exception{
		String testName = "Verify cards must be sorted by most recent published date";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAssetsDate();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_197() throws Exception{
		String testName = "Verify the latest section is responsible for displaying the three most recently published assets for the product";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setLatestAssets();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_198() throws Exception{
		String testName = "Verify the tabs will be alphabetically sorted";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setOrderedProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test
	public void WEB_199() throws Exception{
		String testName = "There are some products within the MyProducts section that will not enable the related products component. "
				+ "Verify that the second line is removed when the related products are not enabled.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        //lpo.setLogin2();
	        pp.setSeperator();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	@Test
	public void WEB_200() throws Exception{
		 String testName = "Verify release notes should not be duplicated between the All resources and Release notes components";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setNotDublicatedReleaseNotes();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_201() throws Exception{
		 String testName = "Verify any asset that will be have the respective product, feature, and release notes tags should show up in the release notes";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setReleaseNotesVisibilityonDropdown();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_202() throws Exception{
		 String testName = "Verify that the Release notes dropdown selection will filter the All Resources to the Release notes type only.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setReleaseNotesFilter();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_203() throws Exception{
		 String testName = "Verify the Release notes document type should be excluded from the other Myproducts components such as Latest and For you section";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setDifferenceFromAssetTitlesandReleaseNote();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_204() throws Exception{
		 String testName = "Verify that the document category for logged-in is a combination of PC and My Products categories";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        hp.setDisplayedTwoDropdown();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_205() throws Exception{
		 String testName = "Verify My Product Doc Category - used for My Products related content";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setDropdownMatchwithProducts();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_206() throws Exception{
		 String testName = "verify the list must be alphabetically sorted";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setDropdownAlphabetical();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_207() throws Exception{
		 String testName = "Verify assets in the section will be sorted by published date";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setPublishDate();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	
	
	@Test
	public void WEB_208() throws Exception{
		 String testName = "Verify filter is used for  targeting specific content types (will be defined in metadata dictionary)";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setFilterTargetSpecificContent();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test
	public void WEB_209() throws Exception{
		String testName = "Verify for any error the field must have a red background";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setRedBackground();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_210() throws Exception{
		String testName = "Verify if there is any error, the system must highlight the respective field in red";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setMandatoryFieldError();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_211() throws Exception{
		String testName = "Verify the display error message is in red and bold for the following fields";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setErrorFont();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_212() throws Exception{
		String testName = "Verify the close and 'X' button functionality ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCloseButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_213() throws Exception{
		String testName = "verify admin is able to edit user details from the product user list page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setEditButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_214() throws Exception{
		String testName = "verify the user name and email is present in the light box";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUsernameEmailVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_215() throws Exception{
		String testName = "Verify search field";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSearchFunctionality();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_216() throws Exception{
		String testName = "Verify after clicking on the 'X' icon navigates the user back to UMS homepage";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCloseButtonNavigatesUMSHomepage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_217() throws Exception{
		String testName = "Verify 'X' icon aborts add user function";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCloseAddUserFunctionality();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_218() throws Exception{
		String testName = "Verify after canceling navigates the user back to UMS homepage";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCancelAddUser();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_219() throws Exception{
		String testName = "Verify Cancel aborts add user function";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCancelAddUser2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_220() throws Exception{
		String testName = "Verify after clicking on Save button user's data gets saved";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSaveButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_221() throws Exception{
		String testName = "Verify for user there will be no user selection by default";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setAdminRights();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_222() throws Exception{
		String testName = "Verify that the dropdown field has two options to choose from 1) User (default value), 2) Admin.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserLevelOptions();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_223() throws Exception{
		String testName = "Verify the user can only select one user level for the user as a user can not have two roles within the company.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setNotAcceptMultiselect();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_224() throws Exception{
		String testName = "Verify if the user selects the role as a user then they need to select the product(s) "
				+ "from the select product dropdown for which they need to provide them access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserNeedsSelectProduct();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_225() throws Exception{
		String testName = "Verify select product is a multi-select dropdown field displaying all the products which the company has a license";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setMultiselectProductDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_226() throws Exception{
		String testName = "Verify the Select product field is used to select the product(s) for which the user needs to be provided access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSelectProductDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_227() throws Exception{
		String testName = "Verify a dropdown field to capture user role in the company";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserLevel();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_228() throws Exception{
		String testName = "Verify user can add emails from any domain.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setAnyDomainEmail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_229() throws Exception{
		String testName = "Verify a text box to capture user's First name";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setFirstNameBox();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_230() throws Exception{
		String testName = "Verify a text box to capture user's Last name";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setLastNameBox();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_231() throws Exception{
		String testName = "Verify value entered must be an email";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setEmailValue();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_232() throws Exception{
		String testName = "Verify if the email address is not already registered";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSaveButtonActivation();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_233() throws Exception{
		String testName = "Verify a text box to capture the user's email address";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setEmailBox();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_234() throws Exception{
		String testName = "Verify the text box show a ghosted message ‘First name*’.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setGhostedFirstname();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_235() throws Exception{
		String testName = "Verify the text box show a ghosted message ‘Last name*’.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setGhostedLastname();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_236() throws Exception{
		String testName = "Verify In the select product field show a ghosted message ‘select product*’";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setGhostedSelectProductname();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_237() throws Exception{
		String testName = "Verify the text box shows a ghosted message ‘select user level*’";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setGhostedSelectUserLevel();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_238() throws Exception{
		String testName = "Verify the email text box show a ghosted message 'Email address*’.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setGhostedEmailAddress();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_239() throws Exception{
		String testName = "Verify company admin can view the company list";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setAdminInCompanyList();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_240() throws Exception{
		String testName = "Verify Company admin can delete the user form the company and edit their details.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setDeleteCancelButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_241() throws Exception{
		String testName = "Verify in the user list title company name should be visible";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_242() throws Exception{
		String testName = "Verify user list display the number of users added to the company .";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyUserNumber();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_243() throws Exception{
		String testName = "Verify the format for the header is Add user to <product name>";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setAddUserTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_244() throws Exception{
		String testName = "Verify If the email address already exists, prepopulate user information.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setPrepopulatedInformation();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	
	@Test
	public void WEB_245() throws Exception{
		String testName = "Verify the title of the lightbox is displayed the top left corner";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setVerifyCompanyTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}

	
	
	
	
	@Test
	public void WEB_246() throws Exception{
		String testName = "Verify Delete user (from Product)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setDeleteUserFromProduct();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_247() throws Exception{
		String testName = "Verify the format of the title <product name> user list";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setDialogTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_248() throws Exception{
		String testName = "Verify user list display the number of users added to the product.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserNumber();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test 
	public void WEB_249() throws Exception{
		String testName = "Verify If the email address already exist in the system, then don't allow the user to add it again. Activate the Save button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserAlreadyExist();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_250() throws Exception{
		String testName = "Verify Delete user (from company)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setDeleteFromCompany();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_251() throws Exception{
		String testName = "Verify user name and email";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUsernameEmailonSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_252() throws Exception{
		String testName = "Verify search field";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSearchonProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test 
	public void WEB_253() throws Exception{
		String testName = "Verify user registration flow is mentioned on another page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserRegistration();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_254() throws Exception{
		String testName = "Verify the number of tabs will depend on how many products the user has access to";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_255() throws Exception{
		String testName = "Verify tabs will be system authored. The system will check the user's license in UMS and display products/tabs accordingly.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyProductsSystemAuthored();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_256() throws Exception{
		String testName = "UMS - Verify company admin that is a pwc.com user would get access to all products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyProductsAccess();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_257() throws Exception{
		String testName = "UMS - Verify that all PwC staff (i.e. internal) users have access to every My Products product page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCompanyProductsAccess();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_258() throws Exception{
		String testName = "Verify if the user selects the role as a user then they need to select the product(s) "
				+ "from the select product dropdown for which they need to provide them access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setAccessSelectProductDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_259() throws Exception{
		String testName = "Verify if the user selects the role as a user then they need to select the product(s) "
				+ "from the select product dropdown for which they need to provide them access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setTotalUsers();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_260() throws Exception{
		String testName = "Verify if the user selects the role as a user then they need to select the product(s) "
				+ "from the select product dropdown for which they need to provide them access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setTotalUsers();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_261() throws Exception{
		String testName = "Verify for a product-specific banner, outage or deprecated is displayed and not both at the same time";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerDisplayed();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_262() throws Exception{
		String testName = "Verify authors can copy and paste source content from the existing Word documents into the text editor tool";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 57));
	        lpo.setLogin4();
	        ap.setPrivacyWord();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test //!!!
	public void WEB_263() throws Exception{
		String testName = "Verify authors can copy and paste source content from the existing Word documents into the text editor tool";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        ap.setWorkflowArchive();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test
	public void WEB_264() throws Exception{
		String testName = "Verify as a Author, when updates any content on above mentioned experience components(XF)."
				+ " All the pages which have the related component should get updated automatically";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 68));
	        lpo.setLogin4();
	        ap.setExperienceFragment();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_265() throws Exception{
		String testName = "Verify would be able to add or re use experience fragment the same way as a normal component while page authoring";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 56));
	        lpo.setLogin4();
	        ap.setExperienceFragment2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test 
	public void WEB_266() throws Exception{
		String testName = "Verify that author should be able to author the links that are linking externally";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFooterElementLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_267() throws Exception{
		 String testName = "Verify that the tiles are not sorted by their created date";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 63));
		        lpo.setLogin4();
		        ap.setReorderTiles();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test 
	public void WEB_268() throws Exception{
		String testName = "Verify that when you are on documentation template (table) and link a text to a pdf assets for the following components";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setReleaseNotesTable();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test 
	public void WEB_269() throws Exception{
		String testName = "Verify if the user is logged in and permitted, the asset opens in the browser and does not download";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setReleaseNotesAssetsOpenNewTab();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test 
	public void WEB_270() throws Exception{
		String testName = "Verify that document tile is displayed per doc category";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 8));
	        rp.setTilesPerDocument();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test 
	public void WEB_271() throws Exception{
		String testName = "Verify the internal user will be able to access product central and will be see all products and their content";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 69));
	        lpo.setLogin4();
	        ap.setAccessAllProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_272() throws Exception{
		String testName = "Verify both approved external and internal user are able to access the PC page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 69));
	        //lpo.setLogin4();
	        ap.setInternalAccess();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_273() throws Exception{
		String testName = "Verify this is related to the PDF assets for non-gated content such as the change navigator, offering overview docs";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 70));
	        lpo.setLogin4();
	        ap.setPDFassets();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_274() throws Exception{
		String testName = "Verify that author is able to add links for Privacy hub footer +"
				+ "Verify that when author add external links then links should open in new window ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 71));
	        lpo.setLogin4();
	        ap.setPrivacyFooter();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_275() throws Exception{
		String testName = "Verify that if there are multiple links added by author then links will be separated with pipe |";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 58));
	       // lpo.setLogin4();
	        ap.setPrivacyHubPipes();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_276() throws Exception{
		String testName = "Verify group is able to complete/approve the workflow"+
	"Verify this is applicable when a page or an asset is pushed in workflow."+
				"Verify this functionality can be applied to any content or asset";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setUserWorkflowApproval();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_277() throws Exception{
		String testName = "Verify that the Product tiles, Resell Product Tiles and Myproducts assets tiles within Latest and For You component are impacted due to this change.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAssetsDesignDifferences();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_278() throws Exception{
		String testName = "Verify that the Download Full Terms should be removed from the following pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 74));
	        plp.setRemoveDownload();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test 
	public void WEB_279() throws Exception{
		String testName = "Verify that checkbox is available for authors in page properties for all listed pages.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 72));
	        lpo.setLogin4();
	        ap.setHideDownloadCheckbox();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_280() throws Exception{
		String testName = "Verify that only the Banner Text Field should be removed so that the author cannot override the default statement";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerTextField();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_281() throws Exception{
		String testName = "Verify that the authors should not be able to change or edit the approved wordings for all 3 types of outages.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerTextField2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test//!!!
	public void WEB_282() throws Exception{
		String testName = "Verify that this page should appear to all Site Visitors that are trying to access a page they are not permitted to.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 73));
	        
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_283() throws Exception{
		String testName = "Verify that the copyright statement that is editable centrally that can support text and inline links";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 71));
	        lpo.setLogin4();
	        ap.setPrivacyFooterCopyWrite();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_284() throws Exception{
		String testName = "Verify internal user can have access all Products for that company";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 69));
	       // lpo.setLogin4();
	        ap.setInternalAccess();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_285() throws Exception{
		String testName = "Verify the listed products should match the user licence in UMS";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMatchingProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_286() throws Exception{
		String testName = "verify the Product Central non-gated content has a different cookie and privacy policy than the My Products gated content due to the nature of the content";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 58));
	       // lpo.setLogin2();
	        pp.setDifferentPrivacy();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_287() throws Exception{
		String testName = "Verify that super author is able to change/edit the banner statements for all 3 types of outages"+
	"Verify that if the super author leaves the text field blank it will display the default statement again";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 66));
	        lpo.setLogin4();
	        ap.setBannerEdit();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_288() throws Exception{
		String testName = "Verify that author is able to choose one or more features related to the product within the feature tag"
				+"Verify that This updation is not affecting any existing asset properties";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 75));
	        lpo.setLogin4();
	        ap.setFeatureTags();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_289() throws Exception{
		String testName = "Verify that video can be searched from Search results eithrt from global search or my products search bar";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setMultimediaSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_290() throws Exception{
		String testName = "Verify that In replacement of the various product tabs, there is a “View all” link";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	       pp.setViewAllVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test
    public void WEB_291() throws Exception{
        String testName = "Verify that author can add maximum 90 Characters (3lines) in the description and it should not cross maximum limit";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setLinesOfHero();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	@Test
	public void WEB_292() throws Exception{
		String testName = "Verify\r\n"
				+ " that the Breadcrumb will be in the following format:- Eg: Linked Parent\r\n"
				+ " Page > Text based detail page title     /          (Privacy \r\n"
				+ "[Hyperlinked] > [Product name])";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setBreadcrumbsHierarchyTablet();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}

	@Test
    public void WEB_293() throws Exception{
        String testName = "Verify that the asset will be managed by Kaltura instead of AEM";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 76));
            lpo.setLogin4();
            ap.setKalturaVideo();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_294() throws Exception{
        String testName = "Verify that if author enters more characters in description then it will show ellipsis"
        		+"Verify that if author enters more characters in title then it will show ellipsis";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 80));
            lpo.setLogin4();
            ap.setLongerTitleDescription();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
	public void WEB_295() throws Exception{
		String testName = "Verify that pagination is removed from All resources section"
				+"Verify that All resources section is having infinite scroll when items to be displayed exceeds the component height";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setDisplayResources(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_296() throws Exception{
		String testName = "Verify that PC document category tag is mandatory only for non-gated content";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    ap.setMandatoryPCtag();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_297() throws Exception{
		String testName = "Verify that author will be able to create this template within a myproducts product section"
				+"Verify that author will be able to drag any components to build accordingly";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 67));
            lpo.setLogin4();
    	    ap.setMyProductLandingPage();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_298() throws Exception{
		String testName = "Verify that for outage banner(red) new statement is"
				+"/ Verify user is able to see automated banner on product page with text and outage start time"
				+"/ Verify that the automated outage banner text is displayed as per below"+
				"/ Verify that the 'begin-UTC' date & time of the outage or degradation is displayed in the banner.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 62));
            lpo.setLogin4();
    	    ap.setOutageBannerMessage(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_299() throws Exception{
		String testName = "Verify that page header background with pwc logo and 'privacy hub' should be by default in a grey";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 58));
            //lpo.setLogin2();
    	    pp.setPrivacyHeaderBackground(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_300() throws Exception{
		String testName = "Verify on click of 'save' button, all the details are saved"
				+"Verify on click of 'cancel' button, pop-up window will get closed and no product or feature selection is saved for new company";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setEditProduct(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_301() throws Exception{
		String testName = "Verify user is able to add new products";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setAddProduct(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_302() throws Exception{
		String testName = "Verify user is able to add new features to a product";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setAddFeature(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_303() throws Exception{
		String testName = "Verify that for each product SC_Product_ID field should be mandatory"
				+"Verify that 'SC_Product_ID' field should be Unique"
				+"Verify after adding the product details system validates mandatory fields and show error message else success message";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setMandatoryProductSCs(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_304() throws Exception{
		String testName = "Verify SC_Account_ID is not unique identifier";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setSC_AccountID(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_305() throws Exception{
		String testName = "Verify SC_Account_ID is mandatory"
				+"Verify user is able to add company through UMS UI";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setSC_AccountIDMandatory(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_306() throws Exception{
		String testName = "Verify user is able to select product from the dropdown and all the active features of the product is displayed with a checkbox for each"
				+"Verify Product/feature/license is added to the company and displayed in the Products section";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setProductFeatureVisibility(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_307() throws Exception{
		String testName = "Verify that author will be able to define either one or two levels of navigation for any gated or non-gated content";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 79));
            lpo.setLogin4();
    	    ap.setLeftNaviEdit();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_308() throws Exception{
		String testName = "Verify notofocation banners at a product level must be inherited by all of the children pages for that product";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 80));
            lpo.setLogin4();
    	    ap.setInheritedBanners();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_309() throws Exception{
		String testName = "Verify for each link author is able to give url and label"
				+"Verify that as an author able to define the label and the url for each links in the related links";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 57));
	        lpo.setLogin4();
	        ap.setRelatedLinksAuthoringandRearrangeRelated();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_310() throws Exception{
		String testName = "Verify that if company is locked then company admin unable to modify the company users"
				+"Verify that greying out the add/edit users functions when company is locked";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setLockedSymbolNotEditable(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_311() throws Exception{
		String testName = "Verify user is able to select license status from dropdown and dropdown has following values: 1.All, 2.Active, 3.Expired, 4.Future, 5.Expire in 30 days";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setLicenseStatus(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_312() throws Exception{
		String testName = "Verify collapsed company list has following columns for each company record:1 Company name 2.Products with count 3.Add user 4. Company users with count 5.Edit company...";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setCompanyElements(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_313() throws Exception{
		String testName = "Verify businedd has the ability to lock and unlock companies from gaining access to mY Products pages if locked a symbol appears to indicate locked the UMS is still accessible by the company admin";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            //lpo.setLogin2();
    	    ums.setLockedFunction(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_314() throws Exception{
		String testName = "Verify that as an author able to define title within the content box"
				+"Verify that content box is displaying in white background";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 81));
            lpo.setLogin4();
    	    ap.setContentBox();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	public String takeScreenshot(String screenshotName) throws IOException {
	    WebDriver driver = Driver.getDriver();
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = "screenshots/" + screenshotName + ".png";
	    File target = new File(destination);
	    FileUtils.copyFile(source, target);
	    return destination;
	}
	public void captureScreenshotAndAddToReport(String testName) throws IOException {
		 String screenshotPath = takeScreenshot(testName);
		 ExtentTest test = extent.createTest(testName).pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	@AfterMethod
    public void closeTabs() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
            	Driver.getDriver().switchTo().window(window);
            	Driver.getDriver().close();
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
         }
	public void tearDown(ITestResult result) throws IOException {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        // Take screenshot if test method fails
	        String screenshotPath = takeScreenshot(result.getName() + "_failed");
	        test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        // Take screenshot if test method passes
	        String screenshotPath = takeScreenshot(result.getName() + "_passed");
	        test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    extent.flush();
	}
      @AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	


	

}