#### assignment-java-boot-camp

#### Swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

#### API
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
