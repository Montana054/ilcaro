package tests;

import manager.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static AplicationManager app = new AplicationManager();// Инициализация
    //так как STATIC то они статик начинают отрабатывать первые
    @BeforeSuite
    public void setUp()
    {
        app.inIt();
    }

    @AfterSuite
    public void tearDown()
    {
        app.stop();
    }
}
