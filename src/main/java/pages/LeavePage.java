package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {
    WebDriver driver;

    By leaveMenu = By.xpath("//span[text()='Leave']");
    By applyBtn = By.xpath("//a[text()='Apply']");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

	public boolean isApplyLeaveVisible() {
        return driver.findElement(applyBtn).isDisplayed();
    }

	public void navigateToLeave() {
		driver.findElement(leaveMenu).click();
		
	}
}