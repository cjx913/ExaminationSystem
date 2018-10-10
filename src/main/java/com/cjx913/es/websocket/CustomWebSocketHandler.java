package com.cjx913.es.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cjx913.es.entity.domain.CustomMessage;
import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.JavaMessageService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class CustomWebSocketHandler extends AbstractWebSocketHandler {
    @Autowired
    private JavaMessageService javaMessageService;

    private static ConcurrentHashMap <String, WebSocketSession> sessionMap = new ConcurrentHashMap <>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        UserIdentity userIdentity = (UserIdentity) session.getPrincipal();
        String userId = userIdentity.getUserid();
        if (userId != null && !sessionMap.containsKey(userId)) {
            sessionMap.put(userId, session);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
    	
        CustomMessage customMessage = JSON.parseObject(textMessage.getPayload(), CustomMessage.class);
        sendMessageToServer(customMessage);
    }

    private void sendMessageToServer(CustomMessage customMessage) throws CustomException {
        javaMessageService.snedMessageToPublicTopic(customMessage);
    }

    public void sendMessageToClient(CustomMessage customMessage) throws CustomException {
        try {
            if (sessionMap.containsKey(customMessage.getTo())) {
                WebSocketSession session = sessionMap.get(customMessage.getTo());
                String json = JSON.toJSONString(customMessage,SerializerFeature.WriteNullStringAsEmpty);
                TextMessage textMessage = new TextMessage(json);
                session.sendMessage(textMessage);
            }
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }
}
