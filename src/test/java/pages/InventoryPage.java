package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {

  String webPageUrl="https://www.saucedemo.com/inventory.html";

  public InventoryPage() {
    PageFactory.initElements(driver,this);
  }

  public void verifyPageHasLoaded(){
    String currentPageUrl=driver.getCurrentUrl();
    Assert.assertEquals(currentPageUrl,webPageUrl);
  }

}
