package com.fhlxc.week17;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月29日 上午10:14:37
* @classname IsBalanced
* @description 
* 给定一个二叉树，判断它是否是高度平衡的二叉树。
* 本题中，一棵高度平衡二叉树定义为：
* 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
* 示例 1:
* 给定二叉树 [3,9,20,null,null,15,7]
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回 true 。
* 示例 2:
* 给定二叉树 [1,2,2,3,3,null,null,4,4]
*        1
*       / \
*      2   2
*     / \
*    3   3
*   / \
*  4   4
* 返回 false 。
*/

public class IsBalanced {
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return Math.max(1 + getHeight(root.left), 1 + getHeight(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        boolean is = false;
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) >= 2) {
            is = false;
        } else {
            is = true;
        }
        return is && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static void main(String[] args) {

    }

}
