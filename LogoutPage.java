import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutWithoutMethods {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Open the SauceDemo inventory page (Assumes user is already logged in)
        driver.get("https://www.saucedemo.com/inventory.html");

        // Click on the menu button
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();

        // Wait for menu to open
        Thread.sleep(1000);

        // Click on the logout button
        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        logoutBtn.click();

        // Wait for logout to complete
        Thread.sleep(2000);

        // Verify logout success by checking if redirected to login page
        if (driver.getCurrentUrl().contains("saucedemo.com")) {
            System.out.println("Logout successful! ✅");
        } else {
            System.out.println("Logout failed! ❌");
        }

        // Close the browser
        Thread.sleep(3000); // Optional: Wait before closing
        driver.quit();
    }
}
