package manager;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class AplicationManager {
    EventFiringWebDriver wd;
    //WebDriver wd;
    HelperUser helperUser;
    CarsHelper car;
    HelperSearch search;
    Asa a;

    Logger logger = LoggerFactory.getLogger(AplicationManager.class);

    public void inIt() {
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("All tests starts in ChromDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        logger.info(("The linc is -->" + wd.getCurrentUrl()));
        helperUser = new HelperUser(wd);// Инициализация
        car = new CarsHelper(wd);
        search = new HelperSearch(wd);
        a = new Asa(wd);
        wd.register(new MyListener());
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
