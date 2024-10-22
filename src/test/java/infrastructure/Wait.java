package infrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {
  private WebDriver driver;


  public Wait(WebDriver driver) {
    this.driver = driver;
  }


  private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.withMessage(timeoutMessage);
    wait.until(condition);
  }


  //page with loading state
  public void forLoading(Duration timeout){
    ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
    String timeoutMessage = "Page didn't load after " + timeout.toString() + " seconds.";
    waitUntilCondition(condition, timeoutMessage, timeout);
  }

  //explicit wait till item becomes visible
  public void forElementToBeDisplayed(Duration timeout, WebElement webElement, String webElementName){
    ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
    String timeoutMessage = webElementName + " wasn't displayed after " + timeout.toString() + " seconds.";
    waitUntilCondition(condition, timeoutMessage, timeout);
  }


  //explicit wait till items exist

  public void forPresenceOfElements(Duration timeout, By elementLocator, String elementName){
    ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
    String timeoutMessage = elementName + " elements were not displayed after " + timeout.toString() + " seconds.";
    waitUntilCondition(condition, timeoutMessage, timeout);
  }


  //wait and retry after a while till elements are seen ans maximum retries are not exceeded

  public void forElementDisplayedWithRetries(int maxRetries, WebElement webElement){
    boolean displayed=false;
    do {
      justSleep(1000);
      try{
        if (webElement.isDisplayed()) displayed=true;
      }
      catch (Exception ignore){}
      maxRetries--;
    } while ((!displayed) && (maxRetries>0));
  }


  //just add a fixed delay (Do not use this ofter)
  public void justSleep(int sleepMilliseconds){
    try {
      Thread.sleep(sleepMilliseconds);
    }
    catch (Exception e){
    }
  }

}
