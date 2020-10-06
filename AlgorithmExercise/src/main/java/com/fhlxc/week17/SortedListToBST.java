package com.fhlxc.week17;

import com.fhlxc.mylove.ListNode;
import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月28日 上午9:54:50
* @classname SortedListToBST
* @description 
* 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
* 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
* 示例:
* 给定的有序链表： [-10, -3, 0, 5, 9],
* 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
*       0
*      / \
*    -3   9
*    /   /
*  -10  5
*/

public class SortedListToBST {
    
    private void help(TreeNode root, int i, int j, int[] nums, boolean direction) {
        if (i > j) {
            return;
        }
        TreeNode r;
        int x = (i + j) / 2;
        if (direction) {
            r = root.left = new TreeNode(nums[x]);
        } else {
            r = root.right = new TreeNode(nums[x]);
        }
        help(r, i, x - 1, nums, true);
        help(r, x + 1, j, nums, false);
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode t = head;
        while (t != null) {
            n++;
            t = t .next;
        }
        if (n == 0) {
            return null;
        }
        int[] nums = new int[n];
        n = 0;
        t = head;
        while (t != null) {
            nums[n] = t.val;
            n++;
            t = t.next;
        }
        int x = (0 + nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[x]);
        help(root, 0, x - 1, nums, true);
        help(root, x + 1, nums.length - 1, nums, false);
        return root;
    }
    
    public static void main(String[] args) {

    }

}
