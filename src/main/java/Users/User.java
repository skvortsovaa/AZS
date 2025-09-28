package Users;

abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Каждый пользователь по-своему выполняет действие
    public abstract void performAction();
}
