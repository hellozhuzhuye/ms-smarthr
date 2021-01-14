package top.smartsoftware.smarthr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableScheduling
@EnableRabbit
@SpringBootApplication
@MapperScan("top.smartsoftware.smarthr.mapper")
public class SmarthrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmarthrApplication.class, args);
    }

}
