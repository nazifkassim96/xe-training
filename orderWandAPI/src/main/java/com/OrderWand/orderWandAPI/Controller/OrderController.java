package com.OrderWand.orderWandAPI.Controller;

import com.OrderWand.orderWandAPI.Entity.Order;
import com.OrderWand.orderWandAPI.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://localhost:8074/"})
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    private Order order = new Order();

    private OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @GetMapping("/orderList")
    
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }

    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable(value="wizardID")long id){
        orderRepository.deleteById(id);
    }

    @PutMapping("update/{orderId}")
    public void updateOrder(@RequestBody Order order){
        orderRepository.save(order);
    }
}
