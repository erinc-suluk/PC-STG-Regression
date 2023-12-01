package Pages;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class AuthoringPage extends HelperFunctions {
	public AuthoringPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//*[@id=\"globalnav-start-home-collection\"]/coral-masonry-item[2]/div")
	private WebElement sites;
	
	@FindBy(xpath="(//div[contains(@title, 'productcentral')])[2]")
	private WebElement productcentral;
	
	@FindBy(xpath="//div[@title='us']")
	private WebElement us;
	
	@FindBy(xpath="//div[@title='en']")
	private WebElement en;
	
	@FindBy(xpath="//coral-columnview-item[@data-foundation-collection-item-id='/content/pc/us/en/products']")
	private WebElement Products;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator.thumb.48.48.png?ck=']")
	private WebElement ChangeNavigator;
	
	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-siteadmin-admin-actions-edit-activator foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']")
	private WebElement edit;
	
	@FindBy(xpath="//h1[.='Fluid Forecast']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/title']")
	private WebElement changeProductsTitle;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleEdit;
	
	@FindBy(xpath="//button[@icon='edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/text']")
	private WebElement changeNavigatorDescription;
	
	@FindBy(xpath="//div[@class='cq-RichText-editable coral-RichText-editable coral-RichText coral-DecoratedTextfield-input is-edited webkit chrome']")
	private WebElement navigatorDescriptionEdit;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement actualNavigatorTitle;
	
	@FindBy(xpath="//div[@class='cmp-text']")
	private WebElement actualNavigatorDescription;
	
	@FindBy(xpath="(//coral-columnview-column[@data-foundation-layout-columnview-columnid='/content/pc/us/en'])//coral-columnview-item")
	private static List<WebElement> contentOptions;
	
	@FindBy(xpath="//*[@id=\"coral-id-496\"]/div[1]")
	private WebElement automation;
	@FindBy(xpath="//coral-columnview-item[@data-granite-collection-item-id='/content/pc/us/en/automation/my-products']")
	private WebElement myproduct;
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products/fluid-forecast.thumb.48.48.png?ck=']")
	private WebElement fluidForecast;
	
	@FindBy(xpath="(//div[@class='cmp-for-you__tiles'])/a")
	private static List<WebElement> foryouAssets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//button[@class='granite-collection-create foundation-toggleable-control coral3-Button coral3-Button--primary']")
	private WebElement createButton;
	
	@FindBy(xpath="(//coral-list-item-content[.='Page'])[1]")
	private WebElement pageButton;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/product-listing-page-template-product-central/thumbnail.png']")
	private WebElement productListingPageTemplate;
	
	@FindBy(xpath="//coral-button-label[.='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//coral-tab-label[.='Product Central']")
	private WebElement productCentralTab;
	
	@FindBy(xpath="//select[contains(@name, 'documentCategory')]//option")
	private static List<WebElement> documentCategoryTag;
	
	@FindBy(xpath="//span[@data-rootpath='/content/cq:tags/productcentral/pc-doc-category']//button")
	private WebElement documentCategoryTag2;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[3]")
	private WebElement productFeatureTag2;
	
	@FindBy(xpath="//button[@class='coral-Select-button coral-MinimalButton is-active is-above']")
	private WebElement portfolioTag2;
	
	@FindBy(xpath="//select[@name='./productFeatureTag']//option")
	private static List<WebElement> productFeatureTags;
	
	@FindBy(xpath="//select[@name='./portfolioTag']//option")
	private static List<WebElement> portfolioTags;
	
	@FindBy(xpath="(//button[@role='combobox'])[4]")
	private WebElement portfolioTags2;
	
	@FindBy(xpath="//div[@title='Products']")
	private WebElement products;
	
	@FindBy(xpath="//div[@title='Change Navigator']")
	private WebElement changeNavigatorLink;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=1]")
	private WebElement firstPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=2]")
	private WebElement secondPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=3]")
	private WebElement thirdPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=4]")
	private WebElement forthPositionAuthor;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=1]")
	private WebElement firstTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=2]")
	private WebElement secondTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=3]")
	private WebElement thirdTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=4]")
	private WebElement forthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=5]")
	private WebElement fifthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=6]")
	private WebElement sixthTitle;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/offering-overview.thumb.48.48.png?ck=1665588252']")
	private WebElement offerinfOverviewImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/terms---conditions.thumb.48.48.png?ck=']")
	private WebElement termsAndConditionsImage;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//coral-columnview-column-content[@role='presentation'])[4])//coral-columnview-item//div")
	private static List<WebElement> contentOptions2;
	
	@FindBy(name= "j_username")
	private WebElement username;
	@FindBy(name="j_password")
	private WebElement password;
	@FindBy(id="submit-button")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/sitemapfortesting/jcr:content/root/container/container/sitemap']")
	private WebElement sitemap;
	
	@FindBy(xpath="//button[@icon='wrench']")
	private WebElement settingIcon;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepageDemo;
	
	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-siteadmin-admin-actions-properties-activator foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']//coral-icon[@class='coral3-Icon coral3-Icon--sizeS coral3-Icon--infoCircle']")
	private WebElement properties;
	
	@FindBy(xpath="//coral-checkbox[@name='./hideInSitemap']")
	private WebElement hidesitemapCheckbox;
	
	@FindBy(xpath="//button[@id='shell-propertiespage-doneactivator']")
	private WebElement saveAndClose;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
	private WebElement sitemapImage;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[2]/button/coral-icon")
	private WebElement edit2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton2;
	
	@FindBy(xpath="//*[@id=\"Content\"]/div[1]/coral-actionbar/coral-actionbar-secondary/coral-actionbar-item[1]/button")
	private WebElement editButton2;
	
	@FindBy(xpath="//coral-icon[@class='coral3-Icon coral3-Icon--sizeS coral3-Icon--globe']")
	private WebElement quickPublish;
	
	@FindBy(xpath="/html/body/div[2]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[11]/button/coral-icon")
	private WebElement Publish;
	
	@FindBy(xpath="//div[@class='cmp-sitemap__title']//a//h1")
	private static List<WebElement> sitemapContents;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/legal/jcr:content/root/container/container/legal_content_tiles']")
	private WebElement legalTilesAuth;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']")
	private static List<WebElement> legalTiles;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel/coral-panel-content/div/div/div/div/coral-multifield/coral-multifield-item[1]/coral-multifield-item-content/div/div/foundation-autocomplete/div/div/span")
	private WebElement legalTilesAuthFirstCheckbox;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/data-processing-addendum.thumb.48.48.png']")
	private WebElement dataProcessingImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/maintenance---support.thumb.48.48.png']")
	private WebElement maintenanceImg;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Select']")
	private WebElement selectButton;
	
	@FindBy(xpath="//button[@title='Done']")
	private WebElement checkIcon;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink2;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdf_highlights']")
	private WebElement offeringOverviewLink2auth;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleField;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement contentTitle;
	
	@FindBy(xpath="(//button[@data-layer='Edit'])[2]")
	private WebElement editButtonContent;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement offeringOverviewPdfauth;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement pdfOptions;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/general/content-pdf/PDF%20Template%20for%20AEM%20Testing.pdf.thumb.48.48.png']")
	private WebElement pdfImage;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles']")
	private WebElement homepageTileauth;
	
	@FindBy(xpath="(//h3[@class='coral-Collapsible-header'])[1]")
	private WebElement collapseHeader;
	
	@FindBy(xpath="//input[@name='./tilesList/item0/./title']")
	private WebElement titleofTile;
	
	@FindBy(xpath="//textarea[@name='./tilesList/item0/./description']")
	private WebElement descriptionofTile;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement firstTitleofTile;
	
	@FindBy(xpath="div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel/coral-panel-content/div/div/div/div[1]/foundation-autocomplete/div/div/span/button")
	private WebElement checkforOptions;
	

	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products.thumb.48.48.png']")
	private WebElement myproductImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation.thumb.48.48.png']")
	private WebElement automationImage;
	
	@FindBy(xpath="//button[@trackingelement='edit']")
	private WebElement editnextToPreview;
	
	@FindBy(xpath="//div[@title='Products']")
	private WebElement productsPackage;
	
	@FindBy(xpath="//div[@title='Cloud']")
	private WebElement cloudPackage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=']")
	private WebElement resellerdemoImage;
	
	@FindBy(xpath="//coral-icon[@icon='globeClock']")
	private WebElement managePublication;
	
	@FindBy(xpath="//button[@icon='globeStrike']")
	private WebElement unpublish;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=1667482422000']")
	private WebElement resellerdemoImageforUnpublish;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement unpublishButton;
	
	@FindBy(xpath="//button[@variant='warning']")
	private WebElement continueButton;
	
	@FindBy(xpath="//coral-columnview-preview-content[@role='presentation']")
	private static List<WebElement> publishInformation;
	
	@FindBy(xpath="//div[@title='Reseller Demo']")
	private WebElement resellerDemo;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/check-in.thumb.48.48.png?ck=']")
	private WebElement checkinImg;
	
	@FindBy(xpath="//button[@trackingelement='quick publish']")
	private WebElement quickPublish2;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Publish']")
	private WebElement publish2;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/microsoft-alliance.thumb.48.48.png?ck=']")
	private WebElement microsoftImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/dragos-alliance.thumb.48.48.png?ck=']")
	private WebElement dragosImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepagedemoImg;
	
	@FindBy(xpath="(//time[@role='presentation'])[2]")
	private WebElement publishedDate;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement contentEdit;
	
	@FindBy(xpath="//*[@id=\"coral-id-655\"]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement contentOptions3;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/general/content-pdf/PricewaterhouseCoopers2.pdf.thumb.48.48.png']")
	private WebElement priceWaterPdf;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__pdf-info']")
	private WebElement lastUpdatedDate;
	
	@FindBy(xpath="//div[@class='coral3-Card-wrapper']")
	private static List<WebElement> pdfInfo;
	
	@FindBy(xpath="(//div[@class='coral3-Card-wrapper'])//foundation-time")
	private static List<WebElement> pdfInfo2;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/general/content-pdf/PDF%20Template%20for%20AEM%20Testing.pdf.thumb.48.48.png']")
	private WebElement pdfTemplate;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement setIcon;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/content-page-template-product-central/thumbnail.png']")
	private WebElement contentPageTemplate;
	
	@FindBy(xpath="//input[@name='./jcr:title']")
	private WebElement titleField2;
	
	@FindBy(xpath="(//li[@class='coral-SelectList-item coral-SelectList-item--option'])[1]")
	private WebElement firstOptionofDocCat;
	
	@FindBy(xpath="//li[.='Bookkeeping Connect']")
	private WebElement firstOptionofProCat;
	
	@FindBy(xpath="//li[.='Customer engagement']")
	private WebElement firstOptionofPortCat;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Create']")
	private WebElement createButton2;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Done']")
	private WebElement doneButton;
	
	@FindBy(xpath="//div[@title='Release Notes [Root]']")
	private WebElement releaseNotes;
	
	@FindBy(xpath="//coral-button-label[.='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="//input[@name='./releaseNotes/item0/./jcr:title']")
	private WebElement releaseTitle;
	
	@FindBy(xpath="//div[@data-fielddescription='Enter Release Note Description']")
	private WebElement releaseDescription;
	
	@FindBy(xpath="//input[@name='./releaseNotes/item0/./cq:lastReplicated']")
	private WebElement releaseDate;
	
	@FindBy(xpath="//span[@class='cmp-release-notes__card-subtitle']")
	private WebElement releaseDateonPreview;
	
	@FindBy(xpath="//a[@class='cmp-release-notes__card-title']")
	private WebElement releaseTitleonPreview;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__card-description']")
	private WebElement releaseDescriptiononPreview;
	
	@FindBy(xpath="(//div[@data-path='/conf/pc/settings/wcm/templates/product-page-template-product-central/structure/jcr:content/root/container/experiencefragment_c'])[2]")
	private WebElement authFooter;
	
	@FindBy(xpath="//textarea[@name='./title']")
	private WebElement textareaForFooter;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement privacyPolicyTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item0/./imagepath']")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath="//input[@name='./multifield/item1/./title']")
	private WebElement termsConditionsTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item1/./imagepath']")
	private WebElement termsConditionsLink;
	
	@FindBy(xpath="//input[@name='./multifield/item2/./title']")
	private WebElement cookieTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item2/./imagepath']")
	private WebElement cookieLink;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//div[@class='ap-footer-content']//span")
	private WebElement footerContent2;
	
	@FindBy(xpath="//a[@href='#pageinfo-popover']")
	private WebElement pageInfo;
	
	@FindBy(xpath="//button[@title='View as Published']")
	private WebElement viewasPublish;
	
	@FindBy(xpath="//button[@title='Publish Template']")
	private WebElement publishTemplate;
	
	@FindBy(xpath="(//button[@role='combobox'])[3]")
	private WebElement pcTags;
	
	@FindBy(xpath="(//foundation-time[@type='datetime'])[1]")
	private WebElement pdfDate;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
	private WebElement sitemapImg;
	
	@FindBy(xpath="//h1[@class='cmp-privacy-hub-header__product-name']")
	private WebElement pwcLogo;
	
	@FindBy(xpath="//div[@class='cmp-banner cmp-product-banner cmp-banner__scheduledMaintenance wcmmode']")
	private WebElement banner;
	
	@FindBy(xpath="(//button[@data-layer='Edit'])[2]")
	private WebElement editBanner;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewBanner;
	
	@FindBy(xpath="//div[@title='Notification Banner']")
	private WebElement bannerArea;
	
	@FindBy(xpath="//button[@data-action='CONFIGURE']")
	private WebElement settingsBanner;
	
	@FindBy(xpath="//coral-select[@name='./bannerType']")
	private WebElement bannerDrop;
	
	@FindBy(xpath="//coral-selectlist-item[@value='scheduledMaintenance']")
	private WebElement scheduledBanner;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/landing-page-template-product-central/thumbnail.png']")
	private WebElement landingPageTemplate;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal.thumb.48.48.png?ck=']")
	private WebElement legalPageImg;
	
	@FindBy(xpath="(//button[@trackingelement='create'])[2]")
	private WebElement createButton3;
	
	@FindBy(xpath="//a[@icon='workflow']")
	private WebElement workflowIcon;
	
	@FindBy(xpath="//span[@class=' coral3-Select-label']")
	private WebElement workflowDropdown;
	
	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-express-publish-workflow/pc-express-publish-workflow']")
	private WebElement publishWorkflow;
	
	@FindBy(xpath="//input[@name='workflowTitle']")
	private WebElement workflowTitle;

	@FindBy(xpath="//img[@class='foundation-collection-item-thumbnail']")
	private WebElement legalPageImgforPublish;
	
	@FindBy(xpath="(//time[@role='presentation'])[2]")
	private WebElement presentationDate;
	
	@FindBy(xpath="//coral-card-title[@class='foundation-collection-item-title coral3-Card-title']")
	private static List<WebElement> pdfTitles;
	
	@FindBy(xpath="//button[@trackingelement='properties']")
	private WebElement properties2;
	
	@FindBy(tagName="coral-tab-label")
	private static List<WebElement> tabs;
	
	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-approval-workflow/pc-approval-workflow']")
	private WebElement approvalWorkflow;
	
	@FindBy(xpath="//coral-icon[@icon='bell']")
	private WebElement bellIcon;
	
	@FindBy(xpath="//a[@href='/aem/inbox']")
	private WebElement aemInbox;
	
	@FindBy(xpath="//coral-table-row-selectcheckbox[@role='checkbox']")
	private static List<WebElement> tasks;
	
	@FindBy(xpath="(//button[@trackingelement='complete'])[2]")
	private WebElement completeButton;
	
	@FindBy(xpath="(//input[@class='coral-InputGroup-input js-coral-Autocomplete-textfield autocomplete-has-suggestion-btn coral3-Textfield'])[1]")
	private WebElement assignGroup;
	
	@FindBy(xpath="//button[@trackingelement='ok']")
	private WebElement okButton;
	
	@FindBy(xpath="(//div[@class='foundation-layout-flexmedia-bd-singleline'])[1]")
	private WebElement user;
	
	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-unpublish/pc-unpublish-workflow']")
	private WebElement unpublishWorkflow;
	
	@FindBy(xpath="(//coral-columnview-preview-value[@role='textbox'])[7]")
	private WebElement unpublishInfo;
	
	@FindBy(xpath="//label[@class='coral-Form-errorlabel']")
	private WebElement errorMessage;
	
	@FindBy(xpath="//div[@title='Image']")
	private WebElement imgPath;
	
	@FindBy(xpath="//button[@title='Configure']")
	private WebElement configure;
	
	@FindBy(xpath="//button[@class='cq-FileUpload-picker coral3-Button coral3-Button--quiet']")
	private WebElement pick;
	
	@FindBy(xpath="//coral-columnview-item[@title='ProductCentralproductcentral']")
	private WebElement pathforImage;
	
	@FindBy(xpath="//coral-columnview-item[@title='Static Assetsstatic-assets']")
	private WebElement pathforImage1;

	@FindBy(xpath="//coral-columnview-item[@title='errors']")
	private WebElement pathforImage2;
	
	@FindBy(xpath="//coral-columnview-item[@title='errors']")
	private WebElement pathforImage3;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/static-assets/errors/403-Error-illus.svg.thumb.48.48.png']")
	private WebElement img403;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/static-assets/errors/search-results-empty.svg.thumb.48.48.png']")
	private WebElement img404;
	
	@FindBy(xpath="//coral-icon[@icon='properties']")
	private WebElement propertiesIcon;
	
	@FindBy(xpath="//button[@title='Publish Page']")
	private WebElement publishIcon;
	
	@FindBy(xpath="//button[@title='View as Published']")
	private WebElement viewPublished;
	
	@FindBy(xpath="//div[@data-asset='/content/dam/productcentral/static-assets/errors/403-Error-illus.svg']")
	private WebElement errorImg403;
	
	@FindBy(xpath="//div[@data-asset='/content/dam/productcentral/static-assets/errors/search-results-empty.svg']")
	private WebElement errorImg404;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement errorTitle;
	
	@FindBy(xpath="//div[contains(@class, 'cmp-text')]")
	private WebElement errorDecsription;
	
	@FindBy(xpath="//div[@title='Title']")
	private WebElement titleEdit403;
	
	@FindBy(xpath="//div[@title='Text']")
	private WebElement descEdit403;
	
	@FindBy(xpath="//div[@name='./text']")
	private WebElement descEditField;
	
	@FindBy(xpath="//img[@class='cmp-image__image']")
	private WebElement errorImg;
	
	@FindBy(xpath="//coral-button-label[.='Add']")
	private WebElement add;
	
	@FindBy(xpath="//coral-icon[@aria-label='Maximum numbers of items allowed are 5 and there are 6']")
	private WebElement alert;
	
	@FindBy(xpath="//div[@title='Hero [Root]']")
	private WebElement homeImage;
	
	@FindBy(xpath="//coral-columnview-item[@title='error_image.png']//img")
	private WebElement pathImage;
	
	@FindBy(xpath="//coral-columnview-item[@title='homepage.svg']//img")
	private WebElement homeImagePath;
	
	@FindBy(xpath="//img[@class='cmp-hero__image']")
	private WebElement homePublishImage;
	
	@FindBy(xpath="//coral-tab-label[.='Text']")
	private WebElement textButton;
	
	@FindBy(xpath="//div[@name='./jcr:description']")
	private WebElement textDescription;
	
	@FindBy(xpath="//div[@class='cmp-hero__description']")
	private WebElement heroDescription;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/privacy-hub.thumb.48.48.png?ck=']")
	private WebElement privacyImg;
	
	@FindBy(xpath="//coral-selectlist[@role='listbox']//coral-selectlist-item")
	private static List<WebElement> workflowOptions;
	
	@FindBy(xpath="//div[@title='FAQs']")
	private WebElement editAccordion;
	
	@FindBy(xpath="(//h3[@class='coral-Collapsible-header'])[1]")
	private WebElement collapsableHeader;
	
	@FindBy(xpath="//div[@name='./faqsList/item0/./answer']")
	private WebElement faqAnswer;
	
	@FindBy(xpath="(//button[@title='Hyperlink'])[1]")
	private WebElement hyperlinkButton;
	
	@FindBy(xpath="(//div[@name='./faqsList/item0/./answer']//a)[1]")
	private WebElement faqHref;
	
	@FindBy(xpath="//div[@title='Title']")
	private WebElement editPrivacy;
	
	@FindBy(xpath="//coral-select[@name='./type']")
	private WebElement font;
	
	@FindBy(xpath="//coral-select[@name='./type']//coral-selectlist-item")
	private static List<WebElement> fontOptions;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement privacyTitle1;
	
	@FindBy(xpath="//h6[@class='cmp-title__text']")
	private WebElement privacyTitle2;
	
	@FindBy(xpath="(//div[@title='Text'])[1]")
	private WebElement editText;
	
	@FindBy(xpath="(//div[@name='./text'])[1]")
	private WebElement textArea;
	
	@FindBy(xpath="(//button[@title='Table'])[1]")
	private WebElement privacyEditTable;
	
	@FindBy(xpath="(//button[@title='Hyperlink'])[1]")
	private WebElement privacyEditHyperlink;
	
	@FindBy(xpath="(//button[@title='Bold (Ctrl+B)'])[1]")
	private WebElement privacyEditText;
	
	@FindBy(xpath="//input[@name='./faqsList/item0/./question']")
	private WebElement faqQuestionField;
	
	@FindBy(xpath="//div[@name='./faqsList/item0/./answer']")
	private WebElement faqAnswerField;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/privacy-hub.thumb.48.48.png?ck=']")
	private WebElement privacyHubImg;
	
	@FindBy(xpath="(//coral-columnview-preview-value)[7]")
	private WebElement notPublishedText;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/legal-product-listing-page-template-product-central/thumbnail.png']")
	private WebElement legalPageTemplate;
	
	@FindBy(xpath="//select[@name='./documentCategory']")
	private WebElement docCatDropdown;
	
	@FindBy(xpath="//coral-button-label[.='Done']")
	private WebElement doneButton2;
	
	@FindBy(xpath="//div[@title='Legal Product Listing [Root]']")
	private WebElement legalTemplate;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']")
	private WebElement legalTiles2;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/accessibility.thumb.48.48.png?ck=']")
	private WebElement accessImg;
	
	@FindBy(xpath="//button[@icon='delete']")
	private WebElement delete;
	
	@FindBy(xpath="//coral-button-label[.='Delete']")
	private WebElement delete2;
	
	@FindBy(xpath="//coral-button-label[.='Create']")
	private WebElement createPage;
	
	@FindBy(xpath="//div[@title='Hero Promotion [Root]']")
	private WebElement heroEdit;
	
	@FindBy(xpath="//input[@name='./jcr:description']")
	private WebElement heroEditDesc;
	
	@FindBy(xpath="//h3[@class='cmp-hero-promotion__content-description']")
	private WebElement productDescription;
	
	@FindBy(xpath="//coral-tab-label[.='Call to action']")
	private WebElement calltoAction;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./ctaLink']//coral-icon[@aria-label='select']")
	private WebElement selectPath;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products.thumb.48.48.png?ck=']")
	private WebElement myproductPath;
	
	@FindBy(xpath="//div[@class='cmp-hero__action-container']//a")
	private WebElement actionContainer;
	
	@FindBy(xpath="//div[@title='Need technical support? [Root]']")
	private WebElement tsEdit;
	
	@FindBy(xpath="//input[@name='./ctaTxt']")
	private WebElement tsTitle;
	
	@FindBy(xpath="//input[@name='./jcr:description']")
	private WebElement tsDescription;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/security.thumb.48.48.png?ck=']")
	private WebElement securityImg;
	
	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-unpublishapprovalworfklow/pc-unpublishapprovalworfklow']")
	private WebElement unpublishApproval;
	
	@FindBy(xpath="//div[@class='granite-shell-badge-item-inbox']//a")
	private WebElement AEMInbox;
	
	@FindBy(xpath="(//coral-table-row-selectcheckbox[@role='checkbox'])[1]")
	private WebElement assignedTask;
	
	@FindBy(xpath="(//time[@role='presentation'])[1]")
	private WebElement firstTasktime;
	
	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-inbox-workitem-complete foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']")
	private WebElement completeButton2;
	
	@FindBy(xpath="//div[@role='heading']")
	private WebElement contentHeader;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[1]")
	private WebElement resource1;
		
	@FindBy(xpath="(//div[@class='cmp-document-tiles__entry-title'])[1]")
	private WebElement firstProductTile;
	
	@FindBy(xpath="//div[@title='Product Tiles [Root]']")
	private WebElement editTiles;
	
	@FindBy(xpath="(//button[@icon='moveUpDown'])[1]")
	private WebElement drag1;
	
	@FindBy(xpath="(//button[@icon='moveUpDown'])[3]")
	private WebElement drag2;
	
	@FindBy(xpath="//coral-popover[@id='pageinfo-popover']//span[1]")
	private WebElement publishInfoonPage;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/landing-page-template-product-central/thumbnail.png']")
	private WebElement landingTemplate;
	
	@FindBy(xpath="//coral-checkbox[@name='./hideListingPages']")
	private WebElement hideListing;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/content-page-template-product-central/thumbnail.png']")
	private WebElement contentTemplate;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/products/testing/accessibility.thumb.48.48.png?ck=']")
	private WebElement accessImg2;
	
	@FindBy(xpath="(//img[@src='/content/pc/us/en/automation/products/testing.thumb.48.48.png?ck='])[1]")
	private WebElement testingImg;
	
	@FindBy(xpath="//span[@class='cmp-product-list__card-title ']")
	private static List<WebElement> productTitles;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Save & Close']")
	private WebElement saveClose;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/products.thumb.48.48.png?ck=']")
	private WebElement productImg;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/sitemap-page-template-product-central/thumbnail.png']")
	private WebElement siteTemplate;
	
	@FindBy(xpath="//div[@class='cmp-sitemap-single-parent__title']")
	private WebElement sitemapContent;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/site-demo.thumb.48.48.png?ck=']")
	private WebElement sitedemoImg;
	
	@FindBy(xpath="//div[@class='cmp-sitemap__title']//a")
	private static List<WebElement> sitemapLinks;
	
	@FindBy(xpath="//h1[normalize-space()='My-Products']")
	private WebElement myproductSitemap;
	
	@FindBy(xpath="//a[normalize-space()='Fluid Forecast']")
	private WebElement childContent;
	
	@FindBy(xpath="//div[@class='cmp-banner cmp-product-banner cmp-banner__scheduledMaintenance wcmmode']")
	private WebElement scheduledCont;
	
	@FindBy(xpath="//div[@class='cmp-banner cmp-product-banner cmp-banner__outage wcmmode']")
	private WebElement outageCont;
	
	@FindBy(xpath="//div[@class='cmp-banner cmp-product-banner cmp-banner__deprecated wcmmode']")
	private WebElement deprecatedCont;
	
	@FindBy(xpath="//tbody[@class='coral-Table-body coral-Table-divider--row']//tr//td[16]")
	private static List<WebElement> pageTitlesinReports;
	
	@FindBy(xpath="//coral-card-title[normalize-space()='Profit Seeker - Maintenance and Support.pdf']")
	private WebElement examplePDF;
	
	@FindBy(xpath="//coral-select[@placeholder='Select a Workflow Model']")
	private WebElement selectModel;
	
	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-express-publish-workflow/pc-express-publish-workflow']")
	private WebElement selectExpress;
	
	@FindBy(xpath="//input[@placeholder='Enter title of workflow']")
	private WebElement selectTitle;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Start']")
	private WebElement selectStart;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Proceed']")
	private WebElement selectProceed;
	
	@FindBy(xpath="//a[normalize-space()='Workflows Report']")
	private WebElement workflowReports;
	
	@FindBy(xpath="//button[normalize-space()='Execute Report']")
	private WebElement executeReports;
	
	@FindBy(xpath="//div[@class='report__result-container']")
	private WebElement results;
	
	@FindBy(xpath="//div[@title='Privacy Hub Header Component']")
	private WebElement phEdit;
	
	@FindBy(xpath="//input[@name='./title']")
	private WebElement pTitle;
	
	@FindBy(xpath="//h1[@class='cmp-privacy-hub-header__product-name']")
	private WebElement phProductName;
	
	@FindBy(xpath="//button[@id='sidepanel-toggle-button']")
	private WebElement sidePanel;
	
	@FindBy(xpath="//coral-icon[@icon='treeExpandAll']")
	private WebElement expandAll;
	
	@FindBy(xpath="//div[contains(text(),'Experience Fragment')]")
	private WebElement ef;
	
	@FindBy(xpath="//div[@class='cq-Overlay cq-Overlay--component cq-droptarget cq-Overlay--placeholder']")
	private WebElement dragPlace;
	
	@FindBy(xpath="//div[@data-asset-accept='[\"text/html\"]']")
	private WebElement ef2;
	
	@FindBy(xpath="//span[normalize-space()='Experience Fragment']")
	private static List<WebElement> ef3;
	
	@FindBy(xpath="//button[@title='Delete']")
	private WebElement ef2Delete;
	
	@FindBy(xpath="//button[@id='DELETE']")
	private WebElement deleteConfirm;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/product-page-template-product-central/thumbnail.png']")
	private WebElement ppTemplate;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Next']")
	private WebElement nextTemplate;
	
	@FindBy(xpath="//coral-tab-label[normalize-space()='Product Details']")
	private WebElement productDetails;
	
	@FindBy(xpath="//span[@class='coral-Form-field coral-Select']")
	private WebElement productSelect;
	
	@FindBy(xpath="//li[@class='coral-SelectList-item coral-SelectList-item--option']")
	private static List<WebElement> allProducts;
	
	@FindBy(xpath="//span[@class='cmp-tabs__title-container-view-more view-all-js']")
	private WebElement viewAll;
	
	@FindBy(xpath="//a[@class='cmp-tabs__products-modal-card']")
	private static List<WebElement> allProducts2;
	
	@FindBy(xpath="//div[@title='Privacy Hub Footer Component']")
	private WebElement phFooter;
	
	@FindBy(xpath="//label[normalize-space()='Footer Text *']")
	private WebElement phFooterText;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement phFooterTitle;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement phFooterExternal;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Add']")
	private WebElement phAddLink;
	
	@FindBy(xpath="//input[@name='./multifield/item1/./title']")
	private WebElement phSecondTitle;
	
	@FindBy(xpath="//coral-multifield-item[@aria-label='(2 of 2)']//coral-icon[@aria-label='delete']")
	private WebElement phSecondDelete;
	
	@FindBy(xpath="//span[@class='item-text']")
	private static List<WebElement> phLinks;
	
	@FindBy(xpath="(//a[@class='ap-link'])[1]")
	private WebElement faqLink;
	
	@FindBy(xpath="//input[@name='./hideDownloadFullTerms']")
	private WebElement hideDownload;
	
	@FindBy(xpath="(//div[@title='Notification Banner'])[1]")
	private WebElement firstBanner;
	
	@FindBy(xpath="//coral-select[@name='./bannerType']")
	private WebElement bannerType;
	
	@FindBy(xpath="//select[@name='./product']")
	private WebElement bannerProduct;
	
	@FindBy(xpath="//div[@aria-required='true']//button[@title='Toggle']")
	private WebElement selectGroup;
	
	@FindBy(xpath="//div[@aria-expanded='true']//input[@role='combobox']")
	private WebElement textGroup;
	
	@FindBy(xpath="//li[@data-value='pc-globalit-qa']")
	private WebElement globalIt;
	
	@FindBy(xpath="//coral-select[@name='archiveZip']//button[@type='button']")
	private WebElement selectZip;
	
	@FindBy(xpath="//coral-selectlist-item[@value='false']")
	private WebElement selectZipNo;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Ok']")
	private WebElement selectOk;
	
	@FindBy(xpath="//form[@enctype='multipart/form-data']//button[@type='button']")
	private WebElement approveGroup;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Publish Page/Asset']")
	private WebElement publishGroup;
	
	@FindBy(xpath="//textarea[@name='./title']")
	private WebElement footerText;
	
	@FindBy(xpath="//span[@class='ap-footer-content__copyright-icon']")
	private WebElement footerCopywrite;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/my-products/fluid-forecast/jcr:content/root/banners_container/container/notification_banner_1833178630']")
	private WebElement bannerEdit;
	
	@FindBy(xpath="//coral-selectlist-item[@value='outage']")
	private WebElement outageBanner;
	
	@FindBy(xpath="(//div[@class='cmp-banner cmp-product-banner cmp-banner__scheduledMaintenance wcmmode'])[2]")
	private WebElement scheduledBanner2;
	
	@FindBy(xpath="(//div[@class='cmp-banner cmp-product-banner cmp-banner__outage wcmmode'])[2]")
	private WebElement outageBanner2;
	
	@FindBy(xpath="//button[@title='Open Selection Dialog']")
	private WebElement selectTag;
	
	@FindBy(xpath="//coral-columnview-item-content[@title='Product Central']")
	private WebElement productCent;
	
	@FindBy(xpath="//coral-columnview-item[@title='Portfolio']//coral-columnview-item-thumbnail")
	private WebElement firstTagImg;
	
	@FindBy(xpath="//coral-columnview-item[@title='My Product Doc Category']//coral-columnview-item-thumbnail")
	private WebElement secondTagImg;
	
	@FindBy(xpath="//coral-tag[@role='row']")
	private static List<WebElement> featureTags;
	
	@FindBy(xpath="//button[@title='Remove']")
	private static List<WebElement> removeTags;
	
	@FindBy(xpath="//button[@title='Remove']")
	private WebElement removeTag;
	
	@FindBy(xpath="//coral-tab-label[normalize-space()='Product Central']")
	private WebElement pcTab;
	
	@FindBy(xpath="//select[@name='./jcr:content/metadata/productFeatureTag']")
	private WebElement selectPF;
	
	@FindBy(xpath="//select[@name='./jcr:content/metadata/productFeatureTag']//option")
	private static List<WebElement> pfOptions;
	
	@FindBy(xpath="//coral-tab-label[normalize-space()='Basic']")
	private WebElement basicTab;
	
	@FindBy(xpath="//a[normalize-space()='Kaltura Video']")
	private WebElement kaltura;
	
	@FindBy(xpath="//div[contains(text(),'youtube video')]")
	private WebElement kalturaVideo;
	
	@FindBy(xpath="//span[normalize-space()='Kaltura Video']")
	private WebElement contentFragment;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement heroEditTitle;
	
	@FindBy(xpath="//h2[@class='cmp-hero-promotion__content-title']")
	private WebElement heroTitle;
	
	@FindBy(xpath="//p[@class='cmp-hero-promotion__content-description']")
	private WebElement heroDesc;
	
	@FindBy(xpath="//label[@class='coral-Form-errorlabel']")
	private WebElement pcErrorLabel;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/myproducts-landing-page-template/thumbnail.png']")
	private WebElement mplpTemplate;
	
	@FindBy(xpath="//coral-tab[@title='Components']")
	private WebElement addComponents;
	
	@FindBy(xpath="(//div[normalize-space()='Related Links'])[1]")
	private WebElement dragRelated;
	
	@FindBy(xpath="(//div[@data-text='Drag components here'])[2]")
	private WebElement dropRelated;
	
	@FindBy(xpath="//div[normalize-space()='Related Links']")
	private static List<WebElement> relatedLinks;
	
	@FindBy(xpath="//img[contains(@src, 'automation-landing')]")
	private WebElement alImg;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Open']")
	private WebElement openPage;
	
	@FindBy(xpath="//div[@title='Left Navigation v2']")
	private WebElement leftNaviEdit;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement firstTitleEdit;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./levelTwoLinks/item0/./title']")
	private WebElement secondTitleEdit;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./imagepath']")
	private WebElement firstImagePath;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./levelTwoLinks/item0/./imagepath']")
	private WebElement secondImagePath;
	
	@FindBy(xpath="//div[@title='Inherited Banners']")
	private WebElement inheritedBanner;
	
	@FindBy(xpath="//div[@class='cmp-banner__message']")
	private WebElement preferencesModal;
	
	@FindBy(xpath="//div[contains(@title, 'Related links')]")
	private WebElement authRelated;
	
	@FindBy(xpath="//input[@name='./items/item0/./overridePageTitle']")
	private WebElement relatedTitleEdit;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./items/item0/./link']")
	private WebElement relatedLinkEdit;
	
	@FindBy(xpath="//div[@id='white-container']")
	private WebElement whiteContainer;
	
	@FindBy(xpath="//div[@data-asset-id='image']")
	private WebElement columnImgEdit;
	
	@FindBy(xpath="//coral-button-label[.='Pick']")
	private WebElement pick2;
	
	@FindBy(xpath="//coral-columnview-item[contains(@title, 'ProductCentral')]")
	private WebElement path1;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/asset.jpg.thumb.48.48.png']")
	private WebElement path2;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/pwc-logo-outline.png.thumb.48.48.png']")
	private WebElement path4;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Select']")
	private WebElement selectButton2;
	
	@FindBy(xpath="//div[@title='MyProducts+ Image Thumbnail']")
	private WebElement columnImgEditThumb;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./jcr:img']//button[@title='Open Selection Dialog']")
	private WebElement path3;
	
	@FindBy(xpath="//div[@class='cmp-image-thumbnail__text']")
	private WebElement thumbText;
	
	@FindBy(xpath="//img[@class='cmp-image-thumbnail__image']")
	private WebElement thumbImg;
	
	@FindBy(xpath="//div[contains(text(),'Divider')]")
	private WebElement dividerDrag;
	
	@FindBy(xpath="(//div[contains(@data-text, 'Drag component')])[2]")
	private WebElement dividerDrop;
	
	@FindBy(xpath="//div[contains(@class, 'cmp-separator')]")
	private WebElement divider;
	
	@FindBy(xpath="//div[contains(@title, 'Divider')]")
	private WebElement dividerEdit;
	
	@FindBy(xpath="//img[@class='cmp-image__image']")
	private WebElement coloumImgPublish;
	
	@FindBy(xpath="//img[@class='image-modal-content']")
	private WebElement coloumImgModal;
	
	@FindBy(xpath="//div[contains(@class, 'for-you')]//div[contains(text(),'Child Check-in')]")
	private static List<WebElement> childTitle;
	
	@FindBy(xpath="//div[contains(@class, 'for-you')]//div[contains(text(),'Top Level Automation')]")
	private static List<WebElement> childTitle2;
	
	@FindBy(xpath="//div[contains(@class, 'for-you')]//div[contains(text(),'Not TopLevel')]")
	private static List<WebElement> childTitle3;
	
	@FindBy(xpath="//li[contains(@class, 'coral-SelectList-item coral-SelectList-item--option')]//label[contains(@class, 'error')]")
	private static List<WebElement> documentError;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'my-product')]//button[@data-toggle='selectlist']")
	private WebElement myproductDropdown;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'audience')]//button[@data-toggle='selectlist']")
	private WebElement audienceDropdown;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'product-feature')]//button[@data-toggle='selectlist']")
	private WebElement pfDropdown;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'portfolio')]//button[@data-toggle='selectlist']")
	private WebElement portfolioDropdown;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'my-product-doc-category')]//li")
	private static List<WebElement> myDocumentList;
	
	@FindBy(xpath="//span[@id='audience-tags-select']//li")
	private static List<WebElement> audienceList;
	
	@FindBy(xpath="//span[@id='product-tag-select']//li")
	private static List<WebElement> pfList;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'portfolio')]//li")
	private static List<WebElement> portfolioList;
	
	@FindBy(xpath="//label[contains(@class, 'error')]")
	private static List<WebElement> errorList;
	
	@FindBy(xpath="//span[@id='product-document-cat-select']//button")
	private WebElement documentCategoryTag3;
	
	@FindBy(xpath="//span[@id='product-tag-select']//button")
	private WebElement productFeatureTag3;
	
	@FindBy(xpath="//div[@title='Text']")
	private WebElement editTable;
	
	@FindBy(xpath="(//div[@title='Container [Root]'])[4]")
	private WebElement createTable;
	
	@FindBy(xpath="//button[@title='Insert component']")
	private WebElement insert;
	
	@FindBy(xpath="//input[@placeholder='Enter Keyword']")
	private WebElement enterKeyword;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Text']")
	private WebElement insertText;
	
	@FindBy(xpath="(//div[@title='Text'])[2]")
	private WebElement textEdit;
	
	@FindBy(xpath="//div[@name='./text']")
	private WebElement textArea2;
	
	@FindBy(xpath="//table[@class='TableStyle-TableStyle']")
	private static List<WebElement> tables;
	
	@FindBy(xpath="//table[@class='TableStyle-TableStyle']")
	private static List<WebElement> myProductBreadcrumbs;
	
	@FindBy(xpath="//coral-checkbox[@name='./hideBreadcrumb']//input")
	private WebElement breadcrumbCheckbox;
	
	@FindBy(xpath="//div[contains(@class, 'for-you')]//a")
	private static List<WebElement> forYouTitles;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__products-link'])[1]")
	private WebElement logintoMyproducts;
	
	@FindBy(xpath="//span[contains(@aria-label, 'Banner')]")
	private WebElement bannerClose;
	
	@FindBy(xpath="//div[contains(@class, 'outage')]")
    private WebElement banner2;
	
	@FindBy(xpath="//div[@class='cmp-banner__message']")
    private WebElement outageBannerMessage;
	
	@FindBy(xpath="//span[@id='audience-tags-select']//button")
	private WebElement audienceTag;
	
	@FindBy(xpath="//li[.='Anonymous']")
	private WebElement anonyOption;
	
	@FindBy(xpath="//span[@id='portfolio-tags-select']//button")
	private WebElement portTag;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static List<WebElement> footerHome;
	
	@FindBy(xpath="//coral-tab-label[.='Product Details']")
	private WebElement productDetailsTab;
	
	@FindBy(xpath="//span[@id='portfolio-tags-select']//button")
	private WebElement portfolioTag;
	
	@FindBy(xpath="//div[contains(text(),'Disclosure Checklist')]")
	private WebElement disclosureRelated;
	
	@FindBy(xpath="//div[@title='Embed HTML']")
	private WebElement embedEdit;
	
	@FindBy(xpath="//textarea[@name='./html']")
	private WebElement embedTextArea;
	
	@FindBy(xpath="//h1[normalize-space()='This is a Heading']")
	private WebElement embedHeading;
	
	@FindBy(xpath="//p[normalize-space()='This is a paragraph.']")
	private WebElement embedParag;
	
	@FindBy(xpath="//coral-icon[contains(@class, 'error')]")
	private WebElement errorIcon;
	
	@FindBy(xpath="//a[@href='/var/acs-commons/reports/workflows-report.html?wcmmode=disabled']")
	private WebElement pageReport;
	
	@FindBy(xpath="//button[normalize-space()='Execute Report']")
	private WebElement executeReport;
	
	@FindBy(tagName="coral-table-headercell-content")
	private static List<WebElement> workflowElements;
	
	@FindBy(xpath="//span[@class='coral-Collapsible-title']")
	private static List<WebElement> expandCollapse;
	
	@FindBy(xpath="(//div[@class='cmp-banner__message'])[2]")
    private WebElement outageBannerMessage2;
	
	@FindBy(xpath="(//div[contains(@class, 'cmp-all-resources__card-title')]//a[@aria-label='open video modal'])[2]")
	private WebElement allResourcesVideo;
	
	@FindBy(xpath="//div[@class='playkit-video-player']")
	private static List<WebElement> videoPlayers;
	
	@FindBy(xpath="//div[@class='playkit-pre-playback-play-overlay']//button[@aria-label='Play']")
	private static List<WebElement> playButtons;
	
	@FindBy(xpath="//div[contains(@data-path, 'latest')]")
	private WebElement authLatest;
	
	@FindBy(xpath="//div[contains(@name, 'description')]")
	private WebElement authLatestDesc;
	
	@FindBy(xpath="//coral-buttongroup[contains(@class, 'coral3-ButtonGroup rte-toolbar is-sticky is-active')]//button[contains(@title, 'Hyperlink')]")
	private WebElement hyperlinkButton2;
	
	@FindBy(xpath="//coral-select[contains(@handle, 'targetSelect')]//button")
	private WebElement tabsDropdown;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='New Tab']")
	private WebElement newTab;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Same Tab']")
	private WebElement sameTab;
	
	@FindBy(xpath="//foundation-autocomplete[@name='href']//input[@is='coral-textfield']")
	private WebElement hrefField;
	
	@FindBy(xpath="//button[contains(@title, 'Apply')]")
	private WebElement applyButton;
	
	@FindBy(xpath="//span[@class='cmp-latest__text-description']//a")
	private WebElement hyperlink;
	
	@FindBy(xpath="//button[@id='ot-sdk-btn']")
	private WebElement customizeCookies;
	
	@FindBy(xpath="//div[@id='ot-pc-content']")
	private WebElement cookiesContent;
	
	@FindBy(xpath="(//div[@class='cmp-sidebar__item first-level-link '])[1]//button")
	private WebElement level1;
	
	@FindBy(xpath="//a[@title='Level 2']")
	private WebElement level2Title;
	
	@FindBy(xpath="//div[@class='cmp-sidebar__sub-list']//button")
	private WebElement level2;
	
	@FindBy(xpath="(//div[@class='cmp-sidebar__sub-list-third'])[1]")
	private WebElement level3Title;
	
	@FindBy(xpath="//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private static WebElement closeButtonforCookies;
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card-title']//a")
	private static List<WebElement> allresourcesContentLink;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/myproducts-landing-page-template/thumbnail.png']")
	private WebElement myProductPageTemplate;
	
	@FindBy(xpath="//span[@id='product-document-cat-select']//button")
	private WebElement myProductDocDropdown;
	
	@FindBy(xpath="//li[@data-value='productcentral:my-product-doc-category/comms-materials']")
	private WebElement myProductDocValue;
	
	@FindBy(xpath="//span[@id='product-tag-select']//button")
	private WebElement productTagDropdown;
	
	@FindBy(xpath="//li[@data-value='productcentral:product-feature/bookkeeping-connect']")
	private WebElement productTagValue;
	
	@FindBy(xpath="//span[@id='audience-tags-select']//button")
	private WebElement audienceDropdown2;
	
	@FindBy(xpath="//li[@data-value='productcentral:audience/anonymous']")
	private WebElement audienceValue;
	
	@FindBy(xpath="//input[@id='gatedSearchInput']")
	private WebElement searchInput;
	
	@FindBy(xpath="//img[contains(@src, '/content/pc/us/en/automation/my-products/search-automation')]")
	private WebElement searchAutomationPage;
	
	@FindBy(xpath="//coral-button-label[.='Open']")
	private WebElement openButton;
	
	@FindBy(xpath="//li[normalize-space()='Anonymous']")
	private WebElement optionAnony;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/general-article-page-template-product-central/thumbnail.png']")
	private WebElement generalArticlePageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/home-page-template-product-central/thumbnail.png']")
	private WebElement homePageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/privacyhub-page-template-product-central/thumbnail.png']")
	private WebElement privacyHubPageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/product-page-template-product-central/thumbnail.png']")
	private WebElement productPageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/reseller-page-template-product-central/thumbnail.png']")
	private WebElement resellerPageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/search-results-template-product-central/thumbnail.png']")
	private WebElement searchResultPageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/content-table-page-template-product-central/thumbnail.png']")
	private WebElement tableContentPageTemplate;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/sitemap-page-template-product-central/thumbnail.png']")
	private WebElement sitemapPageTemplate;
	
	@FindBy(xpath="//select[@name='./audienceTag']")
	private WebElement audienceTag2;
	
	@FindBy(xpath="//select[@name='./myProductsDocumentCategory']")
	private WebElement myProductDocTag;
	
	@FindBy(xpath="//select[@name='./productFeatureTag']")
	private WebElement productTag;
	
	@FindBy(xpath="//select[@name='./featureTags']")
	private WebElement featureTag;
	
	@FindBy(xpath="//select[@name='./portfolioTag']")
	private WebElement portfolioTag3;
	
	
	
	static Logger logger=Logger.getLogger("AuthoringPage");
	
	
	
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	
	String expectedNavigatorTitle="new title";
	String expectedNavigatorDescription="New Description";
	





	public void aemTitle() {Assert.assertEquals(Driver.getDriver().getTitle(), "AEM Start", "AEM title verification has been failed");}
	
    public void setSites() {
    	sites.click();
    	productcentral.click();
    	us.click();
    	en.click();
    	HelperFunctions.staticWait(10);
    	automation.click();
    	myproduct.click();
    	fluidForecast.click();
    	HelperFunctions.staticWait(3);
		edit.click();
		 Set<String> allWindows4=Driver.getDriver().getWindowHandles();
	        List<String> windowsList4=new ArrayList<>(allWindows4);
	        Driver.getDriver().switchTo().window(windowsList4.get(1));
	        HelperFunctions.staticWait(15);
	        Driver.getDriver().switchTo().frame(0);
	        //HelperFunctions.clickWithWait(pageTitle);
	        int count=foryouAssets.size();
	        System.out.println(count);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	        
	  
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        if(viewMoreButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
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
	        
	
	      
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", viewMoreButton);
	        if(viewLessButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
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
	        
	        
	        
	        
	        
    
    
    	}
	
	

    public void setChangeProductsTitle() {
		Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeProductsTitle).build().perform();
		HelperFunctions.staticWait(3);
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        System.out.println(changeProductsTitle.getText());
        
	}
	public void setTitleEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
		titleEdit.click();
		titleEdit.clear();
		titleEdit.sendKeys(expectedNavigatorTitle);
		HelperFunctions.staticWait(3);
		
	}
	
	public void setCheckButton() {checkButton.click();HelperFunctions.staticWait(3);}
	
	public void setChangeNavigatorDescription() {
        Driver.getDriver().switchTo().defaultContent();
        Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeNavigatorDescription).build().perform();
		HelperFunctions.staticWait(3);
	}
	public void setNavigatorDescriptionEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        HelperFunctions.staticWait(3);
		navigatorDescriptionEdit.click();
		navigatorDescriptionEdit.clear();
		navigatorDescriptionEdit.sendKeys(expectedNavigatorDescription);
		HelperFunctions.staticWait(3);
	}
	
	public void setCheckButton2() {checkButton2.click();HelperFunctions.staticWait(3);}
	
	public void setPreviewButton() {previewButton.click();}

    public void setActualNavigatorTitle() {
    	Driver.getDriver().switchTo().frame(0);
    	Assert.assertEquals(actualNavigatorTitle.getText(),expectedNavigatorTitle,"Actual and expected Navigator Title do not match");
	}

    public void setActualNavigatorDescription() {
		Assert.assertEquals(actualNavigatorDescription.getText(),expectedNavigatorDescription,"Actual and expected Navigator description do not match");
	}
    public void setDocCategory() throws Exception {
  
        read1.setExcelFile("./testdata.xlsx", "QA");
 		email.sendKeys(read1.getCellData("DATA", 1));
 		next.click();
 		pass.sendKeys(read1.getCellData("VALUE", 1));
 		submit.click();
 	    HelperFunctions.staticWait(5);
 	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
 js.executeScript("window.open()");
 	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
 	    Driver.getDriver().switchTo().window(tabs.get(1));
 	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
 	    HelperFunctions.waitForPageToLoad(5);
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	 HelperFunctions.staticWait(3);
		
        	
        	 FileInputStream file = new FileInputStream("C:\\Users\\erong\\git\\ProductCentralProject-Automation1\\testdata.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(file);
             XSSFSheet sheet = workbook.getSheetAt(1); 
             int columnIndex = 2; 
          
             HelperFunctions.staticWait(3);
             JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
             executor.executeScript("arguments[0].click();", portfolioTags2);
            
             HashSet<String> cellValues = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex);
                 if(cell == null) continue;
                 cellValues.add(cell.getStringCellValue());
             }
             for (WebElement element : portfolioTags) {
                 if(element.isDisplayed() && element.isEnabled()){
                     String elementText = element.getText();
                     if(elementText!=null && !elementText.isEmpty()){
                         Assert.assertTrue(cellValues.contains(elementText), "element text: " + elementText + " not found in the column: " + columnIndex);
                     }else{
                         System.out.println("Element text is empty or null, skipping the element");
                     }
                 }else{
                     System.out.println("Element is not interactable or not visible, skipping the element");
                 }
             }
            /* HelperFunctions.staticWait(3);
             JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
             executor2.executeScript("arguments[0].click();", pcTags);
             HelperFunctions.staticWait(3);
             int columnIndex2 = 1;
             HashSet<String> cellValues2 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex2);
                 if(cell == null) continue;
                 cellValues2.add(cell.getStringCellValue());
             }
             for (WebElement element2 : productFeatureTags) {
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
             int columnIndex3 = 0;
             HashSet<String> cellValues3 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex3);
                 if(cell == null) continue;
                 cellValues3.add(cell.getStringCellValue());
             }
             for (WebElement element3 : documentCategoryTag) {
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
             }*/
           
    }
  
    	
    
    public void setCombination() throws Exception {
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(3);
    	//sites.click();
    	//productcentral.click();
    	//us.click();
    	//en.click();
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	
    	for(WebElement each: documentCategoryTag) {
    		if(each.getText().contains("Hosted Software Terms")) {
    			each.click();
    			break;
    		}
    	}
    	
    	
    	
    	
    }
    
    public void setHyperlinks() throws Exception {
    	
    	
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(3);
	    productsPackage.click();
	    HelperFunctions.staticWait(3);
	    cloudPackage.click();
	    HelperFunctions.staticWait(3);
	    String expectedTitle="Offering Overview";
    	String expectedTitle2="Terms & Conditions";
    	String expectedTitle3="Maintenance & Support";
    	String expectedTitle4="Documentation";
    	Assert.assertTrue(firstPositionAuthor.getText().contains(expectedTitle));
    	Assert.assertTrue(secondPositionAuthor.getText().contains(expectedTitle2));
    	Assert.assertTrue(thirdPositionAuthor.getText().contains(expectedTitle3));
    	Assert.assertTrue(forthPositionAuthor.getText().contains(expectedTitle4));
    	
	    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs2.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 21));
	    HelperFunctions.waitForPageToLoad(3);
	    Assert.assertTrue(firstTitle.getText().contains(expectedTitle));
	    Assert.assertTrue(secondTitle.getText().contains(expectedTitle2));
	    Assert.assertTrue(thirdTitle.getText().contains(expectedTitle3));
	    Assert.assertTrue(forthTitle.getText().contains(expectedTitle4));
    	
    	
    	
    	
    }
    
    
    public void setSitemap() throws Exception {
    	HelperFunctions.waitForPageToLoad(5);
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 16));
	    HelperFunctions.waitForPageToLoad(5);
	    sitemap.click();
	    settingIcon.click();
	    ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs7.get(1));
	    checkforOptions.click();
	    myproductImage.click();
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", myproductImage);
        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", myproductImage);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", selectButton);
	   
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    previewButton2.click();
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Fluid Forecast")&& each.getText().contains("Disclosure Checklist")
	    			&&!each.getText().contains("Products") ) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    HelperFunctions.staticWait(3);
	    editnextToPreview.click();
	    HelperFunctions.staticWait(3);
	    sitemap.click();
	    settingIcon.click();
	    ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs8.get(1));
	    checkforOptions.click();
	    automationImage.click();
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", automationImage);
        JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", automationImage);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", selectButton);
	   
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    previewButton2.click();
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Products")&& each.getText().contains("Reseller Demo")) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    
    	
    	
    	
    }
    
 public void setHideSitemap() throws Exception {
	    HelperFunctions.waitForPageToLoad(5);
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(5);
	    homepageDemo.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    properties.click();
	    HelperFunctions.waitForPageToLoad(5);
	    hidesitemapCheckbox.click();
	    HelperFunctions.staticWait(5);
	    saveAndClose.click();
	    HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(5);
        JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
        executor7.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(5);
        quickPublish.click();
  	    HelperFunctions.staticWait(5);
  	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();",  publish2);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
        executor11.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
        executor9.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        edit.click();
        ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs2.get(2));
        HelperFunctions.waitForPageToLoad(5);
        previewButton2.click();
	    String expectedContent="Homepage Demo";
	    for(WebElement eachContent: sitemapContents) {
	    	System.out.println(eachContent.getText());
	    	if(!eachContent.getText().contains(expectedContent)) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
    	
    	
    }
 
 public void setTilesAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 19));
	    HelperFunctions.waitForPageToLoad(5);
	   
		for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", legalTilesAuth);
        settingIcon.click();
        ArrayList<String> tabs5 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs5.get(1));
	    legalTilesAuthFirstCheckbox.click();
	    ArrayList<String> tabs6 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs6.get(1));
	    dataProcessingImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Data Processing Addendum")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", legalTilesAuth);
        settingIcon.click();
        ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs7.get(1));
	    legalTilesAuthFirstCheckbox.click();
	    ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs8.get(1));
	    maintenanceImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
	    
	    
	    
	    
 }
 
 public void setContentAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    offeringOverviewLink2auth.click();
	    settingIcon.click();
	    ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs7.get(1));
	    titleField.click();
	    titleField.clear();
	    titleField.sendKeys("test");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    Set<String> allWindows4=Driver.getDriver().getWindowHandles();
        List<String> windowsList4=new ArrayList<>(allWindows4);
        Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
	 String expectedTitle="test";
	 String actualTitle=contentTitle.getText();
	 Assert.assertEquals(expectedTitle, actualTitle);
	 Driver.getDriver().switchTo().defaultContent();
	 editButtonContent.click();
	 offeringOverviewLink2auth.click();
	 settingIcon.click();
	    ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs7.get(1));
	    titleField.click();
	    titleField.clear();
	    titleField.sendKeys("Offering Overview");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    Set<String> allWindows5=Driver.getDriver().getWindowHandles();
     List<String> windowsList5=new ArrayList<>(allWindows5);
     Driver.getDriver().switchTo().window(windowsList5.get(1));
     
     Driver.getDriver().switchTo().frame(0);
	 String expectedTitle2="Offering Overview";
	 String actualTitle2=contentTitle.getText();
	 Assert.assertEquals(expectedTitle2, actualTitle2);
	 HelperFunctions.staticWait(3);
	 
 
	    
	    
	    
	    
 }
 
 public void setHomepageTileAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 10));
	    HelperFunctions.waitForPageToLoad(5);
	    homepageTileauth.click();
	    settingIcon.click();
	    ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs7.get(1));
	    collapseHeader.click();
	    titleofTile.click();
	    titleofTile.clear();
	    titleofTile.sendKeys("Tile 1");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    Set<String> allWindows4=Driver.getDriver().getWindowHandles();
        List<String> windowsList4=new ArrayList<>(allWindows4);
        Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
	 String expectedTitle="Tile 1";
	 String actualTitle=firstTitleofTile.getText();
	 Assert.assertEquals(expectedTitle, actualTitle);
	 Driver.getDriver().switchTo().defaultContent();
	 editButtonContent.click();
	 homepageTileauth.click();
	    settingIcon.click();
	    ArrayList<String> tabs9 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs9.get(1));
	    collapseHeader.click();
	    titleofTile.click();
	    titleofTile.clear();
	    titleofTile.sendKeys("Legal");	
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    Set<String> allWindows5=Driver.getDriver().getWindowHandles();
     List<String> windowsList5=new ArrayList<>(allWindows5);
     Driver.getDriver().switchTo().window(windowsList5.get(1));
     
     Driver.getDriver().switchTo().frame(0);
	 String expectedTitle2="Legal";
	 String actualTitle2=firstTitleofTile.getText();
	 Assert.assertEquals(expectedTitle2, actualTitle2);
	 HelperFunctions.staticWait(3); 
	    
	    
	    
 }
 
 public void setDisplayingLogintomyProductLink() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
	    HelperFunctions.waitForPageToLoad(5);
	    
	    for(WebElement eachLink: loginToMyProductsLinks) {
	    	if(eachLink.getText().contains("Login to My Products")) {
	    		Assert.assertTrue(false);
	    	}else {
	    		Assert.assertTrue(true);
	    		logger.error("Login to My Products link is not displayed ");
	    	}
	    }
	    HelperFunctions.staticWait(3);
	 
	 
 }
 public void setUnpublishWorkflow() throws Exception {
 	
 	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(5);
	    resellerdemoImage.click();
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", resellerdemoImage);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", resellerdemoImage);
	    managePublication.click();
	    HelperFunctions.waitForPageToLoad(5);
	    unpublish.click();
	    HelperFunctions.waitForPageToLoad(5);
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", resellerdemoImageforUnpublish);
	    unpublishButton.click();
	    HelperFunctions.staticWait(3);
	    continueButton.click();
		    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs2.get(1));
		    Driver.getDriver().get(read1.getCellData("VALUE", 17));
		    HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
        executor7.executeScript("arguments[0].click();", resellerdemoImage);
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(eachInfo.getText().contains("Not published")) {
        		Assert.assertTrue(true);
        	}else {
        		Assert.assertTrue(false);
        		logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
        	}
        }
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();", resellerdemoImage);
        resellerDemo.click();
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
        executor9.executeScript("arguments[0].click();", checkinImg);
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(eachInfo.getText().contains("Not published")) {
        		Assert.assertTrue(true);
        	}else {
        		Assert.assertTrue(false);
        		logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
        	}
        }
        
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        publish2.click();
        JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
        executor10.executeScript("arguments[0].click();", checkinImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
        executor11.executeScript("arguments[0].click();", microsoftImg);
        JavascriptExecutor executor12 = (JavascriptExecutor) Driver.getDriver();
        executor12.executeScript("arguments[0].click();", microsoftImg);
        JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
        executor13.executeScript("arguments[0].click();", microsoftImg);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        JavascriptExecutor executor14 = (JavascriptExecutor) Driver.getDriver();
        executor14.executeScript("arguments[0].click();", microsoftImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
        executor15.executeScript("arguments[0].click();", dragosImg);
        JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
        executor16.executeScript("arguments[0].click();", dragosImg);
        JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
        executor17.executeScript("arguments[0].click();", dragosImg);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        JavascriptExecutor executor18 = (JavascriptExecutor) Driver.getDriver();
        executor18.executeScript("arguments[0].click();", dragosImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor19 = (JavascriptExecutor) Driver.getDriver();
        executor19.executeScript("arguments[0].click();", resellerdemoImage);
        JavascriptExecutor executor20 = (JavascriptExecutor) Driver.getDriver();
        executor20.executeScript("arguments[0].click();", resellerdemoImage);
        JavascriptExecutor executor21 = (JavascriptExecutor) Driver.getDriver();
        executor21.executeScript("arguments[0].click();", resellerdemoImage);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(!eachInfo.getText().contains("Not published")) {
        		Assert.assertTrue(true);
        	}else {
        		Assert.assertTrue(false);
        	}
        }
        
        HelperFunctions.staticWait(3);
	    
 }
 public void setUpdatedDate() throws Exception {
	 	
	 	read1.setExcelFile("./testdata.xlsx", "QA");
			email.sendKeys(read1.getCellData("DATA", 1));
			next.click();
			pass.sendKeys(read1.getCellData("VALUE", 1));
			submit.click();
		    HelperFunctions.staticWait(5);
		    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	     js.executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs.get(1));
		    Driver.getDriver().get(read1.getCellData("VALUE", 17));
		    HelperFunctions.waitForPageToLoad(5);
		    homepagedemoImg.click();
		    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	        executor1.executeScript("arguments[0].click();", homepagedemoImg);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", homepagedemoImg);
		    HelperFunctions.staticWait(3);
		    quickPublish.click();
		    HelperFunctions.staticWait(3);
		    publish2.click();
		    HelperFunctions.staticWait(3);
		    
		   
		      Calendar cal = Calendar.getInstance();
		      String month=new SimpleDateFormat("MMMMMMMMM").format(cal.getTime());
		      System.out.println(month);
		      String year=new SimpleDateFormat("YYYY").format(cal.getTime());
		      System.out.println(year);
		      String dayoftheweek=new SimpleDateFormat("EEEEE").format(cal.getTime());
		      System.out.println(dayoftheweek);
		      String dayoftheyear=new SimpleDateFormat("d").format(cal.getTime());
		      System.out.println(dayoftheyear);
		      String value = publishedDate.getAttribute("title");
		      System.out.println(value);
		      if(value.contains(month)&&value.contains(year)&&value.contains(dayoftheweek)&&value.contains(dayoftheyear)) {
		    	  Assert.assertTrue(true);
		      }else {
		    	  Assert.assertTrue(false);
		    	  logger.error("The date of publishing is NOT correct");
		      }
		     
		      HelperFunctions.staticWait(3);    
    
    
 }
 
 public void setUpdatedDateFromAssets() throws Exception {
	 
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/general/content-pdf");
	    HelperFunctions.waitForPageToLoad(5);
	    String originalDate = pdfDate.getAttribute("value");
        String desiredFormat = "MM/dd/yyyy";
        SimpleDateFormat originalSDF = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalSDF.parse(originalDate);
        SimpleDateFormat desiredSDF = new SimpleDateFormat(desiredFormat);
        String formattedDate = desiredSDF.format(date);
        System.out.println(formattedDate);
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
	    priceWaterPdf.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    System.out.println(lastUpdatedDate.getText());
	    String expectedDate=read1.getCellData("VALUE", 33);
	    Assert.assertEquals(lastUpdatedDate.getText(), expectedDate);
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().defaultContent();
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
        pdfTemplate.click();
        HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    String date2 = lastUpdatedDate.getText();
	    System.out.println(date2);
	    Assert.assertTrue(date2.contains(formattedDate));
	 /*read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
	    priceWaterPdf.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    System.out.println(lastUpdatedDate.getText());
	    String expectedDate=read1.getCellData("VALUE", 33);
	    Assert.assertEquals(lastUpdatedDate.getText(), expectedDate);
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().defaultContent();
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
        pdfTemplate.click();
        HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    System.out.println(lastUpdatedDate.getText());
	    System.out.println(lastUpdatedDate.getText().replace("/", "-"));
	    String expectedDate2=read1.getCellData("VALUE", 32);
	    Assert.assertEquals(lastUpdatedDate.getText(), expectedDate2);*/
	    HelperFunctions.staticWait(3);
	  
	    
 }
 public void setUpdatedDateFromAssets2() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/general/content-pdf");
	    HelperFunctions.waitForPageToLoad(5);
	  	    for(WebElement each: pdfInfo) {
	  	    	//System.out.println(each.getText());
	  	    	 
	  	    		for(WebElement each2:pdfInfo2) {
	  	    			if(each.getText().contains("PDF Template for AEM Testing")) {
	  	    				System.out.println(each2.getAttribute("value"));
	  	    				break;
	  	    			}
	  	    			
	  	    		}
	  	    	}
	  	    
	  	  HelperFunctions.staticWait(3);
	   // String expectedDate2="Last updated 01/09/2023";
	   // Assert.assertEquals(lastUpdatedDate.getText(), expectedDate2);
	    
 }
 public void setUpdatedDateVisibility() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(15);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    previewButton2.click();
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    if(lastUpdatedDate.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	 
	    HelperFunctions.staticWait(3);
	    
	    
	    
	    
 }
 public void setCatCombination() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 23));
	    HelperFunctions.waitForPageToLoad(5);
	    createButton.click();
	    pageButton.click();
	    contentPageTemplate.click();
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    titleField2.click();
	    titleField2.sendKeys("content 3");
	    productCentralTab.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
        executor1.executeScript("arguments[0].click();", documentCategoryTag2);
       
	    HelperFunctions.staticWait(3);
	    
	    firstOptionofDocCat.click();
	    HelperFunctions.staticWait(2);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", productFeatureTag2);
	    HelperFunctions.staticWait(2);
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", firstOptionofProCat);
	    HelperFunctions.staticWait(2);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", portfolioTag2);
	    HelperFunctions.staticWait(2);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", firstOptionofPortCat);
        HelperFunctions.staticWait(2);
        createButton2.click();
        HelperFunctions.staticWait(3);
        doneButton.click();
        HelperFunctions.staticWait(3);  
 }
 public void setReleaseNotes() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
	    HelperFunctions.waitForPageToLoad(5);
	    editButtonContent.click();
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(releaseNotes);
        HelperFunctions.staticWait(3);
        releaseNotes.click();
        HelperFunctions.staticWait(3);
        settingIcon.click();
        HelperFunctions.staticWait(3);
        String title="version1";
        releaseTitle.click();
        HelperFunctions.staticWait(2);
        releaseTitle.clear();
        releaseTitle.sendKeys(title);
        HelperFunctions.staticWait(3);
        releaseDate.click();
        releaseDate.clear();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        releaseDate.sendKeys(dateFormat.format(date));
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", releaseDescription);
        String description="some description";
        releaseDescription.clear();
        releaseDescription.sendKeys(description);
        HelperFunctions.staticWait(3);
        checkIcon.click();
        HelperFunctions.staticWait(3);
        previewButton2.click();
        HelperFunctions.staticWait(3);
        Driver.getDriver().switchTo().frame(0);
        HelperFunctions.scrollToElement(releaseTitleonPreview);
        HelperFunctions.staticWait(3);
        String actualDate=releaseDateonPreview.getText();
        String expectedDate=dateFormat.format(date);
        Assert.assertEquals(actualDate, expectedDate);
        HelperFunctions.staticWait(3);
        String actualTitle=releaseTitleonPreview.getText();
        String expectedTitle=title;
        Assert.assertEquals(actualTitle, expectedTitle);
        HelperFunctions.staticWait(3);
        String actualDescription=releaseDescriptiononPreview.getText();
        String expectedDescription=description;
        Assert.assertEquals(actualDescription,expectedDescription);
        HelperFunctions.staticWait(3);
        
        
	   
	    
 }
 public void setAuthFooter() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1)); 
		submit.click();
	    HelperFunctions.staticWait(15);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 27)); */
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.scrollToElement(authFooter); 
        HelperFunctions.staticWait(3); 
        HelperFunctions.scrollToElement(authFooter); 
	    HelperFunctions.staticWait(3);
	    authFooter.click();
	    HelperFunctions.staticWait(3);
	    settingIcon.click();
	    HelperFunctions.staticWait(3);
	    textareaForFooter.click();
	    HelperFunctions.staticWait(2);
	    textareaForFooter.clear();
	    String mockFooter=read1.getCellData("VALUE", 40);
	    textareaForFooter.sendKeys(mockFooter);
	    HelperFunctions.staticWait(3);
	    privacyPolicyTitle.click();
	    HelperFunctions.staticWait(2);
	    privacyPolicyTitle.clear();
	    privacyPolicyTitle.sendKeys("Privacy policy");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    publishTemplate.click();
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(unpublishButton);
	    wait.until(condition);
	    unpublishButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(5);
	    Driver.getDriver().navigate().refresh();
	    HelperFunctions.waitForPageToLoad(5);
	    
	  	   // ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  	   // Driver.getDriver().switchTo().window(tabs2.get(1));
	  	    Driver.getDriver().get(read1.getCellData("VALUE", 41));
	  	    HelperFunctions.waitForPageToLoad(5);
	  	    fluidForecast.click();
	  	  HelperFunctions.staticWait(3);
	  	   JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	        executor1.executeScript("arguments[0].click();", fluidForecast);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", fluidForecast);
	  	  HelperFunctions.staticWait(3);
	  	  quickPublish2.click();
	  	 HelperFunctions.staticWait(3);
	  	 publish2.click();
	  	 HelperFunctions.staticWait(3);
		  	   // ArrayList<String> tabs3 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	   // Driver.getDriver().switchTo().window(tabs3.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
		  	    HelperFunctions.waitForPageToLoad(5);
		  	  previewButton.click();
		  	Driver.getDriver().switchTo().frame(0);
		  	HelperFunctions.scrollToElement(footerContent); 
	        HelperFunctions.staticWait(3);
	        HelperFunctions.scrollToElement(footerContent); 
	        //HelperFunctions.staticWait(2);
	      /*  Assert.assertTrue(footerContent2.getText().contains(mockFooter));
	        HelperFunctions.staticWait(3);
	 
		  	   // ArrayList<String> tabs4 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	   // Driver.getDriver().switchTo().window(tabs4.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 27));
		  	    HelperFunctions.waitForPageToLoad(5);
		  	    HelperFunctions.scrollToElement(authFooter);
		        HelperFunctions.staticWait(3);
		        HelperFunctions.scrollToElement(authFooter);  
			    HelperFunctions.staticWait(3);
			    authFooter.click();
			    HelperFunctions.staticWait(3);
			    settingIcon.click();
			    HelperFunctions.staticWait(3);
			    textareaForFooter.click();
			    textareaForFooter.clear();
			    String footer=read1.getCellData("VALUE", 31);
			    textareaForFooter.sendKeys(footer);
			    HelperFunctions.staticWait(3);
			    checkIcon.click();
			    HelperFunctions.staticWait(3);
			    pageInfo.click();
			    HelperFunctions.staticWait(3);
			    publishTemplate.click();
			    HelperFunctions.staticWait(3);
			    unpublishButton.click();
			    HelperFunctions.staticWait(5);*/
	        
	        HelperFunctions.staticWait(3);
	    
	    
	    
	    
 
 
 
 }
 
 public void setNeedTechnicalSupport() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
	    HelperFunctions.waitForPageToLoad(5);
	    
	    
 
 
 
 }
 public void setUnpublishWorkflow2() throws Exception {
	 	
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    //HelperFunctions.waitForPageToLoad(5);
	   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(legalPageImg);
	    //wait.until(condition);
	   try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
    executor1.executeScript("arguments[0].click();", legalPageImg);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
    executor2.executeScript("arguments[0].click();", legalPageImg);
	    HelperFunctions.staticWait(3);
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown));
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(unpublishWorkflow)); 
	    unpublishWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2);
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    wait.until(ExpectedConditions.visibilityOf(legalPageImgforPublish));
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    createButton2.click();
	    wait.until(ExpectedConditions.visibilityOf(legalPageImg));
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    executor2.executeScript("arguments[0].click();", legalPageImg);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    executor2.executeScript("arguments[0].click();", legalPageImg);
	    HelperFunctions.staticWait(5);
    System.out.println(unpublishInfo.getText());
    if(unpublishInfo.getText().contains("Not published")) {
    	Assert.assertTrue(true);
    }else {
	    	String errorMessage = "Page is not unpublished";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
   // legalPageImg.click();
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
 executor5.executeScript("arguments[0].click();", legalPageImg);
 try {
 	Thread.sleep(3000);
 }catch(InterruptedException e) {
 	e.printStackTrace();
 }
 JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
 executor6.executeScript("arguments[0].click();", legalPageImg);
    HelperFunctions.staticWait(2);
    quickPublish2.click();
    wait.until(ExpectedConditions.visibilityOf(publish2));
    publish2.click();
    HelperFunctions.staticWait(3);
}
 public void setExpressWorkflowApproval() throws Exception {
	// HelperFunctions.waitForPageToLoad(5);
   //  Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(legalPageImg);
	    //wait.until(condition);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", legalPageImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
  executor2.executeScript("arguments[0].click();", legalPageImg);
	    HelperFunctions.staticWait(3);
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown)); 
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(publishWorkflow));
	    publishWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2);
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    wait.until(ExpectedConditions.visibilityOf(legalPageImgforPublish));
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    createButton2.click();
	    HelperFunctions.waitForPageToLoad(90);
	    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(legalPageImg);
	    //wait2.until(condition2);
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
  executor3.executeScript("arguments[0].click();", legalPageImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
  executor4.executeScript("arguments[0].click();", legalPageImg);
  HelperFunctions.staticWait(3);
  if(presentationDate.getText().equalsIgnoreCase("a few seconds ago")) {
  	Assert.assertTrue(true);
  }else {
	    	String errorMessage = "Not publish on workflow option";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
  HelperFunctions.staticWait(3);
}
 public void setWorkflowApproval2() throws Exception {
	 //HelperFunctions.waitForPageToLoad(5);
     //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    //HelperFunctions.waitForPageToLoad(5);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(legalPageImg);
	    //wait.until(condition);
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    } 
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", legalPageImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
  executor2.executeScript("arguments[0].click();", legalPageImg);
	    HelperFunctions.staticWait(3);
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown));
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(publishWorkflow)); 
	    publishWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2);
	    workflowTitle.sendKeys("testing");
	    HelperFunctions.staticWait(2); 
	    workflowTitle.clear();
	    HelperFunctions.staticWait(2);
	    if(nextButton.getAttribute("disabled")==null) {
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Next button is clickable with empty Workflow titles which is mandatory";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
	    wait.until(ExpectedConditions.visibilityOf(errorMessage));
	    if(errorMessage.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Workflow title is not mandatory";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
	    HelperFunctions.staticWait(3);
    
}
 public void setWorkflowApproval() throws Exception {
	 	
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    //HelperFunctions.waitForPageToLoad(5);
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable( legalPageImg);
	    //wait.until(condition);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    legalPageImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", legalPageImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
  executor2.executeScript("arguments[0].click();", legalPageImg);
	    HelperFunctions.staticWait(3);
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown)); 
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(publishWorkflow));  
	    publishWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2);
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    wait.until(ExpectedConditions.visibilityOf(legalPageImgforPublish)); 
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    createButton2.click();
	    HelperFunctions.waitForPageToLoad(30);
	    wait.until(ExpectedConditions.visibilityOf(legalPageImg)); 
	    legalPageImg.click();
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	   
  executor3.executeScript("arguments[0].click();", legalPageImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
  executor4.executeScript("arguments[0].click();", legalPageImg);
  HelperFunctions.staticWait(3);
  if(presentationDate.getText().contains("few")) {
  	Assert.assertTrue(true);
  }else {
	    	String errorMessage = "Not publish on workflow option";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
  HelperFunctions.staticWait(3);
}
 public void set403Image() throws Exception {
	// HelperFunctions.waitForPageToLoad(5);
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/403---forbidden-access.html");
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   imgPath.click();
	   HelperFunctions.staticWait(2);
	   configure.click();
	   HelperFunctions.staticWait(2);
	   pick.click();
	   HelperFunctions.staticWait(2);
	   pathforImage.click();
	   HelperFunctions.staticWait(2);
	   pathforImage1.click();
	   HelperFunctions.staticWait(2);
	   pathforImage2.click();
	   HelperFunctions.staticWait(2);
	   pathforImage3.click();
	   HelperFunctions.staticWait(2);
	   img404.click();
	   HelperFunctions.staticWait(2);
	   selectButton.click();
	   HelperFunctions.staticWait(3);
	   checkIcon.click();
	   HelperFunctions.staticWait(2);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(2);
	   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/403---forbidden-access.html");
	   HelperFunctions.waitForPageToLoad(5);
	   HelperFunctions.staticWait(2);
	   Assert.assertTrue(errorImg404.isDisplayed());
	   HelperFunctions.staticWait(3);
}
 public void set403Title() throws Exception {
	 	
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/403---forbidden-access.html");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait.until(condition);
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(3);
	   titleEdit403.click();
	   wait.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(titleEdit));
	  titleEdit.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.clear();
	  HelperFunctions.staticWait(2);
	  titleEdit.sendKeys("403 - Forbidden Acce");
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  // propertiesIcon.click();
	  // HelperFunctions.staticWait(2);
	  // publishIcon.click();
	  // HelperFunctions.staticWait(2);
	  // Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/403---forbidden-access.html");
	   //HelperFunctions.waitForPageToLoad(5);
	  // HelperFunctions.staticWait(2);
	  previewButton.click();
	  Driver.getDriver().switchTo().frame(0);
	  HelperFunctions.staticWait(3);
	   Assert.assertTrue(errorTitle.getText().equalsIgnoreCase("403 - Forbidden Acce"));
	   HelperFunctions.staticWait(3);
	  // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/403---forbidden-access.html");
	  // HelperFunctions.waitForPageToLoad(5);
	   Driver.getDriver().switchTo().defaultContent();
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait2.until(condition2);
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   titleEdit403.click();
	   wait2.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(titleEdit));
	  titleEdit.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.clear();
	  HelperFunctions.staticWait(2);
	  titleEdit.sendKeys("403 - Forbidden Access");
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  //HelperFunctions.staticWait(2);
	  // propertiesIcon.click();
	   //wait3.until(ExpectedConditions.visibilityOf(publishIcon));
	   //publishIcon.click();
	   HelperFunctions.staticWait(7);
}
 public void set403Description() throws Exception {
	// HelperFunctions.waitForPageToLoad(5);
   //  Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/403---forbidden-access.html");
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   descEdit403.click();
	   wait.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(descEditField));
	  descEditField.click();
	  HelperFunctions.staticWait(2);
	  descEditField.clear();
	  HelperFunctions.staticWait(2);
	  descEditField.sendKeys("403");
	  String actual="403: You do not have access to this page. Please contact our support team for further assistance. (Link to service now where user can submit a ticket)";
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  previewButton.click();
	  Driver.getDriver().switchTo().frame(0);
	  HelperFunctions.staticWait(3);
	   Assert.assertTrue(errorDecsription.getText().equalsIgnoreCase("403"));
	   HelperFunctions.staticWait(3);
	   Driver.getDriver().switchTo().defaultContent();
	  // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/403---forbidden-access.html");
	  // HelperFunctions.waitForPageToLoad(5);
	   WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
	    //wait2.until(condition2);
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   descEdit403.click();
	   wait2.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(descEditField));
	  descEditField.click();
	  HelperFunctions.staticWait(2);
	  descEditField.clear();
	  HelperFunctions.staticWait(2);
	  descEditField.sendKeys(actual);
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  //HelperFunctions.staticWait(2);
	   //propertiesIcon.click();
	   //wait3.until(ExpectedConditions.visibilityOf(publishIcon));
	   //publishIcon.click();
	   HelperFunctions.staticWait(7);
}
 public void set403Visibility() throws Exception {
	 	
   
	 //WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(previewButton);
	   //wait1.until(condition1);
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	 try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   previewButton.click();
	   Driver.getDriver().switchTo().frame(0);
	   //Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/403---forbidden-access.html");
	   //HelperFunctions.waitForPageToLoad(5);
	   HelperFunctions.staticWait(2);
	   Assert.assertTrue(errorImg.isDisplayed()&&errorDecsription.isDisplayed()&&errorTitle.isDisplayed());
	   HelperFunctions.staticWait(3);
}
 public void set500Title() throws Exception {
	 	
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/500-error.html");
	   HelperFunctions.waitForPageToLoad(5);
	   JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   titleEdit403.click();
	  HelperFunctions.staticWait(2);
	  configure.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.clear();
	  HelperFunctions.staticWait(2);
	  titleEdit.sendKeys("500 - Internal Server Err");
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  HelperFunctions.staticWait(2);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(2);
	   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/500-error.html");
	   HelperFunctions.waitForPageToLoad(30);
	   HelperFunctions.staticWait(2);
	   Assert.assertTrue(errorTitle.getText().equalsIgnoreCase("500 - Internal Server Err"));
	   HelperFunctions.staticWait(1);
	   Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/500-error.html");
	   HelperFunctions.waitForPageToLoad(60);
	   WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
	   // wait2.until(condition2);
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   titleEdit403.click();
	  HelperFunctions.staticWait(2);
	  configure.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.click();
	  HelperFunctions.staticWait(2);
	  titleEdit.clear();
	  HelperFunctions.staticWait(2);
	  titleEdit.sendKeys("500 - Internal Server Error");
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  HelperFunctions.staticWait(2);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(3);
}
 public void set500Description() throws Exception {
	// HelperFunctions.waitForPageToLoad(5);
    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/500-error.html");
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   descEdit403.click();
	  HelperFunctions.staticWait(3);
	  configure.click();
	  HelperFunctions.staticWait(3);
	  descEditField.click();
	  HelperFunctions.staticWait(3);
	  descEditField.clear();
	  HelperFunctions.staticWait(2);
	  descEditField.sendKeys("500");
	  String actual="500: Internal server error. If you are looking for information about PwC products, please visit here to learn more.";
	  HelperFunctions.staticWait(3);
	  checkIcon.click();
	  HelperFunctions.staticWait(2);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(2);
	   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/500-error.html");
	   HelperFunctions.waitForPageToLoad(60);
	   HelperFunctions.staticWait(5);
	   Assert.assertTrue(errorDecsription.getText().equalsIgnoreCase("500"));
	   HelperFunctions.staticWait(3);
	   Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/500-error.html");
	   HelperFunctions.waitForPageToLoad(60);
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(3);
	   descEdit403.click();
	  HelperFunctions.staticWait(3);
	  configure.click();
	  HelperFunctions.staticWait(3);
	  descEditField.click();
	  HelperFunctions.staticWait(3);
	  descEditField.clear();
	  HelperFunctions.staticWait(2);
	  descEditField.sendKeys(actual);
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  HelperFunctions.staticWait(3);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(3);
	   publishIcon.click();
	   HelperFunctions.staticWait(3);
}
 public void setReleaseNotes2() throws Exception {
	    HelperFunctions.waitForPageToLoad(5);
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/transparency-hub.html");
	  //  HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    editButtonContent.click();
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(releaseNotes);
     HelperFunctions.staticWait(3);
     releaseNotes.click();
     HelperFunctions.staticWait(3);
     settingIcon.click();
     HelperFunctions.staticWait(2);
     HelperFunctions.scrollToElement(add);
     HelperFunctions.staticWait(2);
     add.click();
     HelperFunctions.staticWait(2);
     Assert.assertTrue(alert.isDisplayed());
     HelperFunctions.staticWait(3);
               	   
	    
}
public void setHomeImage() throws Exception {
	 	
   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   wait.until(ExpectedConditions.visibilityOf(homeImage));
   homeImage.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(pick));
   pick.click();
   wait.until(ExpectedConditions.visibilityOf(pathforImage));
   pathforImage.click();
   wait.until(ExpectedConditions.visibilityOf(pathforImage1));
   pathforImage1.click();
   wait.until(ExpectedConditions.visibilityOf(pathImage));
   pathImage.click();
   HelperFunctions.staticWait(2);
   selectButton.click();
   HelperFunctions.staticWait(3);
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   previewButton.click();
   HelperFunctions.staticWait(2);
   Driver.getDriver().switchTo().frame(0);
   HelperFunctions.staticWait(2);
   //Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/homepage-demo.html");
   //HelperFunctions.waitForPageToLoad(5);
   String image1=homePublishImage.getAttribute("src");
   Driver.getDriver().switchTo().defaultContent();
   
   //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
   //HelperFunctions.waitForPageToLoad(5);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   editButtonContent.click();
   wait.until(ExpectedConditions.visibilityOf(homeImage));
