package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TimePanel extends BaseTest{

    WebDriver driver;
    LoginPage loginPage;
    TimePanel timePanel;

    @BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage = new LoginPage(driver);
        timePanel = new TimePanel();

        loginPage.login("Admin", "admin123");
    }

    @Test(priority = 1)
    public void hoverAndClickAttendance() {
        timePanel.hoverAndClickAttendance();
    }

    @Test(priority = 2)
    public void rightClickTimesheets() {
        timePanel.rightClickTimesheets();
    }

    @Test(priority = 3)
    public void doubleClickFirstTimesheetRow() {
        timePanel.doubleClickFirstTimesheetRow();
    }

	@Test(priority = 4)
    public void tabThroughFilters() {
        timePanel.tabThroughFilters();
    }

    
	@Test(priority = 5)
    public void ctrlACommentBox() {
        timePanel.ctrlACommentBox();
    }


	@Test(priority = 6)
    public void pageDownTimesheets() {
        timePanel.pageDownTimesheets();
    }

   

	@Test(priority = 7)
    public void dragAndDropCalendarEvent() {
        timePanel.dragAndDropCalendarEvent();
    }

    @Test(priority = 8)
    public void enterSubmitTime() {
        timePanel.enterSubmitTime();
    }

   
	@Test(priority = 9)
    public void clickAndHoldTimesheetRow() throws InterruptedException {
        timePanel.clickAndHoldTimesheetRow();
    }

    @Test(priority = 10)
    public void ctrlFBrowserFind() {
        timePanel.ctrlFBrowserFind();
    }

    

	@AfterClass
    public void teardown() {
        driver.quit();
    }
}
