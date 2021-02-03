import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn {
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
    public void logIn() throws InterruptedException {
//This test will open a link,LogIn and verify the person is logged in
        driver.get("https://www.bio-rad.com/");
        driver.findElement(By.cssSelector("[id='portalloginlink']")).click();
        driver.findElement(By.cssSelector("[id='okta-signin-username']")).sendKeys("maksimdaiboff@gmail.com");
        driver.findElement(By.cssSelector("[id='okta-signin-password']")).sendKeys("Password123)");
        driver.findElement(By.cssSelector("[id='okta-signin-submit']")).click();
        Thread.sleep(10000);

        String loggedIn = driver.findElement(By.cssSelector("[id='portalloginlink']")).getText();
        Assert.assertTrue(loggedIn.contains("Log Out"));
        }
}
