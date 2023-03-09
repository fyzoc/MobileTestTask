package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

import java.net.MalformedURLException;
import java.util.List;

public class TC06 extends BaseDriver {
    @Test
    public void tc06() throws MalformedURLException, InterruptedException {
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
        //Hide and Show 1.link tıklanır
        WebElement hideShowMenu=androidDriver.findElementByXPath("(//android.widget.TextView[@text='Hide and Show'])[1]");
        hideShowMenu.click();
        Thread.sleep(5000);
        //Hide and Show sayfasında olduğu valid edilir
        WebElement hideshowTitle=androidDriver.findElementByXPath("//android.widget.TextView[@text='App/Fragment/Hide and Show']");
        String hideshowText=hideshowTitle.getText();
        Assert.assertTrue(hideshowText.contains("Hide and Show"));
        Thread.sleep(5000);
        //two Hide buton and two textbox valid
        List<WebElement> mobileListButon=androidDriver.findElementsByXPath("//android.widget.Button");
        Assert.assertEquals(2,mobileListButon.size());
        Thread.sleep(5000);

        List<WebElement>mobileListTextBox=androidDriver.findElementsByXPath("//android.widget.EditText");
        Assert.assertEquals(2,mobileListTextBox.size());
        Thread.sleep(5000);
        //Textboxlar  hide olduğunu ,hide butonun show olduğu kontrol edilir
        WebElement textBox1=androidDriver.findElementByXPath("(//android.widget.EditText[@text='Initial text.'])[1]");
        WebElement hideBtn1=androidDriver.findElementById("com.hmh.api:id/frag1hide");
        hideBtn1.click();
        Thread.sleep(10000);
        WebElement textBox2=androidDriver.findElementByXPath("(//android.widget.EditText[@text='Initial text.'])[2]");
        Thread.sleep(5000);
        WebElement hideBtn2=androidDriver.findElementById("com.hmh.api:id/frag2hide");
        hideBtn2.click();
        Thread.sleep(5000);

        List<WebElement>mblistText=androidDriver.findElementsByXPath("//android.widget.LinearLayout");
        Assert.assertTrue(mblistText.contains(""));
        Thread.sleep(5000);
        Assert.assertTrue(mblistText.contains("appium2"));
        Thread.sleep(5000);

        //Show butonuna basılarak textin geri geldiği kontrol edilir.
        WebElement showBtn1=androidDriver.findElementById("com.hmh.api:id/frag1hide");
        showBtn1.click();
        Thread.sleep(5000);
    }
}
