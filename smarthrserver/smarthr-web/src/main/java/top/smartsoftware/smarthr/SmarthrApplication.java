package top.smartsoftware.smarthr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "top.smartsoftware.smarthr.mapper")
public class SmarthrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmarthrApplication.class, args);
    }

}
