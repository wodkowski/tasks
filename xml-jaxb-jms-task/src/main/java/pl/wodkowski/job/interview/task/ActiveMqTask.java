package pl.wodkowski.job.interview.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.wodkowski.job.interview.config.ActiveMqConfiguration;
import pl.wodkowski.job.interview.service.JMSMessageSender;

public class ActiveMqTask {
	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = UnmarshallingTask.class.getClassLoader();
		File file = new File(classLoader.getResource("excercise/excercise-1.xml").getFile());

		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = in.readLine()) != null) {
			sb.append(line).append("\n");
		}
		in.close();

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ActiveMqConfiguration.class);
		JMSMessageSender jmsMessageSender = ctx.getBean(JMSMessageSender.class);
		jmsMessageSender.sendText(sb.toString());
		ctx.close();
	}
}
