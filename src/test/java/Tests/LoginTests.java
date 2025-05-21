package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
	
	@Test
	public void loginwithvalid() {
		LoginPage login = new LoginPage(driver);
		login.login("Admin", "admin123");
		DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertEquals(dashboard.getHeading(), "Dashboard");
	}
	@Test (priority=2)
	public void invalidlogin() {
	
		LoginPage login = new LoginPage(driver);
        login.login("Admin", "wrongpass");
        Assert.assertTrue(login.getErrorMessage().contains("Invalid credentials"));

}
	@Test (priority=3)
	public void logoutTest() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}

