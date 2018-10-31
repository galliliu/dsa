package me.galliliu._10_sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author galliliu
 * @createTime 2018-10-31
 */
public class CountingSort {
    /**
     * 计数实现，特殊的桶排序，没个桶内的数据都相同
     * <p>
     * 例子场景：
     * 10个订单，每个订单的金额在0-5之间，此时可以把数装到5个桶内
     * 金额为0的放在0这个桶，1放在1这个桶，以此类推
     *
     * @param arr 待排数组
     */
    public static void countingSort(int[] arr) {
        int maxBucket = arr[0];

        //寻找最大桶
        for (int i = 0; i < arr.length; i++) {
            if (maxBucket < arr[i]) {
                maxBucket = arr[i];
            }
        }

        int[] buckets = new int[maxBucket + 1];
        int index = 0;

        // 数据装入桶内
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i]]++;
        }

        // 从桶内导出数据
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 7, 2, 5, 8};

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
