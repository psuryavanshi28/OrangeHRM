package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LeavePage;
import pages.LoginPage;

public class LeaveTests extends BaseTest {

    @Test
    public void checkLeaveSection() {
        new LoginPage(driver).login("Admin", "admin123");
        LeavePage leave = new LeavePage(driver);
        leave.navigateToLeave();
        Assert.assertTrue(leave.isApplyLeaveVisible());
    }
}
