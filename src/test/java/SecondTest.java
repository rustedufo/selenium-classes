import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandr.neguritsa on 7/25/2017.
 */
public class SecondTest {

    @Test
    public void secondTest() throws Exception {

        RemoteWebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome()
        );

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1550, 1100));


        driver.get("http://mtrading.com");
        driver.findElement(By.linkText("Login")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30, 300);
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Switch to other TAB
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        Thread.sleep(5000);

        Assert.assertEquals(
                "Url does not match expected",
                "https://accounts.mtrading.com/cas/login?language=en-US",
                driver.getCurrentUrl()
        );

        driver.quit();
    }
}
