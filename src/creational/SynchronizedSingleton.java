package creational;

/**
 * Problem - In a multithreaded environment,
 * two threads can call the getInstance method at the same time resulting in two different instances created
 * <p>
 * The solution is implemented using Java synchronization.
 */
public class SynchronizedSingleton {

    private static volatile SynchronizedSingleton instance; // class instance is declared as an object in the CLASS
    private final String data; // class property

    private SynchronizedSingleton(String data) {
        this.data = data;
    }

    // Public method to return the instance
    public static SynchronizedSingleton getInstance(String data) {
        // Everytime we access this variable, we read it from the main memory
        // Now, even if the instance was already initialised, we have to fetch it twice.
        // 1. When we check if it is null.
        // 2. In the return statement to return it to the user
        // To avoid doing this and call the instance from the memory once, we store the single instance in a local variable
        SynchronizedSingleton result = instance;
        // Applying double-check idiom
        // Now,
        // threads do not necessarily have to acquire the lock on the class when the instance is not null, return the instance.
        // We're improving the performance of this method by limiting synchronisation to the rare case of constructing a new instance of this field.
        if (result == null) {
            // Wrap the if statement with the synchronised key word.
            // Now, a thread will wait for its turn before accessing this code block
            synchronized (SynchronizedSingleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SynchronizedSingleton(data);
                }
            }
        }


        return result;
    }

    public String getData() {
        return data;
    }
}
