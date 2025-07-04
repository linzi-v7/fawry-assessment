package shopping;

import products.Product;

import java.util.ArrayList;

public class CheckoutHandler {

    //if there is shippable items,
    //assume delivery fee is max(10, 14% of subtotal)
    public static boolean checkout(Cart cart)
    {

        if(cart.items.isEmpty())
        {
            System.out.println("** CHECKOUT: ERROR, Cart is empty, please fill" +
                    " the cart before checking out. ** \n");
            return false;
        }

        return true;
    }
}
