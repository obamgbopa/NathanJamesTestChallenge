package StepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver ;

    @Before
    public void beforeScenario()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }



    @Given("^I am on the Supply Brain ERP system page on URL \"([^\"]*)\"$")
    public void iAmOnTheSupplyBrainERPSystemPageOnURL(String url)  {
        driver.get(url);
    }


    @When("^I fill in Email field with \"([^\"]*)\"$")
    public void iFillInEmailFieldWith(String email)  {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("^I fill in Password field with \"([^\"]*)\"$")
    public void iFillInPasswordFieldWith(String password)  {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^I click on the Log In button$")
    public void iClickOnTheLogInButton() {
       driver.findElement(By.cssSelector("#app > main > div > div > div > div > div.card-body > form > div.form-group.row.mb-0 > div > button")).click();

    }

    @Then("^I am on the Dashboard page on URL \"([^\"]*)\"$")
    public void iAmOnTheDashboardPageOnURL(String durl) {
        String CURL = driver.getCurrentUrl();
        Assert.assertEquals(CURL, durl);

    }
    @And("^I should see \"([^\"]*)\" message$")
    public void iShouldSeeMessage(String dmessage)  {
        Assert.assertEquals(driver.findElement(By.className("card-body")).getText(),dmessage);

    }

    @Then("^I should see Login text/banner$")
    public void iShouldSeeLoginTextBanner() {
        Assert.assertEquals(driver.findElement(By.className("card-header")).getText(),"Login");
    }


    @When("^I fill in Email with \"([^\"]*)\"$")
    public void iFillInEmailWith(String emails) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(emails);
    }

    @And("^I fill in Password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String passwords) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(passwords);
    }

    @And("^I click on the Login button$")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.cssSelector("#app > main > div > div > div > div > div.card-body > form > div.form-group.row.mb-0 > div > button")).click();
    }

    @And("^I should see an error \"([^\"]*)\" message$")
    public void iShouldSeeAnErrorMessage(String warning) throws Throwable {

        Assert.assertEquals(driver.findElement(By.className("invalid-feedback")).getText(),warning);
    }
}
