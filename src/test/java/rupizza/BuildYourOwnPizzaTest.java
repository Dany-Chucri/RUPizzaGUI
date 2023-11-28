package rupizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for the BuildYourOwnPizza class.
 * Uses Black-Box testing technique to design test cases for the BuildYourOwnPizza - price method.
 * @author Dany Chucri, Madhur Nutulapati
 */
class BuildYourOwnPizzaTest{

    /**
     * Test case for the BuildYourOwnPizza - price() method with extra sauce and size set to large.
     */
    @Test
    void testPriceExtraSauceAndSizeLarge(){
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setExtraSauce(true);
        pizza.setSize("large");
        assertEquals(13.99, pizza.price(), 0.01);
    }

    /**
     * Test case for the BuildYourOwnPizza-price() method with no extra cheese or sauce and size set to small.
     */
    @Test
    void testPriceNoExtraCheeseOrSauceAndSizeSmall(){
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize("small");
        assertEquals(8.99, pizza.price(), 0.01);
    }

    /**
     * Test case for the BuildYourOwnPizza - price() method with three toppings.
     */
    @Test
    void testPriceWThreeToppings(){
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.addTopping("Ham");
        pizza.addTopping("Mushroom");
        pizza.addTopping("Onion");
        assertEquals(8.99, pizza.price(), 0.01);
    }

    /**
     * Test case for the BuildYourOwnPizza - price() method with extra sauce and size set to medium.
     */
    @Test
    void testPriceWExtraSauceAndMedium(){
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize("medium");
        pizza.setExtraSauce(true);
        assertEquals(11.99, pizza.price(), 0.01);
    }
    /**
     * Test case for the BuildYourOwnPizza - price() method with the maximum number of toppings.
     */
    @Test
    void testWithMaxToppings(){
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.addTopping("Beef");
        pizza.addTopping("Black Olive");
        pizza.addTopping("Crab Meats");
        pizza.addTopping("Ham");
        pizza.addTopping("Pepperoni");
        pizza.addTopping("Sausage");
        pizza.addTopping("Pineapple");
        assertEquals(14.95, pizza.price(), 0.01);
    }
}

