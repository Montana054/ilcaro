package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class AplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    CarsHelper car;
    HelperSearch search;


    Logger logger = LoggerFactory.getLogger(AplicationManager.class);

    public void inIt() {
        wd = new ChromeDriver();
        logger.info("All tests starts in ChromDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        helperUser = new HelperUser(wd);// Инициализация
        car = new CarsHelper(wd);
        search = new HelperSearch(wd);
    }

    public void stop() {

        //wd.quit();
    }

    public HelperSearch getSearch() {
        return search;
    }

    public CarsHelper car() {
        return car;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
