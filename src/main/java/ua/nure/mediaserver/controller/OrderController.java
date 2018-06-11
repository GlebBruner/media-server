package ua.nure.mediaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.mediaserver.domain.Order;
import ua.nure.mediaserver.domain.dto.OrderDTO;
import ua.nure.mediaserver.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Order>> gelAllOrders() {

    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {

    }

}
