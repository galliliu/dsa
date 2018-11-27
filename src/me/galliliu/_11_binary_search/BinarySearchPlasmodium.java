package me.galliliu._11_binary_search;

/**
 * 二分查找变形
 * 说明：数组数据可以重复
 *
 * @author galliliu
 * @createTime 2018-11-26
 */
public class BinarySearchPlasmodium {

    /**
     * 二分查找递归实现：查找第一个值等于给定值的元素
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearchFirstItem(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            //int index = binarySearchFirstItem(arr, low, mid - 1, target);
            //return index == -1 ? mid : index;
            if (mid == 0 || (arr[mid - 1] != target)) {
                return mid;
            } else {
                return binarySearchFirstItem(arr, low, mid - 1, target);
            }
        } else if (arr[mid] > target) {
            return binarySearchFirstItem(arr, low, mid - 1, target);
        } else {
            return binarySearchFirstItem(arr, mid + 1, high, target);
        }
    }

    /**
     * 二分查找递归实现：查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearchLastItem(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            //int index = binarySearchLastItem(arr, mid + 1, high, target);
            //return index == -1 ? mid : index;
            if (mid == high || arr[mid + 1] != target) {
                return mid;
            } else {
                return binarySearchLastItem(arr, mid + 1, high, target);
            }
        } else if (arr[mid] > target) {
            return binarySearchLastItem(arr, low, mid - 1, target);
        } else {
            return binarySearchLastItem(arr, mid + 1, high, target);
        }
    }

    /**
     * 二分查找递归实现：查找第一个值大于等于给定值的元素
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearchFirstEqOrGtItem(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] >= target) {
            //int index = binarySearchFirstEqOrGtItem(arr, low, mid - 1, target);
            //return index == -1 ? mid : index;
            if (mid == 0 || arr[mid - 1] < target) {
                return mid;
            } else {
                return binarySearchFirstEqOrGtItem(arr, low, mid - 1, target);
            }
        } else {
            return binarySearchFirstEqOrGtItem(arr, mid + 1, high, target);
        }
    }

    /**
     * 二分查找递归实现：查找最后一个值小于等于给定值的元素
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return 返回找到的目标元素的下标
     */
    public static int binarySearchFirstEqOrLtItem(int[] arr, int low, int high, int target) {
        if (low < 0 || high >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界了");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] <= target) {
            //int index = binarySearchFirstEqOrLtItem(arr, mid + 1, high, target);
            //return index == -1 ? mid : index;
            if (mid == high || arr[mid + 1] > target) {
                return mid;
            } else {
                return binarySearchFirstEqOrLtItem(arr, mid + 1, high, target);
            }
        } else {
            return binarySearchFirstEqOrLtItem(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int firstItemIndex = binarySearchFirstItem(new int[]{0, 0, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 13, 0);
        System.out.println("firstItemIndex: " + firstItemIndex);

        int lastItemIndex = binarySearchLastItem(new int[]{0, 0, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10}, 0, 14, 10);
        System.out.println("lastItemIndex: " + lastItemIndex);

        int firstEqOrGtItemIndex = binarySearchFirstEqOrGtItem(new int[]{0, 0, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 13, 2);
        System.out.println("firstEqOrGtItemIndex: " + firstEqOrGtItemIndex);

        int firstEqOrLtItemIndex = binarySearchFirstEqOrLtItem(new int[]{0, 0, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10}, 0, 14, 2);
        System.out.println("firstEqOrLtItemIndex: " + firstEqOrLtItemIndex);
    }
}
