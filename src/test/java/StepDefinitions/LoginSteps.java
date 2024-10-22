package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.InventoryPage;
import pages.LoginPage;



public class LoginSteps {

  LoginPage loginPage=new LoginPage();
  InventoryPage inventoryPage=new InventoryPage();

  @Given("browser is open")
  public void browserIsOpen() {
    loginPage.openBrowser();
  }

  @Given("user is on login page")
  public void userIsOnLoginPage() {
    loginPage.verifyPageIsLoaded();
  }

  @When("^user enters (.*) and (.*)$")
  public void userEntersEmailAndPassword(String username, String password) {
   loginPage.enterUsernameAndPassword(username,password);
  }

  @And("clicks on login button")
  public void clicksOnLoginButton() {
    loginPage.login();
  }

  @Then("user is navigated to homepage")
  public void userIsNavigatedToHomepage() {
    inventoryPage.verifyPageHasLoaded();

  }


}
