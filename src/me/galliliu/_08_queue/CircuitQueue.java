package me.galliliu._08_queue;

/**
 * 基于数组的循环队列，主要包括出队和入队操作
 *
 * @author galliliu
 * @createTime 2018-10-14
 */
public class CircuitQueue {
    private String[] strings;//循环队列，最大长度为size，牺牲一个数据
    private int head;
    private int tail;
    private int n;//记录队列长度

    public CircuitQueue(int size) {
        this.strings = new String[size + 1];
        this.head = 0;
        this.tail = 0;
        this.n = 0;
    }

    /**
     * 入队操作
     *
     * @param str 入队数据
     * @return 入队成功返回true，失败false
     */
    public boolean enQueue(String str) {
        //入队，tail = (tail + 1) % n
        //队满判断：(tail + 1) % n == head
        int newTail = (tail + 1) % this.strings.length;

        if (newTail == head) {
            return false;
        }
        this.strings[this.tail] = str;
        this.tail = newTail;
        this.n++;

        return true;
    }

    /**
     * 出队操作
     *
     * @return 出队成功返回队头数据，失败返回null
     */
    public String deQueue() {
        //队空判断：(head + 1) % n == tail
        int newHead = (this.head + 1) % this.strings.length;

        if (newHead == tail) {
            return null;
        }
        //出队，head = (head + 1) % n
        String str = this.strings[this.head];
        this.head = newHead;
        this.n--;

        return str;
    }

    /**
     * 返回队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return this.n;
    }

    @Override
    public String toString() {
        //打印队列数据，比较麻烦，head<tail，head>tail
        StringBuilder str = new StringBuilder("CircuitQueue[");

        if (this.size() > 0) {
            int i = this.head;

            while (i != this.tail) {
                str.append(this.strings[i] + ",");
                i = (i + 1) % this.strings.length;
            }

            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        str.append(", size=" + this.size());

        return str.toString();
    }

    public static void main(String[] args) {
        CircuitQueue aq = new CircuitQueue(3);

        System.out.println(aq);

        aq.enQueue("A");
        System.out.println(aq);
        aq.enQueue("B");
        System.out.println(aq);
        aq.enQueue("C");
        System.out.println(aq);

        //aq.enQueue("D");//失败，队满了
        //System.out.println(aq);

        aq.deQueue();
        System.out.println(aq);

        aq.enQueue("D");
        System.out.println(aq);

        aq.deQueue();
        System.out.println(aq);
        aq.deQueue();
        System.out.println(aq);

        aq.enQueue("E");
        System.out.println(aq);
        aq.enQueue("F");
        System.out.println(aq);
        aq.enQueue("G");
        System.out.println(aq);
    }
}
