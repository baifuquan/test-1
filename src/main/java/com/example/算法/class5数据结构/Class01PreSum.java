package com.example.算法.class5数据结构;

/**
 * @author : baifuquan
 * @date : 2022/7/8 18:21
 * @className : Class01PreSum
 * @description :
 * 题目：求累加和
 * 一个数组[5,4,2,3,5,2,3,5]，sum(arr,l,r);频繁的求一个数组l位置到r位置的和。
 **/
public class Class01PreSum {

    public static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * 图标算法
     */
    public static class RangeSum1 {
        private int[] arr;

        public RangeSum1(int[] array) {
            arr = array;
        }

        public int rangeSum(int l, int r) {
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    /**
     * 前缀和数组算法
     */
    public static class RangeSum2 {
        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int l, int r) {
            return l == 0 ? preSum[r] : preSum[r] - preSum[l - 1];
        }
    }

    public static void main(String[] args) {

        RangeSum1 rangeSum1 = new RangeSum1(array);
        RangeSum2 rangeSum2 = new RangeSum2(array);
        int sum1 = rangeSum1.rangeSum(3, 5);
        int sum2 = rangeSum2.rangeSum(3, 5);
        System.out.println(sum1);
        System.out.println(sum2);
    }


}
