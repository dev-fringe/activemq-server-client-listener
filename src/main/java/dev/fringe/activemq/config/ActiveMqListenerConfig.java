package dev.fringe.activemq.config;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
@EnableJms
public class ActiveMqListenerConfig {

	@Bean
	public DefaultJmsListenerContainerFactory listenerFactory(ConnectionFactory connectionFactory, MessageConverter jacksonJmsMessageConverter) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jacksonJmsMessageConverter);
		return factory;
	}
}