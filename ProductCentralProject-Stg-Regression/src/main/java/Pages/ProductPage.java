package Pages;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class ProductPage extends HelperFunctions {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//div[@class='cmp-error__title']")
	private WebElement errorTitle;
	
	@FindBy(xpath="//div[@class='cmp-error__description']")
	private WebElement errorDescription;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement myProductCatDropdown;
	
	@FindBy(xpath="//div[@class='cmp-all-resources']")
	private WebElement allResources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5resources;
	
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> myProductCatDropdownList;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//div[@class='ap-footer-link-group']")
	private WebElement footerLinkGroup;
	
	@FindBy(xpath="//span[.='Next']")
	private WebElement nextButtonforResources;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample10.pdf.coredownload.inline.pdf.coredownload.inline.pdf']")
	private WebElement firstResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample13.png.coredownload.inline.png.coredownload.inline.png']")
	private WebElement secondResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample16.jpg.coredownload.inline.jpg.coredownload.inline.jpg']")
	private WebElement thirdResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/7E1c.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement forthResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/gif.coredownload.inline.gif.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement fifthResource;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductItemOnSitemap;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//span[1]")
	private static List<WebElement> myProductCatDropdownList2;
	
	@FindBy(xpath="//div[@id='tagElements']//div[@class='ap-dropdown-select']")
	private WebElement selectDropdown;
	
	@FindBy(xpath="//*[@id=\"listPage\"]/div/div/div[2]/div[3]")
	private WebElement cardCat;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement documentDropdown;
	
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-category'])[1]")
	private WebElement cardCategory;
	
	@FindBy(xpath="//div[@class='cmp-error__img']")
	private WebElement errorImage;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='gatedSearchInput']")
	private WebElement myProductSearchField;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[1]")
	private WebElement resource1;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[2]")
	private WebElement resource2forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[3]")
	private WebElement resource3forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[4]")
	private WebElement resource4forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[5]")
	private WebElement resource5forProduct2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-2.html']")
	private WebElement product2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-4.html']")
	private WebElement product4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Transparency-Hub-Support-Guide-test.pdf.coredownload.inline.pdf']")
	private WebElement resource1forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Resell Data Processing addendum.png.coredownload.inline.png']")
	private WebElement resource2forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/sample7.jpg.coredownload.inline.jpg']")
	private WebElement resource3forProduct4;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__title']")
	private static List<WebElement> titleofAssets;
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card-title']//a")
	private static List<WebElement> allresourcesContentLink;
	
	@FindBy(xpath="//div[@class='cmp-for-you__tiles']//a")
	private static List<WebElement> forYouAssets;
	
	@FindBy(xpath="//div[@class='cmp-for-you__txt']")
	private WebElement forYouTitle;
	
	@FindBy(xpath="//span[.='Product 2']")
	private WebElement product2Title;
	
	@FindBy(xpath="//span[.='Product 4']")
	private WebElement product4Title;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductOnLeftNavigation;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion']")
	private WebElement heroPromotion;
	
	@FindBy(xpath="((//div[@class='cmp-tabs__tab-search-container'])[1]//li)[position()=1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//span[@class='cmp-header__cta-avatar-initials']")
	private WebElement userInitials;
	
	@FindBy(xpath="//div[@class='cmp-need-technical-support__text-container']")
	private WebElement technicalSupportTitle;
	
	@FindBy(xpath="//div[@class='cmp-related-products__title']")
	private WebElement relatedProductsTitle;
	
	@FindBy(xpath="(//div[@class='cmp-related-products__carousel-title'])[position()=1]")
	private WebElement relatedProduct1;
	
	@FindBy(xpath="(//div[@class='cmp-related-products__carousel-title'])[position()=2]")
	private WebElement relatedProduct2;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[@id='loginLink']")
	private WebElement loginLink;
	
	@FindBy(xpath="//div[@data-href='/content/pc/us/en/my-products/product-4.html']")
	private WebElement loginLink2;
	
	@FindBy(xpath="//a[.='Go To Client View']")
	private WebElement technicalSupportButton;
	
	@FindBy(xpath="//ol[@class='cmp-tabs__tablist']//a//li//div//span[1]")
	private static List<WebElement> allProducts;
	
	@FindBy(xpath="//span[@class='cmp-tabs__title-container-view-more view-all-js']")
	private WebElement viewAll;
	
	@FindBy(xpath="//span[@id='closeTabsModal']")
	private WebElement closeTabs;
	
	@FindBy(xpath="//a[@class='cmp-tabs__products-modal-card']")
	private static List<WebElement> allProducts2;
	
	@FindBy(xpath="//div[@class='cmp-tabs__products-modal-text-container']")
	private static List<WebElement> productsCont;
	
	@FindBy(xpath="//div[@class='cmp-header__cta-avatar']")
	private WebElement avatar;
	 
	@FindBy(xpath="//a[@aria-label='Logout']")
	private WebElement logout;
 
	@FindBy(xpath="//div[contains(@class, 'outage')]")
	private WebElement banner;

    @FindBy(xpath="//span[contains(@aria-label, 'Banner')]")
	private WebElement bannerClose;

	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement myproductTitle;

	@FindBy(xpath="(//div[@class='ap-modal-content'])[2]//a")
	private static List<WebElement> allProducts3;
	
	@FindBy(xpath="(//div[@class='ap-modal-content'])[2]")
	private WebElement modalBox;
	
	@FindBy(xpath="//span[@class='ap-icon icon-open-in-new-outline']")
	private WebElement footerIcon;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion__content']")
	private WebElement heroPromotionContent;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion__image']")
	private WebElement heroPromotionImg;
	
	@FindBy(xpath="//span[@class='cmp-search-results__left-panel-products-badge-title']")
	private WebElement productFilter;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[1]")
	private WebElement firstSearchResult;
	
	@FindBy(xpath="//span[@class='cmp-search-results__empty-text']")
	private WebElement noSearchResult;
	
	@FindBy(xpath="//div[@class='cmp-search-results__page ap-page-container']//a")
	private static List<WebElement> searchProducts;
	
	@FindBy(xpath="//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private static WebElement closeButtonforCookies;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//input")
	private static List<WebElement> products;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//label")
	private static List<WebElement> productsLabel;
	
	@FindBy(xpath="//h1[@class='cmp-search-results__filter-section-title-heading']")
	private WebElement searchResultsTitle;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='globalSearchInput']")
	private WebElement searchInput;
	
	@FindBy(xpath="//h2[@class='cmp-hero-promotion__content-title']")
	private WebElement productTitle;
	
	@FindBy(xpath="//p[@class='cmp-hero-promotion__content-description']")
	private WebElement productDescription;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion__content']")
	private WebElement contentSpace;

	@FindBy(xpath="//div[@id='avatarGlove']")
	private WebElement userInitials2;
	
	@FindBy(xpath="//div[@id='allResourcesPagination']")
	private WebElement pagination;
	
	@FindBy(xpath="//div[@aria-label='previous']")
	private WebElement previousButton;
	
	@FindBy(xpath="//div[@aria-label='next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card']")
	private static List<WebElement> allresourcesElements;
	
	@FindBy(xpath="//div[@class='cmp-latest__text-container']")
	private WebElement latestTitle;
	
	@FindBy(xpath="//div[@class='cmp-for-you__txt']")
	private WebElement foryouTitle;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__title']")
	private WebElement releaseNoteTitle;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private static WebElement search;
	
	@FindBy(xpath="//div[@class='cmp-header__logo']")
	private static WebElement logo;
	
	@FindBy(xpath="//div[@class='ap-footer-link']//a")
	private static List<WebElement> footerLinks;
	
	@FindBy(xpath="//div[@class='ap-modal-title']")
	private static WebElement modalTitle;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__title']")
	private static List<WebElement> foryouTitles;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__thumbnail']//img")
	private static List<WebElement> thumbnails;
	
	@FindBy(xpath="//a[@href='#collapseNavBtn']")
	private static WebElement collapseButton;
	
	@FindBy(xpath="//div[@class='cmp-sidebar__item-image']//img")
	private static List<WebElement> leftNavigationImg;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__card']")
	private static List<WebElement> releaseNotesElements;
	
	@FindBy(xpath="//a[@id='preferencesLink']")
	private static WebElement preferences;
	
	@FindBy(xpath="//div[@class='ap-preferences-container']")
	private static WebElement preferencesModal;
	
	@FindBy(xpath="//label[@id='emailNotificationsToggleLabel']")
	private static WebElement toggleLabel;
	
	@FindBy(xpath="//button[@id='emailNotificationsToggle']")
	private static WebElement toggleButton;
	
	@FindBy(xpath="//input[@id='emailConsentCheckbox']")
	private static WebElement consentCheckbox;
	
	@FindBy(xpath="//div[@class='ap-footer-link']")
	private static List<WebElement> footerLinksGroup;
	
	@FindBy(xpath="//div[@class='ap-footer-link']//a")
	private static List<WebElement> footerLinksGroup2;
	
	@FindBy(xpath="//div[@id='productsBadgesContainer']")
	private static WebElement productList;
	
	@FindBy(xpath="//div[@class='cmp-tabs__products-modal-text-container']")
	private static List<WebElement> allresourcesTitle;
	
	@FindBy(xpath="//div[@class='cmp-latest__tiles']//a")
	private static List<WebElement> latestAssets;
	
	@FindBy(xpath="//span[@class='cmp-tabs__products-modal-text']")
	private static List<WebElement> productsName;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__card-title']")
	private static List<WebElement> releaseNotesTitle;
	
	@FindBy(xpath="//span[@class='ap-dropdown-option-label']")
	private static List<WebElement> docOptionsLabel;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//label")
	private static List<WebElement> pcDropdownLabel;
	
	@FindBy(xpath="//input[@class='ap-dropdown-option-checkbox']")
	private static List<WebElement> pcDropdownLabel2;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__text']")
	private static List<WebElement> divList;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']")
	private static List<WebElement> divElements;
	
	@FindBy(xpath="//span[@class='cmp-search-results__left-panel-products-badge-title']")
	private static List<WebElement> productList2;
	
	 @FindBy(xpath="(//div[@class='cmp-tiles__products-link'])[1]")
		private WebElement logintoMyproducts;
	 
	 @FindBy(xpath="//h2[@class='cmp-hero-promotion__content-title']")
	    private WebElement heroTitle;
	    
	    @FindBy(xpath="//h3[@class='cmp-hero-promotion__content-description']")
	    private WebElement heroDesc;
	    
	    @FindBy(xpath="//span[.='Next']")
		private static List<WebElement> nextButtonforResources2;
	    
	    @FindBy(xpath="//div[@id='listPage']")
	    private WebElement allresourcesContainer;
	    
	    @FindBy(xpath="//div[@class='cmp-banner__message']")
	    private WebElement outageBannerMessage;
	    
	    @FindBy(xpath="//header[@class='cmp-privacy-hub-header ']")
	    private WebElement privacyHeader;
	    
	    @FindBy(xpath="//a[@id='preferencesLink']")
	    private static List<WebElement> preferences2;
	    
	    @FindBy(xpath="//a[contains(@class, 'cmp-release-notes__card')]")
		private static List<WebElement> releaseNotesTitle2;
	    
	    @FindBy(xpath="//div[@class='cmp-all-resources__card-category']")
	    private static List<WebElement> cardCategory2;
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	static Logger logger=Logger.getLogger("ProductPage");
	
	
	
	
	
	
	
	public void setDocCategory() throws Exception {
		HelperFunctions.scrollToElement(allResources);
		read1.setExcelFile("./testdata.xlsx", "Tag Taxonomy");
         
		for(WebElement eachdocCat: myProductCatDropdownList) {
			System.out.println(eachdocCat.getText());
			
			if(eachdocCat.getText().contains(read1.getCellData("Portfolio", 1))&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 2))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 3))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 4))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 5))){
				
				Assert.assertTrue(true);}else {Assert.assertTrue(false);}}
		
		for(WebElement eachdocCat:myProductCatDropdownList) {
			if(eachdocCat.getText().contains(read1.getCellData("Portfolio", 1))) {
				eachdocCat.click();
				break;
			}
		}	
		
		
	}
	
	public void setFooterWithoutLogin() {
		HelperFunctions.scrollToElement(footerContent);
	
	        if(footerContent.isDisplayed() && footerLinkGroup.isEnabled() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	
	}
	
	public void setFooterWithLogin() throws Exception {
		
		HelperFunctions.scrollToElement(footerContent);
		
	        System.out.println(footerContent.getText());
	       
	        if(footerContent.isDisplayed() && footerLinkGroup.isDisplayed() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	      
	
	}
	
	public void setErrorMessage() throws Exception  {
	
	    
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 36));
	    HelperFunctions.staticWait(5);
	    String actualErrorTitle=errorTitle.getText();
	    String expectedErrorTitle=read1.getCellData("VALUE", 38);
		String actualErrorDescription=errorDescription.getText();
		String expectedErrorDescription=read1.getCellData("VALUE", 37);
		Assert.assertEquals(actualErrorTitle, expectedErrorTitle, "Actual and expected error title do not match");
		Assert.assertEquals(actualErrorDescription, expectedErrorDescription, "Actual and expected error description do not match");
	    
		
	}
	
	public void setErrorPage() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 36));
	    HelperFunctions.staticWait(5); 
		if(errorImage.isDisplayed() && errorTitle.isDisplayed() &errorDescription.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
		
	}
	
	
	
