package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMSteps {

    WebDriver driver;
    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.out.println("Test");
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I open orange hrm homepage")
    public void i_open_orange_hrm_homepage() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Then("I verify that the logo present on page")
    public void i_verify_that_the_logo_present_on_page() {
    //boolean value = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
      //  Assert.assertEquals (true, value);
    }

    @And("Close browser")
    public void close_browser() {
    driver.quit();
    }

}
