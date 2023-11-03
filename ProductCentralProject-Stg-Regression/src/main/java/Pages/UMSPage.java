package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class UMSPage extends HelperFunctions {
	public UMSPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="(//button[.='Add User'])[1]")
	private WebElement addUser;
	
	@FindBy(xpath="(//button[.='Add User'])[4]")
	private WebElement addUser2;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//ap-button[@class='submitBt isValidClass']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	private WebElement saveButton2;
	
	@FindBy(xpath="(//div[@class='ap-field-validation ap-field-visible'])[position()=1]")
	private WebElement firstErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation ap-field-visible'])[position()=2]")
	private WebElement secondErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation ap-field-visible'])[position()=3]")
	private WebElement thirdErrorMessage;
	
	@FindBy(xpath="//mat-select[@name='user_level']")
	private WebElement selectUserLevel;
	
	@FindBy(xpath="//span[normalize-space()='User']")
	private WebElement userLabel;
	
	@FindBy(xpath="//span[normalize-space()='Admin']")
	private WebElement adminLabel;
	
	@FindBy(xpath="(//mat-form-field[@appearance='fill'])[2]")
	private WebElement selectProducts;
	
	@FindBy(xpath="//mat-select[@name='product_list1']")
	private WebElement selectProducts2;
	
	@FindBy(xpath="//div[@class='ap-checkbox']")
	private static List<WebElement> checkBoxes;
	
	@FindBy(xpath="//mat-pseudo-checkbox[starts-with(@class, 'mat-pseudo-checkbox')]")
	private static List<WebElement> checkBoxes2;
	
	@FindBy(xpath="(//span[starts-with(@class, 'mat-expansion-indicator')])[1]")
	private WebElement checkProducts;
	
	@FindBy(xpath="(//span[.='Product 2'])[1]")
	private WebElement product2;
	

	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[9]//td[4]//button")
	private WebElement otherProductUsers;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchUsers;
	
	@FindBy(xpath="//button[normalize-space()='close']")
	private WebElement closeUsers;
	
	@FindBy(xpath="//div[@class='cdk-virtual-scroll-content-wrapper']//tbody//tr//td")
	private static List<WebElement> allUsers;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[3]")
	private static List<WebElement> features;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[2]")
	private static List<WebElement> products;
	
	@FindBy(xpath="((//table[starts-with(@class, \"ng-tns\")])[9])//tr")
	private static List<WebElement> productsRows;
	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[8]//td[4]//button")
	private WebElement product2users;
	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[8]//td[2]")
	private WebElement product2Title;
	
	@FindBy(xpath="//td[@class='emailAdd']")
	private WebElement emailForVerification;
	
	@FindBy(xpath="//div[@class='table ap-table-div']")
	private WebElement resultTable;
	
	@FindBy(xpath="(//span[contains(@class, 'mat-content')]//table//tr//td[5]//button)[1]")
	private WebElement firstCompanyUsers;
	
	@FindBy(xpath="//ap-button[@class='Appkit4-icon icon-close-fill apButtonDelete click1 companyLockedFalse']//button[@type='submit']")
	private WebElement closeIconforDeleteUsers;
	
	@FindBy(xpath="//ap-button[@class='submitBt']")
	private WebElement deleteUser;
	
	@FindBy(xpath="(//ap-button[@class='cancelBt click1'])[2]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//ap-button[@class='apButtonEdit click1 companyLockedFalse']")
	private WebElement editButton;
	
	@FindBy(xpath="//ap-button[@class='support']")
	private WebElement pwcSupport;
	
	@FindBy(xpath="//ap-button[@class='textClose cancel margin-left']")
	private WebElement textClose;
	
	@FindBy(xpath="//td[@class='userName']")
	private WebElement resultUsername;
	
	@FindBy(xpath="//div[@id='errormessage']")
	private WebElement errorMessageSpecial;
	
	@FindBy(xpath="//span[@class='adminClass']")
	private WebElement adminClass;
	
	@FindBy(xpath="//div[@class='ap-field-validation ap-field-visible']")
	private WebElement emailError;
	
	@FindBy(xpath="//button[normalize-space()='close']")
	private WebElement XButton;
	
	@FindBy(xpath="//div[@class='umsText']")
	private WebElement UMSTitle;
	
	@FindBy(xpath="//ap-button[@class='click1 cancelBt']")
	private WebElement cancelButtonAddUser;
	
	@FindBy(xpath="//mat-option[@role='option']")
	private static List<WebElement> userLevelOptions;
	
	@FindBy(xpath="//div[@class='ap-field-title-container']//label")
	private static List<WebElement> ghostedMessages;
	
	@FindBy(xpath="//ap-button[@class='submitBt isValidClass']")
	private WebElement activateSaveButton;
	
	@FindBy(xpath="//div[@class='mat-dialog-title']")
	private WebElement companyTitle;
	
	@FindBy(xpath="//div[@class='mat-dialog-title-info-new align-middle']//span")
	private WebElement companyUserNumber;
	
	@FindBy(xpath="(//div[@class='mat-dialog-title']//span)[1]")
	private WebElement addUserTitle;
	
	@FindBy(xpath="//div[@class='mat-dialog-title']")
	private WebElement dialogTitle;
	
	@FindBy(xpath="//span[@class='mat-dialog-title-info']")
	private WebElement userNumber;
	
	@FindBy(xpath="//div[@class='warnMsg ng-star-inserted']")
	private WebElement warnMessage;
	
	@FindBy(xpath="(//td[@class='userName'])[1]")
	private WebElement usernameonSearch;
	
	@FindBy(xpath="(//td[@class='emailAdd'])[1]")
	private WebElement emailonSearch;
	
	@FindBy(xpath="(//div[starts-with(@class, 'mat-expansion-panel')])[1]//td[2]//span")
	private static List<WebElement> firstCompanyProducts;
	
	@FindBy(xpath="//span[normalize-space()='Select product(s)*']")
	private WebElement ghostedSelectProducts;
	
	@FindBy(xpath="//span[normalize-space()='Select User Level*']")
	private WebElement ghostedSelectUser;
	
	@FindBy(xpath="(//mat-select[@role='combobox'])[1]")
	private WebElement selectUser;
	
	@FindBy(xpath="//div[@class='mat-dialog-title-info-new align-middle']//span")
	private WebElement userNumber2;
	
	@FindBy(xpath="//input[@role='searchbox']")
	private WebElement searchCompany;
	
	@FindBy(xpath="//ap-button[@class='searchBt']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[normalize-space()='Company Automation']")
	private WebElement companyAutomation;
	
	@FindBy(xpath="//span[normalize-space()='Edit Company']")
	private WebElement editCompany;
	
	@FindBy(xpath="//input[@name='SC_Account_ID']")
	private WebElement SCaccount;
	
	@FindBy(xpath="//input[@name='SC_Product_ID']")
	private WebElement SCproduct;
	
	@FindBy(xpath="//ap-button[@class='saveBt']")
	private WebElement saveCompany;
	
	@FindBy(xpath="//span[normalize-space()='Company was updated.']")
	private WebElement updateCompanyMessage;
	
	@FindBy(xpath="//div[contains(text(),'Products')]")
	private WebElement productsTab;
	
	@FindBy(xpath="//div[normalize-space()='automation product1']")
	private WebElement productAutomation;
	
	@FindBy(xpath="//span[normalize-space()='Edit Product']//span[@class='mat-button-wrapper']")
	private WebElement editProduct;
	
	@FindBy(xpath="//span[normalize-space()='Product was updated.']")
	private WebElement updateProductMessage;
	
	@FindBy(xpath="//div[normalize-space()='automation2']")
	private WebElement automation2;
	
	@FindBy(xpath="//span[normalize-space()='Add Feature to Product']")
	private WebElement addFeatureButton;
	
	@FindBy(xpath="//ap-button[@class='submitBt']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[normalize-space()='[Feature Name] is required']")
	private WebElement featureError;
	
	@FindBy(xpath="(//span[normalize-space()='Edit'])[1]")
	private WebElement editFeature;
	
	@FindBy(xpath="//input[@name='FeatureName']")
	private WebElement featureName;
	
	@FindBy(xpath="//span[normalize-space()='Feature was modified.']")
	private WebElement updateFeatureMessage;
	
	@FindBy(xpath="(//mat-expansion-panel-header[@role='button'])[1]")
	private WebElement firstResult;
	
	@FindBy(xpath="//ap-button[@class='clearBt']")
	private WebElement clearButton;
	
	@FindBy(xpath="(//mat-select[@role='combobox'])[1]")
	private WebElement selectProductdropdown;
	
	@FindBy(xpath="//div[contains(@id, 'mat-select-0-panel')]")
	private WebElement productsPanel;
	
	@FindBy(xpath="//span[normalize-space()='automation product1']")
	private WebElement selectAutomationProduct;
	
	@FindBy(xpath="//span[normalize-space()='automation2']")
	private WebElement selectAutomationProduct2;
	
	@FindBy(xpath="//span[normalize-space()='Download Company Report']")
	private WebElement downloadLink;
	
	@FindBy(xpath="//span[normalize-space()='+ Add New Company']")
	private WebElement addNewCompanyButton;
	
	@FindBy(xpath="//ap-button[@class='cancelSaveBt']")
	private WebElement cancelButton2;
	
	@FindBy(xpath="//ap-button[@class='addCompanyBt']")
	private WebElement addProductButton;
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productNameField;
	
	@FindBy(xpath="//input[@name='productCode']")
	private WebElement productCodeField;
	
	@FindBy(xpath="//div[starts-with(@class,'col')]")
	private static List<WebElement> cols;
	
	@FindBy(xpath="//div[@class='error_message ng-star-inserted']")
	private WebElement scProductError;
	
	@FindBy(xpath="//input[@id='mat-input-2']")
	private WebElement startDate;
	
	@FindBy(xpath="//input[@id='mat-input-3']")
	private WebElement endDate;
	
	@FindBy(xpath="//div[normalize-space()='Automation3']")
	private WebElement automation3;
	
	@FindBy(xpath="//div[@class='row container ng-star-inserted']")
	private WebElement scAccountError;
	
	@FindBy(xpath="//input[@name='companyName']")
	private WebElement companyNameField;
	
	@FindBy(xpath="//input[@name='companyCode']")
	private WebElement companyCodeField;
	
	@FindBy(xpath="//span[normalize-space()='+ Assign Product']")
	private WebElement assignProducts;
	
	@FindBy(xpath="//mat-select[@name='user_level']")
	private WebElement selectaProduct;
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	private static List<WebElement> productsOptions;
	
	@FindBy(xpath="//mat-checkbox[@name='feature.value']")
	private WebElement featureCheckbox;
	
	@FindBy(xpath="(//input[starts-with(@id, 'mat-input')])[1]")
	private WebElement startDate2;
	
	@FindBy(xpath="(//input[starts-with(@id, 'mat-input')])[2]")
	private WebElement endDate2;
	
	@FindBy(xpath="//div[@class='col']")
	private static List<WebElement> colsforcompany;
	
	@FindBy(xpath="//span[@class='adminButton']")
	private static List<WebElement> adminButtons;
	
	@FindBy(xpath="//span[contains(@class, 'locked')]")
	private WebElement lockedSymbol;
	
	@FindBy(xpath="(//span[contains(@class, 'mat-content')]//table//tr//td[5]//button)[3]")
	private WebElement lockedCompanyUsers;
	
	@FindBy(xpath="//ap-button[contains(@class, 'Edit')]//button")
	private WebElement editLocked;
	
	@FindBy(xpath="//ap-button[contains(@class, 'LockedTrue')]//button")
	private WebElement addUserLocked;
	
	@FindBy(xpath="//span[contains(@class, 'mat-select-value')]//span")
	private static List<WebElement> superDropdowns;
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	private static List<WebElement> licenseTexts;
	
	@FindBy(xpath="//mat-expansion-panel-header[contains(@id, 'mat-expansion-panel-header')]//span")
	private static List<WebElement> companyElements;
	
	@FindBy(xpath="//span[normalize-space()='On']")
	private static WebElement on;
	
	@FindBy(xpath="//span[normalize-space()='Off']")
	private static WebElement off;
	
	@FindBy(xpath="//button[@role='switch']")
	private static WebElement switchButton;
	
	@FindBy(xpath="//div[normalize-space()='Locked Automation']")
	private WebElement lockedAutomation;
	
	static Logger logger=Logger.getLogger("UMSPage");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setErrorMessages() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		
	
		addUser.click();
		HelperFunctions.staticWait(3);
		if(emailAddress.getText().trim().isEmpty()&&firstName.getText().trim().isEmpty()&&lastName.getText().trim().isEmpty()) {
			boolean a=saveButton.getAttribute("aria-disabled").equals("true");
			Assert.assertTrue(a);
		}
		HelperFunctions.staticWait(3);
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(3);
		saveButton.click();
		String errorMessage1="First name is required";
		String errorMessage2="Last name is required";
		String errorMessage3="User level selection is required";
		Assert.assertEquals(firstErrorMessage.getText(), errorMessage1);
		Assert.assertEquals(secondErrorMessage.getText(), errorMessage2);
		Assert.assertEquals(thirdErrorMessage.getText(), errorMessage3);
		
		
		
		
		
	}
	public void setAssigningMultipleProducts() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		firstName.click();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		lastName.click();
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		for(WebElement each:checkBoxes) {
			each.click();	
		}
		for(WebElement each:checkBoxes) {
		Assert.assertTrue(each.isSelected());
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
           executor.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
		//String actualUrl=Driver.getDriver().getCurrentUrl();
		//System.out.println(Driver.getDriver().getCurrentUrl());
		//String expectedUrl="https://ums-productcentral-qa.pwc.com/home";
		//Assert.assertEquals(actualUrl,expectedUrl);
		
		
		
		
		
		
	}
	
	public void setAdminForMultipleCompanies() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		
		addUser.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		HelperFunctions.staticWait(3);
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		HelperFunctions.staticWait(3);
		firstName.click();
		HelperFunctions.staticWait(3);
		firstName.clear();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		HelperFunctions.staticWait(3);
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		HelperFunctions.staticWait(3);
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		HelperFunctions.staticWait(3);
		selectUserLevel.click();
		HelperFunctions.staticWait(3);
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		for(WebElement each:checkBoxes) {
			each.click();	
			break;
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         executor.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
		//String actualUrl=Driver.getDriver().getCurrentUrl();
		//System.out.println(Driver.getDriver().getCurrentUrl());
		//String expectedUrl="https://ums-productcentral-qa.pwc.com/home";
		//Assert.assertEquals(actualUrl,expectedUrl);
		HelperFunctions.staticWait(3);
		addUser2.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		HelperFunctions.staticWait(3);
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		HelperFunctions.staticWait(3);
		firstName.click();
		HelperFunctions.staticWait(3);
		firstName.clear();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		HelperFunctions.staticWait(3);
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		HelperFunctions.staticWait(3);
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		HelperFunctions.staticWait(3);
		selectUserLevel.click();
		HelperFunctions.staticWait(3);
		userLabel.click();
		HelperFunctions.staticWait(3);
		/*selectProducts.click();
		for(WebElement each:checkBoxes) {
			each.click();	
			break;
		}
		selectProducts.click();
		HelperFunctions.staticWait(3);
		saveButton.click();
		Assert.assertEquals(actualUrl,expectedUrl);*/
		
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", saveButton);
		
		
		
	}
	
	
	
	
	
	public void setAdminRights() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
	//	pass.sendKeys(read1.getCellData("VALUE", 1));
	//	submit.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		//emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		firstName.click();
		HelperFunctions.staticWait(2);
		firstName.sendKeys(faker.name().firstName());
		HelperFunctions.staticWait(2);
		lastName.click();
		HelperFunctions.staticWait(2);
		lastName.sendKeys(faker.name().lastName());
		HelperFunctions.staticWait(2);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(adminLabel));
		adminLabel.click();
		HelperFunctions.staticWait(3);
		boolean a=selectProducts2.getAttribute("aria-disabled").equals("true");
		Assert.assertTrue(a);
	}
	public void setDisplayingContentBasedOnLicence() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		
		addUser.click();
		HelperFunctions.staticWait(3);
		String email="admin@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(email);
		firstName.click();
		firstName.sendKeys("adminadmin");
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		lastName.sendKeys("company");
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		for(int i=0;i<checkBoxes2.size();i++) {
			if(checkBoxes2.get(i).getText().equalsIgnoreCase("Product 2")) {
				checkBoxes2.get(i).click();
			}
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	        executor3.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
	
		HelperFunctions.staticWait(3);
		checkProducts.click();
		HelperFunctions.staticWait(3);
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	    js.executeScript("arguments[0].scrollIntoView(true);", product2Title);
	    HelperFunctions.staticWait(3);
	    product2users.click();
	    HelperFunctions.staticWait(3);
	    searchUsers.click();
	    searchUsers.sendKeys(email);
	    HelperFunctions.staticWait(3);
	    String actualUser=emailForVerification.getText();
	    Assert.assertEquals(actualUser, email);
	    HelperFunctions.staticWait(3);
	    closeUsers.click();
	    HelperFunctions.staticWait(3);
		checkProducts.click();
		HelperFunctions.staticWait(3);
		JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
	    js2.executeScript("arguments[0].scrollIntoView(true);", otherProductUsers);
	    HelperFunctions.staticWait(3);
	    otherProductUsers.click();
	    HelperFunctions.staticWait(3);
	    searchUsers.click();
	    searchUsers.sendKeys(email);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(resultTable.getText().isBlank());
		
	
			

		
	}
	public void setFaviconItem() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		
		WebElement favicon = Driver.getDriver().findElement(By.cssSelector("link[rel='shortcut icon'], link[rel='icon']"));

        if (favicon != null) {
            System.out.println("Favicon is present on the page");
        } else {
            System.out.println("Favicon is not present on the page");
        }

		
		
		
		
		
		
	}
	public void setDeleteCancelButton() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail="tes654t1234@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		wait.until(ExpectedConditions.visibilityOf(checkBoxes2.get(0)));
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		Actions actions=new Actions(Driver.getDriver());
		actions.moveToElement(selectUserLevel).click().perform();
		//selectProducts.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         //  executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
         //  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
         //  executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           firstCompanyUsers.click();
           wait.until(ExpectedConditions.visibilityOf(searchUsers));
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    wait.until(ExpectedConditions.visibilityOf(emailForVerification));
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    HelperFunctions.staticWait(1);
	    closeIconforDeleteUsers.click();
	    wait.until(ExpectedConditions.visibilityOf(cancelButton));
	    if(cancelButton.isDisplayed()) {
	    	cancelButton.click();
	    }
	    HelperFunctions.staticWait(2);
	    Assert.assertEquals(user, mockEmail);
	    HelperFunctions.staticWait(2);
	    closeIconforDeleteUsers.click();
	    wait.until(ExpectedConditions.visibilityOf(deleteUser));
	    if(deleteUser.isDisplayed()) {
	    	 deleteUser.click();
	    }
	    HelperFunctions.staticWait(3);
	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
   	    searchUsers.clear();
	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	   // Assert.assertTrue(resultTable.getText().isBlank());
	    HelperFunctions.staticWait(3);
		
		
	}
	public void setEditButton() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail="test12432sttest12345@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		wait.until(ExpectedConditions.visibilityOf(checkBoxes2.get(0)));
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		Actions actions=new Actions(Driver.getDriver());
		actions.moveToElement(selectUserLevel).click().perform();
		//selectProducts.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        //   executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
         //  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
         //  executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           firstCompanyUsers.click();
        //firstCompanyUsers.click();
           wait.until(ExpectedConditions.visibilityOf(searchUsers));
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    wait.until(ExpectedConditions.visibilityOf(emailForVerification));
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    HelperFunctions.staticWait(1);
	    editButton.click();
	    wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("testfirst");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("testlast");
		HelperFunctions.staticWait(1);
		saveButton.click();
        //JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
         //  executor3.executeScript("arguments[0].click();", saveButton2);
           HelperFunctions.staticWait(3);
           searchUsers.click();
      	    HelperFunctions.staticWait(2);
      	  searchUsers.clear();
      	HelperFunctions.staticWait(2);
   	    searchUsers.sendKeys(mockEmail);
   	 wait.until(ExpectedConditions.visibilityOf(resultUsername));
           Assert.assertEquals(resultUsername.getText(), "testfirst testlast");
           HelperFunctions.staticWait(2);
           closeIconforDeleteUsers.click();
           wait.until(ExpectedConditions.visibilityOf(deleteUser));
   	    if(deleteUser.isDisplayed()) {
   	    	 deleteUser.click();
   	    }
   	    HelperFunctions.staticWait(2);
   	   
	}
	
	public void setContactSupportandCloseButton() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
        firstCompanyUsers.click();
        HelperFunctions.staticWait(2);
        textClose.click();
        HelperFunctions.staticWait(2);
        firstCompanyUsers.click();
        int numberOfWindows = Driver.getDriver().getWindowHandles().size();
        HelperFunctions.staticWait(2);
        pwcSupport.click();
        HelperFunctions.staticWait(2);
        int newNumberOfWindows = Driver.getDriver().getWindowHandles().size();
     if (newNumberOfWindows > numberOfWindows) {
         Assert.assertTrue(true);
     } else {
    	 String errorMessage = "No new tab was opened.";
	        logger.error(errorMessage);
     }
	}
	
	public void setNotAcceptingSpeacialChar() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="test1234@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test123@#");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test123@#");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
           executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(2);
        if(errorMessageSpecial.isDisplayed()) {
        	Assert.assertTrue(true);
        }else {
        	 String errorMessage = "Accepting special characters";
 	        logger.error(errorMessage);
        }
      
	}
	public void setAdminNotDelete() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="test123456@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		HelperFunctions.staticWait(1);
		adminLabel.click();
		HelperFunctions.staticWait(2);
		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", saveButton);
        HelperFunctions.staticWait(4);
        firstCompanyUsers.click();
   		HelperFunctions.staticWait(1);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    if(adminClass.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Delete icon exists";
 	        logger.error(errorMessage);
	    }
	}
	public void setRedBackground() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
	
	
		addUser.click();
		HelperFunctions.staticWait(3);
		/*if(emailAddress.getText().trim().isEmpty()&&firstName.getText().trim().isEmpty()&&lastName.getText().trim().isEmpty()) {
			boolean a=saveButton.getAttribute("aria-disabled").equals("true");
			Assert.assertTrue(a);
		}*/
		HelperFunctions.staticWait(2);
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(3);
		saveButton.click();
		HelperFunctions.staticWait(2);
		String errorMessage1="First name is required";
		String errorMessage2="Last name is required";
		String errorMessage3="User level selection is required";
		Assert.assertEquals(firstErrorMessage.getText(), errorMessage1);
		Assert.assertEquals(secondErrorMessage.getText(), errorMessage2);
		Assert.assertEquals(thirdErrorMessage.getText(), errorMessage3);
		String expectedRedBackground="rgba(220, 53, 69, 0.3)";
		System.out.println(firstName.getCssValue("background-color"));
		System.out.println(lastName.getCssValue("background-color"));
		Assert.assertTrue(firstName.getCssValue("background-color").contains(expectedRedBackground));
		Assert.assertTrue(lastName.getCssValue("background-color").contains(expectedRedBackground));

	}
	public void setMandatoryFieldError() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
	
		addUser.click();
		HelperFunctions.staticWait(3);
		/*if(emailAddress.getText().trim().isEmpty()&&firstName.getText().trim().isEmpty()&&lastName.getText().trim().isEmpty()) {
			boolean a=saveButton.getAttribute("aria-disabled").equals("true");
			Assert.assertTrue(a);
		}*/
		HelperFunctions.staticWait(2);
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(3);
		saveButton.click();
		HelperFunctions.staticWait(2);
		String errorMessage1="First name is required";
		String errorMessage2="Last name is required";
		String errorMessage3="User level selection is required";
		Assert.assertEquals(firstErrorMessage.getText(), errorMessage1);
		Assert.assertEquals(secondErrorMessage.getText(), errorMessage2);
		Assert.assertEquals(thirdErrorMessage.getText(), errorMessage3);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("abc");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("def");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
		String errorMessageforemail="Please enter a valid email address";
		String errorMessageforproductSelect="Product selection is required";
		Assert.assertEquals(emailError.getText(), errorMessageforproductSelect);
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.clear();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys("abcdef");
		HelperFunctions.staticWait(1);
		Assert.assertEquals(emailError.getText(), errorMessageforemail);
	}
	public void setErrorFont() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		
	
		addUser.click();
		HelperFunctions.staticWait(3);
		/*if(emailAddress.getText().trim().isEmpty()&&firstName.getText().trim().isEmpty()&&lastName.getText().trim().isEmpty()) {
			boolean a=saveButton.getAttribute("aria-disabled").equals("true");
			Assert.assertTrue(a);
		}*/
		HelperFunctions.staticWait(2);
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(3);
		saveButton.click();
		HelperFunctions.staticWait(2);
		String expectedColor="rgba(197, 42, 26, 1)";
		String expectedWeight="500";
		System.out.println(firstErrorMessage.getCssValue("color"));
		System.out.println(firstErrorMessage.getCssValue("font-weight"));
		String errorMessage1="First name is required";
		String errorMessage2="Last name is required";
		String errorMessage3="User level selection is required";
		Assert.assertEquals(firstErrorMessage.getText(), errorMessage1);
		Assert.assertEquals(secondErrorMessage.getText(), errorMessage2);
		Assert.assertEquals(thirdErrorMessage.getText(), errorMessage3);
		HelperFunctions.staticWait(1);
		Assert.assertTrue(firstErrorMessage.getCssValue("color").contains(expectedColor));
		Assert.assertTrue(firstErrorMessage.getCssValue("font-weight").contains(expectedWeight));
		HelperFunctions.staticWait(1);
		Assert.assertTrue(secondErrorMessage.getCssValue("color").contains(expectedColor));
		Assert.assertTrue(secondErrorMessage.getCssValue("font-weight").contains(expectedWeight));
		HelperFunctions.staticWait(1);
		Assert.assertTrue(thirdErrorMessage.getCssValue("color").contains(expectedColor));
		Assert.assertTrue(thirdErrorMessage.getCssValue("font-weight").contains(expectedWeight));
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("abc");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("def");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
		String errorMessageforemail="Please enter a valid email address";
		String errorMessageforproductSelect="Product selection is required";
		Assert.assertEquals(emailError.getText(), errorMessageforproductSelect);
		HelperFunctions.staticWait(1);
		Assert.assertTrue(emailError.getCssValue("color").contains(expectedColor));
		Assert.assertTrue(emailError.getCssValue("font-weight").contains(expectedWeight));
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.clear();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys("abcdef");
		HelperFunctions.staticWait(1);
		Assert.assertEquals(emailError.getText(), errorMessageforemail);
		HelperFunctions.staticWait(1);
		Assert.assertTrue(emailError.getCssValue("color").contains(expectedColor));
		Assert.assertTrue(emailError.getCssValue("font-weight").contains(expectedWeight));
	}
	public void setCloseButton() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
        firstCompanyUsers.click();
        HelperFunctions.staticWait(2);
        XButton.click();
        HelperFunctions.staticWait(2);
        Assert.assertTrue(firstCompanyUsers.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setUsernameEmailVisibility() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="test1234@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         //  executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
         //  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
         //  executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           firstCompanyUsers.click();
   		HelperFunctions.staticWait(1);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    Assert.assertTrue(resultUsername.isDisplayed());
           closeIconforDeleteUsers.click();
   	    HelperFunctions.staticWait(1);
   	    if(deleteUser.isDisplayed()) {
   	    	 deleteUser.click();
   	    }
   	    HelperFunctions.staticWait(2);
   	   
	}
	public void setSearchFunctionality() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="test1234@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         //  executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
         //  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
         //  executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           firstCompanyUsers.click();
   		HelperFunctions.staticWait(1);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys("test1234@");
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    Assert.assertTrue(resultUsername.isDisplayed());
           closeIconforDeleteUsers.click();
   	    HelperFunctions.staticWait(1);
   	    if(deleteUser.isDisplayed()) {
   	    	 deleteUser.click();
   	    }
   	    HelperFunctions.staticWait(2);
   	   
	}
	public void setCloseButtonNavigatesUMSHomepage() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(firstCompanyUsers));
        firstCompanyUsers.click();
        wait.until(ExpectedConditions.visibilityOf(XButton));
        XButton.click();
        wait.until(ExpectedConditions.visibilityOf(UMSTitle));
        Assert.assertTrue(UMSTitle.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setCloseAddUserFunctionality() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
        addUser.click();
        wait.until(ExpectedConditions.visibilityOf(XButton));
        XButton.click();
        wait.until(ExpectedConditions.visibilityOf(UMSTitle));
        Assert.assertTrue(UMSTitle.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setCloseAddUser() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
        addUser.click();
        HelperFunctions.staticWait(2);
        XButton.click();
        HelperFunctions.staticWait(3);
        Assert.assertTrue(UMSTitle.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setCancelAddUser() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
        addUser.click();
        HelperFunctions.staticWait(2);
        cancelButtonAddUser.click();
        HelperFunctions.staticWait(3);
        Assert.assertTrue(UMSTitle.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setCancelAddUser2() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
        addUser.click();
        HelperFunctions.staticWait(2);
        cancelButtonAddUser.click();
        HelperFunctions.staticWait(3);
        Assert.assertTrue(UMSTitle.isDisplayed());
        HelperFunctions.staticWait(2);
     
	}
	public void setSaveButton() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="te321st1234@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		Actions actions=new Actions(Driver.getDriver());
		actions.moveToElement(selectUserLevel).click().perform();
		//selectProducts.click();
		HelperFunctions.staticWait(1);
		saveButton.click();
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         //  executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
         //  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
         //  executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           firstCompanyUsers.click();
   		HelperFunctions.staticWait(1);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys("te321st1234@");
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    Assert.assertTrue(resultUsername.isDisplayed());
           closeIconforDeleteUsers.click();
   	    HelperFunctions.staticWait(1);
   	    if(deleteUser.isDisplayed()) {
   	    	 deleteUser.click();
   	    }
   	    HelperFunctions.staticWait(2);
   	   
	}
	public void setUserLevelOptions() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
        addUser.click();
        wait.until(ExpectedConditions.visibilityOf(selectUserLevel));
        selectUserLevel.click();
        HelperFunctions.staticWait(3);
        int actualOptionSize=userLevelOptions.size();
        System.out.println(actualOptionSize);
        Assert.assertTrue(actualOptionSize==2);
       
	}
	public void setNotAcceptMultiselect() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));	
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.sendKeys(faker.name().firstName());
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.sendKeys(faker.name().lastName());
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(adminLabel));
		adminLabel.click();
		HelperFunctions.staticWait(2);
		Assert.assertTrue(selectUser.getAttribute("aria-expanded").equals("false"));
		//Assert.assertFalse(userLabel.isDisplayed());
		//HelperFunctions.staticWait(2);
		/*selectUserLevel.click();
		HelperFunctions.staticWait(1);
		userLabel.click();
		HelperFunctions.staticWait(2);
		Assert.assertTrue(!adminLabel.isDisplayed());
		HelperFunctions.staticWait(2);*/
		
	}
	public void setUserNeedsSelectProduct() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		Faker faker=new Faker();
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.sendKeys(faker.name().firstName());
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.sendKeys(faker.name().lastName());
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(2);
		saveButton.click();
		// JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        // executor.executeScript("arguments[0].click();", saveButton);
		wait.until(ExpectedConditions.visibilityOf(emailError));
         String expectedErrorMessage="Product selection is required";
         if(emailError.isDisplayed()&&emailError.getText().contains(expectedErrorMessage)) {
        	 Assert.assertTrue(true);
         }else {
        	 String errorMessage = "User does not see error message for select product section";
 	        logger.error(errorMessage);
 	        throw new Exception(errorMessage);
         }
		
	}
	public void setMultiselectProductDropdown() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		Faker faker=new Faker();
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.sendKeys(faker.name().firstName());
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.sendKeys(faker.name().lastName());
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		wait.until(ExpectedConditions.visibilityOf(checkBoxes2.get(0)));
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		if(checkBoxes2.get(1).isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Select product is not multiselect";
	 	        logger.error(errorMessage);
	 	        throw new Exception(errorMessage);
		}
		
		HelperFunctions.staticWait(3);
	}
	public void setSelectProductDropdown() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		Faker faker=new Faker();
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(2);
		firstName.click();
		HelperFunctions.staticWait(2);
		firstName.sendKeys(faker.name().firstName());
		HelperFunctions.staticWait(2);
		lastName.click();
		HelperFunctions.staticWait(2);
		lastName.sendKeys(faker.name().lastName());
		HelperFunctions.staticWait(2);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		wait.until(ExpectedConditions.visibilityOf(checkBoxes2.get(0)));
		if(checkBoxes2.get(0).isDisplayed()) {
			checkBoxes2.get(0).click();
		}
		HelperFunctions.staticWait(2);
		
	}
	public void setUserLevel() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
        addUser.click();
        wait.until(ExpectedConditions.visibilityOf(selectUserLevel));
        selectUserLevel.click();
        wait.until(ExpectedConditions.visibilityOf(userLabel));
        System.out.println(userLabel.getText());
        if(userLabel.isDisplayed()&&userLabel.getText().equalsIgnoreCase("User")) {
        	Assert.assertTrue(true);
		}else {
			 String errorMessage = "User label is not displayed";
	 	        logger.error(errorMessage);
	 	        throw new Exception(errorMessage);
		}
        HelperFunctions.staticWait(3);
	}
	public void setAnyDomainEmail() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail1="abcd@hotmail.com";
		String mockEmail2="abcd@gft.com";
		String mockEmail3="abcd@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail1);
		HelperFunctions.staticWait(2);
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(emailError));
		// JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       // executor.executeScript("arguments[0].click();", saveButton);
		String errorMessageforemail="Please enter a valid email address";
		Assert.assertTrue(!emailError.getText().contains(errorMessageforemail));
		HelperFunctions.staticWait(2);
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.clear();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail2);
		HelperFunctions.staticWait(2);
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(emailError));
		// JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
       // executor2.executeScript("arguments[0].click();", saveButton);
		Assert.assertTrue(!emailError.getText().contains(errorMessageforemail));
		HelperFunctions.staticWait(2);
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.clear();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail3);
		HelperFunctions.staticWait(2);
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(emailError));
		// JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
       // executor3.executeScript("arguments[0].click();", saveButton);
		Assert.assertTrue(!emailError.getText().contains(errorMessageforemail));
		HelperFunctions.staticWait(3);
	}
	public void setFirstNameBox() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
        addUser.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        Assert.assertTrue(firstName.isDisplayed());
        Assert.assertTrue(firstName.isEnabled());
        HelperFunctions.staticWait(3);
       
	}
	public void setLastNameBox() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
        addUser.click();
        wait.until(ExpectedConditions.visibilityOf(lastName));
        Assert.assertTrue(lastName.isDisplayed());
        Assert.assertTrue(lastName.isEnabled());
        HelperFunctions.staticWait(3);
       
	}
	public void setEmailBox() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
        addUser.click();
        HelperFunctions.staticWait(2);
        Assert.assertTrue(emailAddress.isDisplayed());
        Assert.assertTrue(emailAddress.isEnabled());
       
	}
	public void setEmailValue() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail3="abcd";
		String errorMessageforemail="Please enter a valid email address";
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail3);
		//HelperFunctions.staticWait(2);
		//saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(emailError));
		// JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
       // executor3.executeScript("arguments[0].click();", saveButton);
		Assert.assertTrue(emailError.getText().contains(errorMessageforemail));
	}
	public void setSaveButtonActivation() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail1="abcd@hotmail.com";
		String mockEmail2="abcd@gft.com";
		String mockEmail3="abcd@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail1);
		wait.until(ExpectedConditions.visibilityOf(activateSaveButton));
		Assert.assertTrue(activateSaveButton.isDisplayed());
		HelperFunctions.staticWait(2);
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.clear();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail2);
		wait.until(ExpectedConditions.visibilityOf(activateSaveButton));
		Assert.assertTrue(activateSaveButton.isDisplayed());
		HelperFunctions.staticWait(2);
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.clear();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail3);
		wait.until(ExpectedConditions.visibilityOf(activateSaveButton));
		Assert.assertTrue(activateSaveButton.isDisplayed());
		HelperFunctions.staticWait(3);

	}
	public void setGhostedFirstname() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String expectedMessage="First Name*";
		String actualMessage=ghostedMessages.get(1).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		HelperFunctions.staticWait(3);
		
	}
	public void setGhostedLastname() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.waitForPageToLoad(5);
		addUser.click();
		HelperFunctions.staticWait(3);
		String expectedMessage="Last Name*";
		String actualMessage=ghostedMessages.get(2).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		HelperFunctions.staticWait(3);
		
	}
	public void setGhostedSelectProductname() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.waitForPageToLoad(5);
		addUser.click();
		HelperFunctions.staticWait(3);
		//String expectedMessage="Select product(s)*";
		Assert.assertTrue(ghostedSelectProducts.isDisplayed());
		//String actualMessage=ghostedMessages.get(4).getText();
		//Assert.assertEquals(actualMessage, expectedMessage);
		HelperFunctions.staticWait(3);
		
	}
	public void setGhostedSelectUserLevel() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.waitForPageToLoad(5);
		addUser.click();
		HelperFunctions.staticWait(3);
		//String expectedMessage="Select User Level*";
		Assert.assertTrue(ghostedSelectUser.isDisplayed());
		//String actualMessage=ghostedMessages.get(3).getText();
		//Assert.assertEquals(actualMessage, expectedMessage);
		HelperFunctions.staticWait(3);
		
	}
	public void setGhostedEmailAddress() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		HelperFunctions.waitForPageToLoad(5);
		addUser.click();
		HelperFunctions.staticWait(3);
		String expectedMessage="Email address*";
		String actualMessage=ghostedMessages.get(0).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		HelperFunctions.staticWait(3);
		
	}
	public void setAdminInCompanyList() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail="432test@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(1);
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(adminLabel));
		adminLabel.click();
		HelperFunctions.staticWait(2);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
           executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(5);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           wait.until(ExpectedConditions.visibilityOf(searchUsers));
   		Assert.assertTrue(searchUsers.isDisplayed());	   
   	    HelperFunctions.staticWait(2);
   	   
	}
	public void setCompanyTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		
		HelperFunctions.staticWait(2);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();", firstCompanyUsers);
           wait.until(ExpectedConditions.visibilityOf(companyTitle));
   		Assert.assertTrue(companyTitle.isDisplayed());	   
   	    HelperFunctions.staticWait(2);
   	   
	}
	public void setCompanyUserNumber() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();", firstCompanyUsers);
   		HelperFunctions.staticWait(1);
   		String text = companyUserNumber.getText();
   		if (text.matches(".*\\d.*")) {
   			Assert.assertTrue(true);
   		    System.out.println("Element contains a number.");
   		} else {
   		    System.out.println("Element does not contain a number.");
   		}
   		HelperFunctions.staticWait(3);
	}
	public void setAddUserTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		System.out.println(addUserTitle.getText());
		Assert.assertTrue(addUserTitle.getText().contains("Add user"));	
		//Assert.assertTrue(addUserTitle.getText().length()>=13);
		HelperFunctions.staticWait(3);
		
	}
	public void setPrepopulatedInformation() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail="user1212@gmail.com";
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(mockEmail);
		//HelperFunctions.staticWait(1);
		HelperFunctions.staticWait(2);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
           executor.executeScript("arguments[0].click();", saveButton);
           wait.until(ExpectedConditions.visibilityOf(UMSTitle));
		Assert.assertTrue(UMSTitle.isDisplayed());
		HelperFunctions.staticWait(3);
	}
	public void setVerifyCompanyTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();", firstCompanyUsers);
   		HelperFunctions.staticWait(1);
   		Assert.assertTrue(companyUserNumber.isDisplayed());
   		HelperFunctions.staticWait(3);
	}
	public void setDeleteUserFromProduct() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String email="abc123def@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(email);
		firstName.click();
		firstName.sendKeys("adm");
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		lastName.sendKeys("comp");
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(2);
		for(int i=0;i<checkBoxes2.size();i++) {
		checkBoxes2.get(i).click();		
		}
		HelperFunctions.staticWait(2);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		saveButton.click();
		// JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	    //    executor3.executeScript("arguments[0].click();", saveButton);
	
		HelperFunctions.staticWait(5);
		checkProducts.click();
		HelperFunctions.staticWait(5);
		List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector("tr.ng-star-inserted"));

		for (WebElement row : rows) {
		    if (row.getText().contains("SMART")) {

		        WebElement button = row.findElement(By.cssSelector("td:nth-child(4) ap-button button"));
		        button.click();
		        break;
		    }
		}
		HelperFunctions.staticWait(2);
		 searchUsers.click();
		 searchUsers.clear();
		    searchUsers.sendKeys(email);
		    HelperFunctions.staticWait(3);
		    String actualUser=emailForVerification.getText();
		    Assert.assertEquals(actualUser, email);
		    HelperFunctions.staticWait(3);
		    closeIconforDeleteUsers.click();
		    HelperFunctions.staticWait(1);
		    if(deleteUser.isDisplayed()) {
		    	 deleteUser.click();
		    }
		    HelperFunctions.staticWait(2);
		    closeUsers.click();
		    HelperFunctions.staticWait(2);
			for (WebElement row : rows) {
			    if (row.getText().contains("SMART")) {

			        WebElement button = row.findElement(By.cssSelector("td:nth-child(4) ap-button button"));
			        button.click();
			        break;
			    }
			}
			HelperFunctions.staticWait(2);
			 searchUsers.click();
			 searchUsers.clear();
			    searchUsers.sendKeys(email);
			    HelperFunctions.staticWait(2);
			    Assert.assertTrue(resultTable.getText().isBlank());
			    HelperFunctions.staticWait(3);
	}
	public void setDialogTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		firstCompanyUsers.click();
		HelperFunctions.staticWait(4);
		String titleText = dialogTitle.getText();
		if (titleText.length() > 0) {
		    String[] titleParts = titleText.split(" ");
		    if (titleParts.length > 2 && titleParts[2].equals("user") && titleParts[3].equals("list")) {
		    	Assert.assertTrue(true);
		        System.out.println("Title is correct.");
		    } else {
		        System.out.println("Title is incorrect.");
		    }
		} else {
		    System.out.println("Title is incorrect.");
		}
		HelperFunctions.staticWait(3);
	}
	public void setUserNumber() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(firstCompanyUsers));
		firstCompanyUsers.click();
		wait.until(ExpectedConditions.visibilityOf(userNumber2));
		String text = userNumber2.getText();
		if (text.matches(".*\\d+.*")) {
			Assert.assertTrue(true);
		    System.out.println("Element text contains a number.");
		} else {
		    System.out.println("Element text does not contain a number.");
		}
		HelperFunctions.staticWait(3);
		HelperFunctions.staticWait(3);
	}
	public void setUserAlreadyExist() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String email="erinc.suluk@net-effect.com";
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(email);
		HelperFunctions.staticWait(3);
	    Assert.assertTrue(warnMessage.isDisplayed());
	    Assert.assertTrue(saveButton.isEnabled());
	    HelperFunctions.staticWait(3);
	}
	public void setDeleteFromCompany() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		addUser.click();
		HelperFunctions.staticWait(3);
		String mockEmail="companydelete@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		HelperFunctions.staticWait(2);
		saveButton.click();
           HelperFunctions.staticWait(5);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();",firstCompanyUsers);
       // firstCompanyUsers.click();
   		HelperFunctions.staticWait(2);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    HelperFunctions.staticWait(2);
	    closeIconforDeleteUsers.click();
	    HelperFunctions.staticWait(1);
	    if(deleteUser.isDisplayed()) {
	    	 deleteUser.click();
	    }
	    HelperFunctions.staticWait(2);
	    searchUsers.click();
   	    HelperFunctions.staticWait(1);
   	    searchUsers.clear();
	    HelperFunctions.staticWait(1);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	    Assert.assertTrue(resultTable.getText().isBlank());
	    HelperFunctions.staticWait(3);
		
		
	}
	public void setUsernameEmailonSearch() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		firstCompanyUsers.click();
		HelperFunctions.staticWait(3);
		Assert.assertTrue(usernameonSearch.isDisplayed());
		Assert.assertTrue(emailonSearch.isDisplayed());
		HelperFunctions.staticWait(3);
	}
	public void setSearchonProducts() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
	
		checkProducts.click();
		HelperFunctions.staticWait(5);
		List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector("tr.ng-star-inserted"));

		for (WebElement row : rows) {
		    if (row.getText().contains("SMART")) {

		        WebElement button = row.findElement(By.cssSelector("td:nth-child(4) ap-button button"));
		        button.click();
		        break;
		    }
		}
		HelperFunctions.staticWait(2);
		Assert.assertTrue(searchUsers.isDisplayed());
		Assert.assertTrue(searchUsers.isEnabled());
		HelperFunctions.staticWait(3);
	}
	public void setUserRegistration() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		HelperFunctions.staticWait(2);
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String mockEmail="test12345678@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(mockEmail);
		HelperFunctions.staticWait(1);
		firstName.click();
		HelperFunctions.staticWait(1);
		firstName.clear();
		HelperFunctions.staticWait(1);
		firstName.sendKeys("test");
		HelperFunctions.staticWait(1);
		lastName.click();
		HelperFunctions.staticWait(1);
		lastName.clear();
		HelperFunctions.staticWait(1);
		lastName.sendKeys("test");
		HelperFunctions.staticWait(1);
		selectUserLevel.click();
		HelperFunctions.staticWait(1);
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		checkBoxes2.get(0).click();
		HelperFunctions.staticWait(2);
		Actions actions=new Actions(Driver.getDriver());
		actions.moveToElement(selectUserLevel).click().perform();
		//selectProducts.click();
		HelperFunctions.staticWait(2);
		saveButton.click();
		HelperFunctions.staticWait(3);
		
       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       //    executor.executeScript("arguments[0].click();", saveButton);
           HelperFunctions.staticWait(3);
           JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
           executor2.executeScript("arguments[0].click();", firstCompanyUsers);
        //firstCompanyUsers.click();
   		HelperFunctions.staticWait(3);
   	    searchUsers.click();
   	    HelperFunctions.staticWait(3);
	    searchUsers.sendKeys(mockEmail);
	    HelperFunctions.staticWait(1);
	    String user=emailForVerification.getText();
	    Assert.assertEquals(user, mockEmail);
	    HelperFunctions.staticWait(2);
        closeIconforDeleteUsers.click();
	    HelperFunctions.staticWait(3);
	    if(deleteUser.isDisplayed()) {
	    	 deleteUser.click();
	    }
	    HelperFunctions.staticWait(2);
	   
	}
	public void setCompanyProducts() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
		checkProducts.click();
	    HelperFunctions.staticWait(2);
	    for(WebElement each:firstCompanyProducts) {
	    	if(each.getText()!=null) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    HelperFunctions.staticWait(3);
	}
	public void setCompanyProductsSystemAuthored() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		HelperFunctions.staticWait(2);
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		//HelperFunctions.staticWait(2);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(checkProducts);
	    wait.until(condition);
		checkProducts.click();
		wait.until(ExpectedConditions.visibilityOf(firstCompanyProducts.get(0)));
	   /* for (WebElement element : firstCompanyProducts) {
	    	System.out.println(firstCompanyProducts.size());
            if (element.isDisplayed() && element.isEnabled()) {
            	Assert.assertTrue(false);
                System.out.println("Element is not clickable: " + element.getText());
            }else {
            	Assert.assertTrue(true);
            }
        }*/
	    for (WebElement element : firstCompanyProducts) {
            element.click();
            if (Driver.getDriver().getCurrentUrl().equals("https://ums-productcentral-stg.pwc.com/home")) {
                System.out.println("Element is not clickable: " + element.getText());
                Assert.assertTrue(true);
            } else {
                System.out.println("Element is clickable: " + element.getText());
                Assert.assertTrue(false);
            }

        }
	    HelperFunctions.staticWait(3);
	    
	}
	public void setCompanyProductsAccess() throws Exception {
		HelperFunctions.waitForPageToLoad(60);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		HelperFunctions.staticWait(2);
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(checkProducts));
		checkProducts.click();
		wait.until(ExpectedConditions.visibilityOf(firstCompanyProducts.get(0)));
	    for(WebElement each:firstCompanyProducts) {
	    	System.out.println(firstCompanyProducts.size());
	    	if(each.getText()!=null) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    Assert.assertTrue(firstCompanyProducts.size()>1);
	    HelperFunctions.staticWait(3);
	}
	public void setAccessSelectProductDropdown() throws Exception {
		HelperFunctions.waitForPageToLoad(60);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		HelperFunctions.staticWait(2);
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		emailAddress.click();
		HelperFunctions.staticWait(2);
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		HelperFunctions.staticWait(2);
		firstName.click();
		HelperFunctions.staticWait(2);
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		HelperFunctions.staticWait(2);
		lastName.click();
		HelperFunctions.staticWait(2);
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		HelperFunctions.staticWait(2);
		selectUserLevel.click();
		wait.until(ExpectedConditions.visibilityOf(userLabel));
		userLabel.click();
		HelperFunctions.staticWait(2);
		selectProducts.click();
		wait.until(ExpectedConditions.visibilityOf(checkBoxes2.get(0)));
		if(checkBoxes2.get(0).isDisplayed()) {
			checkBoxes2.get(0).click();
		}
		HelperFunctions.staticWait(3);
	}
	public void setTotalUsers() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(2);
		  //HelperFunctions.staticWait(3);
          JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
          executor2.executeScript("arguments[0].click();", firstCompanyUsers);
  		HelperFunctions.staticWait(5);
  		

  		List<WebElement> rows = Driver.getDriver().findElements(By.xpath("(//span[@class='adminClass'][normalize-space()='Admin'])"));
  		int numRows = rows.size();
  		System.out.println(numRows);
	}
	public void setEditProduct(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
	   // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
	    HelperFunctions.staticWait(3);
		productsTab.click();
		HelperFunctions.staticWait(15);
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		wait1.until(ExpectedConditions.visibilityOf(searchCompany));
		String auto="automation product1";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(productAutomation));
		productAutomation.click();
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(editProduct));
		editProduct.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		wait4.until(ExpectedConditions.visibilityOf(SCproduct));
		SCproduct.click();
		HelperFunctions.staticWait(2);
		Faker faker=new Faker();
		String random=faker.lorem().characters(4);
		SCproduct.clear();
		HelperFunctions.staticWait(2);
		SCproduct.sendKeys(random);
		HelperFunctions.staticWait(2);
		saveCompany.click();
		WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
		wait5.until(ExpectedConditions.visibilityOf(updateProductMessage));
		Assert.assertTrue(updateProductMessage.isDisplayed());
		HelperFunctions.staticWait(3);
		productAutomation.click();
		WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
		wait6.until(ExpectedConditions.visibilityOf(editProduct));
		editProduct.click();
		WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
		wait7.until(ExpectedConditions.visibilityOf(SCproduct));
		cancelButton2.click();
		WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 10);
		wait8.until(ExpectedConditions.visibilityOf(productAutomation));
		Assert.assertTrue(productAutomation.isDisplayed());
		HelperFunctions.staticWait(3);

	}
	public void setAddProduct(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
	    HelperFunctions.staticWait(3);
		productsTab.click();
		HelperFunctions.staticWait(15);
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		wait1.until(ExpectedConditions.visibilityOf(addProductButton));
		addProductButton.click();
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 15);
		wait2.until(ExpectedConditions.visibilityOf(saveCompany));
		Assert.assertTrue(saveCompany.isDisplayed());
		HelperFunctions.staticWait(3);
		
		
	}
	public void setAddFeature(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
	    HelperFunctions.staticWait(3);
		productsTab.click();
		HelperFunctions.staticWait(15);
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		wait1.until(ExpectedConditions.visibilityOf(searchCompany));
		String auto="automation2";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(automation2));
		automation2.click();
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(addFeatureButton));
		addFeatureButton.click();
		WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
		wait7.until(ExpectedConditions.visibilityOf(submitButton));
		HelperFunctions.staticWait(3);
		
	}
	public void setMandatoryProductSCs(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(15);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
	  
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
	    HelperFunctions.staticWait(3);
		productsTab.click();
		HelperFunctions.staticWait(5);
		wait.until(ExpectedConditions.visibilityOf(addProductButton));
		addProductButton.click();
		wait.until(ExpectedConditions.visibilityOf(saveCompany));
		productNameField.click();
		HelperFunctions.staticWait(2);
		Faker faker=new Faker();
		String random=faker.lorem().characters(4);
		productNameField.sendKeys(random);
		HelperFunctions.staticWait(2);
		productCodeField.click();
		HelperFunctions.staticWait(2);
		Faker faker2=new Faker();
		String random2=faker2.lorem().characters(4);
		productCodeField.sendKeys(random2);
		HelperFunctions.staticWait(2);
		saveCompany.click();
		wait.until(ExpectedConditions.visibilityOf(scProductError));
		Assert.assertTrue(scProductError.getText().contains("SC_Product"));
		HelperFunctions.staticWait(3);
		/*SCproduct.click();
		HelperFunctions.staticWait(2);
		String existingSC="automation";
		SCproduct.sendKeys(existingSC);
		HelperFunctions.staticWait(2);
		startDate.click();
		HelperFunctions.staticWait(2);
		LocalDate currentDate=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate=currentDate.format(formatter);
		startDate.sendKeys(formattedDate);
		HelperFunctions.staticWait(2);
		LocalDate currentDate2=LocalDate.now();
		LocalDate futureDate=currentDate2.plusMonths(3);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate2=futureDate.format(formatter2);
		HelperFunctions.staticWait(2);
		endDate.click();
		HelperFunctions.staticWait(2);
		endDate.sendKeys(formattedDate2);
		HelperFunctions.staticWait(2);
		saveCompany.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 15);
		wait4.until(ExpectedConditions.visibilityOf(scProductError));
		Assert.assertTrue(scProductError.getText().contains("already exists"));
		HelperFunctions.staticWait(3);*/
	}
	public void setSC_AccountID(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
		searchCompany.click();
		test.info("Clicked on search company and search company automation");
		String auto="Automation3";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		test.info("Wait for company automation visibility");
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
		wait1.until(ExpectedConditions.visibilityOf(automation3));
		automation3.click();
		test.info("Clicked on company automation and wait for edit company button visibility");
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(editCompany));
		editCompany.click();
		test.info("Clicked on edit company and wait for SC account visibility");
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(SCaccount));
	    String existingSC="123@2";
		SCaccount.click();
		test.info("Clicked on SC Account and send new text");
		HelperFunctions.staticWait(2);
		SCaccount.clear();
		HelperFunctions.staticWait(2);
		SCaccount.sendKeys(existingSC);
		HelperFunctions.staticWait(2);
		saveCompany.click();
		test.info("Clicked on save button");
		WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
		wait5.until(ExpectedConditions.visibilityOf(updateCompanyMessage));
		Assert.assertTrue(updateCompanyMessage.isDisplayed());
		test.info("Verified updateCompanyMessage is displayed");
		HelperFunctions.staticWait(3);

	}
	public void setSC_AccountIDMandatory(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
		addNewCompanyButton.click();
		test.info("wait for SC account visibility");
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(SCaccount));
		HelperFunctions.staticWait(2);
		SCaccount.click();
		HelperFunctions.staticWait(2);
		SCaccount.clear();
		HelperFunctions.staticWait(5);
		saveCompany.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		wait4.until(ExpectedConditions.visibilityOf(scAccountError));
		String expectedError="SC_Account";
		Assert.assertTrue(scAccountError.isDisplayed());
		
	}
	public void setProductFeatureVisibility(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
		searchCompany.click();
		test.info("Clicked on search company and search company automation");
		String auto="Automation3";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		test.info("Wait for company automation visibility");
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
		wait1.until(ExpectedConditions.visibilityOf(automation3));
		automation3.click();
		test.info("Clicked on company automation and wait for edit company button visibility");
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(assignProducts));
		assignProducts.click();
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(selectaProduct));
		selectaProduct.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		wait4.until(ExpectedConditions.visibilityOf(productsOptions.get(0)));
		for(WebElement each: productsOptions) {
			if(each.getText().contains("Connected Solutions")) {
				each.click();
				break;
			}
		}
		HelperFunctions.staticWait(2);
		featureCheckbox.click();
		HelperFunctions.staticWait(2);
		startDate2.click();
		HelperFunctions.staticWait(2);
		LocalDate currentDate=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate=currentDate.format(formatter);
		startDate2.sendKeys(formattedDate);
		HelperFunctions.staticWait(2);
		LocalDate currentDate2=LocalDate.now();
		LocalDate futureDate=currentDate2.plusMonths(1);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate2=futureDate.format(formatter2);
		HelperFunctions.staticWait(2);
		endDate2.click();
		HelperFunctions.staticWait(2);
		endDate2.sendKeys(formattedDate2);
		HelperFunctions.staticWait(2);
		submitButton.click();
		WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
		wait5.until(ExpectedConditions.visibilityOf(colsforcompany.get(0)));
		Assert.assertTrue(colsforcompany.get(0).isDisplayed());
		HelperFunctions.staticWait(2);
		int deleteCount=0;
		for(WebElement each2: adminButtons) {
			if(each2.getText().contains("Delete")) {
				deleteCount++;
				if(deleteCount==2) {
					each2.click();
					break;
				}
				
			}
		}
		WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
		wait6.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
		HelperFunctions.staticWait(3);
		
	}
	public void setLockedSymbolNotEditable(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(10);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(lockedSymbol));
	    String expectedValue=addUserLocked.getAttribute("aria-disabled");
	    Assert.assertTrue(expectedValue.contains("true"));
	    HelperFunctions.staticWait(3);
	    /*lockedCompanyUsers.click();
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(editLocked));
	    String expectedValue2=editLocked.getAttribute("aria-disabled");
	    Assert.assertTrue(expectedValue2.contains("true"));
	    HelperFunctions.staticWait(3);*/
	}
	public void setLicenseStatus(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
	    superDropdowns.get(1).click();
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(licenseTexts.get(0)));
	    Assert.assertTrue(licenseTexts.get(0).getText().contains("All"));
	    HelperFunctions.staticWait(1);
	    Assert.assertTrue(licenseTexts.get(1).getText().contains("Active"));
	    HelperFunctions.staticWait(1);
	    Assert.assertTrue(licenseTexts.get(2).getText().contains("Expired"));
	    HelperFunctions.staticWait(1);
	    Assert.assertTrue(licenseTexts.get(3).getText().contains("Future"));
	    HelperFunctions.staticWait(1);
	    Assert.assertTrue(licenseTexts.get(4).getText().contains("Expire in 30 days"));
	    HelperFunctions.staticWait(3);
	}
	public void setCompanyElements(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
		searchCompany.click();
		test.info("Clicked on search company and search company automation");
		String auto="Automation3";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		test.info("Wait for company automation visibility");
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
		wait1.until(ExpectedConditions.visibilityOf(automation3));
		automation3.click();
		test.info("Clicked on company automation and wait for edit company button visibility");
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(editCompany));
		Assert.assertTrue(editCompany.isDisplayed());
		List<String> elementTexts=new ArrayList<>();
		for(WebElement element:companyElements) {
			elementTexts.add(element.getText());
		}
		List<String> expectedTexts=Arrays.asList("PwC Products","Add User","Company Users");
		boolean allTextContained=true;
		for(String expectedText: elementTexts) {
			boolean textContained=false;
			for(String elementText:elementTexts) {
				if(elementText.contains(expectedText)) {
					textContained=true;
					break;
				}
			}
			if(!textContained) {
				allTextContained=false;
				break;
			}
		}
		if(allTextContained) {
			Assert.assertTrue(true);
		}
		HelperFunctions.staticWait(3);
		
	}
	public void setLockedFunction(ExtentTest test) throws Exception {
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		HelperFunctions.waitForPageToLoad(30);
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(addUser));
		addUser.click();
		HelperFunctions.staticWait(3);
		Driver.getDriver().get(read1.getCellData("VALUE", 77));
		//Driver.getDriver().get("https://ums-productcentral-qa.pwc.com/ums");
		HelperFunctions.waitForPageToLoad(15);
		test.info("Wait for search company visibility");
	    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(searchCompany));
		searchCompany.click();
		test.info("Clicked on search company and search company automation");
		String auto="Locked Automation";
		searchCompany.sendKeys(auto);
		HelperFunctions.staticWait(2);
		searchButton.click();
		test.info("Wait for company automation visibility");
		WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
		wait1.until(ExpectedConditions.visibilityOf(lockedAutomation));
		lockedAutomation.click();
		test.info("Clicked on company automation and wait for edit company button visibility");
		WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		wait2.until(ExpectedConditions.visibilityOf(editCompany));
		editCompany.click();
		WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
		wait3.until(ExpectedConditions.visibilityOf(switchButton));
		switchButton.click();
		WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		wait4.until(ExpectedConditions.visibilityOf(off));
		Assert.assertTrue(off.isDisplayed());
		HelperFunctions.staticWait(2);
		switchButton.click();
		WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
		wait5.until(ExpectedConditions.visibilityOf(on));
		Assert.assertTrue(on.isDisplayed());
		HelperFunctions.staticWait(3);
	}
	
	
	

}
