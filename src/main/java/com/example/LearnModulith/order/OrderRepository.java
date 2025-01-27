package com.example.LearnModulith.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findOrderByOrderIdentifier(String orderIdentifier);
}
