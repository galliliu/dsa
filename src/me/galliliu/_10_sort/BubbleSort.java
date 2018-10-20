package me.galliliu._10_sort;

import java.util.List;
import java.util.ListIterator;

/**
 * 冒泡排序
 *
 * @author galliliu
 * @createTime 2018-10-20
 */
public class BubbleSort implements ISort {
    @Override
    public <T> void sort(List<T> list) {
        Object[] array = list.toArray();

        // Do sort
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
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

