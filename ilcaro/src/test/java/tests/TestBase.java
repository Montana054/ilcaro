package tests;

import manager.AplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static AplicationManager app = new AplicationManager();
    @BeforeMethod
    public void setUp()
    {
        app.inIt();
    }
    @AfterMethod
    public void tearDown()
    {
        app.stop();
    }
}
