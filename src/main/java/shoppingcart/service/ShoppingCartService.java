package shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcart.dao.TourRepository;

/**
 * This class is used to caculate the total price for the shopping
 */
@Service
public class ShoppingCartService {
    @Autowired
    private TourRepository tourRepository;

    /**
     * get the price from database base on the different tour
     * @param id tour id
     * @return tour price
     */
    public double getPricebyId(String id) {
        return tourRepository.findTour(id).getPrice();
    }


    /**
     * get the total tour shopping price
     * @param ids order tours Ids
     * @return total price
     */
    public double totalPrice(String[] ids) {
        int countOH = 0;
        int countBC = 0;
        int countSK = 0;
        double totalPrice = 0;


        for (String o : ids) {
            if ("OH".equals(o)) {
                countOH += 1;
            } else if ("BC".equals(o)) {
                countBC += 1;
            } else if ("SK".equals(o)) {
                countSK += 1;
            } else {
                throw new RuntimeException("this is an invalid option");
            }
        }
        if (countOH <3) {
            if (countOH != 0 && countSK != 0) {

                if (countSK == countOH) {
                    totalPrice = countOH * getPricebyId("OH");
                } else if (countSK > countOH) {
                    totalPrice = countOH * getPricebyId("OH") + (countSK - countOH) * getPricebyId("SK");
                } else {
                    totalPrice = countSK * getPricebyId("OH") + (countOH - countSK) * getPricebyId("OH");

                }

            }
            totalPrice = getPricebyId("OH") * countOH;
        } else {
            int divider = countOH / 3;
            int remainder = countOH % 3;

            if (remainder != 0 || countSK != 0) {

                if (countSK == remainder) {
                    totalPrice = remainder * getPricebyId("OH");
                } else if (countSK > remainder) {
                    totalPrice = remainder * getPricebyId("OH") + (countSK - remainder) * getPricebyId("SK");
                } else {
                    totalPrice = countSK * getPricebyId("OH") + (remainder - countSK) * getPricebyId("OH");

                }

            }
            totalPrice = totalPrice + getPricebyId("OH") * divider * 2;
        }
        if (countBC > 4) {
            totalPrice = totalPrice + 4 * getPricebyId("BC") + (countBC - 4) * 20;
        } else {
            totalPrice = totalPrice + countBC * getPricebyId("BC");
        }
        return totalPrice;
    }
}

