package me.galliliu._11_binary_search;

/**
 * 二分查找
 *
 * @author galliliu
 * @createTime 2018-11-26
 */
public class BinarySearch {


    /**
     * 二分查找非递归实现
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearchRecursion(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length || low > high) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursion(arr, low, mid - 1, target);
        } else {
            return binarySearchRecursion(arr, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int index = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 10, 2);
        System.out.println(index);

        int indexj = binarySearchRecursion(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 10, 10);
        System.out.println(indexj);
    }
}
