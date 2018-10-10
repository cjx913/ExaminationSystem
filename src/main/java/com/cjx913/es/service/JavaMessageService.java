package com.cjx913.es.service;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.Message;

import com.cjx913.es.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;


public interface JavaMessageService {

	public static final String QUEUE_MESSAGE_LISTENER_CONTAINER  ="queueMessageListenerContainer";
	public static final String TOPIC_MESSAGE_LISTENER_CONTAINER  ="topicMessageListenerContainer";
	
	public abstract void snedMessageToPublicTopic(Serializable message) throws CustomException;

	public abstract void receiveMessageFromPublicTopic(Serializable message) throws CustomException;

	public void receiveMsg(String msg);
}
