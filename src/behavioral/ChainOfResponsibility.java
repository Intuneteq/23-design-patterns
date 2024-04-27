package behavioral;

import java.util.HashMap;
import java.util.Map;

class Database {
    private final Map<String, String> users;

    Database() {
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }
}

abstract class Handler {
    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    abstract boolean handle(String username, String password);

    protected boolean handleNext(String username, String password) {
        if (next == null) {
            return true;
        }

        return next.handle(username, password);
    }
}

class UserExistHandler extends Handler {
    private final Database database;

    UserExistHandler(Database _database) {
        database = _database;
    }

    @Override
    boolean handle(String username, String password) {
        return database.isValidUser(username);
    }
}

class ValidPasswordHandler extends Handler {
    private final Database database;

    ValidPasswordHandler(Database _database) {
        database = _database;
    }
    @Override
    boolean handle(String username, String password) {
        return database.isValidPassword(username, password );
    }
}

class ChainOfResponsibility {

}
