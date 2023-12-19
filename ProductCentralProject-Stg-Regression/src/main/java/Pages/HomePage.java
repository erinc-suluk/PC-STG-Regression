package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class HomePage extends HelperFunctions {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	@FindBy(xpath="//img[@class='cmp-hero__image']")
	private WebElement promotionBannerImage;
	
	@FindBy(xpath="//div[@class='cmp-hero__description']")
	private WebElement descriptionOfPromotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-hero']")
	private WebElement promotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']")
	private static List<WebElement> leftNavigationItems2;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a")
	private static List<WebElement> homePageTiles;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement legalTile;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a[1]")
	private WebElement FirsthomePageTile;
	
	@FindBy(xpath="//div[@class='cmp-product-list__search-bar-container']")
	private WebElement landingPageComponentForLegalTile;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-title']")
	private static List<WebElement> titleOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement oneStopTitle;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='text cmp-tiles__description']")
	private WebElement descriptionOfTitle;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement logintoMyProduct;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles/title']")
	private WebElement titleforAuthor;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='globalSearchInput']")
	private WebElement searchInput;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div//label")
	private static List<WebElement> productDropdownList;
	
	@FindBy(xpath="//input[@id='change-navigator']")
	private WebElement changeNavigatorCheckbox;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='data-processing-addendum']")
	private WebElement dataAppCheckbox;
	
	@FindBy(xpath="//input[@id='documentation']")
	private WebElement documentationCheckbox;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[1]")
	private WebElement dataAppTitle;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//span[@class='sdk-HeaderFileInfoView-fileBreadCrumb sdk-HeaderFileInfoView-fileBreadCrumbNormal']")
	private WebElement dataAppContent;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-option-item'])//input")
	private static List<WebElement> catDropdownCheckboxes;
	
	@FindBy(xpath="((//div[@class='cmp-search-results__page ap-page-container'])//div[3])[position()=1 or position()=2 or position()=3 or position()=4 or position()=5 or position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> resultList;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement loginToMyProductLink;
	
	@FindBy(xpath="(//*[@id='searchProductDropdown']/div[2])//div")
	private static List<WebElement> productDropdownItems;
	
	@FindBy(xpath="//*[@id='docDropdown']/div[2]//div")
	private static List<WebElement> catDropdownItems;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-list show'])[2]//div//label")
	private static List<WebElement> catDropdownList;
	
	@FindBy(xpath="//div[@data-href='/content/pc/us/en/my-products/product-4.html']")
	private WebElement loginLink;
	
	@FindBy(xpath="//img[@id='PwCLogo']")
	private WebElement pwcLogo;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@class='ap-dropdown-option-checkbox']")
	private static List<WebElement> productCheckbox;
	
	@FindBy(xpath="//div[@class='cmp-search-results__card-title']")
	private static List<WebElement> resultsTitles;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> productDropdownList2;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="//div[@id='resultsContainer']//div//a")
	private WebElement resultContainer;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private WebElement breadCrumb;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProducts;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement optionItem;
	
	@FindBy(xpath="//a[@class='cmp-product-list__card-link']")
	private WebElement resultLink;
	
	@FindBy(xpath="//h2[@class='cmp-hero__title']")
	private WebElement promoTitle;
	
	@FindBy(xpath="//div[@class='cmp-hero__action-container']")
	private WebElement promoActionCont;
	
	@FindBy(xpath="//div[@class='ap-footer-link-group']")
	private static WebElement footerElements;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footerHome;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a[1]")
	private static WebElement firstTile;
	
	@FindBy(xpath="//div[@id='faqsTooltipDisplayButton']")
	private static WebElement needHelp;
	
	@FindBy(xpath="//div[@class='cmp-faqs-tooltip__links']//a")
	private static List<WebElement> tooltipLinks;
	
	@FindBy(xpath="//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private static WebElement closeButtonforCookies;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[1]")
	private WebElement firstSearchResult;
	
	@FindBy(xpath="//span[@class='cmp-search-results__empty-text']")
	private WebElement noSearchResult;
	
	@FindBy(xpath="//div[@class='cmp-search-results__page ap-page-container']//a")
	private static List<WebElement> searchProducts2;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//input")
	private static List<WebElement> products;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//label")
	private static List<WebElement> productsLabel;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div")
	private static List<WebElement> sortingElements;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div[1]")
	private WebElement firstSortingElement;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div[2]")
	private WebElement secondSortingElement;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div[position()>1]")
	private static List<WebElement> otherSortingElements;
	
	@FindBy(xpath="//div[@class='cmp-search-results__card-title']")
	private static List<WebElement> cardTitles;
	
	@FindBy(xpath="//h1[@class='cmp-search-results__filter-section-title-heading']")
	private WebElement searchResultsTitle;
	
	@FindBy(xpath="//a[@class='cmp-breadcrumb__link referrer-module']")
	private WebElement breadcrumbSearchpage;
	
	@FindBy(xpath="//div[@class='cmp-hero__action-container']//a")
	private WebElement allProductsButton;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="(//button[@data-layer='Edit'])[2]")
	private WebElement editButton;
	
	@FindBy(xpath="//ul[@class='ap-footer-link-group']//a")
	private static List<WebElement> footerElementsLink;
	
	@FindBy(xpath="//div[@class='cmp-header__logo']")
	private WebElement pwcLogo2;
	 
	@FindBy(xpath="//span[@class='total-count']")
	private WebElement totalCount;
	
	@FindBy(xpath="//div[@class='playkit-video-player']")
	private static List<WebElement> videoPlayers;
	
	
	ReadXLSdata read2=new ReadXLSdata();
	
	
		
	static Logger logger=Logger.getLogger("HomePage");
	
	public void setTitlesColor(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		test.info("Checking each title of tiles' hex color");
		 for (WebElement title : titleOfTiles) { 

	           String color = title.getCssValue("color");
	           String hexColor = Color.fromString(color).asHex(); 
	           if(hexColor.equals("#252525")) {
	        	   String successMessage = "Color of Titles is black";
			        logger.info(successMessage);
				Assert.assertTrue(true);
	           }else {
	        	   String errorMessage = "Color of Titles is not black";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
	           }
	          
	       }
		 test.info("Verified Color of Titles is black");
		 HelperFunctions.staticWait(2);
	}
	
	public void setTilesNumber(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		int numberOfTiles=homePageTiles.size();
		if(numberOfTiles<=15) {
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Tiles' size more than 15 ";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		}
		test.info("Verified Tiles' size is not more than 15");
		 HelperFunctions.staticWait(2);
	}
	
	public void setTilesHasLoginLink(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		if(FirsthomePageTile.getText().contains("My Products")&&FirsthomePageTile.getText().contains("Login to My Products")) {
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "My Product Tile does not contain 'login to my product' link";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		}
		test.info("Verified My Product Tile contains 'login to my product' link");
	}
	
public void setLegalTile() {
		
		HelperFunctions.waitForPageToLoad(5);
		for (WebElement link : homePageTiles) {
		    try {
		        String expectedUrl = link.getAttribute("href");
		        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
		        WebElement linkClickable = wait.until(ExpectedConditions.elementToBeClickable(link));
		        linkClickable.click();
		        String actualUrl = Driver.getDriver().getCurrentUrl();
		        Assert.assertTrue(actualUrl.startsWith("https://login"));
		    } catch (StaleElementReferenceException e) {
		      
		    }
		}
   
		
	}

public void setPromoTitle() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	if(promoTitle.getText().equalsIgnoreCase("Welcome to Product Central")) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Promotion banner does not contain a page title 'Welcome to Product Central' ";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
}

