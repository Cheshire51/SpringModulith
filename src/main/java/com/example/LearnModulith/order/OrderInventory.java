package com.example.LearnModulith.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
        @Index(name="ord_idx", columnList = "order_id"),
        @Index(name="inv_idx", columnList = "inventory_id")
})
public class OrderInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long orderId;
    private long inventoryId;
    private int quantity;
    private long totalQtyPrice;
}
