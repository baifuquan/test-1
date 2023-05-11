package com.example.test.suanfa1;

/**
 * @author : baifuquan
 * @date : 2022/6/21 16:13
 * @className : Demo3
 * @description : 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法
 * 链接：https://leetcode.cn/problems/search-insert-position
 **/
public class Demo3 {

    public static void main(String[] args) {
        //给定数组
        int[] nums = new int[]{3, 4, 8, 9, 12, 14, 16, 19};
        //给定目标值
        int target = 9;
        int target1 = 19;
        int res = searchInsert(nums, target1);
        System.out.println(res);
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * @param nums
     * @param target
     * @return 下标
     */
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        //注意这个地方不是长度减一
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                //注意这个地方是mid+1
                start = mid + 1;
            }
        }
        return start;
    }
}
