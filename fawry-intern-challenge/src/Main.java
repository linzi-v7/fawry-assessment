import customer.Customer;
import products.DigitalProduct;
import products.FoodProduct;
import products.PhysicalProduct;
import products.Product;
import shopping.Cart;
import shopping.CheckoutHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(); //better looking
        Product cheese = new FoodProduct("Cheese", 2.5F, 5,
                0.1, LocalDate.of(2025,11,7));

        Product expiredCheese = new FoodProduct("Expired Cheese", 2.5F, 5,
                0.1, LocalDate.of(2025,7,3));

        Product biscuits = new FoodProduct("Biscuits", 1.5F, 10,
                0.05, LocalDate.of(2025,7,7));

        Product tv = new PhysicalProduct("TV", 50.0F, 5,
                1.5);

        Product mobile = new PhysicalProduct("Mobile", 100.0F, 5,
                200);

        Product scratchCard = new DigitalProduct("My-e# Scratch Card", 2.0F, 5);


        Customer user = new Customer("Faris", 200);
        user.printDetails();

        Cart cart = new Cart(user);

        //these should give an error
        CheckoutHandler.checkout(cart);
        cart.addProduct(cheese,6);
        cart.addProduct(expiredCheese);
        cart.addProduct(cheese,3);
        cart.addProduct(cheese,2);
        cart.listAllItems();

        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 3);
        cart.addProduct(scratchCard, 1);

        CheckoutHandler.checkout(cart);
        cart.resetCart();
        cart.listAllItems(); //shouldnt print anything as cart is now empty
        user.printDetails();

        cart.addProduct(tv,3); //should give error because now only 2 in stock

    }
}