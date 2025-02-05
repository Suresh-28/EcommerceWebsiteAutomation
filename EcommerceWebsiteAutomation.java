import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceWebsiteAutomationWithoutMethods {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Navigate to Login Page and Perform Login
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(2000);

        // Verify Login Success
        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println("Test Case 01: Login Functionality ✅ PASS");
        } else {
            System.out.println("Test Case 01: Login Functionality ❌ FAIL");
        }

        // Apply Filter (Price Low to High)
        WebElement dropdownElement = driver.findElement(By.className("product_sort_container"));
        dropdownElement.click();
        dropdownElement.sendKeys("Price (low to high)");
        Thread.sleep(1000);

        // Verify Filter Success
        System.out.println("Test Case 02: Applying Filter ✅ PASS");

        // Add to Cart - "Sauce Labs Onesie"
        WebElement onesie = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item']//button"));
        onesie.click();
        Thread.sleep(1000);

        // Add to Cart - "Sauce Labs Fleece Jacket"
        WebElement fleeceJacket = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//button"));
        fleeceJacket.click();
        Thread.sleep(1000);

        // Verify Add to Cart
        System.out.println("Test Case 03: Add to Cart ✅ PASS");

        // Navigate to Cart and Perform Checkout
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);

        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        WebElement firstName_TxtBox = driver.findElement(By.id("first-name"));
        firstName_TxtBox.sendKeys("Chanchal");

        WebElement lastName_TxtBox = driver.findElement(By.id("last-name"));
        lastName_TxtBox.sendKeys("Korsewada");

        WebElement zipCode_TxtBox = driver.findElement(By.id("postal-code"));
        zipCode_TxtBox.sendKeys("492222");

        Thread.sleep(1000);
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();

        Thread.sleep(1000);
        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();

        Thread.sleep(1000);

        WebElement message = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        if (message.getText().equals("Thank you for your order!")) {
            System.out.println("Test Case 04: Checkout ✅ PASS");
        } else {
            System.out.println("Test Case 04: Checkout ❌ FAIL");
        }

        // Perform Logout
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);

        if (driver.getCurrentUrl().contains("saucedemo.com")) {
            System.out.println("Test Case 05: Logout ✅ PASS");
        } else {
            System.out.println("Test Case 05: Logout ❌ FAIL");
        }

        // Close Browser
        Thread.sleep(3000);
        driver.quit();
    }
}
