package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class TC04 extends BaseDriver {
    @Test
    public void tc04() throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = getAppiumDriver();

        //Uygulama yüklenir ana sayfa valid edilir
        WebElement homepage= androidDriver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);
        //  'Go to App > Device Admin > General menus > Enable Admin' menu.
        WebElement appMenu=androidDriver.findElementByXPath("//android.widget.TextView[@text='App']");
        appMenu.click();
        Thread.sleep(5000);

        //  In the opened activity, the 'Enable admin' radio button is pressed,
        WebElement deviceAdmin=androidDriver.findElementByXPath("(//android.widget.TextView[@text='Device Admin'])[1]");
        deviceAdmin.click();
        Thread.sleep(5000);
        //  and the 'Activate' button is pressed in the new activity.

        //  By checking that the active activity is General activity,
        WebElement generalMenu=androidDriver.findElementByXPath("(//android.widget.LinearLayout)[4]");
        WebElement generalTitle=androidDriver.findElementById("android:id/action_bar");
        generalMenu.click();
        Thread.sleep(5000);
        Assert.assertTrue(generalTitle.isDisplayed());
        Thread.sleep(5000);

        //  it is checked that the 'Enable admin' radio button is active.
        WebElement enableAdmın=androidDriver.findElementByXPath("(//android.widget.TextView[@text='Enable admin'])[2]");
        enableAdmın.click();
        Thread.sleep(8000);
        WebElement deviceAdminTitle=androidDriver.findElementById("com.android.settings:id/collapsing_toolbar");
        Assert.assertTrue(deviceAdminTitle.isDisplayed());
        Thread.sleep(5000);

        //Bu şekilde yaptık, çünkü tıklayacağımız element tarayıcının göremeyeceği bir yerde dimenson ve TouchAction kullanarak ekranı aşağı kaydıracağız
        List<WebElement> mobileList;

        do {
            mobileList=androidDriver.findElementsByXPath("//android.widget.TextView");
            Dimension dimension=androidDriver.manage().window().getSize();

            int start_x= (int) (dimension.width*0.5);
            int start_y= (int) (dimension.height*0.8);

            int end_x= (int) (dimension.width*0.5);
            int end_y= (int) (dimension.height*0.2);

            TouchAction touchAction=new TouchAction(androidDriver);
            touchAction.press(PointOption.point(start_x,start_y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(end_x,end_y)).
                    release().perform();

        }while(mobileList.size()==0);
        Thread.sleep(2000);
        WebElement activateDeviceAdmin=androidDriver.findElementById("com.android.settings:id/action_button");
        activateDeviceAdmin.click();
        Thread.sleep(5000);
        WebElement enableAdminChecked=androidDriver.findElementByXPath("(//android.widget.CheckBox)[1]");
        //enableAdminChecked.getAttribute("checked");
        Assert.assertEquals(enableAdminChecked.getAttribute("checked"),true);
        Thread.sleep(5000);
    }
}

