package shoppingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shoppingcart.domain.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query("select tour from Tour tour where tour.id=:id ")
    Tour findTour(@Param("id")String id);
}
