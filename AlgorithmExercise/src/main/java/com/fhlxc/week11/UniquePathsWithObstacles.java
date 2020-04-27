package com.fhlxc.week11;

import java.awt.Point;

/**
* @author Xingchao Long
* @date 2020年3月19日 上午10:33:04
* @classname UniquePathsWithObstacles
* @description 以下回溯法超时
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
* 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
* 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
* 网格中的障碍物和空位置分别用 1 和 0 来表示。
* 说明：m 和 n 的值均不超过 100。
* 示例 1:
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
*/
public class UniquePathsWithObstacles {
    
    private int total = 0;
    private Point point = new Point(0, 0);
    
    private void backtrace(int[][] obstacleGrid, Point point) {
        if (point.x == obstacleGrid.length || point.y == obstacleGrid[0].length) {
            return;
        }
        if (obstacleGrid[point.x][point.y] == 1) {
            return;
        }
        if (point.x == obstacleGrid.length - 1 && point.y == obstacleGrid[0].length - 1) {
            total++;
            return;
        }
        int direction = -1;
        if (point.x < obstacleGrid.length - 1) {
            direction = 0;
            point.x++;
            backtrace(obstacleGrid, point);
        }
        if (direction == 0) {
            point.x--;
        }
        if (point.y < obstacleGrid[0].length) {
            direction = 1;
            point.y++;
            backtrace(obstacleGrid, point);
        }
        if (direction == 1) {
            point.y--;
        }
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        backtrace(obstacleGrid, point);
        return total;
    }
    
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));
    }

}
