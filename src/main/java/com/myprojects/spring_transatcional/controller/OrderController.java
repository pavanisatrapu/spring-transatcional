package com.myprojects.spring_transatcional.controller;

import com.myprojects.spring_transatcional.dto.OrderRequest;
import com.myprojects.spring_transatcional.dto.OrderResponse;
import com.myprojects.spring_transatcional.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

    private OrderServiceImpl orderServiceImpl;

    @PostMapping("/place-order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderServiceImpl.placeOrder(orderRequest));
    }
}

