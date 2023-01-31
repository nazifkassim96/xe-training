//package com.OrderWand.orderWandAPI.Service;
//
//import com.OrderWand.orderWandAPI.Entity.Order;
//import com.OrderWand.orderWandAPI.Repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//public class OrderService {
//
//    @Autowired
//    OrderRepository orderRepository;
//
//    RestTemplate restTemplate = new RestTemplate();
//
//    public Order addOrder(Order order){
//        return orderRepository.save(order);
//    }
//
//    public List<Order> getOrders(){
//        return orderRepository.findAll();
//    }
//
//    public void deleteOrder(Long id){
//        orderRepository.deleteById(id);
//    }
//
//    public Order updateOrder(Order order){
//        return orderRepository.save(order);
//    }
//}
