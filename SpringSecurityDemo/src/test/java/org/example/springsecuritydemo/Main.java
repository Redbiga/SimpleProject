package org.example.springsecuritydemo;

import java.util.Scanner;

/**
 * @author redA
 * @时间: 2024年10月31日 上午11:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int vec[][] = new int[n][m];
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                vec[i][j] = sc.nextInt();
                sum += vec[i][j];
            }
        }
        int[] line = new  int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                line[i] += vec[i][j];
            }
        }
        int[] row = new  int[m];
        for(int j = 0;j<m;j++){
            for(int i = 0;i<n;i++){
                row[j] += vec[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        int lineCount = 0;
        for(int i = 0; i < n; i++){
            lineCount += line[i];
            ans = Math.min(ans, Math.abs(sum - 2 * lineCount));

        }
        int rowCount = 0;
        for(int j = 0; j < m; j++){
            rowCount += row[j];
            ans = Math.min(ans, Math.abs(sum - 2 * rowCount));
        }
        System.out.println(ans);
        sc.close();
    }
}