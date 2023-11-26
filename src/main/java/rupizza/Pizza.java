package rupizza;
import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class

    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    protected static final double SALES_TAX = 1.06625;
    protected static final double PRICE_DELUXE=14.99;

    protected static final double PRICE_SUPREME=15.99;
    protected static final double PRICE_MEATZZA=16.99;

    protected static final double PRICE_SEAFOOD=17.99;
    protected static final double PRICE_PEPPERONI=10.99;
    protected static final double PRICE_BUILD_YOUR_OWN_PIZZA=8.99;

    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        this.toppings = new ArrayList<>();
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public abstract double price();
}

class DeluxePizza extends Pizza{
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
            base+=1.00;
        if(this.extraCheese)
            base+=1.00;
        if(this.size==Size.MEDIUM)
            base+=2;
        if(this.size==Size.LARGE)
            base+=4;
        return base * SALES_TAX;
    }
}
class SupremePizza extends Pizza {
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
            base += 1.00;
        if (this.extraCheese)
            base += 1.00;
        if (this.size == Size.MEDIUM)
            base += 2;
        if (this.size == Size.LARGE)
            base += 4;
        return base * SALES_TAX;
    }
}
class MeatzzaPizza extends Pizza {
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
            base += 1.00;
        if (this.extraCheese)
            base += 1.00;
        if (this.size == Size.MEDIUM)
            base += 2;
        if (this.size == Size.LARGE)
            base += 4;
        return base * SALES_TAX;
    }
}
class SeafoodPizza extends Pizza {
    public SeafoodPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }
    public double price() {
        double base = PRICE_SEAFOOD;
        if (this.extraSauce)
            base += 1.00;
        if (this.extraCheese)
            base += 1.00;
        if (this.size == Size.MEDIUM)
            base += 2;
        if (this.size == Size.LARGE)
            base += 4;
        return base * SALES_TAX;
    }
}
class PepperoniPizza extends Pizza {
    public PepperoniPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        toppings.add(Topping.PEPPERONI);
    }
    public double price() {
        double base = PRICE_PEPPERONI;
        if (this.extraSauce)
            base += 1.00;
        if (this.extraCheese)
            base += 1.00;
        if (this.size == Size.MEDIUM)
            base += 2;
        if (this.size == Size.LARGE)
            base += 4;
        return base * SALES_TAX;
    }
}
class BuildYourOwnPizza extends Pizza {
    public BuildYourOwnPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, sauce, extraSauce, extraCheese);
        this.toppings = new ArrayList<>(toppings); // ??
    }
    public double price() {
        double base = PRICE_BUILD_YOUR_OWN_PIZZA;
        if (this.extraSauce)
            base += 1.00;
        if (this.extraCheese)
            base += 1.00;
        if (this.size == Size.MEDIUM)
            base += 2;
        if (this.size == Size.LARGE)
            base += 4;
        return base * SALES_TAX;
    }
}
