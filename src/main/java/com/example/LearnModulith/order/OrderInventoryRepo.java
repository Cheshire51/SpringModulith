package com.example.LearnModulith.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

interface OrderInventoryRepo extends CrudRepository<OrderInventory, Long> {
    @Query(nativeQuery = true, value = "SELECT SUM(oi.total_qty_price) FROM order_inventory oi where oi.order_id = ?1")
    long orderInventoryAmount(Long orderId);
}
