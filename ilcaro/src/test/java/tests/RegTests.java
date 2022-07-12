package tests;

import models.Users;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogOutPresent()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    void registrationSuccessModel() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Users user = new Users().withName("Mia").withLasteName("Sena").withEmail("ii" + index + "@yahoo.com").withPassword("Liza1234$");

        app.getHelperUser().openRegForm();
        app.getHelperUser().fillRegForm(user);

        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());//можно так
        Assert.assertEquals(app.getHelperUser().chekMessage(), "Logout");// а можно так

    }

    @Test
    void regWrongPassModel() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Users user = new Users().withName("Ria").withLasteName("Aena").withEmail("iei" + index + "@yahoo.com").withPassword("L1234");

        app.getHelperUser().openRegForm();
        app.getHelperUser().fillRegForm(user);
        app.getHelperUser().checkPolicyXY();
       // app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordDisplayedFormat());
        Assert.assertFalse(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotClicabal());
    }

    //    @Test
//    void registrationSuccess()
//    {
//        int index=(int)(System.currentTimeMillis()/1000)%3600;
//        app.getHelperUser().openRegForm();
//        app.getHelperUser().fillRegGorm("Mia","Sena","ii"+index+"@yahoo.com","Liza1234$");
//       // app.getHelperUser().checkPolicy();
//        app.getHelperUser().checkPolicyXY();
//        app.getHelperUser().submitYallaButton();
//        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());//можно так
//        Assert.assertEquals(app.getHelperUser().chekMessage(),"Logout");// а можно так
//
//    }
    @AfterMethod
    public void postCondition() {
        app.getHelperUser().submitOkButton();
    }
}