public void setPromotionBannerElements() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	if(promotionBannerImage.isDisplayed()&&descriptionOfPromotionBanner.isDisplayed()&&promoTitle.isDisplayed()&&promoActionCont.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Missing promotion banner element";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
}

public void setFooterBar() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(footerHome);
	HelperFunctions.staticWait(3);
	
	/*	if(footerElements.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			String errorMessage = "Missing footer element";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
		}*/
	
	if(footerHome.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		String errorMessage = "Missing footer text";
        logger.error(errorMessage);
        throw new Exception(errorMessage);
	}
}

public void setDescriptionOfTiles() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement eachDescription: descriptionOfTiles) {
		System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
		if(eachDescription.getCssValue("-webkit-line-clamp").equals("6")) {
			 String successMessage = "The description is 6 lines";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "The description is more than 6 lines";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);

			
		}
	}
}

public void setClickability() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	String beforeBoxShadow = firstTile.getCssValue("box-shadow");
	System.out.println(beforeBoxShadow);
	Actions actions = new Actions(Driver.getDriver());

	actions.moveToElement(firstTile).perform();
	HelperFunctions.staticWait(3);
	String afterBoxShadow = firstTile.getCssValue("box-shadow");
	System.out.println(afterBoxShadow);
	if(!beforeBoxShadow.equals(afterBoxShadow)) {
		String successMessage = "Tile shadow has changed";
        logger.info(successMessage);
	Assert.assertTrue(true);
	}else {
		 String errorMessage = "Tile shadow has not changed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);

	}
}

