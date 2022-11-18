package br.com.fiap.droneagro.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SenderConfig {

    @Value("${queue.name}")
    private String queue;

    @Bean
    public Queue createQueue() 
    {
        return new Queue(queue, true);
    }
    
}
