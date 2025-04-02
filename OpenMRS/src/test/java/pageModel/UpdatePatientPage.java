package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UpdatePatientPage {
    WebDriver driver;
    WebDriverWait wait;

    public UpdatePatientPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchPatient(String patientName) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search")));
        searchBox.sendKeys(patientName);
        
        WebElement patientResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + patientName + "')]")));
        patientResult.click();
    }

    public void clickEdit() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit-patient-details")));
        editButton.click();
    }

    public void updateAddress(String street, String city, String state, String country, String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("address1"))).clear();
        driver.findElement(By.name("address1")).sendKeys(street);

        wait.until(ExpectedConditions.elementToBeClickable(By.name("cityVillage"))).clear();
        driver.findElement(By.name("cityVillage")).sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable(By.name("stateProvince"))).clear();
        driver.findElement(By.name("stateProvince")).sendKeys(state);

        wait.until(ExpectedConditions.elementToBeClickable(By.name("country"))).clear();
        driver.findElement(By.name("country")).sendKeys(country);

        wait.until(ExpectedConditions.elementToBeClickable(By.name("postalCode"))).clear();
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
    }

    public void saveChanges() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-button")));
        saveButton.click();
    }
}