homeImage.click();
wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(pick));
   pick.click();
   wait.until(ExpectedConditions.visibilityOf(pathforImage));
   pathforImage.click();
   wait.until(ExpectedConditions.visibilityOf(pathforImage1));
   pathforImage1.click();
   wait.until(ExpectedConditions.visibilityOf(homeImagePath));
   homeImagePath.click();
   HelperFunctions.staticWait(2);
   selectButton.click();
   HelperFunctions.staticWait(3);
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   //propertiesIcon.click();
   //HelperFunctions.staticWait(2);
  // publishIcon.click();
   //HelperFunctions.staticWait(2);
   //Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/homepage-demo.html");
   previewButton.click();
   HelperFunctions.staticWait(2);
   Driver.getDriver().switchTo().frame(0);
   HelperFunctions.staticWait(2);
   String image2=homePublishImage.getAttribute("src");
   Assert.assertTrue(!image1.equals(image2));
   HelperFunctions.staticWait(3);
}
public void setHomeDescription() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
	   HelperFunctions.waitForPageToLoad(5);
	   JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
  homeImage.click();
	   HelperFunctions.staticWait(2);
	   configure.click();
	   HelperFunctions.staticWait(2);
	   textButton.click();
	   HelperFunctions.staticWait(2);
	   textDescription.click();
	   HelperFunctions.staticWait(2);
	   textDescription.clear();
	   HelperFunctions.staticWait(2);
	   textDescription.sendKeys("hdfgjhdfgj"); 
	   HelperFunctions.staticWait(2);
	   checkIcon.click();
	   HelperFunctions.staticWait(5);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(5);
	   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/homepage-demo.html");
	   HelperFunctions.waitForPageToLoad(60);
	   String description1=heroDescription.getText();
	   Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
	   HelperFunctions.waitForPageToLoad(60);
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
  homeImage.click();
	   HelperFunctions.staticWait(2);
	   configure.click();
	   HelperFunctions.staticWait(2);
	   textButton.click();
	   HelperFunctions.staticWait(2);
	   textDescription.click();
	   HelperFunctions.staticWait(2);
	   textDescription.clear();
	   HelperFunctions.staticWait(2);
	   textDescription.sendKeys("PwC's home for information on legal terms & conditions, security, and compliance for our licensed products."); 
	   HelperFunctions.staticWait(2);
	   checkIcon.click();
	   HelperFunctions.staticWait(5);
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(5);
	   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/homepage-demo.html");
	   HelperFunctions.waitForPageToLoad(60);
	   String description2=heroDescription.getText();
	   Assert.assertTrue(!description1.equals(description2));
	   HelperFunctions.staticWait(3);
}
public void setPrivacyHubWorkflow() throws Exception {
	// HelperFunctions.waitForPageToLoad(5);
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    try {
    	Thread.sleep(5000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    privacyImg.click();
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
executor1.executeScript("arguments[0].click();", privacyImg);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
executor2.executeScript("arguments[0].click();", privacyImg);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
    createButton3.click();
    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
    workflowIcon.click();
    wait.until(ExpectedConditions.visibilityOf(workflowDropdown));
    workflowDropdown.click();
    wait.until(ExpectedConditions.visibilityOf(workflowOptions.get(0)));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(workflowOptions.stream().anyMatch(option -> option.getText().contains("Express Publish")));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(workflowOptions.stream().anyMatch(option -> option.getText().contains("Express Unpublish")));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(workflowOptions.stream().anyMatch(option -> option.getText().contains("Approval Workflow")));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(workflowOptions.stream().anyMatch(option -> option.getText().contains("Unpublish Approval Workflow")));
    HelperFunctions.staticWait(3);
}
public void setFAQAccordion() throws Exception {
	//   HelperFunctions.waitForPageToLoad(5);
   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editAccordion.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(collapsableHeader));
   collapsableHeader.click();
   HelperFunctions.staticWait(1);
   Assert.assertTrue(collapsableHeader.getAttribute("aria-expanded").contains("true"));
   HelperFunctions.staticWait(3);
	  
}
public void setFAQAddLinks() throws Exception {
	  // HelperFunctions.waitForPageToLoad(5);
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editAccordion.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(collapsableHeader));
   collapsableHeader.click();
   HelperFunctions.staticWait(3);
   faqAnswer.click();
   Assert.assertTrue(faqAnswer.getAttribute("value")!=null);
   Assert.assertTrue(faqHref.isDisplayed());
   HelperFunctions.staticWait(3);
}
public void setFAQEditableAreas() throws Exception {
	 //  HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editAccordion.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(collapsableHeader));
   collapsableHeader.click();
   HelperFunctions.staticWait(3);
   Assert.assertTrue(faqQuestionField.isEnabled());
   Assert.assertTrue(faqAnswerField.isEnabled());
   HelperFunctions.staticWait(5);
}
public void setPrivacyHucHeadingStyle() throws Exception {
	  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editPrivacy.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(font));
   font.click();
   HelperFunctions.staticWait(3);
   for(WebElement each:fontOptions) {
	   if(each.getText().contains("H6")) {
		   each.click();
	   }
   }
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   previewButton.click();
   HelperFunctions.staticWait(2);
   Driver.getDriver().switchTo().frame(0);
   Assert.assertTrue(privacyTitle2.isDisplayed());
   Driver.getDriver().switchTo().defaultContent();
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editPrivacy.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(font));
   font.click();
   HelperFunctions.staticWait(3);
   for(WebElement each:fontOptions) {
	   if(each.getText().contains("H1")) {
		   each.click();
	   }
   }
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   previewButton.click();
   HelperFunctions.staticWait(2);
   Driver.getDriver().switchTo().frame(0);
   Assert.assertTrue(privacyTitle1.isDisplayed());
   HelperFunctions.staticWait(3);
}
public void setPrivacyHubInline() throws Exception {
	   //HelperFunctions.waitForPageToLoad(5);
Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/privacy-hub.html");
	   HelperFunctions.waitForPageToLoad(20);
	   WebElement inline=privacyTitle1.findElement(By.tagName("a"));
	   Assert.assertTrue(inline.isDisplayed());
	   HelperFunctions.staticWait(3);

}
public void setPrivacyHubBody() throws Exception {
	//   HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editText.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(textArea));
   textArea.click();
   wait.until(ExpectedConditions.visibilityOf(privacyEditTable));
   Assert.assertTrue(privacyEditTable.isDisplayed());
   Assert.assertTrue(privacyEditHyperlink.isDisplayed());
   Assert.assertTrue(privacyEditText.isDisplayed());
   HelperFunctions.staticWait(3);

}
public void setPrivacyHubPublishingDate() throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	  WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	  try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    privacyHubImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
executor1.executeScript("arguments[0].click();", privacyHubImg);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
executor2.executeScript("arguments[0].click();", privacyHubImg);
	    HelperFunctions.staticWait(3);
	    quickPublish2.click();
	    wait.until(ExpectedConditions.visibilityOf(publish2));
   publish2.click();
   HelperFunctions.staticWait(5);
   
