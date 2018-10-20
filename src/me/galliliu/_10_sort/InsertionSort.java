package me.galliliu._10_sort;

import java.util.List;
import java.util.ListIterator;

/**
 * 插入排序
 *
 * @author galliliu
 * @createTime 2018-10-20
 */
public class InsertionSort implements ISort {
    /**
     * @param list the {@code <T>} list to sort.
     */
    @Override
    public <T> void sort(List<T> list) {
        Object[] array = list.toArray();

        // Do sort
        for (int i = 1; i < array.length; i++) {
            Comparable key = (Comparable) array[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        // Assign sorted datum to the list
        int i = 0;

        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set((T) array[i++]);
        }
    }

    /**
     * @param list the {@code <T>} list to sort.
     */
    public <T> void enhancedSort(List<T> list) {
        Object[] array = list.toArray();

        // Do sort
        for (int i = 1; i < array.length; i++) {
            Comparable key = (Comparable) array[i];

            // Binary search
            int start = 0;
            int end = i - 1;
            int mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                if (key.compareTo(array[mid]) < 0) {
                    end = mid - 1;
                } else if (key.compareTo(array[mid]) >= 0) {
                    start = mid + 1;
                }
            }

            for (int j = i; j > start; j--) {
                array[j] = array[j - 1];
            }
            array[start] = key;
        }

        // Assign sorted datum to the list
        int i = 0;

        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set((T) array[i++]);
        }
    }
}
