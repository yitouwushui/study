package com.teambition.base;


/**
 * Created by ding on 2017/11/3.
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树
 * 中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树。
 */

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        root.leftNode = node1;
        root.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.leftNode = node5;
        node2.rightNode = node6;
        root.value = 1;
        node1.value = 2;
        node2.value = 3;
        node3.value = 4;
        node4.value = 5;
        node5.value = 6;
//        node6.value = 7;
        BalancedBinaryTree p = new BalancedBinaryTree();
        p.midOrder(root);
    }

//                                        目标二叉树
//                                              1
//                                            /   ╲
//                                           /     ╲
//                                          2       3
//                                        /  ╲      /  ╲
//                                       4    5    6   7

    public void midOrder(BinaryTreeNode node) {
        if (node != null) {
            midOrder(node.leftNode);
            System.out.print(node.value + " ");
            midOrder(node.rightNode);
        }
    }

    public void posOrder(BinaryTreeNode node) {
        if (node != null) {
            posOrder(node.leftNode);
            posOrder(node.rightNode);
            System.out.print(node.value + " ");
        }
    }

    /**
     * 前序遍历
     * 递归
     */
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }


//    public void midOrder2(BinaryTreeNode node1) {
//        if (node1 != null) {
//            //1 h1
//            if (node1.leftNode != null) {
//                //2 h2
//                BinaryTreeNode node2 = node1.leftNode;
//                if (node2.leftNode != null) {
//                    //4 h3
//                    BinaryTreeNode node3 = node2.leftNode;
//                        if(node3.leftNode == null){
//                            //不再递归h4
//                        }
//                    System.out.print(node3.value + " ");
//                        if(node3.rightNode == null){
//                            //方法结束h4
//                        }
//                    System.out.print(node2.value + " ");
//                }
//
//                System.out.print(node.value + " ");
//                midOrder(node.rightNode);
//            }
//
//
//            System.out.print(node.value + " ");
//            midOrder(node.rightNode);
//        }
//    }

}
