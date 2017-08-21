package com.identity.e2e.dvlaPagesPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by NasirAhmed on 19/08/2017.
 */
public class EnterVehicleRegistrationPage extends GetVehicleInfoPage {


    @FindBy(id = "Vrm")
    private WebElement vehicleRegistrationInputBox;

    @FindBy(css = "a.button")
    private WebElement startNow;
}