package me.galliliu._10_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author galliliu
 * @createTime 2018-10-28
 */
public class QuickSort {

    /**
     * 快速排序实现
     *
     * @param arr 待排数组
     */
    public static void quickSort(int[] arr) {
        quickSortC(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序递归实现
     *
     * @param arr 待排数组
     * @param p   起始元素下标
     * @param r   最后元素下标
     */
    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        //int q = partition(arr, p, r);
        //int q = partitionByRandom(arr, p, r);
        int q = partitionByMidValue(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }

    /**
     * 分区实现，直接使用最后一个元素作为分区点，寻找pivot位置并返回
     *
     * @param arr 待排数组
     * @param p   起始元素下标
     * @param r   最后元素下标
     * @return
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);

        return i;
    }

    /**
     * 分区实现，随机选择分区点，寻找pivot位置并返回
     *
     * @param arr 待排数组
     * @param p   起始元素下标
     * @param r   最后元素下标
     * @return
     */
    private static int partitionByRandom(int[] arr, int p, int r) {
        //随机选择分区点
        int t = new Random().nextInt(r + 1 - p) + p;
        swap(arr, r, t);

        return partition(arr, p, r);
    }

    /**
     * 分区实现，三或五点取中间值作为分区点，寻找pivot位置并返回
     *
     * @param arr 待排数组
     * @param p   起始元素下标
     * @param r   最后元素下标
     * @return
     */
    private static int partitionByMidValue(int[] arr, int p, int r) {
        //从[p,r]选择三或五点并取中间值作为分区点，这里取三点的中值
        int t = new Random().nextInt(r + 1 - p) + p;
        if (arr[p] < arr[t]) {
            if (arr[t] < arr[r]) {
                swap(arr, t, r); //取arr[t]作为中值
            } else {
                if (arr[p] > arr[r]) {
                    swap(arr, p, r);//取arr[p]作为中值
                }
                //默认选择arr[r]作为中值
            }
        } else {
            if (arr[t] > arr[r]) {
                swap(arr, t, r); //取arr[t]作为中值
            } else {
                if (arr[p] < arr[r]) {
                    swap(arr, p, r);//取arr[p]作为中值
                }
                //默认选择arr[r]作为中值
            }
        }

        return partition(arr, p, r);
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 10, 5, 5, 4, 8, 22, 10, 87, 3};

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