public void setItemsinNeedHelp() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	try {
    	if (closeButtonforCookies.isDisplayed()) {
    	   
    		closeButtonforCookies.click();
    	    System.out.println("Close cookies.");
    	} 
    	}catch(NoSuchElementException | StaleElementReferenceException ignored) {
    		
    	}
	HelperFunctions.staticWait(2);
	needHelp.click();
	HelperFunctions.staticWait(2);
	for(WebElement eachLink:tooltipLinks) {
		if(eachLink.isDisplayed()) {
			String successMessage = "Each link is displayed";
	        logger.info(successMessage);
		Assert.assertTrue(true);
		}else {
			 String errorMessage = "Each link is not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);

		}
	}
	
}
public void setItemsinNeedHelpExpandCollapse() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(2);
	if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
	    // Click the accept cookies button
		closeButtonforCookies.click();
	    System.out.println("Close cookies.");
	} else {
	    System.out.println("Cookies already closed.");
	}
	HelperFunctions.staticWait(2);
	needHelp.click();
	HelperFunctions.staticWait(2);
	for(WebElement eachLink:tooltipLinks) {
		if(eachLink.isDisplayed()) {
			String successMessage = "Each link is displayed";
	        logger.info(successMessage);
		Assert.assertTrue(true);
		}else {
			 String errorMessage = "Each link is not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);

		}
	}
	HelperFunctions.staticWait(2);
	needHelp.click();
	HelperFunctions.staticWait(2);
	for(WebElement eachLink:tooltipLinks) {
		if(!eachLink.isDisplayed()) {
			String successMessage = "Each link is not displayed";
	        logger.info(successMessage);
		Assert.assertTrue(true);
		}else {
			 String errorMessage = "Each link still is displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);

		}
	}
	
}

public void setSearchResult() {
	   HelperFunctions.waitForPageToLoad(3);
	searchButton.click();
	HelperFunctions.staticWait(3);
	
    searchInput.sendKeys("products");
    searchInput.sendKeys(Keys.ENTER);
    HelperFunctions.staticWait(3);
    productDropdown.click();
    String expectedProductName="change-navigator";
    for(int i=0; i<productCheckbox.size(); i++) {
 	   if(productCheckbox.get(i).getAttribute("id").equalsIgnoreCase(expectedProductName)) {
 		   productCheckbox.get(i).click();
 	   }
    }
    productDropdown.click();
    HelperFunctions.staticWait(3);
    String actualProductName=resultContainer.getAttribute("data-product-name");
    System.out.println(actualProductName);
    Assert.assertEquals(actualProductName, expectedProductName);
    resultContainer.click();
   // HelperFunctions.staticWait(3);
   // breadCrumb.click();
    HelperFunctions.staticWait(3);
    String actualTitle=oneStopTitle.getText();
    String expectedTitle="Change Navigator";
    Assert.assertEquals(actualTitle, expectedTitle);
    breadCrumb.click();
    HelperFunctions.staticWait(3);
    searchProducts.click();
    searchProducts.sendKeys(expectedTitle);
    optionItem.click();
    HelperFunctions.staticWait(3);
    String actualTitle2=resultLink.getAttribute("data-product-name");
    Assert.assertEquals(actualTitle2, expectedTitle);


}

