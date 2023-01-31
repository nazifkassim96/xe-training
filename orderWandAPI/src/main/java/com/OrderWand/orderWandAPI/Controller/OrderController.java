package com.OrderWand.orderWandAPI.Controller;

import com.OrderWand.orderWandAPI.Entity.Order;
import com.OrderWand.orderWandAPI.Entity.magicPojo;
import com.OrderWand.orderWandAPI.Entity.wizardPojo;
import com.OrderWand.orderWandAPI.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"https://localhost:8074/"})
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    private Order order = new Order();
    wizardPojo WizardPojo;
    magicPojo MagicPojo;

    String urlWizard = "http://localhost:8075/api/wizardList";
    String urlMagicWand = "http://localhost:8072/api/magicWandList";

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/getAllWizardOrder")
    public String getAllWizards(){
        try{
            String responseFromWizard = restTemplate.getForObject(urlWizard, String.class);
            return responseFromWizard;
        }catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/getAllMagicOrder")
    public String getAllMagics(){
        try{
            String responseFromMagic = restTemplate.getForObject(urlMagicWand, String.class);
            return responseFromMagic;
        }catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/getListOrders")
    public  List<Order> getOrderList(){
        return orderRepository.findAll();
    }

    @GetMapping("/getWizardOrder")
    public List<wizardPojo> getWizardOrder(){
        ResponseEntity<List<wizardPojo>> responseWizard = restTemplate.exchange(urlWizard, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<wizardPojo>>() {
        });
        List<wizardPojo> activeWizard = new ArrayList<>();

        for(wizardPojo WizardPojo : responseWizard.getBody()){
            if(WizardPojo.getWizard_activeStatus().equals("Y")){
                activeWizard.add(WizardPojo);
            }
        }
        return activeWizard;
    }

    @PostMapping("/addWizardsOrder")
    public String addWizardOrder(@RequestBody Order order){
        ResponseEntity<List<wizardPojo>> responseWizard = restTemplate.exchange(urlWizard, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<wizardPojo>>() {
                });
        ResponseEntity<List<magicPojo>> responseMagic= restTemplate.exchange(urlMagicWand, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<magicPojo>>() {
                });

        String infoException = "";

        for (wizardPojo WizardPojo : responseWizard.getBody()) {

//            log.info(String.valueOf(WizardPojo.getWizard_id()));
//            log.info(String.valueOf(order.getWizard_id()));
//            log.info(String.valueOf(WizardPojo.getWizard_activeStatus()));
            log.info(String.valueOf(WizardPojo.getWizard_age()));
            log.info(String.valueOf(WizardPojo.getWizard_id()));
            log.info(String.valueOf(WizardPojo.getWizard_name()));


            if (WizardPojo.getWizard_id() == order.getWizard_id() && WizardPojo.getWizard_activeStatus().equals("Y")) {
                order.setWizard_name(WizardPojo.getWizard_name());
                order.setWizard_age(WizardPojo.getWizard_age());
                order.setJoinedDate(WizardPojo.getJoinedDate());
                order.setWizard_activeStatus(WizardPojo.getWizard_activeStatus());

                for(magicPojo MagicPojo : responseMagic.getBody()){

//                    log.info(String.valueOf(MagicPojo.getMagicWand_id()));
//                    log.info(String.valueOf(order.getMagicWand_id()));
//                    log.info(String.valueOf(MagicPojo.getAgeLimit()));
//                    log.info(String.valueOf(MagicPojo.getStockWand()));
                    if (MagicPojo.getMagicWand_id() == order.getMagicWand_id() && WizardPojo.getWizard_age() <= MagicPojo.getAgeLimit() && MagicPojo.getStockWand() > 0) {
                        order.setMagicWandName(MagicPojo.getMagicWandName());
                        order.setDescriptionWand(MagicPojo.getDescriptionWand());
                        order.setAgeLimit(MagicPojo.getAgeLimit());
                        order.setStockWand(MagicPojo.getStockWand());
                        orderRepository.save(order);
                        WizardPojo.equals(null);
                        MagicPojo.equals(null);
                        return infoException = "Order created successfully";
                    }
                }
            }
            WizardPojo.equals(null);
            return infoException = "Invalid Wand ID";
        }
        return infoException;
    }



}
