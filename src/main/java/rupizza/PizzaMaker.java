package rupizza;

/**
 * The PizzaMaker class is responsible for creating different types of pizzas based on the given pizza type.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class PizzaMaker {

    /**
     * Creates a pizza based on the specified pizza type.
     *
     * @param pizzaType The type of pizza to create. (e.g., "deluxe", "supreme", "meatzza", etc.)
     * @return A new Pizza object corresponding to the specified pizza type.
     * @throws IllegalArgumentException If an invalid pizza type is provided.
     */
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