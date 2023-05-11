package com.example.算法.class1位运算;

import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Test2 {

    public static void main(String[] args) {
        BigDecimal last1 = null;
        BigDecimal last2 = new BigDecimal("33.33");
        System.out.println(last1.subtract(last2));

        BigDecimal now = new BigDecimal("12.22");
        BigDecimal last = new BigDecimal("10.22");
        last = new BigDecimal("0");
        System.out.println(last);
        BigDecimal zhi = now.subtract(last).divide(last,2, BigDecimal.ROUND_HALF_UP);
        System.out.println(now.subtract(last));
        System.out.println(now.subtract(last).divide(last,2, BigDecimal.ROUND_HALF_UP));

        System.out.println(zhi);


        BigDecimal ce = new BigDecimal("1002.34234").multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(ce);


        String  str = "AL";
        System.out.println(str.toLowerCase());
        String pathname = "hello.txt";
        int prefixLength = 10000;

        File file =  new File(pathname, String.valueOf(prefixLength));


        List<File> l = new ArrayList<>();
        //l.add(file);
        File f = l.get(0);
        System.out.println(f);








    }

    @Test
    public void test1() {
        int[] arr = {5,7,9,3,2,6};
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++)    {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i] > arr[j]) {
                    //1.第三个变量
                    //int tmp = arr[j];
                    //arr[j] = arr[i];
                    //arr[i] = tmp;

                    //2.使用加减法 A = A + B; B = A - B; A = A - B;
                    //arr[i] = arr[i] + arr[j];
                    //arr[j] = arr[i] - arr[j];
                    //arr[i] = arr[i] - arr[j];
                    //请注意，当两个变量的值非常大时，使用加减法交换可能会导致溢出。因此，在处理较大的值时，请使用其他方法来交换变量的值。


                    //3.使用异或
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 交换方法
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }




}
