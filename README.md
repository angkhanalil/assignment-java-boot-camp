#### assignment-java-boot-camp

- [x] mvn clean test
- [x] mvn test  
- [x] mvn clean
- [x] mvn compile
- [x] mvn spring-boot:run

#### Swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

#### URL
| Method  | URL  | Description | Input | Output |
|-------------| ------------- | ------------- | ------------- | ------------- |
|`User `|
|GET| /SignIn  | SignIn Email |||
|GET| /user/{id}  | Get user detail with id |||
|`Product `|
|GET| /product  | Get Product all  |||
|GET| /product/productname/{productname}  | Search Products by Name  |||
|GET| /product/{id}  |   Show Product Detail by id  |||
|`Add To Cart `|
|POST| /cart  | Add Product to Cart  |||
|`Show Data in Basket`|
|GET| /cart/{userid}  | Show Basket  |||
