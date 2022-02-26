package com.example.shoppingapi;

import com.example.shoppingapi.Cart.CartRepository;
import com.example.shoppingapi.Shipping.CustomerAddressItemRepository;
import com.example.shoppingapi.customer.CustomerRepository;
import com.example.shoppingapi.model.Cart;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.Product;
import com.example.shoppingapi.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingApiApplication {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressItemRepository customerAddressItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostConstruct
    public void xyz() {

        Customer customer = new Customer();
//        customer.setId();
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");

        Customer cust = customerRepository.save(customer);
        System.out.print("Save");
    }


    @PostConstruct
    void initialize() {
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("adidas ORIGINALS Stan Smith Shoes Women White");
        product1.setPrice(1792.00);
        product1.setBrand("adidas");
        product1.setProductDetails("Despite their history on the tennis courts, you don't need a racket and short shorts to appreciate the clean-cut style of the adidas Stan Smith trainer.");
        product1.setCategory("shoes");
        product1.setSku("");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductid(2);
        product2.setProductName("adidas ORIGINALS NMD_R1");
        product2.setPrice(2576.00);
        product2.setBrand("adidas");
        product2.setProductDetails("Continue the NMD legacy in these adidas NMD_R1 Shoes");
        product2.setCategory("shoes");
        product2.setSku("2282329674_TH-7670241944");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductid(3);
        product3.setProductName("Nike Unisex Sportswear Tie-Dye Bucket Hat - Black");
        product3.setPrice(603.00);
        product3.setBrand("Nike");
        product3.setProductDetails("Nike Unisex Sportswear Tie-Dye Bucket Hat - Black");
        product3.setCategory("Hats & Caps");
        product3.setSku("2393636799_TH-8154833598");
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setProductid(4);
        product4.setProductName("ALAND เสื้อ MARK GONZALES รุ่น ANGEL WAPPEN LONG SLEEVE T-SHIRT");
        product4.setPrice(2160.00);
        product4.setBrand("ALAND");
        product4.setProductDetails(" MARK GONZALES  รุ่น ANGEL WAPPEN LONG SLEEVE T-SHIRT");
        product4.setCategory("Sweaters");
        product4.setSku("2322454554_TH-7846618238");
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setProductid(5);
        product5.setProductName("ALAND เสื้อ BAD IN BAD รุ่น FAT LOGO SWEAT SHIRT KNIT PULL OVER");
        product5.setPrice(2750.00);
        product5.setBrand("ALAND");
        product5.setProductDetails("3.3 FIELD TRIP, ANOTHER A, AGOOD, FENNEC, BAD IN BAD, BAGGU, CHUCK, CLOTTY");
        product5.setCategory("Sweaters");
        product5.setSku("2676542336_TH-9639619841");
        productRepository.save(product5);


        Cart cart = new Cart();
        cart.setCartid(1);
        cart.setItemid(1);
        cart.setItemqty(1);
        cart.setUserid(1);
        cartRepository.save(cart);

    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
        System.out.println("TEST");
    }

}
