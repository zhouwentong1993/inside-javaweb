package com.puhui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wentong on 2016/4/11.
 */
@ComponentScan("com.puhui")
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = null;
        try
        {
            context = SpringApplication.run(Application.class, args);
        }
        finally
        {
            if (context != null) {
                context.close();
            }
        }
    }


}
