package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurreanMonth(String city, String dFrom, String dTo) {
        typeCity(city);
        selectPeriod(dFrom, dTo);

    }


    private void selectPeriod(String dFrom, String dTo) {

     click(By.id("dates"));
        String[] from = dFrom.split("/");
        String[] to = dTo.split("/");
        click(By.xpath("//*[text()=' " + from[1] + " ']"));
        click(By.xpath("//*[text()=' " + to[1] + " ']"));
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
      click(By.cssSelector(".pac-item"));

    }

    public boolean islistOfCarsAppeared() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".search-results"))));
        return wd.findElement(By.cssSelector(".search-results")).isDisplayed();


    }

    public void searchAnyPeriod(String city, String dayS, String dayF) {

        typeCity(city);
        selectPeriodAnyData(dayS, dayF);

    }

    private void selectPeriodAnyData(String dayS, String dayF) {
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dayS, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dayF, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        click(By.id("dates"));
        int diffYear;
        int diffMonth;

        diffYear = from.getYear() - now.getYear();
        if (diffYear == 0) {
            diffMonth = from.getMonthValue() - now.getMonthValue();
        } else {
            diffMonth = 12 - now.getMonthValue() + from.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(locator));
//**************************************
        diffYear = to.getYear() - from.getYear();
        if (diffYear == 0) {
            diffMonth = to.getMonthValue() - from.getMonthValue();
        } else {
            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
        }
        clickByNextMonth(diffMonth);

        locator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(locator));
    }


    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }

    }

//    private void selectPeriodAnyData2(String dayS, String dayF) {
//        LocalDate now = LocalDate.now();
//        LocalDate from = LocalDate.parse(dayS, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate to = LocalDate.parse(dayF, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//
//        click(By.id("dates"));
//        int diffYear;
//
//
//        int diffMonth = from.getYear() - now.getYear()
//                == 0 ? from.getMonthValue() - now.getMonthValue() :
//                12 - now.getMonthValue() + from.getMonthValue();
//
//        clickByNextMonth(diffMonth);
//
//        String locator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
//        click(By.xpath(locator));
////*******************************************************************
//        diffMonth = to.getYear() - from.getYear() == 0 ? to.getMonthValue() - from.getMonthValue() :
//                12 - from.getMonthValue() + to.getMonthValue();
//
//        clickByNextMonth(diffMonth);
//
//        locator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
//        click(By.xpath(locator));
//    }
//

    public void clear()
    {
        clearForm(By.id("city"));
        clearForm(By.id("dates"));

    }


    public void returnToHomePage()
    {
        click(By.cssSelector(".header a[href='/']"));
    }

    public void searchPeriodInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);

        typePeriodInPast(dataFrom,dataTo);
    }

    private void typePeriodInPast(String dataFrom, String dataTo) {
        WebElement el = wd.findElement(By.id("dates"));

// os?
        String  osname = System.getProperty("os.name");
        if (osname.startsWith("Mac")) {
            System.out.println(osname);

            el.sendKeys(Keys.COMMAND,"a");
        }else {
            el.sendKeys(Keys.CONTROL,"a");
        }
        el.sendKeys(Keys.DELETE);
       pause(2000);



        type(By.id("dates"),dataFrom + " - "+dataTo);
        click(By.cssSelector(".cdk-overlay-container"));

        //takeScreenShot("src/test/screenshots/screen.png");

    }


    public boolean isPeriodInPast() {
        pause(1000);
        WebElement el = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String error = el.getText();
        System.out.println(error);
        return error.equals("You can't pick date before today");
    }
}

