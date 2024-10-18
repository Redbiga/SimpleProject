package org.example.jwtrbac;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {-1, 2, 1, 1},
                {0, 2, 2, 0},
                {0, 0, 2, 2},
                {1, 1, 0, -1}
        };
        int rows = grid.length;
        int cols = grid[0].length;

        int maxPlates = maxPlates(grid, rows, cols);
        System.out.println("最多能携带的盘子数量是: " + maxPlates);
    }

    public static int maxPlates(int[][] grid, int rows, int cols) {
        // 创建dp数组，初始化为1，因为至少可以携带1个盘子
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = 1;
            }
        }

        // 从网格的最后一个元素开始向前遍历
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < cols - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                }
                if (i < rows - 1 && j < cols - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
                dp[i][j] = Math.min(dp[i][j], grid[i][j]);
            }
        }

        // 返回到达食堂位置时可以携带的最大盘子数量
        return Math.min(dp[0][0], grid[0][0]);
    }
}