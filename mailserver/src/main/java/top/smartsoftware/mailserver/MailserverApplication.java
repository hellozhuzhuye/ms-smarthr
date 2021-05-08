package top.smartsoftware.mailserver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import top.smartsoftware.smarthr.model.MailConstants;
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableRabbit
public class MailserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailserverApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(MailConstants.MAIL_QUEUE_NAME);
	}
}