if(presentationDate.getText().contains("few")) {
	Assert.assertTrue(true);
	    }
HelperFunctions.staticWait(3);
}
public void setExpressUnpublishWorkflow() throws Exception {
	 	
//  Driver.getDriver().navigate().to("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    homepageDemo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
executor1.executeScript("arguments[0].click();", homepageDemo);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
executor2.executeScript("arguments[0].click();", homepageDemo);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown));
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(unpublishWorkflow));
	    unpublishWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2);
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    wait.until(ExpectedConditions.visibilityOf(legalPageImgforPublish));
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    createButton2.click();
	    wait.until(ExpectedConditions.visibilityOf(homepageDemo));
	    homepageDemo.click();
	    try {
	      	Thread.sleep(3000);
	      }catch(InterruptedException e) {
	      	e.printStackTrace();
	      }
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	    executor3.executeScript("arguments[0].click();", homepageDemo);
	    try {
	      	Thread.sleep(3000);
	      }catch(InterruptedException e) {
	      	e.printStackTrace();
	      }
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
	    executor4.executeScript("arguments[0].click();", homepageDemo);
	    try {
	      	Thread.sleep(3000);
	      }catch(InterruptedException e) {
	      	e.printStackTrace();
	      }
	    executor4.executeScript("arguments[0].click();", homepageDemo);
	    try {
	      	Thread.sleep(3000);
	      }catch(InterruptedException e) {
	      	e.printStackTrace();
	      }
	    executor4.executeScript("arguments[0].click();", homepageDemo);
