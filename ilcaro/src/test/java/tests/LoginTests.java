package tests;

import manager.MyDataprovider;
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


    @Test(dataProvider= "validLoginData", dataProviderClass = MyDataprovider.class)
    public void loginSuccessModel(String email, String password)
    {
        logger.info("the test starts with data :  email "+email+ " password : "+password);
        Users user =new Users().withEmail(email).withPassword(password);
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
