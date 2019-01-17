package com.ifeng.soft.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public Queue Queue(){
    return new Queue("hello zhangfu");
    }
}
