package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchHelper extends TestBase {
    @BeforeMethod
    public void postCondition()
    {
        app.getSearch().returnToHomePage();
        app.getSearch().clear();
    }
    @Test
    public void searchPeriodInPast() {
        app.getSearch().searchPeriodInPast("Tel Aviv", "2/01/2022", "04/20/2022");
        app.getSearch().submitWithoutWait();

        Assert.assertFalse(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getSearch().isPeriodInPast());
    }
    @Test
    public void searchCurreantMonth() {

        app.getSearch().searchCurreanMonth("Tel aviv", "07/17/22", "07/20/22");
        app.getSearch().submit();
       Assert.assertTrue(app.getSearch().islistOfCarsAppeared());
    }


    @Test
    public void searchAnyPeriod() {

        app.getSearch().searchAnyPeriod("Tel Aviv", "01/05/2023", "03/15/2023");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch(). islistOfCarsAppeared());
    }

}
