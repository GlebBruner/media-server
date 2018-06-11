package ua.nure.mediaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.mediaserver.domain.Order;
import ua.nure.mediaserver.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {

    }

    public void createOrder() {

    }

}
