package shoppingcart.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shoppingcart.ShoppingCartApplication;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = ShoppingCartApplication.class)
public class ShoppintCartServerTest {

    @Autowired
    ShoppingCartService shoppingCartService;


    @Test
    public void getPricebyId(){

        assertEquals(300.0, shoppingCartService.getPricebyId("OH"),0.1);
        assertEquals(30.0, shoppingCartService.getPricebyId("SK"),0.1);
        assertEquals(110.0, shoppingCartService.getPricebyId("BC"),0.1);

    }

    @Test
    public void totalPrice(){

        String[] tourComb1 ={"OH","OH","OH","SK"};
        String[] tourComb2 ={"OH","SK"};
        String[] tourComb3 ={"OH","OH","OH","OH"};
        String[] tourComb4 ={"BC","BC","BC","BC","BC"};

        assertEquals(630.0, shoppingCartService.totalPrice(tourComb1),0.1);
        assertEquals(300.0, shoppingCartService.totalPrice(tourComb2),0.1);
        assertEquals(900.0, shoppingCartService.totalPrice(tourComb3),0.1);
        assertEquals(460.0, shoppingCartService.totalPrice(tourComb4),0.1);
    }

}
