package shopping;

import products.Product;

import java.util.ArrayList;

public class CheckoutHandler {

    //if there is shippable items,
    //assume delivery fee is min(10, 14% of subtotal), else 0;
    static double  deliveryFee = 0.0f;
    public static boolean checkout(Cart cart)
    {

        if(cart.items.isEmpty())
        {
            System.out.println("** CHECKOUT: ERROR, Cart is empty, please fill" +
                    " the cart before checking out. ** \n");
            return false;
        }

        if(cart.checkShippable())
        {
            deliveryFee = Math.min(cart.cumulativeSubtotal * 0.14,10);
            System.out.println("** SHIPMENT NOTICE **");
            cart.listShippableItems();
        }

        System.out.println("\n** CHECKOUT RECEIPT **");
        cart.listAllItems();

        System.out.println("--------------------------------");
        System.out.println("Subtotal\t\t\t\t\t" + cart.cumulativeSubtotal);
        System.out.println("Shipping\t\t\t\t\t" + deliveryFee);
        System.out.println("Total Pr.\t\t\t\t\t" + (cart.cumulativeSubtotal + deliveryFee));
        return true;
    }
}
