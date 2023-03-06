package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

import java.net.MalformedURLException;

public class TC02 extends BaseDriver {
    @Test
    public void tc02() throws MalformedURLException {
        AndroidDriver androidDriver = getAppiumDriver();

        //'App > Activity > Custom Title' menu. In the activity that opens
        WebElement appButton =  androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]"));
        appButton.click();
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]")).click();
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]")).click();

        //the default textBox and navigationBar texts are checked
        Assert.assertTrue(androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit")).getText().contains("Left is best"));
        Assert.assertEquals(androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit")).getText(),"Right is always right");
        Assert.assertTrue(androidDriver.findElement(By.id("com.hmh.api:id/right_text_button")).isDisplayed());
        Assert.assertTrue( androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout")).isDisplayed());

        //By changing the left and right textBox fields, it is checked that the relevant textBox and navigationBar texts have changed.
        androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit")).click();
        androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit")).clear();
        androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit")).sendKeys("feyza");
        androidDriver.findElement(By.id("com.hmh.api:id/left_text_button")).click();
        Assert.assertTrue(androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit")).getText().contains("feyza"));

        androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit")).click();
        androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit")).clear();
        androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit")).sendKeys("ocakdan");
        androidDriver.findElement(By.id("com.hmh.api:id/right_text_button")).click();
        Assert.assertEquals(androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit")).getText(),"ocakdan");


    }

}
