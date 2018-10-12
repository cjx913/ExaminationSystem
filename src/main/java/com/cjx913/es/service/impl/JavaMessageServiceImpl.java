package com.cjx913.es.service.impl;

import com.cjx913.es.entity.domain.CustomMessage;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.JavaMessageService;
import com.cjx913.es.websocket.CustomWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;

@Service
@Transactional
@EnableJms
public class JavaMessageServiceImpl  implements JavaMessageService {

    @Autowired
    private JmsTemplate jmsQueueTemplate;

    @Autowired
    private JmsTemplate jmsTopicTemplate;

//    @Autowired
//    private CustomWebSocketHandler customWebSocketHandler;

    @Override
    public void snedMessageToPublicTopic(Serializable message) throws CustomException {
        jmsTopicTemplate.convertAndSend("publicTopic", message);
    }

//    @Override
//    @JmsListener(containerFactory = TOPIC_MESSAGE_LISTENER_CONTAINER, destination = "publicTopic")
//    public void receiveMessageFromPublicTopic(Serializable message) throws CustomException {
//        if (message instanceof CustomMessage) {
//            CustomMessage customMessage = (CustomMessage) message;
//            customWebSocketHandler.sendMessageToClient(customMessage);
//        }
//    }

    @Override
    @JmsListener(containerFactory = QUEUE_MESSAGE_LISTENER_CONTAINER, destination = "publicQueue")
    public void receiveMsg(String msg) {
        System.out.println(msg);

    }

}