public void setDisplayResources() throws Exception {
	
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(viewAll);
	    wait.until(condition);
	    HelperFunctions.staticWait(3);
	viewAll.click();
	
	HelperFunctions.staticWait(2);
   for(int i=0;i<allProducts2.size();i++) {
		allProducts2.get(1).click();
		break;
   }
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(3);
 
	HelperFunctions.scrollToElement(allResources); 
	HelperFunctions.staticWait(3);
    for(WebElement eachResources: first5resources) {
   	 if(eachResources.isDisplayed()) {
   		 String successMessage = "First 5 resources are displayed";
            logger.info(successMessage);
   		 Assert.assertTrue(true);
   	 }else {
   		 String errorMessage = "First 5 resources are not displayed";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
   		// Assert.assertTrue(false);
   	 }
  
    }
    HelperFunctions.staticWait(3);
    Assert.assertTrue(nextButtonforResources2.size()==0);
    /*test.info("Scroll down next button");
    HelperFunctions.scrollToElement(nextButtonforResources);
    HelperFunctions.staticWait(3);
    test.info("Click on next button");
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", nextButtonforResources);
   // nextButtonforResources.click();
    HelperFunctions.staticWait(3);
    for(WebElement eachResources2: last5resources) {
   	 if(eachResources2.isDisplayed()) {
   		 String successMessage = "Last 5 resources are displayed";
            logger.info(successMessage);
   		 Assert.assertTrue(true);
   	 }else {
   		 String errorMessage = "Last 5 resources are not displayed";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
   		// Assert.assertTrue(false);
   	 }
   	 test.info("Verified first 5 resources are displayed");
    }*/
    HelperFunctions.staticWait(3);
     
    }
public void setNewTabAssets() throws Exception {

	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;}
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources); 
    HelperFunctions.staticWait(3);
    String hrefValue = resource1.getAttribute("href");
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", resource1);
    //resource1.click();
    HelperFunctions.staticWait(3);
    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(tabs.get(2));
    System.out.println(Driver.getDriver().getCurrentUrl());
	 String currentUrl = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue, currentUrl);
   // Driver.getDriver().close();
   // Driver.getDriver().switchTo().window(tabs.get(1));
   // HelperFunctions.staticWait(3);
	
}

public void setMyProductSitemap() {
	HelperFunctions.waitForPageToLoad(3);
	if(myProductItemOnSitemap.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

public void setTagsAccompany() {
	//HelperFunctions.waitForPageToLoad(10);
	//HelperFunctions.staticWait(2);
	 WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	HelperFunctions.scrollToElement(viewMoreButton); 
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", selectDropdown);
    HelperFunctions.staticWait(3);
    String expected1="User Guide";
    
    
    for(WebElement tags:myProductCatDropdownList2) {
        System.out.println(tags.getText());
        if(tags.getText().equalsIgnoreCase("User Guide")) {
        	JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
            executor2.executeScript("arguments[0].click();", tags);
            wait.until(ExpectedConditions.visibilityOf(cardCategory2.get(0)));
        Assert.assertTrue(cardCategory2.get(0).getText().contains(expected1));
        }
    }
	HelperFunctions.staticWait(3);

	
	
}

public void setMyProductSearch() {
	
	HelperFunctions.waitForPageToLoad(3);
	myProductSearchField.click();
	myProductSearchField.sendKeys("Product 2");
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(3);
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	
}

public void setResourcesBasedonProducts() {
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources);  
    if(resource1.isDisplayed() ) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
    String text1=resource1.getText();
    System.out.println(text1);
    HelperFunctions.staticWait(3);
   myProductItemOnSitemap.click();
   HelperFunctions.waitForPageToLoad(5); 
   for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		break;
   }
   HelperFunctions.staticWait(3);
  // product4.click();
   HelperFunctions.scrollToElement(allResources);
   HelperFunctions.staticWait(3);
 
   String text2=resource1.getText();
   System.out.println(text2);
   Assert.assertNotEquals(text1, text2);
   HelperFunctions.staticWait(3);
   if(resource1.isDisplayed()  ) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
   
}

public void setNotSupportMultiSelect() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(documentDropdown);
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", documentDropdown);
   // documentDropdown.click();    
	    for(WebElement tags:myProductCatDropdownList) {
			tags.click();
			break;
			
		}
	    for(WebElement tags:myProductCatDropdownList) {
	    	Assert.assertFalse(tags.isDisplayed());
	    }
	    
	   
}

public void setLoadMoreButton() {
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	//HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	for (int i = 0; i < 4; i++) {
	    if (!forYouAssets.get(i).isDisplayed()) {
	        System.out.println("Element " + (i+1) + " is not displayed");
	    }
	}
	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", viewMoreButton);
     HelperFunctions.staticWait(5);
     int count = 0;
     for (int i = 0; i < forYouAssets.size(); i++) {
         if (forYouAssets.get(i).isDisplayed()) {
             count++;
         }
     }
     if (count >= 5) {
    	 Assert.assertTrue(true);
         System.out.println("5 or more elements are displayed");
     } else {
         System.out.println("Less than 5 elements are displayed");
     }
	HelperFunctions.staticWait(3);
	
	
}

public void setClickLoadMoreButton() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(viewMoreButton);
	
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      	for(WebElement eachAsset2:last5Assets) {
      		if(eachAsset2.isDisplayed() && viewLessButton.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      			Assert.assertTrue(false);
      		}
      	}
      
	
	
}