wait.until(ExpectedConditions.visibilityOf(notPublishedText));
if(notPublishedText.getText().equalsIgnoreCase("Not published")) {
	Assert.assertTrue(true);
}else {
	    	String errorMessage = "Not publish does not appear";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
HelperFunctions.staticWait(2);
quickPublish.click();
wait.until(ExpectedConditions.visibilityOf(publish2));
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
executor6.executeScript("arguments[0].click();",  publish2);
HelperFunctions.staticWait(3);
}
public void setExpressOptions() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    homepageDemo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
executor1.executeScript("arguments[0].click();", homepageDemo);
HelperFunctions.staticWait(3);
JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
executor2.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    createButton3.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(workflowDropdown));
	    workflowDropdown.click();
	    wait.until(ExpectedConditions.visibilityOf(publishWorkflow));
	    if(publishWorkflow.isDisplayed()&&unpublishWorkflow.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Express options do not appear in the dropdown";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	    }
	    
HelperFunctions.staticWait(3);
}
public void setCreateLegalPage() throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation/legal");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    createButton.click();
	    HelperFunctions.staticWait(2);
	    pageButton.click();
	    HelperFunctions.waitForPageToLoad(30);
	    wait.until(ExpectedConditions.visibilityOf(legalPageTemplate));
	    legalPageTemplate.click();
	    HelperFunctions.staticWait(2);
nextButton.click();
	HelperFunctions.waitForPageToLoad(60);
	titleField2.click();
	HelperFunctions.staticWait(2);
	titleField2.sendKeys("Accessibility");
	HelperFunctions.staticWait(2);
	productCentralTab.click();
	wait.until(ExpectedConditions.visibilityOf(documentCategoryTag2));
	 JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", documentCategoryTag2);
	 HelperFunctions.staticWait(2);
	documentCategoryTag.get(1).click();
	 HelperFunctions.staticWait(3);
	    createPage.click();
	    HelperFunctions.staticWait(2); 
	    doneButton2.click();
	    HelperFunctions.waitForPageToLoad(30);
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation/legal");
	  //  HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2); 
	    accessImg.click();
	    HelperFunctions.staticWait(3); 
	    //HelperFunctions.staticWait(2);
	    delete.click();
	    wait.until(ExpectedConditions.visibilityOf(delete2));
	    delete2.click();
	    HelperFunctions.staticWait(5);
}
public void setEditHeroDescription() throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/listen-platform.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   heroEdit.click();
	  HelperFunctions.staticWait(2);
	  configure.click();
	  HelperFunctions.staticWait(2);
	  heroEditDesc.click();
	  HelperFunctions.staticWait(2);
	  heroEditDesc.clear();
	  HelperFunctions.staticWait(2);
	  String expected="some";
	  heroEditDesc.sendKeys(expected);
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  previewButton.click();
	  HelperFunctions.staticWait(2);
	  Driver.getDriver().switchTo().frame(0);
	  String actual=productDescription.getText();
	  Assert.assertEquals(expected, actual);
	  HelperFunctions.staticWait(2);
	  Driver.getDriver().switchTo().defaultContent();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  editButtonContent.click();
	   HelperFunctions.staticWait(2);
	   heroEdit.click();
	  HelperFunctions.staticWait(2);
	  configure.click();
	  HelperFunctions.staticWait(2);
	  heroEditDesc.click();
	  HelperFunctions.staticWait(2);
	  heroEditDesc.clear();
	  HelperFunctions.staticWait(2);
	  String expected2="some description";
	  heroEditDesc.sendKeys(expected2);
	  HelperFunctions.staticWait(2);
	  checkIcon.click();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  previewButton.click();
	  HelperFunctions.staticWait(2);
	  Driver.getDriver().switchTo().frame(0);
	  String actual2=productDescription.getText();
	  Assert.assertEquals(expected2, actual2);
	  Driver.getDriver().switchTo().defaultContent();
	   propertiesIcon.click();
	   HelperFunctions.staticWait(2);
	   publishIcon.click();
	   HelperFunctions.staticWait(3);
	  
}
public void setDefineLinkforMyProducts() throws Exception {
	 	
  // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
  editButtonContent.click();
  wait.until(ExpectedConditions.visibilityOf(homeImage));
  homeImage.click();
  wait.until(ExpectedConditions.visibilityOf(configure));
  configure.click();
  wait.until(ExpectedConditions.visibilityOf(calltoAction));
  calltoAction.click();
  wait.until(ExpectedConditions.visibilityOf(selectPath));
  selectPath.click();
  wait.until(ExpectedConditions.visibilityOf(myproductPath));
  myproductPath.click();
  HelperFunctions.staticWait(2);
  selectButton.click();
  wait.until(ExpectedConditions.visibilityOf(checkButton));
  checkButton.click();
  try {
  	Thread.sleep(10000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  js.executeScript("arguments[0].click();", pageInfo);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  previewButton.click();
  HelperFunctions.staticWait(2);
  Driver.getDriver().switchTo().frame(0);
  wait.until(ExpectedConditions.visibilityOf(actionContainer));
  Assert.assertTrue(actionContainer.getAttribute("href").contains("my-products"));
  HelperFunctions.staticWait(3);

	  
}
public void setEditTechnicalSupport() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/listen-platform.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	   editButtonContent.click();
	   HelperFunctions.staticWait(2);
	  // Driver.getDriver().switchTo().frame(0);
	   HelperFunctions.scrollToElement(tsEdit);
	   HelperFunctions.staticWait(2);
	   tsEdit.click();
	   wait.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  wait.until(ExpectedConditions.visibilityOf(tsTitle));
	  Assert.assertTrue(tsTitle.isDisplayed()&&tsTitle.isEnabled());
	  Assert.assertTrue(tsDescription.isDisplayed()&&tsDescription.isEnabled());
	  HelperFunctions.staticWait(3);

	  
}
public void setPreviewButton2() throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/homepage-demo.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	  editButtonContent.click();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  previewButton.click();
	  HelperFunctions.staticWait(2);
	  Driver.getDriver().switchTo().frame(0);
	  Assert.assertTrue(actionContainer.isDisplayed());
	  HelperFunctions.staticWait(3);

	  
}
public void setUnpublishWorkflowApproval() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(securityImg);
	    //wait.until(condition);
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    securityImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", securityImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
  executor2.executeScript("arguments[0].click();", securityImg);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
	    createButton3.click();
	    HelperFunctions.staticWait(3);
	    workflowIcon.click();
	    HelperFunctions.staticWait(3); 
	    workflowDropdown.click();
	    HelperFunctions.staticWait(3); 
	    unpublishApproval.click();
	    HelperFunctions.staticWait(3); 
	    workflowTitle.click();
	    HelperFunctions.staticWait(2); 
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    HelperFunctions.staticWait(3);
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    createButton2.click();
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2);
	    bellIcon.click();
	    HelperFunctions.staticWait(2);
	    AEMInbox.click();
	    HelperFunctions.waitForPageToLoad(30);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(firstTasktime.getText().contains("few"));
	    HelperFunctions.staticWait(3);
}
public void setUnpublishWorkflowApproval2() throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(bellIcon);
	    //wait.until(condition);
	   try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    bellIcon.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    AEMInbox.click();
	    HelperFunctions.waitForPageToLoad(60);
	    wait.until(ExpectedConditions.visibilityOf(assignedTask));
	    assignedTask.click();
	    HelperFunctions.staticWait(2);
	    completeButton2.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(contentHeader.isDisplayed());
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    HelperFunctions.waitForPageToLoad(60);
	    //HelperFunctions.staticWait(2);
	    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(securityImg);
	    //wait2.until(condition2);
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    securityImg.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
 executor1.executeScript("arguments[0].click();", securityImg);
 try {
 	Thread.sleep(3000);
 }catch(InterruptedException e) {
 	e.printStackTrace();
 }
 JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
 executor2.executeScript("arguments[0].click();", securityImg);
 HelperFunctions.staticWait(3);
 quickPublish.click();
 wait.until(ExpectedConditions.visibilityOf(publish2));
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
 executor6.executeScript("arguments[0].click();",  publish2);
 HelperFunctions.staticWait(3);
}
public void setAssetsDate() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/en_us/products/enterprise-control/myproducts");
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2);
	    List<WebElement> timeElements = Driver.getDriver().findElements(By.tagName("foundation-time"));
	    LocalDateTime maxDateTime = null;
	    String maxTitle = null;
	    for (WebElement timeElement : timeElements) {
         String valueAttr = timeElement.getAttribute("value");
	        LocalDateTime dateTime = LocalDateTime.parse(valueAttr, DateTimeFormatter.ISO_DATE_TIME);
	        if (maxDateTime == null || dateTime.isAfter(maxDateTime)) {
	            maxDateTime = dateTime;
	            maxTitle = timeElement.findElement(By.xpath("./ancestor::coral-card")).findElement(By.className("coral3-Card-title")).getText();
	        }
	    }
	    System.out.println("Most recent title: " + maxTitle);
  HelperFunctions.staticWait(2);
  Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/enterprise-control.html");
  HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2);
	  previewButton.click();
	  Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2);
	    HelperFunctions.scrollToElement(resource1);
	    HelperFunctions.staticWait(2);
	    String resourceTitle=resource1.getText();
	    Assert.assertEquals(maxTitle, resourceTitle);
	    HelperFunctions.staticWait(3);
}

