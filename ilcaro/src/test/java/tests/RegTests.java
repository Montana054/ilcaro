package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegTests extends TestBase
{
    @BeforeMethod
    public void precondition()

    {
        if(app.getHelperUser().isLogOutPresent())
        {
            app.getHelperUser().logOut();
        }
    }
    @Test
    void registrationSuccess()
    {
        int index=(int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openRegForm();
        app.getHelperUser().fillRegGorm("Mia","Sena","ii"+index+"@yahoo.com","Liza1234$");
       // app.getHelperUser().checkPolicy();
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submitYallaButton();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());//можно так
        Assert.assertEquals(app.getHelperUser().chekMessage(),"Logout");// а можно так

    }
    @AfterMethod
    public void postCondition()
    {
        app.getHelperUser().btnOk();
    }
}
