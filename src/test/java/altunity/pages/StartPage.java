package altunity.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

public class StartPage extends BasePage{

    public AltUnityObject startButton;

    public StartPage(AltUnityDriver driver) {
        super(driver);
    }

//    public boolean isDisplayed(){
//        if(startButton != null && startText != null && logoImage != null && unityUrlButton != null){
//            return true;
//        }
//        return false;
//    }

//    public void load(){
//        getDriver().loadScene("Start");
//    }

    public void clickStartButton(){
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "StartButton").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.startButton = getDriver().waitForObject(params);
        startButton.tap();
    }
}
