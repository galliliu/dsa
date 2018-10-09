package me.galliliu._05_array;

import java.util.Arrays;

/**
 * 数组类，可随机访问、删除、插入数据
 *
 * @author galliliu
 * @createTime 2018-10-09
 */
public class Array {
    public static int DEFAULT_CAPACITY = 10;
    public static int FACTOR = 2;
    //存储数据的数组
    private int[] array;
    //数组的容量
    private int n;
    //当前数组的元素个数
    private int count;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(int capacity) {
        this.array = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 查找数组索引index的元素数据
     *
     * @param index 元素索引
     * @return 找到返回元素，找不到返回-1
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        return this.array[index];
    }

    /**
     * 删除数组中指定索引的元素
     *
     * @param index 元素索引
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        //index后面的数据往前搬移，这种算法保证数据有序
        for (int i = index; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;

        return true;
    }

    /**
     * 往数组中插入一个元素
     *
     * @param ele 元素
     * @return 成功返回true，失败返回false
     */
    public boolean insert(int ele) {
        //自动扩容
        if (count >= n) {
            int[] tempArray = new int[this.n * FACTOR];
            for (int i = 0; i < n; i++) {
                tempArray[i] = this.array[i];
            }
            this.array = tempArray;
            this.n = this.n * FACTOR;
        }
        this.array[count++] = ele;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        for (int i = 0; i < this.count; i++) {
            str.append(this.array[i] + ",");
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]");

        return str.toString();
    }

    public static void main(String[] args) {
        Array array = new Array();

        System.out.println(array);

        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        System.out.println(array);

        System.out.println(array.find(3));
        System.out.println(array.find(5));

        array.delete(2);
        System.out.println(array);

        array.delete(1);
        array.delete(2);
        array.delete(1);
        System.out.println(array);
    }
}
