package altunity.pages;

import ro.altom.altunitytester.AltUnityDriver;

public class BasePage {
    private AltUnityDriver driver;

    public BasePage(AltUnityDriver driver) {
        this.driver = driver;
    }

    public AltUnityDriver getDriver() {
        return driver;
    }

    public void setDriver(AltUnityDriver driver) {
        this.driver = driver;
    }

    public void loadScene(String scene){
        getDriver().loadScene(scene);
    }
    public String getScene(){
        return getDriver().getCurrentScene();
    }
}
