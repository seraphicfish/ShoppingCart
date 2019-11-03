package shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcart.dto.Tours;

/**
 * This class is used to calculate the total price for the shopping
 */
@Service
public class TourService {
    @Autowired
    ShoppingCartService shoppingCartService;
    private double totalPrice=0;

    /**
     * Calculate the total price
     * @param tours the tours option customer enters
     * @return total price
     */
    public String getPrice(Tours tours){
        totalPrice= shoppingCartService.totalPrice(tours.getTours());

        return Double.toString(totalPrice);
    }
}
