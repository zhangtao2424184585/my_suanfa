package com.example.aaaaa.domain;

import java.util.ArrayList;

/**
 * @Classname ReverseNodeDeomo
 * @Description TODO
 * @Date 2020/11/3 16:59
 * @Created by zhangtao
 * <p>
 * 翻转链表
 */
public class ReverseNodeDeomo {
    public static Node reversenode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reversenode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        Node reversenode = reversenode(head);

        temp = reversenode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    static class Node {
        int val;
        Node next;

        Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }
}
