package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

  @FindBy(id ="user-name" )
  private WebElement web_username;
  @FindBy(id ="password" )
  private WebElement web_password;

  @FindBy(id="login-button")
  private WebElement btn_login;


  public LoginPage(){
    PageFactory.initElements(driver,this);
  }

  public void openBrowser(){
    System.getProperty("webDriver.chrome.driver","src/test/resources/drivers/chromedriver");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
  }

  public void verifyPageIsLoaded() {
    String pageUrl = "https://www.saucedemo.com/";
    driver.navigate().to(pageUrl);
    String driverPageUrl=driver.getCurrentUrl();
    Assert.assertEquals(driverPageUrl, pageUrl);
  }

  public void enterUsernameAndPassword(String username, String password) {
    web_username.sendKeys(username);
    web_password.sendKeys(password);
  }

  public void login() {
    btn_login.click();
  }
}
