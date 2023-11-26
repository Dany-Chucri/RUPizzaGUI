package rupizza;
import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is an enum class
    protected Size size; //Size is an enum class
    protected Sauce sauce; //Sauce is an enum class
    protected boolean extraSauce;
    protected boolean extraCheese;
    protected static final double SALES_TAX = 1.06625;
    protected static final double PRICE_DELUXE=14.99;

    protected static final double PRICE_SUPREME=15.99;
    protected static final double PRICE_MEATZZA=16.99;

    protected static final double PRICE_SEAFOOD=17.99;
    protected static final double PRICE_PEPPERONI=10.99;
    protected static final double PRICE_BUILD_YOUR_OWN_PIZZA=8.99;
    protected static final double EXTRA_SAUCE_FEE = 1.00;
    protected static final double EXTRA_CHEESE_FEE = 1.00;
    protected static final double PRICE_FOR_MEDIUM= 2.00;

    protected static final double PRICE_FOR_LARGE= 4.00;

    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        this.toppings = new ArrayList<>();
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public abstract double price();

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public Size getSize() {
        return size;
    }
    public Sauce getSauce() {
        return sauce;
    }
    public boolean isExtraSauce() {
        return extraSauce;
    }
    public boolean isExtraCheese() {
        return extraCheese;
    }
}
class DeluxePizza extends Pizza{
    public DeluxePizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }
    public DeluxePizza (Size size , Sauce sauce, boolean extraSauce, boolean extraCheese){
        super(size,sauce,extraSauce,extraCheese);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }
    public double price(){
        double base=PRICE_DELUXE;
        if(this.extraSauce)
            base+=EXTRA_SAUCE_FEE;
        if(this.extraCheese)
            base+=EXTRA_CHEESE_FEE;
        if(this.size==Size.MEDIUM)
            base+=PRICE_FOR_MEDIUM;
        if(this.size==Size.LARGE)
            base+=PRICE_FOR_LARGE;
        return base * SALES_TAX;
    }
}
class SupremePizza extends Pizza {
    public SupremePizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
    }
    public SupremePizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
    }

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
        return base * SALES_TAX;
    }
}
class MeatzzaPizza extends Pizza {
    public MeatzzaPizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }
    public MeatzzaPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }
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
        return base * SALES_TAX;
    }
}
class SeafoodPizza extends Pizza {
    public SeafoodPizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }
    public SeafoodPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }
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
        return base * SALES_TAX;
    }
}
class PepperoniPizza extends Pizza {
    public PepperoniPizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        toppings.add(Topping.PEPPERONI);
    }
    public PepperoniPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.PEPPERONI);
    }
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
        return base * SALES_TAX;
    }
}
class BuildYourOwnPizza extends Pizza {
    public BuildYourOwnPizza(){
        super(Size.SMALL,Sauce.TOMATO,false,false);
        this.toppings = new ArrayList<>(toppings);
    }
    public BuildYourOwnPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        this.toppings = new ArrayList<>(toppings); // ??
    }
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
        return base * SALES_TAX;
    }
}
