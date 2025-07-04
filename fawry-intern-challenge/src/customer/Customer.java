package customer;

public class Customer {
    private final String name;
    private float balance;

    Customer(String name, float balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    //assumes that people dont change their names so no setter for name.
    public String getName() {
        return name;
    }
}
