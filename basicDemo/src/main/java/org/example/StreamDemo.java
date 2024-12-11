package org.example;

import java.util.Random; /**
 * @author redA
 * @时间: 2024年11月15日 下午1:30
 */
public class StreamDemo{
    public static void main(String[] args) {
        Random random = new Random();

        // 在左闭右开区间中 [1, 100) 随机生成 10 个不重复的数字
//        random.ints(1, 100)
//                .distinct()
//                .limit(10)
//                .forEach(System.out::println);

    // 一个有趣的问题，如果 limit 方法放在 distinct 前面，
    // 结果和上面的代码有什么区别吗？
    // 欢迎加群讨论。
    random.ints(1, 100)
            .limit(10)
            .distinct()
            .forEach(System.out::println);
        System.out.println();
    }
}
