package pl.wodkowski.job.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JMSMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendText(final String text) {
		this.jmsTemplate.convertAndSend(text);
	}

}