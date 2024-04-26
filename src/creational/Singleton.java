package creational;

public class Singleton {
    private static Singleton instance; // class instance is declared as an object in the CLASS
    private final String data; // class property

    // private constructor to ensure the class cannot be instantiated
    private Singleton(String data) {
        this.data = data;
    }

    // Public method to return the instance
    public static Singleton getInstance(String data) {
        if (instance == null) {
            instance = new Singleton(data);
        }

        return instance;
    }

    public String getData() {
        return data;
    }
}
