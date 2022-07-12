package tests;

import models.Cars;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeMethod
    public void preCondition()
    {
        if(!app.getHelperUser().isLogOutPresent())
        {
            app.getHelperUser().login(new Users().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
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
      app.car().attachForm("C:/Qa32/ilcaro/JIPG/Tesla-Model-S-6-1.jpg");

      app.car().submit();
      Assert.assertTrue(app.car().isCarAdded());


    }
}
