package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import page.LoginPage;
import page.RegisterPateintPage;
import page.UpdatePatientPage;
import org.testng.Assert;

public class MRSSteps {
    WebDriver driver;
    LoginPage login;
    RegisterPateintPage registerPatient;
    UpdatePatientPage updatePatient;

    @Given("User is on OpenMRS Login page")
    public void user_is_on_openmrs_loginpage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        login = new LoginPage(driver);
        registerPatient = new RegisterPateintPage(driver);
        updatePatient = new UpdatePatientPage(driver);
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.selectLocation();
    }

    @When("User clicks Login button")
    public void user_clicks_login_button() {
        login.clickLogin();
    }

    @When("User navigates to Register a Patient page")
    public void user_navigates_to_register_a_patient_page() {
        driver.findElement(By.linkText("Register a patient")).click();
    }
    @When("User enters mandatory patient details")
    public void user_enters_mandatory_patient_details() {
        registerPatient.enterGivenName("Sana");
        registerPatient.enterFamilyName("Narayan");
        registerPatient.clickNext();

        registerPatient.selectGender("Female");
        registerPatient.clickNext();

        registerPatient.enterBirthdate("12", "June", "2000");
        registerPatient.clickNext();

        registerPatient.enterAddress("Street ABC", "City XYZ", "State PQR", "Country LMN", "123456");
        registerPatient.clickNext();

        registerPatient.enterPhoneNumber("112");
        registerPatient.clickNext();

        registerPatient.selectRelationship("Sibling");
        registerPatient.enterRelativeName("John Doe");
        registerPatient.clickNext();

        registerPatient.clickConfirm();
    }

    @When("User submits the patient form")
    public void user_submits_the_patient_form() {
        registerPatient.clickConfirm();
    }

    @Then("Patient should be registered successfully")
    public void patient_should_be_registered_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("Patient ID"), "Patient registration failed!");
        driver.quit();
    }

    @When("User searches for the registered patient")
    public void user_searches_for_registered_patient() {
        updatePatient.searchPatient("Sana Narayan");
    }

    @When("User updates the patient's details")
    public void user_updates_patient_details() {
        updatePatient.enterNewAddress("New Street XYZ");
    }

    @Then("Patient details should be updated successfully")
    public void patient_details_updated_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("Updated Successfully"), "Patient update failed!");
        driver.quit();
    }
}
