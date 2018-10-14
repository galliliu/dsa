package me.galliliu._07_stack;

/**
 * 顺序栈，主要包含push，pop，pek操作
 *
 * @author galliliu
 * @createTime 2018-10-14
 */
public class ArrayStack {
    public static int DEFAULT_SIZE = 10;
    public static int DEFAULT_CAPACITY = 2;
    private String[] strings;
    private int n;//strings[n-1]栈顶

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int size) {
        this.strings = new String[size];
        this.n = 0;
    }

    /**
     * 入栈操作
     *
     * @param str 元素
     * @return 入栈成功返回true，否则返回false
     */
    public boolean push(String str) {
        if (n >= strings.length) {
            String[] strs = new String[n * DEFAULT_CAPACITY];
            for (int i = 0; i < n; i++) {
                strs[i] = this.strings[i];
            }
            //System.arraycopy(this.strings, 0, strs, 0, n);
            this.strings = strs;
        }
        this.strings[n] = str;
        this.n++;
        return true;
    }

    /**
     * 出栈
     *
     * @return 返回栈顶元素
     */
    public String pop() {
        if (n < 1) {
            return null;
        }
        String str = this.strings[n - 1];
        this.n--;

        return str;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public String peek() {
        return this.isEmpty() ? null : this.strings[n - 1];
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
        StringBuilder str = new StringBuilder("ArrayStack[");

        for (int i = 0; i < this.n; i++) {
            str.append(this.strings[i] + ",");
        }
        if (this.n > 0) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        str.append(", size=" + this.n);

        return str.toString();
    }

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(3);

        as.push("A");
        System.out.println(as);
        as.push("B");
        System.out.println(as);
        as.push("C");
        System.out.println(as);
        as.push("D");
        System.out.println(as);

        System.out.println(as.pop());
        System.out.println(as);
        System.out.println(as.peek());
        System.out.println(as.isEmpty());
    }
}
