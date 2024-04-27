package creational;

interface IPrototype {
    IPrototype _clone();
}

class Vehicle implements IPrototype {
    String brand;
    String model;
    String color;

    Vehicle() {
    }

    Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    @Override
    public Vehicle _clone() {
        return null;
    }
}

class Truck extends Vehicle {
    String topSpeed;

    Truck() {
    }

    Truck(Truck truck) {
        super((Vehicle) truck);
        this.topSpeed = truck.topSpeed;
    }

    @Override
    public Truck _clone() {
        return new Truck(this);
    }
}

/**
 * Problem - Recreating similar objects
 * <p>
 * It delegates the object duplication or cloning process to the actual objects that are being cloned
 */
public class Prototype {
    public static void main(String[] args) {
        var truck1 = new Truck();
        truck1.model = "Nissan";
        truck1.brand = "Nissan";
        truck1.color = "Black";
        truck1.topSpeed = "30miles/hr";

        Truck truck2 = truck1._clone();

        System.out.println(truck2.brand);
        System.out.println(truck2.model);
        System.out.println(truck2.color);
        System.out.println(truck2.topSpeed);
    }
}