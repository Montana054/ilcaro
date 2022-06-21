package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
    public void loginSuccess()
    {
       app.getHelperUser().openLoginForm();
       app.getHelperUser().implicitlyWait();
       app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
       app.getHelperUser().submitLogin();
       app.getHelperUser().btnOk();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }

}
