package com.zzm.leetcode.array;

/**
 * @author: zhangmeng
 * @date: 2020/3/12 23:02
 * @Description:
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

 

示例 1：

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""

 *
 *
 *
 */
public class Question1071 {


    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }

     /*
        如果 str1 和 str2 存在最大公约数 str，那么就相当于 str1 和 str2 都是由 str 组成的，那么 str1 + str2 和 str2 + str1 应该是相等的
        如果不满足，那么不存在最大公约数

        我们可以通过 两个字符串的长度来求得最大公约数的长度
        比如 str1 = "ABABAB", str2 = "ABAB"
            len1 = 6         len2 = 4
            那么最大公约数 str = "AB"
                         len = 2
        */
     public static String gcdOfStrings(String str1, String str2) {

         if(!(str1 + str2).equals(str2 + str1)){
        return "";
    }

        return str2.substring(0, gcd(str1.length(), str2.length()));
}
    /*              a   b
                    18  12
    18 % 12 = 6     12  6
    12 % 6  = 0     6   0
    */
    private static int gcd(int a, int b){
        //保证 a 比 b 大，不加这个也没问题，下一次递归会自动变成 a > b
        if(a < b){
            return gcd(b, a);
        }
        if(a % b == 0){
            return b;
        }else{
            return gcd(b, a % b);
        }
    }


}
