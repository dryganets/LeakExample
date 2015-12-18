package com.example.leak;

/**
 * Created by sergeyd on 11/19/15.
 */
public class SingletonManager {
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (SingletonManager.class) {
                if (instance == null) {
                    instance = new EvilSingleton();
                }
            }
        }
        return instance;
    }
}
