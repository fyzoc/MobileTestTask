package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseDriver;

import java.net.MalformedURLException;
import java.util.List;

public class TC03 extends BaseDriver {
    @Test
    public void tc03() throws MalformedURLException {
        AndroidDriver androidDriver =getAppiumDriver();

        //'Follow the App > Alert Dialogs > List dialog' menu.
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]")).click();
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[4]")).click();
        androidDriver.findElement(By.id("com.hmh.api:id/select_button")).click();

        // In the opened activity, any element is selected in the list dialog,

        // List<MobileElement> elementsOne = (List<MobileElement>) androidDriver.findElementByClassName("android.widget.TextView");
        // System.out.println(elementsOne);

        //A fter the selection is made, the order of the selected element and the name of the element is checked in the alert message.
        Assert.assertEquals(androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")).getText(),"Command two");
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")).click();
        Assert.assertEquals(androidDriver.findElement(By.id("android:id/message")).getText(),"You selected: 1 , Command two");


    }

}
