package manager;


import models.Cars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    CarsHelper car;

    public void inIt() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        helperUser = new HelperUser(wd);// Инициализация
        car = new CarsHelper(wd);

    }

    public void stop() {

        //wd.quit();
    }

    public CarsHelper car() {
        return car;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