public void setClickLoadLessButton() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      if(viewLessButton.isDisplayed()) {
        	for(WebElement eachAsset: first5Assets) {
        		if(eachAsset.isDisplayed()) {
        			Assert.assertTrue(true);
        		}else {
        	      	Assert.assertTrue(false);
              }
        	}
        	for(WebElement eachAsset2:last5Assets) {
        		if(eachAsset2.isDisplayed()) {
        			Assert.assertTrue(true);
        		}
        	}
        }else {
        	Assert.assertTrue(false);
        }
      
      JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
      executor2.executeScript("arguments[0].click();", viewLessButton);
      
      if(viewMoreButton.isDisplayed()) {
      	for(WebElement eachAsset: first5Assets) {
      		if(eachAsset.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      	      	Assert.assertTrue(false);
            }
      	}
      	for(WebElement eachAsset2:last5Assets) {
      		if(!eachAsset2.isDisplayed()) {
      			Assert.assertTrue(true);
      		}
      	}
      }else {
      	Assert.assertTrue(false);
      }
  	
      
	
	
}

public void setTitleOfAssets() {
	
	//HelperFunctions.waitForPageToLoad(5);
   /* for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);*/
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(3);
    int hasMoreThan4Line=0;
    System.out.println(titleofAssets.size());
    for (int i = 0; i < 3 && i < titleofAssets.size(); i++) {
    	 WebElement eachTitleOfAssets = titleofAssets.get(i);
    	 System.out.println(eachTitleOfAssets.getCssValue("-webkit-line-clamp"));
    	 if (Integer.parseInt(eachTitleOfAssets.getCssValue("-webkit-line-clamp")) < 4) {
    		 Assert.assertTrue(true);
    		} else {
    		 hasMoreThan4Line++;
    		 System.out.println(hasMoreThan4Line);
    		 Assert.assertTrue(false);}
    	}
	HelperFunctions.staticWait(3);
}

public void setActiveTab() {
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		
		String s = allProducts.get(0).getCssValue("color");
		String s2 = allProducts.get(1).getCssValue("color");
		Assert.assertNotEquals(s, s2);
		Assert.assertTrue(s.equals("rgba(65, 83, 133, 1)"));
		System.out.println("Color is :" + s); 
		break;
	}
	HelperFunctions.staticWait(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		
		String s = allProducts.get(0).getCssValue("color");
		String s2 = allProducts.get(1).getCssValue("color");
		Assert.assertNotEquals(s, s2);
		Assert.assertTrue(s2.equals("rgba(65, 83, 133, 1)"));
		System.out.println("Color is :" + s); 
		break;
	}
	

}

public void setFirstTabActive() throws Exception {
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(3);
    myProductOnLeftNavigation.click();
    HelperFunctions.waitForPageToLoad(5);
    viewAll.click();
    HelperFunctions.staticWait(2);
    /*read1.setExcelFile("./testdata.xlsx", "QA");
    String activeColor=read1.getCellData("VALUE", 39);
    String fp=firstProduct.getCssValue("color");
    if(fp.equals(activeColor)) {
        Assert.assertTrue(true);
    }else {
        Assert.assertTrue(false);
    }*/
    int index=0;
    WebElement firstTab=productsCont.get(index);
    WebElement eyeIcon=firstTab.findElement(By.xpath("//span[@class='ap-icon icon-view-outline']"));
    if(eyeIcon!=null) {
         String successMessage = "First tab is active";
         logger.info(successMessage);
        Assert.assertTrue(true);
    }else {
         String errorMessage = "First tab is not active";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
    //    Assert.assertTrue(false);
    }

}

public void setHeroPromotion() {
	HelperFunctions.waitForPageToLoad(5);
	 String attr = heroPromotion.getAttribute("src");
	    if (attr == null){
	        System.out.println("Hero promotion is not clickable");
	        Assert.assertTrue(true);
	    }

	    else {
	    	System.out.println("Hero promotion is clickable");
	    	Assert.assertTrue(false);
	    }

	
	
}

public void setUserInitials() throws Exception {
	read1.setExcelFile("./testdata.xlsx", "QA");
	HelperFunctions.waitForPageToLoad(3);
	String email=read1.getCellData("DATA", 1);
	String firstInit=email.substring(0,1);
	String lastInit=email.substring(email.indexOf(".")+1);
	String lastInit2=lastInit.substring(0,1);
	String userInitials2=userInitials.getText();
	String firstAndLastInit=firstInit+lastInit2;
	System.out.println(userInitials.getText());
	System.out.println(firstInit+lastInit2);
	Assert.assertTrue(userInitials2.equalsIgnoreCase(firstAndLastInit));
	
	
}



public void setInfoOfProducts() throws Exception {
 HelperFunctions.waitForPageToLoad(5);
 HelperFunctions.staticWait(3);
 viewAll.click();
 HelperFunctions.staticWait(2);
 for(int i=0;i<allProducts2.size();i++) {
 allProducts2.get(2).click();
  break;}
HelperFunctions.staticWait(3);
JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
 executor1.executeScript("arguments[0].click();", closeTabs);
 HelperFunctions.staticWait(3);
 HelperFunctions.scrollToElement(forYouTitle);
 WebElement first = titleofAssets.stream().findFirst().get();
 System.out.println(first.getText());
 System.out.println("----");
 HelperFunctions.staticWait(3);
 JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
 js2.executeScript("window.scrollBy(0,-1200)", "");
 HelperFunctions.staticWait(3);
 viewAll.click();
 HelperFunctions.staticWait(2);

 for(int i=0;i<allProducts2.size();i++) {
allProducts2.get(3).click();
break;}
HelperFunctions.staticWait(3);
JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
 executor2.executeScript("arguments[0].click();", closeTabs);
HelperFunctions.staticWait(3);
 HelperFunctions.scrollToElement( forYouTitle);
 HelperFunctions.staticWait(3);
 WebElement first2 = titleofAssets.stream().findFirst().get();
 System.out.println(first2.getText());
 HelperFunctions.staticWait(3);
 Assert.assertNotEquals(first, first2);
if (first.equals(first2)) {
String errorMessage = "Titles are not supposed to match but they match";
logger.error(errorMessage);
throw new Exception(errorMessage);
}else {
String successMessage = "Titles are not supposed to match and they do not match";
logger.info(successMessage);} }






public void setRelatedProducts() throws Exception {

	HelperFunctions.waitForPageToLoad(3);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
    HelperFunctions.staticWait(3);
    HelperFunctions.scrollToElement(relatedProductsTitle);
    String actualTitle=relatedProduct1.getText();
    String actualTitle2=relatedProduct2.getText();
    HelperFunctions.staticWait(3);
	JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
	js2.executeScript("window.scrollBy(0,-2500)", "");
	HelperFunctions.staticWait(3);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		break;
    }
	HelperFunctions.staticWait(3);
	 HelperFunctions.scrollToElement(relatedProductsTitle);
	 String actualTitle3=relatedProduct1.getText();
	 String actualTitle4=relatedProduct2.getText();
	 HelperFunctions.staticWait(3);
	 Assert.assertNotEquals(actualTitle, actualTitle3);
	 Assert.assertNotEquals(actualTitle2, actualTitle4);
  
	
}

public void setAllResourcesContent() {
	//HelperFunctions.waitForPageToLoad(5);
	/*for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }*/
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources);
	HelperFunctions.staticWait(3);
	 String a=".pdf";
	 String b=".png";
	 String c=".jpg";
	 String d=".gif";
	 String e=".mp4";
	 String f=".mp3";
	 
	 List<String> list = new ArrayList<String>();
    for(WebElement each:allresourcesContentLink) {
    	list.add(each.getAttribute("href").substring(each.getAttribute("href").length()-4));
    }
    if(list.contains(a)||list.contains(b)||list.contains(c)||list.contains(d)||list.contains(e)||list.contains(f)) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }

    HelperFunctions.staticWait(3);
        
   
   
}

public void setTechnicalSupport() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.scrollToElement(technicalSupportButton);
    HelperFunctions.staticWait(5);
    System.out.println(technicalSupportButton.getAttribute("href"));
    String hrefValue = technicalSupportButton.getAttribute("href");
    technicalSupportButton.click();
    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(tabs2.get(2));
    HelperFunctions.staticWait(5);
	 String currentUrl = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue, currentUrl);

}

public void setProductSorting() throws Exception {
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    wait.until(ExpectedConditions.visibilityOf(myProductOnLeftNavigation));
    myProductOnLeftNavigation.click();
    HelperFunctions.waitForPageToLoad(30);
    viewAll.click();
    HelperFunctions.staticWait(5);
    int index=0;
    WebElement firstTab=productsCont.get(index);
    WebElement eyeIcon=firstTab.findElement(By.xpath("//span[@class='ap-icon icon-view-outline']"));
    if(eyeIcon!=null) {
         String successMessage = "First tab is active";
         logger.info(successMessage);
        Assert.assertTrue(true);
    }else {
         String errorMessage = "First tab is not active";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
    }
    
    List<String> elementTexts = new ArrayList<String>();

    for (WebElement element : allProducts3) {
      elementTexts.add(element.getText());
    }

    List<String> sortedElementTexts = new ArrayList<String>(elementTexts);
    Collections.sort(sortedElementTexts);

    if (elementTexts.equals(sortedElementTexts)) {
      System.out.println("The list of products is in alphabetical order.");
    } else {
      System.out.println("The list of products is not in alphabetical order.");
    }
    HelperFunctions.staticWait(2);
}

