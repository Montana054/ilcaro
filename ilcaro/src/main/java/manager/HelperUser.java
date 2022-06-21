package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd)
    {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//*[@id='email']"),email);
        type(By.xpath("//*[@id='password']"),password);
    }


    public void submitLogin() {
        click(By.xpath("//*[@type='submit']"));
    }
    public void btnOk()
    {
        click(By.xpath("//button[@type='button']"));
    }

    public boolean isLoginRegSuccess() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }
}
