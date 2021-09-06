package altunity.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import ro.altom.altunitytester.Commands.UnityCommand.AltLoadSceneParameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartPageTest {

    @BeforeClass
    public static void setUp() throws Exception {
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void testStartPageLoadedCorrectly1() throws MalformedURLException {
        AltUnityDriver altUnityDriver;
        AndroidDriver appiumDriver;
        System.out.println("*** AltUnity - testStartPageLoadedCorrectly1 " );

        System.out.println("*** AltUnity - setUp ");
        String deviceName = "localhost:7000";
        //String deviceName = "2271469230027ece";

        String app = "/Users/eyalyovel/Documents/github/customers/AltUnity/alttrashcat_latest.apk";
        String url = "http://localhost:4723/wd/hub";

        AltUnityDriver.setupPortForwarding("android", deviceName, 13001, 13000);
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", app);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceName);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 8200);

        appiumDriver = new AndroidDriver(new URL(url), capabilities);
        System.out.println("*** AndroidDriver - was created " );
        appiumDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//        altUnityDriver = new AltUnityDriver("127.0.0.1", 13001);
        altUnityDriver = new AltUnityDriver ("127.0.0.1", 13001, ";", "&", true);

        actualTest(appiumDriver, altUnityDriver, "testStartPageLoadedCorrectly1");

    }
//
//    @Test
//    public void testStartPageLoadedCorrectly2() throws MalformedURLException {
//        AltUnityDriver altUnityDriver;
//        AndroidDriver appiumDriver;
//        System.out.println("*** AltUnity - testStartPageLoadedCorrectly2 " );
//
//        System.out.println("*** AltUnity - setUp ");
//        String deviceName = "localhost:7002";
//        String app = "/Users/eyalyovel/Documents/github/customers/AltUnity/alttrashcat_latest.apk";
//        String url = "http://localhost:4723/wd/hub";
//
//        AltUnityDriver.setupPortForwarding("android", deviceName, 13002, 13000);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", app);
//        capabilities.setCapability(MobileCapabilityType.UDID, deviceName);
//        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 8201);
//
//        appiumDriver = new AndroidDriver(new URL(url), capabilities);
//        System.out.println("*** AndroidDriver - was created " );
//        appiumDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//        //altUnityDriver = new AltUnityDriver("127.0.0.1", 13002);
//        altUnityDriver = new AltUnityDriver ("127.0.0.1", 13002, ";", "&", true);
//
//        actualTest(appiumDriver, altUnityDriver, "testStartPageLoadedCorrectly2");
//    }
//
//    @Test
//    public void testStartPageLoadedCorrectly3() throws MalformedURLException {
//        AltUnityDriver altUnityDriver;
//        AndroidDriver appiumDriver;
//        System.out.println("*** AltUnity - testStartPageLoadedCorrectly3 " );
//
//        System.out.println("*** AltUnity - setUp ");
//        String deviceName = "localhost:7005";
//        //String deviceName = "2271469230027ece";
//
//        String app = "/Users/eyalyovel/Documents/github/customers/AltUnity/alttrashcat_latest.apk";
//        String url = "http://localhost:4723/wd/hub";
//
//        AltUnityDriver.setupPortForwarding("android", deviceName, 13003, 13000);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", app);
//        capabilities.setCapability(MobileCapabilityType.UDID, deviceName);
//        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 8202);
//
//        appiumDriver = new AndroidDriver(new URL(url), capabilities);
//        System.out.println("*** AndroidDriver - was created " );
//        appiumDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
////        altUnityDriver = new AltUnityDriver("127.0.0.1", 13001);
//        altUnityDriver = new AltUnityDriver ("127.0.0.1", 13003, ";", "&", true);
//
//        actualTest(appiumDriver, altUnityDriver, "testStartPageLoadedCorrectly3");
//
//    }
//
//    @Test
//    public void testStartPageLoadedCorrectly4() throws MalformedURLException {
//        AltUnityDriver altUnityDriver;
//        AndroidDriver appiumDriver;
//        System.out.println("*** AltUnity - testStartPageLoadedCorrectly4 " );
//
//        System.out.println("*** AltUnity - setUp ");
//        String deviceName = "localhost:7004";
//        //String deviceName = "2271469230027ece";
//
//        String app = "/Users/eyalyovel/Documents/github/customers/AltUnity/alttrashcat_latest.apk";
//        String url = "http://localhost:4723/wd/hub";
//
//        AltUnityDriver.setupPortForwarding("android", deviceName, 13004, 13000);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", app);
//        capabilities.setCapability(MobileCapabilityType.UDID, deviceName);
//        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 8203);
//
//        appiumDriver = new AndroidDriver(new URL(url), capabilities);
//        System.out.println("*** AndroidDriver - was created " );
//        appiumDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
////        altUnityDriver = new AltUnityDriver("127.0.0.1", 13001);
//        altUnityDriver = new AltUnityDriver ("127.0.0.1", 13004, ";", "&", true);
//
//        actualTest(appiumDriver, altUnityDriver, "testStartPageLoadedCorrectly4");
//
//    }


//    @Test
//    public void testStartPageLoadedCorrectly_ios() throws MalformedURLException {
//        AltUnityDriver altUnityDriver;
//        IOSDriver appiumDriver;
//        System.out.println("*** AltUnity - testStartPageLoadedCorrectly_ios " );
//
//        System.out.println("*** AltUnity - setUp ");
//        String deviceName = "iPhone_SE_11_3_POC12";
//        String app = "/Users/eyalyovel/Documents/github/customers/AltUnity/application.ipa";
//        String url = "http://localhost:4723/wd/hub";
//
//        AltUnityDriver.setupPortForwarding("android", "", 13000, 13000);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("automationName", "XCuiTest");
//        capabilities.setCapability("app", app);
//        //capabilities.setCapability(MobileCapabilityType.UDID, deviceName);
//        //capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 8200);
//
//        appiumDriver = new IOSDriver(new URL(url), capabilities);
//        System.out.println("*** iOS Driver - was created " );
//        appiumDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
////        altUnityDriver = new AltUnityDriver("127.0.0.1", 13001);
//        altUnityDriver = new AltUnityDriver ("127.0.0.1", 13000, ";", "&", true);
//
//       // actualTest(appiumDriver, altUnityDriver);
//
//
//    }

    public void actualTest(AndroidDriver appiumDriver, AltUnityDriver altUnityDriver, String methodName) {
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie)
            {
                //
            }

            String[] allScenes = altUnityDriver.getAllLoadedScenes();
            String currentScene = altUnityDriver.getCurrentScene();
            System.out.println("*** AltUnity - CurrentScene for method: " + methodName + " is: " + currentScene );

            // Click on Start button
            AltFindObjectsParameters altFindObjectsParameters = new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME,
                    "StartButton").build();
            AltUnityObject startButton = altUnityDriver.findObject(altFindObjectsParameters);
            System.out.println("*** AltUnity - startButton x: " + startButton.x + " .startButton.mobileY: " + startButton.mobileY);
            TouchAction tapButton = new TouchAction(appiumDriver);
            tapButton.tap(new PointOption().withCoordinates(startButton.x, startButton.mobileY)).perform();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie)
            {
                //
            }

            // run button
            AltFindObjectsParameters par1=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/StartButton").build();
            AltWaitForObjectsParameters params1 = new AltWaitForObjectsParameters.Builder(par1).withTimeout(10).build();
            AltUnityObject runButton = altUnityDriver.waitForObject(params1);
            runButton.tap();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie)
            {
                //
            }

            // pause button
            AltFindObjectsParameters par2=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/WholeUI/pauseButton").build();
            AltWaitForObjectsParameters params2 = new AltWaitForObjectsParameters.Builder(par2).withTimeout(2).build();
            AltUnityObject pauseButton = altUnityDriver.waitForObject(params2);
            pauseButton.tap();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie)
            {
                //
            }

        } finally {
            System.out.println("*** AltUnity - tearDown " );
            altUnityDriver.stop();
            appiumDriver.quit();
            AltUnityDriver.removePortForwarding();
        }
    }
}
