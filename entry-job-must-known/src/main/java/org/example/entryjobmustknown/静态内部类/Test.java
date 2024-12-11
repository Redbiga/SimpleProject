package org.example.entryjobmustknown.静态内部类;

import java.util.ArrayList;
import java.util.List;

/**
 * @author redA
 * @时间: 2024年11月25日 下午7:56
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List xx = list;
        xx.add("1111");
        System.out.println(list);
    }
}