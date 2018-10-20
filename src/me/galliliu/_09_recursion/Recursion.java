package me.galliliu._09_recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 递归
 *
 * @author galliliu
 * @createTime 2018-10-20
 */
public class Recursion {
    //全局变量，控制递归调用次数
    public static int nthFnCall = 0;

    /**
     * 给定台阶数，一次走一步或两步，一共多少种，递归实现
     *
     * @param n 台阶数
     * @return 走法总数
     */
    public static int nSteps(int n) {
        /*
            递推公式：
            f(n) = f(n - 1) + f(n-2)
            f(1) = 1
            f(2) = 2
         */
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return nSteps(n - 1) + nSteps(n - 2);
    }

    /**
     * 给定台阶数，一次走一步或两步，一共多少种，非递归（循环迭代）实现
     *
     * @param n 台阶数
     * @return 走法总数
     */
    public static int nStepsNoRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        /*
            n: 0 1 2 3 4 5 6 ...
            r: 0 1 1 2 3 5 8 ...
         */
        int totalCount = 1;
        int prevCount = 0;
        int temp;
        for (int i = 1; i <= n; i++) {
            temp = totalCount;
            totalCount += prevCount;
            prevCount = temp;
        }
        return totalCount;
    }


    /**
     * 控制递归调用次数
     *
     * @param n
     * @return
     */
    public static int callFnDeptControl(int n) {
        if (nthFnCall == 10) {
            return n;
        } else {
            nthFnCall++;
            return callFnDeptControl(n - 1);
        }
    }

    /**
     * n阶乘求解
     *
     * @param n
     * @param computedResut 中间计算结果
     * @return 返回阶乘结果
     */
    public static int nFactorial(int n, Map<Integer, Integer> computedResut) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (computedResut.containsKey(n)) {
            return n * computedResut.get(n);
        } else {
            //保存计算结果
            int temp = n * nFactorial(n - 1, computedResut);
            computedResut.put(n, temp);
            return temp;
        }
    }

    /**
     * n阶乘求解，非递归（手动模拟栈）实现
     *
     * @param n
     * @return 返回阶乘结果
     */
    public static int nFactorialNoRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        //使用栈模拟
        LinkedList<Integer> numberStack = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            numberStack.push(i);
        }

        //弹栈，并计算结果
        int res = 1;
        while (!numberStack.isEmpty()) {
            res = res * numberStack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(nSteps(7));
        System.out.println(nStepsNoRecursion(7));

        System.out.println(callFnDeptControl(5));
        System.out.println(callFnDeptControl(20));

        System.out.println(nFactorial(6, new HashMap<>()));

        System.out.println(nFactorialNoRecursion(5));
    }
}
