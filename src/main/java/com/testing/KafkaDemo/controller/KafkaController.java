package com.testing.KafkaDemo.controller;

import com.testing.KafkaDemo.dto.Customer;
import com.testing.KafkaDemo.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producer;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody Customer customer) {
        try {
            producer.sendEvent(customer);
            return ResponseEntity.ok("Message send successfully.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}

