import products.FoodProduct;
import products.PhysicalProduct;
import products.Product;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product cheese = new FoodProduct("Cheese", 2.5F, 5,
                100, LocalDate.of(2025,11,7));

        Product biscuits = new FoodProduct("Biscuits", 1.5F, 10,
                50, LocalDate.of(2025,7,7));

        Product tv = new PhysicalProduct("TV", 50.0F, 5,
                100);

        Product mobile = new PhysicalProduct("Mobile", 100.0F, 5,
                100);

        Product mobileScratchCard = new FoodProduct("Cheese", 2.0F, 5,
                100, LocalDate.of(2025,11,7));

    }
}