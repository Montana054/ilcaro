package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AplicationManager
{

    WebDriver wd;
    HelperUser helperUser;

    public void inIt()
    {
        wd= new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
helperUser=new HelperUser(wd);
    }
    public void stop()
    {

        //wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
