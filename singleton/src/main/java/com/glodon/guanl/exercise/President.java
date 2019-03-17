package com.glodon.guanl.exercise;

/**
 * @author :guanl-c
 * @date :2019/3/13 10:23
 * @description :用懒汉式单例模式模拟产生美国当今总统对象。
 */
public class President {

    private String name;
    private static volatile President instance;

    // 构造函数私有化
    private President(String name) {
        this.name = name;
    }

    public static synchronized President getInstance() {
        if (instance == null) {
            instance = new President("帝释天");
        }
        return instance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
