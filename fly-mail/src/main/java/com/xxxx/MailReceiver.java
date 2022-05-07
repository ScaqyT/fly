package com.xxxx;

import com.rabbitmq.client.Channel;
import com.xxxx.flyserver.pojo.MailConstants;
import com.xxxx.flyserver.pojo.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.springframework.messaging.Message;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;


/**
 * @program: fly
 * @description: 邮件发送者
 * @author: cxf
 * @create: 2022-04-21 23:05
 **/
@Component
public class MailReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(queues = MailConstants.MAIL_QUEUE_OPERATION)
    public void handler(Message message, Channel channel){
        Operation operation = (Operation) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        //消息序号
        long tag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        HashOperations hashOperations = redisTemplate.opsForHash();


        try {
            if(hashOperations.entries("mail_key").containsKey(msgId)){
                LOGGER.error("{}==============>消息已被消费",msgId);
                /**
                 *
                 *tag:消息序号
                 * b:是否消费多条
                 */
                channel.basicAck(tag,false);
                return;
            }
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);

            helper.setFrom(mailProperties.getUsername());
            String[] To = {operation.getCustomer().getMail(),operation.getSupplier().getMail()};
            helper.setTo(To);
            helper.setSubject("托运单创建通知");
            helper.setSentDate(new Date());

            Context context = new Context();
//            context.setVariable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
