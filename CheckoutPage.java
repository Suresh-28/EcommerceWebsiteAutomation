import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutWithoutMethods {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Open the SauceDemo website and navigate to the cart page
        driver.get("https://www.saucedemo.com/cart.html");

        // Click on the cart icon to navigate to the cart page
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        
        // Wait for the page to load
        Thread.sleep(1000);

        // Click on the checkout button
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        // Enter checkout details
        WebElement firstName_TxtBox = driver.findElement(By.id("first-name"));
        firstName_TxtBox.sendKeys("John");

        WebElement lastName_TxtBox = driver.findElement(By.id("last-name"));
        lastName_TxtBox.sendKeys("Doe");

        WebElement zipCode_TxtBox = driver.findElement(By.id("postal-code"));
        zipCode_TxtBox.sendKeys("12345");

        // Wait and click the continue button
        Thread.sleep(1000);
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();

        // Wait and click the finish button
        Thread.sleep(1000);
        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();

        // Wait and verify the order confirmation message
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        String textMsg = message.getText();

        // Print success message based on confirmation
        if (textMsg.equals("Thank you for your order!")) {
            System.out.println("Checkout completed successfully! ✅");
        } else {
            System.out.println("Checkout failed! ❌");
        }

        // Close the browser after execution
        Thread.sleep(3000); // Optional: Wait before closing
        driver.quit();
    }
}
