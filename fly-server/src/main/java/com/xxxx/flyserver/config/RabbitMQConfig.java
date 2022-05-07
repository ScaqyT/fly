package com.xxxx.flyserver.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxxx.flyserver.pojo.MailConstants;
import com.xxxx.flyserver.pojo.MailLog;
import com.xxxx.flyserver.service.IMailLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.ChangedCharSetException;

/**
 * @program: fly
 * @description: rabbitmq配置类
 * @author: cxf
 * @create: 2022-04-11 20:45
 **/
@Configuration
public class RabbitMQConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    private IMailLogService mailLogService;

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);

        rabbitTemplate.setConfirmCallback((data,ack,cause)->{
            String msgId = data.getId();
            if(ack){
                LOGGER.info("{}===========>消息发送成功",msgId);
                mailLogService.update(new UpdateWrapper<MailLog>().set("state",1).eq("msgId",msgId));
            }else{
                LOGGER.error("{}===========>消息发送失败",msgId);
            }
        });

        rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingKey)->{
            LOGGER.error("{}==========>消息发送queue失败",msg.getBody());
        });

        return rabbitTemplate;
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

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(operationQueue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_OPERATION);
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(poQueue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_PO);
    }
    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(orderQueue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_ORDER);
    }
}