public void setReorderTiles() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/products/cloud.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	  previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		  HelperFunctions.staticWait(2);
	  Assert.assertTrue(firstProductTile.getText().contains("Offering"));
	  HelperFunctions.staticWait(2);
	  Driver.getDriver().switchTo().defaultContent();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  editButtonContent.click();
	  HelperFunctions.staticWait(2);
	  editTiles.click();
	  wait.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  wait.until(ExpectedConditions.visibilityOf(drag1));
	  Actions builder = new Actions(Driver.getDriver());
	builder.dragAndDrop(drag1, drag2).build().perform();
	HelperFunctions.staticWait(2);
	checkIcon.click();
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	 previewButton.click();
	Driver.getDriver().switchTo().frame(0);
	  HelperFunctions.staticWait(2);
	  Assert.assertTrue(firstProductTile.getText().contains("Terms"));
	  Driver.getDriver().switchTo().defaultContent();
	  try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	  editButtonContent.click();
	  HelperFunctions.staticWait(2);
	  editTiles.click();
	  wait.until(ExpectedConditions.visibilityOf(configure));
	  configure.click();
	  wait.until(ExpectedConditions.visibilityOf(drag1));
	  Actions builder2 = new Actions(Driver.getDriver());
	builder2.dragAndDrop(drag1, drag2).build().perform();
	HelperFunctions.staticWait(2);
	checkIcon.click();
	HelperFunctions.staticWait(5);

	  
}
public void setPublishDate() throws Exception {
	 	
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/legal.html");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	 HelperFunctions.staticWait(2);
	 String beforePublish=publishInfoonPage.getText();
publishIcon.click();
HelperFunctions.staticWait(2);
Driver.getDriver().navigate().refresh();
HelperFunctions.waitForPageToLoad(30);
try {
	Thread.sleep(10000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
js.executeScript("arguments[0].click();", pageInfo);
try {
	Thread.sleep(3000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
	 HelperFunctions.staticWait(2);
	 String afterPublish=publishInfoonPage.getText();
	 Assert.assertNotEquals(beforePublish, afterPublish);
	 HelperFunctions.staticWait(3);
}

public void setHidingFromList() throws Exception {
	// Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/products.html");
	 HelperFunctions.waitForPageToLoad(5);
	 HelperFunctions.staticWait(2);
	 for(WebElement each:productTitles) {
		 if(each.getText().contains("testing")) {
			 Assert.assertTrue(false);
		 }
	 }

	   // HelperFunctions.staticWait(3);
	 HelperFunctions.staticWait(2);
  Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/sites.html/content/pc/us/en/automation/products/testing");
  //HelperFunctions.waitForPageToLoad(5);
  HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(5);
	read1.setExcelFile("./testdata.xlsx", "QA");
	email.sendKeys(read1.getCellData("VALUE", 44));
	HelperFunctions.staticWait(3);
	next.click();
  HelperFunctions.waitForPageToLoad(60);
  try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	 //testingImg.click();
	// HelperFunctions.staticWait(2);
	// JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
 // executor2.executeScript("arguments[0].click();", testingImg);
 // HelperFunctions.staticWait(2);
 // JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
 // executor3.executeScript("arguments[0].click();", testingImg);
 // HelperFunctions.staticWait(2);
  JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
  executor4.executeScript("arguments[0].click();", testingImg);
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
  executor4.executeScript("arguments[0].click();", testingImg);
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
  executor4.executeScript("arguments[0].click();", testingImg);
  HelperFunctions.staticWait(2);
  properties.click();
  HelperFunctions.waitForPageToLoad(60);
	 HelperFunctions.staticWait(2);
	 hideListing.click();
	 HelperFunctions.staticWait(2);
	 saveClose.click();
	 HelperFunctions.waitForPageToLoad(60);
	 HelperFunctions.waitForPageToLoad(60);
	 try {
		  	Thread.sleep(5000);
		  }catch(InterruptedException e) {
		  	e.printStackTrace();
		  }
	 testingImg.click();
	 try {
		  	Thread.sleep(3000);
		  }catch(InterruptedException e) {
		  	e.printStackTrace();
		  }
	 JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
  executor5.executeScript("arguments[0].click();", testingImg);
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
  JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
  executor6.executeScript("arguments[0].click();", testingImg);
  HelperFunctions.staticWait(3);
  quickPublish.click();
  try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	    JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
  executor7.executeScript("arguments[0].click();",  publish2);
  HelperFunctions.staticWait(5);
  productImg.click();
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	 JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
  executor8.executeScript("arguments[0].click();", productImg);
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
  JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
  executor9.executeScript("arguments[0].click();", productImg);
  try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
  JavascriptExecutor executor19 = (JavascriptExecutor) Driver.getDriver();
  executor19.executeScript("arguments[0].click();",  quickPublish);
  try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
  executor10.executeScript("arguments[0].click();",  publish2);
  HelperFunctions.staticWait(5);
  Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/products.html");
	 HelperFunctions.waitForPageToLoad(90);
	 HelperFunctions.staticWait(2);
	 for(WebElement each:productTitles) {
		 if(each.getText().contains("testing")) {
			 Assert.assertTrue(true);
		 }
	 }
	 HelperFunctions.staticWait(2);
	 Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/sites.html/content/pc/us/en/automation/products/testing");
  HelperFunctions.waitForPageToLoad(90);
  try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }

	 testingImg.click();
	 try {
		  	Thread.sleep(3000);
		  }catch(InterruptedException e) {
		  	e.printStackTrace();
		  }
	 JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
executor11.executeScript("arguments[0].click();", testingImg);
try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
JavascriptExecutor executor12 = (JavascriptExecutor) Driver.getDriver();
executor12.executeScript("arguments[0].click();", testingImg);
HelperFunctions.staticWait(3);
properties.click();
HelperFunctions.waitForPageToLoad(60);
	 HelperFunctions.staticWait(2);

	 hideListing.click();
	 HelperFunctions.staticWait(2);

	 saveClose.click();
	 HelperFunctions.waitForPageToLoad(60);
	 try {
		  	Thread.sleep(5000);
		  }catch(InterruptedException e) {
		  	e.printStackTrace();
		  }

	 testingImg.click();
	 try {
		  	Thread.sleep(3000);
		  }catch(InterruptedException e) {
		  	e.printStackTrace();
		  }
	 JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
executor13.executeScript("arguments[0].click();", testingImg);
try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
JavascriptExecutor executor14 = (JavascriptExecutor) Driver.getDriver();
executor14.executeScript("arguments[0].click();", testingImg);
HelperFunctions.staticWait(3);
quickPublish.click();
try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	    JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
executor15.executeScript("arguments[0].click();",  publish2);
HelperFunctions.staticWait(5);
productImg.click();
try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	 JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
executor16.executeScript("arguments[0].click();", productImg);
try {
	  	Thread.sleep(3000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
executor17.executeScript("arguments[0].click();", productImg);
HelperFunctions.staticWait(3);
quickPublish.click();
try {
	  	Thread.sleep(5000);
	  }catch(InterruptedException e) {
	  	e.printStackTrace();
	  }
	    JavascriptExecutor executor18 = (JavascriptExecutor) Driver.getDriver();
executor18.executeScript("arguments[0].click();",  publish2);
HelperFunctions.staticWait(5);
}
public void setSitemapPage() throws Exception {
	
 //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(createButton);
	    //wait.until(condition);
	    createButton.click();
	    HelperFunctions.staticWait(2);
	    pageButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    siteTemplate.click();
	    HelperFunctions.staticWait(2);
 nextButton.click();
	HelperFunctions.waitForPageToLoad(5);
	titleField2.click();
	titleField2.sendKeys("site-demo");
	HelperFunctions.staticWait(2);
	    createPage.click();
	    HelperFunctions.staticWait(2); 
	    doneButton2.click();
	    HelperFunctions.waitForPageToLoad(5);
	    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/site-demo.html");
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(2); 
	    previewButton.click();
	    Driver.getDriver().switchTo().frame(0);
	    Assert.assertTrue(sitemapContent.isDisplayed());
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/sites.html/content/pc/us/en/automation");
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
		 JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
	     executor15.executeScript("arguments[0].click();", sitedemoImg);
		 HelperFunctions.staticWait(2);
		 JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
	     executor16.executeScript("arguments[0].click();", sitedemoImg);
	     HelperFunctions.staticWait(2);
	     JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
	     executor17.executeScript("arguments[0].click();", sitedemoImg); 
	     HelperFunctions.staticWait(2);
		    delete.click();
		    HelperFunctions.staticWait(2);
		    delete2.click();
		    HelperFunctions.staticWait(3);
} 
public void setNavigateLinksSitemap() throws Exception {
	 	
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/sitemapfortesting.html");
		    //HelperFunctions.waitForPageToLoad(10);
		    //HelperFunctions.staticWait(3);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
		    previewButton.click();
		    Driver.getDriver().switchTo().frame(0);
		    for(WebElement link:sitemapLinks) {
		    	if(link.getAttribute("href")!=null) {
		    		Assert.assertTrue(true);
		    	}else {
		    		Assert.assertTrue(false);
		    	}
		    }
		    HelperFunctions.staticWait(3);
	} 
public void setMyProductsinSitemap() throws Exception {
	 	
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/sitemapfortesting.html");
		//HelperFunctions.waitForPageToLoad(10);
		//HelperFunctions.staticWait(3);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
		previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		Assert.assertTrue(myproductSitemap.isDisplayed()&& childContent.isDisplayed());
		HelperFunctions.staticWait(3);
	} 
public void setBannerText() throws Exception {
	 	
	  //  Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
		HelperFunctions.waitForPageToLoad(10);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		System.out.println(scheduledCont.getText());
		Assert.assertTrue(scheduledCont.getText().contains("Scheduled Maintenance"));
		HelperFunctions.staticWait(2);
		System.out.println(outageCont.getText());
		Assert.assertTrue(outageCont.getText().contains("service outage"));
		HelperFunctions.staticWait(2);
		System.out.println(deprecatedCont.getText());
		Assert.assertTrue(deprecatedCont.getText().contains("service interruption"));
		HelperFunctions.staticWait(3);
	} 
public void setBannerforSpecificProduct() throws Exception {
	 	
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
		HelperFunctions.waitForPageToLoad(10);
		HelperFunctions.staticWait(3);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		System.out.println(scheduledCont.getText());
		Assert.assertTrue(scheduledCont.getText().contains("Fluid Forecast"));
		HelperFunctions.staticWait(2);
		System.out.println(outageCont.getText());
		Assert.assertTrue(outageCont.getText().contains("Fluid Forecast"));
		HelperFunctions.staticWait(2);
		System.out.println(deprecatedCont.getText());
		Assert.assertTrue(deprecatedCont.getText().contains("Fluid Forecast"));
		HelperFunctions.staticWait(3);
	} 
public void setBannerTypes(ExtentTest test) throws Exception {
	 	
	test.info("Wait for the page to load.");
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	test.info("Click on page info");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	  WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    //wait.until(condition);
	  js.executeScript("arguments[0].click();", pageInfo);
	    //pageInfo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		test.info("Getting each color of banners");
		String scheduledContColor = scheduledCont.getCssValue("background-color");
		String outageContColor = outageCont.getCssValue("background-color");
		String deprecatedContColor = deprecatedCont.getCssValue("background-color");
		System.out.println(outageContColor+"---"+deprecatedContColor);
		Assert.assertNotEquals(scheduledContColor, outageContColor, "Scheduled and outage containers have the same background color");
		test.info("Verified Scheduled and outage containers do NOT have the same background color");
		Assert.assertNotEquals(scheduledContColor, deprecatedContColor, "Scheduled and deprecated containers have the same background color");
		test.info("Verified Scheduled and deprecated containers do NOT have the same background color");
		Assert.assertNotEquals(outageContColor, deprecatedContColor, "Outage and deprecated containers have the same background color");
		test.info("Verified Outage and deprecated containers do NOT have the same background color");
		HelperFunctions.staticWait(3);
	} 
public void setBannerDisplayed() throws Exception {
	 	
	  //  Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
		HelperFunctions.waitForPageToLoad(10);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		previewButton.click();
		Driver.getDriver().switchTo().frame(0);
		Assert.assertTrue(scheduledCont.isDisplayed());
		Assert.assertTrue(outageCont.isDisplayed());
		Assert.assertTrue(outageCont.isDisplayed());
		HelperFunctions.staticWait(3);
	} 
public void setBannerDisplayed2() throws Exception {
 	
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
	HelperFunctions.waitForPageToLoad(10);
	HelperFunctions.staticWait(3);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	previewButton.click();
	Driver.getDriver().switchTo().frame(0);
	Assert.assertTrue(outageCont.isDisplayed());
	Assert.assertTrue(deprecatedCont.isDisplayed());
	HelperFunctions.staticWait(3);
} 
public void setPrivacyWord() throws Exception {
   //HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   editText.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(textArea));
   textArea.click();
   HelperFunctions.staticWait(2);
   textArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
   HelperFunctions.staticWait(2);
   Actions actions = new Actions(Driver.getDriver());
   actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
   String clipboardText = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
   HelperFunctions.staticWait(2);
   Assert.assertTrue(clipboardText.contains("Board Central is an offering of PwC Product Sales"));
   HelperFunctions.staticWait(3);

}
public void setWorkflowArchive() throws Exception {
   HelperFunctions.waitForPageToLoad(5);
Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/assets.html/content/dam/productcentral/en_us/products/profit-seeker");
   HelperFunctions.waitForPageToLoad(5);
   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
   ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(examplePDF);
   wait.until(condition);
   examplePDF.click();
   HelperFunctions.staticWait(2);
   managePublication.click();
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(3);
   nextButton.click();
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(3);
   legalPageImgforPublish.click();
    HelperFunctions.staticWait(2);
    unpublishButton.click();
    HelperFunctions.waitForPageToLoad(5);
	   HelperFunctions.staticWait(3);
   Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/apps/acs-commons/content/reports.html");
   HelperFunctions.waitForPageToLoad(5);
   workflowReports.click();
   HelperFunctions.waitForPageToLoad(5);
   executeReports.click();
   WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
   ExpectedCondition<WebElement> condition2 = ExpectedConditions.visibilityOf(results);
   wait2.until(condition2);
   HelperFunctions.staticWait(3);
   String searchString ="Profit Seeker - Maintenance and Support.pdf";
   boolean containsSearchString = false;
   for (WebElement element : pageTitlesinReports) {
	    String elementText = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].textContent;", element);
	    System.out.println(elementText);
	    if (elementText.contains(searchString)) {
	        containsSearchString = true;
	        break;
	    }
	}
   Assert.assertTrue(containsSearchString, "List does not contain search string: " + searchString);

}
public void setExperienceFragment() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
 //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/experience-fragments/pc/us/en/site/experience-fragment/master.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
 //  Driver.getDriver().switchTo().frame(0);
   HelperFunctions.staticWait(2);
   phEdit.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(pTitle));
  // Driver.getDriver().switchTo().frame(0);
   pTitle.click();
   HelperFunctions.staticWait(1);
   pTitle.clear();
   HelperFunctions.staticWait(1);
   String mockName="Product";
   pTitle.sendKeys(mockName);
   HelperFunctions.staticWait(1);
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
    publishIcon.click();
    HelperFunctions.staticWait(3);
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub.html");
    HelperFunctions.waitForPageToLoad(90);
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    previewButton.click();
    Driver.getDriver().switchTo().frame(0);
    Assert.assertEquals(phProductName.getText(), mockName);
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub/phpage.html");
    HelperFunctions.waitForPageToLoad(90);
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    previewButton.click();
    Driver.getDriver().switchTo().frame(0);
    Assert.assertEquals(phProductName.getText(), mockName);
    HelperFunctions.staticWait(3);
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/experience-fragments/productcentral/us/en/site/experience-fragment/master.html");
	   HelperFunctions.waitForPageToLoad(90);
	   WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
	   //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait2.until(condition2);
	   try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	 //  Driver.getDriver().switchTo().frame(0);
	   HelperFunctions.staticWait(2);
	   phEdit.click();
	   HelperFunctions.staticWait(2);
	   configure.click();
	   HelperFunctions.staticWait(2);
	  // Driver.getDriver().switchTo().frame(0);
	   pTitle.click();
	   HelperFunctions.staticWait(1);
	   pTitle.clear();
	   HelperFunctions.staticWait(1);
	   String mockName2="Product Title";
	   pTitle.sendKeys(mockName2);
	   HelperFunctions.staticWait(1);
	   checkIcon.click();
	   try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    publishIcon.click();
	    HelperFunctions.staticWait(3);
  
}

public void setExperienceFragment2() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   sidePanel.click();
   HelperFunctions.staticWait(2);
   expandAll.click();
   HelperFunctions.staticWait(2);
   Actions actions = new Actions(Driver.getDriver());

   actions.dragAndDrop(ef, dragPlace).build().perform();
   HelperFunctions.staticWait(2);
   Assert.assertTrue(ef3.size()>1);
   HelperFunctions.staticWait(3);
 //  ef2.click();
 //  HelperFunctions.staticWait(2);
  // ef2Delete.click();
  // HelperFunctions.staticWait(2);
  // deleteConfirm.click();
  // HelperFunctions.staticWait(2);
  
}
public void setAccessAllProducts() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/wcm/core/content/sites/createpagewizard.html/content/pc/us/en/automation/my-products");
   HelperFunctions.waitForPageToLoad(5);
   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
   ExpectedCondition<WebElement> condition=ExpectedConditions.visibilityOf(ppTemplate);
   wait.until(condition);
   ppTemplate.click();
   HelperFunctions.staticWait(2);
   nextTemplate.click();
   HelperFunctions.waitForPageToLoad(5);
   productDetails.click();
   HelperFunctions.staticWait(2);
   productSelect.click();
   HelperFunctions.staticWait(2);
   List<String> firstListText = new ArrayList<>();
   for (WebElement firstElement : allProducts) {
       firstListText.add(firstElement.getText());
       System.out.println(firstElement.getText());
   }
   HelperFunctions.staticWait(2);
   Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/my-products/enterprise-control.html");
   HelperFunctions.waitForPageToLoad(90);
   viewAll.click();
   for (WebElement secondElement : allProducts2) {
	    boolean found = false;
	    for (String firstText : firstListText) {
	        if (firstText.contains(secondElement.getText())) {
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	       
	    }
	}
   HelperFunctions.staticWait(3);
}
public void setInternalAccess() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/wcm/core/content/sites/createpagewizard.html/content/pc/us/en/automation/my-products");
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(2);
   Assert.assertTrue(ppTemplate.isDisplayed());
   HelperFunctions.staticWait(3);
 
}
public void setPDFassets() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/en_us/products/change-navigator");
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(2);
   boolean hasChangeNavigator = false;
   boolean hasOfferingOverview = false;

   for (WebElement each : pdfTitles) {
       System.out.println(each.getText());
       if (each.getText().contains("Change Navigator")) {
           hasChangeNavigator = true;
       }
       if (each.getText().contains("Offering Overview")) {
           hasOfferingOverview = true;
       }
   }

   Assert.assertTrue(hasChangeNavigator);
   Assert.assertTrue(hasOfferingOverview);
   HelperFunctions.staticWait(3);
 
}
public void setPrivacyFooter() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/experience-fragments/pc/us/en/site/experience-fragment/footer.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
 //  Driver.getDriver().switchTo().frame(0);
   HelperFunctions.staticWait(2);
   phFooter.click();
   HelperFunctions.staticWait(2);
   configure.click();
   HelperFunctions.staticWait(2);
  // Driver.getDriver().switchTo().frame(0);
   phFooterTitle.click();
   HelperFunctions.staticWait(1);
   phFooterTitle.clear();
   HelperFunctions.staticWait(1);
   String mockName="FAQs";
   phFooterTitle.sendKeys(mockName);
   HelperFunctions.staticWait(1);
   if(!phFooterExternal.isSelected()) {
	   phFooterExternal.click();
   }
   HelperFunctions.staticWait(2);
   JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", phAddLink);
   //phAddLink.click();
     HelperFunctions.staticWait(2);
     JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
     executor2.executeScript("arguments[0].click();", phSecondTitle);
  // phSecondTitle.click();
   HelperFunctions.staticWait(1);
   phSecondTitle.clear();
   HelperFunctions.staticWait(1);
   String mockName2="Cookies";
   phSecondTitle.sendKeys(mockName2);
   HelperFunctions.staticWait(1);
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
    publishIcon.click();
    HelperFunctions.staticWait(3);
    Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/experience-fragments/productcentral/us/en/site/experience-fragment/footer.html");
    HelperFunctions.waitForPageToLoad(90);
    Assert.assertTrue(phLinks.size()>1);
    
    String href = faqLink.getAttribute("href");

 if (href.startsWith("http") && !href.equals(Driver.getDriver().getCurrentUrl())) {
	 Assert.assertTrue(true);
     System.out.println("FAQ link opens in a new tab");
 } else {
     System.out.println("FAQ link does not open in a new tab");
 }   
 HelperFunctions.staticWait(3);
  
}
public void setPrivacyHubPipes() throws Exception {
 //  HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/privacy-hub.html");
   HelperFunctions.waitForPageToLoad(5);
   HelperFunctions.staticWait(2);
   List<WebElement> footerLinks = Driver.getDriver().findElements(By.cssSelector("div.ap-footer-link"));

for (int i = 0; i < footerLinks.size() - 1; i++) {
    WebElement firstLink = footerLinks.get(i).findElement(By.cssSelector("a.ap-link"));
    WebElement secondLink = footerLinks.get(i + 1).findElement(By.cssSelector("a.ap-link"));
    String firstLinkAfterContent = firstLink.getCssValue("content");
    String secondLinkAfterContent = secondLink.getCssValue("content");
    if (!firstLinkAfterContent.isEmpty() || !secondLinkAfterContent.isEmpty()) {
    	 Assert.assertTrue(true);
        System.out.println("There is an ::after pseudo-element between links " + (i + 1) + " and " + (i + 2));
    } else {
        System.out.println("There is no ::after pseudo-element between links " + (i + 1) + " and " + (i + 2));
    }
}

 
}
public void setUserWorkflowApproval() throws Exception {
 	
 //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
   // HelperFunctions.waitForPageToLoad(15);
   // HelperFunctions.staticWait(3);
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(securityImg);
    //wait.until(condition);
    try {
    	Thread.sleep(5000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    securityImg.click();
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
 executor1.executeScript("arguments[0].click();", securityImg);
 try {
 	Thread.sleep(3000);
 }catch(InterruptedException e) {
 	e.printStackTrace();
 }
 JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
 executor2.executeScript("arguments[0].click();", securityImg);
    HelperFunctions.staticWait(3);
    createButton3.click();
    HelperFunctions.staticWait(3);
    workflowIcon.click();
    HelperFunctions.staticWait(3); 
    workflowDropdown.click();
    HelperFunctions.staticWait(3); 
    approvalWorkflow.click();
    HelperFunctions.staticWait(3); 
    workflowTitle.click();
    HelperFunctions.staticWait(2); 
    workflowTitle.sendKeys("Testing");
    HelperFunctions.staticWait(2);
    nextButton.click();
    //HelperFunctions.staticWait(3);
    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),15);
    ExpectedCondition<WebElement> condition2=ExpectedConditions.visibilityOf(legalPageImgforPublish);
    wait2.until(condition2);
    legalPageImgforPublish.click();
    HelperFunctions.staticWait(2);
    createButton2.click();
    HelperFunctions.waitForPageToLoad(60);
    //HelperFunctions.staticWait(2);
    WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition3=ExpectedConditions.visibilityOf(bellIcon);
    wait3.until(condition3);
    bellIcon.click();
    HelperFunctions.staticWait(2);
    AEMInbox.click();
    HelperFunctions.waitForPageToLoad(60);
    //HelperFunctions.staticWait(2);
    WebDriverWait wait4=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition4=ExpectedConditions.visibilityOf(assignedTask);
    wait4.until(condition4);
    assignedTask.click();
    HelperFunctions.staticWait(3);
    completeButton2.click();
    HelperFunctions.staticWait(3);
    selectGroup.click();
    HelperFunctions.staticWait(2);
    Actions builder = new Actions(Driver.getDriver());
    builder.moveToElement(textGroup).click().sendKeys("Global IT QA").perform();
    HelperFunctions.staticWait(3);
    globalIt.click();
    HelperFunctions.staticWait(2);
    //selectZip.click();
   // HelperFunctions.staticWait(2);
   // selectZipNo.click();
   // HelperFunctions.staticWait(2);
    selectOk.click();
    HelperFunctions.waitForPageToLoad(10);
    HelperFunctions.staticWait(10);
    Driver.getDriver().navigate().refresh();
    HelperFunctions.waitForPageToLoad(15);
    //HelperFunctions.staticWait(2);
    WebDriverWait wait5=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition5=ExpectedConditions.visibilityOf(assignedTask);
    wait5.until(condition5);
    assignedTask.click();
    HelperFunctions.staticWait(2);
    completeButton2.click();
    HelperFunctions.staticWait(3);
    approveGroup.click();
    HelperFunctions.staticWait(2);
    publishGroup.click();
    HelperFunctions.staticWait(2);
    selectOk.click();
    HelperFunctions.staticWait(5);
    
    
   
  
}
public void setHideDownloadCheckbox() throws Exception {
 	
 //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/wcm/core/content/sites/createpagewizard.html/content/pc/us/en/automation");
    HelperFunctions.waitForPageToLoad(5);
    HelperFunctions.staticWait(3);
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(contentTemplate);
    //wait.until(condition);
    try {
    	Thread.sleep(5000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    contentTemplate.click();
    HelperFunctions.staticWait(2);
nextButton.click();
HelperFunctions.waitForPageToLoad(5);
HelperFunctions.staticWait(2);
Assert.assertTrue(hideDownload.isDisplayed());
HelperFunctions.staticWait(3);
   
  
}
public void setBannerTextField() throws Exception {
 	
    //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
	HelperFunctions.waitForPageToLoad(10);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	editButtonContent.click();
	HelperFunctions.staticWait(2);
	firstBanner.click();
	wait.until(ExpectedConditions.visibilityOf(configure));
	configure.click();
	HelperFunctions.staticWait(2);
	Assert.assertTrue(bannerType.isDisplayed());
	Assert.assertTrue(bannerProduct.isDisplayed());
	HelperFunctions.staticWait(3);
} 
public void setBannerTextField2() throws Exception {
 	
    //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
	HelperFunctions.waitForPageToLoad(10);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	editButtonContent.click();
	HelperFunctions.staticWait(2);
	firstBanner.click();
	wait.until(ExpectedConditions.visibilityOf(configure));
	configure.click();
	HelperFunctions.staticWait(2);
	Assert.assertTrue(bannerType.isDisplayed());
	Assert.assertTrue(bannerProduct.isDisplayed());
	HelperFunctions.staticWait(3);
} 
public void setPrivacyFooterCopyWrite() throws Exception {
  // HelperFunctions.waitForPageToLoad(5);
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/experience-fragments/pc/us/en/site/experience-fragment/footer.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   editButtonContent.click();
   HelperFunctions.staticWait(2);
   phFooter.click();
   wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
   wait.until(ExpectedConditions.visibilityOf(footerText));
   footerText.click();
   HelperFunctions.staticWait(1);
   footerText.clear();
   HelperFunctions.staticWait(1);
   String mockName="All rights reserved. PwC refers to the US member firm of the PwC network or one of its subsidiaries or affiliates";
   footerText.sendKeys(mockName);
   HelperFunctions.staticWait(1);
   checkIcon.click();
   try {
   	Thread.sleep(10000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   js.executeScript("arguments[0].click();", pageInfo);
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
    publishIcon.click();
    HelperFunctions.staticWait(3);
    Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/experience-fragments/productcentral/us/en/site/experience-fragment/footer.html");
    HelperFunctions.waitForPageToLoad(90);
    HelperFunctions.staticWait(2);
  Assert.assertTrue(footerCopywrite.isDisplayed());
  HelperFunctions.staticWait(3);
}
public void setBannerEdit() throws Exception {
 	
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	    editBanner.click();
	    HelperFunctions.staticWait(2);
	    bannerEdit.click();
	    HelperFunctions.staticWait(2);
	    settingsBanner.click();
	    HelperFunctions.staticWait(4);
	    bannerDrop.click();
	    HelperFunctions.staticWait(2);
	    scheduledBanner.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewBanner.click();
		Driver.getDriver().switchTo().frame(0);
		HelperFunctions.staticWait(2);
		String firstColor=scheduledBanner2.getCssValue("background-color");
		System.out.println(firstColor);
		System.out.println(scheduledBanner2.getText());
		Assert.assertFalse(scheduledBanner2.getText()==null);
		 HelperFunctions.staticWait(3);
		 Driver.getDriver().switchTo().defaultContent();
		 editBanner.click();
		    HelperFunctions.staticWait(2);
		    bannerEdit.click();
		    HelperFunctions.staticWait(2);
		    settingsBanner.click();
		    HelperFunctions.staticWait(4);
		    bannerDrop.click();
		    HelperFunctions.staticWait(2);
		    outageBanner.click();
		    HelperFunctions.staticWait(2);
		    checkIcon.click();
		    try {
		    	Thread.sleep(10000);
		    }catch(InterruptedException e) {
		    	e.printStackTrace();
		    }
		    js.executeScript("arguments[0].click();", pageInfo);
		    try {
		    	Thread.sleep(3000);
		    }catch(InterruptedException e) {
		    	e.printStackTrace();
		    }
		    previewBanner.click();
			Driver.getDriver().switchTo().frame(0);
			HelperFunctions.staticWait(2);
			String secondColor=outageBanner2.getCssValue("background-color");
			System.out.println(secondColor);
			Assert.assertNotEquals(firstColor, secondColor);
			HelperFunctions.staticWait(3);
		
	} 
public void setFeatureTags() throws Exception {
 	
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
		HelperFunctions.waitForPageToLoad(10);
		HelperFunctions.staticWait(3);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(selectTag);
	    //wait.until(condition);
		try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    selectTag.click();
	    HelperFunctions.staticWait(2);
	    productCent.click();
	    HelperFunctions.staticWait(2);
	    firstTagImg.click();
	    HelperFunctions.staticWait(4);
	    secondTagImg.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(featureTags.size()>1);
	    HelperFunctions.staticWait(2);
	    removeTags.get(0).click();
	    HelperFunctions.staticWait(2);
	    removeTag.click();
	    HelperFunctions.staticWait(3);
	    pcTab.click();
	    HelperFunctions.staticWait(3);
	    selectPF.click();
	    HelperFunctions.staticWait(3);
	    pfOptions.get(0).click();
	    HelperFunctions.staticWait(3);
	    basicTab.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(featureTags.isEmpty());
	    HelperFunctions.staticWait(3);
	    
		
	} 

public void setKalturaVideo() throws Exception {
 	
	   // Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/dam/productcentral/en_us/products/check-in-archive/myproducts/multimedia-testing");
		//HelperFunctions.waitForPageToLoad(20);
		//HelperFunctions.staticWait(3);
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	//wait.until(ExpectedConditions.visibilityOf(kaltura));
	HelperFunctions.staticWait(10);
	Assert.assertTrue(kaltura.isDisplayed());
    HelperFunctions.staticWait(2);
	Assert.assertTrue(kalturaVideo.isDisplayed());
    HelperFunctions.staticWait(2);
		
	} 
public void setLongerTitleDescription() throws Exception {
 	
   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/check-in.html");
	//HelperFunctions.waitForPageToLoad(15);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    editButtonContent.click();
    HelperFunctions.staticWait(2);
    
    heroEdit.click();
    HelperFunctions.staticWait(2);
    configure.click();
    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
    wait1.until(ExpectedConditions.visibilityOf(heroEditTitle));
    String actualTitle="check-in";
    String mockTitle="check-incheck-incheck-incheck-incheck-incheck-incheck-incheck-incheck-incheck-incheck-incheck-incheck-in";
    String actualDesc="for testing";
    String mockDesc="for testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testingfor testing";
    heroEditTitle.click();
    HelperFunctions.staticWait(2);
    heroEditTitle.clear();
    HelperFunctions.staticWait(2);
    heroEditTitle.sendKeys(mockTitle);
    HelperFunctions.staticWait(2);
    heroEditDesc.click();
    HelperFunctions.staticWait(2);
    heroEditDesc.clear();
    HelperFunctions.staticWait(2);
    heroEditDesc.sendKeys(mockDesc);
    HelperFunctions.staticWait(2);
    checkIcon.click();
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    previewButton.click();
    Driver.getDriver().switchTo().frame(0);
    HelperFunctions.staticWait(2);
    System.out.println(heroTitle.getText());
    String textOverflow=heroTitle.getCssValue("text-overflow");
    boolean hasEllipsis=textOverflow.contains("ellipsis");
    Assert.assertTrue(hasEllipsis);
    HelperFunctions.staticWait(2);
    String textOverflow2=heroDesc.getCssValue("text-overflow");
    boolean hasEllipsis2=textOverflow2.contains("ellipsis");
    Assert.assertTrue(hasEllipsis2);
    HelperFunctions.staticWait(3);
    
} 
public void setMandatoryPCtag() throws Exception {
	
Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/dam/gui/content/assets/metadataeditor.external.html?item=/content/dam/productcentral/en_us/products/legal/Legal_Hosted_Software_Terms.pdf&_charset_=utf-8");
HelperFunctions.waitForPageToLoad(15);
WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
ExpectedCondition<WebElement> condition=ExpectedConditions.visibilityOf(productCentralTab);
wait.until(condition);
productCentralTab.click();
WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
wait1.until(ExpectedConditions.visibilityOf(documentCategoryTag2));
JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
executor9.executeScript("arguments[0].click();", documentCategoryTag2);
//documentCategoryTag2.click();
HelperFunctions.staticWait(2);
documentCategoryTag.get(0).click();
WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
wait2.until(ExpectedConditions.visibilityOf(pcErrorLabel));
Assert.assertTrue(pcErrorLabel.isDisplayed());
HelperFunctions.staticWait(3);
}
public void setMyProductLandingPage() throws Exception {
	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation/legal");
	  WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(createButton);
	    //wait.until(condition);
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    createButton.click();
	    wait.until(ExpectedConditions.visibilityOf(pageButton));
	    pageButton.click();
	    wait.until(ExpectedConditions.visibilityOf(mplpTemplate));
	    mplpTemplate.click();
	    HelperFunctions.staticWait(2);
      nextButton.click();
      wait.until(ExpectedConditions.visibilityOf(titleField2));
	    titleField2.click();
	    HelperFunctions.staticWait(2);
	    titleField2.sendKeys("automation landing");
	    HelperFunctions.staticWait(2);
	    productCentralTab.click();
	    wait.until(ExpectedConditions.visibilityOf(documentCategoryTag3));
	    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),30);
		wait2.until(ExpectedConditions.visibilityOf(documentCategoryTag3));
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
      executor1.executeScript("arguments[0].click();", documentCategoryTag3);
     
	    HelperFunctions.staticWait(3);
	    
	    firstOptionofDocCat.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
      executor1.executeScript("arguments[0].click();", productFeatureTag3);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      executor1.executeScript("arguments[0].click();", firstOptionofProCat);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      

      executor1.executeScript("arguments[0].click();", audienceTag);
	    HelperFunctions.staticWait(3);
	
      executor1.executeScript("arguments[0].click();", anonyOption);
      HelperFunctions.staticWait(3);
	    createButton2.click();
      WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),10);
	    ExpectedCondition<WebElement> condition3=ExpectedConditions.visibilityOf(openPage);
	    wait3.until(condition3);
	    openPage.click();
	    Set<String> allWindows4=Driver.getDriver().getWindowHandles();
      List<String> windowsList4=new ArrayList<>(allWindows4);
      Driver.getDriver().switchTo().window(windowsList4.get(1));
	    HelperFunctions.waitForPageToLoad(15);
	    WebDriverWait wait4=new WebDriverWait(Driver.getDriver(),10);
	    ExpectedCondition<WebElement> condition2=ExpectedConditions.visibilityOf(sidePanel);
	    wait4.until(condition2);
	    sidePanel.click();
	    wait.until(ExpectedConditions.visibilityOf(expandAll));
	    expandAll.click();
	    HelperFunctions.staticWait(5);
	    Actions actions = new Actions(Driver.getDriver());
	    Action dragAndDrop=actions.clickAndHold(dragRelated).moveToElement(dropRelated).release().build();
	    try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    dragAndDrop.perform();
	    
	    //actions.dragAndDrop(dragRelated, dropRelated).build().perform();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(relatedLinks.size()>=1);
	    HelperFunctions.staticWait(3);
	   Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/sites.html/content/pc/us/en/automation");
	    HelperFunctions.waitForPageToLoad(30);
	   // WebDriverWait wait4=new WebDriverWait(Driver.getDriver(),10);
	   // ExpectedCondition<WebElement> condition4=ExpectedConditions.elementToBeClickable(createButton);
	   // wait4.until(condition4);
	    try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
        executor15.executeScript("arguments[0].click();", alImg);
        try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
        JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
        executor16.executeScript("arguments[0].click();", alImg);
        try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
        JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
        executor17.executeScript("arguments[0].click();", alImg);
        HelperFunctions.staticWait(3);
	    delete.click();
	    wait.until(ExpectedConditions.visibilityOf(delete2));
	    delete2.click();
	    HelperFunctions.staticWait(5);
}

