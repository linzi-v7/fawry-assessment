package shopping;

import customer.Customer;
import products.Product;
import products.categories.Expirable;
import products.categories.Shippable;

import java.util.ArrayList;

public class Cart {

    //the user currently using this cart
    Customer currentUser;
    ArrayList<CartItem> items;
    double cumulativeSubtotal = 0.0F;
    boolean needsShipping = false;

    public Cart(Customer currentUser) {
        this.items = new ArrayList<>();
        this.currentUser = currentUser;
    }

    public boolean addProduct(Product product) {
        return addProduct(product, 1); //default case
    }

    //document says : Give an error if  one product is out of stock or expired.
    //Assume that the check happens when adding the product not at the end.
    //Realistically, user shouldnt be able to add items out of stock
    //and expired items should be checked on addition not on checkout.
    public boolean addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("** CART: ERROR (addProduct), quantity must be >=1. **\n");
            return false;
        }
        int remainingQuantity = product.getQuantity() - quantity;
        //check in stock
        if (product.getQuantity() <= 0) {
            System.out.println("** CART: ERROR (addProduct), Item out of stock. **\n");
            return false; //not enough in stock
        }

        //check remaining stock is appropriate for desired quantity
        //realistically, should take only the amount available
        //but its better to leave the choice to the user in a console environment
        if (remainingQuantity < 0) {
            System.out.println("** CART: ERROR (addProduct), Not enough in stock. ** \n" +
                    "Available: " + product.getQuantity()
                    + "\nDesired: " + quantity + "\nPlease try again with appropriate quantity.");

            System.out.println("** END ERROR **\n");
            return false;
        }

        //get existing item or create new
        CartItem cartItem = getExisting(product);
        if (cartItem == null) cartItem = new CartItem(product);

        if (cartItem.isExpirable()) {
            Expirable expirableItem = (Expirable) product;
            boolean expired = expirableItem.checkExpired();
            if (expired) {
                System.out.println("** CART: ERROR (addProduct), Item Expired! Please try another item. **\n");
                return false;
            }
        }

        double addedPrice = product.getPrice() * quantity;
        cumulativeSubtotal += addedPrice;
        product.setQuantity(remainingQuantity);
        cartItem.addItemSubtotal(addedPrice);
        cartItem.addDesiredQuantity(quantity);

        if(!cartItem.isExist)  items.add(cartItem);
        cartItem.setExist(true);


        System.out.println("** CART ADD ITEM SUCCESSFUL **");
        System.out.println("ITEM SUBTOTAL: " + cartItem.getDesiredQuantity()
                + "x " + cartItem.getProductName() + "\t" + cartItem.getItemSubtotal());
        System.out.println("CURRENT SUBTOTAL: " + cumulativeSubtotal);
        System.out.println("** END DETAILS **\n");

        return true;
    }

    //returns cart item reference if an existing item with the same product exists
    private CartItem getExisting(Product desiredProduct) {
        for (CartItem item : items) {
            if (item.getProduct().equals(desiredProduct)) {
                return item;
            }
        }

        return null;
    }

    public ArrayList<CartItem> checkShippable()
    {
        ArrayList<CartItem> shippableItems = new ArrayList<>();
        boolean found = false;
        for (CartItem item : items) {
            if (item.isShippable()) {
                needsShipping = true;
                found = true;
                shippableItems.add(item);
            }
        }

        if(found)
        {
            return shippableItems;
        }
        needsShipping = false;
        return null;
    }

    //list item count, item name and their subtotal price
    public void listAllItems() {
        for (CartItem cartItem : items) {
            //to make all items have equal spacing with price
            String line = String.format("%dx %-25s %.2f",
                    cartItem.getDesiredQuantity(),
                    cartItem.getProductName(),
                    cartItem.getItemSubtotal());
            System.out.println(line);

        }
    }

    public void listShippableItems()
    {
        double totalWeight = 0.0;
        for (CartItem cartItem : items) {
            if (cartItem.isShippable()) {
                Shippable shippableItem = (Shippable) cartItem.getProduct();
                double currentWeight = shippableItem.getWeight() * cartItem.getDesiredQuantity();
                totalWeight += currentWeight;
                String line = String.format("%dx %-25s %.2fkg",
                        cartItem.getDesiredQuantity(),
                        cartItem.getProductName(),
                        currentWeight);
                System.out.println(line);
            }
        }
        System.out.println("Total Package Weight " + totalWeight + "kg");
    }

    public void resetCart()
    {
        this.items = new ArrayList<>();
        cumulativeSubtotal = 0.0;
        needsShipping = false;
    }
}
