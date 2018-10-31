package me.galliliu._10_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 桶排序
 *
 * @author galliliu
 * @createTime 2018-10-31
 */
public class BucketSort {
    /**
     * 桶排序实现，对数据要求苛刻
     * <p>
     * 例子场景：
     * 20个订单，订单金额范围在1~50之间
     * 我们可以把它分为5个桶，每个桶数据范围均匀，第一个桶的订单金额为1-10，第二个桶的订单金额为11~20，依次类推
     * 桶内数据不一定相同，每个桶内使用稳定排序，如快速排序来排序
     *
     * @param arr        待排数组
     * @param bucketSize 桶个数
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        int maxValue = arr[0];

        //寻找最大桶
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }

        bucketSort(arr, bucketSize, 1, maxValue);
    }

    /**
     * @param arr        待排数组
     * @param bucketSize 桶个数
     * @param maxValue   数据的最大值
     */
    public static void bucketSort(int[] arr, int bucketSize, int minValue, int maxValue) {
        ArrayList<Integer>[] buckets = new ArrayList[bucketSize];

        // 初始化桶
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 把数据装到桶中
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = findWhichBucket(bucketSize, maxValue, arr[i]);
            if (bucketIndex != -1) {
                buckets[bucketIndex].add(arr[i]);
            } else {
                // 最后一个桶装超过最大桶的数据
                // 如桶：1~10、11~20...41~50，桶大小为5，超过50之后无法装入，桶排序的限制
                // 这里做个简单处理，把51~54之间的数据丢到最后一个桶
                buckets[bucketSize - 1].add(arr[i]);
                //System.out.println("数据" + arr[i] + "无法装入桶");
            }
        }

        // 每个桶做内排序
        for (int i = 0; i < bucketSize; i++) {
            buckets[i].sort(Integer::compareTo);
        }

        int index = 0;
        for (int i = 0; i < bucketSize; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    /**
     * 寻找元素是在哪个桶
     *
     * @param bucketSize 桶个数
     * @param maxValue   元素最大值
     * @return 找到的桶的索引，找不到返回-1
     */
    public static int findWhichBucket(int bucketSize, int maxValue, int eleValue) {

        for (int i = 0; i < bucketSize; i++) {
            for (int j = i * (maxValue / bucketSize) + 1; j <= (i + 1) * (maxValue / bucketSize); j++) {
                if (eleValue == j) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 2, 5, 8, 10, 13, 15, 19, 53, 51, 42, 38, 33, 28, 18, 10, 19};

        // 传递数组和桶个数
        bucketSort(arr, 5);

        System.out.println(Arrays.toString(arr));
    }
}
