import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartWithoutFunctions {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Open the SauceDemo inventory page
        driver.get("https://www.saucedemo.com/inventory.html");

        // Define the target product name
        String targetProductName = "Sauce Labs Backpack"; // Change as per your requirement

        // Get the list of all product name elements
        List<WebElement> productNameElements = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

        // Loop through the product list to find the target product
        for (WebElement productNameElement : productNameElements) {
            String productName = productNameElement.getText();

            if (productName.equals(targetProductName)) {
                // Find the corresponding "Add to cart" button
                List<WebElement> addButton = productNameElement.findElements(By.xpath("./parent::a/parent::div/following-sibling::div/button"));

                if (!addButton.isEmpty()) {
                    addButton.get(0).click();
                    System.out.println(targetProductName + " added to cart successfully!");
                    break; // Exit loop once the product is added
                }
            }
        }

        // Close the browser after execution
        Thread.sleep(3000); // Optional: Wait before closing
        driver.quit();
    }
}
