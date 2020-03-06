package com.zzm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangmeng
 * @date: 2020/3/6 22:17
 * @Description:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 */
public class InterviewQuestion57 {

    public static void main(String[] args) {
        int[][] result = findContinuousSequence(9);

    }

    public static int[][] findContinuousSequence(int target) {

        int start = 1;
        int end = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();

        while (target/2 >= start) {
            if (sum < target) {
                sum += end;
                end++;
            }else if (sum > target) {
                sum -= start;
                start++;
            }else {
                int[] arr = new int[end-start];
                for (int i = start; i < end ; i++) {
                    arr[i-start] = i;
                }
                result.add(arr);
                sum -= start;
                start++;
            }
        }
        return result.toArray(new int[result.size()][]);






    }




}
