package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
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
    public void loginSuccess()
    {
       app.getHelperUser().openLoginForm();
       app.getHelperUser().implicitlyWait();
       app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
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
