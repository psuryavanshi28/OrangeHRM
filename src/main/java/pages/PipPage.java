package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PipPage {
WebDriver driver;
	
    public PipPage (WebDriver driver) {
        this.driver = driver;
        
    }
    By performanceMenu = By.xpath("//span[text()='Performance']/following::input[1]");
    By pipMenu = By.xpath("//a[contains(@href,'performanceManagePip')]");

    By header = By.xpath("//h6[text()='Performance Improvement Plan']");
    By statusDropdown = By.xpath("//label[text()='Status']/following::div[1]");
    By reviewerDropdown = By.xpath("//label[text()='Reviewer']/following::div[1]");
    By searchInput = By.xpath("//input[@placeholder='Type for hints...']");
    By addBtn = By.xpath("//button[normalize-space()='Add']");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");
    By nameRequired = By.xpath("//span[contains(text(),'Required')]");

    public void navigateToPIP() {
        driver.findElement(performanceMenu).click();
        driver.findElement(pipMenu).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void filterByStatus(String status) {
        driver.findElement(statusDropdown).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void filterByReviewer(String reviewer) {
        driver.findElement(reviewerDropdown).click();
        driver.findElement(By.xpath("//span[text()='" + reviewer + "']")).click();
    }

    public void searchEmployee(String name) {
        driver.findElement(searchInput).sendKeys(name);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void addNewPIP() {
        driver.findElement(addBtn).click();
        // Assuming at least one required field is not filled
        driver.findElement(saveBtn).click();
    }

    public boolean isValidationShown() {
        return driver.findElement(nameRequired).isDisplayed();
    }
}

