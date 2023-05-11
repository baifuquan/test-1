package com.example.算法.class6java随机函数random;

/**
 * @author : baifuquan
 * @date : 2022/7/8 18:30
 * @className : Test
 * @description : Test
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println("测试开始");

        // Math.random() [0,1) 范围。计算机里是有穷尽的，返回等概率的数据
        double ans = Math.random();
        System.out.println(ans);

        int testTimes = 100000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        //打印 小于0.3的概率
        System.out.println("打印 小于0.3的概率");
        System.out.println((double) count / (double) testTimes);
        System.out.println("=====================");

        // [0,1) -> [0,8)
        double ans1 = Math.random() * 8;
        // 小于4的概率
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        //打印 小于4的概率
        System.out.println("小于4的概率");
        System.out.println((double) count / (double) testTimes);


        int K = 9;
        // [0,K) - > [0,8)   0到8左闭右开的数等概率的次数，
        int[] counts = new int[9];// counts[0] 0出现的次数，counts[1] 1出现的次数...
        for (int i = 0; i < testTimes; i++) {
            int ans11 = (int) (Math.random() * K);
            counts[ans11]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数出现了 " + counts[i] + " 次");
            // 概率就是 K
        }

        System.out.println("=====================");


        //
        count = 0;
        double x = 0.62;
        for (int i = 0; i < testTimes; i++) {
            if (xToXpower3() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 3)); // 一个double类型的数，做平方，返回一个小数。


        System.out.println("=====================");
        //
        count = 0;
         x = 0.62;
        for (int i = 0; i < testTimes; i++) {
            if (xToXpower4() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 1- Math.pow((double) 1-x , 2)); // 一个double类型的数，做平方，返回一个小数。

    }

    // 对数器 申请一个范围内的数出现的随机数


    /**
     * 返回[0,1)范围上的一个小数
     * 任意的X，X属于[0,1),[0,X)范围上的数出现概率由原来的X调整成X的平方 x^2
     *
     * @return
     */
    public static double xToXpower2() {
        return Math.max(Math.random(), Math.random());
    }

    /**
     * 返回[0,1)范围上的一个小数
     * 任意的X，X属于[0,1),[0,X)范围上的数出现概率由原来的X调整成X的3平方 x^3
     *
     * @return
     */
    public static double xToXpower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    /**
     *  Math.min(Math.random(), Math.random());
     *
     * 如果要是改成 Math.min()是什么样？概率是什么？
     * Math.min()，第一次调用和第二次调用取最小值
     *
     * 答案：Math.min(Math.random(), Math.random()) = 1- (1-x)^2
     * 一次：[0,x)范围上的数，随机数出现的概率是x，那么，min最小值不在[0,x)范围内的概率就是 1- x
     * 另一次也是 min最小值不在[0,x)范围内的概率就是 1- x
     *
     * Math.min(Math.random(), Math.random()) = 1- (1-x)^2
     *
     */
    public static double xToXpower4() {
        return Math.min(Math.random(), Math.random());
    }

}
