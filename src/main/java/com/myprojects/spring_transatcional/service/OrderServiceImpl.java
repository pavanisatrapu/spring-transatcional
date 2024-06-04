package com.myprojects.spring_transatcional.service;

import com.myprojects.spring_transatcional.dto.OrderRequest;
import com.myprojects.spring_transatcional.dto.OrderResponse;
import com.myprojects.spring_transatcional.entity.Order;
import com.myprojects.spring_transatcional.entity.Payment;
import com.myprojects.spring_transatcional.exceptions.PaymentCardException;
import com.myprojects.spring_transatcional.repository.OrderRepository;
import com.myprojects.spring_transatcional.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order=orderRequest.getOrder();
        order.setStatus("in progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        Payment payment=orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentCardException(payment.getType()+" this card not acceptable");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }

}
