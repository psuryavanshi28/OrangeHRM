package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    By welcomeText = By.tagName("h6");
    By logoutDropdown = By.cssSelector(".oxd-userdropdown-name");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        return driver.findElement(welcomeText).getText();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public void navigateToAdmin() {
        By adminTab = By.xpath("//span[text()='Admin']");
		driver.findElement(adminTab).click();
    }
}