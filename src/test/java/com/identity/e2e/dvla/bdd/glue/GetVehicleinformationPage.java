package com.identity.e2e.dvla.bdd.glue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import org.openqa.selenium.*;


/**
 * Created by NasirAhmed on 18/08/2017.
 */
public class GetVehicleinformationPage

{
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    public GetVehicleinformationPage()
    {
        }

    @Given("^that DVLA 'Start Now' page is open$")
    public void StartNowPage() throws Throwable
    {
        driver.get(baseUrl + "/get-vehicle-information-from-dvla");
    }

    @Then("^click on the 'Start now button'$")
    public void startNowButton() throws Throwable
    {
        assertEquals(driver.findElement(By.linkText("Start now")).getText(), "Start now");
        driver.findElement(By.linkText("Start now")).click();

    }

    @Given("^the 'Vehicle Enquiry page' is open$")
    public void vehicleEnquiryPage() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^vehicle registration 'Number Input box' is displayed$")
    public void vehicleRegistrationNumberInputBox() throws Throwable
    {
        assertTrue(By.id("Vrm"));
    }

    private void assertTrue(By vrm) {
    }

    @And("^the 'Continue Button' is displayed under the vehicle registeration number input box$")
    public void continueButton() throws Throwable
    {

        assertEquals(driver.findElement(By.name("Continue")).getText(), "Continue");
    }

    @Then("^enter the vehicle registration number in the vehicle registeration number input box$")
    public void enterTheVehicleRegistrationNumber() throws Throwable
    {
        driver.findElement(By.id("Vrm")).sendKeys("E4MEU");
    }

    @Then("^click on 'Continue Button'$")
    public void clickOnContinueButton() throws Throwable
    {
        driver.findElement(By.name("Continue")).click();
    }

    @Given("^that 'Vehicle Information page' is open$")
    public void vehicleInformationPage() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^the Vehicle Make' is displayed$")
    public void theVehicleMake() throws Throwable
    {
        assertEquals(driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[2]/span[2]/strong")).getText(), "MERCEDES-BENZ");
    }

    @And("^the 'Vehicle Colour' is displayed$")
    public void theVehicleColour() throws Throwable
    {
        assertEquals(driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[3]/span[2]/strong")).getText(), "SILVER");
    }
}