public void setModalClose() throws Exception {

	//HelperFunctions.waitForPageToLoad(10);
	//HelperFunctions.staticWait(2);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(viewAll);
    wait.until(condition);
	viewAll.click();
	HelperFunctions.staticWait(5);
    for(int i=0;i<allProducts3.size();i++) {
		allProducts3.get(0).click();
		break;
    }
    HelperFunctions.staticWait(5);
    if(modalBox.isDisplayed()) {
    	 String errorMessage = "Modal is not closed";
         logger.error(errorMessage);
    }else {
    	String successMessage = "Modal is closed";
        logger.info(successMessage);
    }
    HelperFunctions.staticWait(2);
}

public void setViewAllVisibility() throws Exception {

	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(viewAll));
    if(!viewAll.isDisplayed()) {
    	 String errorMessage = "Modal is not closed";
         logger.error(errorMessage);
    }else {
    	String successMessage = "Modal is closed";
        logger.info(successMessage);
    }
    HelperFunctions.staticWait(2);
}

public void setFooterIconVisibility() throws Exception {

	//HelperFunctions.waitForPageToLoad(5); 
    //HelperFunctions.staticWait(3);
    HelperFunctions.scrollToElement(footerContent);
    HelperFunctions.staticWait(3);
    if(!footerIcon.isDisplayed()) {
    	 String errorMessage = "Modal is not closed";
         logger.error(errorMessage);
    }else {
    	String successMessage = "Modal is closed";
        logger.info(successMessage);
    }
    HelperFunctions.staticWait(3);
}
public void setBannerPersistance() throws Exception {

	HelperFunctions.waitForPageToLoad(5); 

    if(!banner.isDisplayed()) {
    	 String errorMessage = "Banner is not displayed";
         logger.error(errorMessage);
    }else {
    	String successMessage = "Banner is displayed";
        logger.info(successMessage);
    }
    bannerClose.click();
    HelperFunctions.staticWait(2);
    Driver.getDriver().navigate().refresh();
    HelperFunctions.waitForPageToLoad(15); 
    HelperFunctions.staticWait(3);
    if(!banner.isDisplayed()) {
   	 String errorMessage = "Banner is not displayed";
        logger.error(errorMessage);
   }else {
   	String successMessage = "Banner is displayed";
       logger.info(successMessage);
   }
    HelperFunctions.staticWait(3);
}
public void setHeroPromotionDesign() throws Exception {

	//HelperFunctions.waitForPageToLoad(5); 
    HelperFunctions.staticWait(3);
    WebElement parentElement = Driver.getDriver().findElement(By.xpath("//div[@class='cmp-hero-promotion']"));

 WebElement contentElement = parentElement.findElement(By.xpath("//div[@class='cmp-hero-promotion__content']"));

 WebElement imageElement = parentElement.findElement(By.xpath("//div[@class='cmp-hero-promotion__image']"));

 HelperFunctions.staticWait(3);
 if (contentElement != null && imageElement != null) {
     System.out.println("Verification successful");
 } else {
     System.out.println("Verification failed");
 }
 HelperFunctions.staticWait(3);
}

public void setMyProductSearchResults() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(firstSearchResult));
	if(firstSearchResult.getText().contains("Check-In")) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Check-In is not displayed";
	        logger.error(errorMessage);
	}
	HelperFunctions.staticWait(2);
	productFilter.click();
	HelperFunctions.staticWait(2);
	 if(!noSearchResult.isDisplayed()) {
	   	 String errorMessage = "No Search Result is not displayed";
	        logger.error(errorMessage);
	   }else {
	   	String successMessage = "No Search Result is displayed";
	       logger.info(successMessage);
	   }
	 HelperFunctions.staticWait(2);
}

public void setLimitOfSearchResults() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(20);
	HelperFunctions.staticWait(2);
	if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
	
		closeButtonforCookies.click();
	    System.out.println("Close cookies.");
	} else {
	    System.out.println("Cookies already closed.");
	}
	HelperFunctions.staticWait(2);
	
	int webElementsListSize = searchProducts.size();

	int elementsPerPage = 10;

	for (int i = 0; i < elementsPerPage; i++) {
	    System.out.println(searchProducts.get(i).getText());
	}

	if (webElementsListSize > elementsPerPage) {
	
	    WebElement nextButton = Driver.getDriver().findElement(By.xpath("(//span[@class='ap-pagination-btn-text'])[2]"));
	    HelperFunctions.scrollToElement(nextButton);
	    nextButton.click();

	    for (int i = elementsPerPage; i < webElementsListSize; i++) {
	        System.out.println(searchProducts.get(i).getText());
	    }
	}

	HelperFunctions.staticWait(2);

	
}
public void setOrangeSearchResults() {
	
	HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
	if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
	
		closeButtonforCookies.click();
	    System.out.println("Close cookies.");
	} else {
	    System.out.println("Cookies already closed.");
	}
	HelperFunctions.staticWait(2);
	
	String expectedColorValue = "rgba(255, 165, 0, 1)";

	
	Actions actions = new Actions(Driver.getDriver());
	actions.moveToElement(firstSearchResult).moveToElement(firstSearchResult, firstSearchResult.getSize().getWidth()/2, firstSearchResult.getSize().getHeight()/2).build().perform();
	HelperFunctions.staticWait(2);
	String colorValue = firstSearchResult.getCssValue("color");
	System.out.println(colorValue);
	Assert.assertEquals("Color value of element is not as expected", expectedColorValue, colorValue);
	

	

	
}
public void setMyProductSearchBar(ExtentTest test) {
	test.info("Wait for my product search field");
	WebDriverWait wait10 = new WebDriverWait(Driver.getDriver(), 30);
    wait10.until(ExpectedConditions.visibilityOf(myProductSearchField));
    test.info("Verified my product search field's visibility");
    HelperFunctions.staticWait(2);
	Point searchBarLocation = myProductSearchField.getLocation();
    System.out.println(searchBarLocation);
	Assert.assertTrue(searchBarLocation.getY() <= 200);
	test.info("Verified my product search field's location");
	HelperFunctions.staticWait(5);
	test.info("Manage window's size to tablet mode");
	Dimension tabletSize=new Dimension(768,533);
	Driver.getDriver().manage().window().setSize(tabletSize);
	wait10.until(ExpectedConditions.visibilityOf(myProductSearchField));
	Assert.assertTrue(myProductSearchField.isDisplayed());
	test.info("Verified my product search field's visibility in tablet mode");
	HelperFunctions.staticWait(3);
	test.info("Manage window's size to mobile mode");
	Dimension mobileSize=new Dimension(375,533);
	Driver.getDriver().manage().window().setSize(mobileSize);
	wait10.until(ExpectedConditions.visibilityOf(myProductSearchField));
	Assert.assertTrue(myProductSearchField.isDisplayed());
	test.info("Verified my product search field's visibility in mobile mode");
	HelperFunctions.staticWait(5);
	
}
public void setFilterMyProductSearch() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(catDropdown));
	catDropdown.click();
	HelperFunctions.staticWait(5);
	for (int i = 8; i < 10 && i < products.size(); i++) {
	    WebElement checkbox = products.get(i);
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }
	}
	 HelperFunctions.staticWait(2);
	 for (int i = 8; i < 10 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (checkBox.isSelected()) {
		        Assert.assertTrue(true);
		    }else {
		    	 String errorMessage = "Verification failed";
			        logger.error(errorMessage);
		    }
		}
	HelperFunctions.staticWait(2);
	
	
}

public void setInputKeywords() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(sortingDropdown));
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(2);

	
	
}

public void setSearchingProducts() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	String product="Check-In";
	myProductSearchField.sendKeys(product);
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(sortingDropdown));
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(2);
	if(firstSearchResult.getText().equalsIgnoreCase(product)) {
		Assert.assertTrue(true);
	}else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(3);
	
	
}
public void setUsingGlobalSearch() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(searchButton);
    wait.until(condition);
	searchButton.click();
	HelperFunctions.staticWait(3);	
	searchInput.sendKeys("products");
	HelperFunctions.staticWait(2);
	searchInput.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(sortingDropdown));
    if(productDropdown.isDisplayed() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(2);
	
	
}
public void setMyProductSearchAccessibility() {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(myProductSearchField));
	if(myProductSearchField.isDisplayed()&& !loginLink.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(2);
	
	
}
public void setAcceptingSpecialChar() {
	
	//HelperFunctions.waitForPageToLoad(5);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("test@#$%^&*()");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(sortingDropdown));
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }

	HelperFunctions.staticWait(2);
	
}
public void setSearchBarLight() {
	
	//HelperFunctions.waitForPageToLoad(5);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(1);
	  String borderStyle = myProductSearchField.getCssValue("border-style");
	    String borderColor = myProductSearchField.getCssValue("border-color");
	    String boxShadow = myProductSearchField.getCssValue("box-shadow");

	    if (borderStyle.equals("solid") && borderColor.equals("#007eff") && boxShadow.equals("rgba(0, 126, 255, 0.5) 0px 0px 5px 0px")) {
	        System.out.println("Search bar border has changed on click.");
	    } else {
	        System.out.println("Search bar border has not changed on click.");
	    }
	    HelperFunctions.staticWait(2);
	
}
public void setProductNameVisibility() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(productTitle));
	if(productTitle.isDisplayed()&&productTitle.getText()!=null) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Product name is not visible";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
	HelperFunctions.staticWait(2);
	
}
public void setSearchProductAccessibility(ExtentTest test) throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(productTitle));
	if(productTitle.isDisplayed()&& myProductSearchField.isDisplayed()&& !loginLink.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Product search is not visible";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
	test.info("Verified my product title, search field are visible and login link is not visible");
	HelperFunctions.staticWait(3);
	test.info("Checking if my product document category tag is visible for each product");
    WebElement parentElement = Driver.getDriver().findElement(By.xpath("//div[@class='cmp-my-products-tile__text']"));

    WebElement portfolioTag = parentElement.findElement(By.xpath(".//div[contains(@class, 'cmp-my-products-tile__portfolio-tag')]"));
    WebElement title = parentElement.findElement(By.xpath(".//div[contains(@class, 'cmp-my-products-tile__title')]"));
    test.info("Verified my product document category tag is visible for each product");
	HelperFunctions.staticWait(5);
}
public void setAllResourcesPrevious() throws Exception {
	
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(pagination);
	HelperFunctions.staticWait(2);
	if(previousButton.isEnabled()) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Previous button is not enabled";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
	
	
}

