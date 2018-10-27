package me.galliliu._10_sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author galliliu
 * @createTime 2018-10-27
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr 待排数组
     */
    public static void mergeSort(int[] arr) {
        mergeSortC(arr, 0, arr.length - 1);
    }


    /**
     * 归并排序递归
     *
     * @param arr 待排数组
     * @param p   第一个元素下标
     * @param r   最后一个元素下标
     */
    private static void mergeSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        // 分解
        mergeSortC(arr, p, q);
        mergeSortC(arr, q + 1, r);
        // 合并
        merge(arr, p, q, r);
    }

    /**
     * 合并两个有序数组
     *
     * @param arr
     * @param p   起始位置
     * @param q   中间位置
     * @param r   结束位置
     */
    private static void merge(int[] arr, int p, int q, int r) {
        int[] arr1 = Arrays.copyOfRange(arr, p, q + 1);
        int[] arr2 = Arrays.copyOfRange(arr, q + 1, r + 1); //size = r - (q + 1) + 1

        int i, j;
        i = j = 0;
        int k = p;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 10, 5};

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
