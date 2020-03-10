package com.zzm.leetcode.array;

/**
 * @author: zhangmeng
 * @date: 2020/3/10 21:53
 * @Description:
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树

1
/ \
2   3
/ \
4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

 *
 *
 */
public class Question543 {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        traverse(root);
        return diameter;
    }

    // 返回树的深度
    int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left); // 左子树的深度
        int right = traverse(root.right); // 右子树的深度
        // 直接访问全局变量
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
