package com.myprojects.spring_transatcional.service;

import com.myprojects.spring_transatcional.dto.OrderRequest;
import com.myprojects.spring_transatcional.dto.OrderResponse;
import com.myprojects.spring_transatcional.entity.Order;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
