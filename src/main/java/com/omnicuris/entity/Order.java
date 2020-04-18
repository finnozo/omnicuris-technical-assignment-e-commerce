package com.omnicuris.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order extends BaseAudit {

    @Column(name = "item_id", nullable = false)
    private Long itemId;
    @Column(name = "number_of_items", nullable = false)
    private Integer numberOfItems;
    @Column(name = "email_id", nullable = false)
    private String emailId;
}
