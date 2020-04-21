package com.skp.spring.listener;

import com.skp.spring.model.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-producer", groupId = "group_id")
    public void consume(String message){
        System.out.println("message consumed" + message);
    }

    @KafkaListener(topics="kafka-customer", groupId = "group_customer",
            containerFactory ="customerKafkaListenerContainerFactory" )
    public void consumeCustomer(Customer customer){
        System.out.println("message consumed" +customer);
    }
}
