package testCase;

import java.net.MalformedURLException;

import org.apache.http.util.Asserts;
import org.junit.Test;
import org.openqa.selenium.By;


import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import junit.framework.Assert;
import pageObject.CheckOutPageObject;
import pageObject.HomePageObject;
import pageObject.ProductsPageObject;
import utilitties.Scrolling;


public class Ecommerce extends Base {
	@Test
	public void mySecondTest() throws MalformedURLException, InterruptedException {//mySecond name akta method create korlam
		AndroidDriver driver=capabilities();//base class ar capabilities ke call korlam  or
		//AndroidDriver<AndroidElement> driver=capabilities();
		Thread.sleep(2000);
		
		HomePageObject hpage=new HomePageObject(driver);
		hpage.femaleButton.click();
		hpage.nameField.sendKeys("hello");
		
		hpage.dropDownClick.click();
		
		Scrolling util=new Scrolling(driver);//Utilitties class ar akta object create korlam
		util.scrollToText("Bangladesh");//util object ar moddome utilittieis class scrollToText method ke call korlam and Bangladesh value pathalam
		
		
		hpage.chooseCountryBangladesh.click();//bangladesh lekhate click korbe
		
		hpage.letsShop.click();//lets shop button a click korbe
		
		//product selection(ADD TO CART)
		ProductsPageObject prod=new ProductsPageObject(driver);
		prod.addToCart.get(1).click();//addToCart products list ar 1 indext ar product ta click hobe
		prod.addToCart.get(0).click();//addToCart products list ar 0 indext ar product ta click hobe bcz 1 index ar product  click hole nicher product ta 1 hoya jai 
		Thread.sleep(2000);
		prod.cart.click();//cart a click korbe
		
		//product value comparison
		CheckOutPageObject cpage=new CheckOutPageObject(driver);//CheckOutPageObject ar akta object create  korlam
		double sum=0;
		int count=cpage.productList.size();//checkoutpageobject a powa 2 ta product ar sieze 2 count ar modde rakhalam
		for (int i = 0; i < count; i++) {//i =0 to 2 porjonto
			String amountWithDollarSign = cpage.productList.get(i).getText();//productlist a powa valuegulor modde i=0 ar jonno first text $ 120.0 nibe and amountwithdolar sign ar modde rakhbe
			double onlyDoubleAmount = getAmount(amountWithDollarSign);//getAmount method ke call korbe and amountWithdolar sign ar value ke pass korbe getAmount method setake double valute convert kore return korbe and onlyDoubleAmount a dukbe
			sum = sum + onlyDoubleAmount;
		}
		
		System.out.println("SumOfProducts individually: " + sum);

		String amountWithDollarSign = cpage.total.getText();//cpga ar moddome Total Purchase Amount ar  string text $280.97 ke total ar modde rakhlam 
		double totalValue = getAmount(amountWithDollarSign);//getAmount method ke call kore ar modde total ar value pass kore getAmount method ar return kora double value ke totalValue ar modde kahlam 
		System.out.println("TotalValue from the application: " + totalValue);

		
	    Assert.assertEquals(sum, totalValue);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.quit();
		
	}
	
	//remove dolar sign and convert string to double
	public static double getAmount(String amountWithDollarSign) {//total purshase price ar jonno getAmount name method create kore ar modde amountWithdolarsign value dibo ...
		String amountWithOutDollarSign = amountWithDollarSign.substring(1);//amountWithdolarsign ar first 1 dolar sign bad dia bakituku amountwithoutdolarsign a dibe
		double amountOnlyDouble = Double.parseDouble(amountWithOutDollarSign);//string value ke double value te convert kore amountOnlydouble a rakhe
		return amountOnlyDouble;//amountonlydouble value return kore
	}
}
