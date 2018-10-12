package me.galliliu._06_linkedlist;

/**
 * 单链表，访问、插入、删除操作
 *
 * @author galliliu
 * @createTime 2018-10-10
 */

class Node {
    //节点数据
    int data;
    //后继节点
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
