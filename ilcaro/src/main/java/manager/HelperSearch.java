package manager;

import org.openqa.selenium.By;
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

    //    private void selectPeriod(String dFrom, String dTo) {
//        click(By.id("dates"));
//
//        click(By.xpath("//*[text()=' 13 ']"));
//        click(By.xpath("//*[text()=' 18 ']"));
//    }
    private void selectPeriod(String dFrom, String dTo) {
        click(By.xpath("//input[@formcontrolname='dates']"));
        //click(By.id("dates"));
        String[] from = dFrom.split("/");
        String[] to = dTo.split("/");
        click(By.xpath("//*[text()=' " + from[1] + " ']"));
        click(By.xpath("//*[text()=' " + to[1] + " ']"));
    }

    private void typeCity(String city) {

        type(By.id("city"), city);
        click(By.cssSelector(".pac-item"));

    }

//    public void searchCurreanMonthInPast(String city, String dFrom, String dTo)
//    {
//        typeCity(city);
//        typePeriodInPast(dFrom,dTo);
//    }

//    private void typePeriodInPast(String dFrom, String dTo)
//    {
//        String data=dFrom+" - "+dTo;
//   type(By.cssSelector(".input-label"),data);
//      wd.findElement().sendKeys();
//
//    }

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

    private void selectPeriodAnyData2(String dayS, String dayF) {
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dayS, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dayF, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        click(By.id("dates"));
        int diffYear;


        int diffMonth = from.getYear() - now.getYear()
                == 0 ? from.getMonthValue() - now.getMonthValue() :
                12 - now.getMonthValue() + from.getMonthValue();

        clickByNextMonth(diffMonth);

        String locator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(locator));
//*******************************************************************
        diffMonth = to.getYear() - from.getYear() == 0 ? to.getMonthValue() - from.getMonthValue() :
                12 - from.getMonthValue() + to.getMonthValue();

        clickByNextMonth(diffMonth);

        locator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(locator));
    }


    public void clear()
    {
        clearForm(By.id("city"));

        clearForm(By.xpath("//input[@formcontrolname='dates']"));

    }
}

