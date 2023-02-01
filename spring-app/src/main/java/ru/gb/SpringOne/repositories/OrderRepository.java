package ru.gb.SpringOne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.SpringOne.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
