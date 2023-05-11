package com.example.算法.class4排序;

/**
 * @author : baifuquan
 * @date : 2022/7/20 15:46
 * @className : Test
 * @description : Test
 **/
public class Test {


    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectSort(int[] arr) {
        //边界
        if (arr != null && arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~ n-1
        // i ~ n-1
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // 最小值的位置
            int minValueIndex = i;
            // 0 ~ n-1
            // 1 ~ n-1
            // 2 ~ n-1
            // i ~ n-1
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 交换方法
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 3, 8, 4, 6};
        printArr(arr);
        selectSort(arr);
        printArr(arr);
    }
}
