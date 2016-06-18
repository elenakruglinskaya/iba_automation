import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CalendarPopup {
    WebDriver driver;
    String CurrentDate;
    String CurrentMonth;

  @BeforeMethod
   public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mtbank.by/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

   @AfterMethod
   public void closeBroswer() {
       driver.close();
   }
@Ignore
    @Test
    public void checkCalendarDate () throws InterruptedException {
        CurrentDate = "18.06.2016";
        WebElement element = driver.findElement(By.id("datapicker"));
        Assert.assertTrue(element.getAttribute("value").equals(CurrentDate));
        Thread.sleep(2000);
    }
   @Ignore
    @Test
    public void checkCalendarIconDispaying() {
        WebElement Element1 = driver.findElement(By.id("datapickericon"));
        Assert.assertTrue(Element1.isDisplayed());
    }
    @Ignore
    @Test
    public void checkMonthInCalendarPicker() {
        CurrentMonth = "Июнь";
        WebElement element = driver.findElement(By.id("datapickericon"));
        element.click();
        WebElement element2 = driver.findElement(By.className("ui-datepicker-month"));
        Assert.assertTrue(element2.getText().contains(CurrentMonth));
    }

    @Test
    public void checkCurrentDateHighlighting() {
        WebElement element = driver.findElement(By.id("datapickericon"));
        element.click();
        WebElement CurrentDate = driver.findElement(By.xpath("//tr/td/a[text()='18']"));
        Assert.assertTrue(CurrentDate.getCssValue("background-color").compareToIgnoreCase("rgba(251, 236, 136, 1)")==0);
    }
}
