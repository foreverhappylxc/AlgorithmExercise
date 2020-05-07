package com.fhlxc.week18;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年5月7日 上午11:07:49
* @classname Flatten
* @description
* 给定一个二叉树，原地将它展开为链表。
* 例如，给定二叉树
*     1
*    / \
*   2   5
*  / \   \
* 3   4   6
* 将其展开为：
* 1
*  \
*   2
*    \
*     3
*      \
*       4
*        \
*         5
*          \
*           6
*/

public class Flatten {
    
    public void flatten(TreeNode root) {
        TreeNode mostRight;
        while (root != null) {
            if (root.left != null) {
                mostRight = root.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                mostRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {

    }

}
