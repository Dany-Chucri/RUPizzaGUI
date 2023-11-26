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
    protected static final double EXTRA_SAUCE_FEE = 1.00;
    protected static final double EXTRA_CHEESE_FEE = 1.00;
    protected static final double PRICE_FOR_MEDIUM= 2.00;

    protected static final double PRICE_FOR_LARGE= 4.00;

    public Pizza() {
        this.toppings = new ArrayList<>();
        this.size = Size.SMALL;
        this.sauce = Sauce.TOMATO;
        this.extraSauce = false;
        this.extraCheese = false;
    }
    public abstract double price();

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public Size getSize() {
        return size;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public boolean getExtraSauce() {
        return extraSauce;
    }

    public boolean getExtraCheese() {
        return extraCheese;
    }

    public void addTopping(String topping) {

    }

    public void removeTopping(String topping) {

    }

    public void setSize(String size) {

    }

    public void setSauce(String sauce) {

    }

    public void setExtraSauce(Boolean extra) {
        extraSauce = extra;
    }

    public void setExtraCheese(Boolean extra) {
        extraCheese = extra;
    }
}

class DeluxePizza extends Pizza{
    public DeluxePizza (){
        super();
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
        return base;
    }
}
class SupremePizza extends Pizza {
    public SupremePizza() {
        super();
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
        return base;
    }
}
class MeatzzaPizza extends Pizza {
    public MeatzzaPizza() {
        super();
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
        return base;
    }
}
class SeafoodPizza extends Pizza {
    public SeafoodPizza() {
        super();
        sauce = Sauce.ALFREDO;
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
        return base;
    }
}
class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        super();
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
        return base;
    }
}
class BuildYourOwnPizza extends Pizza {
    public BuildYourOwnPizza() {
        super();
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
        return base;
    }
}
