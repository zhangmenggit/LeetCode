package com.zzm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangmeng
 * @date: 2020/3/3 22 27
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 *
 *
 *
 */
public class Question1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum(nums, 18);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        // 两次遍历
        /*for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }*/

        //一次遍历
        /*Map<Integer,Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (valueMap.containsKey(target - nums[i])) {
                return new int[]{valueMap.get(target - nums[i]),i};
            }else {
                valueMap.put(nums[i],i);
            }
        }*/

        //两次遍历
        Map<Integer,Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            valueMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length ; i++) {
            if (valueMap.containsKey(target - nums[i])) {
                return new int[]{valueMap.get(target - nums[i]),i};
            }
        }
        return null;
    }


}
