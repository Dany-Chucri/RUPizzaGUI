package rupizza;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Abstract class representing a pizza.
 * @author Dany Chucri, Madhur Nutulapati
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is an enum class

    protected Size size; //Size is an enum class
    protected Sauce sauce; //Sauce is an enum class
    protected boolean extraSauce;
    protected boolean extraCheese;
    protected String pizzaType;

    protected static final double SALES_TAX = 1.06625;
    protected static final double PRICE_DELUXE=14.99;

    protected static final double PRICE_SUPREME=15.99;
    protected static final double PRICE_MEATZZA=16.99;

    protected static final double PRICE_SEAFOOD=17.99;
    protected static final double PRICE_PEPPERONI=10.99;
    protected static final double PRICE_BUILD_YOUR_OWN_PIZZA=8.99;
    protected static final double PRICE_EXTRA_TOPPING = 1.49;
    protected static final double MIN_TOPPINGS = 3;
    protected static final double MAX_TOPPINGS = 7;
    protected static final double EXTRA_SAUCE_FEE = 1.00;
    protected static final double EXTRA_CHEESE_FEE = 1.00;
    protected static final double PRICE_FOR_MEDIUM= 2.00;
    protected static final double PRICE_FOR_LARGE= 4.00;

    /**
     * Default constructor for a Pizza object.
     */
    public Pizza() {
        this.toppings = new ArrayList<>();
        this.size = Size.SMALL;
        this.sauce = Sauce.TOMATO;
        this.extraSauce = false;
        this.extraCheese = false;
        this.pizzaType = "";
    }

    /**
     * Abstract method to calculate the price of the pizza.
     *
     * @return The price of the pizza.
     */
    public abstract double price();

    /**
     * Get the list of toppings on the pizza.
     *
     * @return ArrayList of Topping enum representing toppings on the pizza.
     */
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Get the size of the pizza.
     *
     * @return Size enum representing the size of the pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Get the sauce on the pizza.
     *
     * @return Sauce enum representing the sauce on the pizza.
     */
    public Sauce getSauce() {
        return sauce;
    }

    /**
     * Check if extra sauce is added to the pizza.
     *
     * @return true if extra sauce is added, false otherwise.
     */
    public boolean isExtraSauce() {
        return extraSauce;
    }

    /**
     * Check if extra cheese is added to the pizza.
     *
     * @return true if extra cheese is added, false otherwise.
     */
    public boolean isExtraCheese() {
        return extraCheese;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    /**
     * Add a topping to the pizza.
     *
     * @param topping The topping to be added.
     */
    public void addTopping(String topping) {
        if (topping.equals("Crab Meats")) topping = "Crab_Meats";
        if (topping.equals("Green Pepper")) topping = "Green_Pepper";
        if (topping.equals("Black Olive")) topping = "Black_Olive";
        toppings.add(Topping.valueOf(topping.toUpperCase()));
    }

    /**
     * Remove a topping from the pizza.
     *
     * @param topping The topping to be removed.
     */
    public void removeTopping(String topping) {
        if (topping.equals("Crab Meats")) topping = "Crab_Meats";
        if (topping.equals("Green Pepper")) topping = "Green_Pepper";
        if (topping.equals("Black Olive")) topping = "Black_Olive";
        toppings.remove(Topping.valueOf(topping.toUpperCase()));
    }

    /**
     * Set the size of the pizza.
     *
     * @param size The size to be set.
     */
    public void setSize(String size) {
        this.size = Size.valueOf(size.toUpperCase());
    }

    /**
     * Set the sauce of the pizza.
     *
     * @param sauce The sauce to be set.
     */
    public void setSauce(String sauce) {
        this.sauce = Sauce.valueOf(sauce.toUpperCase());
    }

    /**
     * Set whether extra sauce is added to the pizza.
     *
     * @param extra True if extra sauce is added, false otherwise.
     */
    public void setExtraSauce(Boolean extra) {
        extraSauce = extra;
    }

    /**
     * Set whether extra cheese is added to the pizza.
     *
     * @param extra True if extra cheese is added, false otherwise.
     */
    public void setExtraCheese(Boolean extra) {
        extraCheese = extra;
    }

    public void copyPizza(Pizza pizza) {
        this.toppings = new ArrayList<>();
        this.toppings.addAll(pizza.getToppings());
        this.size = pizza.getSize();
        this.sauce = pizza.getSauce();
        this.extraSauce = pizza.isExtraSauce();
        this.extraCheese = pizza.isExtraCheese();
        this.pizzaType = pizza.getPizzaType();
    }

    /**
     * Generate a string representation of the pizza.
     *
     * @return String representation of the pizza.
     */
    @Override
    public String toString() {
        String exSauce = "No Extra Sauce", exCheese = "No Extra Cheese";
        if (extraSauce) exSauce = "Extra Sauce";
        if (extraCheese) exCheese = "Extra cheese";

        return "[" + pizzaType + "] " + toppings + ", " + size.toString() + ", " + sauce.toString() + ", "
                + exSauce + ", " + exCheese + " " + NumberFormat.getCurrencyInstance().format(this.price());
    }
}

