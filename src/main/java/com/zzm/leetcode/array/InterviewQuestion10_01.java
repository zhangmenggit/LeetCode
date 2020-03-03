package com.zzm.leetcode.array;

import java.util.Arrays;

/**
 * @author: zhangmeng
 * @date: 2020/3/3 22 42
 * @Description: 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class InterviewQuestion10_01 {

    public static void main(String[] args) {
        int[] numsA = new int[]{1, 2, 3, 0, 0, 0};
        int[] numsB = new int[]{2, 5, 6};
        merge(numsA, 3, numsB, 2);

    }

    public static void merge(int[] A, int m, int[] B, int n) {

        //暴力破解方式
       /* int j = 0;
        for (int i = m; i < m + n ; i++) {
            A[i] = B[j++];
        }
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));*/

        int sum = m + n - 1, i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[sum--] = A[i--];
            } else {
                A[sum--] = B[j--];
            }
        }
        while (j >= 0) {
            A[sum--] = B[j--];
        }

        System.out.println(Arrays.toString(A));

    }


}
