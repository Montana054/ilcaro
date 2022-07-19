package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);

        }
    }

    public void submitWithoutWait() {

        click(By.cssSelector("[type='submit']"));

    }

    public void clearForm(By locator) {
        WebElement element = wd.findElement(locator);
        element.clear();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void implicitlyWait() {
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void submit() {

        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("[type='submit']"))));
        click(By.cssSelector("[type='submit']"));
    }

    public void submitWithotWait() {
        click(By.cssSelector("[type='submit']"));
    }


    public void takeScreenshot(String pathToFile)
    {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);
        try{
            Files.copy(tmp,screenshot);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

