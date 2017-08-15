import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandr.neguritsa on 8/10/2017.
 */
public class AbstractTestCase {

    private WebDriver webDriver;

    protected WebDriver getDriver() throws MalformedURLException {
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
            if (AbstractTestCase.this.webDriver != null) {
                AbstractTestCase.this.webDriver.quit();
                AbstractTestCase.this.webDriver = null;
            }
        }
    };



}
