package com.fhlxc.week17;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月30日 下午4:04:15
* @classname MinDepth
* @description 
* 给定一个二叉树，找出其最小深度。
* 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
* 说明: 叶子节点是指没有子节点的节点。
* 示例:
* 给定二叉树 [3,9,20,null,null,15,7],
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回它的最小深度  2.
*/

public class MinDepth {

    private int min = Integer.MAX_VALUE;
    
    private void help(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (min > n) {
                min = n;
            }
        }
        help(root.left, n + 1);
        help(root.right, n + 1);
    }
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root, 1);
        return min;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new MinDepth().minDepth(root));
    }

}
