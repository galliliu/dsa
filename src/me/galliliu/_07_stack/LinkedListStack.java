package me.galliliu._07_stack;

/**
 * 链式栈，主要包含push，pop，peek等操作
 *
 * @author galliliu
 * @createTime 2018-10-14
 */
public class LinkedListStack {
    private class Node {
        private Node prev;
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }
    }

    private Node head;//head哨兵，head.next栈顶
    private int n;//栈长度

    public LinkedListStack() {
        this.head = new Node(null);
        this.n = 0;
    }

    /**
     * 入栈操作
     *
     * @param str 元素
     * @return 入栈成功返回true，否则返回false
     */
    public boolean push(String str) {
        Node headNode = this.head;
        Node newNode = new Node(str);

        newNode.next = headNode.next;
        if (headNode.next != null) {
            headNode.next.prev = newNode;
        }
        headNode.next = newNode;
        newNode.prev = headNode;
        this.n++;

        return true;
    }

    /**
     * 出栈
     *
     * @return 返回栈顶元素
     */
    public String pop() {
        String str = null;
        if (this.n > 0) {
            Node newStackTop = this.head.next.next;//this.n不为0，this.head.next绝对不为空
            str = this.head.next.data;
            this.head.next = newStackTop;

            if (newStackTop != null) {
                newStackTop.prev = this.head;
            }
            this.n--;
        }

        return str;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public String peek() {
        return this.isEmpty() ? null : this.head.next.data;
    }

    /**
     * 获取栈元素个数
     *
     * @return 返回元素个数
     */
    public int size() {
        return this.n;
    }

    /**
     * 判断栈是否为空
     *
     * @return 空返回true，否则返回false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("LinkedListStack[");

        Node headNode = this.head.next;
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
        LinkedListStack lls = new LinkedListStack();

        lls.push("A");
        lls.push("B");
        lls.push("C");
        System.out.println(lls.peek());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.isEmpty());
    }
}
