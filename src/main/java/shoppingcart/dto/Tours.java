package shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * This is the tours customer enter
 */
@Getter
@Setter
public class Tours implements Serializable {
    String[] tours;
}
