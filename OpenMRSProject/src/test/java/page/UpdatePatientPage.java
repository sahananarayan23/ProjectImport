package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void searchPatient(String patientNameOrId) {
        // Wait for the search box to be visible and enter patient name or ID
        wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search"))).sendKeys(patientNameOrId);
        
        // Click on the search result (assuming the first result should be clicked)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='name']/a"))).click();
    }

    public void clickEditPatient() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Edit"))).click();
    }

    public void enterNewAddress(String newAddress) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("address1"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("address1"))).sendKeys(newAddress);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save-button"))).click();
    }
}