public void setLimitOfSearchResults() {
	   HelperFunctions.waitForPageToLoad(3);
	searchButton.click();
	HelperFunctions.staticWait(3);
	
 searchInput.sendKeys("products");
 searchInput.sendKeys(Keys.ENTER);
 HelperFunctions.staticWait(3);
/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
		
		closeButtonforCookies.click();
	    System.out.println("Close cookies.");
	} else {
	    System.out.println("Cookies already closed.");
	}
 HelperFunctions.staticWait(2);*/
 productDropdown.click();
 for (int i = 0; i < 20 && i < products.size(); i++) {
	    WebElement checkBox = products.get(i);
	    if (!checkBox.isSelected()) {
	        checkBox.click();
	    }
	}
 HelperFunctions.staticWait(2);
 productDropdown.click();
 
 HelperFunctions.staticWait(2);
	
	int webElementsListSize = searchProducts2.size();

	int elementsPerPage = 10;

	for (int i = 0; i < elementsPerPage; i++) {
	    System.out.println(searchProducts2.get(i).getText());
	}

	if (webElementsListSize > elementsPerPage) {
	
	    WebElement nextButton = Driver.getDriver().findElement(By.xpath("(//span[@class='ap-pagination-btn-text'])[2]"));
	    HelperFunctions.scrollToElement(nextButton);
	    nextButton.click();

	    for (int i = elementsPerPage; i < webElementsListSize; i++) {
	        System.out.println(searchProducts2.get(i).getText());
	    }
	}


}
public void setOrangeSearchResults() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	 if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	 for (int i = 0; i < 1 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	HelperFunctions.staticWait(2);
	
	String expectedColorValue = "rgba(208, 74, 2, 1)";
	String colorValue2 = firstSearchResult.getCssValue("color");
	System.out.println(colorValue2);
	
	Actions actions = new Actions(Driver.getDriver());
	actions.moveToElement(firstSearchResult).build().perform();
	HelperFunctions.staticWait(2);
	String colorValue = firstSearchResult.getCssValue("color");
	System.out.println(colorValue);
	Assert.assertTrue(colorValue.contains(expectedColorValue));
	

	

	
}
public void setBlackSearchResults() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);*/
	 productDropdown.click();
	 for (int i = 0; i < 1 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	HelperFunctions.staticWait(2);
	
	String expectedColorValue = "rgba(45, 45, 45, 1)";
	String colorValue2 = firstSearchResult.getCssValue("color");
	System.out.println(colorValue2);
	HelperFunctions.staticWait(2);
	String colorValue = firstSearchResult.getCssValue("color");
	System.out.println(colorValue);
	Assert.assertTrue(colorValue.contains(expectedColorValue));
	

	

	
}
public void setLineItems() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);*/
	 productDropdown.click();
	 for (int i = 0; i < 4 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	HelperFunctions.staticWait(2);
	
	for (WebElement searchResultElement : searchProducts2) {
	    if(searchResultElement.getAttribute("href")!=null) {
	    	Assert.assertTrue(true);
	    }else {
	    	 String errorMessage = "Verification failed";
		        logger.error(errorMessage);
	    }
	}
	

	

	
}
public void setMultiselectDropdown() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	 productDropdown.click();
	 for (int i = 0; i < 4 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 for (int i = 0; i < 4 && i < products.size(); i++) {
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
public void setNotMultiSelectSortingDropdown() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	 /*if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);*/
	 sortingDropdown.click();
	 HelperFunctions.staticWait(2);
	 firstSortingElement.click();
	 HelperFunctions.staticWait(2);
	 for(WebElement each:otherSortingElements) {
		 if(!each.isDisplayed()) {
			 
			 Assert.assertTrue(true);
		    }else {
		    	 String errorMessage = "Verification failed";
			        logger.error(errorMessage);
		    }
	 }
   

	

	
}
public void setSortingSearchResult() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);*/
	 sortingDropdown.click();
	 HelperFunctions.staticWait(2);
	 firstSortingElement.click();
	 
	 List<String> cardTitles2 = new ArrayList<>();
     for (WebElement cardTitleElement : cardTitles) {
         cardTitles2.add(cardTitleElement.getText());
     }

     List<String> first10CardTitles = cardTitles2.subList(0, Math.min(10, cardTitles2.size()));
     List<String> sortedFirst10CardTitles = new ArrayList<>(first10CardTitles);
     Collections.sort(sortedFirst10CardTitles);
     boolean areFirst10CardTitlesSorted = first10CardTitles.equals(sortedFirst10CardTitles);
     if (areFirst10CardTitlesSorted) {
    	 Assert.assertTrue(true);
         System.out.println("The card titles are in alphabetical order.");
     } else {
    	 String errorMessage = "Verification failed";
	        logger.error(errorMessage);
   
     }
	
     HelperFunctions.staticWait(2);
	 sortingDropdown.click();
	 HelperFunctions.staticWait(2);
	 secondSortingElement.click();
	 HelperFunctions.staticWait(2);
	 List<String> cardTitles3 = new ArrayList<>();
     for (WebElement cardTitleElement2 : cardTitles) {
         cardTitles3.add(cardTitleElement2.getText().trim());
     }
     List<String> first10CardTitles2 = cardTitles3.subList(0, Math.min(10, cardTitles3.size()));
     List<String> sortedFirst10CardTitles2 = new ArrayList<>(first10CardTitles2);
     Collections.sort(sortedFirst10CardTitles2, Collections.reverseOrder());
     boolean areFirst10CardTitlesSorted2 = first10CardTitles2.equals(sortedFirst10CardTitles2);
     if (areFirst10CardTitlesSorted2) {
    	 Assert.assertTrue(true);
         System.out.println("The card titles are in reverse alphabetical order.");
     } else {
    	 String errorMessage = "Verification failed";
	        logger.error(errorMessage);
  
     }

	

	
}
public void setTitleofThePage() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
			
			closeButtonforCookies.click();
		    System.out.println("Close cookies.");
		} else {
		    System.out.println("Cookies already closed.");
		}
	 HelperFunctions.staticWait(2);*/
	 System.out.println(searchResultsTitle.getText());
	 if(searchResultsTitle.getText().equalsIgnoreCase("Search results")) {
		 Assert.assertTrue(true);
	 }else {
		 String errorMessage = "Verification failed";
	        logger.error(errorMessage);
	 }
	
  

	

	
}
public void setNavigateHomepage() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.waitForPageToLoad(3);
	 HelperFunctions.staticWait(3);
	
	 breadcrumbSearchpage.click();
	 HelperFunctions.waitForPageToLoad(5);
	 if(promotionBanner.isDisplayed()) {
		 Assert.assertTrue(true);
	 }else {
		 String errorMessage = "Verification failed";
	        logger.error(errorMessage);
	 }

	
}
public void setBackoHomeBreadcrumb() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.waitForPageToLoad(3);
	 HelperFunctions.staticWait(3);
	 System.out.println(breadcrumbSearchpage.getText());
	 if(breadcrumbSearchpage.isDisplayed()) {
		 Assert.assertTrue(true);
	 }else {
		 String errorMessage = "Verification failed";
	        logger.error(errorMessage);
	 }

	
}
public void setColorDifferences() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.waitForPageToLoad(3);
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	 for (int i = 0; i < 1 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 productDropdown.click();
	HelperFunctions.staticWait(2);
	
	String expectedColorValue = "rgba(45, 45, 45, 1)";
	String colorValue2 = firstSearchResult.getCssValue("color");
	System.out.println(colorValue2);
	HelperFunctions.staticWait(2);
	String colorValue = firstSearchResult.getCssValue("color");
	System.out.println(colorValue);
	Assert.assertTrue(colorValue.contains(expectedColorValue));
	HelperFunctions.staticWait(2);
	String expectedColorValue2 = "rgba(208, 74, 2, 1)";
	String colorValue3 = firstSearchResult.getCssValue("color");
	System.out.println(colorValue3);
	
	Actions actions = new Actions(Driver.getDriver());
	actions.moveToElement(firstSearchResult).build().perform();
	HelperFunctions.staticWait(2);
	String colorValue4 = firstSearchResult.getCssValue("color");
	System.out.println(colorValue4);
	Assert.assertTrue(colorValue4.contains(expectedColorValue2));
	

	
}
public void setFilterMatchingSearchResults() {
	
	 HelperFunctions.waitForPageToLoad(3);
		searchButton.click();
		HelperFunctions.staticWait(3);
		
	 searchInput.sendKeys("products");
	 searchInput.sendKeys(Keys.ENTER);
	 HelperFunctions.staticWait(3);
	 productDropdown.click();
	 for (int i = 0; i < 1 && i < products.size(); i++) {
		    WebElement checkBox = products.get(i);
		    if (!checkBox.isSelected()) {
		        checkBox.click();
		    }
		}
	 HelperFunctions.staticWait(2);
	 for (int i = 0; i < 1 && i < productsLabel.size(); i++) {
		    WebElement checkBox = productsLabel.get(i);
		    String firstProduct=productsLabel.get(i).getText();
		    System.out.println(firstProduct);
		    HelperFunctions.staticWait(2);
			 productDropdown.click();
		    if(firstSearchResult.getText().equals(firstProduct)) {
		    	 Assert.assertTrue(true);
			 }else {
				 String errorMessage = "Verification failed";
			        logger.error(errorMessage);
			 }
		}
	 HelperFunctions.staticWait(2);
	
	
}
public void setTwoFilteronGlobalSearchResult() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	searchButton.click();
	HelperFunctions.staticWait(3);
	
    searchInput.sendKeys("products");
    searchInput.sendKeys(Keys.ENTER);
    if(productDropdown.isDisplayed() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	 String successMessage = "dropdowns are displayed";
	        logger.info(successMessage);
    	Assert.assertTrue(true);
    }else {
    	 String errorMessage = "dropdowns are not displayed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
    
    }
}
public void setAllProductsButtonVisibility() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
    if(allProductsButton.isDisplayed()) {
    	 String successMessage = "All Products button is displayed";
	        logger.info(successMessage);
    	Assert.assertTrue(true);
    }else {
    	 String errorMessage = "All Products button is not displayed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
    
    }
}
public void setAllProductsButtonFunctionality() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
    if(allProductsButton.getAttribute("href")!=null && allProductsButton.getAttribute("href").endsWith("products.html")) {
    	 String successMessage = "This component contains a link/button for my product page";
	        logger.info(successMessage);
    	Assert.assertTrue(true);
    }else {
    	 String errorMessage = "This component does not contain a link/button for my product page";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
    
    }
}
public void setFooterSystemAuthored() throws Exception {
	//HelperFunctions.waitForPageToLoad(3);
	Driver.getDriver().switchTo().frame(0);
	HelperFunctions.staticWait(2);
	    HelperFunctions.scrollToElement(footerHome); 
	HelperFunctions.staticWait(2); 
	if(footerHome.isEnabled()) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "The footer is editable";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
	HelperFunctions.staticWait(2);
	 
   
}
public void setFooterYear() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
	HelperFunctions.scrollToElement(footerHome); 
	HelperFunctions.staticWait(2); 
	String footerText=footerHome.getText();
	System.out.println(footerText);
	String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	System.out.println(currentYear);
	Assert.assertTrue(footerText.startsWith("© " + currentYear));
   
}
public void setTilesNumber2() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
	if (titleOfTiles.size() <= 15) {
	    Set<String> titles = new HashSet<>();
	    for (WebElement element : titleOfTiles) {
	        String title = element.getText();
	        if (!titles.contains(title)) {
	            titles.add(title);
	        } else {
	        	Assert.assertTrue(false);
	            System.out.println("Duplicate title found: " + title);
	        }
	    }
	} else {
	    System.out.println("List size is greater than 15.");
	}
   
}