public void setLeftNaviEdit() throws Exception {
 	
    //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/dam/gui/content/assets/metadataeditor.external.html?item=/content/dam/productcentral/en_us/products/legal/Legal_Hosted_Software_Terms.pdf&_charset_=utf-8");
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	  WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    //wait.until(condition);
	  js.executeScript("arguments[0].click();", pageInfo);
	    //pageInfo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    editButtonContent.click();
	WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(leftNaviEdit);
    wait1.until(condition1);
    leftNaviEdit.click();
    wait1.until(ExpectedConditions.visibilityOf(configure));
    configure.click();
    wait1.until(ExpectedConditions.visibilityOf(expandCollapse.get(0)));
    expandCollapse.get(0).click();
    wait1.until(ExpectedConditions.visibilityOf(expandCollapse.get(1)));
    expandCollapse.get(1).click();
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
    executor9.executeScript("arguments[0].click();", secondTitleEdit);
    Assert.assertTrue(secondTitleEdit.isDisplayed());
    String nongated=firstImagePath.getAttribute("value");
    String gated=secondImagePath.getAttribute("value");
    String expected1="study";
    String expected2="listen";
    Assert.assertTrue(nongated.contains(expected1));
    HelperFunctions.staticWait(2);
    Assert.assertTrue(gated.contains(expected2));
    HelperFunctions.staticWait(3);
    
    
}
public void setInheritedBanners() throws Exception {
 	
    //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/dam/gui/content/assets/metadataeditor.external.html?item=/content/dam/productcentral/en_us/products/legal/Legal_Hosted_Software_Terms.pdf&_charset_=utf-8");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	    editButtonContent.click();
	WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),10);
    ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(bannerArea);
    wait1.until(condition1);
    bannerArea.click();
    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
    wait2.until(ExpectedConditions.visibilityOf(settingsBanner));
    settingsBanner.click();
    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
    wait3.until(ExpectedConditions.visibilityOf(bannerDrop));
    bannerDrop.click();
    HelperFunctions.staticWait(2);
    scheduledBanner.click();
    HelperFunctions.staticWait(2);
    checkIcon.click();
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    publishIcon.click();
    HelperFunctions.staticWait(3);
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/check-in/child-check-in.html");
    HelperFunctions.waitForPageToLoad(60);
    WebDriverWait wait4=new WebDriverWait(Driver.getDriver(),10);
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    previewButton2.click();
    Driver.getDriver().switchTo().frame(0);
    String text=preferencesModal.getText();
    System.out.println(text);
    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/check-in.html");
    HelperFunctions.waitForPageToLoad(60);
	  WebDriverWait wait5=new WebDriverWait(Driver.getDriver(),10);
	  try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    editButtonContent.click();
	WebDriverWait wait6=new WebDriverWait(Driver.getDriver(),10);
  ExpectedCondition<WebElement> condition6=ExpectedConditions.visibilityOf(bannerArea);
  wait6.until(condition6);
  bannerArea.click();
  WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
  wait7.until(ExpectedConditions.visibilityOf(settingsBanner));
  settingsBanner.click();
  WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 10);
  wait8.until(ExpectedConditions.visibilityOf(bannerDrop));
  bannerDrop.click();
  HelperFunctions.staticWait(2);
  outageBanner.click();
  HelperFunctions.staticWait(2);
  checkIcon.click();
  try {
  	Thread.sleep(10000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  js.executeScript("arguments[0].click();", pageInfo);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  publishIcon.click();
  HelperFunctions.staticWait(3);
  Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/check-in/child-check-in.html");
  WebDriverWait wait9=new WebDriverWait(Driver.getDriver(),10);
  HelperFunctions.waitForPageToLoad(60);
  //ExpectedCondition<WebElement> condition9=ExpectedConditions.elementToBeClickable(previewButton2);
  //wait9.until(condition9);
  try {
  	Thread.sleep(10000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  js.executeScript("arguments[0].click();", pageInfo);
  try {
  	Thread.sleep(3000);
  }catch(InterruptedException e) {
  	e.printStackTrace();
  }
  previewButton2.click();
  Driver.getDriver().switchTo().frame(0);
  String text2=preferencesModal.getText();
  System.out.println(text2);
  Assert.assertNotEquals(text, text2);
  HelperFunctions.staticWait(3);
}
public void setRelatedLinksAuthoringandRearrangeRelated() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 HelperFunctions.waitForPageToLoad(10);
	  
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		editButtonContent.click();
		HelperFunctions.staticWait(2);
		authRelated.click();
		wait.until(ExpectedConditions.visibilityOf(configure));
       configure.click();
       WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
       wait3.until(ExpectedConditions.visibilityOf(relatedTitleEdit));
       Assert.assertTrue(relatedLinkEdit.isDisplayed());
       HelperFunctions.staticWait(2);
       String expected="check-in";
       String title="Disclosure Checklist";
       JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       executor.executeScript("arguments[0].click();", relatedTitleEdit);
       HelperFunctions.staticWait(2);
       relatedTitleEdit.clear();
       HelperFunctions.staticWait(2);
       relatedTitleEdit.sendKeys(expected);
       HelperFunctions.staticWait(2);
       checkIcon.click();
       HelperFunctions.staticWait(10);
       authRelated.click();
       wait3.until(ExpectedConditions.visibilityOf(configure));
      configure.click();
      WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
      wait4.until(ExpectedConditions.visibilityOf(relatedTitleEdit));
      String actual=relatedTitleEdit.getAttribute("value");
      System.out.println(actual);
      System.out.println(expected);
      
       Assert.assertEquals(actual, expected);
       HelperFunctions.staticWait(2);
       JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
       executor2.executeScript("arguments[0].click();", relatedTitleEdit);
       HelperFunctions.staticWait(2);
       relatedTitleEdit.clear();
       HelperFunctions.staticWait(2);
       relatedTitleEdit.sendKeys(title);
       HelperFunctions.staticWait(3);
       checkIcon.click();
       HelperFunctions.staticWait(5);
       
       
	   
	    
	    
	}
public void setContentBox() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 HelperFunctions.waitForPageToLoad(10);
	  
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		editButtonContent.click();
		HelperFunctions.staticWait(2);
		titleEdit403.click();
		wait.until(ExpectedConditions.visibilityOf(configure));
		configure.click();
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(titleEdit));
	    String mockTitle="New Title";
	    titleEdit.click();
	    HelperFunctions.staticWait(2);
	    titleEdit.clear();
	    HelperFunctions.staticWait(2);
	    titleEdit.sendKeys(mockTitle);
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(privacyTitle1.getText().equalsIgnoreCase(mockTitle));
	    System.out.println(whiteContainer.getCssValue("background-color"));
	    System.out.println(whiteContainer.getCssValue("color"));
	    String expectedColor="rgba(70, 70, 70, 1)";
	    String actualColor=whiteContainer.getCssValue("color");
	    Assert.assertEquals(actualColor, expectedColor);
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().defaultContent();
	    WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),15);
		//ExpectedCondition<WebElement> condition3=ExpectedConditions.elementToBeClickable(editButtonContent);
		//wait3.until(condition3);
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		editButtonContent.click();
		HelperFunctions.staticWait(2);
		titleEdit403.click();
		wait2.until(ExpectedConditions.visibilityOf(configure));
		configure.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(titleEdit));
	    String actualTitle="Content Box Automation";
	    titleEdit.click();
	    HelperFunctions.staticWait(2);
	    titleEdit.clear();
	    HelperFunctions.staticWait(2);
	    titleEdit.sendKeys(actualTitle);
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(privacyTitle1.getText().equalsIgnoreCase(actualTitle));
	    HelperFunctions.staticWait(3);
	    
	    
		
		
}
public void setBannerClose(ExtentTest test) throws Exception {
	read1.setExcelFile("./testdata.xlsx", "STG");
	test.info("Wait for the page to load.");
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
    executor.executeScript("arguments[0].click();", pageInfo);
    //HelperFunctions.staticWait(3);
    test.info("Click on view as published");
    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
    viewasPublish.click();
    test.info("Go to new tab");
	 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
	    test.info("Wait for banner visibility");
	    HelperFunctions.waitForPageToLoad(60);
	   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
	    wait1.until(ExpectedConditions.visibilityOf(banner2));
    test.info("Checking if the banner is displayed");
    if(!banner2.isDisplayed()) {
   	 String errorMessage = "Banner is not displayed";
        logger.error(errorMessage);
   }else {
   	String successMessage = "Banner is displayed";
       logger.info(successMessage);
   }
    test.info("Verified banner is displayed");
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    String actualMessage=outageBannerMessage.getText();
    String expectedProductName="Disclosure Checklist";
    String nonExpectedProductCode="disclosure-checklist";
    Assert.assertTrue(actualMessage.contains(expectedProductName));
    test.info("Verified banner message contains product name");
    try {
    	Thread.sleep(2000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    Assert.assertFalse(actualMessage.contains(nonExpectedProductCode));
    test.info("Verified banner message does not contain product code");
    try {
    	Thread.sleep(2000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    test.info("Click on banner close");
   bannerClose.click();
   HelperFunctions.staticWait(2);
   test.info("Refresh the page");
   Driver.getDriver().navigate().refresh();
   HelperFunctions.waitForPageToLoad(30); 
   HelperFunctions.staticWait(3);
   if(!banner2.isDisplayed()) {
  	 String errorMessage = "Banner is not displayed";
       logger.error(errorMessage);
  }else {
  	String successMessage = "Banner is displayed";
      logger.info(successMessage);
  }
   test.info("Verified banner is displayed");
   HelperFunctions.staticWait(3);
}
public void setOutageBannerMessage(ExtentTest test) throws Exception {
	read1.setExcelFile("./testdata.xlsx", "STG");
	test.info("Wait for page info and click on it");
	try {
    	Thread.sleep(5000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
    executor.executeScript("arguments[0].click();", pageInfo);
    //HelperFunctions.staticWait(3);
    test.info("Click on view as published");
    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
    viewasPublish.click();
    test.info("Go to new tab");
	 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
	    test.info("Wait for banner visibility");
	    HelperFunctions.waitForPageToLoad(15);
	   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
	    wait1.until(ExpectedConditions.visibilityOf(banner2));
    wait1.until(ExpectedConditions.visibilityOf(outageBannerMessage2));
	HelperFunctions.staticWait(3);
	String text1="We are investigating a service outage";
	int currentYear=LocalDate.now().getYear();
	Assert.assertTrue(outageBannerMessage2.getText().contains(text1));
	test.info("Verified outage banner is displayed expected text");
	HelperFunctions.staticWait(2);
	Assert.assertTrue(outageBannerMessage2.getText().contains(String.valueOf(currentYear)));
	test.info("Verified outage banner is displayed current year");
	String date="Aug 31, 2023 18:08 UTC";
	Assert.assertTrue(outageBannerMessage2.getText().contains(date));
	test.info("Verified outage banner's date is displayed as expected format");
	HelperFunctions.staticWait(3);
	    
}
public void setFooterSystemAuthored() throws Exception {
	//HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
    try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    js.executeScript("arguments[0].click();", pageInfo);
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    editButtonContent.click();
	HelperFunctions.staticWait(2);
	Assert.assertTrue(footerHome.size()==0);
	HelperFunctions.staticWait(2);
	 
   
}
public void setInternalOnly() throws Exception {
 	
    
   	//HelperFunctions.waitForPageToLoad(15);
   	WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),30);
    ExpectedCondition<WebElement> condition3=ExpectedConditions.visibilityOf(productCentralTab);
    wait3.until(condition3);
    productCentralTab.click();
    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
    wait4.until(ExpectedConditions.visibilityOf(audienceDropdown));
    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", audienceDropdown);
    //HelperFunctions.staticWait(2);
    wait4.until(ExpectedConditions.visibilityOf(audienceList.get(1)));
    for(int i = 1; i < audienceList.size(); i++) {
    	WebElement element=audienceList.get(i);
    	String elementText=element.getText();
    	if(elementText.contains("Internal Only")) {
    		Assert.assertTrue(true);
    		break;
    	
    	}
    }
    HelperFunctions.staticWait(2);
    executor10.executeScript("arguments[0].click();", audienceDropdown);
    HelperFunctions.staticWait(2);
    Assert.assertTrue(portfolioDropdown.isDisplayed());
    HelperFunctions.staticWait(3);
    
    }
public void setInternalOnly2() throws Exception {
 	
    
   	//HelperFunctions.waitForPageToLoad(15);
   	WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),30);
    //ExpectedCondition<WebElement> condition3=ExpectedConditions.elementToBeClickable(pageInfo);
    //wait3.until(condition3);
   	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    pageInfo.click();
    //WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 15);
    wait3.until(ExpectedConditions.visibilityOf(properties2));
    properties2.click();
    HelperFunctions.waitForPageToLoad(15);
    wait3.until(ExpectedConditions.visibilityOf(productDetailsTab));
    productDetailsTab.click();
    wait3.until(ExpectedConditions.visibilityOf(audienceTag));  
    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", audienceTag);
    wait3.until(ExpectedConditions.visibilityOf(audienceList.get(1)));
    for(int i = 1; i < audienceList.size(); i++) {
    	WebElement element=audienceList.get(i);
    	String elementText=element.getText();
    	if(elementText.contains("Internal Only")) {
    		Assert.assertTrue(true);
    		break;
    	
    	}
    }
    HelperFunctions.staticWait(2);
   /* if(errorList.size()>=3) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
    
    HelperFunctions.staticWait(2);*/
    executor10.executeScript("arguments[0].click();", audienceTag);
    HelperFunctions.staticWait(2);
    Assert.assertTrue(portfolioTag.isDisplayed());
    HelperFunctions.staticWait(3);
    }
public void setRelatedLinksTextandSticky() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 //HelperFunctions.waitForPageToLoad(10);
	  
	 try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
	    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
	    executor.executeScript("arguments[0].click();", pageInfo);
	    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
	    viewasPublish.click();
		 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
		    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs.get(1));
		  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
		    HelperFunctions.waitForPageToLoad(15);
		   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		    wait1.until(ExpectedConditions.visibilityOf(disclosureRelated));
		HelperFunctions.staticWait(2);
		String actualColor=disclosureRelated.getCssValue("color");
        System.out.println(disclosureRelated.getCssValue("color"));
        HelperFunctions.staticWait(2);
        String expectedColor="rgba(37, 37, 37, 1)";
        Assert.assertEquals(actualColor, expectedColor);
        HelperFunctions.staticWait(3);  
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); 
	     HelperFunctions.staticWait(2);
	        if(disclosureRelated.isDisplayed()) {
	            Assert.assertTrue(true);
	        }else {
	        	 Assert.assertTrue(false);
	        }
	        HelperFunctions.staticWait(3);
	    
	}
