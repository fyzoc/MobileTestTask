package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BaseDriver;

import java.net.MalformedURLException;

public class TC01 extends BaseDriver {
    @Test
    public void tc01 () throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = BaseDriver.getAppiumDriver();

        //is checked that the opened app is the desired app.
        Assert.assertEquals(androidDriver.findElement(By.xpath("//*[@text='API Demos']")).getText(),"API Demos");

        //'Go to App
        WebElement appButton =androidDriver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        appButton.click();

        //> ActionBar
        WebElement actionBar =androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Action Bar']"));
        actionBar.click();

        //> Action Bar Tabs' menu.
        WebElement actionBarTabs =androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='Action Bar Tabs'])[1]"));
        actionBarTabs.click();

        // !!!!??Make sure that the 'Toggle tab mode' is passive.
        WebElement toggleTab=androidDriver.findElementById("com.hmh.api:id/btn_toggle_tabs");
        toggleTab.click();
        Thread.sleep(5000);
        WebElement addNewTab =androidDriver.findElement(By.id("com.hmh.api:id/btn_add_tab"));
        // Add 3 new tabs,
        for (int i = 0; i < 3; i++) {
            addNewTab.click();
        }
        // check that 3 tabs have been added
        androidDriver.findElement(By.id("com.hmh.api:id/btn_toggle_tabs")).click();
        Thread.sleep(1000);
        System.out.println(androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[3]/android.widget.TextView")).getText());
        Assert.assertEquals(androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[3]/android.widget.TextView")).getText(),"TAB 2");

        // the last added tab is deleted with,'Remove last tab'
        androidDriver.findElement(By.id("com.hmh.api:id/btn_remove_tab")).click();


        // and it is checked that the correct tab has been deleted.
       Assert.assertEquals(androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab[2]/android.widget.TextView")).getText(),"TAB 1");


        // With 'Remove all tabs',
        androidDriver.findElement(By.id("com.hmh.api:id/btn_remove_all_tabs")).click();

        // all tabs are deleted and it is checked that there are no active tabs in the activity
        Assert.assertTrue(androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout")).isDisplayed());


    }

}

