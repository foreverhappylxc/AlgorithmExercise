package com.fhlxc.mylove;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingchao Long
 * @date 2020/06/03 09:50
 * @classname Node
 * @description
 */

public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < neighbors.size() - 1; i++) {
            s += (neighbors.get(i).val + ",");
        }
        if (neighbors.size() - 1 >= 0) {
            s += neighbors.get(neighbors.size() - 1).val + "]";
        }
        return s;
    }
}
