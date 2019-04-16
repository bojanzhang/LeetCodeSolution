package com.chen.leetcode.algorithm.medium;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 如：
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * @author: chen
 * @date: 2019/4/16
 **/
public class Solution_063_UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row, col;
        if (obstacleGrid == null || (row = obstacleGrid.length) == 0 ||
                (col = obstacleGrid[0].length) == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = 1;

        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i - 1][0];
        }

        for (int j = 1; j < col; j++) {
            if (obstacleGrid[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    int left = obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
                    int up = obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
