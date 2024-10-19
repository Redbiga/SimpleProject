package org.example.Demo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author redA
 * @时间: 2024年10月19日 下午4:24
 * 题目：
 * <img src="https://fastly.jsdelivr.net/gh/Redbiga/imgs@main/1729351184368c64d2b5840b62332c2e98d61a51464b.jpg"></>
 */
public class 笔试360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BigDecimal[][] points = new BigDecimal[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = BigDecimal.valueOf(sc.nextDouble());
        }
        for (int i = 0; i < n; i++) {
            points[i][1] =BigDecimal.valueOf(sc.nextDouble());
        }
        if(n==0){
            System.out.println(0);
            return;
        }
        int max = getMax(n, points, k);
        System.out.println(max);


    }

    private static int getMax(int n, BigDecimal[][] points, int k) {
        int max = 1;
        for(int i = 0; i < n; i++){
            int riskCounter = 0;
            for(int j = 0; j < n; j++){
                BigDecimal dx = points[j][0].subtract(points[i][0]).abs();
                BigDecimal dy = points[j][1].subtract(points[i][1]).abs();
                BigDecimal dxSquared = dx.multiply(dx);
                BigDecimal dySquared = dy.multiply(dy);
                BigDecimal distanceSquared = dxSquared.add(dySquared);
                BigDecimal kSquared = BigDecimal.valueOf(k).multiply(BigDecimal.valueOf(k));
                if(distanceSquared.compareTo(kSquared) <= 0){
                    riskCounter++;
                }
            }
            max = Math.max(riskCounter, max);
        }
        return max;
    }
}