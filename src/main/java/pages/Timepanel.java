package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Timepanel {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	By timeModuleMenu = By.id("menu_time_viewTimeModule");
    By attendanceMenu = By.id("menu_attendance_Attendance");
    By timesheetsMenu = By.id("menu_time_Timesheets");
    By timesheetTableFirstRow = By.cssSelector("#timeTimesheet tbody tr:first-child");
    By commentBox = By.id("txtComment");
    By timeInput = By.id("time_input"); // Example - may not exist, replace if needed
    By calendarEvent = By.id("calendar_event_1"); // Example - replace as needed
    By calendarDay2 = By.id("calendar_day_2"); // Example - replace as needed
    
    
    public void hoverAndClickAttendance() {
        WebElement timeMenu = driver.findElement(timeModuleMenu);
        actions.moveToElement(timeMenu).perform();

        WebElement attendance = wait.until(ExpectedConditions.visibilityOfElementLocated(attendanceMenu));
        actions.moveToElement(attendance).click().perform();
    }

    public void rightClickTimesheets() {
        WebElement timesheets = driver.findElement(timesheetsMenu);
        actions.contextClick(timesheets).perform();
    }

    public void doubleClickFirstTimesheetRow() {
        driver.findElement(timesheetsMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(timesheetTableFirstRow));
        WebElement firstRow = driver.findElement(timesheetTableFirstRow);
        actions.doubleClick(firstRow).perform();
    }

    public void tabThroughFilters() {
        driver.findElement(timeModuleMenu).click();
        WebElement firstFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("time_date_range")));
        firstFilter.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
    }

    public void ctrlACommentBox() {
        driver.findElement(timeModuleMenu).click();
        WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox));
        comment.click();
        comment.sendKeys("This is a test comment");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    }

    public void pageDownTimesheets() {
        driver.findElement(timesheetsMenu).click();
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeTimesheet")));
        table.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void dragAndDropCalendarEvent() {
        driver.findElement(timeModuleMenu).click();
        WebElement event = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarEvent));
        WebElement target = driver.findElement(calendarDay2);
        actions.dragAndDrop(event, target).perform();
    }

    public void enterSubmitTime() {
        driver.findElement(timeModuleMenu).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(timeInput));
        input.click();
        input.sendKeys("8");
        input.sendKeys(Keys.ENTER);
    }

    public void clickAndHoldTimesheetRow() throws InterruptedException {
        driver.findElement(timesheetsMenu).click();
        WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(timesheetTableFirstRow));
        actions.clickAndHold(firstRow).perform();
        Thread.sleep(2000);
        actions.release().perform();
    }

    public void ctrlFBrowserFind() {
        driver.findElement(timeModuleMenu).click();
        actions.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).perform();
    }
}
