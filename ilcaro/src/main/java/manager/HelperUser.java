package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd)
    {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath(""));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath(""),email);
        type(By.xpath(""),password);
    }

    public void submitLogin() {
        click(By.xpath(""));
    }
}
