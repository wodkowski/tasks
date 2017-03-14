package pl.wodkowski.job.interview.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import pl.wodkowski.job.interview.service.JMSMessageSender;

@Configuration
public class ActiveMqConfiguration {

	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	@Bean
	public CachingConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(amqConnectionFactory());
	}

	@Bean
	public ActiveMQTopic destination() {
		return new ActiveMQTopic("Example.Library.Publication");
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(destination());
		return jmsTemplate;
	}

	@Bean
	public JMSMessageSender jmsMessageSender() {
		return new JMSMessageSender();
	}

}
