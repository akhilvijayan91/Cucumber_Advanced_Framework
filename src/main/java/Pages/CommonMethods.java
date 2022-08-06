package Pages;

import Driver_SetUp.Driver;

public class CommonMethods {
    public static String getTitle() {
        return Driver.getDriver().getCurrentUrl();
    }
}
