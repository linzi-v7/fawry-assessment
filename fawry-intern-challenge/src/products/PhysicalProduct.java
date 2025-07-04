package products;

import products.categories.Shippable;

//represents products that are shippable but not expirable like TV
//so most phyiscal products except expirable products like food/medicine.
public class PhysicalProduct extends Product implements Shippable {

    double weight;
    public PhysicalProduct(String name, float price, int quantity, double weight)
    {
        super(name,price,quantity);
        this.weight = weight;
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
}
