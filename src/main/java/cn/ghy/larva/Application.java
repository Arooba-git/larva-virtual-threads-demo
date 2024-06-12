package cn.ghy.larva;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ziyang
 */
@SpringBootApplication
@MapperScan("cn.ghy.larva.dao")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}