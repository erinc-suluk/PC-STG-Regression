package Pages;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;



public class ProductListingPage extends HelperFunctions {
	public ProductListingPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	
	
	@FindBy(xpath="//div[@class='cmp-related-links__items']//div//a")
	private static List<WebElement> allLinks;
	
	@FindBy(xpath="//div[@class='cmp-related-links']")
	private static List<WebElement> allLinks2;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewFromCloud;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/terms---conditions.html']")
	private WebElement termsAndConditionsLink;
	
	@FindBy(xpath="(//span[.='PricewaterhouseCoopers2'])[1]")
	private WebElement termsAndConditionsTitle;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/maintenance---support.html']")
	private WebElement maintenanceAndSupportLink;
	
	@FindBy(xpath="(//span[.='sample (5)'])[1]")
	private WebElement headerForMaintenanceAndSupport;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[1]")
	private WebElement offeringOverviewLinkTitle;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/documentation.html']")
	private WebElement documentationLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//div[@class='HUDView__hudContainer___3mx_O HUDView__immersiveShow___1pWVE']")
	private WebElement offeringPdfIcon;
	
	@FindBy(xpath="//nav[@id='skinny-rail']")
	private WebElement pdfIcon;
	
	@FindBy(linkText="Back to Cloud")
	private WebElement backToCloudBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement cloudTitle;
	
	@FindBy(linkText="Back to Products")
	private WebElement backToProductsBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-product-list__search-bar-title']")
	private WebElement productsTitle;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProduct;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement searchItem;
	
	@FindBy(xpath="//span[@class='cmp-product-list__card-title ']")
	private WebElement products;
	
	@FindBy(xpath="//a[@data-product-name='Strategic']")
	private WebElement strategicProduct;
	
	@FindBy(xpath="//a[@data-product-name='Cloud']")
	private WebElement cloudProduct;
	
	@FindBy(xpath="//a[@data-product-name='Risk']")
	private WebElement riskProduct;
	
	@FindBy(xpath="//input[@placeholder='Search Products']")
	private WebElement productSearchBar;
	
	@FindBy(xpath="//div[@class='has-no-results']")
	private WebElement noResult;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span[2]")
	private static List<WebElement> titleofTiles;
	
	@FindBy(xpath="//h1[contains(@class, 'title')]")
	private WebElement contentTitle;
	
	@FindBy(xpath="//div[@id='pdfviewer-cc9adec430-content']")
	private WebElement termsConditionContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb6948d1d-content']")
	private WebElement offeringOverviewContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb8297d06-content']")
	private WebElement documentationContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-033ffa1470-content']")
	private WebElement maintenanceContent;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span")
	private static List<WebElement> cardTitle;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productLinks;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-alphabet-section']//div//a[2]")
	private WebElement productBasedonSearch;
	
	@FindBy(xpath="//div[@class='cmp-related-links__download']//span[@class='cmp-related-links__download-text'][normalize-space()='Download Full Terms']")
	private WebElement downloadLink;
	
	@FindBy(xpath="//a[contains(text(),'Documentation')]")
	private WebElement documentationLink2;
	
	@FindBy(xpath="//a[contains(text(),'Privacy and Security')]")
	private WebElement privacyandSecurityLink;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-info-container']//div[1]")
	private static List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-info-container']//div[2]")
	private static List<WebElement> productDescriptions;
	
	@FindBy(xpath="//div[@id='productDropdown']")
	private WebElement portfolioDropdown;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div")
	private static List<WebElement> productList;
	
	@FindBy(xpath="//a[@class='cmp-product-list__card-link']")
	private static List<WebElement> productListElements;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-title']")
	private static List<WebElement> titleofElements;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-desc']")
	private static List<WebElement> descriptionofElements;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-image-container']//img")
	private static List<WebElement> thumbnailofElements;
	
	@FindBy(xpath="(//div[@class='cmp-document-tiles__entry-info-container'])[1]")
	private WebElement firstTile;
	
