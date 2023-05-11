package com.example.mtest;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * @author : baifuquan
 * @date : 2022/7/4 14:33
 * @className : Test4Sort
 * @description : 排序
 **/
public class Test4Sort {

    public static void main(String[] args) {
        Test4Sort sort = new Test4Sort();

        int[] nums = {5, 3, 7, 2, 9, 1};
//        int[] res = insertSort1(nums);

        int[] res = sort.quickSort(nums, 0, nums.length - 1);
        System.out.println(JSONUtil.toJsonStr(res));
        System.out.println("hello");
    }

    /**
     * 快速排序：
     * 时间复杂度:平均O(n logn) 最好O(n logn),最坏O(n^2)
     * 空间复杂度：O(logn)
     * 基本是想：快速排序是将分治法运用到排序问题中的一个典型例子，快速排序的基本思想是：通过
     * 一个枢轴（pivot）元素将 n 个元素的序列分为左、右两个子序列 Ll 和 Lr，其中子序列 Ll
     * 中的元素均比枢轴元素小，而子序列 Lr 中的元素均比枢轴元素大，然后对左、右子序列分
     * 别进行快速排序，在将左、右子序列排好序后，则整个序列有序，而对左右子序列的排序过
     * 程直到子序列中只包含一个元素时结束，此时左、右子序列由于只包含一个元素则自然有序
     */
    public int[] quickSort(int[] nums, int low, int high) {
        if (low >= high) return null;
        int keypos = partition(nums, low, high);
        quickSort(nums, low, keypos - 1);
        quickSort(nums, keypos + 1, high);
        return nums;
    }

    int partition(int a[], int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] >= key) high--;
            a[low] = a[high];
            while (low < high && a[low] <= key) low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    /**
     * 第二种插入排序： while
     *
     * @param nums
     * @return
     */
    public int[] insertSort1(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            //前一个下标
            int preIndex = i - 1;
            //当前元素
            int current = nums[i];
            //当前插入的，小于前一个则交换
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex -= 1;
            }
            nums[preIndex + 1] = current;
            System.out.println("第" + i + "轮的排序结果为：" + Arrays.toString(nums));
        }

        return nums;
    }

    /**
     * 插入排序:
     * 时间复杂度:平均O(n^2) 最好O(n),最坏O(n^2)
     * 空间复杂度：O(1)
     * 基本思想是：仅有一个元素的序列总是有序的
     * 因此，对 n 个记录的序列，可从第二个元素开始直到第 n 个元素，逐个向有序序
     * 列中执行插入操作，从而得到 n 个元素按关键字有序的序列
     */
    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //定义待交换的元素
            int temp = nums[i];
            //定义待插入的位置
            int j;
            for (j = i; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 选择排序:
     * 时间复杂度:平均O(n^2) 最好(n^2),最坏(n^2)
     * 空间复杂度：O(1)
     * 基本思想是：首先在 n 个元素中找到最小元素，将其放在 A[0]中，
     * 然后在剩下的 n-1 个元素中找到最小的放到 A[1]中，这个过程不断进行下去，直到在最后2个元素中找到小的并将其放到 A[n-2]中.
     * 假设一个最小的（下标为0的最小），下一个比最小的还小，则交换位置
     */
    public int[] selectSort(int[] nums) {
        //假设第一个元素是最小值，则循环的轮数是 n-1
        for (int k = 0; k < nums.length - 1; k++) {
            //假设最小值
            int min = k;
            // 每轮比较的次数是
            for (int i = k + 1; i < nums.length; i++) {
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            // 如果k不是最小值的位置，交换还俗
            if (min != k) {
                int tmp = nums[min];
                nums[min] = nums[k];
                nums[k] = tmp;
            }
        }
        return nums;
    }

    /**
     * 冒泡排序:
     * 时间复杂度:平均O(n^2) 最好O(n),最坏O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }


}
