package shopping;

import products.Product;
import products.categories.Expirable;
import products.categories.Shippable;

public class CartItem {

    private Product desiredProduct; //reference to the desired product
    private float itemSubtotal = 0;
    private int desiredQuantity = 0;

   public boolean isExist = false;

    CartItem(Product product, int desiredQuantity)
    {
        this.desiredProduct = product;
        this.desiredQuantity = desiredQuantity;
    }

    CartItem(Product product)
    {
        this.desiredProduct = product;
        this.desiredQuantity = 0;
    }



    public boolean isShippable()
    {
        return desiredProduct instanceof Shippable;
    }

    public boolean isExpirable()
    {
        return desiredProduct instanceof Expirable;
    }

    public Product getProduct()
    {
        return desiredProduct;
    }

    public String getProductName()
    {
        return desiredProduct.getName();
    }

    public int getDesiredQuantity() {
        return desiredQuantity;
    }
    public void addDesiredQuantity(int desiredQuantity) {
        this.desiredQuantity += desiredQuantity;

        if(desiredQuantity <= 0)
        {
            isExist = false;
        }
    }

    public void addItemSubtotal(double itemSubtotal) {
        this.itemSubtotal += itemSubtotal;
    }
    public float getItemSubtotal() {
        return itemSubtotal;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
