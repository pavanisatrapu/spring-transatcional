package com.myprojects.spring_transatcional.dto;

import com.myprojects.spring_transatcional.entity.Order;
import com.myprojects.spring_transatcional.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
