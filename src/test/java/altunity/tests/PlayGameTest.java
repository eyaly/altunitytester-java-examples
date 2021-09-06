package altunity.tests;

import altunity.pages.GamePlayPage;
import altunity.pages.MainMenuPage;
import altunity.pages.StartPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PlayGameTest {

    private static AltUnityDriver altUnityDriver;
    private static AndroidDriver appiumDriver;

    private static StartPage startPage;
    private static MainMenuPage mainMenuPage;
    private static GamePlayPage gamePlayPage;

    @BeforeClass
    public static void setUp() throws Exception {

        System.out.println("*** AltUnityTester - setUp " );

        String deviceName = "localhost:7000";

        String app = System.getProperty("user.dir") + "/app/alttrashcat_latest.apk";
        String url = "http://localhost:4723/wd/hub";

        AltUnityDriver.setupPortForwarding("android", deviceName, 13001, 13000);
        DesiredCapabilities capabilities = new DesiredCapabilities();
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

    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("*** AltUnityTester - tearDown " );
        altUnityDriver.stop();
        appiumDriver.quit();
        AltUnityDriver.removePortForwarding();
    }

    @Test
    public void testPlayTheGame() throws Exception{
        System.out.println("*** AltUnityTester - testPlayTheGame " );

        startPage = new StartPage(altUnityDriver);
        mainMenuPage = new MainMenuPage(altUnityDriver);
        gamePlayPage = new GamePlayPage(altUnityDriver);

        // verify we on the first page
        Assert.assertEquals(startPage.getScene(), "Start");

        // Click Start
        startPage.clickStartButton();
        Assert.assertEquals(mainMenuPage.getScene(), "Main");
        waiting();

        // Click Run
        mainMenuPage.pressRun();
        System.out.println("*** AltUnity - Scene: " + gamePlayPage.getScene());

        waiting();
        gamePlayPage.pauseGame();
        waiting();
        gamePlayPage.resumeGame();
        gamePlayPage.getCharacter();
        gamePlayPage.avoidObstacles(10);
        int currentLife = gamePlayPage.getCurrentLife();
        System.out.println("*** AltUnity - currentLife: " + currentLife);
        assertTrue(currentLife>0);

    }

    public void waiting() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            //
        }
    }
}
