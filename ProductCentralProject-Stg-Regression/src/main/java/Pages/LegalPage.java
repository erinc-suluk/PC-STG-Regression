package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class LegalPage extends HelperFunctions {
	public LegalPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/maintenance---support.html']")
	private WebElement maintenanceAndSupportLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/data-processing-addendum.html']")
	private WebElement dataProcessingLink;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/offering-overview.html']")
	private WebElement changeNavigatorLink;
	
	@FindBy(xpath="//a[@href='/us/en/products/customer-link/maintenance---support.html']")
	private WebElement customerLink;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement maintenanceAndSupportTitle;
	
	@FindBy(xpath="//a[@href='https://productcentral-qa.products.pwc.com/us/en/automation/legal/maintenance---support.html']")
	private WebElement maintenanceAndSupportBreadcrumb;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement ContentTitle;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']//a")
	private static List<WebElement> tilesComponents;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal.html']")
	private WebElement backtoLegalBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> legalTiles;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']")
	private static List<WebElement> legalTilesOffering;
	
	@FindBy(xpath="//span[@class='cmp-breadcrumb__link-title']")
	private WebElement offeringOverviewBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//a[@id='referrer-module']")
	private WebElement backtoLegalBreadcrumbfromContent;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-title']")
	private static List<WebElement> legalTilesTitle;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement contentTitle;
	
	@FindBy(xpath="(//div[@class='cmp-document-tiles'])[2]//a")
	private static List<WebElement> specificTermsItems;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']//span")
	private static List<WebElement> specificTermsItemsTiles;
	
	@FindBy(xpath="(//div[@class='cmp-document-tiles'])[2]")
	private WebElement specificTerms;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']//a[1]")
	private WebElement firstSpecificTermsItem;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']//a//div[2]/img")
	private static List<WebElement> thumbnails;
	
	@FindBy(xpath="//div[@id='sortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//span[1]")
	private static List<WebElement> sortOptions;
	
	
	ReadXLSdata read1=new ReadXLSdata();
	static Logger logger=Logger.getLogger("LegalPage");
	
	public void setlegalTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : legalTiles) {
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
	            }
	}
	public void setDescriptionOfTiles() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachDescription: descriptionOfTiles) {
			System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
			if(eachDescription.getCssValue("-webkit-line-clamp").equals("3")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
	}
	
	public void setContentPageTags() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachTiles: tilesComponents) {
			 try {
				 String hrefValue = eachTiles.getAttribute("href");
				 eachTiles.click();
				 HelperFunctions.staticWait(3);
				 String currentUrl = Driver.getDriver().getCurrentUrl();
				 Assert.assertEquals(hrefValue, currentUrl);
				 Driver.getDriver().navigate().back();
	    	    } catch (StaleElementReferenceException e) {
	    	       
	    	    }
		}
			
	}
	public void setDisplayTilePerDocumentCat() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		//read1.setExcelFile("./testdata.xlsx", "QA");
		 FileInputStream file = new FileInputStream("C:\\Users\\erong\\git\\ProductCentralProject-Automation1\\testdata.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(file);
         XSSFSheet sheet = workbook.getSheetAt(1); 
         
         int columnIndex3 = 0;
         HashSet<String> cellValues3 = new HashSet<String>();
         for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
             XSSFRow row = sheet.getRow(rowNum);
             if(row == null) continue;
             XSSFCell cell = row.getCell(columnIndex3);
             if(cell == null) continue;
             cellValues3.add(cell.getStringCellValue());
         }
         for (WebElement element3 : legalTilesTitle) {
             if(element3.isDisplayed() && element3.isEnabled()){
                 String elementText3 = element3.getText();
                 if(elementText3!=null && !elementText3.isEmpty()){
                     Assert.assertTrue(cellValues3.contains(elementText3), "element text: " + elementText3 + " not found in the column: " + columnIndex3);
                 }else{
                     System.out.println("Element text is empty or null, skipping the element");
                 }
             }else{
                 System.out.println("Element is not interactable or not visible, skipping the element");
             }
         }
	
	}
	
	public void setBreadcrumb() {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : breadcrumbLinks) {
			 Assert.assertTrue(link.isDisplayed());
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
	}
	public void setProductsNamePresent() {
		HelperFunctions.waitForPageToLoad(5);
		   JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
		    js2.executeScript("window.scrollBy(0,200)", "");
		    HelperFunctions.staticWait(2);
		 for (WebElement title : legalTilesTitle) {
			 if(title.isDisplayed()) {
				 Assert.assertTrue(true);
			 }else {
				 String errorMessage = "Product names is not present on the page";
			        logger.error(errorMessage);
			 }
	            }
		
	}
	public void setNavigateAssetPage() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < 3; i++) {
			 if (!tilesComponents.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", tilesComponents.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 tilesComponents.get(i).click();
	            if (contentTitle.isDisplayed()) {
	                System.out.println("Tile displayed for element " + i);
	            } else {
	                System.out.println("Tile not displayed for element " + i);
	            }
	          
	            Driver.getDriver().navigate().back();
	        }
		HelperFunctions.waitForPageToLoad(5);
		
	}
	
	public void setTitleandDescription() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < legalTilesTitle.size(); i++) {
			 if (!legalTilesTitle.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", legalTilesTitle.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			 String titleText = legalTilesTitle.get(i).getText();
			   if (titleText != null && !titleText.isEmpty()) {
				   Assert.assertTrue(true);
			      System.out.println("Title " + i + " is displayed: " + titleText);
			   } else {
			      System.out.println("Title " + i + " is not displayed.");
			   }
			}
		 HelperFunctions.staticWait(2);

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
		
			 String titleText = descriptionOfTiles.get(i).getText();
			   if (titleText != null && !titleText.isEmpty()) {
				   Assert.assertTrue(true);
			      System.out.println("Description " + i + " is displayed: " + titleText);
			   } else {
			      System.out.println("Description" + i + " is not displayed.");
			   }
			}
		
	}
	public void setSelectTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < 3; i++) {
			 if (!legalTilesTitle.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", legalTilesTitle.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 String expectedTitle = legalTilesTitle.get(i).getText();
			 legalTilesTitle.get(i).click();
			   String actualTitle = contentTitle.getText();
			   if (expectedTitle.equals(actualTitle)) {
				   Assert.assertTrue(true);
			      System.out.println("Title displayed for element " + i + " matches: " + actualTitle);
			   } else {
			      System.out.println("Title displayed for element " + i + " does not match: " + actualTitle);
			   }
	          
	            Driver.getDriver().navigate().back();
	        }
		HelperFunctions.waitForPageToLoad(5);
		
	}
	
	public void setColorChanging() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.scrollToElement(specificTerms);
		HelperFunctions.staticWait(2);
        specificTermsItems.get(0).click();
        HelperFunctions.waitForPageToLoad(3);
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 5; i++) {
			 if (!specificTermsItemsTiles.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", specificTermsItemsTiles.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			
			 WebElement tile = specificTermsItemsTiles.get(i);
			 String tileColor = tile.getCssValue("color");
			   System.out.println(tileColor);
			   HelperFunctions.staticWait(2);
			   actions.moveToElement(tile).perform();
			   String tileColor2 = tile.getCssValue("color");
			   System.out.println(tileColor2);
			   if(tileColor!=tileColor2 &&tileColor2.equals("rgba(65, 83, 133, 1)")) {
				   Assert.assertTrue(true);
			   }else {
				   String errorMessage = "The product did not turn blue";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			   }
        }
	}
	public void setLegalProductListingPage() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.scrollToElement(specificTerms);
		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < 3; i++) {
			 if (!specificTermsItems.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", specificTermsItems.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 specificTermsItems.get(i).click();
	            if (firstSpecificTermsItem.isDisplayed()) {
	            	 Assert.assertTrue(true);
	                System.out.println("List is displayed for element " + i);
	            } else {
	            	String errorMessage = "List is not displayed";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
	            }
	          
	            Driver.getDriver().navigate().back();
	        }
		HelperFunctions.waitForPageToLoad(5);
		
	}
	public void setThumbnails() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
	

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < thumbnails.size(); i++) {
			 if (!thumbnails.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", thumbnails.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			  String src = thumbnails.get(i).getAttribute("src");
			    if (src == null || src.isEmpty()) {

			        String errorMessage = "ERROR: src attribute is null or empty for thumbnail " + i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			    }
		 }
		
	}
	public void setLightUpThumbnail() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
	
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
				 Assert.assertTrue(true);
	                System.out.println("Thumbnail " + i + " changes opacity when hovered over");
	            } else {
	            	 String errorMessage = "Thumbnail " + i + " does not change opacity when hovered over";
				        logger.error(errorMessage);
				        throw new Exception(errorMessage);
	            }
	        }
	        
		 HelperFunctions.staticWait(2);
		
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
	public void setTitleDescriptionThumbnail() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < legalTilesTitle.size(); i++) {
			 if (!legalTilesTitle.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", legalTilesTitle.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			 if (!legalTilesTitle.get(i).getText().isEmpty()) {
				 Assert.assertTrue(true);
			        System.out.println("Title is displayed for tile " + i);
			 
			    } else {
			    	Assert.assertTrue(false);
			        System.out.println("ERROR: Title is not displayed for tile " + i);
			 
			    }
		 }
		

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
		
			 if (!descriptionOfTiles.get(i).getText().isEmpty()) {
				 Assert.assertTrue(true);
			        System.out.println("Description is displayed for tile " + i);
			 
			    } else {
			    	Assert.assertTrue(false);
			        System.out.println("ERROR: Description is not displayed for tile " + i);
			 
			    }
		 }
		 for (int i = 0; i < thumbnails.size(); i++) {
			 if (!thumbnails.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", thumbnails.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
		
			  String src = thumbnails.get(i).getAttribute("src");
			    if (src == null || src.isEmpty()) {

			        String errorMessage = "ERROR: src attribute is null or empty for thumbnail " + i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			    }
		 }
		
	}
	public void setFilterOptions() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.scrollToElement(specificTerms);
		HelperFunctions.staticWait(2);
        specificTermsItems.get(0).click();
        HelperFunctions.waitForPageToLoad(3);
	    sortingDropdown.click();
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(sortOptions.get(0).getText().contains("A-Z"));
	    Assert.assertTrue(sortOptions.get(1).getText().contains("Z-A"));
	    Assert.assertTrue(sortOptions.size()==2);
	    
	}
	
	
	
	
	
	

}
