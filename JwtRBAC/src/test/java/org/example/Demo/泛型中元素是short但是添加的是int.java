package org.example.Demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author redA
 * @时间: 2024年10月19日 下午11:06
 */
public class 泛型中元素是short但是添加的是int {
    public static void main(String[] args) {
        Set<Short> s = new HashSet<>();
//        s.add(1);这里就无法添加添加int类型的元素，因为泛型中元素是short类型的，同时add方法的参数就是泛型
        for (Short i = 0; i < 10; i++) {
//
            s.add(i);
//          这里的remove的参数是object 类型，所以可以传入int类型的元素，但是会自动转换成Short类型的元素
            s.remove(i-1);
        }
        System.out.println(s.size());
    }
}