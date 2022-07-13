package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchHelper extends TestBase{


    @Test
    public void searchCurreantMonth()
    {

        app.getSearch().searchCurreanMonth("Tel aviv","07/15/22","07/20/22");
        app.getSearch().submit();
     Assert.assertTrue(app.getSearch().islistOfCarsAppeared());



    }

//    @Test
//    public void searchCurreantMonthInPast()
//    {
//        app.getSearch().searchCurreanMonthInPast("Tel aviv","01/10/22","07/20/22");
//        app.getSearch().submit();
//        // Assert.assertTrue(app.getSearch().islistOfCarsAppeared());
//
//
//    }

    @Test
    public void searchAnyPeriod(){
        app.getSearch().clear();
        app.getSearch().searchAnyPeriod("Tel Aviv","01/05/2023","03/15/2023");
        app.getSearch().submit();
       // Assert.assertTrue(app.getSearch().isListOfCarsAppeared());

    }

}
