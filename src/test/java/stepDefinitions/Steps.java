package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Steps {
    public WebDriver driver;
    public LoginPage lp;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String string) {
        driver.get(string);
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @And("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            //Assert.assertTrue(false);
            Assert.fail();
        }
        else
        {
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);

    }

    @And("Close the browser")
    public void close_the_browser() {
    driver.quit();
    }
}
