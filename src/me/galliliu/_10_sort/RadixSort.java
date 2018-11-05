package me.galliliu._10_sort;

import java.util.*;

/**
 * 基数排序
 *
 * @author galliliu
 * @createTime 2018-11-05
 */
public class RadixSort {

    /**
     * 基数排序实现
     * <p>
     * 场景：
     * 对固定长度的字符串数组元素排序，假设字符串只有小写字母
     * <p>
     * 方案：
     * 从字符串最后一个位开始到第一位，依次实施桶排序或者基数排序
     *
     * @param arr 待排数组
     * @param n   每个数据的位数
     */
    public static void radixSort(String[] arr, int n) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            bucketSort(arr, i, 26);
        }
    }

    /**
     * 桶排序
     *
     * @param arr        待排数组
     * @param bit        第几个位，从后面开始数起
     * @param bucketSize 桶大小
     */
    private static void bucketSort(String[] arr, int bit, int bucketSize) {
        ArrayList<String>[] buckets = new ArrayList[bucketSize];

        // 初始化桶
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 把数据装到桶中
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = arr[i].charAt(bit) - 'a';//a字母放在0这个桶内
            if (bucketIndex != -1) {
                buckets[bucketIndex].add(arr[i]);
                //System.out.println("装到" + bucketIndex + "桶中");
            } else {
                buckets[bucketSize - 1].add(arr[i]);
            }
        }

        // 每个桶做内排序
        for (int i = 0; i < bucketSize; i++) {
            buckets[i].sort(Comparator.comparingInt(o -> o.charAt(bit)));
        }

        // 取数据
        int index = 0;
        for (int i = 0; i < bucketSize; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {
                "abc",
                "ede",
                "deg",
                "rrs",
                "abb",
                "abd",
                "ddd"
        };

        radixSort(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
