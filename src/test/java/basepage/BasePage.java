package basepage;

import infrastructure.SetUp;
import infrastructure.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {
  protected WebDriver driver;
  protected Wait wait;

  public BasePage() {
    this.driver = SetUp.driver;
    this.wait=new Wait(driver);
  }
}
