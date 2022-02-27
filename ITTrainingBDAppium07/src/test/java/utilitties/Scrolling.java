package utilitties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scrolling {
	
	
	AndroidDriver driver;//driver ke initialize korlam
	public Scrolling(AndroidDriver<AndroidElement> driver) {//
		this.driver=driver;
	}
	 
	 public void scrollToText(String value)//bangladesh value ta utill dia scrollToText method  ke call ar maddome  string value ar modde dukbe 
		{
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));");//scrool korbe jotosomoy porjonto text a bangladesh lekha deka na jay
		}

}
