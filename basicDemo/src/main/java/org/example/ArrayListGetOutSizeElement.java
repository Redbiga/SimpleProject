package org.example;

import java.util.ArrayList;

/**
 * @author redA
 * @时间: 2024年11月14日 下午3:16
 */
public class ArrayListGetOutSizeElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        下面的get方法会抛出异常的,可以详细看看get的源码就知道了
        System.out.println( list.get(9));

    }
}