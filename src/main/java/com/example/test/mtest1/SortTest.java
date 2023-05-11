package com.example.test.mtest1;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : baifuquan
 * @date : 2022/6/15 11:01
 * @className : SortTest
 * @description : 排序算法实现
 **/
public class SortTest {


    /**
     * 简单选择排序：
     * 基本思想是：首先在 n 个元素中找到最小元素，将其
     * 放在 A[0]中，然后在剩下的 n-1 个元素中找到最小的放到 A[1]中，这个过程不断进行下去，
     * 直到在最后2个元素中找到小的并将其放到 A[n-2]中。
     */
    @Test
    public void selectSort() {
        int[] arr = {5, 3, 2, 6, 4};
        //长度
        int length = arr.length;
        //假设第一个元素是最小值，则循环的轮数是 n-1
        for (int k = 0; k < length - 1; k++) {
            //假设最小值的元素的位置min
            int min = k;
            //每轮比较的次数是
            for (int i = k + 1; i < length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            if (min != k) {
                int temp = arr[k];
                arr[k] = arr[min];
                arr[min] = arr[temp];
            }
        }
        System.out.println(JSONUtil.toJsonStr(arr));

    }

    @Test
    public void selectSort1() {
        int[] a = {5, 3, 2, 6, 4};
        //长度
        int len = a.length;
        // 循环的轮次 len - 1 ，假设第一个位置是最小的
        for (int k = 0; k < len - 1; k++) {
            // 假设最小的元素位置是 k=0
            int min = k;
            //比较本轮循环 后面的元素有没有更小的
            for (int i = k + 1; i < len; i++) {
                //
                if (a[i] < a[min]) {
                    min = i;
                }
            }
            // 判断k是不是本轮比较中最小的元素
            if (k != min) {
                int temp = a[k];
                a[k] = a[min];
                a[min] = temp;
            }
            System.out.println(JSONUtil.toJsonStr(a));
        }
        System.out.println(JSONUtil.toJsonStr(a));
    }

    /**
     * 直接插入排序
     * 基本思想是：仅有一个元素的序列总是有序的。
     * 因此对 n 个记录的序列，可从第二个元素开始直到第 n 个元素，逐个向有序序
     * 列中执行插入操作，从而得到 n 个元素按关键字有序的序列
     */
    @Test
    public void insertionSort() {
        int[] arr = {5, 3, 2, 6, 4};
        System.out.println("排序前的结果为：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
            System.out.println("第" + i + "轮的排序结果为：" + Arrays.toString(arr));
        }
        System.out.println(JSONUtil.toJsonStr(arr));
        System.out.println("第二种写法");
        insertionSort1();
    }

    /**
     * 直接插入排序2
     * 基本思想是：仅有一个元素的序列总
     * 是有序的，因此，对 n 个记录的序列，可从第二个元素开始直到第 n 个元素，逐个向有序序
     * 列中执行插入操作，从而得到 n 个元素按关键字有序的序列
     * https://blog.csdn.net/qq_48718409/article/details/120866840
     */
    @Test
    public void insertionSort1() {
        int[] numbers = {5, 3, 2, 6, 4};
        System.out.println("排序前的结果为：" + Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) { //控制循环轮数
            int temp = numbers[i]; //定义待交换元素
            int j; //定义待插入的位置
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                System.out.println(j);
                System.out.println(numbers[j - 1]);
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
            System.out.println("第" + i + "轮的排序结果为：" + Arrays.toString(numbers));
        }
        System.out.println("排序后的结果为：" + Arrays.toString(numbers));
        System.out.println(JSONUtil.toJsonStr(numbers));
    }

    @Test
    public void insertionSort11() {
        int[] arr = {5, 3, 2, 6, 4};
        System.out.println("排序前的数据：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            System.out.println("第" + i + "轮排序前: " + Arrays.toString(arr));
            //定义交换元素
            int temp = arr[i];
            //定义插入位置
            int j;
            //比较剩余无需数据
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            System.out.println("第" + i + "轮排序后: " + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }


}
