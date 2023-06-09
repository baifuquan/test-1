package com.example.test.suanfa1;

/**
 * @author : baifuquan
 * @date : 2022/6/21 15:55
 * @className : Demo2
 * @description : 你是产品经理，目前正在带领一个团队开发新的产品。
 * 不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 **/
public class Demo2 {
    public static void main(String[] args) {

        int[] versions = new int[]{};
    }

    //给定 n = 5，并且 version = 4 是第一个错误的版本。

    /**
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号
     * version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * 链接：https://leetcode.cn/problems/first-bad-version
     * @return
     */
    public int firstBadVersion(int n) {
        int st = 1;
        while (st <= n) {

            int mid = st + (n - st) / 2;
//            if (isBadVersion(mid)) {
//                n = mid - 1;
//            } else {
//                st = mid + 1;
//            }
            return st;
        }
        return 1;
    }
}
