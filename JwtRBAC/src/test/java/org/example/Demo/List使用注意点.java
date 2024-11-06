package org.example.Demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author redA
 * @时间: 2024年10月21日 下午4:18
 * @博客： <a href="https://www.cnblogs.com/wuqinglong/p/9760272.html"> </a>
 * @描述：Arrays.asList 产生不可操作的集合, 不能使用remove方法;
 */
public class List使用注意点 {
    @Test
    public void  产生不可操作的集合() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);
        list.remove(1);
    }
}