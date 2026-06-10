# HackerRank Challenge: Spring Basic Config Properties

## Task

Create a simple Spring Java application to calculate final product price using configurable discount and tax values.

Requirements

- Create a class Product with fields:
```java
String name;
double price;
int quantity;
double discountPercentage;
```

- Create config properties from application.properties:

```yaml
product.default-discount=5
product.tax-percentage=11
```

- Create ProductConfig using:

```java
@ConfigurationProperties(prefix = "product")
```

- Create ProductService with method:

```java
double calculateFinalPrice(Product product)
```

Business Rules

* If price < 0, throw IllegalArgumentException
* If quantity <= 0, throw IllegalArgumentException
* If discountPercentage < 0 or discountPercentage > 100, throw IllegalArgumentException
* If discountPercentage == 0, use product.default-discount
* Apply tax after discount

Formula:

```text
subtotal = price * quantity
discount = subtotal * discountPercentage / 100
afterDiscount = subtotal - discount
tax = afterDiscount * taxPercentage / 100
finalPrice = afterDiscount + tax
```

Example

- Input:

```java
Product product = new Product("Milk", 10000, 2, 0);
```

- Config:

```yaml
product.default-discount=5
product.tax-percentage=11
```

Output:

```21090.0```

Expected Deliverables

* Product.java
* ProductConfig.java
* ProductService.java
* Unit tests for valid and invalid cases.
