package creational;

/**
 * Burger class
 */
class Burger {
    private int productId;

    private String addOns;

    public void prepare() {
        // Prepare burger
        System.out.println("preparing burger");
    }

    public String getAddOns() {
        return addOns;
    }

    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }

    public int getProductId() {
        return productId;
    }
}

/**
 * Beef burger
 */
class BeefBurger extends Burger {
}

/**
 * Veggie burger
 */
class VeggieBurger extends Burger {
}

/**
 * This is the base restaurant selling two types of burgers
 * <p>
 * 1. beef burger
 * 2. Veggie burger
 */
abstract class Restaurant {

    // method to order burger from the restaurant
    public Burger orderBurger() {

        // call the create burger method
        Burger burger = createBurger();

        // prepare burger
        burger.prepare();

        return burger;
    }

    // Factory method
    abstract Burger createBurger();
}

/**
 * Factory subclass to create beef burger
 */
class BeefBurgerRestaurant extends Restaurant {
    @Override
    Burger createBurger() {
        return new BeefBurger();
    }
}

/**
 * Factory subclass to create veggie burger
 */
class VeggieBurgerRestaurant extends Restaurant {
    @Override
    Burger createBurger() {
        return new VeggieBurger();
    }
}

/**
 * A factory is a class whose sole responsibility is creating instances of a class.
 * Factory design pattern takes out the responsibility of instantiating a class from the class into a factory
 * <p>
 * Best used when you have no idea of the exact types of the object the code will work with.
 */
class Factory {
    public static void main(String[] args) {
        Restaurant beefResto = new BeefBurgerRestaurant();
        Burger beefBurger = beefResto.orderBurger();

        System.out.println(beefBurger);

        Restaurant veggieResto = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieResto.orderBurger();

        System.out.println(veggieBurger);
    }

}
