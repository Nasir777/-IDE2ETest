package com.identity.e2e.dvlaPagesPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by NasirAhmed on 20/08/2017.
 */
public class VehicleConfirmationPage extends GetVehicleInfoPage
{

    @FindBy(name = "Correct")
    private List<WebElement> yes;

    @FindBy(name = "Correct")
    private List<WebElement> no;

    @FindBy(name = "Continue")
    private WebElement continueButton;


}
