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

    /**
     * 反转单链表
     *
     * @return 返回反转后链表的副本
     */
    public SingleLinkedList reverse() {
        Node currentNode = this.head.next;
        SingleLinkedList copy = new SingleLinkedList();

        while (currentNode != null) {
            copy.insert(0, currentNode.data);
            currentNode = currentNode.next;
        }

        return copy;
    }

    /**
     * 反转单链表，改变自身链表
     *
     * @return 返回反转后链表
     */
    public SingleLinkedList reverse2() {
        Node prevNode = this.head;
        Node currentNode = this.head.next;
        prevNode.next = null;
        Node tempNode;

        while (currentNode != null) {
            tempNode = currentNode;
            currentNode = currentNode.next;
            //插入第一个
            tempNode.next = prevNode.next;
            prevNode.next = tempNode;
        }

        return this;
    }


    /**
     * 生成一个环形链表
     *
     * @return
     */
    public void makeCircuit() {
        Node currentNode = this.head.next;
        Node prevNode = this.head;

        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = this.head.next;
    }

    /**
     * 判断是否是环形链表
     * 1、链表为空，返回true
     * 2、链表大小1个
     * 3、链表大小2个及以上
     *
     * @return
     */
    public boolean hasCircuit() {
        Node headNode = this.head;
        Node currentNode = this.head.next;
        int count = 0;

        if (currentNode == null) {
            return true;
        }

        while (currentNode != null) {
            count++;
            if (this.n == count && currentNode.next == headNode.next) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * 查找中间节点
     *
     * @return 找到返回节点值，找不到返回-1
     */
    public int findMiddleNode() {
        Node fastNode = this.head.next;
        Node slowNode = this.head.next;
        if (slowNode == null) {
            return -1;
        }

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        //如果fastNode==null，为链表长度为双数，否则为单数
        return slowNode.data;
    }

    /**
     * 删除倒数第n个节点
     *
     * @param nth 倒数第n
     * @return 删除成功返回true，失败返回false
     */
    public boolean deleteLastNthNode(int nth) {
        if (this.n <= 0) {
            return false;
        }
        Node prevNode = this.head;
        Node currentNode = this.head.next;
        nth = this.n - nth + 1;//正数第几位

        if (nth < 1 || nth > this.n) {
            return false;
        }
        for (int i = 1; i <= this.n; i++) {
            if (i == nth) {
                prevNode.next = currentNode.next;
                this.n--;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return true;
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
        //////////
        sll.insert(2);
        System.out.println(sll.toString());
        //sll.insert(3);
        //System.out.println(sll.toString());
        //sll.insert(4);
        //System.out.println(sll.toString());

        //sll.delete(2);
        //System.out.println(sll.toString());

        //System.out.println(sll.contains(2));
        //System.out.println(sll.contains(21));
        //System.out.println(sll.find(2));

        //sll.insert(2, 3);
        //System.out.println(sll.toString());

        //sll.deleteLast();
        //System.out.println(sll.toString());

        //反转链表，不改原链表，返回新的链表
        //System.out.println(sll.reverse());

        //反转链表2，更改原链表
        //System.out.println(sll.reverse2());
        //System.out.println(sll);

        //环形链表，toString方法无限循环
        //sll.makeCircuit();
        //System.out.println(sll.hasCircuit());

        //System.out.println(sll.findMiddleNode());

        System.out.println(sll.deleteLastNthNode(2));
        System.out.println(sll);
    }
}

