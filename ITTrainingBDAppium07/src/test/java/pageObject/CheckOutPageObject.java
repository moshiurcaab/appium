package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPageObject {
	public CheckOutPageObject(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	//public List<WebElement> totalAmount; 	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")//productprice namer 2 ta same product ar value ar list
	public List<WebElement> productList; 									// public List<WebElement> name; -->for FindByElements
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement total;
}
