package com.xxxx;

import com.xxxx.flyserver.pojo.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: fly
 * @description:
 * @author: cxf
 * @create: 2022-04-21 23:01
 **/
@SpringBootApplication
public class FlyMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlyMailApplication.class,args);
    }

    @Bean
    public Queue operationQueue(){
        return new Queue(MailConstants.MAIL_QUEUE_OPERATION);
    }
    @Bean
    public Queue poQueue(){
        return new Queue(MailConstants.MAIL_QUEUE_PO);
    }
    @Bean
    public Queue orderQueue(){
        return new Queue(MailConstants.MAIL_QUEUE_ORDER);
    }
}