public void setEmbedHTML(ExtentTest test) throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 test.info("Wait for the page to load.");
	    //HelperFunctions.waitForPageToLoad(10);
	    
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    test.info("Click on edit");
	    //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    js.executeScript("arguments[0].click();", embedEdit);
	    wait.until(ExpectedConditions.visibilityOf(configure));
	    configure.click();
	    wait.until(ExpectedConditions.visibilityOf(embedTextArea));
	    embedTextArea.click();
	    HelperFunctions.staticWait(2);
	    embedTextArea.sendKeys(Keys.BACK_SPACE);
	    wait.until(ExpectedConditions.visibilityOf(errorIcon));
	    Assert.assertTrue(errorIcon.isDisplayed());
	    HelperFunctions.staticWait(2);
	    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "z"));
	    HelperFunctions.staticWait(2);
	    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    HelperFunctions.staticWait(2);
	    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	    HelperFunctions.staticWait(2);
	    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    wait.until(ExpectedConditions.visibilityOf(embedHeading));
	    Assert.assertTrue(embedHeading.isDisplayed());
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(embedParag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    
	    
}
public void setGettingReport() throws Exception {
	read1.setExcelFile("./testdata.xlsx", "QA");
    //Driver.getDriver().get(read1.getCellData("VALUE", 32));
   // HelperFunctions.waitForPageToLoad(15);
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    wait.until(ExpectedConditions.visibilityOf(pageReport));
    pageReport.click();
    HelperFunctions.waitForPageToLoad(15);
    wait.until(ExpectedConditions.visibilityOf(executeReport));
    executeReport.click();
    wait.until(ExpectedConditions.visibilityOf(workflowElements.get(0)));
    HelperFunctions.staticWait(2);
    List<String> expectedTexts=List.of("Workflow Model","Content Type","Workflow Title","Author Username",
    "Approver email address","Started","Completed","Approval Status","Workflow Status","Content Hyperlink","Days Per Step","Content Version","Approval Notes","Initiator Notes");
    Random random=new Random();
    int randomIndex=random.nextInt(workflowElements.size());
    WebElement selected=workflowElements.get(randomIndex);
    String elementText=selected.getText();
    for(String each:expectedTexts) {
    	if(elementText.contains(each)) {
    		Assert.assertTrue(true);
    		break;
    	}
    }
    HelperFunctions.staticWait(2);
}
public void setVideosonResources(ExtentTest test) throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 test.info("Wait for the page to load.");
	    //HelperFunctions.waitForPageToLoad(10);
	   JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	 try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	 test.info("Wait for preview button and click");
	 //HelperFunctions.staticWait(4);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
	    //wait.until(condition);
	 
	   
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(videoPlayers.size()==0 ||videoPlayers.size()==1);
	    test.info("Verified there is no video is shown on my product page");
	    //HelperFunctions.staticWait(2);
	    test.info("Clicking on video component");
	    //HelperFunctions.scrollToElement(allResourcesVideo);
	    HelperFunctions.staticWait(2);
	    test.info("Click on video component");
	    
	    js.executeScript("arguments[0].click();", allResourcesVideo);
	    HelperFunctions.waitForPageToLoad(60);
	    Driver.getDriver().switchTo().defaultContent();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    //wait.until(ExpectedConditions.visibilityOf(playButtons.get(0)));
	    Assert.assertTrue(playButtons.get(0).isDisplayed());
	    test.info("Verified video component is shown on seperate page");
	    HelperFunctions.staticWait(3);
	   // playButtons.get(0).click();
	   // HelperFunctions.staticWait(5);
	   // Assert.assertTrue(playButtons.size()==2);
	   // HelperFunctions.staticWait(3);
	    
	    
}
public void setLatestLinkAuth() throws Exception {
   read1.setExcelFile("./testdata.xlsx", "QA");
   JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
   try {
   	Thread.sleep(7000);
   }catch(InterruptedException e) {
   	executor.executeScript("arguments[0].click();", pageInfo);
   	e.printStackTrace();
   }

   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);
   //wait.until(ExpectedConditions.elementToBeClickable(editButtonContent));
   
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   editButtonContent.click();
   HelperFunctions.staticWait(3);
	authLatest.click();
	wait.until(ExpectedConditions.visibilityOf(configure));
   configure.click();
	wait.until(ExpectedConditions.elementToBeClickable(authLatestDesc));
	authLatestDesc.click();
	HelperFunctions.staticWait(2);	
	authLatestDesc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	HelperFunctions.staticWait(2);
	hyperlinkButton2.click();
	wait.until(ExpectedConditions.visibilityOf(hrefField));
	HelperFunctions.staticWait(3);
	hrefField.click();
	HelperFunctions.staticWait(3);
	hrefField.clear();
	HelperFunctions.staticWait(3);
	String path="/content/dam/productcentral/en_us/products/enterprise-control/Enterprise_Control_PwC_Architecture_Privacy_Security_and_Operations_Overview.pdf";
	hrefField.sendKeys(path);
	HelperFunctions.staticWait(3);
	
	executor.executeScript("arguments[0].click();", applyButton);
	//applyButton.click();
	wait.until(ExpectedConditions.invisibilityOf(applyButton));
	checkButton.click();
	HelperFunctions.staticWait(5);
	
}
public void setMenuItemChevron(ExtentTest test) throws Exception {
	read1.setExcelFile("./testdata.xlsx", "STG");
	test.info("Wait for the page to load.");
	try {
   	Thread.sleep(7000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
   WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
   //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
   executor.executeScript("arguments[0].click();", pageInfo);
   //pageInfo.click();
   wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
   viewasPublish.click();
	 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
	    HelperFunctions.waitForPageToLoad(30);
	   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
	    test.info("Wait for visibility of menu items");
	    wait1.until(ExpectedConditions.visibilityOf(level1));
	    Assert.assertFalse(level2Title.isDisplayed());
	    test.info("Verified level2 title is not displayed");
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    test.info("Clicking on level 1 chevron");
	   
       executor.executeScript("arguments[0].click();", level1);
       wait1.until(ExpectedConditions.visibilityOf(level2Title));
       //Assert.assertFalse(level3Title.isDisplayed());
       test.info("Verified level 2 is displayed and level 3 is not displayed");
       try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
       test.info("Clicking on level 2 chevron");
       executor.executeScript("arguments[0].click();", level2);
       //level2.click();
       wait1.until(ExpectedConditions.visibilityOf(level3Title));
       Assert.assertTrue(level3Title.isDisplayed());
       test.info("Verified level 3 is displayed");
       HelperFunctions.staticWait(3);
}
public void setCustomizeCookies() throws Exception {
   read1.setExcelFile("./testdata.xlsx", "QA");
   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);
	/*ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
	wait.until(condition);
	previewButton.click();
	//HelperFunctions.staticWait(5);
	Driver.getDriver().switchTo().frame(0);*/
   /*try {
   	if (closeButtonforCookies.isDisplayed()) {
   	   
   		closeButtonforCookies.click();
   	    System.out.println("Close cookies.");
   	} 
   	}catch(NoSuchElementException | StaleElementReferenceException ignored) {
   		
   	}
	//HelperFunctions.staticWait(2);*/
   HelperFunctions.scrollToElement(customizeCookies);
   Assert.assertTrue(customizeCookies.isDisplayed());
	//wait.until(ExpectedConditions.visibilityOf(customizeCookies));
	HelperFunctions.staticWait(3);
}
public void setNewTabAssets(ExtentTest test) throws Exception {
	test.info("Wait for the page to load.");
	//HelperFunctions.waitForPageToLoad(15);
	//Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/automation/my-products/enterprise-control.html");
	try {
   	Thread.sleep(7000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
	  JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	//HelperFunctions.waitForPageToLoad(15);
   WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
   executor.executeScript("arguments[0].click();", pageInfo);
   //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
   //pageInfo.click();
   wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
   viewasPublish.click();
	 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
	    HelperFunctions.waitForPageToLoad(30);
	test.info("Scroll down all resources elements");
	
  // HelperFunctions.staticWait(3);
   test.info("Clicking on resource");
   //String hrefValue = resource2forProduct2.getAttribute("href");
 
   for(WebElement each:allresourcesContentLink) {
   	if(each.getAttribute("href").contains(".pdf")) {
   executor.executeScript("arguments[0].click();", each);
   break;
   	}
   }
   //resource1.click();
   HelperFunctions.staticWait(3);
   test.info("Verified asset/page is loaded in the new tab");
   WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
   wait4.until(ExpectedConditions.numberOfWindowsToBe(3));
   Set<String> windowHandles2 = Driver.getDriver().getWindowHandles();
   Assert.assertEquals(windowHandles2.size(), 3, "Expected three windows to be open, but found " + windowHandles2.size());
	// Assert.assertEquals(hrefValue, currentUrl);
  // Driver.getDriver().close();
  // Driver.getDriver().switchTo().window(tabs.get(1));
  // HelperFunctions.staticWait(3);
	 HelperFunctions.staticWait(3);
}
public void setMyProductPageSearch(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	 HelperFunctions.waitForPageToLoad(20);
	 read1.setExcelFile("./testdata.xlsx", "QA");
	   
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);
		//wait.until(ExpectedConditions.elementToBeClickable(createButton));
	    try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		 //HelperFunctions.staticWait(2);
		test.info("Click on create button");
	    createButton.click();
	    wait.until(ExpectedConditions.visibilityOf(pageButton));
	    test.info("Click on create page button");
	    pageButton.click();
	    wait.until(ExpectedConditions.visibilityOf(myProductPageTemplate));
	    test.info("Click on content page template");
	    myProductPageTemplate.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on next button");
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(60);
	    wait.until(ExpectedConditions.visibilityOf(titleField2));
	    test.info("Click on title field");
	    titleField2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Send text to title field");
	    titleField2.sendKeys("Search Automation");
	    HelperFunctions.staticWait(3);
	    test.info("Click on product central tab");
	    productCentralTab.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Select option from document category ");
	    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
		wait2.until(ExpectedConditions.visibilityOf(myProductDocDropdown));
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
      executor1.executeScript("arguments[0].click();", myProductDocDropdown);
      wait2.until(ExpectedConditions.visibilityOf(myProductDocValue));
	    
      myProductDocValue.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    test.info("Select option from product tag ");
	 
      executor1.executeScript("arguments[0].click();", productTagDropdown);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      productTagValue.click();
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Select option from audience dropdown");
      executor1.executeScript("arguments[0].click();", audienceDropdown2);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      audienceValue.click();
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Clicking on create button");
      createButton2.click();
      test.info("Wait for open button and click on it");
	    wait2.until(ExpectedConditions.visibilityOf(openButton));
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      executor1.executeScript("arguments[0].click();", openButton);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Go to new tab (created my product page)");
      ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    HelperFunctions.waitForPageToLoad(60);
	    try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	 executor1.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	   
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      previewButton.click();
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      Driver.getDriver().switchTo().frame(0);
      wait2.until(ExpectedConditions.visibilityOf(searchInput));
      Assert.assertTrue(searchInput.isDisplayed());
      test.info("Verified search input is displayed");
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Go to AEM page");
      Driver.getDriver().get(read1.getCellData("VALUE", 41));
      HelperFunctions.waitForPageToLoad(60);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Select newly created my product page");
      searchAutomationPage.click();
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      executor1.executeScript("arguments[0].click();", searchAutomationPage);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      executor1.executeScript("arguments[0].click();", searchAutomationPage);
      try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
      test.info("Click on delete");
      delete.click();
      wait2.until(ExpectedConditions.visibilityOf(delete2));
      delete2.click();
      HelperFunctions.staticWait(5);
}
public void setRequiredTagsEachTemplate(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	 HelperFunctions.waitForPageToLoad(20);
	 read1.setExcelFile("./testdata.xlsx", "QA");
	   
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);
		//wait.until(ExpectedConditions.elementToBeClickable(createButton));
	    try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		 //HelperFunctions.staticWait(2);
		test.info("Click on create button");
	    createButton.click();
	    wait.until(ExpectedConditions.visibilityOf(pageButton));
	    test.info("Click on create page button");
	    pageButton.click();
	    wait.until(ExpectedConditions.visibilityOf(myProductPageTemplate));
	    test.info("Click on my product landing page template");
	    myProductPageTemplate.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on next button");
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(60);
	    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
	    test.info("Click on product central tab");
	    productCentralTab.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Select option from document category ");
	    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),10);
		wait2.until(ExpectedConditions.visibilityOf(myProductDocDropdown));
	    Assert.assertTrue(audienceTag2.isDisplayed());
	    test.info("Verified audience tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(myProductDocTag.isDisplayed());
	    test.info("Verified my product document tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(productTag.isDisplayed());
	    test.info("Verified product tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(featureTag.isDisplayed());
	    test.info("Verified feature tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(portfolioTag3.isDisplayed());
	    test.info("Verified portfolio tag is displayed");
	    HelperFunctions.staticWait(2);
	    
     test.info("Go to AEM page");
     Driver.getDriver().get(read1.getCellData("VALUE", 41));
     HelperFunctions.waitForPageToLoad(60);
     try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		 //HelperFunctions.staticWait(2);
		test.info("Click on create button");
	    createButton.click();
	    wait.until(ExpectedConditions.visibilityOf(pageButton));
	    test.info("Click on create page button");
	    pageButton.click();
	    wait.until(ExpectedConditions.visibilityOf(contentPageTemplate));
	    test.info("Click on content page template");
	    contentPageTemplate.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on next button");
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(60);
	    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
	    test.info("Click on product central tab");
	    productCentralTab.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Select option from document category ");
		wait2.until(ExpectedConditions.visibilityOf(myProductDocDropdown));
		Assert.assertTrue(audienceTag2.isDisplayed());
		test.info("Verified audience tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(myProductDocTag.isDisplayed());
	    test.info("Verified my product doc tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(productTag.isDisplayed());
	    test.info("Verified product tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(featureTag.isDisplayed());
	    test.info("Verified feature tag is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(portfolioTag3.isDisplayed());
	    test.info("Verified portfolio tag is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Go to AEM page");
	      Driver.getDriver().get(read1.getCellData("VALUE", 41));
	      HelperFunctions.waitForPageToLoad(60);
	      try {
		    	Thread.sleep(7000);
		    }catch(InterruptedException e) {
		    	e.printStackTrace();
		    }
			 //HelperFunctions.staticWait(2);
			test.info("Click on create button");
		    createButton.click();
		    wait.until(ExpectedConditions.visibilityOf(pageButton));
		    test.info("Click on create page button");
		    pageButton.click();
		    wait.until(ExpectedConditions.visibilityOf(generalArticlePageTemplate));
		    test.info("Click on general article page template");
		    generalArticlePageTemplate.click();
		    HelperFunctions.staticWait(3);
		    test.info("Click on next button");
		    nextButton.click();
		    HelperFunctions.waitForPageToLoad(60);
		    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
		    test.info("Click on product central tab");
		    productCentralTab.click();
		    //HelperFunctions.staticWait(3);
		    test.info("Select option from document category ");
			wait2.until(ExpectedConditions.visibilityOf(myProductDocDropdown));
			Assert.assertTrue(audienceTag2.isDisplayed());
			test.info("Verified audience tag is displayed");
		    HelperFunctions.staticWait(2);
		    Assert.assertTrue(myProductDocTag.isDisplayed());
		    test.info("Verified my product doc tag is displayed");
		    HelperFunctions.staticWait(2);
		    Assert.assertTrue(productTag.isDisplayed());
		    test.info("Verified product tag is displayed");
		    HelperFunctions.staticWait(2);
		    Assert.assertTrue(featureTag.isDisplayed());
		    test.info("Verified feature tag is displayed");
		    HelperFunctions.staticWait(2);
		    Assert.assertTrue(portfolioTag3.isDisplayed());
		    test.info("Verified portfolio tag is displayed");
		    HelperFunctions.staticWait(2);
		    test.info("Go to AEM page");
		      Driver.getDriver().get(read1.getCellData("VALUE", 41));
		      HelperFunctions.waitForPageToLoad(60);
		      try {
			    	Thread.sleep(7000);
			    }catch(InterruptedException e) {
			    	e.printStackTrace();
			    }
				 //HelperFunctions.staticWait(2);
				test.info("Click on create button");
			    createButton.click();
			    wait.until(ExpectedConditions.visibilityOf(pageButton));
			    test.info("Click on create page button");
			    pageButton.click();
			    wait.until(ExpectedConditions.visibilityOf(homePageTemplate));
			    test.info("Click on home page template");
			    homePageTemplate.click();
			    HelperFunctions.staticWait(3);
			    test.info("Click on next button");
			    nextButton.click();
			    HelperFunctions.waitForPageToLoad(60);
			    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
			    test.info("Click on product central tab");
			    productCentralTab.click();
			    HelperFunctions.staticWait(3);
			    test.info("Select option from document category ");
				//wait2.until(ExpectedConditions.visibilityOf(myProductDocDropdown));
				Assert.assertFalse(audienceTag2.isDisplayed());
				test.info("Verified audience tag is NOT displayed");
			    HelperFunctions.staticWait(2);
			    //Assert.assertTrue(myProductDocTag.isDisplayed());
			    //HelperFunctions.staticWait(2);
			    Assert.assertFalse(productTag.isDisplayed());
			    test.info("Verified product tag is NOT displayed");
			    HelperFunctions.staticWait(2);
			    Assert.assertFalse(featureTag.isDisplayed());
			    test.info("Verified feature tag is NOT displayed");
			    HelperFunctions.staticWait(2);
			    Assert.assertFalse(portfolioTag3.isDisplayed());
			    test.info("Verified portfolio tag is NOT displayed");
			    HelperFunctions.staticWait(2);
			    test.info("Go to AEM page");
			      Driver.getDriver().get(read1.getCellData("VALUE", 41));
			      HelperFunctions.waitForPageToLoad(60);
			      try {
				    	Thread.sleep(7000);
				    }catch(InterruptedException e) {
				    	e.printStackTrace();
				    }
					 //HelperFunctions.staticWait(2);
					test.info("Click on create button");
				    createButton.click();
				    wait.until(ExpectedConditions.visibilityOf(pageButton));
				    test.info("Click on create page button");
				    pageButton.click();
				    wait.until(ExpectedConditions.visibilityOf(landingPageTemplate));
				    test.info("Click on landing page template");
				    landingPageTemplate.click();
				    HelperFunctions.staticWait(3);
				    test.info("Click on next button");
				    nextButton.click();
				    HelperFunctions.waitForPageToLoad(60);
				    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
				    test.info("Click on product central tab");
				    productCentralTab.click();
				    test.info("Select option from document category ");
					wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
					Assert.assertTrue(audienceTag2.isDisplayed());
					test.info("Verified audience tag is displayed");
				    HelperFunctions.staticWait(2);
				    //Assert.assertTrue(myProductDocTag.isDisplayed());
				    //HelperFunctions.staticWait(2);
				    Assert.assertTrue(productTag.isDisplayed());
				    test.info("Verified product tag is displayed");
				    HelperFunctions.staticWait(2);
				    Assert.assertFalse(featureTag.isDisplayed());
				    test.info("Verified feature tag is NOT displayed");
				    HelperFunctions.staticWait(2);
				    Assert.assertFalse(portfolioTag3.isDisplayed());
				    test.info("Verified portfolio tag is NOT displayed");
				    HelperFunctions.staticWait(2);
				    test.info("Go to AEM page");
				      Driver.getDriver().get(read1.getCellData("VALUE", 41));
				      HelperFunctions.waitForPageToLoad(60);
				      try {
					    	Thread.sleep(7000);
					    }catch(InterruptedException e) {
					    	e.printStackTrace();
					    }
						 //HelperFunctions.staticWait(2);
						test.info("Click on create button");
					    createButton.click();
					    wait.until(ExpectedConditions.visibilityOf(pageButton));
					    test.info("Click on create page button");
					    pageButton.click();
					    wait.until(ExpectedConditions.visibilityOf(legalPageTemplate));
					    test.info("Click on legal page template");
					    legalPageTemplate.click();
					    HelperFunctions.staticWait(3);
					    test.info("Click on next button");
					    nextButton.click();
					    HelperFunctions.waitForPageToLoad(60);
					    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
					    test.info("Click on product central tab");
					    productCentralTab.click();
					    test.info("Select option from document category ");
						wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
						Assert.assertTrue(audienceTag2.isDisplayed());
						test.info("Verified audience tag is displayed");
					    HelperFunctions.staticWait(2);
					    Assert.assertFalse(myProductDocTag.isDisplayed());
					    test.info("Verified my product doc tag is NOT displayed");
					    //HelperFunctions.staticWait(2);
					    Assert.assertFalse(productTag.isDisplayed());
					    test.info("Verified product tag is NOT displayed");
					    HelperFunctions.staticWait(2);
					    Assert.assertFalse(featureTag.isDisplayed());
					    test.info("Verified feature tag is NOT displayed");
					    HelperFunctions.staticWait(2);
					    Assert.assertFalse(portfolioTag3.isDisplayed());
					    test.info("Verified portfolio tag is NOT displayed");
					    HelperFunctions.staticWait(2);
					    test.info("Go to AEM page");
					      Driver.getDriver().get(read1.getCellData("VALUE", 41));
					      HelperFunctions.waitForPageToLoad(60);
					      try {
						    	Thread.sleep(7000);
						    }catch(InterruptedException e) {
						    	e.printStackTrace();
						    }
							 //HelperFunctions.staticWait(2);
							test.info("Click on create button");
						    createButton.click();
						    wait.until(ExpectedConditions.visibilityOf(pageButton));
						    test.info("Click on create page button");
						    pageButton.click();
						    wait.until(ExpectedConditions.visibilityOf(productListingPageTemplate));
						    test.info("Click on product listing page template");
						    productListingPageTemplate.click();
						    HelperFunctions.staticWait(3);
						    test.info("Click on next button");
						    nextButton.click();
						    HelperFunctions.waitForPageToLoad(60);
						    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
						    test.info("Click on product central tab");
						    productCentralTab.click();
						    test.info("Select option from document category ");
							wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
							Assert.assertTrue(audienceTag2.isDisplayed());
							test.info("Verified audience tag is displayed");
						    HelperFunctions.staticWait(2);
						    Assert.assertFalse(myProductDocTag.isDisplayed());
						    test.info("Verified my product doc tag is NOT displayed");
						    HelperFunctions.staticWait(2);
						    Assert.assertFalse(productTag.isDisplayed());
						    test.info("Verified product tag is NOT displayed");
						    HelperFunctions.staticWait(2);
						    Assert.assertFalse(featureTag.isDisplayed());
						    test.info("Verified feature tag is NOT displayed");
						    HelperFunctions.staticWait(2);
						    Assert.assertFalse(portfolioTag3.isDisplayed());
						    test.info("Verified portfolio tag is NOT displayed");
						    HelperFunctions.staticWait(2);
						    test.info("Go to AEM page");
						      Driver.getDriver().get(read1.getCellData("VALUE", 41));
						      HelperFunctions.waitForPageToLoad(60);
						      try {
							    	Thread.sleep(7000);
							    }catch(InterruptedException e) {
							    	e.printStackTrace();
							    }
								 //HelperFunctions.staticWait(2);
								test.info("Click on create button");
							    createButton.click();
							    wait.until(ExpectedConditions.visibilityOf(pageButton));
							    test.info("Click on create page button");
							    pageButton.click();
							    wait.until(ExpectedConditions.visibilityOf(productPageTemplate));
							    test.info("Click on product page template");
							    productPageTemplate.click();
							    HelperFunctions.staticWait(3);
							    test.info("Click on next button");
							    nextButton.click();
							    HelperFunctions.waitForPageToLoad(60);
							    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
							    test.info("Click on product central tab");
							    productCentralTab.click();
							    test.info("Select option from document category ");
								wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
								Assert.assertTrue(audienceTag2.isDisplayed());
								test.info("Verified audience tag is displayed");
							    HelperFunctions.staticWait(2);
							    Assert.assertTrue(myProductDocTag.isDisplayed());
							    test.info("Verified my product doc tag is displayed");
							    HelperFunctions.staticWait(2);
							    Assert.assertTrue(productTag.isDisplayed());
							    test.info("Verified product tag is displayed");
							    HelperFunctions.staticWait(2);
							    Assert.assertTrue(featureTag.isDisplayed());
							    test.info("Verified feature tag is displayed");
							    HelperFunctions.staticWait(2);
							    Assert.assertTrue(portfolioTag3.isDisplayed());
							    test.info("Verified portfolio tag is displayed");
							    HelperFunctions.staticWait(2);
							    test.info("Go to AEM page");
							      Driver.getDriver().get(read1.getCellData("VALUE", 41));
							      HelperFunctions.waitForPageToLoad(60);
							      try {
								    	Thread.sleep(7000);
								    }catch(InterruptedException e) {
								    	e.printStackTrace();
								    }
									 //HelperFunctions.staticWait(2);
									test.info("Click on create button");
								    createButton.click();
								    wait.until(ExpectedConditions.visibilityOf(pageButton));
								    test.info("Click on create page button");
								    pageButton.click();
								    wait.until(ExpectedConditions.visibilityOf(resellerPageTemplate));
								    test.info("Click on reseller page template");
								    resellerPageTemplate.click();
								    HelperFunctions.staticWait(3);
								    test.info("Click on next button");
								    nextButton.click();
								    HelperFunctions.waitForPageToLoad(60);
								    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
								    test.info("Click on product central tab");
								    productCentralTab.click();
								    test.info("Select option from document category ");
									wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
									Assert.assertTrue(audienceTag2.isDisplayed());
									test.info("Verified audience tag is displayed");
								    HelperFunctions.staticWait(2);
								    Assert.assertFalse(myProductDocTag.isDisplayed());
								    test.info("Verified my product doc tag is NOT displayed");
								    HelperFunctions.staticWait(2);
								    Assert.assertFalse(productTag.isDisplayed());
								    test.info("Verified product tag is NOT displayed");
								    HelperFunctions.staticWait(2);
								    Assert.assertFalse(featureTag.isDisplayed());
								    test.info("Verified feature tag is NOT displayed");
								    HelperFunctions.staticWait(2);
								    Assert.assertFalse(portfolioTag3.isDisplayed());
								    test.info("Verified portfolio tag is NOT displayed");
								    HelperFunctions.staticWait(2);
								    test.info("Go to AEM page");
								      Driver.getDriver().get(read1.getCellData("VALUE", 41));
								      HelperFunctions.waitForPageToLoad(60);
								      try {
									    	Thread.sleep(7000);
									    }catch(InterruptedException e) {
									    	e.printStackTrace();
									    }
										 //HelperFunctions.staticWait(2);
										test.info("Click on create button");
									    createButton.click();
									    wait.until(ExpectedConditions.visibilityOf(pageButton));
									    test.info("Click on create page button");
									    pageButton.click();
									    wait.until(ExpectedConditions.visibilityOf(searchResultPageTemplate));
									    test.info("Click on search result page template");
									    searchResultPageTemplate.click();
									    HelperFunctions.staticWait(3);
									    test.info("Click on next button");
									    nextButton.click();
									    HelperFunctions.waitForPageToLoad(60);
									    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
									    test.info("Click on product central tab");
									    productCentralTab.click();
									    test.info("Select option from document category ");
										wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
										Assert.assertTrue(audienceTag2.isDisplayed());
										test.info("Verified audience tag is displayed");
									    HelperFunctions.staticWait(2);
									    Assert.assertFalse(myProductDocTag.isDisplayed());
									    test.info("Verified my product doc tag is NOT displayed");
									    HelperFunctions.staticWait(2);
									    Assert.assertFalse(productTag.isDisplayed());
									    test.info("Verified product tag is NOT displayed");
									    HelperFunctions.staticWait(2);
									    Assert.assertFalse(featureTag.isDisplayed());
									    test.info("Verified feature tag is NOT displayed");
									    HelperFunctions.staticWait(2);
									    Assert.assertFalse(portfolioTag3.isDisplayed());
									    test.info("Verified portfolio tag is NOT displayed");
									    HelperFunctions.staticWait(2);
									    test.info("Go to AEM page");
									      Driver.getDriver().get(read1.getCellData("VALUE", 41));
									      HelperFunctions.waitForPageToLoad(60);
									      try {
										    	Thread.sleep(7000);
										    }catch(InterruptedException e) {
										    	e.printStackTrace();
										    }
											 //HelperFunctions.staticWait(2);
											test.info("Click on create button");
										    createButton.click();
										    wait.until(ExpectedConditions.visibilityOf(pageButton));
										    test.info("Click on create page button");
										    pageButton.click();
										    wait.until(ExpectedConditions.visibilityOf(tableContentPageTemplate));
										    test.info("Click on table content page template");
										    tableContentPageTemplate.click();
										    HelperFunctions.staticWait(3);
										    test.info("Click on next button");
										    nextButton.click();
										    HelperFunctions.waitForPageToLoad(60);
										    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
										    test.info("Click on product central tab");
										    productCentralTab.click();
										    test.info("Select option from document category ");
											wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
											Assert.assertTrue(audienceTag2.isDisplayed());
											test.info("Verified audience tag is displayed");
										    HelperFunctions.staticWait(2);
										    Assert.assertFalse(myProductDocTag.isDisplayed());
										    test.info("Verified my product doc tag is NOT displayed");
										    HelperFunctions.staticWait(2);
										    Assert.assertFalse(productTag.isDisplayed());
										    test.info("Verified product tag is NOT displayed");
										    HelperFunctions.staticWait(2);
										    Assert.assertFalse(featureTag.isDisplayed());
										    test.info("Verified feature tag is NOT displayed");
										    HelperFunctions.staticWait(2);
										    Assert.assertFalse(portfolioTag3.isDisplayed());
										    test.info("Verified portfolio tag is NOT displayed");
										    HelperFunctions.staticWait(2);
										    test.info("Go to AEM page");
										      Driver.getDriver().get(read1.getCellData("VALUE", 41));
										      HelperFunctions.waitForPageToLoad(60);
										      try {
											    	Thread.sleep(7000);
											    }catch(InterruptedException e) {
											    	e.printStackTrace();
											    }
												 //HelperFunctions.staticWait(2);
												test.info("Click on create button");
											    createButton.click();
											    wait.until(ExpectedConditions.visibilityOf(pageButton));
											    test.info("Click on create page button");
											    pageButton.click();
											    wait.until(ExpectedConditions.visibilityOf(sitemapPageTemplate));
											    test.info("Click on sitemap page template");
											    sitemapPageTemplate.click();
											    HelperFunctions.staticWait(3);
											    test.info("Click on next button");
											    nextButton.click();
											    HelperFunctions.waitForPageToLoad(60);
											    wait.until(ExpectedConditions.visibilityOf(productCentralTab));
											    test.info("Click on product central tab");
											    productCentralTab.click();
											    HelperFunctions.staticWait(3);
											    test.info("Select option from document category ");
												//wait2.until(ExpectedConditions.visibilityOf(audienceTag2));
												Assert.assertFalse(audienceTag2.isDisplayed());
												test.info("Verified audience tag is NOT displayed");
											    HelperFunctions.staticWait(2);
											    
  
}
public void setColumnImage(ExtentTest test) throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 test.info("Wait for the page to load.");
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	 try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    //HelperFunctions.waitForPageToLoad(10);
	
	 test.info("Wait for edit button visibility and click on it");
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	   // ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    //wait.until(condition);
	   
	    //pageInfo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	  /*  test.info("Click on edit");
	    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    js.executeScript("arguments[0].click();", columnImgEdit);
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(configure));
	    configure.click();
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(pick2));
	    pick2.click();
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(path1));
	    path1.click();
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(path2));
	    path2.click();
	    HelperFunctions.staticWait(2);
	    selectButton2.click();
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);*/
	    test.info("Click on column img edit thumbnail");
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", columnImgEditThumb);
	    test.info("Click on configure");
	    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 30);
	    wait5.until(ExpectedConditions.visibilityOf(configure));
	    configure.click();
	    test.info("Click on first path");
	    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 30);
	    wait6.until(ExpectedConditions.visibilityOf(path3));
	    path3.click();
	    test.info("Click on second path");
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 30);
	    wait7.until(ExpectedConditions.visibilityOf(path4));
	    path4.click();
	    HelperFunctions.staticWait(2);
	    test.info("Click on select button");
	    selectButton2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on check icon");
	    checkIcon.click();
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	   
	    //pageInfo.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton.click();
	    Driver.getDriver().switchTo().frame(0);
	    test.info("Switching iframe and wait for thumbnail img's visibility");
	    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 30);
	    wait8.until(ExpectedConditions.visibilityOf(thumbImg));
	    Assert.assertTrue(thumbImg.isDisplayed());
	    test.info("Verified thumbnail visibility");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(thumbText.isDisplayed());
	    test.info("Verified thumbnail path");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(searchInput.isDisplayed());
	    test.info("Verified search field is displayed");
	    HelperFunctions.staticWait(3);
	    
	    
}public void setHorizontalDivider(ExtentTest test) throws Exception {
	  // HelperFunctions.waitForPageToLoad(5);
	//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	   //HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	try {
   	Thread.sleep(7000);
   }catch(InterruptedException e) {
   	 js.executeScript("arguments[0].click();", pageInfo);
   	e.printStackTrace();
   }

	test.info("Wait for edit button visibility and click on it");
	   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	   //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait.until(condition);
	  
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   editButtonContent.click();
	   test.info("Wait for side panel visibility and click on it");
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   //wait.until(ExpectedConditions.visibilityOf(sidePanel));
	   js.executeScript("arguments[0].click();", sidePanel);
	   //sidePanel.click();
	   test.info("Wait for expand all visibility and click on it");
	   wait.until(ExpectedConditions.visibilityOf(expandAll));
	   expandAll.click();
	   HelperFunctions.staticWait(7);
	   test.info("Drag divider and drop it to the page");
	   Actions actions = new Actions(Driver.getDriver());
	   actions.clickAndHold(dividerDrag).build().perform();
	   HelperFunctions.staticWait(3);
	   actions.release(dividerDrop).build().perform();

	   //actions.dragAndDrop(dividerDrag, dividerDrop).build().perform();
	   try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	  // wait.until(ExpectedConditions.visibilityOf(pageInfo));
	  
	   try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   previewButton.click();
	   Driver.getDriver().switchTo().frame(0);
	   test.info("Switching to iframe and wait for divider visibility");
	   WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
	   wait1.until(ExpectedConditions.visibilityOf(divider));
    Assert.assertTrue(divider.isDisplayed());
    test.info("Verified divider is displayed");
    Driver.getDriver().switchTo().defaultContent();
    test.info("Switching back to default content and click on edit button");
    //WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),30);
	  // ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait2.until(condition2);
    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
 	
   
	    HelperFunctions.staticWait(3);
	   editButtonContent.click();
	   try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   test.info("Click on divider edit");
	   //WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 30);
	   //wait3.until(ExpectedConditions.visibilityOf(dividerEdit));
	   //dividerEdit.click();
	   JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	     executor.executeScript("arguments[0].click();", dividerEdit);
	   test.info("Wait for divider delete button and click on it");
	   WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
	   wait4.until(ExpectedConditions.visibilityOf(ef2Delete));
	   ef2Delete.click();
	   test.info("Wait for delete confirmation button and click on it");
	   WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 30);
	   wait5.until(ExpectedConditions.visibilityOf(deleteConfirm));
	   deleteConfirm.click();
	   HelperFunctions.staticWait(5);
	  
	}

