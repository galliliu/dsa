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

public class SingleLinkedList {
    //链表头结点，哨兵
    private Node head;
    //链表长度
    private int n;

    public SingleLinkedList() {
        this.head = new Node(0);
        this.n = 0;
    }


    /**
     * 根据节点值返回对应的节点
     *
     * @param val 值
     * @return 找到返回true，否则返回false
     */
    public boolean find(int val) {
        if (this.head.next == null) {
            return false;
        }

        Node currentNode = this.head.next;
        while (currentNode != null && currentNode.data != val) {
            currentNode = currentNode.next;
        }

        return currentNode != null;
    }

    /**
     * 根据值删除链表中的节点
     *
     * @param val 值
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(int val) {
        Node prevNode = this.head;
        Node currentNode = this.head.next;

        //寻找删除的节点
        while (currentNode != null && currentNode.data != val) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            prevNode.next = currentNode.next;
            //currentNode = null;//释放内存
            this.n--;
            return true;
        }

        return false;
    }

    /**
     * 根据给定的节点引用删除节点
     *
     * @param node 待删除的节点
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(Node node) {
        Node prevNode = this.head;

        //寻找要删除的节点的先驱节点
        while (prevNode.next != null && prevNode.next != node) {
            prevNode = prevNode.next;
        }

        if (prevNode.next != null) {
            prevNode.next = node.next;
            node.next = null;
            this.n--;
        }

        return false;
    }


    /**
     * 插入节点
     *
     * @param val 要插入的节点
     * @return 插入成功返回true，失败返回false
     */
    public boolean insert(int val) {
        Node prevNode = this.head;
        Node newNode = new Node(val);

        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }

        prevNode.next = newNode;
        this.n++;

        return true;
    }

    /**
     * 返回链表元素个数
     *
     * @return 链表元素个数
     */
    public int size() {
        return this.n;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("SingleLinkedList[");

        Node firstNode = this.head.next;
        while (firstNode != null) {
            str.append(firstNode.data + ",");
            firstNode = firstNode.next;
        }

        if (this.n > 0) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        str.append(", size=" + this.n);

        return str.toString();
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        System.out.println(sll.toString());

        sll.insert(1);
        System.out.println(sll.toString());

        sll.insert(2);
        System.out.println(sll.toString());

        //sll.delete(2);
        //System.out.println(sll.toString());

        System.out.println(sll.find(2));
        System.out.println(sll.find(21));
    }
}

