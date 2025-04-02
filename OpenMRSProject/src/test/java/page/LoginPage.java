package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.id("Inpatient Ward")).click();
    }

    public void clickLogin() {
        driver.findElement(By.id("loginButton")).click();
    }
}
