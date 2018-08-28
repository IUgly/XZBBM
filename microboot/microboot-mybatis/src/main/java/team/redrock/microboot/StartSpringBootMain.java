package team.redrock.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
//@EnableTransactionManagement
//public class StartSpringBootMain {
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(StartSpringBootMain.class, args);
//    }
//
//}
@SpringBootApplication // 启动SpringBoot程序，而后自带子包扫描
@ServletComponentScan
@ComponentScan("team.redrock.microboot")
public class StartSpringBootMain extends SpringBootServletInitializer { // 必须继承指定的父类
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(StartSpringBootMain.class) ;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartSpringBootMain.class, args);
    }
}

