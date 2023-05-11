package com.example.算法.class4排序;

import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/7/8 15:35
 * @className : TestSort
 * @description : TestSort
 **/
public class TestSort {

    /**
     * 选择排序:
     * [0....N-1]找到最小的，放到0位置
     * [1...N-1]找到最小的，放到1位置
     * [2...N-1]找到最小的，放到2位置
     */
    public static void selectSort(int[] arr) {
        // 先想边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        // 0 - n-1
        // 1 - n-1
        // 2 - n-1
        // i - n-1
        for (int i = 0; i < n; i++) {
            // 0 - n-1
            // 1 - n-1
            // 2 - n-1
            // i - n-1
            int minValueIndex = i; // i
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序:
     * 思想：谁大谁往后交换，两层循环，每一轮次比较，最后一个位置一定放最大值。
     * 两个循环，一层轮次，一层每轮比较的次数。
     * 数组：[4,1,2,3,6,5,7,7]
     * 索引： 0 1 2 3 4 5 6 7
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //边界判断
        if (arr == null || arr.length < 2) {
            return;
        }
        //0 ~ n-1 做一些事情
        //0 ~ n-2 做一些事情
        //0 ~ n-3 做一些事情
        //0 ~ n-4 做一些事情
        //0 ~ end 做一些事情
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            //0 ~ end 做一些事情
            // 0和1 位置要不要换，1和2 ，2和3 ... end-1和end要不要换
            // 怎么描述？可以用开头作为变量来描述做这些事，也可以用结尾作为变量来描述，比如
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }

    }

    /**
     * 插入排序：
     * <p>
     * 数组：[4,1,2,3,6,5,7,7]
     * 索引： 0 1 2 3 4 5 6 7
     * 思想：
     * 1.想让0 ~ 0 范围上有序 已经完成
     * 2.想让0 ~ 1 范围上有序 做这件事
     * 3.想让0 ~ 2 范围上有序 做这件事
     * 4.想让0 ~ 3 范围上有序 做这件事
     * 4.想让0 ~ n-1 范围上有序 做这件事
     * 结尾位置在变
     *
     * @param arr
     */
    public static void insertSort1(int[] arr) {
        //边界判断
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            //当前数所在的位置
            int newNumIndex = end;
            // end -1 >= 0 说明左边有序的列有数。
            // arr[end -1] > arr[end], 左边的数比当前数还大，则交换
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
            //解释：newNumIndex - 1 >= 0 当左边不在有数了
            // arr[newNumIndex - 1] > arr[newNumIndex] 左边的数不比当前数大了，则while循环停止
        }
    }

    /**
     * 插入排序优化版
     *
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        //边界判断
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            // pre = end - 1 当前数的前一个位置，新数的前一个位置
            // pre >= 0 没越界
            // arr[pre] > arr[pre + 1] 前一个位置的数比当前位置的数还大
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }

    }

    //交换写法，常规
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * 题目：返回一个数组 arr ，arr长度是[0 , maxLen-1]，arr中的每个值是[0,maxValue-1].
     * 思路：
     * 1.定义长度随机的数组
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        //定义长度随机的数组
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 拷贝一个相同的数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ans[i];
        }
        return ans;
    }

    /**
     * 验证两个数组的值是否相同
     * arr1 和 arr2 长度一样
     *
     * @return  i
     */
    public static boolean equalValues(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个数组是不是有序的
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 4, 2, 5, 3, 0, 1, 8};
        int[] arr1 = lenRandomValueRandom(8, 19);

        int[] arr2 = copyArray(arr1);
        printArr(arr1);
        insertSort2(arr1);
        printArr(arr1);
        if (!isSorted(arr2)) {
            System.out.println("排序错了");
        }

    }

}
