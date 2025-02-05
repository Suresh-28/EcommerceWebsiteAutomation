import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithoutMethods {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Open the SauceDemo login page
        driver.get("https://www.saucedemo.com/");

        // Enter username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");  // Replace with actual username

        // Enter password
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");  // Replace with actual password

        // Click on login button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        // Wait for login action to complete
        Thread.sleep(2000);

        // Verify if login is successful by checking the page URL or element presence
        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println("Login successful! ✅");
        } else {
            System.out.println("Login failed! ❌");
        }

        // Close the browser
        Thread.sleep(3000); // Optional: Wait before closing
        driver.quit();
    }
}
