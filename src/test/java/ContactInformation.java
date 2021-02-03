import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class ContactInformation {

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
        //This test will verify the all checkboxes are selected
        driver.get("https://careers.bio-rad.com/homepage");
        driver.findElement(By.cssSelector("[id='consent_agree']")).click();
        driver.findElement(By.cssSelector("[id='search_control_query_2_0']")).sendKeys("QA engineer");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[id='search_control_button_2_0']")).click();
        Thread.sleep(5000);

        List<WebElement> chkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i <= chkBox.size(); i++) {

            chkBox.get(i).click();
        }
    }

}