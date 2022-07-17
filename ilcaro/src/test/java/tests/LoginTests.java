package tests;

import models.Users;
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
    logger.info("Test needs logout");
}
   }


    @Test
    public void loginSuccessModel()
    {
        logger.info("the test starts with data [noa@gmail.com] & [Nnoa12345$]");
        Users user =new Users().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
//флюинстайл - выятгивание метода по цепочки в строчку

        app.getHelperUser().openLoginForm();
       app.getHelperUser().implicitlyWait();
       app.getHelperUser().fillLoginForm(user);
       app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());//можно так
        Assert.assertEquals(app.getHelperUser().chekMessage(),"Logout");// а можно так


    }

//    @Test
//    public void loginSuccess()  // просто изменили метод сделали ерез моделз
//    {
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().implicitlyWait();
//        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
//        app.getHelperUser().submitYallaButton();
//
//        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());//можно так
//        Assert.assertEquals(app.getHelperUser().chekMessage(),"Logout");// а можно так
//
//
//    }
    @AfterMethod
    public void postCondition()
    {
        app.getHelperUser().submitOkButton();
    }

}
