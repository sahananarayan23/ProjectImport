package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void selectLocation() {
    	WebElement locationOption = driver.findElement(By.xpath("//*[@id='Inpatient Ward']"));
        locationOption.click();    }

    public void clickLogin() {
        driver.findElement(By.id("loginButton")).click();
    }

    public String getErrorMessage() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id='error-message']"));
        return errorMsg.getText();
    }
}
