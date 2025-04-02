package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageModel.LoginPage;
import pageModel.RegisterPatientPage;
import pageModel.UpdatePatientPage;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    LoginPage login;
    RegisterPatientPage registerPatient;
    UpdatePatientPage updatePatient;

    @Given("User is on OpenMRS Login page")
    public void user_is_on_openmrs_loginpage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        login = new LoginPage(driver);
        registerPatient = new RegisterPatientPage(driver);
        updatePatient = new UpdatePatientPage(driver);
    }

    @When("User enters invalid username {string} and password {string}")
    public void user_enters_invalid_credentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @When("User clicks Login button")
    public void user_clicks_login_button() {
        login.selectLocation();
        login.clickLogin();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals(login.getErrorMessage(), "Invalid username/password. Please try again.", "Error message did not match!");
        driver.quit();
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.selectLocation();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("home"), "User is not logged in successfully!");
        driver.quit();
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

    // **Test Case 5: Updating Patient Details**
    @When("User searches for patient {string}")
    public void user_searches_for_patient(String patientName) {
        driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
        updatePatient.searchPatient(patientName);
    }

    @When("User updates patient details")
    public void user_updates_patient_details() {
        updatePatient.clickEdit();
        updatePatient.updateAddress("Updated Street", "Updated City", "Updated State", "Updated Country", "543210");
        updatePatient.saveChanges();
    }

    @Then("Updated patient details should be saved successfully")
    public void updated_patient_details_should_be_saved_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("Updated Street"), "Update failed!");
        driver.quit();
    }
}
