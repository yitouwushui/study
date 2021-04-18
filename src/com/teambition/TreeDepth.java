package com.teambition;


import com.teambition.base.BinaryTreeNode;

import java.util.Stack;

/**
 * @author ding
 * @date 2017/11/3
 * 二叉树的深度
 * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过
 * 的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class TreeDepth {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();
        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.rightNode = node6;
        node5.leftNode = node7;
//                                        目标二叉树
//                                            1
//                                           /  ╲
//                                         2      3
//                                        / ╲      ╲
//                                      4    5      6
//                                           /
//                                          7
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;
        node6.value = 6;
        node7.value = 7;
        TreeDepth p = new TreeDepth();
        System.out.println(p.treeDepth2(node1));
    }

    private int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    private int treeDepth2(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<Integer> flag = new Stack<>();
        BinaryTreeNode currentNode = root;
        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                flag.push(0);
                currentNode = currentNode.leftNode;
            }
            if (flag.peek() == 1) {
                height = height > stack.size() ? height : stack.size();
                stack.pop();
                flag.pop();
                currentNode = null;
            } else {
                currentNode = stack.peek();
                currentNode = currentNode.rightNode;
                flag.pop();
                flag.push(1);
            }
        }
        return height;
    }
//                                        目标二叉树
//                                            1
//                                           /  ╲
//                                         2      3
//                                        / ╲      ╲
//                                      4    5      6
//                                           /
//                                          7
}