public void setBringBack5Assets() throws Exception {
	
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(pagination);
	HelperFunctions.staticWait(2);
	for (int i = 0; i < 5; i++) {
	    if (!allresourcesElements.get(i).isDisplayed()) {
	        System.out.println("Test case failed: The first five elements are not displayed initially.");
	        break;
	    }else {
	    	Assert.assertTrue(true);
	    }
	}
	HelperFunctions.staticWait(1);
	nextButton.click();
	HelperFunctions.staticWait(1);
	for (int i = 5; i < 10; i++) {
	    if (!allresourcesElements.get(i).isDisplayed()) {
	        System.out.println("Test case failed: The next five elements are not displayed after clicking on the 'Next' button.");
	        break;
	    }else {
	    	Assert.assertTrue(true);
	    }
	}
	HelperFunctions.staticWait(1);
	previousButton.click();
	HelperFunctions.staticWait(1);
	for (int i = 0; i < 5; i++) {
	    if (!allresourcesElements.get(i).isDisplayed()) {
	        System.out.println("Test case failed: The first five elements did not stay the same after clicking on the 'Previous' button.");
	        break;
	    }else {
	    	Assert.assertTrue(true);
	    }
	}
	
}
/*public void setFilterValuesPopulateTagTaxonomy() throws Exception {
	//HelperFunctions.waitForPageToLoad(3);
	//HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(selectDropdown); 
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", selectDropdown);  
	HelperFunctions.staticWait(3);
	 FileInputStream file = new FileInputStream("C:\\Users\\GLBL_RDP_USER_01\\git\\PC-Regression\\ProductCentralProject-QA-Regression\\testdata.xlsx");
     XSSFWorkbook workbook = new XSSFWorkbook(file);
     XSSFSheet sheet = workbook.getSheetAt(1); 
	HelperFunctions.staticWait(3);
    int columnIndex2 = 3;
    HashSet<String> cellValues2 = new HashSet<String>();
    for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
        XSSFRow row = sheet.getRow(rowNum);
        if(row == null) continue;
        XSSFCell cell = row.getCell(columnIndex2);
        if(cell == null) continue;
        cellValues2.add(cell.getStringCellValue());
    }
    for (WebElement element2 : myProductCatDropdownList2) {
        if(element2.isDisplayed() && element2.isEnabled()){
            String elementText2 = element2.getText();
            if(elementText2!=null && !elementText2.isEmpty()){
                Assert.assertTrue(cellValues2.contains(elementText2), "element text: " + elementText2 + " not found in the column: " + columnIndex2);
            }else{
                System.out.println("Element text is empty or null, skipping the element");
            }
        }else{
            System.out.println("Element is not interactable or not visible, skipping the element");
        }
    }
    HelperFunctions.staticWait(3);
	
	
}*/
public void setNoAutoSuggestionSearchBar() throws Exception {
	
	//HelperFunctions.waitForPageToLoad(5);
	//HelperFunctions.staticWait(2);
	int searchBarSize = myProductSearchField.getSize().getHeight();
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("C");
	HelperFunctions.staticWait(2);
	int searchBarSizeAfter = myProductSearchField.getSize().getHeight();
	if (searchBarSizeAfter == searchBarSize) {
		Assert.assertTrue(true);
	    System.out.println("Test case passed: No auto-suggestions are displayed.");
	} else {
		String errorMessage = "Test case failed: Auto-suggestions are displayed.";
        logger.error(errorMessage);
        throw new Exception(errorMessage);
	   
	}
	HelperFunctions.staticWait(3);
	
}
public void setMyProductLabel() throws Exception {
	
	//HelperFunctions.waitForPageToLoad(5);
	//HelperFunctions.staticWait(1);
	 String labelText = myproductTitle.getText();
     String expectedText = "My products";
	if (labelText.equalsIgnoreCase(expectedText)) {
		Assert.assertTrue(true);
	    System.out.println("My Product label is displayed.");
	} else {
		String errorMessage = "My Product label is displayed.";
        logger.error(errorMessage);
        throw new Exception(errorMessage);
	   
	}
	HelperFunctions.staticWait(3);
	
}
public void setAllSectionsonthePge() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(viewAll));
	Assert.assertTrue(viewAll.isDisplayed());
	HelperFunctions.staticWait(2);
	Assert.assertTrue(heroPromotion.isDisplayed());
	HelperFunctions.scrollToElement(latestTitle);
	HelperFunctions.staticWait(2);
	Assert.assertTrue(latestTitle.isDisplayed());
	HelperFunctions.scrollToElement(foryouTitle);
	HelperFunctions.staticWait(2);
	Assert.assertTrue(foryouTitle.isDisplayed());
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(allResources);
	HelperFunctions.staticWait(2);
	Assert.assertTrue(allResources.isDisplayed());
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(releaseNoteTitle);
	HelperFunctions.staticWait(2);
	Assert.assertTrue(releaseNoteTitle.isDisplayed());
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(technicalSupportTitle);
	HelperFunctions.staticWait(2);
	Assert.assertTrue(technicalSupportTitle.isDisplayed());
	HelperFunctions.staticWait(2);
	
	
}
public void setMyProductPageVisibility() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(heroPromotion));
	Assert.assertTrue(heroPromotion.isDisplayed());
	HelperFunctions.staticWait(2);
	Assert.assertTrue(userInitials.isDisplayed());
	HelperFunctions.staticWait(2);
	
	
}
public void setLogoutOption() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(userInitials));
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", userInitials);
	HelperFunctions.staticWait(5);
	Assert.assertTrue(logout.isDisplayed());
	HelperFunctions.staticWait(5);
	
	
}

