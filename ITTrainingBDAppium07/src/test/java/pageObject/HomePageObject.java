package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageObject
{

	public HomePageObject(AppiumDriver driver) {//HomePage name akta constructor kore tar modde AppiumDriver driver argument pass korlam
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")//name field hello lekha pass korar jonno
	public WebElement nameField;
	
	@AndroidFindBy(xpath = "//*[@text='Female']")//female button button a click korar jonno
	public WebElement femaleButton;
	
	@AndroidFindBy(id="android:id/text1")// country select ar jonno button a click ar jonno
	public WebElement dropDownClick;
	
	
	@AndroidFindBy(xpath ="//*[@text='Bangladesh']")//bangladesh lekhta te click ar jonno locator
	public WebElement chooseCountryBangladesh;
	 
	 
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")//lets shop button a click ar jono
	public WebElement letsShop;
	
	
	
	
}
