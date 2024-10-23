package org.example.autowireddifresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/**
 * autowired注入list和map的时候是先根据类型找到符号的bean然后注入到
 * resource是先根据名字来查找是否符合名字的，然后才是类型
* */
@SpringBootApplication
public class AutowiredDifResourceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AutowiredDifResourceApplication.class, args);

        MyServiceAutowired serviceAutowired = context.getBean(MyServiceAutowired.class);
        serviceAutowired.printBeans();

        MyServiceResource serviceResource = context.getBean(MyServiceResource.class);
        serviceResource.printBeans();
    }

}
