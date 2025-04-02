package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPateintPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPateintPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterGivenName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("givenName"))).sendKeys(name);
    }

    public void enterFamilyName(String surname) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("familyName"))).sendKeys(surname);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();
    }

    public void selectGender(String gender) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + gender + "']"))).click();
        clickNext();
    }

    public void enterBirthdate(String day, String month, String year) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateDay"))).sendKeys(day);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateMonth"))).sendKeys(month);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthdateYear"))).sendKeys(year);
        clickNext();
    }

    public void enterAddress(String street, String city, String state, String country, String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("address1"))).sendKeys(street);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("cityVillage"))).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("stateProvince"))).sendKeys(state);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("country"))).sendKeys(country);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("postalCode"))).sendKeys(postalCode);
        clickNext();
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("phoneNumber"))).sendKeys(phone);
        clickNext();
    }

    public void selectRelationship(String relationship) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("relationship_type"))).sendKeys(relationship);
    }

    public void enterRelativeName(String relativeName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Person Name']"))).sendKeys(relativeName);
        clickNext();
    }

    public void clickConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
    }
}
