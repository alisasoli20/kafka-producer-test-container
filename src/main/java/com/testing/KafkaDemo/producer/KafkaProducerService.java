package com.testing.KafkaDemo.producer;

import com.testing.KafkaDemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "customer";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /*public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);
        future.whenComplete((result, ex) -> {
           if(ex == null) {
               System.out.println("Sent message=["+message+"] with offset=["+result.getRecordMetadata().offset()+"]");
           }else{
               System.out.println("Unable to send message=[" + message + "] due to : "+ex.getMessage());
           }
        });
    }*/

    public void sendEvent(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC, customer);
        future.whenComplete((result, ex) -> {
            if(ex == null) {
                System.out.println("Sent message=["+customer.toString()+"] with offset=["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unable to send message=[" + customer.toString() + "] due to : "+ex.getMessage());
            }
        });
    }
}
