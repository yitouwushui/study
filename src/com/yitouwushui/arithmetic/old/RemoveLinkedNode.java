package com.yitouwushui.arithmetic.old;

import com.yitouwushui.arithmetic.base.ListNode;

/**
 * Created by ding on 2017/8/23.
 * 给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除
 * 该结点。
 */

public class RemoveLinkedNode {

    public static void main(String[] args){
        ListNode head=new ListNode();
        ListNode second=new ListNode();
        ListNode third=new ListNode();
        head.nextNode =second;
        second.nextNode =third;
        head.data=1;
        second.data=2;
        third.data=3;
        RemoveLinkedNode p13=new RemoveLinkedNode();
        p13.deleteNode(head, second);
        System.out.println(head.nextNode.data);
    }

    public void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null) {
            return;
        }
        if (deListNode.nextNode == null) {
            // 尾节点
            ListNode pointListNode = head;
            while (pointListNode.nextNode.nextNode != null) {
                pointListNode = pointListNode.nextNode;
            }
            pointListNode.nextNode = null;
        } else {
            // 非尾节点
            deListNode.data = deListNode.nextNode.data;
            deListNode.nextNode = deListNode.nextNode.nextNode;
        }
    }
}
