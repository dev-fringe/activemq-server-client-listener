package dev.fringe.activemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.JmsListener;

import dev.fringe.activemq.config.ActiveMqCommonConfig;
import dev.fringe.activemq.config.ActiveMqListenerConfig;
import dev.fringe.activemq.model.Email;


@Import(value = {ActiveMqCommonConfig.class, ActiveMqListenerConfig.class})
public class Listener {

    @JmsListener(destination = "mailbox", containerFactory  = "listenerFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
        
    }
    
    @JmsListener(destination = "mailbox", containerFactory  = "listenerFactory2")
    public void receiveMessage2(Email email) {
        System.out.println("Received <" + email + ">");
        
    }
    public static void main(String[] args) {
    	new AnnotationConfigApplicationContext(Listener.class);   
    }
}
