package customer;

public class Customer {
    private final String name;
    private double balance;

   public Customer(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //assumes that people dont change their names so no setter for name.
    public String getName() {
        return name;
    }

    public void printDetails()
    {
        System.out.println("\n** CUSTOMER DETAILS **");
        System.out.println("NAME: " + name);
        System.out.println("BALANCE: " + balance);
        System.out.println("** END DETAILS **\n");
    }
}
