package com.fhlxc.week18;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author Xingchao Long
* @date 2020年5月9日 上午9:46:20
* @classname Connect
* @description
* 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
* struct Node {
*   int val;
*   Node *left;
*   Node *right;
*   Node *next;
* }
* 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
* 初始状态下，所有 next 指针都被设置为 NULL。
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Connect {

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
