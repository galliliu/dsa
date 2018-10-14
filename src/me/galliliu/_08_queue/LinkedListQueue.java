package me.galliliu._08_queue;

/**
 * 基于链表的队列，主要包括出队和入队操作
 *
 * @author galliliu
 * @createTime 2018-10-14
 */
public class LinkedListQueue {
    private class Node {
        private Node prev;
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }
    }

    private Node guardNode;//哨兵节点
    private Node head;//头指针
    private Node tail;//尾指针
    private int n;//队列长度

    public LinkedListQueue() {
        this.guardNode = new Node(null);
        this.n = 0;
    }

    /**
     * 入队操作
     *
     * @param str 入队数据
     * @return 入队成功返回true，失败false
     */
    public boolean enQueue(String str) {
        Node newNode = new Node(str);

        if (this.tail == null) {
            this.tail = this.head = newNode;
            this.guardNode.next = newNode;
            newNode.prev = this.guardNode;
            this.n++;
            return true;
        }

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.n++;

        return true;
    }

    /**
     * 出队操作
     *
     * @return 出队成功返回队头数据，失败返回null
     */
    public String deQueue() {
        Node currentNode = this.head;
        String str = null;

        /*
            分三种情况：
               1、队列为空，则出队失败，原有head和tail指针不变，为null
               2、队列只有一个元素，出队成功后，head和tail指针设置为null
               3、队列有多个元素，出队成功后，head为第一个指针，tail最后一个指针，如出队后仅剩一个元素则head和tail一致

         */
        if (currentNode == null) {
            return null;
        }
        str = currentNode.data;
        this.guardNode.next = currentNode.next;
        if (currentNode.next == null) {
            this.tail = this.head = null;//只有一个节点的时候，head和tail都指向一起
        } else {
            currentNode.next.prev = this.guardNode;
            this.head = this.guardNode.next;
        }
        this.n--;

        return str;
    }


    /**
     * 获取队列元素个数
     *
     * @return 返回元素个数
     */
    public int size() {
        return this.n;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("LinkedListQueue[");

        Node headNode = this.head;
        while (headNode != null) {
            str.append(headNode.data + ",");
            headNode = headNode.next;
        }
        if (this.n > 0) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        str.append(", size=" + this.n);

        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue llq = new LinkedListQueue();

        System.out.println(llq);

        llq.deQueue();
        System.out.println(llq);

        llq.enQueue("A");
        System.out.println(llq);
        //llq.deQueue();
        //System.out.println(llq);

        llq.enQueue("B");
        System.out.println(llq);
        llq.deQueue();
        System.out.println(llq);
        llq.deQueue();
        System.out.println(llq);
        llq.deQueue();
        System.out.println(llq);

        llq.enQueue("C");
        System.out.println(llq);
    }
}
