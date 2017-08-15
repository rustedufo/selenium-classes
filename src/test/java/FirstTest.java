import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;

/**
 * Created by aleksandr.neguritsa on 7/25/2017.
 */
public class FirstTest {

    @Test
    public void firstTest() throws Exception {

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

        RemoteWebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                desiredCapabilities
        );
        driver.get("http://google.com");
        WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
        element.sendKeys("Zhopa");
        element.sendKeys(Keys.RETURN);

        Thread.sleep(2000);

        List<WebElement> elementList = driver.findElements(By.cssSelector("div.g cite"));
//        System.out.printf(elementList.get(0).getText());

        Assert.assertEquals(
                "The first link leads to unexpected domain",
                "www.urbandictionary.com/define.php?term=zhopa",
                elementList.get(0).getText()
        );

        //Thread.sleep(10000);

        driver.quit();
    }
}
