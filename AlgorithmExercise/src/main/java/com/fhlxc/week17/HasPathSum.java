package com.fhlxc.week17;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年5月1日 上午10:34:21
* @classname HasPathSum
* @description 
* 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
* 说明: 叶子节点是指没有子节点的节点。
* 示例: 
* 给定如下二叉树，以及目标和 sum = 22，
*               5
*              / \
*             4   8
*            /   / \
*           11  13  4
*          /  \      \
*         7    2      1
* 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
*/

public class HasPathSum {

    private boolean result = false;
    private int sum;
    
    private void help(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        curr += root.val;
        if (root.left == null && root.right == null) {
            if (sum == curr) {
                result = true;
            }
        }
        help(root.left, curr);
        help(root.right, curr);
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root == null) {
            return false;
        }
        help(root, 0);
        return result;
    }
    
    public static void main(String[] args) {
        
    }

}
