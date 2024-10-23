package org.example.autowireddifresource;

/**
 * @author redA
 * @时间: 2024年10月24日 下午12:11
 */
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MyServiceResource {

    @Resource
    private List<MyBean> myBeans; // 默认按名称查找，可能导致注入失败

    @Resource
    private Map<String, MyBean> myBeansMap; // 默认按名称查找

    public void printBeans() {
        System.out.println("Using @Resource with List:");
        for (MyBean bean : myBeans) {
            System.out.println(bean.getName());
        }

        System.out.println("Using @Resource with Map:");
        for (Map.Entry<String, MyBean> entry : myBeansMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Bean: " + entry.getValue().getName());
        }
    }
}
