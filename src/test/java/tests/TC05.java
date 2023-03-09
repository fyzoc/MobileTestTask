package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class TC05 extends BaseDriver {
    @Test
    public void tc05() throws MalformedURLException, InterruptedException {
        AndroidDriver androidDriver = getAppiumDriver();
    //Uygulama yüklenir ana sayfa valid edilir
        WebElement homepage= androidDriver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);

        //App menusune tıklanır
        WebElement appMenu=androidDriver.findElementByXPath("//android.widget.TextView[@text='App']");
        appMenu.click();
        Thread.sleep(5000);
        //Fragment tıklarız
        WebElement fragmentMenu=androidDriver.findElementByXPath("//android.widget.TextView[@text='Fragment']");
        fragmentMenu.click();
        Thread.sleep(5000);
        //Context Menu 1 seçilir
        WebElement contextMenu1=androidDriver.findElementByXPath("(//android.widget.TextView[@text='Context Menu'])[2]");
        contextMenu1.click();
        Thread.sleep(5000);
        //Context Menu olduğu valid edilir
        // MobileElement title=driver.findElementByXPath("//android.widget.TextView[@text='App/Fragment/Context Menu']");
        // String titleText=title.getText();
        // Assert.assertTrue(titleText.contains("Context Menu"));
        // Thread.sleep(5000);

        //LongPress buton uzun basılıp--->TouchAction classını kullanırız,web elementde action classını kullandığımız gibi
        WebElement longPress1=androidDriver.findElementById("com.touchboarder.android.api.demos:id/long_press");
        TouchAction touchAction=new TouchAction(androidDriver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longPress1))).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();
        //Menu A and  Menu B tıklanıp seçildiği valid edilir.
            /*
            Burda Menu A ve Menu B tıkladıktan sonra çıkan Toast messages,UIAutomation2 toast mesajları bulamıyor.
            */
        WebElement menuA=androidDriver.findElementByXPath("//android.widget.TextView[@text='Menu A']");
        menuA.click();
        Thread.sleep(8000);

        WebDriverWait waitForToast = new WebDriverWait(androidDriver,3);
        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
        String toastMessageA=androidDriver.findElementByClassName("android.widget.Toast").getText();
        Assert.assertTrue(toastMessageA.contains("Item 1a was chosen"));
        Thread.sleep(5000);

        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longPress1))).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();
        WebElement menuB=androidDriver.findElementByXPath("//android.widget.TextView[@text='Menu B']");
        menuB.click();
        Thread.sleep(5000);
        String toastMessageB=androidDriver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
        Assert.assertTrue(toastMessageB.contains("Item 1a was chosen"));
        Thread.sleep(5000);
    }

    }

