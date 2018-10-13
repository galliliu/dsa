package me.galliliu._06_linkedlist;

/**
 * 双向链表
 *
 * @author galliliu
 * @createTime 2018-10-13
 */
public class DoubleLinkedList {
    private class Node {
        Node prev;
        Node next;
        int data;

        Node(int val) {
            this.data = val;
        }
    }

    private Node head;
    private int n;

    public DoubleLinkedList() {
        this.head = new Node(0);
        this.n = 0;
    }

    /**
     * 判断元素是否在链表里面
     *
     * @param val 元素值
     * @return 在返回true，否则返回false
     */
    public boolean contains(int val) {
        return this.find(val) != -1;
    }

    /**
     * 查找指定的元素
     *
     * @param val 元素值
     * @return 找到返回该值，不在返回-1
     */
    public int find(int val) {
        Node headNode = this.head.next;

        while (headNode != null && headNode.data != val) {
            headNode = headNode.next;
        }

        return headNode == null ? -1 : headNode.data;
    }

    /**
     * 添加节点
     *
     * @param val 节点值
     * @return 添加成功返回true，失败false
     */
    public boolean insert(int val) {
        Node headNode = this.head;
        Node newNode = new Node(val);

        while (headNode.next != null) {
            headNode = headNode.next;
        }
        headNode.next = newNode;
        newNode.prev = headNode;
        this.n++;

        return true;
    }

    /**
     * 删除节点
     *
     * @param val 删除的节点值
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(int val) {
        Node headNode = this.head.next;

        while (headNode != null && headNode.data != val) {
            headNode = headNode.next;
        }

        if (headNode == null) {
            return false;
        } else {
            Node preNode = headNode.prev;
            headNode.prev = null;
            preNode.next = headNode.next;
            //删除最后一个节点处理
            if (headNode.next != null) {
                headNode.next.prev = preNode;
            }
            this.n--;
            return true;
        }
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int size() {
        return this.n;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("DoubleLinkedList[");

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
        DoubleLinkedList dll = new DoubleLinkedList();

        System.out.println(dll);
        System.out.println(dll.contains(1));
        System.out.println(dll.find(1));

        dll.insert(1);
        System.out.println(dll);
        dll.insert(2);
        System.out.println(dll);

        dll.delete(2);
        System.out.println(dll);
    }
}
