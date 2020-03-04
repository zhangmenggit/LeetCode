package com.zzm.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangmeng
 * @date: 2020/3/4 16 51
 * @Description: 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
public class Question994 {

    public static void main(String[] args) {
        //int[][] nums = {{2,1,1},{1,1,0},{0,1,1}};
        //int[][] nums = {{0,2}};
        //int[][] nums = {{2,1,1},{0,1,1},{1,0,1}};
        //int[][] nums = {{1}};
        int[][] nums = {{2, 2, 2,1,1}};
        //int[][] nums = {{1, 1, 2,0,2,0}};

        System.out.println(orangesRotting(nums));


    }

    public static int orangesRotting(int[][] grid) {


        //正常橘子的个数
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //获取正常橘子的个数
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        //统计橘子传染的次数
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n ; i++) {
                //上下左右操作
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        }else {
            return round ;
        }
    }


}
