package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PipPage;

public class PIPTests extends BaseTest {
    LoginPage loginPage;
    PipPage pipPage;

    @Test(priority = 1)
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test(priority = 2)
    public void navigateToPIPTest() {
        pipPage = new PipPage(driver);
        pipPage.navigateToPIP();
    }

    @Test(priority = 3)
    public void verifyPIPHeaderTest() {
        Assert.assertEquals(pipPage.getHeaderText(), "Performance Improvement Plan");
    }

    @Test(priority = 4)
    public void filterByStatusTest() {
        pipPage.filterByStatus("Active");
    }

    @Test(priority = 5)
    public void filterByReviewerTest() {
        pipPage.filterByReviewer("Linda Anderson");
    }

    @Test(priority = 6)
    public void searchEmployeeTest() {
        pipPage.searchEmployee("Peter");
    }

    @Test(priority = 7)
    public void addPIPTest() {
        pipPage.addNewPIP();
    }

    @Test(priority = 8)
    public void verifyValidationOnSaveTest() {
        Assert.assertTrue(pipPage.isValidationShown());
    }

    @Test(priority = 9)
    public void editPIPEntryTest() {
        // Add logic to click on edit icon of first row (if present)
        // For now, just a placeholder
        System.out.println("Edit logic placeholder");
    }

    @Test(priority = 10)
    public void deletePIPEntryTest() {
        // Add logic to click delete icon and confirm (if applicable)
        System.out.println("Delete logic placeholder");
    }
}
