package dev.fringe.activemq;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.core.JmsTemplate;

import dev.fringe.activemq.config.ActiveMqClientConfig;
import dev.fringe.activemq.config.ActiveMqCommonConfig;
import dev.fringe.activemq.model.Email;

@Configuration
@Import(value = { ActiveMqCommonConfig.class, ActiveMqClientConfig.class })
public class Client implements InitializingBean {

	@Autowired JmsTemplate jmsTemplate;
	@Autowired JmsTemplate jmsTemplate2;

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Client.class);
	}

	public void afterPropertiesSet() throws Exception {
		Email email = new Email();
		email.setToRecipient("info@email.com");
		email.setSubject("Subject");
		email.setEmailBody("Hello");
		try {
			jmsTemplate.convertAndSend("mailbox", email);
		} catch (Exception e) {
			jmsTemplate2.convertAndSend("mailbox", email);
		}
	}
}
