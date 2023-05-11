package com.example.test.suanfa1;

/**
 * @author : baifuquan
 * @date : 2022/6/21 15:20
 * @className : Demo1
 * @description : Demo1
 **/
public class Demo1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int res = binarySearch(arr, target);
        System.out.println(res);
    }

    /**
     * 二分查找法，
     * 有序的数据
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target
     * ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * 思路：
     */
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            ////如果目标值小于中间值，则从左边找
            if (arr[middle] > target) {
                end = middle - 1;
                //如果目标值大于中间值，从右边找
            } else if (arr[middle] < target) {
                start = middle + 1;
            } else {
                System.out.println(middle);
                return middle;
            }
        }
        return -1;
    }


}
