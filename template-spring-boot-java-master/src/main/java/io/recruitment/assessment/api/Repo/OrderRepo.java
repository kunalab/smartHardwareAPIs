package io.recruitment.assessment.api.Repo;

import io.recruitment.assessment.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM orders o WHERE o.user_id=?1")
    Optional<Order>findOrderByUserID(Integer userId);
}
