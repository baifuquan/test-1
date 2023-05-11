package com.example.test.test3;

/**
 * @author : baifuquan
 * @date : 2022/5/21 11:09
 * @className : Test4
 * @description : Test4
 *
 *
 * 15:57
 * 返回 Java5道题(1).docx ...
 *
 * 共5题，时间15分钟，错3题则失去面试机会
 * 1.有如下表结构:
 * CREATE TABLE `user(
 * id`bigint(20) NOT NULL AUTO INCREMENT
 * password hashvarchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4 bin NOT NULL COMMENT密码的 hash 值，
 * login_name varchar(32)NOT NULL COMMENT登录名'
 * nickname`varchar(32) NOT NULL COMMENT'昵称，
 * create time`bigint(20)NOTNULLCOMMENT创建毫秒时间戳`update timebigint(20)NOTNULLCOMMENT更新毫秒时间戳'
 * PRIMARY KEY(`id`),
 * KEY `idx_nickname_update_time`(`nickname,`update_time`)
 * KEY `idxcreate time(`create time`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4 0900 ai ci
 *
 * mysql 云主机1c2g，数据量大概在10000000 左右，哪条SQL语句执行最快?( A )
 * (A) select*from `user`where create time between 1648791898534 and 1648791998534
 * (B)select*from `user`where updatetime between 1648791898534 and 1648791998534
 * (C)select*from`userwhere nickname like %登录%
 * (D)select*from `userwhere login_name like'登录%
 *
 *
 * 2.表结构同题1，mysql 云主机1c2g，数据量大概在10000000左右，哪条SQL语句执行最慢?(D)
 * (A) select*from `user where nickname like'登录%
 * (B)select*from `user where nickname=登录 and update time>1648791898534
 * (C)select*from `user`where nickname=登录 order by update time deso
 * (D)select *from `user`where login_name=登录 and update_time> 1648791898534
 *
 * 3.使用Redis作为上述库表缓存，在更新数据库表的某一条数据的时候，应该( C )对应的缓存数据
 * (A)删除
 * (B)更新
 * (C)先查询缓存，如果没有则新增，否则更新
 * (D)删除后马上新增
 *
 * 4.@Transactional注解写在方法上会自动开启事务，在已经开启事务的方法中执行非数据库相关的耗时操作会导致(A)
 * (A) QPS数量较高
 * (B)数据库连接池活跃连接数量较高
 * (C) @Transactional注解失效
 * (D)数据被回滚
 *  因为：一旦开启的事务中执行的其他操作消耗资源特别多特别耗时，则导致当前这个开启的事务执行完成特别耗时，mysql服务器
 *  无法进行快速完成一个事务的commit，可能会大量锁行或者锁表。因此QPS会较高
 *
 **/
public class Test4 {
}