/**
 * DeluxePizza class represents a pizza with a predefined set of toppings.
 */
class DeluxePizza extends Pizza{
    /**
     * Default constructor for a DeluxePizza object.
     */
    public DeluxePizza (){
        super();
        pizzaType = "Deluxe";
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Calculate the price of the DeluxePizza based on its size and additional options.
     *
     * @return The total price of the DeluxePizza.
     */
    public double price(){
        double base=PRICE_DELUXE;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        return base;
    }
}

/**
 * SupremePizza class represents a pizza with a variety of toppings.
 */
class SupremePizza extends Pizza {

    /**
     * Default constructor for a SupremePizza object.
     */
    public SupremePizza() {
        super();
        pizzaType = "Supreme";
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Calculate the price of the SupremePizza based on its size and additional options.
     *
     * @return The total price of the SupremePizza.
     */
    public double price() {
        double base = PRICE_SUPREME;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        return base;
    }
}

/**
 * MeatzzaPizza class represents a pizza with meat toppings.
 */
class MeatzzaPizza extends Pizza {

    /**
     * Default constructor for a MeatzzaPizza object.
     */
    public MeatzzaPizza() {
        super();
        pizzaType = "Meatzza";
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }

    /**
     * Calculate the price of the MeatzzaPizza based on its size and additional options.
     *
     * @return The total price of the MeatzzaPizza.
     */
    public double price() {
        double base = PRICE_MEATZZA;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        return base;
    }
}

/**
 * SeafoodPizza class represents a pizza with seafood toppings.
 */
class SeafoodPizza extends Pizza {

    /**
     * Default constructor for a SeafoodPizza object.
     */
    public SeafoodPizza() {
        super();
        pizzaType = "Seafood";
        sauce = Sauce.ALFREDO;
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }

    /**
     * Calculate the price of the SeafoodPizza based on its size and additional options.
     *
     * @return The total price of the SeafoodPizza.
     */
    public double price() {
        double base = PRICE_SEAFOOD;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        return base;
    }
}

/**
 * PepperoniPizza class represents a pizza with pepperoni toppings.
 */
class PepperoniPizza extends Pizza {

    /**
     * Default constructor for a PepperoniPizza object.
     */
    public PepperoniPizza() {
        super();
        pizzaType = "Pepperoni";
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * Calculate the price of the PepperoniPizza based on its size and additional options.
     *
     * @return The total price of the PepperoniPizza.
     */
    public double price() {
        double base = PRICE_PEPPERONI;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        return base;
    }
}

/**
 * BuildYourOwnPizza class represents a customizable pizza where toppings can be added.
 */
class BuildYourOwnPizza extends Pizza {

    /**
     * Default constructor for a BuildYourOwnPizza object.
     */
    public BuildYourOwnPizza() {
        super();
        pizzaType = "Build your own";
    }

    /**
     * Calculate the price of the BuildYourOwnPizza based on its size, toppings, and additional options.
     *
     * @return The total price of the BuildYourOwnPizza.
     */
    public double price() {
        double base = PRICE_BUILD_YOUR_OWN_PIZZA;
        if (this.extraSauce)
            base += EXTRA_SAUCE_FEE;
        if (this.extraCheese)
            base += EXTRA_CHEESE_FEE;
        if (this.size == Size.MEDIUM)
            base += PRICE_FOR_MEDIUM;
        if (this.size == Size.LARGE)
            base += PRICE_FOR_LARGE;
        if (this.toppings.size() > MIN_TOPPINGS) {
            base += (this.toppings.size() - MIN_TOPPINGS) * PRICE_EXTRA_TOPPING;
        }
        return base;
    }
}
