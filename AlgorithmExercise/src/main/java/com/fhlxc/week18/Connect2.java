package com.fhlxc.week18;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author Xingchao Long
* @date 2020年5月10日 上午10:34:18
* @classname Connect2
* @description
* 给定一个二叉树
* struct Node {
*   int val;
*   Node *left;
*   Node *right;
*   Node *next;
* }
* 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
* 初始状态下，所有 next 指针都被设置为 NULL。
* 进阶：
* 你只能使用常量级额外空间。
* 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
*/

public class Connect2 {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node curr = root;
        Node next = null;
        if (root == null) {
            return root;
        }
        queue.add(curr);
        queue.add(null);
        while (!queue.isEmpty()) {
            curr = queue.poll();
            next = queue.peek();
            if (curr != null) {
                curr.next = next;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (curr != null && next == null) {
                queue.add(null);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {

    }

}
