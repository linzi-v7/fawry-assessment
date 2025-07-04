package shopping;

import products.Product;
import products.categories.Shippable;

import java.util.ArrayList;

public class ShippingService {

    public static void ship(ArrayList<CartItem> shippableItems)
    {
        System.out.println("** Shipping Service Initiated, expect delivery within 7 working days. **");
        System.out.println("Items with applicable shipping:");

        for (CartItem item: shippableItems) {
            Shippable shippable = (Shippable) item.getProduct();
            System.out.println(shippable.getName() +" "
                    + item.getDesiredQuantity() +"x "
                    +(item.getDesiredQuantity()*shippable.getWeight()) + "kg");

        }

        System.out.println("** END TRANSACTION **");
    }

}
