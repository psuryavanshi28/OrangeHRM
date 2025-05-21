package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage {
	WebDriver driver;
	
    public AdminPage (WebDriver driver) {
        this.driver = driver;
        
    }
    By adminTab = By.xpath("//span[text()='Admin']");
    By addbtn = By.xpath("//button[text()=' Add ']");
    By userrole = By.xpath("//span[contains(text(),'Admin')]");
    By employeeNameField = By.xpath("//input[contains(@placeholder,'Type for hints')]");
    By username= By.xpath("//label[text()='Username']/following::input[1]");
    By statusdropdown = By.xpath("//span[normalize-space()='Enabled']");
    By password = By.xpath("//label[text()='Password']/following::input[1]");
    By confirmpassword= By.xpath("//label[text()='Confirm Password']/following::input[1]");
    By saveBtn = By.xpath("//button[text()=' Save ']");
    By searchfield = By.xpath("//label[text()='Username']/following::input[1]");
    By searchbutton = By.xpath("//button[text()=' Search ']");
    
    
    public void adduser(String empName, String uname, String pass) {
    	driver.findElement(adminTab).click();
    	driver.findElement(addbtn).click();
    	driver.findElement(employeeNameField).sendKeys(empName);
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmpassword).sendKeys(pass);
        driver.findElement(saveBtn).click();
    }
    
    public void searchuser(String uname) {
    	driver.findElement(adminTab).click();
        driver.findElement(searchfield).sendKeys(uname);
        driver.findElement(searchbutton).click();
    }
    
    public void deleteUser(String username) {
        searchuser(username);
        driver.findElement(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']//i[@class='oxd-icon bi-trash']")).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
    }

	public void addjobtitile(String title,String description, String notes ) {
		driver.findElement(By.xpath("//span[text()='Job ']")).click();
		driver.findElement(By.xpath("//a[text() = 'Job Titles']")).click();
		driver.findElement(By.xpath("//button[text() =' Add ']")).click();
		driver.findElement(By.xpath("//label[text() ='Job Title']/following::input[1]")).sendKeys(title);
		driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(description);
		driver.findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys(notes);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public void addPayGrade(String gradeName) {
	    driver.findElement(By.xpath("//span[text()='Job ']")).click();
	    driver.findElement(By.xpath("//a[text()='Pay Grades']")).click();
	    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	    driver.findElement(By.xpath("//label[text() ='Name']/following::input[1]"));
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public void addEmploymentStatus(String status) {
	    driver.findElement(By.xpath("//span[text()='Job ']")).click();
	    driver.findElement(By.xpath("//a[text()='Employment Status']")).click();
	    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	    driver.findElement(By.xpath("//label[text()='Name']/following::input[1]")).sendKeys(status);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void addLocation(String name, String country, String city, String zip) {
	    driver.findElement(By.xpath("//span[text()='Organization ']")).click();
	    driver.findElement(By.xpath("//a[text()='Locations']")).click();
	    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	    driver.findElement(By.xpath("//label[text() ='Name']/following::input[1]")).sendKeys(name);
	    driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
	    driver.findElement(By.xpath("//span[text()='" + country + "']")).click();
	    driver.findElement(By.xpath("//label[text() ='City']/following::input[1]")).sendKeys(city);
	    driver.findElement(By.xpath("//label[text() ='Zip/Postal Code']/following::input[1]")).sendKeys(zip);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
