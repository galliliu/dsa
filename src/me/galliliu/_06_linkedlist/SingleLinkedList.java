package me.galliliu._06_linkedlist;

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
    public boolean contains(int val) {
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
     * 根据节点值返回对应的节点值
     *
     * @param val 值
     * @return 找到返回该值，否则返回-1
     */
    public int find(int val) {
        if (this.head.next == null) {
            return -1;
        }

        Node currentNode = this.head.next;
        while (currentNode != null && currentNode.data != val) {
            currentNode = currentNode.next;
        }

        return currentNode == null ? -1 : currentNode.data;
    }

    /**
     * 根据索引返回对应的节点值
     *
     * @param index 索引值
     * @return 找到返回该值，否则返回-1
     */
    public int findByIndex(int index) {
        if (this.head.next == null) {
            return -1;
        }

        return -1;
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
     * 删除最后一个数据
     *
     * @return 删除成功返回true，失败返回false
     */
    public boolean deleteLast() {
        Node prevNode = this.head;
        Node currentNode = this.head.next;

        //寻找最后一个节点
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }
        while (prevNode.next != currentNode) {
            prevNode = prevNode.next;
        }

        prevNode.next = null;
        if (this.size() != 0) {
            this.n--;
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
     * 在任意地方插入节点
     *
     * @param index 索引
     * @param val   节点值
     * @return 插入成功返回true，失败返回false
     */
    public boolean insert(int index, int val) {
        if (index <= -1 || index > this.size()) {
            return false;
        }
        Node prevNode = this.head;
        Node currentNode = this.head.next;
        Node newNode = new Node(val);

        //寻找要插入的位置
        for (int j = 0; j <= this.size(); j++) {
            if (index == j) {
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        newNode.next = currentNode;
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

        //sll.insert(1);
        //System.out.println(sll.toString());
        //////
        //sll.insert(2);
        //System.out.println(sll.toString());

        //sll.delete(2);
        //System.out.println(sll.toString());

        //System.out.println(sll.contains(2));
        //System.out.println(sll.contains(21));
        //System.out.println(sll.find(2));

        //sll.insert(2, 3);
        //System.out.println(sll.toString());

        sll.deleteLast();
        System.out.println(sll.toString());
    }
}