public void setUserInitials2() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(userInitials));
	String actualText=userInitials.getText();
	String expectedText = actualText.toUpperCase();
	Assert.assertEquals(expectedText, actualText, "Element text is not in uppercase");
	Point location = userInitials.getLocation();
	int x = location.getX();
	int y = location.getY();
	System.out.println(x);
	System.out.println(y);
	Assert.assertTrue(x>1800, "Element is not in the top-right corner");
	Assert.assertTrue(y>= 20, "Element is not in the top-right corner");
	HelperFunctions.staticWait(3);
}
public void setSearchButtonPlace() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(search));
	Point location = search.getLocation();
	int width = Driver.getDriver().manage().window().getSize().getWidth();
	int x = location.getX();
	int y = location.getY();
	System.out.println(x);
	System.out.println(y);
	Assert.assertEquals(x, 903, "Element is not in the middle of the header");
	Assert.assertEquals(y, 12, "Element is not in the middle of the header");
	HelperFunctions.staticWait(2);

	
}
public void setLogoPlace() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(logo));
	Point location = logo.getLocation();
	int x = location.getX();
	int y = location.getY();
	System.out.println(x);
	System.out.println(y);
	Assert.assertEquals(x, 20, "Element is not on left most corner of page");
	Assert.assertEquals(y, 20, "Element is not on left most corner of page");
	HelperFunctions.staticWait(3);

	
}
public void setCursorChanging() throws Exception {
	
	//HelperFunctions.waitForPageToLoad(5);
	//HelperFunctions.staticWait(1);
	HelperFunctions.scrollToElement(footerContent);
	HelperFunctions.staticWait(2);
	Actions builder = new Actions(Driver.getDriver());

	for (WebElement link : footerLinks) {
	    builder.moveToElement(link).perform();
	    String cursorStyle = link.getCssValue("cursor");
	    Assert.assertEquals("pointer", cursorStyle, "Expected cursor style: pointer");
	}
	HelperFunctions.staticWait(3);
	
}
public void setNoBrokenLinks() throws Exception {
	
	//HelperFunctions.waitForPageToLoad(5);
	//HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(footerContent);
	HelperFunctions.staticWait(2);
	for (WebElement link : footerLinks) {
	    String href = link.getAttribute("href");
	    if (href != null && !href.startsWith("javascript")) {
	        if (href.endsWith("#")) {
	            continue; 
	        }
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL(href);
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("HEAD");
	            connection.connect();
	            int statusCode = connection.getResponseCode();
	            if (statusCode >= 400) {
	                 Assert.fail("Broken link: " + href + ", status code: " + statusCode);
	            }
	        } catch (IOException e) {
	             Assert.fail("IO Exception occurred: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	    }
	}
	HelperFunctions.staticWait(3);
}
public void setInsideViewAllProducts() throws Exception {
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(viewAll));
	 viewAll.click();
	 wait.until(ExpectedConditions.visibilityOf(allProducts2.get(0)));
	 if(allProducts2.size()>2) {
		 Assert.assertTrue(true);
	 }else {
		 String errorMessage = "There is no more than 2 products";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	 }
	
	 HelperFunctions.staticWait(3);
	
}

public void setModalTitle() throws Exception {
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(viewAll));
	 viewAll.click();
	 wait.until(ExpectedConditions.visibilityOf(modalTitle));
	 Assert.assertTrue(modalTitle.isDisplayed());
	 HelperFunctions.staticWait(2);
	
}
public void setForYouTitlesColor() {
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	for(WebElement each:foryouTitles){
		System.out.println(each.getCssValue("color"));
		Assert.assertTrue(each.getCssValue("color").contains("rgba(37, 37, 37, 1)"));
	}
	HelperFunctions.staticWait(3);
	
	
}
public void setViewLessButton() {
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", viewMoreButton);
     HelperFunctions.staticWait(2);
   Assert.assertTrue(viewLessButton.isDisplayed());
	HelperFunctions.staticWait(2);
	
	
}
public void setLightUpThumbnail() throws Exception {
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	HelperFunctions.waitForPageToLoad(5);
	
	  Actions actions = new Actions(Driver.getDriver());
	 HelperFunctions.staticWait(2);
	 for (int i = 0; i < 3; i++) {
		 if (!thumbnails.get(i).isDisplayed()) {
			  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("arguments[0].scrollIntoView(true);", thumbnails.get(i));
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		 String initialColor = thumbnails.get(i).getCssValue("opacity");
		 actions.moveToElement(thumbnails.get(i)).perform();
		 String actualEffect = thumbnails.get(i).getCssValue("opacity");
		 if (!initialColor.equals(actualEffect)) {
                System.out.println("Thumbnail " + i + " changes opacity when hovered over");
                Assert.assertTrue(true);
            } else {
                System.out.println("Thumbnail " + i + " does not change opacity when hovered over");
            }
        }
        
	 HelperFunctions.staticWait(2);
	
}
public void setOpenNewTab() {
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	HelperFunctions.waitForPageToLoad(5);
	//HelperFunctions.scrollToElement(forYouTitle);
	//HelperFunctions.staticWait(2);
	foryouTitles.get(2).click();
	HelperFunctions.staticWait(2);
	Set<String> handles=Driver.getDriver().getWindowHandles();
	if(handles.size()>1) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
	HelperFunctions.staticWait(2);
	
}
public void setClickingonLogo() {
	HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
	logo.click();
	HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    Assert.assertTrue(myproductTitle.isDisplayed());
    HelperFunctions.staticWait(1);
}

public void setRightSpace() {
	WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
    wait1.until(ExpectedConditions.visibilityOf(heroPromotion));
    Point elementPosition = heroPromotion.getLocation();
    Point expectedPosition=new Point(560, 260);
    System.out.println(elementPosition);
    //Assert.assertTrue(elementPosition.equals(expectedPosition));
    HelperFunctions.staticWait(2);
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", collapseButton);
    HelperFunctions.staticWait(2);
    Point elementPosition2 = heroPromotion.getLocation();
    Point expectedPosition2=new Point(447, 260);
    System.out.println(elementPosition2);
    Assert.assertTrue(!elementPosition.equals(expectedPosition2));
    HelperFunctions.staticWait(2);
}

public void setMyProductIcon() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    String myProductIcon=leftNavigationImg.get(0).getAttribute("src");
    Assert.assertNotNull(myProductIcon);
    HelperFunctions.staticWait(3);
}
public void setHeroPromotionNotClickable() {
	WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
    wait1.until(ExpectedConditions.visibilityOf(heroPromotion));
    String hrefValue = heroPromotion.getAttribute("href");
    HelperFunctions.staticWait(2);
    Assert.assertNull(hrefValue);
    HelperFunctions.staticWait(3);
}	

public void setHeroPromotionContentVericallyCentered() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='flex';" + 
            "arguments[0].style.flexDirection='column';" + 
            "arguments[0].style.justifyContent='center';" + 
            "arguments[0].style.height='100%';", contentSpace);
    HelperFunctions.staticWait(3);
}

public void set404Page() {
	//HelperFunctions.waitForPageToLoad(5);
    //HelperFunctions.staticWait(2);
   // Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/my-products/notproduct.html");
    //HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
    Assert.assertTrue(errorImage.isDisplayed());
    HelperFunctions.staticWait(2);
    Assert.assertTrue(errorTitle.isDisplayed()&&errorTitle.getText().contains("404"));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(errorDescription.isDisplayed());
    HelperFunctions.staticWait(2);
}

public void set404Page2() {
	//HelperFunctions.waitForPageToLoad(5);
   // HelperFunctions.staticWait(2);
   // Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/my-products/notproduct.html");
    //HelperFunctions.waitForPageToLoad(5);
    Assert.assertTrue(errorImage.isDisplayed());
    HelperFunctions.staticWait(2);
    Assert.assertTrue(errorDescription.isDisplayed()&&errorDescription.getText().contains("This page doesn't exist. Please click below to visit our homepage."));
    HelperFunctions.staticWait(2);
}

public void setCompareReleaseandAllResourcesElements() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    HelperFunctions.scrollToElement(allResources);
    HelperFunctions.staticWait(2);
    for (WebElement releaseNotesElement : releaseNotesElements) {
        for (WebElement allresourcesElement : allresourcesElements) {
            if (releaseNotesElement.equals(allresourcesElement)) {
                System.out.println("Error: Duplicate element found!");
            }
        }
    }
    HelperFunctions.staticWait(2);
}
public void setPreferencesModal() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
    HelperFunctions.waitForPageToLoad(25);
    HelperFunctions.staticWait(2);
    userInitials.click();
    HelperFunctions.staticWait(1);
    preferences.click();
    HelperFunctions.staticWait(2);
    Assert.assertTrue(preferencesModal.isDisplayed());
    HelperFunctions.staticWait(1);
}
public void setPreferencesToggle() {
	HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    userInitials.click();
    HelperFunctions.staticWait(1);
    preferences.click();
    HelperFunctions.staticWait(2);
    Assert.assertTrue(preferencesModal.isDisplayed());
    HelperFunctions.staticWait(1);
    Assert.assertTrue(toggleLabel.getText().equalsIgnoreCase("Off"));
    HelperFunctions.staticWait(1);
}

public void setPreferencesConsent() {
	HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    userInitials.click();
    HelperFunctions.staticWait(1);
    preferences.click();
    HelperFunctions.staticWait(2);
    Assert.assertTrue(preferencesModal.isDisplayed());
    HelperFunctions.staticWait(1);
    Assert.assertTrue(toggleLabel.getText().equalsIgnoreCase("Off"));
    HelperFunctions.staticWait(1);
    toggleButton.click();
    HelperFunctions.staticWait(1);
    consentCheckbox.click();
    HelperFunctions.staticWait(1);
    Assert.assertTrue(consentCheckbox.isSelected());
    HelperFunctions.staticWait(1);
    consentCheckbox.click();
    HelperFunctions.staticWait(1);
    toggleButton.click();
    HelperFunctions.staticWait(1);
}
public void setDifferentFooterItems() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(footerContent);
	HelperFunctions.staticWait(2);
for(WebElement link:footerLinksGroup) {
	if(link.getAttribute("data-show-anonymous")!=null) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}
HelperFunctions.staticWait(3);
   
}
public void setFooterVisibility() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(footerContent);
	HelperFunctions.staticWait(2);
	 if(footerContent.isDisplayed() && footerLinkGroup.isDisplayed() ) {
     	Assert.assertTrue(true);
     }else {
     	Assert.assertTrue(false);
     }
	 HelperFunctions.staticWait(3);
   
}

public void setFooterEachLink() {
	//HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(footerContent);
	//closeButtonforCookies.click();
	 HelperFunctions.staticWait(2);
	 for (WebElement link : footerLinksGroup2) {
		 if(link.getAttribute("href")!=null) {
			 Assert.assertTrue(true);
		 }else {
		     	Assert.assertTrue(false);
	     }
		}
	 HelperFunctions.staticWait(3);
}
public void setGatedContent() throws Exception {
	//HelperFunctions.waitForPageToLoad(15);
    //HelperFunctions.staticWait(2);
    //Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
   // HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    HelperFunctions.scrollToElement(footerContent);
    HelperFunctions.staticWait(2);
    try {
    	if (closeButtonforCookies.isDisplayed()) {
    	   
    		closeButtonforCookies.click();
    	    System.out.println("Close cookies.");
    	} 
    	}catch(NoSuchElementException | StaleElementReferenceException ignored) {
    		
    	}
	HelperFunctions.staticWait(2);
   /* for (WebElement link : footerLinksGroup2) {
        link.click(); 
        String pageTitle = Driver.getDriver().getTitle(); 
        System.out.println("Title of the current page is: " + pageTitle);
        Assert.assertTrue(pageTitle != null && !pageTitle.isEmpty(), "Page title is not present for link: " + link.getText());
        Driver.getDriver().navigate().back(); 
    }*/
    footerLinksGroup2.get(1).click();
    String pageTitle = Driver.getDriver().getTitle(); 
    System.out.println("Title of the current page is: " + pageTitle);
    Assert.assertTrue(pageTitle != null);
    
    HelperFunctions.staticWait(5);

}
public void setListedProducts() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(30);
	  WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 20);
	    wait4.until(ExpectedConditions.visibilityOf(productList));
	//HelperFunctions.staticWait(2);
	Assert.assertTrue(productList.isDisplayed());
	HelperFunctions.staticWait(3);
	
	
}
public void setFilterMoreDocument() {
	
	//HelperFunctions.waitForPageToLoad(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(myProductSearchField);
    wait.until(condition);
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Check-In");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(catDropdown));
	catDropdown.click();
	HelperFunctions.staticWait(5);
	for (int i = 8; i < 10 && i < products.size(); i++) {
	    WebElement checkbox = products.get(i);
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }
	}
	 HelperFunctions.staticWait(2);
	 for (int i = 8; i < 10 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (checkBox.isSelected()) {
		        Assert.assertTrue(true);
		    }else {
		    	 String errorMessage = "Verification failed";
			        logger.error(errorMessage);
		    }
		}
	HelperFunctions.staticWait(2);
	
	
}
public void setProductTitleandDescription() {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(productTitle));
	if(productTitle.getText()!=null && productDescription.getText()!=null) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Product title or description is an empty";
	        logger.error(errorMessage);
	}
	HelperFunctions.staticWait(2);
	
}
public void setAllResourcesTitle() {
	
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	 for (WebElement titleElement : allresourcesTitle) {
         String titleText = titleElement.getText();
         String[] titleLines = titleText.split("\n");
         if (titleLines.length > 3) {
             System.out.println("Title text is longer than three lines!");
         } else {
        	 Assert.assertTrue(true);
             System.out.println("Title text is restricted to three lines or less.");
         }
     }
	 HelperFunctions.staticWait(2);
	
}
public void setForYouTitles(ExtentTest test) {
    test.info("Wait for the page to load.");
    //HelperFunctions.waitForPageToLoad(15);
    HelperFunctions.staticWait(2);

    test.info("Scroll to the For You section.");
    HelperFunctions.scrollToElement(forYouTitle);
    HelperFunctions.staticWait(2);

    for (WebElement titleElement : foryouTitles) {
        String titleText = titleElement.getText();
        String[] titleLines = titleText.split("\n");
        if (titleLines.length > 4) {
            test.fail("Title text is longer than four lines!");
        } else {
            test.pass("Title text is restricted to four lines or less.");
        }
    }

    HelperFunctions.staticWait(2);
}

