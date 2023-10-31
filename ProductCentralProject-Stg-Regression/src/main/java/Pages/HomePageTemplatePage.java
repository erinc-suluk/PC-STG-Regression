package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class HomePageTemplatePage extends HelperFunctions {
	public HomePageTemplatePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	@FindBy(xpath="//div[@title='Product Central Footer']")
	private WebElement footer;



	public void setFooter() {
		Actions a = new Actions(Driver.getDriver());
		a.doubleClick(footer).build().perform();
		HelperFunctions.staticWait(3);
	}
	
	
	
	
	
	
	
	

}
