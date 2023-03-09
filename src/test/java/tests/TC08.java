package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

import java.net.MalformedURLException;

public class TC08 extends BaseDriver {
    public void tc08() throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = getAppiumDriver();

        //Uygulama yüklenir ana sayfa valid edilir
        WebElement homepage= androidDriver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);
        //Views menusune tıklanır
        WebElement viewsMenu=androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']");
        viewsMenu.click();
        Thread.sleep(5000);
        //Tabs menu tıklanır
        AndroidElement element1 = (AndroidElement) androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Tabs\"))");
        element1.click();
        Thread.sleep(10000);

        //Scrollable tıklanır(Bu sefer index-> 2)
        WebElement scrol=androidDriver.findElementByXPath("(//android.widget.TextView[@text='5. Scrollable'])[2]");
        scrol.click();
        Thread.sleep(7000);

        //****Tab 30 yatay kaydırma(Horizontal scroll)****
        TouchAction touchAction=new TouchAction(androidDriver);

        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\"TAB 30\"))"));
        WebElement tab30=androidDriver.findElementByXPath("//android.widget.TextView[@text='TAB 30']");
        tab30.click();
        Thread.sleep(5000);
        WebElement doc30=androidDriver.findElementByXPath("//android.widget.TextView[@text='Content for tab with tag Tab 30']");
        String text30=doc30.getText();
        Assert.assertTrue(text30.contains("Tab 30"));

    }

    }