public void setAssetsDate() throws ParseException {
	//HelperFunctions.waitForPageToLoad(30);
	//HelperFunctions.staticWait(2);
	// Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/en_us/products/transparency-hub/myproducts");
	   // HelperFunctions.waitForPageToLoad(15);
	    HelperFunctions.staticWait(2);

	    List<WebElement> timeElements = Driver.getDriver().findElements(By.tagName("time"));
	    List<Date> dates = new ArrayList<>();

	    for (WebElement timeElement : timeElements) {
	        String datetime = timeElement.getAttribute("datetime");
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        Date date = df.parse(datetime);
	        dates.add(date);
	    }

	    boolean isSorted = true;
	    for (int i = 1; i < dates.size(); i++) {
	        if (dates.get(i).before(dates.get(i - 1))) {
	            isSorted = false;
	            break;
	        }
	    }

	    if (isSorted) {
	    	Assert.assertTrue(true);
	        System.out.println("The list is sorted.");
	    } else {
	        System.out.println("The list is not sorted.");
	    }
	    HelperFunctions.staticWait(2);
}
public void setLatestAssets() {
	HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(latestTitle);
	HelperFunctions.staticWait(2);
	if (latestAssets.size() == 3) {
		Assert.assertTrue(true);
	    System.out.println("Latest assets size is equal to 3.");
	} else {
	    System.out.println("Latest assets size is not equal to 3.");
	}
	
	HelperFunctions.staticWait(2);
	
}
public void setOrderedProducts() {
	HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	viewAll.click();
	HelperFunctions.staticWait(3);
	List<String> productsNameTexts = new ArrayList<String>();
	for (WebElement product : productsName) {
	    productsNameTexts.add(product.getText());
	}
	List<String> sortedProductsNameTexts = new ArrayList<String>(productsNameTexts);
	Collections.sort(sortedProductsNameTexts);
	if (productsNameTexts.equals(sortedProductsNameTexts)) {
		Assert.assertTrue(true);
	    System.out.println("Product names are in alphabetical order.");
	} else {
	    System.out.println("Product names are not in alphabetical order.");
	}
	HelperFunctions.staticWait(2);
	
	
}

public void setSeperator() {
	/*HelperFunctions.waitForPageToLoad(10);
	JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
    js2.executeScript("window.scrollBy(0,250)", "");
    HelperFunctions.staticWait(3);
    logintoMyproducts.click();
	HelperFunctions.waitForPageToLoad(15);*/
	//HelperFunctions.staticWait(3);
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/check-in.html");
	//HelperFunctions.waitForPageToLoad(15);
	WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
    wait1.until(ExpectedConditions.visibilityOf(viewAll));
	viewAll.click();
	HelperFunctions.staticWait(5);
    for(int i=0;i<allProducts2.size();i++) {
		allProducts2.get(1).click();
		break;
    }
    HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(technicalSupportTitle);
	HelperFunctions.staticWait(2);
	List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='cmp-all-resources']//following-sibling::div[not(@class='cmp-separator')]//preceding-sibling::div[not(@class='cmp-separator')]"));
	if (elements.size() == 1) {
		Assert.assertTrue(true);
	    System.out.println("There is only one element between the two elements.");
	} else {
	    System.out.println("There are more than one elements between the two elements.");
	}
	HelperFunctions.staticWait(3);
	
	
}

public void setNotDublicatedReleaseNotes() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
	//HelperFunctions.waitForPageToLoad(15);
	//HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(4);
	for(WebElement element:docOptionsLabel) {
		if(element.getText().equalsIgnoreCase("Release Notes")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element);
			break;
		}
	}
	String firstRelease=releaseNotesTitle.get(0).getText();
	if(!resource1.getText().equalsIgnoreCase(firstRelease)) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
	HelperFunctions.staticWait(2);
	
	
}
public void setReleaseNotesVisibilityonDropdown() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
	HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(5);
	for(WebElement element:docOptionsLabel) {
		if(element.getText().equalsIgnoreCase("Release Notes")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element);
			break;
		}
	}
	HelperFunctions.staticWait(5);
	Assert.assertTrue(cardCategory.getText().contains("Release Notes"));
	HelperFunctions.staticWait(2);
	
	
	
}
public void setReleaseNotesFilter() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
	HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(5);
	for(WebElement element:docOptionsLabel) {
		if(element.getText().equalsIgnoreCase("Release Notes")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element);
			break;
		}
	}
	HelperFunctions.staticWait(5);
	Assert.assertTrue(cardCategory.getText().contains("Release Notes"));
	HelperFunctions.staticWait(2);
		
}
public void setDifferenceFromAssetTitlesandReleaseNote() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
	HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(5);
	for(WebElement element:docOptionsLabel) {
		if(element.getText().equalsIgnoreCase("Release Notes")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element);
			break;
		}
	}
	HelperFunctions.staticWait(5);
	String release=resource1.getText();
	for(WebElement element:foryouTitles) {
		if(element.getText().equalsIgnoreCase(release)) {
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
	}
	HelperFunctions.staticWait(2);
		
}
public void setDropdownMatchwithProducts() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	searchButton.click();
	HelperFunctions.staticWait(3);	
    searchInput.sendKeys("products");
    HelperFunctions.staticWait(2);
    searchInput.sendKeys(Keys.ENTER);
    HelperFunctions.waitForPageToLoad(60);
	HelperFunctions.staticWait(2);
	productDropdown.click();
	HelperFunctions.staticWait(5);
	String value=pcDropdownLabel2.get(1).getAttribute("value");
	Assert.assertTrue(value.contains("change-navigator"));
	HelperFunctions.staticWait(2);

	
}
public void setDropdownAlphabetical() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	searchButton.click();
	HelperFunctions.staticWait(3);	
    searchInput.sendKeys("products");
    HelperFunctions.staticWait(2);
    searchInput.sendKeys(Keys.ENTER);
    HelperFunctions.waitForPageToLoad(60);
	HelperFunctions.staticWait(2);
	productDropdown.click();
	HelperFunctions.staticWait(5);
	List<String> dropdownLabelText = new ArrayList<String>();
	for (WebElement element : pcDropdownLabel) {
	    String text = element.getText().trim();
	    if (!text.isEmpty()) {
	        dropdownLabelText.add(text);
	    }
	}
	Collections.sort(dropdownLabelText);

	for (int i = 0; i < pcDropdownLabel.size(); i++) {
	    WebElement element = pcDropdownLabel.get(i);
	    String expectedText = i < dropdownLabelText.size() ? dropdownLabelText.get(i) : "";
	    String actualText = element.getText().trim();
	    Assert.assertEquals(actualText, expectedText);
	}
	HelperFunctions.staticWait(2);

	
}
public void setPublishDate() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	List<String> dates = new ArrayList<String>();
	for (WebElement element : latestAssets) {
	    String date = element.getAttribute("data-pwc-publication-date");
	    if(date!=null && !date.isEmpty()) {
	    	 dates.add(date);
	    }
	}
	List<String> sortedDates = new ArrayList<String>(dates);
	Collections.sort(sortedDates, Collections.reverseOrder());
	Assert.assertEquals(dates, sortedDates);
	HelperFunctions.staticWait(3);
	
}
public void setFilterTargetSpecificContent() {
	//HelperFunctions.waitForPageToLoad(15);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(forYouTitle);
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(5);
	for(WebElement element:docOptionsLabel) {
		if(element.getText().equalsIgnoreCase("Release Notes")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element);
			break;
		}
	}
	HelperFunctions.staticWait(5);
	Assert.assertTrue(cardCategory.getText().contains("Release Notes"));
	HelperFunctions.staticWait(2);
	selectDropdown.click();
	HelperFunctions.staticWait(5);
	for(WebElement element2:docOptionsLabel) {
		if(element2.getText().equalsIgnoreCase("User Guide")) {
			JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
			executor.executeScript("arguments[0].click();", element2);
			break;
		}
	}
	HelperFunctions.staticWait(5);
	Assert.assertTrue(cardCategory.getText().contains("User Guide"));
	HelperFunctions.staticWait(2);
	
	
	
}
public void setDifferentFooterLinks() {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	
	
	
	
}
public void setReleaseNotesTable() {
	//HelperFunctions.waitForPageToLoad(15);
    HelperFunctions.staticWait(2);
    HelperFunctions.scrollToElement(allResources);
    HelperFunctions.staticWait(2);
    List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector(".cmp-release-notes__card-description, .cmp-release-notes__separator"));

 boolean found = false;

 for (int i = 0; i < elements.size() - 1; i++) {
     WebElement currentElement = elements.get(i);
     WebElement nextElement = elements.get(i + 1);

     if (currentElement.getTagName().equals("div") && currentElement.getAttribute("class").equals("cmp-release-notes__card-description")
             && nextElement.getTagName().equals("span") && nextElement.getAttribute("class").equals("cmp-release-notes__separator")) {
         found = true;
         break;
     }
 }
 HelperFunctions.staticWait(2);
 //Assert.assertTrue(found);
 HelperFunctions.staticWait(2);
 for(WebElement eachLink: releaseNotesTitle2) {
	 if(eachLink.getAttribute("href")!=null) {
		 Assert.assertTrue(true);
	 }else {
		 Assert.assertTrue(false);
	 }
 }
 HelperFunctions.staticWait(3);
}
public void setReleaseNotesAssetsOpenNewTab() {
	//HelperFunctions.waitForPageToLoad(15);
    HelperFunctions.staticWait(2);
    HelperFunctions.scrollToElement(viewMoreButton);
    HelperFunctions.staticWait(2);
    releaseNotesTitle2.get(0).click();
    HelperFunctions.staticWait(5);
    Set<String> windowHandles = Driver.getDriver().getWindowHandles();
    Assert.assertEquals(windowHandles.size(), 2);
    HelperFunctions.staticWait(2);
}