	@FindBy(xpath="//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private static WebElement closeButtonforCookies;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-img']//img")
	private static List<WebElement> thumbnails;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-alphabet-container']//div[2]//a")
	private static List<WebElement> allProducts;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-image-container']//img")
	private static List<WebElement> thumbnails2;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__pdf-info']")
	private static WebElement dateInfo;
	
	@FindBy(xpath="//div[@class='cmp-pdf-highlights__content']")
	private static WebElement contentElements;
	
	@FindBy(xpath="//span[@class='cmp-product-list__card-title ']")
	private static List<WebElement> productsTitle2;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private WebElement breadcrumb;
	
	@FindBy(xpath="//a[@class='cmp-product-list__card-link']")
	private WebElement productListElement;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//span[contains(@class,'cmp-product-list__card-title')][normalize-space()='Cloud']")
	private WebElement cloudTiles;
	
	@FindBy(xpath="//div[@class='cmp-related-links__link']//a")
	private static List<WebElement> allLinks3;
	
	
	
	static Logger logger=Logger.getLogger("ProductListingPage");
	
	
	
	
	



   

    public void setAllLinks() throws IOException { 
    	HelperFunctions.waitForPageToLoad(5);
    	  for (WebElement link : allLinks) { 
            
              String href = link.getAttribute("href");

          
              if (!href.isEmpty()) {
            
                  System.out.println(href);
                  Assert.assertTrue(true);
              }else {
            	  Assert.assertTrue(false);
              }
          }
    	
    }


	
    
