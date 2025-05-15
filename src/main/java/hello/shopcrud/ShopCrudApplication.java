package hello.shopcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"hello.shopcrud.v3"})
public class ShopCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCrudApplication.class, args);
    }

}
