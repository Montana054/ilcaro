package tests;

import models.Cars;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeMethod
    public void preCondition()
    {
        // if Login-->Login
    }
    @Test
    public void addNewCarsSuccess()
    {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
       Cars car = Cars.builder()
               .address("Tel-Aviv")
               .about("surprise masefakers")
               .carRegNumber("AA777A054"+index)
               .clasS("S")
               .distanseIbclude("54 km")
               .doors("4")
               .engine("6.0")
               .gear("AT")
               .fuel("Petrol")
               .fuelConsuptions("6.6")
               .make("Mersedes")
               .model("E333")
               .wD("RWD")
               .year("2020")
               .seats("4")
               .price("400")
               .features("CD")
               .build();
       app.car().openCarForm();
       app.car().fillCarForm(car);
       app.car().attachForm("");
       app.car().submit();
       // login --- vsr added- нужно разнести в 2класса

    }
}
