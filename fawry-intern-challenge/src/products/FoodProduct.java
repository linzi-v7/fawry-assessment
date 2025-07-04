package products;

import products.categories.Expirable;
import products.categories.Shippable;

import java.time.LocalDate;

//for products that are both expirable and shippable (mainly food) e.g: cheese, biscuits
public class FoodProduct extends Product implements Shippable, Expirable {

    double weight;

    //assume all products of same reference have same expiration date
    //otherwise, could be made with a dictionary or a map for individual items.
    LocalDate expirationDate;
    public FoodProduct(String name, float price, int quantity, double weight, LocalDate expiry)
    {
        super(name,price,quantity);
        this.weight = weight;
        this.expirationDate = expiry;
    }

    //needed by shippable but its implemented for all classes by default
    //to achieve encapsulation
//    @Override
//    public String getName() {
//        return this.name;
//    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    //return true if expired, else false
    @Override
    public boolean checkExpired() {
        LocalDate todayDate = LocalDate.now();
        LocalDate expiryDate = getExpirationDate();

        //assumes that the store wont sell products with expiration date of today.
        //if we need to handle this case we can use .equals() but i chose not to
        //since a store probably dont sell products that expire on the same day.
        return todayDate.isAfter(expiryDate); //expired
    }
}
