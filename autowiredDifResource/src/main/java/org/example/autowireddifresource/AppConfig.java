package org.example.autowireddifresource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean1() {
        return new MyBean("Bean 1");
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean("Bean 2");
    }
    public MyBean myBean3() {
        return new MyBean("Bean 3");
    }
    public MyBean myBean4() {
        return new MyBean("Bean 4");
    }

    @Bean
    public List<MyBean> myBeans() {
        List<MyBean> beans = new ArrayList<>();
        beans.add(myBean3());
        beans.add(myBean4());
        return beans;
    }

    @Bean
    public Map<String, MyBean> myBeansMap() {
        Map<String, MyBean> map = new HashMap<>();
        map.put("bean3", myBean3());
        map.put("bean4", myBean4());
        return map;
    }
}
