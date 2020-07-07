package dev.fringe.activemq.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
public class ActiveMqClientConfig {

	@Bean
	public JmsTemplate jmsTemplate(MessageConverter jacksonJmsMessageConverter, ConnectionFactory connectionFactory) {
		JmsTemplate template = new JmsTemplate();
		template.setMessageConverter(jacksonJmsMessageConverter);
		template.setConnectionFactory(connectionFactory);
		template.setDefaultDestination(new ActiveMQQueue("ps"));
		return template;
	}
	
}