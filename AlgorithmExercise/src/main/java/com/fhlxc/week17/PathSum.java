package com.fhlxc.week17;

import java.util.ArrayList;
import java.util.List;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年5月3日 下午6:09:15
* @classname PathSum
* @description 
* 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
* 说明: 叶子节点是指没有子节点的节点。
* 示例:
* 给定如下二叉树，以及目标和 sum = 22，
*               5
*              / \
*             4   8
*            /   / \
*           11  13  4
*          /  \    / \
*         7    2  5   1
* 返回:
* [
*    [5,4,11,2],
*    [5,8,4,5]
* ]
*/

public class PathSum {

    private List<List<Integer>> result = new ArrayList<>();
    private int sum = 0;
    private List<Integer> tmp = new ArrayList<>();
    
    private void help(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        curr += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == curr) {
                result.add(new ArrayList<>(tmp));
            }
        }
        help(root.left, curr);
        help(root.right, curr);
        tmp.remove(tmp.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root == null) {
            return result;
        }
        help(root, 0);
        return result;
    }
    
    public static void main(String[] args) {

    }

}
