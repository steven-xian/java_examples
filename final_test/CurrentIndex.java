package com.zhijiang.test;

public class CurrentIndex {
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void set(int i) {
        threadLocal.set(i);
    }

    public static int get() {
        return (int)threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
