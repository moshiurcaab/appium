package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPageObject {
	public ProductsPageObject(AppiumDriver driver) {//ProductsPageObject name akta constructor kore tar modde AppiumDriver driver argument pass korlam
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")// ADDED TO CART namer sob products ar list ar locator
	public List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")//for products click after select ADD TO CART
	public WebElement cart;
}
