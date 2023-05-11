package com.example.test.base;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.*;


public class Test1 {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    //基本类型转换
    @Test
    public void test0() {
        String str = "100";
        int str2 = Integer.parseInt(str);
        long str3 = Long.parseLong(str);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        Integer dd = str2;
        Long ddd = str3;
        System.out.println(dd);
        System.out.println(ddd);
    }

    //list 转 数组
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>();
        list1.add("aaaa");
        list1.add("bbb");
        list1.add("ccc");
        String[] arr = list1.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

        List<Integer> intList = new ArrayList<>();
        intList.add(111);
        intList.add(222);
        intList.add((333));
        Integer[] intArr = intList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(intArr));

    }

    //数组 转 list
    @Test
    public void test2() {
        //方法一
        String[] strArr = {"aaa","bbb","ccc"};
        List<String> strList = Arrays.asList(strArr);
        System.out.println(strList);

        System.out.println(JSONUtil.toJsonStr(strArr)); //list 转 json

        //方法二
        List<String> list = new ArrayList<>();
        Collections.addAll(list,strArr);
        System.out.println(list);

    }

    //循环遍历map
    @Test
    public void test3(){
        HashMap<String,String> hm = new HashMap<>();
        hm.put("aaa","111");
        hm.put("bbb","222");
        hm.put("ccc","333");
        System.out.println(JSONUtil.toJsonStr(hm));

        //一、for循环 + Entryset
        //首先通过map.entrySet()方法，可以获取到一个Set集合，这个集合中的每一个元素就是Map中的一个键值对。
        //然后通过循环遍历这个Set集合，可以依次取出每对的键和值。
        //该方法使用了foreach循环，代码简洁明了，且能获取Map的键和值，是最常见且多数情况最可取的遍历方式。
        for(Map.Entry<String,String> entry:hm.entrySet()) {
            System.out.println("key:" + entry.getKey() + "---> val:" + entry.getValue());
        }
        System.out.println("\r\n");

        //二、Iterator + Entryset
        //Entry是Map接口的内部接口，获取迭代器，然后循环依次取出每个迭代器里面的Entry，
        //再通过Entry取出每个键值对。该种方法看起来冗余，却是老版本java中遍历map的唯一方式。
        //第一种遍历方法其实是这种方法通过语法糖做的一种编码方式，其本质是一样的。所以在性能方面，两种方法基本相同。
        //另外，如果在遍历过程中，有删除某些键值对的需求，需要使用这种遍历方式。
        Iterator<Map.Entry<String,String>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry=iterator.next();
            System.out.println("key:" + entry.getKey() + "---> val:" + entry.getValue());
        }
        System.out.println("\r\n");

        //三、for循环 + KeySet（效率低）
        // 通过map.keySet()方法可以获取Map的所有key的集合（set）。
        // 然后通过遍历这个Set就可以遍历到Map的key，如果想要同时遍历到Map的value，
        // 则需要进一步通过key来从Map这个集合中获取对应的value。
        // 【不推荐，只能获取key，要想获取对应的value，需要重复计算】
        // 这个代码看上去比方法二简洁，但实际上效率非常低。因为从键取值是耗时的操作（
        // 与方法一、二相比，在不同的Map实现中该方法慢了20%~200%，所以尽量避免使用。
        for(String key : hm.keySet()) {
            System.out.println("key:" + key+ "---> val:" + hm.get(key));
        }
        System.out.println("\r\n");

        //四、Iterator + Keyset（效率低）
        // 与第三种方法类似，只是将循环遍历换成了迭代器。性能提升微乎其微，同样不推荐使用。
        Iterator<String> iterator1 = hm.keySet().iterator();
        while (iterator1.hasNext()) {
            String key =iterator1.next();
            System.out.println("key:" + key + "---> val:" + hm.get(key));
        }
        System.out.println("\r\n");

        //五、lambda表达式
        // 从Java8开始，Java提供了对Lambda表达式的支持，通过Lambda表达式可以使代码更简洁，这其中就包括用Lambda表达式实现遍历Map的功能。
        // Lambda表达式的forEach方法，其实就是一种语法糖，可以让代码更加简洁，使用更加方便。查看源码，我们可以发现，这种方式也是对entrySet遍历方式的一种包装。
        hm.forEach((key,value)->{
            System.out.println("key:" + key + "---> val:" + value);
        });
        System.out.println("\r\n");

        //六 、Stream流
        // 如果Map集合存在一些中间处理，可以过滤操作，使用流式遍历也很方便。
        hm.entrySet().stream().forEach((Map.Entry<String,String> entry) -> {
            System.out.println("key:" + entry.getKey() + "---> val:" + entry.getValue());
        });
        System.out.println("\r\n");

        //总结
        //1.EntrySet的方式比KeySet性能要好，原因在于keySet相当于遍历了2次。

        //2.map.get(key)是计算密集型操作，很耗费CPU。

        //3.EntrySet的Iterator遍历的效率比for循环效率更好。

        //4.lambda 表达式和Entryset的底层原理相同，且语法更加简洁。

        //结论：JAVA8以下推荐使用方法一、二，JAVA8及以上，推荐使用方法五。

    }


    @Test
    public void test4() {

        System.out.println("hello");

    }


}
