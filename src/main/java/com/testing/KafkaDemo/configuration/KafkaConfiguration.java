package com.testing.KafkaDemo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("customer", 3, (short) 1);
    }
}

