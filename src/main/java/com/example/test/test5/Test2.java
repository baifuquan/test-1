package com.example.test.test5;

/**
 * @author : baifuquan
 * @date : 2022/6/21 14:20
 * @className : Test2
 * @description : Test2
 **/
public class Test2 {
    // 数组，每个元素都是整数 ，数组元素 小->大->小 ; 求最大值

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 8, 6, 4, 3, 2, 0};
        int res = maxVal(nums);
        System.out.println(res);
    }

    /**
     * @param nums 数组
     * @return max
     * @description :数组，每个元素都是整数 ，数组元素 小->大->小 ; 求最大值
     * 要求：时间复杂度O（logN）
     */
    public static int maxVal(int[] nums) {
        // [1,3,5,8,6,4,3,2,0]
        int start = 0;
        int end = nums.length - 1;
        int max = -1;
        while (start >= 0 && end >= 0) {
            if (nums[start] <= nums[end]) {
                max = nums[end];
                start++;
            } else if (nums[start] > nums[end]) {
                max = nums[start];
                end--;
            }
            if (start == end) {
                max = nums[start];
                break;
            }
        }
        return max;

    }

}
