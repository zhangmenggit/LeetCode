package com.zzm.leetcode.array;

import java.util.Arrays;

/**
 * @author: zhangmeng
 * @date: 2020/3/14 21:24
 * @Description:
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 *
 *
 *
 */
public class Question300 {

    public static void main(String[] args) {
        int[] values = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(values));
    }


    public static int lengthOfLIS(int[] nums) {
       if (nums.length == 0 ) {
           return 0;
       }
       int res = 0;
       int[] dp = new int[nums.length];
       Arrays.fill(dp,1);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] < nums[i] ) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }





}