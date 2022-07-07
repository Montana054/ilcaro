package manager;

import models.Cars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarsHelper extends HelperBase {
    public CarsHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Cars car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());

        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWD());


        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsuptions());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanseIbclude());
        type(By.cssSelector(".feature-input"), car.getFeatures());
        type(By.id("about"), car.getAbout());






    }

    private void select(By locator, String option)
    {
new Select(wd.findElement(locator)).selectByValue(option);
    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector(".pac-item"));


    }

    public void attachForm(String s) {
    }
}
