package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class TC07 extends BaseDriver {
    public void test07() throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = getAppiumDriver();

        //Uygulama yüklenir ana sayfa valid edilir
        WebElement homepage= androidDriver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);

        //App menusune tıklanır
        WebElement appMenu=androidDriver.findElementByXPath("//android.widget.TextView[@text='App']");
        appMenu.click();
        Thread.sleep(5000);
        //Notification tıklanır
        WebElement notif=androidDriver.findElementByXPath("//android.widget.TextView[@text='Notification']");
        notif.click();
        Thread.sleep(5000);
        //IncomingMessage tıklanır,valid edilir
        WebElement ıncomıng=androidDriver.findElementByXPath("(//android.widget.TextView[@text='IncomingMessage'])[1]");
        ıncomıng.click();
        Thread.sleep(5000);
        WebElement ıncomıngTitle=androidDriver.findElementByXPath("//android.widget.TextView[@text='App/Notification/IncomingMessage']");
        Assert.assertTrue(ıncomıngTitle.isDisplayed());
        Thread.sleep(5000);
        //Show notification tıklanır,notification bar area checked
        WebElement showNotif=androidDriver.findElementById("com.hmh.api:id/notify");
        showNotif.click();
        Thread.sleep(5000);
        androidDriver.openNotifications();
        Thread.sleep(5000);
        //driver.executeScript("mobile : getNotifications");
        //Map<String,Object>notifications= (Map<String, Object>) driver.executeScript("mobile : getNotifications");
        //
        Map<String,Object> response= (Map<String, Object>) androidDriver.executeScript("mobile : getNotifications");
        List<Map<String,Object>> notifications= (List<Map<String, Object>>) response.get("statusBarNotifications");
        for (Map<String, Object> notification : notifications) {
            Map<String, String> innerNotification = (Map<String, String>)notification.get("notification");
            if (innerNotification.get("title") != null) {
                System.out.println(innerNotification.get("title"));
            }
        }

    }
}
