package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;
import utils.Waiter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TechGlobalSteps{

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;
    Actions actions;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
        actions = new Actions(driver);
    }

    @Given("user is on {string}")
    public void userIsOnHttpsTechglobalTrainingNetlifyApp(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @When("user moves to “Practices” header dropdown")
    public void user_moves_to_Practices_header_dropdown() {
        actions.moveToElement(techGlobalFrontendTestingHomePage.headerDropdown).perform();
    }

    @When("user clicks on “Frontend Testing” header dropdown option")
    public void user_clicks_on_Frontend_Testing_header_dropdown_option() {
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to_https_techglobal_training_netlify_app_frontend(String url) {
       Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("user clicks on “Pagination” card")
    public void user_clicks_on_Pagination_card() {
        techGlobalFrontendTestingHomePage.clickOnCard("Pagination");
    }

    @And("user should see {string} heading")
    public void user_should_see_World_City_Populations_heading(String heading){
        switch(heading){
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPaginationPage.heading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPaginationPage.subHeading.getText());
                break;
            default: throw new NotFoundException("heading text not found");
        }
    }

    @And("user should see {string} paragraph")
    public void user_should_see_paragraph(String paragraph) {
        Assert.assertEquals(paragraph, techGlobalPaginationPage.paragraph.getText());
    }
    @Then("user should see {string} button is disabled")
    public void user_should_see_button_disabled(String button) {
        switch (button){
            case "Next":
                Assert.assertFalse(techGlobalPaginationPage.next.isEnabled());
                break;
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previous.isEnabled());
                break;
            default: throw new NotFoundException("element not found");
        }
    }

    @Then("user should see {string} button is enabled")
    public void user_should_see_button_is_enabled(String button) {
        switch (button){
            case "Next":
                assertTrue(techGlobalPaginationPage.next.isEnabled());
                break;
            case "Previous":
                assertTrue(techGlobalPaginationPage.previous.isEnabled());
                break;
            default: throw new NotFoundException("element not found");
        }
    }

    @When("user clicks on “Next” button")
    public void user_clicks_on_Next_button() {
       techGlobalPaginationPage.next.click();
    }


    @When("user clicks on “Next” button till it becomes disabled")
    public void user_clicks_on_Next_button_till_it_becomes_disabled() {
        while(techGlobalPaginationPage.next.isEnabled()){
            techGlobalPaginationPage.next.click();
        }
        assertFalse(techGlobalPaginationPage.next.isEnabled());
    }


    @And("user should see {string} city with correct {string} and {string} image")
    public void userShouldSeeCityWithCorrectAndImage(String city, String country, String population) {
    }
}
