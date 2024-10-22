package infrastructure;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SetUp {

  public static WebDriver driver=new ChromeDriver();


  @BeforeAll
  public static void setUp() {
    System.out.println("I am inside browser open");
    System.getProperty("webDriver.chrome.driver","src/test/resources/drivers/chromedriver");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

  }

  @AfterAll
  public static void tearDown()
  {
    System.out.println("cleaning up");
    driver.close();
    driver.quit();
  }

  @After
  public void tearDownScenario(Scenario scenario) {
    if (scenario.isFailed()) {
      captureScreenshot(scenario);
    }
  }

  private void captureScreenshot(Scenario scenario) {
    // Capture screenshot and store as a file format
    TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
    File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);

    // Format for screenshot file name
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String screenshotName = "screenshot_" + scenario.getName() + "_" + timestamp + ".png";
    String screenshotPath = "target/screenshots/" + screenshotName;

    // Create the directory if it doesn't exist
    try {
      Files.createDirectories(Paths.get("target/screenshots"));
      Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
      System.out.println("Screenshot captured: " + screenshotPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
