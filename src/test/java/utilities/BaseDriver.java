package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

        public static AndroidDriver<AndroidElement> getAppiumDriver() throws MalformedURLException {


                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
                desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/HP/IdeaProjects/MobileTestTask/src/App/API_Demos.apk");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
                desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,"false");


                URL url = new URL("http://0.0.0.0:4723/wd/hub");
                AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(url, desiredCapabilities);
                androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                return androidDriver;
        }

}