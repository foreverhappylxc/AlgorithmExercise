package com.fhlxc.week22;

import java.util.LinkedList;
import java.util.Queue;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年8月21日
* @classname Solution
* @description
*/

public class Solution {
    
    public int minDepth(TreeNode root) {
        int result = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        TreeNode tmp = null;
        
        out: while (!queue.isEmpty() || !queue2.isEmpty()) {
            result++;
            if (!queue.isEmpty()) {
                while ((tmp = queue.poll()) != null) {
                    if (tmp.left != null) {
                        queue2.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue2.add(tmp.right);
                    }
                    if (tmp.left == null && tmp.right == null) {
                        break out;
                    }
                }
            } else {
                if (!queue2.isEmpty()) {
                    while ((tmp = queue2.poll()) != null) {
                        if (tmp.left != null) {
                            queue.add(tmp.left);
                        }
                        if (tmp.right != null) {
                            queue.add(tmp.right);
                        }
                        if (tmp.left == null && tmp.right == null) {
                            break out;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {

    }

}
