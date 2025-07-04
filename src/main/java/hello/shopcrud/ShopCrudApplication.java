package hello.shopcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"hello.shopcrud.v3"})
@EnableAsync
public class ShopCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCrudApplication.class, args);
    }

}
