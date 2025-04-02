package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPatientPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
    }

    public void enterGivenName(String givenName) {
        WebElement givenNameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("givenName")));
        givenNameField.sendKeys(givenName);
    }

    public void enterFamilyName(String familyName) {
        WebElement familyNameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("familyName")));
        familyNameField.sendKeys(familyName);
    }

    public void clickNext() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'next-button')]")));
        nextButton.click();
    }

    public void selectGender(String gender) {
        WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + gender + "']")));
        genderOption.click();
        clickNext();
    }

    public void enterBirthdate(String day, String month, String year) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateDay"))).sendKeys(day);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateMonth"))).sendKeys(month);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateYear"))).sendKeys(year);
        clickNext();
    }

    public void enterAddress(String street, String city, String state, String country, String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='address1']"))).sendKeys(street);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cityVillage']"))).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='stateProvince']"))).sendKeys(state);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='country']"))).sendKeys(country);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='postalCode']"))).sendKeys(postalCode);
    }



    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.name("phoneNumber")));
        phoneField.sendKeys(phoneNumber);
        clickNext();
    }

    public void selectRelationship(String relationship) {
        try {
            // Wait for the relationship dropdown to be visible and clickable
            WebElement relationshipDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("relationship_type")));
            // Use JavaScript if normal selection fails
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", relationshipDropdown);
            relationshipDropdown.click(); // Click the dropdown

            // Select the relationship using XPath option
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'" + relationship + "')]")));
            option.click();
            
        } catch (Exception e) {
            System.out.println("Error selecting relationship: " + e.getMessage());
        }
    }


    public void enterRelativeName(String relativeName) {
        try {
            // Wait for the field to be visible
            WebElement relativeNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("relationship_person")));
        	Thread.sleep(5000);

            // Scroll into view if necessary
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", relativeNameField);

            // Click to activate the field before entering text
            relativeNameField.click();
            relativeNameField.sendKeys(relativeName);
            
            clickNext(); // Proceed to the next step

        } catch (Exception e) {
            System.out.println("Error entering relative name: " + e.getMessage());
        }
    }


    public void clickConfirm() {
        try {
            // Wait for button to be visible and clickable
            WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

            // Use JavaScript Executor to click in case of issues
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", confirmButton);
            
        } catch (Exception e) {
            System.out.println("Confirm button is not clickable: " + e.getMessage());
        }
    }
}
