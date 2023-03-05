# CV-JAVA-INTERVIEW

> [!INFO]
> This was a code test made in a process with oracle

### Pre Requisites
 - IDE supporting Java
 - Java 11
 - Maven

## Instructions
### Building and running tests
From the command line you can build the project with:
```
mvn clean install
```

And run the tests with:
```
mvn test
```

### Project Description
 * This test is based on a simple retail checkout pipeline
 * A Basket of BasketItems is passed to a CheckoutPipeline
 * The Basket is placed in a CheckoutContext, then passed through a series of CheckoutSteps
 * These steps process and update the basket and the context in order to produce a final bill
