package com.example.mtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : baifuquan
 * @date : 2022/7/4 10:13
 * @className : Test1
 * @description : 两数只和：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 
 * 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 **/
public class Test2TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
//        int[] result = twoSum(nums,target);
        int[] result = twoSum1(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力求解 o(n^2):
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;

    }

    /**
     * 一遍hash o(n)
     * HashMap key存元素，val存该元素下标
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
