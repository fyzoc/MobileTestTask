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
    public void tc02() throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = getAppiumDriver();

        //'App > Activity > Custom Title' menu. In the activity that opens
        WebElement appButton=androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]"));
        Thread.sleep(4000);
        appButton.click();

        WebElement activity=androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]"));
        Thread.sleep(4000);
        activity.click();
        WebElement customTitle= androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]"));
        customTitle.click();
        Thread.sleep(5000);

        //the default textBox and navigationBar texts are checked
        WebElement leftBox=androidDriver.findElement(By.id("com.hmh.api:id/left_text_edit"));
        Assert.assertTrue(leftBox.getText().contains("Left is best"));
        WebElement rightBox= androidDriver.findElement(By.id("com.hmh.api:id/right_text_edit"));
        Assert.assertEquals(rightBox.getText(),"Right is always right");
        WebElement rightButon= androidDriver.findElement(By.id("com.hmh.api:id/right_text_button"));
        Assert.assertTrue(rightButon.isDisplayed());
        WebElement header=androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout"));
        Assert.assertTrue(header.isDisplayed());

        //By changing the left and right textBox fields, it is checked that the relevant textBox and navigationBar texts have changed.
        leftBox.click();
        leftBox.clear();
        Thread.sleep(5000);
        leftBox.findElement(By.id("com.hmh.api:id/left_text_edit")).sendKeys("feyza");

        WebElement leftButon= androidDriver.findElement(By.id("com.hmh.api:id/left_text_button"));
        leftButon.click();
       // Assert.assertTrue(header.getText().contains("feyza"));


        rightBox.click();
        rightBox.clear();
        rightBox.sendKeys("ocakdan");


        rightButon.click();
        Assert.assertEquals(rightBox.getText(),"ocakdan");


    }

}