    public void setLinks() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfViewer);
    	    } catch (StaleElementReferenceException e) { 
    	       
    	    }
    	}
    }
    
    public void setPdfControllers() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfIcon);
    	    } catch (StaleElementReferenceException e) {
    	       
    	    }
    	}
    	
    
    }

	

	public void setBreadcrumbs() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		breadcrumbLinks.get(0).click();
		String currentUrl = Driver.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("/products/cloud.html"));
		/* for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			// Assert.assertEquals(hrefValue, currentUrl);
			  if (!hrefValue.equals(currentUrl)) {
				  String errorMessage = "The promotion banner does not match with the expected text.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			  }else {
				  String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
			  }
	            }*/
    
         
			 
	
	
	}
	public void setBreadcrumbsVisibility() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		Assert.assertTrue(breadcrumbLinks.get(0).isDisplayed());
		breadcrumbLinks.get(0).click();
		String currentUrl = Driver.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("/products/cloud.html"));
		/* for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			// Assert.assertEquals(hrefValue, currentUrl);
			  if (!hrefValue.equals(currentUrl)&& link.isDisplayed()) {
				  String errorMessage = "The promotion banner does not match with the expected text.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			  }else {
				  String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
			  }
	            }*/
    
         
			 
	
	
	}
	public void setLinkOfBreadcrumbs() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
    
		for (WebElement link : breadcrumbLinks) {
			if(link.getAttribute("href")!=null) {
				 String successMessage = "Breadcrumb contains a link.";
			        logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				 String errorMessage = "Breadcrumb does not contain a link.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			//	Assert.assertTrue(false);
			}
		}

		
	}
	
	public void setSearchBox() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		String str="Customer Link";
		searchProduct.sendKeys(str);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.click();
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		String str2="Digital on Demand";
		searchProduct.sendKeys(str2);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str2)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching."; 
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	public void setSearchResult() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		String str="Cus";
		String str2="Customer Link";
		searchProduct.sendKeys(str);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str2)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.click();
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		String str3="Dig";
		String str4="Digital on Demand";
		searchProduct.sendKeys(str3);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str4)) {
			String successMessage = "Texts are matching";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			//Assert.assertTrue(false);
		}

			
		
	}
	
	public void setSearchBarKeywordforNegativeTest() {
		HelperFunctions.waitForPageToLoad(5);
		productSearchBar.click();
		Faker faker=new Faker();
		productSearchBar.sendKeys(faker.name().firstName());
		if(noResult.isDisplayed() && noResult.getText().contains("Nothing matches your results")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		HelperFunctions.staticWait(3);
	}
	
	public void setDocumentTileLine() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachProductTitle: titleofTiles) {
			System.out.println(eachProductTitle.getCssValue("-webkit-line-clamp"));
			if(eachProductTitle.getCssValue("-webkit-line-clamp").equals("2")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
		HelperFunctions.staticWait(3);
	}
	public void setContentPageSameTab() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement each:productLinks) {
			each.click();
			break;
		}
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : productLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
		 HelperFunctions.staticWait(3);
	}
	
	
	public void setDownloadFullTermsLink() {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", downloadLink);
		 HelperFunctions.staticWait(3);
		 String directoryPath = "C:\\Users\\GLBL_RDP_USER_02\\Downloads";
	        File directory = new File(directoryPath);
	        File[] files = directory.listFiles((dir, name) -> name.endsWith(".zip"));

	        if (files != null && files.length > 0) {
	        	Assert.assertTrue(true);
	            System.out.println("At least one .zip file exists in the directory.");
	        } else {
	            System.out.println("No .zip files exist in the directory.");
	        }
	     
	        HelperFunctions.staticWait(3);
		
	}
	
	public void setDocumentationTileChanging(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		test.info("Click on documentation link");
		documentationLink2.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		/*for(WebElement link:allLinks3) {
			System.out.println(link.getText());
			if(link.getText().contains("Privacy and Security")) {
				System.out.println();
				String successMessage = "Related links contain Privacy and Security Link";
		        logger.info(successMessage);
			}else {
				String errorMessage = "Related links do not contain Privacy and Security Link";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}*/
		boolean containsPS=allLinks3.stream().anyMatch(link -> link.getText().contains("Privacy and Security"));
		if(containsPS) {
			Assert.assertTrue(true);
		}
		test.info("Verified the link contains Privacy and Security");
		HelperFunctions.staticWait(3);
		test.info("Click on privacy and Security link");
		JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
	    executor13.executeScript("arguments[0].click();", privacyandSecurityLink);
	    test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		 String title = Driver.getDriver().getTitle();
		 if(title.contains("Privacy & Security")) {
			 String successMessage = "Privacy & Security Page is verified";
		        logger.info(successMessage);
			Assert.assertTrue(true); 
		 }else {
			 String errorMessage = "Privacy & Security is not verified";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		 }
		 test.info("Verified Privacy & Security Page is verified");
		 HelperFunctions.staticWait(2);
	}
	
	
    
	public void setProductDescription(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		test.info("Store titles and descriptions in a list");
		List<String> titles = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();

		for (WebElement titleElement : productTitles) {
		    titles.add(titleElement.getText());
		}
		for (WebElement descElement : productDescriptions) {
		    descriptions.add(descElement.getText());
		}
		test.info("Compare if Title and description match for element");
		for (int i = 0; i < titles.size(); i++) {
		    String title = titles.get(i);
		    String desc = descriptions.get(i);
		    String titlePrefix = title.substring(0, 4).toLowerCase();
		    if (desc.toLowerCase().contains(titlePrefix)) {
		    	 String successMessage = "Title and description match for element";
			        logger.info(successMessage);
		    } else {
		    	 String errorMessage = "Title and description do not match for element"+i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		       
		    }
		}
		test.info("Verified Title and description match for element");
		HelperFunctions.staticWait(3); 
	
	
	}
	
	public void setProductTitleandDescriptionVisibility(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(5);
		test.info("Store titles and descriptions in a list");
		List<String> titles = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();

		for (WebElement titleElement : productTitles) {
		    if (titleElement.isDisplayed()) {
		        titles.add(titleElement.getText());
		    }else {
		    	 String errorMessage = "Titles are not visible";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		    }
		}
		test.info("Verified Titles are visible");
		for (WebElement descElement : productDescriptions) {
		    if (descElement.isDisplayed()) {
		        descriptions.add(descElement.getText());
		    }else {
		    	 String errorMessage = "Descriptions are not visible";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		    }
		}
		test.info("Verified Descriptions are visible");
         
		HelperFunctions.staticWait(3);
	
	
	}
	
	public void setContentPageTags() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		for (WebElement link : allLinks) {
		    String linkText = link.getText();
		    String linkUrl = link.getAttribute("href");
		    link.click();
		    HelperFunctions.staticWait(2);
		    String pageTitle = Driver.getDriver().getTitle();
		    System.out.println(pageTitle);
		    Assert.assertTrue(pageTitle.toLowerCase().contains(linkText.substring(0, 4).toLowerCase()));
		    break;
		}
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		WebElement linkToClick = allLinks.get(1);
		String linkText = linkToClick.getText();
		String linkUrl = linkToClick.getAttribute("href");

		linkToClick.click();
		HelperFunctions.staticWait(2);
		String pageTitle = Driver.getDriver().getTitle();
		Assert.assertTrue(pageTitle.toLowerCase().contains(linkText.substring(0, 4).toLowerCase()));
		HelperFunctions.staticWait(3);
	}
	public void setPortfolioDropdown() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		if(portfolioDropdown.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			String errorMessage = "Portfolio dropdown is not displayed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
		}
		HelperFunctions.staticWait(3);
		
	}
	public void setPortfolioDropdownHoverOver() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		if(portfolioDropdown.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			String errorMessage = "Portfolio dropdown is not displayed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
		}
		HelperFunctions.staticWait(2);
		portfolioDropdown.click();
		for(WebElement each:productList) {
			if(each.isDisplayed()) {
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Products are not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}
		HelperFunctions.staticWait(3);
	}
	
	public void setTitleDescriptionThumbnail() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		productListElements.get(1).click();
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachTitle:titleofElements) {
			if(eachTitle.getText()!=null) {
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Title equals null value";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}
		HelperFunctions.staticWait(2);
		for(WebElement eachDesc:descriptionofElements) {
			if(eachDesc.getText()!=null) {
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Description equals null value";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}
		HelperFunctions.staticWait(2);
		for(WebElement eachThumb:thumbnailofElements) {
			if(eachThumb.getAttribute("src")!=null) {
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Thumbnail equals null value";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}
		HelperFunctions.staticWait(2);
	}
	
	public void setZeroTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		Assert.assertTrue(productListElements.size()>0);
		HelperFunctions.staticWait(3);
	}
	
	public void setLightUpThumbnail() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		
		/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
				
				closeButtonforCookies.click();
			    System.out.println("Close cookies.");
			} else {
			    System.out.println("Cookies already closed.");
			}*/
		  Actions actions = new Actions(Driver.getDriver());
		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < thumbnails.size(); i++) {
			 if (!thumbnails.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", productListElements.get(i));
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
	            } else {
	                System.out.println("Thumbnail " + i + " does not change opacity when hovered over");
	            }
	        }
	        
		 HelperFunctions.staticWait(2);
		
	}
	
	
	
	public void setDescriptionOfTiles() {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		
		/* if (closeButtonforCookies.isDisplayed() && closeButtonforCookies.isEnabled()) {
				
				closeButtonforCookies.click();
			    System.out.println("Close cookies.");
			} else {
			    System.out.println("Cookies already closed.");
			}*/
		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < productListElements.size(); i++) {
			 if (!productListElements.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", productListElements.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 productListElements.get(i).click();
			 for(WebElement eachDescription: descriptionofElements) {
					System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
					if(eachDescription.getCssValue("-webkit-line-clamp").equals("3")) {
						Assert.assertTrue(true);
					}else {
						Assert.assertTrue(false);
						
					}
				}
	            Driver.getDriver().navigate().back();
	        }
		 HelperFunctions.staticWait(2);
		
		
	
	}
	public void setMatchingTitleAndDescription() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		productListElements.get(1).click();
		HelperFunctions.waitForPageToLoad(5);
		List<String> titles = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();

		for (WebElement titleElement : titleofElements) {
		    titles.add(titleElement.getText());
		}
		for (WebElement descElement : descriptionofElements) {
		    descriptions.add(descElement.getText());
		}
		for (int i = 0; i < titles.size(); i++) {
		    String title = titles.get(i);
		    String desc = descriptions.get(i);
		    String titlePrefix = title.substring(0, 4).toLowerCase();
		    if (desc.toLowerCase().contains(titlePrefix)) {
		    	 String successMessage = "Title and description match for element";
			        logger.info(successMessage);
		    } else {
		    	 String errorMessage = "Title and description do not match for element"+i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		       
		    }
		}
		HelperFunctions.staticWait(3);
			 
	
	
	}
	public void setTitleDescriptionThumbnail2() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(1).click();
		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < titleofElements.size(); i++) {
			 if (!titleofElements.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", titleofElements.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			 if (!titleofElements.get(i).getText().isEmpty()) {
				 Assert.assertTrue(true);
			        System.out.println("Title is displayed for tile " + i);
			 
			    } else {
			    	Assert.assertTrue(false);
			        System.out.println("ERROR: Title is not displayed for tile " + i);
			 
			    }
		 }
		

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < descriptionofElements.size(); i++) {
			 if (!descriptionofElements.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", descriptionofElements.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			 if (!descriptionofElements.get(i).getText().isEmpty()) {
				 Assert.assertTrue(true);
			        System.out.println("Description is displayed for tile " + i);
			 
			    } else {
			    	Assert.assertTrue(false);
			        System.out.println("ERROR: Description is not displayed for tile " + i);
			 
			    }
		 }
		 for (int i = 0; i < thumbnails2.size(); i++) {
			 if (!thumbnails2.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", thumbnails2.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			  String src = thumbnails2.get(i).getAttribute("src");
			    if (src == null || src.isEmpty()) {

			        String errorMessage = "ERROR: src attribute is null or empty for thumbnail " + i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			    }
		 }
		 HelperFunctions.staticWait(3);
	}
	
	public void setThumbnails() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(1).click();
		 HelperFunctions.staticWait(2);
		
		 for (int i = 0; i < thumbnails2.size(); i++) {
			 if (!thumbnails2.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", thumbnails2.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			  String src = thumbnails2.get(i).getAttribute("src");
			    if (src == null || src.isEmpty()) {

			        String errorMessage = "ERROR: src attribute is null or empty for thumbnail " + i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			    }
		 }
		 HelperFunctions.staticWait(3);
		
	}
	public void setDateFormat() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		titleofElements.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		 String dateString = dateInfo.getText().split(" ")[2];
	    
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Date date = dateFormat.parse(dateString);
	            Assert.assertEquals(dateString, dateFormat.format(date));
	            System.out.println("Date format is valid: " + dateString);
	        } catch (ParseException e) {
	            System.out.println("Date format is invalid: " + dateString);
	        }
	        
		
	}
	public void setRelatedLinkSize() {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		titleofElements.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		 int width = Driver.getDriver().manage().window().getSize().getWidth();
		 Dimension size = new Dimension(1200, Driver.getDriver().manage().window().getSize().height);
		    Driver.getDriver().manage().window().setSize(size);
		  
		    if (width < 1300) {
		      WebElement dropdown = Driver.getDriver().findElement(By.xpath("//div[@class='ap-dropdown-select']"));
		      if (dropdown.isDisplayed()) {
			      System.out.println("The Related links components have been converted to a drop-down menu.");
			    } else {
			      System.out.println("The Related links components have not been converted to a drop-down menu.");
			    }
		    }

		    HelperFunctions.staticWait(3);

		
		
	}
	public void setNavigateContentPage() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		titleofElements.get(0).click();
		HelperFunctions.waitForPageToLoad(5);
		Assert.assertTrue(contentElements.isDisplayed());
		HelperFunctions.staticWait(3);
		
	}
	
	public void setDisplayTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		Assert.assertTrue(allProducts.size() > 0, "The list of elements is not displayed.");

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		int lastElementIndex = allProducts.size() - 1;
		WebElement lastElement = allProducts.get(lastElementIndex);
		js.executeScript("arguments[0].scrollIntoView(true);", lastElement);

		for (WebElement element : allProducts) {
		    Assert.assertTrue(element.isDisplayed(), "Element is not displayed: " + element.getText());
		}
		HelperFunctions.staticWait(3);
	}
	
	public void setFixedOrder() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		List<String> textValues = new ArrayList<String>();
		for (WebElement element : productsTitle2) {
		    textValues.add(element.getText());
		}

		List<String> sortedTextValues = new ArrayList<String>(textValues);
		Collections.sort(sortedTextValues, String.CASE_INSENSITIVE_ORDER);

		if (!textValues.stream().map(String::toLowerCase).collect(Collectors.toList())
		        .equals(sortedTextValues.stream().map(String::toLowerCase).collect(Collectors.toList()))) {
		    String errorMessage = "The list of element text values is not in alphabetical order.\n";
		    for (int i = 0; i < textValues.size(); i++) {
		        if (!textValues.get(i).equalsIgnoreCase(sortedTextValues.get(i))) {
		            errorMessage += "Element at index " + i + " is out of order: " + textValues.get(i) + " should come before " + sortedTextValues.get(i) + ".\n";
		        }
		    }
		    fail(errorMessage);
		}
		HelperFunctions.staticWait(3);
	}
	public void setBreadcrumbsHierarchy() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		allProducts.get(0).click();
        HelperFunctions.waitForPageToLoad(3);
        titleofElements.get(0).click();
        HelperFunctions.waitForPageToLoad(3);
        HelperFunctions.staticWait(1);
        if(contentTitle.isDisplayed()) {
        	 Assert.assertTrue(true);
        }else {
        	String errorMessage = "Content page did not open";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
        }
        HelperFunctions.staticWait(1);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(3);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(3);
        Assert.assertTrue(allProducts.get(0).isDisplayed());
        HelperFunctions.staticWait(3);
	}
	public void setAutoSuggestion() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(searchProduct));
		searchProduct.click();
		String str="Change Navigator";
		searchProduct.sendKeys(str);
		wait.until(ExpectedConditions.visibilityOf(searchItem));
		//System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(searchItem.getText().contains(str)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
	
		}
		HelperFunctions.staticWait(3);
		
	}
	public void setRelevantProduct() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(searchProduct));
		searchProduct.click();
		String str="Change Navigator";
		searchProduct.sendKeys(str);
		wait.until(ExpectedConditions.visibilityOf(searchItem));
		searchItem.click();
		wait.until(ExpectedConditions.visibilityOf(productListElement));
		//System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(productListElement.getAttribute("data-product-name").equals(str)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
	
		}
		HelperFunctions.staticWait(3);
		
	}
	public void setDescriptionOfTiles2() {
		HelperFunctions.waitForPageToLoad(5);
	
		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < descriptionOfTiles.size(); i++) {
			 if (!descriptionOfTiles.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", descriptionOfTiles.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 for(WebElement eachDescription: descriptionOfTiles) {
					System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
					if(eachDescription.getCssValue("-webkit-line-clamp").equals("3")) {
						Assert.assertTrue(true);
					}else {
						Assert.assertTrue(false);
						
					}
				}
	          
	        }
		 HelperFunctions.staticWait(2);
		
		
	
	}
	public void setProductsTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		Assert.assertTrue(productsTitle.isDisplayed());
		HelperFunctions.staticWait(3);
		
		
	}
	public void setLinksTags() {
		HelperFunctions.waitForPageToLoad(5);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(allLinks.get(0)));
		WebElement link = allLinks.get(0); 
		String linkText = link.getText().substring(0,4); 
		link.click();
		wait.until(ExpectedConditions.visibilityOf(contentTitle));
		Assert.assertTrue(contentTitle.getText().contains(linkText));
		HelperFunctions.staticWait(3);
	}
	public void setDownloadFullTermsLinkName() {
		 HelperFunctions.waitForPageToLoad(5);
		    HelperFunctions.staticWait(3);
		    downloadLink.click();
		    HelperFunctions.staticWait(3);

		    String expectedFileName = "Change-Navigator-Full-Terms";
		  //  String expectedDate = "3-2-2023";
		    String downloadsFolder = System.getProperty("user.home") + "/Downloads/";
		    File[] downloadedFiles = new File(downloadsFolder).listFiles();
		    boolean isFileDownloaded = false;
		    for (File file : downloadedFiles) {
		        if (file.getName().contains(expectedFileName)) {
		            isFileDownloaded = true;
		            String actualDate = new SimpleDateFormat("M-d-yyyy").format(new Date(file.lastModified()));
		          //  Assert.assertEquals(expectedDate, actualDate);
		            break;
		        }
		    }
		    Assert.assertTrue(isFileDownloaded);
		    HelperFunctions.staticWait(3);
		
	}
	public void setSearchableContentPage() {
		//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/products.html");
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		String str="Cloud";
	    searchProduct.sendKeys(str);
		HelperFunctions.staticWait(2);
		searchItem.click();
		HelperFunctions.staticWait(2);
		Assert.assertTrue(cloudTiles.isDisplayed());
		HelperFunctions.staticWait(2);
		
		
	}
	
	public void setMultipleDownload() {
		 HelperFunctions.waitForPageToLoad(5);
		    HelperFunctions.staticWait(3);
		    downloadLink.click();
		    HelperFunctions.staticWait(3);

		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		    String timestamp = dateFormat.format(new Date());
		    String fileName = "Bookkeeping-Connect-Full-Terms-" + timestamp + ".zip";

		    String downloadPath = "C:\\Users\\erong\\Downloads\\";
		    File file = new File(downloadPath + fileName);

		    int attempts = 0;
		    while (!file.exists() && attempts < 5) {
		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        attempts++;
		    }

		    Assert.assertTrue(file.exists());
		    HelperFunctions.staticWait(3);
		
	}
	public void setRemoveDownload() {
		 HelperFunctions.waitForPageToLoad(30);
		    HelperFunctions.staticWait(3);
		    for (WebElement link : allLinks3) {
		        if (!link.getText().contains("Download")) {
		        	Assert.assertTrue(true);
		            System.out.println("The link does not contain 'Download': " + link.getAttribute("href"));
		        }
		    }
		    HelperFunctions.staticWait(3);
		
	}
	
	public void setBreadcrumbsHierarchyTablet() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(2);
		allProducts.get(1).click();
        HelperFunctions.waitForPageToLoad(30);
        titleofElements.get(0).click();
        HelperFunctions.waitForPageToLoad(30);
        HelperFunctions.staticWait(1);
        int width = Driver.getDriver().manage().window().getSize().getWidth();
		 Dimension size = new Dimension(1200, Driver.getDriver().manage().window().getSize().height);
		    Driver.getDriver().manage().window().setSize(size);
		    HelperFunctions.staticWait(2);
        if(contentTitle.isDisplayed()) {
        	 Assert.assertTrue(true);
        }else {
        	String errorMessage = "Content page did not open";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
        }
        HelperFunctions.staticWait(1);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(30);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(30);
        Assert.assertTrue(allProducts.get(0).isDisplayed());
        HelperFunctions.staticWait(3);
	}
	
	
	
   
	
   
        
	
		
		
	     
     
	    
	      
	
	
	

}
