package org.example.autowireddifresource;

/**
 * @author redA
 * @时间: 2024年10月24日 下午12:10
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MyServiceAutowired {

    @Autowired
    private List<MyBean> myBeans; // 按类型注入所有 MyBean 实例

    @Autowired
    private Map<String, MyBean> myBeansMap; // 按类型注入，键为 bean 名称

    public void printBeans() {
        System.out.println("Using @Autowired with List:");
        for (MyBean bean : myBeans) {
            System.out.println(bean.getName());
        }

        System.out.println("Using @Autowired with Map:");
        for (Map.Entry<String, MyBean> entry : myBeansMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Bean: " + entry.getValue().getName());
        }
    }
}
