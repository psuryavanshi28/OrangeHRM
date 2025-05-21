package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By username = By.name("username");
	By password = By.name("password");
	By login = By.xpath("//button[normalize-space()='Login']");
	By error = By.className("oxd-alert-content");
	

	public LoginPage(WebDriver driver) {
		this.driver =driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void login(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
		
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        
		return driver.findElement(error).getText();
		
	}
}
