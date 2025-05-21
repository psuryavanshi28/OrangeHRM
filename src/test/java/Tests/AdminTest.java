package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {
	LoginPage loginpage;
    AdminPage adminPage;
    DashboardPage dashboard;

    @BeforeMethod
    public void initPages() {
        loginpage = new LoginPage(driver);         // ✅ initialized after driver is set
        adminPage = new AdminPage(driver);
        dashboard = new DashboardPage(driver);
    }
	
    @Test(priority = 1)
    public void addUserTest() {
        loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.adduser ("Linda Anderson", "linda_test01", "Test@1234");
    }

    @Test(priority = 2)
    public void searchUserTest() {
        loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.searchuser("linda_test01");
    }

    @Test(priority = 3)
    public void deleteUserTest() {
        loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.deleteUser("linda_test01");
    }
    
    @Test(priority = 5)
    public void addJobTitleTest() {
        loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.addjobtitile("Senior QA Engineer", "Automation Expert", "this is pratice");
}
    @Test(priority = 7)
    public void addPayGradeTest() {
        loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.addPayGrade("Grade 5");
    }

    @Test(priority = 8)
    public void addEmploymentStatusTest() {
    	loginpage.login("Admin", "admin123");
        dashboard.navigateToAdmin();
        adminPage.addEmploymentStatus("Freelancer");
    }
    
    @Test(priority = 9)
    public void addLocationTest() {
    	loginpage.login("Admin", "admin123");
    	dashboard.navigateToAdmin();
        adminPage.addLocation("Pune Office", "India", "Pune", "411001");
    }

}