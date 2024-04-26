package creational;

class Builder {
    private int id;
    private String brand;
    private String model;
    private String color;

    public Builder id(int id) {
        this.id = id;

        return this;
    }

    public Builder brand(String _brand) {
        brand = _brand;

        return this;
    }

    public Builder model(String _model) {
        model = _model;

        return this;
    }

    public Builder color(String _color) {
        color = _color;

        return this;
    }

    public Car build() {
        return new Car(id, brand, model, color);
    }
}

class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final String color;

    Car(int _id, String _brand, String _model, String _color) {
        id = _id;
        brand = _brand;
        model = _model;
        color = _color;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}

class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();

        builder.id(2122).brand("Bugatti").model("Chiron").color("blue");

        Car car = builder.build();

        System.out.println(car);
    }
}


