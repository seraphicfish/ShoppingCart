package shoppingcart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * domain class for tour
 */
@Entity
@Getter
@Setter
@Table(name="tour")
public class Tour {
  @Id
  private String id;
  private String name;
  private double price;
}
