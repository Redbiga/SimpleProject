package org.example.unittestdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author redA
 * @时间: 2024年11月12日 下午4:05
 */

public class Main {
    public static void main (String[] args) {
        List<String> list = new ArrayList();
        try {
            list.add("A");
            list.set(1, "B");
            System.out.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.toString());
        }
    }
    @Test
    public void test(){
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);

    }

}