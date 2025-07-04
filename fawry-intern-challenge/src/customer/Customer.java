package customer;

public class Customer {
    private final String name;
    private float balance;

   public Customer(String name, float balance)
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

    public void printDetails()
    {
        System.out.println("** CUSTOMER DETAILS **");
        System.out.println("NAME: " + name);
        System.out.println("BALANCE: " + balance);
        System.out.println("** END DETAILS **\n");
    }
}
