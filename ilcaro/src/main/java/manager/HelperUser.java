package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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


    public void submitYallaButton() {
        click(By.xpath("//*[@type='submit']"));
    }
    public void btnOk()
    {
        click(By.xpath("//button[@type='button']"));
    }

    public boolean isLoginRegSuccess() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }


    public String chekMessage() {
        return wd.findElement(By.xpath("//a[text()=' Logout ']")).getText();
    }

    public boolean isLogOutPresent()
    {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logOut()
    {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegForm()
    {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegGorm(String name, String lastname, String email, String password)
    {
        type(By.id("name"),name);
        type(By.id("lastName"),lastname);
        type(By.id("email"),email);
        type(By.id("password"),password);

    }

    public void checkPolicy()
    {
        click(By.xpath("//*[@class='checkbox-label terms-label']"));
    }

    public void checkPolicyXY()
    {
        WebElement lable=wd.findElement(By.xpath("//*[@class='checkbox-label terms-label']"));
        Rectangle rect = lable.getRect();
        int offSetX=rect.getWidth()/2;
        int offSetY=rect.getHeight()/2;
        Actions actions=new Actions(wd);
        actions.moveToElement(lable).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();
    }
}