public void setAssetsDesignDifferences() {
	//HelperFunctions.waitForPageToLoad(15);
    HelperFunctions.staticWait(2);
    for(WebElement div : divList) {
        List<WebElement> childDivs = div.findElements(By.tagName("div"));
        if(childDivs.size() == 1 && childDivs.get(0).getAttribute("class").equals("cmp-my-products-tile__title")) {
        	 Assert.assertTrue(true);
            System.out.println("The div contains only the title");
        } else {
            System.out.println("The div does not contain only the title");
        }
    }
    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/us/en/products.html");
    HelperFunctions.waitForPageToLoad(30);
    HelperFunctions.staticWait(2);
    if(!divElements.isEmpty()) {
        WebElement firstDiv = divElements.get(0);
        List<WebElement> spanElements = firstDiv.findElements(By.tagName("span"));
        if(spanElements.size() == 2) {
        	Assert.assertTrue(true);
            System.out.println("The first div contains two span elements");
        } else {
            System.out.println("The first div does not contain two span elements");
        }
    } else {
        System.out.println("No div elements with class cmp-product-list__card-content found");
    }
    HelperFunctions.staticWait(3);
}

public void setMatchingProducts() {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(myProductSearchField));
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	String product="products";
	myProductSearchField.sendKeys(product);
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(30);
	for(WebElement each: productList2) {
		System.out.println(each.getText());
		Assert.assertTrue(each.isDisplayed());
	}
	HelperFunctions.staticWait(3);
	
	
}

public void setDifferentPrivacy() throws Exception {
	
	HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(3);
	List<WebElement> anchorElements = Driver.getDriver().findElements(By.xpath("//a[@class='ap-link' and @href]"));
	List<String> hrefValues=new ArrayList<>();
	for(WebElement element:anchorElements) {
		String hrefValue=element.getAttribute("href");
		hrefValues.add(hrefValue);
	}
	boolean areDifferent = true;
	for (int i = 0; i < hrefValues.size() - 1; i++) {
	    for (int j = i + 1; j < hrefValues.size(); j++) {
	        if (hrefValues.get(i).equals(hrefValues.get(j))) {
	            areDifferent = false;
	            break;
	        }
	    }
	}

	Assert.assertTrue(areDifferent);
	HelperFunctions.staticWait(3);
}

public void setMultimediaSearch() {
	
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	wait.until(ExpectedConditions.visibilityOf(myProductSearchField));
	myProductSearchField.click();
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys("Multimedia");
	HelperFunctions.staticWait(2);
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(30);
	wait.until(ExpectedConditions.visibilityOf(firstSearchResult));
	Assert.assertTrue(firstSearchResult.isDisplayed());
	HelperFunctions.staticWait(2);
	searchButton.click();
	HelperFunctions.staticWait(3);	
	searchInput.sendKeys("Multimedia");
	HelperFunctions.staticWait(2);
	searchInput.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(15);
	wait.until(ExpectedConditions.visibilityOf(firstSearchResult));
    Assert.assertTrue(firstSearchResult.isDisplayed());
	HelperFunctions.staticWait(2);
	
}
	
	
public void setLinesOfHero() throws Exception {
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(2);
    String[] lines = heroTitle.getText().split("\n");
    int numLines = lines.length;

    if (numLines < 3) {
        Assert.assertTrue(true);
        System.out.println("The heroTitle element has fewer than 3 lines of text.");
    } else {
        System.out.println("The heroTitle element has 3 or more lines of text.");
    }
    String[] lines2 = heroDesc.getText().split("\n");
    int numLines2 = lines2.length;
    if (numLines2 < 3) {
        Assert.assertTrue(true);
        System.out.println("The heroTitle element has fewer than 3 lines of text.");
    } else {
        System.out.println("The heroTitle element has 3 or more lines of text.");
    }
}
public void setDisplayResources(ExtentTest test) throws Exception {
	test.info("Wait for the page to load.");
	//HelperFunctions.waitForPageToLoad(15);
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	//HelperFunctions.waitForPageToLoad(15);
	//test.info("Click on view all");
	// WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	//    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(viewAll);
	//    wait.until(condition);
	//    HelperFunctions.staticWait(3);
	/*viewAll.click();
	test.info("Select a product in product container");
	HelperFunctions.staticWait(2);
    for(int i=0;i<allProducts2.size();i++) {
		allProducts2.get(1).click();
		break;
    }
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(3);*/
    test.info("Scroll down all resources");
	HelperFunctions.scrollToElement(allResources); 
	HelperFunctions.staticWait(3);
     for(WebElement eachResources: first5resources) {
    	 if(eachResources.isDisplayed()) {
    		 String successMessage = "First 5 resources are displayed";
             logger.info(successMessage);
    		 Assert.assertTrue(true);
    	 }else {
    		 String errorMessage = "First 5 resources are not displayed";
             logger.error(errorMessage);
             throw new Exception(errorMessage);
    		// Assert.assertTrue(false);
    	 }
    	 test.info("Verified first 5 resources are displayed");
     }
     HelperFunctions.staticWait(3);
     Assert.assertTrue(nextButtonforResources2.size()==0);
     HelperFunctions.staticWait(2);
     JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
     executor9.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",allresourcesContainer);
     long scrollPosition=(long)executor9.executeScript("return arguments[0].scrollTop", allresourcesContainer);
     long scrollHeight=(long)executor9.executeScript("return arguments[0].scrollHeight - arguments[0].clientHeight", allresourcesContainer);
     if(scrollPosition>=scrollHeight) {
    	 Assert.assertTrue(true);
     }else {
    	 Assert.assertTrue(false);
     }
     HelperFunctions.staticWait(3);
    }	
public void setOutageBannerMessage(ExtentTest test) throws Exception {
	test.info("Wait for the page to load.");
	//HelperFunctions.waitForPageToLoad(10);
	/*JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
    js2.executeScript("window.scrollBy(0,250)", "");
    HelperFunctions.staticWait(3);
    logintoMyproducts.click();
	HelperFunctions.waitForPageToLoad(15);*/
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	//HelperFunctions.waitForPageToLoad(15);
	WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
    wait1.until(ExpectedConditions.visibilityOf(outageBannerMessage));
	HelperFunctions.staticWait(3);
	String text1="We are investigating a service outage";
	int currentYear=LocalDate.now().getYear();
	Assert.assertTrue(outageBannerMessage.getText().contains(text1));
	HelperFunctions.staticWait(2);
	Assert.assertTrue(outageBannerMessage.getText().contains(String.valueOf(currentYear)));
	HelperFunctions.staticWait(3);
	    
}
public void setPrivacyHeaderBackground(ExtentTest test) throws Exception {
	test.info("Wait for the page to load.");
	HelperFunctions.waitForPageToLoad(30);
	WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
    wait1.until(ExpectedConditions.visibilityOf(privacyHeader));
    String actualColor=privacyHeader.getCssValue("background-color");
    String expectedColor="rgba(242, 242, 242, 0.48)";
    System.out.println(privacyHeader.getCssValue("background-color"));
    Assert.assertEquals(actualColor, expectedColor);
    HelperFunctions.staticWait(3);
}
public void setPreferencesModalNotDisplayed() {
	HelperFunctions.waitForPageToLoad(5);
    //HelperFunctions.staticWait(2);
   // Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/transparency-hub.html");
   // HelperFunctions.waitForPageToLoad(5);
   // HelperFunctions.staticWait(2);
    userInitials.click();
    HelperFunctions.staticWait(3);
    Assert.assertTrue(!preferences.isDisplayed());
    HelperFunctions.staticWait(3);
}
	
	
	

 
	
	

	
	
	

	
	
	
	
	
	

}
