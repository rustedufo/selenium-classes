import com.mtrading.selenium.DashboardPage;
import com.mtrading.selenium.LoginPage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandr.neguritsa on 7/25/2017.
 */
public class ThirdTest {

    private WebDriver webDriver;

    private WebDriver getDriver() throws MalformedURLException {
        if (this.webDriver == null) {
            this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());

            this.webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            this.webDriver.manage().window().setSize(new Dimension(1550, 1100));
        }
        return this.webDriver;
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            if (ThirdTest.this.webDriver != null) {
                ThirdTest.this.webDriver.quit();
                ThirdTest.this.webDriver = null;
            }
        }
    };


    @Test
    public void thirdTest() throws Exception {


        this.getDriver().get("http://mtrading.com");
        this.getDriver().findElement(By.linkText("Login")).click();

        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        this.getDriver().switchTo().window(this.getDriver().getWindowHandles().toArray()[1].toString());

        webDriverWait.until(ExpectedConditions.urlToBe("https://accounts.mtrading.com/cas/login?language=en-US"));

//        this.getDriver().quit();
    }

    @Test
    public void secondTest() throws Exception {

        this.getDriver().get("https://accounts.mtrading.com/cas/login");

        this.getDriver().findElement(By.cssSelector("#username")).sendKeys("i1888146@mvrht.com");
        this.getDriver().findElement(By.cssSelector("#password")).sendKeys("i1888146@mvrht.com");
        this.getDriver().findElement(By.cssSelector("[name='submitButton']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.urlToBe("https://tr3.mtrading.com/dashboard"));
    }

    @Test
    public void secondTestNew() throws Exception {

        this.getDriver().get("https://accounts.mtrading.com/cas/login");

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.login("i1888146@mvrht.com","i1888146@mvrht.com");


        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.urlToBe("https://tr3.mtrading.com/dashboard"));
    }

    @Test
    public void secondTestNewNew() throws Exception {

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.open();

        loginPage.login("i1888146@mvrht.com","i1888146@mvrht.com");

        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.urlToBe("https://tr3.mtrading.com/dashboard"));
    }

    @Test
    public void secondTest00() throws Exception {

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.open();

        loginPage.login("i1888146@mvrht.com","i1888146@mvrht.com");

        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.urlToBe(new DashboardPage(this.getDriver()).getUrl()));
    }
}
