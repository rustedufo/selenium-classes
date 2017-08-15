import com.mtrading.selenium.DashboardPage;
import com.mtrading.selenium.LoginPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aleksandr.neguritsa on 8/10/2017.
 */
public class ForthTest extends AbstractTestCase{

    @Test
    public void loginTest() throws Exception {

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.open();

        loginPage.login("i1888146@mvrht.com","i1888146@mvrht.com");

        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), 30, 300);
        webDriverWait.until(ExpectedConditions.urlToBe(new DashboardPage(this.getDriver()).getUrl()));
    }
}
