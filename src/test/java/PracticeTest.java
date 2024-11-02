import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PracticeTest {
     private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMainCheckbox() throws InterruptedException {

        driver.get("https://demoqa.com/checkbox");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mainCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='rct-checkbox']")));
        mainCheckbox.click();
        Thread.sleep(1000);
        mainCheckbox.click();

        List<WebElement> childChekboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : childChekboxes){

            Assert.assertTrue(checkbox.isSelected());
        }
        driver.quit();

    }

}
