package manager;

import models.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
    }

    public void fillLoginForm(Users user)//длямоделс
    {
        type(By.xpath("//*[@id='email']"), user.getEmail());
        type(By.xpath("//*[@id='password']"), user.getPassword());
    }


    public void submitOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }

    }

    public boolean isLoginRegSuccess() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }


    public String chekMessage() {
        new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//a[text()=' Logout ']"))));
        return wd.findElement(By.xpath("//a[text()=' Logout ']")).getText();
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegForm(Users user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLasteName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void fillRegForm(String name, String lastname, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastname);
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void checkPolicy() {
        click(By.xpath("//*[@class='checkbox-label terms-label']"));
    }

    public void checkPolicyXY() {
        WebElement lable = wd.findElement(By.xpath("//*[@class='checkbox-label terms-label']"));
        Rectangle rect = lable.getRect();
        int offSetX = rect.getWidth() / 2;
        int offSetY = rect.getHeight() / 2;
        Actions actions = new Actions(wd);
        actions.moveToElement(lable).release().perform();
        actions.moveByOffset(-offSetX, -offSetY).click().release().perform();
    }

    public boolean isErrorPasswordDisplayedSize() {
        Boolean firstChaild = new WebDriverWait(wd, 5).until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector("div.error div:first-child"))
                        , "Password must contain minimum 8 symbols"));

        return firstChaild;
    }

    public boolean isErrorPasswordDisplayedFormat() {
        Boolean lastChaild = new WebDriverWait(wd, 8).until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector("div.error div:last-child"))
                        , "Password must contain 1 uppercase letter, 1 lowercase letter and one number"));
        return lastChaild;
    }

    public boolean isYallaButtonNotActive() {

        return wd.findElement(By.xpath("//*[@type='submit']")).isEnabled();//1 вариант-слцжебный метот силениума
    }

    public boolean isYallaButtonNotClicabal() {
        return isElementPresent(By.cssSelector("Button[disabled]"));//2 вариант
    }

    public void login(Users user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        //submitOkButton();

    }

//    public void mainPage()
//    {
//
//    }
}
