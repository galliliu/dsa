package me.galliliu._10_sort;

import java.util.List;
import java.util.ListIterator;

/**
 * 选择排序
 *
 * @author galliliu
 * @createTime 2018-10-20
 */
public class SelectionSort implements ISort {
    @Override
    public <T> void sort(List<T> list) {
        Object[] array = list.toArray();

        // Do sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (((Comparable) array[i]).compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }

        // Assign sorted datum to the list
        int i = 0;
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set((T) array[i++]);
        }
    }

    private void swap(Object[] array, int i, int j) {
        Object temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

