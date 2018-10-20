package me.galliliu._10_sort;

/**
 * 包装的数据类
 *
 * @author galliliu
 * @createTime 2018-10-20
 */
public class Data implements Comparable<Data> {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "Data[value=" + value + "]";
    }

    public int compareTo(Data another) {
        return this.value - another.value;
    }
}