public void setDisplayedTwoDropdown() throws Exception {
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
	searchButton.click();
	HelperFunctions.staticWait(3);	
    searchInput.sendKeys("products");
    searchInput.sendKeys(Keys.ENTER);
    HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.staticWait(2);
	if(productDropdown.isDisplayed() && catDropdown.isDisplayed() ) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	HelperFunctions.staticWait(2);
   
}
public void setFooterElementLinks() throws Exception {
	HelperFunctions.waitForPageToLoad(30);
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(footerHome);
	HelperFunctions.staticWait(3);
	
	boolean found = footerElementsLink.stream()
		    .map(element -> element.getAttribute("href"))
		    .anyMatch(attr -> attr != null && attr.startsWith("https://www.pwc"));
		Assert.assertTrue(found);


		HelperFunctions.staticWait(3);
	
}

public void setOpenHomePagePwcLogo() throws Exception {
	
	HelperFunctions.waitForPageToLoad(10);
	HelperFunctions.staticWait(3);
	
    pwcLogo2.click();
    HelperFunctions.staticWait(2);
    String currentUrl=Driver.getDriver().getCurrentUrl();
    if(currentUrl.contains("/us/en/homepage.html")) {
        Assert.assertTrue(true);
    }else {
         String errorMessage = "When clicking pwc logo pc homepage is not loaded ";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
    }
 
    HelperFunctions.staticWait(3);
}
public void setSearchResultNumber() {
	   HelperFunctions.waitForPageToLoad(3);
	searchButton.click();
	HelperFunctions.staticWait(3);
	
 searchInput.sendKeys("products");
 HelperFunctions.staticWait(2);
 searchInput.sendKeys(Keys.ENTER);
 WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 15);
 wait3.until(ExpectedConditions.visibilityOf(productDropdown));
 String total1=totalCount.getText();
 productDropdown.click();
 WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
 wait4.until(ExpectedConditions.visibilityOf(productCheckbox.get(0)));
 productCheckbox.get(0).click();
 HelperFunctions.staticWait(3);
 productDropdown.click();
 HelperFunctions.staticWait(5);
 String total2=totalCount.getText();
 Assert.assertNotEquals(total1, total2);
 HelperFunctions.staticWait(3);


}
public void setSearchResultforVideo() {
	   HelperFunctions.waitForPageToLoad(60);
	   WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 15);
	   wait3.until(ExpectedConditions.visibilityOf(searchButton));
	searchButton.click();
	HelperFunctions.staticWait(3);
	
searchInput.sendKeys("1_6zzb6i5o");
HelperFunctions.staticWait(2);
searchInput.sendKeys(Keys.ENTER);
HelperFunctions.waitForPageToLoad(60);
Assert.assertTrue(videoPlayers.size()==0);
HelperFunctions.staticWait(3);
firstSearchResult.click();
HelperFunctions.waitForPageToLoad(60);
wait3.until(ExpectedConditions.visibilityOf(videoPlayers.get(0)));
HelperFunctions.staticWait(3);
}

	
	
	
	
	
	
	
	
}
