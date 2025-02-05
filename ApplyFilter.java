import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplyFilterWithoutMethods {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver (Ensure the correct path for chromedriver)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // Open the SauceDemo inventory page
        driver.get("https://www.saucedemo.com/inventory.html");

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@class='product_sort_container']"));

        // Create a Select object and choose "Price (low to high)"
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Price (low to high)");

        // Wait for sorting to take effect
        Thread.sleep(1000);

        // Fetch the product prices after sorting
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        boolean isSorted = true;

        // Check if prices are sorted in ascending order
        for (int i = 1; i < productPrice.size(); i++) {
            String price1 = productPrice.get(i - 1).getText().replace("$", "").trim();
            String price2 = productPrice.get(i).getText().replace("$", "").trim();

            double numericPrice1 = Double.parseDouble(price1);
            double numericPrice2 = Double.parseDouble(price2);

            if (numericPrice1 > numericPrice2) {
                isSorted = false;
                break; // Exit the loop if sorting is incorrect
            }
        }

        // Print sorting result
        if (isSorted) {
            System.out.println("Products are sorted in ascending order (low to high). ✅");
        } else {
            System.out.println("Sorting failed! Prices are not in the correct order. ❌");
        }

        // Close the browser after execution
        Thread.sleep(3000); // Optional: Wait before closing
        driver.quit();
    }
}
