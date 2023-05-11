package com.example.test.base;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        String[] deptgw = {"北京","天津","冀北","河北","山西","山东","上海","江苏","浙江","安徽","福建","湖北","湖南","河南","江西","辽宁","言林","黑龙江","内蒙","陕西","甘肃","青海","宁夏","新疆","四川","重庆","西藏"};
        String[] bbDept = {"国网山西超高压（变电）公司","国网山西超高压(变电)公司","国网山西超高压（输电）公司","国网山东超高压公司","国网上海超高压公司","国网江苏超高压公司","国网安徽招高压公司","国网福建超高压公司","国网湖北超高压（直流）公司","国网湖北超高压公司","国网河南超高压公司","国网四川超高压公司","国网重庆招高压公司","国网陕西超高压公司","国网甘肃超高压公司","国网青海超高压公司","国网宁夏超高压公司","国网新疆超高压公司"};
        List<String> deptGW  = new ArrayList<>(Arrays.asList(deptgw));
        List<String> deptBB  = new ArrayList<>(Arrays.asList(bbDept));

        sort1(deptBB,deptGW);

        System.out.println(JSONUtil.toJsonStr(bbDept));
    }

    private static List<String> sort(List<String> targetList, List<String> orderList){
        List<String> nDept = new ArrayList<>();
        List<String> bj = new ArrayList<>();
        List<String> tj = new ArrayList<>();
        List<String> jb = new ArrayList<>();
        List<String> hb = new ArrayList<>();
        List<String> sx = new ArrayList<>();
        List<String> sd = new ArrayList<>();
        List<String> sh = new ArrayList<>();
        List<String> js = new ArrayList<>();
        List<String> zj = new ArrayList<>();
        List<String> ah = new ArrayList<>();
        List<String> fj = new ArrayList<>();
        List<String> hubei = new ArrayList<>();
        List<String> hunan = new ArrayList<>();
        List<String> jiangxi = new ArrayList<>();
        List<String> liaoni = new ArrayList<>();
        List<String> jilin = new ArrayList<>();
        List<String> heilongjiang = new ArrayList<>();
        List<String> neimenggu = new ArrayList<>();
        List<String> shanxi = new ArrayList<>();
        List<String> gansu = new ArrayList<>();
        List<String> qinghai = new ArrayList<>();
        List<String> ningxia = new ArrayList<>();
        List<String> xinjiang = new ArrayList<>();
        List<String> sichuan = new ArrayList<>();
        List<String> chongqing = new ArrayList<>();
        List<String> xizang = new ArrayList<>();


        return nDept;
    }

    // 根据orderList顺序排序，orderList不存在的元素放置在targetList最后面
    private static void sort1(List<String> targetList, List<String> orderList) {


        targetList.sort(((o1, o2) -> {
            int io1 = orderList.indexOf(o1);
            int io2 = orderList.indexOf(o2);
            if (io1 != -1) {
                io1 = targetList.size() - io1;
            }
            if (io2 != -1) {
                io2 = targetList.size() - io2;
            }
            return io2 - io1;
        }));
    }
}
