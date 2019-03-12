package com.glodon.guanl;

// 懒汉式-单例模式
public class LazySingleton {

    // 私有的构造函数
    private LazySingleton() {
    }

    // 非线程安全
    private static LazySingleton safeLazySingleton;

    public static LazySingleton getSingleton() {

        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    // 线程安全
    private static volatile LazySingleton lazySingleton;

    public static synchronized LazySingleton getSafeLazySingleton() {
        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
