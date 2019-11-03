package shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shoppingcart.dto.Tours;
import shoppingcart.service.ShoppingCartService;
import shoppingcart.service.TourService;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    TourService tourService;

    @PostMapping("/tours")
    public ResponseEntity<String> getToursPrice(@RequestBody Tours body){

        String price = tourService.getPrice(body);
        return ResponseEntity.ok().body(price);
    }

}
