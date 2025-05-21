package Tests;

import org.testng.annotations.Test;

import pages.EmployeePage;
import pages.LoginPage;

public class EmployeeTests extends BaseTest {

    @Test
    public void addEmployeeTest() {
        new LoginPage(driver).login("Admin", "admin123");
        new EmployeePage(driver).addEmployee("John", "Doe");
        // Add validation as needed
    }
}
