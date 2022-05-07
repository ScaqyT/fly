package com.xxxx.flyserver.pojo;

/**
 * @program: fly
 * @description: 消息状态
 * @author: cxf
 * @create: 2022-01-26 16:39
 **/
public class MailConstants {
    //消息投递中
    public static final Integer DELIVERING = 0;
    //消息投递成功
    public static final Integer SUCCESS = 1;
    //消息投递失败
    public static final Integer FAILURE = 2;
    //最大重试次数
    public static final Integer MAX_TRY_COUNT = 3;
    //消息超过时间
    public static final Integer MSG_TIMEOUT = 1;
    //队列
    public static final String MAIL_QUEUE_OPERATION = "mail.queue.operation";
    public static final String MAIL_QUEUE_PO = "mail.queue.po";
    public static final String MAIL_QUEUE_ORDER = "mail.queue.order";
    //交换机
    public static final String MAIL_EXCHANGE_NAME = "mail.exchang";
    //创建托运单
    public static final String MAIL_ROUTING_KEY_OPERATION = "mail.routing.key.operation";
    //货物入库
    public static final String MAIL_ROUTING_KEY_PO = "mail.routing.key.po";
    //货物出库
    public static final String MAIL_ROUTING_KEY_ORDER = "mail.routing.key.order";
}