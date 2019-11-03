package shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShoppingCartApplication {
/*    @Autowired
    ShoppingCartService shoppingCartService;*/
    public static void main(String[] args) {

/*
        String[] shoppinglist = {"OH", "SK", "BC"};
        double shoppingCost = shoppingCartService.totalPrice(shoppinglist);
        System.out.println(shoppingCost);*/
        SpringApplication.run(ShoppingCartApplication.class, args);
    }
}
