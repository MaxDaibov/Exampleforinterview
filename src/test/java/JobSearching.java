import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class JobSearching {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void testdown() {
        driver.quit();
    }

    @Test
    public void contactInformation() throws InterruptedException {
        //This test will verify how many results were found
        driver.get("https://careers.bio-rad.com/homepage");
        driver.findElement(By.cssSelector("[id='consent_agree']")).click();
        driver.findElement(By.cssSelector("[id='search_control_query_2_0']")).sendKeys("QA Engineer");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[id='search_control_button_2_0']")).click();
        Thread.sleep(5000);

        List<WebElement> optionCount = driver.findElements(By.xpath("//*[contains(@class,'job-search-results-title')]"));
        System.out.println(optionCount.size());
    }

}