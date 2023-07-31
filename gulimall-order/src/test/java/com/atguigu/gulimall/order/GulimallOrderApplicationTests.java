package com.atguigu.gulimall.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallOrderApplicationTests {

    @Resource
    private AmqpAdmin amqpAdmin;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void createExchange() {

        amqpAdmin.declareExchange(new DirectExchange("hell-java-exchange", true, false));
        log.info("Exchange[{}]创建成功", "hell-java-exchange");
    }

    @Test
    public void createqueue() {

        amqpAdmin.declareQueue(new Queue("hell-java-queue", true, false, false));
        log.info("Exchange[{}]创建成功", "hell-java-queue");
    }

    @Test
    public void createBind() {
        Binding binding = new Binding("hell-java-queue", Binding.DestinationType.QUEUE, "hell-java-exchange", "hello-java", null);
        amqpAdmin.declareBinding(binding);
        log.info("Exchange[{}]创建成功", "hell-java-queue");
    }

    @Test
    public void sendTest() {
        rabbitTemplate.convertAndSend("hell-java-exchange","hello-java","hello cxk");
    }


}
