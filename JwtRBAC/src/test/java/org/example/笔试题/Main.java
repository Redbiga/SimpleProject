package org.example.笔试题;

public class Main {
    public int maxGold(int[] coins, int rounds) {
        int n = coins.length - 1; // 第 n 个城市
        int[] dp = new int[n + 1];

        // 初始化 dp 数组
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        // 动态规划计算
        for (int round = 1; round <= rounds; round++) {
            for (int i = n; i >= 1; i--) {
                for (int j = 1; j <= 4; j++) {
                    if (i - j >= 0) {
                        dp[i] = Math.max(dp[i], dp[i - j] + coins[i]);
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {-1, 2, 3, 4, -9, -9, -1, 3, -1, -1};
        int rounds = 2; // 假设小美有两轮机会

        Main solution = new Main();
        int result = solution.maxGold(coins, rounds);
        System.out.println("最大金币数: " + result);
    }
}