public void setColumnImgaeModal(ExtentTest test) throws Exception {
	  // HelperFunctions.waitForPageToLoad(5);
	//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/faqs.html");
	   //HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	try {
   	Thread.sleep(5000);
   }catch(InterruptedException e) {
   	  js.executeScript("arguments[0].click();", pageInfo);
   	e.printStackTrace();
   }
	test.info("Wait for coloumn image visibility");
	   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);
	   //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
	   //wait.until(condition);
	   HelperFunctions.staticWait(5);
	 	
	  
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	   previewButton.click();
	   HelperFunctions.staticWait(3);
	   previewButton.click();
	   Driver.getDriver().switchTo().frame(0);
	   wait.until(ExpectedConditions.visibilityOf(coloumImgPublish));
	   test.info("Click on it");
	   coloumImgPublish.click();
	   wait.until(ExpectedConditions.visibilityOf(coloumImgModal));
    Assert.assertTrue(coloumImgModal.isDisplayed());   
    test.info("Verified it opens in the modal window");
	   HelperFunctions.staticWait(5);
	  
	}
public void setTopLevel(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	   // HelperFunctions.waitForPageToLoad(10);
	read1.setExcelFile("./testdata.xlsx", "QA");
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	try {
   	Thread.sleep(7000);
   }catch(InterruptedException e) {
   	js.executeScript("arguments[0].click();", pageInfo);
   	e.printStackTrace();
   }
	
   
   try {
   	Thread.sleep(3000);
   }catch(InterruptedException e) {
   	e.printStackTrace();
   }
   previewButton.click();
	    //WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 30);
	   // wait5.until(ExpectedConditions.visibilityOf(previewButton));
	   // previewButton.click();
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(3);
	    for (WebElement element: childTitle) {
	    	if(element.isDisplayed()) {
	    	}else {
	    		HelperFunctions.scrollToElement(element);
	    		//break;
	    	}
	    }
	    HelperFunctions.staticWait(3);
	    for (WebElement element2: childTitle2) {
	    	if(element2.isDisplayed()) {
	    	}else {
	    		HelperFunctions.scrollToElement(element2);
	    		//break;
	    	}
	    }
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(childTitle3.size()==0);  
	    HelperFunctions.staticWait(3);
}
public void setMandatoryPCtags(ExtentTest test) throws Exception {
 	
	test.info("Wait for product central tab's clickability and click on it");
   	//HelperFunctions.waitForPageToLoad(15);
	try {
    	Thread.sleep(7000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
   	//WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),30);
    //ExpectedCondition<WebElement> condition3=ExpectedConditions.elementToBeClickable(productCentralTab);
    //wait3.until(condition3);
   	executor.executeScript("arguments[0].click();", productCentralTab);
    //HelperFunctions.staticWait(3);
    //productCentralTab.click();
    test.info("Wait for dropdown's visibility");
    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
    wait4.until(ExpectedConditions.visibilityOf(myproductDropdown));
    test.info("Click on my product dropdown");
    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", myproductDropdown);
    //documentCategoryTag2.click();
    test.info("Click on empty element");
    wait4.until(ExpectedConditions.visibilityOf(myDocumentList.get(0)));
    myDocumentList.get(0).click();
    HelperFunctions.staticWait(2);
    test.info("Click on audience dropdown");
    executor10.executeScript("arguments[0].click();", audienceDropdown);
    test.info("Click on empty element");
    wait4.until(ExpectedConditions.visibilityOf(audienceList.get(0)));
    audienceList.get(0).click();
    HelperFunctions.staticWait(2);
    test.info("Click on product feature dropdown");
    executor10.executeScript("arguments[0].click();", pfDropdown);
    test.info("Click on empty element");
    wait4.until(ExpectedConditions.visibilityOf(pfList.get(0)));
    pfList.get(0).click();
    HelperFunctions.staticWait(2);
    test.info("Click on audience dropdown");
    executor10.executeScript("arguments[0].click();", portfolioDropdown);
    test.info("Click on empty element");
    wait4.until(ExpectedConditions.visibilityOf(portfolioList.get(0)));
    portfolioList.get(0).click();
    HelperFunctions.staticWait(5);
    
    
    if(errorList.size()>=3) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
    test.info("Verified error messages");
    HelperFunctions.staticWait(3);
    
}
public void setTableContent(ExtentTest test) throws Exception {
	 test.info("Wait for edit button visibility and click on it");
	   // HelperFunctions.waitForPageToLoad(10);
	read1.setExcelFile("./testdata.xlsx", "QA");
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	try {
    	Thread.sleep(7000);
    }catch(InterruptedException e) {
    	executor.executeScript("arguments[0].click();", pageInfo);
    	e.printStackTrace();
    }
	
    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
    
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    test.info("Click on edit table content");
	    editTable.click();
	    test.info("Click on configure");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
	    wait1.until(ExpectedConditions.visibilityOf(configure));
	    configure.click();
	    test.info("Wait for text area and click on it");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 30);
	    wait2.until(ExpectedConditions.visibilityOf(textArea2));
	    textArea2.click();
	    test.info("Choose all and copy them");
	    HelperFunctions.staticWait(2);    
	    textArea2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    HelperFunctions.staticWait(2);
	    textArea2.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	    HelperFunctions.staticWait(2);
	    test.info("Click on check icon");
	    checkIcon.click();
	    HelperFunctions.staticWait(5);
	    test.info("Click on create table");
	    createTable.click();
	    test.info("Click on insert");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 15);
	    wait3.until(ExpectedConditions.visibilityOf(insert));
	    insert.click();
	    test.info("Click on enter keyword");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 15);
	    wait4.until(ExpectedConditions.visibilityOf(enterKeyword));
	    enterKeyword.click();
	    test.info("Sends key as text");
	    HelperFunctions.staticWait(2);
	    enterKeyword.sendKeys("Text");
	    test.info("Click on insert text");
	    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 15);
	    wait5.until(ExpectedConditions.visibilityOf(insertText));
	    insertText.click();
	    HelperFunctions.staticWait(2);
	    test.info("Click on text edit");
	    textEdit.click();
	    test.info("Click on configure");
	    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 15);
	    wait6.until(ExpectedConditions.visibilityOf(configure));
	    configure.click();
	    test.info("Click on text area");
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 15);
	    wait7.until(ExpectedConditions.visibilityOf(textArea2));
	    textArea2.click();
	    HelperFunctions.staticWait(2);
	    test.info("Paste copied text");
	    textArea2.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	    HelperFunctions.staticWait(2);
	    test.info("Click on check icon");
	    checkIcon.click();
	    try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	executor.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    previewButton.click();
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(tables.size()>1);
	    test.info("Verified the table size");
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().switchTo().defaultContent();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	executor.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    test.info("Click on edit button");
	    
	    HelperFunctions.staticWait(3);
	    editButtonContent.click();
	    test.info("Click on text edit");
	    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 15);
	    wait8.until(ExpectedConditions.visibilityOf(textEdit));
	    textEdit.click();  
	    test.info("Click on delete button");
	    WebDriverWait wait9 = new WebDriverWait(Driver.getDriver(), 10);
		wait9.until(ExpectedConditions.visibilityOf(ef2Delete));
		ef2Delete.click();
		test.info("Click on delete confirmation button");
	    WebDriverWait wait10 = new WebDriverWait(Driver.getDriver(), 10);
		wait10.until(ExpectedConditions.visibilityOf(deleteConfirm));
		deleteConfirm.click();
		HelperFunctions.staticWait(5);
}
public void setHideBreadcrumbs(ExtentTest test) throws Exception {
	 test.info("Wait for preview button and click on it");
	   // HelperFunctions.waitForPageToLoad(10);
	 JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	read1.setExcelFile("./testdata.xlsx", "QA");
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	js.executeScript("arguments[0].click();", pageInfo);
    	e.printStackTrace();
    }
 	
    
    try {
    	Thread.sleep(3000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
    previewButton.click();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
	    //wait.until(ExpectedConditions.visibilityOf(previewButton));
	    //previewButton.click();
	    test.info("Switching iframe");
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(5);
	    for (WebElement element: myProductBreadcrumbs) {
	    	if(element.getText().contains("breadcrumbs")) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified breadcrumbs visibility");
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().switchTo().defaultContent();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    test.info("Switch on default content and click on edit button");
	   
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
	    //wait1.until(ExpectedConditions.visibilityOf(editButtonContent));
	    editButtonContent.click();
	    test.info("Click on page info");
	    try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) { 	
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    test.info("Click on properties");
	    //WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 15);
	    wait1.until(ExpectedConditions.visibilityOf(properties2));
	    properties2.click();
	    test.info("Wait for breadcrumb checkbox and click on it");
	    //WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 20);
	    wait1.until(ExpectedConditions.visibilityOf(breadcrumbCheckbox));
	    breadcrumbCheckbox.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on save and close");
	    saveAndClose.click();
	    test.info("VWait for page to load");
	    HelperFunctions.waitForPageToLoad(90);
	    try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	    	js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 15);
	    //wait1.until(ExpectedConditions.visibilityOf(previewButton));
	    previewButton.click();
	    Driver.getDriver().switchTo().frame(0);
	    test.info("Switching iframe");
	    HelperFunctions.staticWait(5);
	    for (WebElement element: myProductBreadcrumbs) {
	    	if(!element.getText().contains("breadcrumbs")) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified breadcrumbs are not displayed");
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().switchTo().defaultContent();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	 js.executeScript("arguments[0].click();", pageInfo);
	    	e.printStackTrace();
	    }
	    test.info("Switching default content and click on edit button");
	    //WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 15);
	   
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //wait1.until(ExpectedConditions.visibilityOf(editButtonContent));
	    editButtonContent.click();
	    test.info("Click on page info");
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    js.executeScript("arguments[0].click();", pageInfo);
	    test.info("Click on properties");
	    //WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 15);
	    wait1.until(ExpectedConditions.visibilityOf(properties2));
	    properties2.click();
	    test.info("Wait for breadcrumb checkbox and click on it");
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 20);
	    wait7.until(ExpectedConditions.visibilityOf(breadcrumbCheckbox));
	    breadcrumbCheckbox.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on save and close");
	    saveAndClose.click();
	    //HelperFunctions.waitForPageToLoad(30);
	    HelperFunctions.staticWait(15);
	    
}
public void setChildPageUpdate(ExtentTest test) throws Exception {
	 test.info("Wait for page info and click on it");
	 try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	read1.setExcelFile("./testdata.xlsx", "QA");
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
    executor.executeScript("arguments[0].click();", pageInfo);
    //HelperFunctions.staticWait(3);
	    test.info("Click on publish icon");
	    wait.until(ExpectedConditions.visibilityOf(publishIcon));
	    publishIcon.click();
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().get(read1.getCellData("VALUE", 80));
	    HelperFunctions.waitForPageToLoad(30);
	    wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    pageInfo.click();
	    wait.until(ExpectedConditions.visibilityOf(publishIcon));
	    publishIcon.click();
	    HelperFunctions.staticWait(3);
	    ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 15));
	    HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(5);
		JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("window.scrollBy(0,250)", "");
	    HelperFunctions.staticWait(3);
	    logintoMyproducts.click();
		HelperFunctions.waitForPageToLoad(20);
		//((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
	    //ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(0));
	    Driver.getDriver().get(read1.getCellData("VALUE", 88));
	    HelperFunctions.waitForPageToLoad(30);
	    Assert.assertTrue(forYouTitles.get(0).getAttribute("href").contains("child"));
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().get(read1.getCellData("VALUE", 83));
	    HelperFunctions.waitForPageToLoad(15);
	    wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    pageInfo.click();
	    wait.until(ExpectedConditions.visibilityOf(publishIcon));
	    publishIcon.click();
	    HelperFunctions.staticWait(3);
	    
}
public void setInternalOnly(ExtentTest test) throws Exception {
 	
	test.info("Wait for product central tab is clickable then click on it");
   	//HelperFunctions.waitForPageToLoad(15);
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   	WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),30);
    //ExpectedCondition<WebElement> condition3=ExpectedConditions.elementToBeClickable(productCentralTab);
    //wait3.until(condition3);
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("arguments[0].click();", productCentralTab);
    //productCentralTab.click();
    test.info("Wait for audience dropdown and click on it");
    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
    wait4.until(ExpectedConditions.visibilityOf(audienceDropdown));
    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", audienceDropdown);
    //HelperFunctions.staticWait(2);
    wait4.until(ExpectedConditions.visibilityOf(audienceList.get(1)));
    for(int i = 1; i < audienceList.size(); i++) {
    	WebElement element=audienceList.get(i);
    	String elementText=element.getText();
    	if(elementText.contains("Internal Only")) {
    		Assert.assertTrue(true);
    		break;
    	
    	}
    }
    test.info("Verified dropdown contains internal only text");
    HelperFunctions.staticWait(2);
    executor10.executeScript("arguments[0].click();", audienceDropdown);
    HelperFunctions.staticWait(2);
    Assert.assertTrue(portfolioDropdown.isDisplayed());
    HelperFunctions.staticWait(3);
    
    }
public void setInternalOnly2(ExtentTest test) throws Exception {
 	
	test.info("Wait for page info");
	try {
    	Thread.sleep(10000);
    }catch(InterruptedException e) {
    	e.printStackTrace();
    }
   	//HelperFunctions.waitForPageToLoad(15);
   	WebDriverWait wait3=new WebDriverWait(Driver.getDriver(),30);
    //ExpectedCondition<WebElement> condition3=ExpectedConditions.elementToBeClickable(pageInfo);
    //wait3.until(condition3);
   	//HelperFunctions.staticWait(5);
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("arguments[0].click();", pageInfo);
    //pageInfo.click();
    test.info("Click on properties");
    //WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 15);
    wait3.until(ExpectedConditions.visibilityOf(properties2));
    properties2.click();
    test.info("Wait for product details tab on click on it");
    HelperFunctions.waitForPageToLoad(15);
    wait3.until(ExpectedConditions.visibilityOf(productDetailsTab));
    productDetailsTab.click();
    test.info("Wait audience tag and click on it");
    wait3.until(ExpectedConditions.visibilityOf(audienceTag));  
    JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", audienceTag);
    wait3.until(ExpectedConditions.visibilityOf(audienceList.get(1)));
    for(int i = 1; i < audienceList.size(); i++) {
    	WebElement element=audienceList.get(i);
    	String elementText=element.getText();
    	if(elementText.contains("Internal Only")) {
    		Assert.assertTrue(true);
    		break;
    	
    	}
    }
    test.info("Verified dropdown contains internal only text");
    HelperFunctions.staticWait(2);
   /* if(errorList.size()>=3) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
    
    HelperFunctions.staticWait(2);*/
    executor10.executeScript("arguments[0].click();", audienceTag);
    HelperFunctions.staticWait(2);
    Assert.assertTrue(portfolioTag.isDisplayed());
    HelperFunctions.staticWait(3);
    }
public void setRelatedLinksTextandSticky(ExtentTest test) throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 //HelperFunctions.waitForPageToLoad(10);
	 test.info("Wait for page info");
	 try {
	    	Thread.sleep(7000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 60);
	    //wait1.until(ExpectedConditions.visibilityOf(pageInfo));
	    executor.executeScript("arguments[0].click();", pageInfo);
	    //HelperFunctions.staticWait(3);
	    test.info("Click on view as publish");
	    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
	    viewasPublish.click();
	    test.info("Go to the next tab");
		 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
		    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs.get(1));
		  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
		    HelperFunctions.waitForPageToLoad(60);
		   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		    test.info("Wait for the related element");
		    wait1.until(ExpectedConditions.visibilityOf(disclosureRelated));
		HelperFunctions.staticWait(2);
		String actualColor=disclosureRelated.getCssValue("color");
       System.out.println(disclosureRelated.getCssValue("color"));
       HelperFunctions.staticWait(2);
       String expectedColor="rgba(37, 37, 37, 1)";
       Assert.assertEquals(actualColor, expectedColor);
       test.info("Verified the related link text's color");
       HelperFunctions.staticWait(3);  
       test.info("Scroll down the page");
       JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); 
	     HelperFunctions.staticWait(2);
	        if(disclosureRelated.isDisplayed()) {
	            Assert.assertTrue(true);
	        }else {
	        	 Assert.assertTrue(false);
	        }
	        test.info("Verified the related link's sticky");
	        HelperFunctions.staticWait(3);
	    
	}

    
    
    

}
