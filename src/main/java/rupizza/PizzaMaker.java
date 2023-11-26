package rupizza;
public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType.toLowerCase()){
            case "deluxe":
                return new DeluxePizza();
            case "supreme":
                return new SupremePizza();
            case "meatzza":
                return new MeatzzaPizza();
            case "seafood":
                return new SeafoodPizza();
            case "pepperoni":
                return new PepperoniPizza();
            case "buildyourown":
                return new BuildYourOwnPizza();
            default:
                throw new IllegalArgumentException("Invalid Pizza Type:" + pizzaType);
        }
    }
}