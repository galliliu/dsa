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
     * 计数实现，特殊的桶排序，每个桶内的数据都相同
     * <p>
     * 例子场景：
     * 10个订单，每个订单的金额在0-5之间，要求对订单按金额排序
     * <p>
     * 方案：
     * 此时可以把数装到5个桶内，金额为0的放在0这个桶，1放在1这个桶，以此类推
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

        //buckets数组内顺序求和,buckets[k]存储了小于等于k的个数
        int sum = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] += sum;
            sum = buckets[i];
        }

        //从后往前扫描arr
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = buckets[arr[i]] - 1; //根据元素值获取它在桶buckets保存的下标
            r[j] = arr[i];//保存结果
            buckets[arr[i]]--;//桶元素个数减少
        }

        System.arraycopy(r, 0, arr, 0, r.length);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 7, 2, 5, 8};

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
