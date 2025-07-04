# E-Commerce System Design – Fawry Quantum Internship Challenge

This repository contains a Java-based solution for the **Fawry Rise Journey Full-Stack Development Internship Challenge**. The project demonstrates a simplified e-commerce system designed using core **Object-Oriented Programming (OOP)** principles to manage products, customers, and shopping cart functionality.

---

## 🚀 Core Features

### 🛒 Product Management

* Defines products with `name`, `price`, and `quantity`.
* Differentiates between various product types:

  * **Expirable Products**: e.g., food items with expiration dates.
  * **Shippable Products**: e.g., physical goods with weight.
  * **Digital Products**: non-expirable, non-shippable items.

### 🧺 Shopping Cart

* Customers can add products to their cart.
* Quantity validation ensures the requested amount does not exceed available stock.

### 💳 Checkout Process

* Calculates subtotal, shipping fees, and final total.
* Validations include:

  * Empty cart
  * Insufficient customer balance
  * Expired or out-of-stock products

### 🚚 Shipping Integration

* Collects all shippable items and sends them to a simulated `ShippingService`, using a consistent `Shippable` interface.

---

## 🧱 Object-Oriented Design

This project demonstrates all **four pillars of OOP**:

### 1. Abstraction & Inheritance

* An abstract `Product` class defines shared fields (`name`, `price`, `quantity`).
* Subclasses extend `Product` to define specific behavior:

  * `FoodProduct`: adds `expirationDate`.
  * `PhysicalProduct`: adds `weight`.
  * `DigitalProduct`: inherits as-is.

### 2. Interfaces for Behavior

* `Expirable`: provides `isExpired()` (used by `FoodProduct`).
* `Shippable`: provides `getWeight()` and `getName()` (used by `FoodProduct` and `PhysicalProduct`).
* This design supports multiple behaviors without complex inheritance.

### 3. Encapsulation

* All class fields are private and accessed via getters/setters.
* Ensures state integrity (e.g., stock quantity cannot be modified directly).

### 4. Polymorphism

* The `Cart` class holds a list of `CartItem` objects that contain any `Product` type.
* Supports behavior-based processing using polymorphic methods and `instanceof` checks.

---

## 📁 Project Structure

```
src/
├── customer/
│   └── Customer.java
├── products/
│   ├── DigitalProduct.java
│   ├── Expirable.java
│   ├── FoodProduct.java
│   ├── PhysicalProduct.java
│   ├── Product.java
│   └── Shippable.java
├── shopping/
│   ├── Cart.java
│   ├── CartItem.java
│   ├── CheckoutHandler.java
│   └── ShippingService.java
└── Main.java
```

---

## ✅ Assumptions

* **Shipping Fee**: Calculated as **14% of the total price** or **\$10**, whichever is less.
* **Cart Item Removal**: The provided specification does not mention removing items from the cart. While implementable, it is treated as a future enhancement.

---

### 📺 Demo Video

[![Watch the demo](https://img.youtube.com/vi/abcd1234XYZ/hqdefault.jpg)](https://www.youtube.com/watch?v=abcd1234XYZ)

---

## 💻 Development Environment

This project was developed using **IntelliJ IDEA**, and it's **recommended** to run it using the same environment for best experience:

* Automatic build configuration
* Syntax highlighting and code navigation
* Easier execution of the `Main` class

> If you prefer running it manually via the terminal, follow the steps below.

---

## 🔧 How to Run (Manual)

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Compile all Java files:**

   ```bash
   javac src/**/*.java
   ```

3. **Run the main class:**

   ```bash
   java -cp src Main
   ```

---

## 📤 Expected Console Output

The output includes:

* ✅ Successful checkout receipts
* 📦 Shipping confirmations for shippable products
* ❌ Error messages for all validation failures and edge cases

---

## 📎 License

This project was developed as part of the **Fawry Rise Journey Internship Challenge** and is intended for educational and evaluative purposes.

---

## Contact  

Have feedback or want to collaborate? Feel free to connect:  

- **GitHub** – [linzi-v7](https://github.com/linzi-v7)  
- **LinkedIn** – [Faris Osama](https://www.linkedin.com/in/faris-osama-7a3496303/)  

---

### 📌 Project Status: **Submitted** 🚀
