package com.glodon.guanl;

/**
 * 饿汉式-单例模式
 */
public class HungrySingleton {

    // 非线程安全
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    // 线程安全
    private static final HungrySingleton safeHungrySingleton = new HungrySingleton();

    // 私有构造方法
    private HungrySingleton() {
    }

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
