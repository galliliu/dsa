package me.galliliu._08_queue;

/**
 * 基于数组的队列，主要包括出队和入队操作
 *
 * @author galliliu
 * @createTime 2018-10-14
 */
public class ArrayQueue {
    private String[] strings;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        this.strings = new String[size];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队操作
     *
     * @param str 入队数据
     * @return 入队成功返回true，失败false
     */
    public boolean enQueue(String str) {
        if (this.tail == this.strings.length) {
            if (head == 0) {
                //队满了
                return false;
            } else {
                //数据搬移，否则数据无法再插入了
                for (int i = this.head; i < this.tail; i++) {
                    this.strings[i - this.head] = this.strings[i];
                }
                //head，tail要重置
                this.tail = this.tail - this.head;
                this.head = 0;
            }
        }
        this.strings[this.tail++] = str;
        return true;
    }

    /**
     * 出队操作
     *
     * @return 出队成功返回队头数据，失败返回null
     */
    public String deQueue() {
        if (this.size() > 0) {
            return this.strings[this.head++];
        }
        return null;
    }

    /**
     * 返回队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return this.tail - this.head;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ArrayQueue[");

        for (int i = this.head; i < this.tail; i++) {
            str.append(this.strings[i] + ",");
        }
        if (this.size() > 0) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        str.append(", size=" + this.size());

        return str.toString();
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);

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
    }
}
