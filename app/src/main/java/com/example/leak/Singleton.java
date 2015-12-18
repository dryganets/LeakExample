package com.example.leak;

/**
 * Created by sergeyd on 11/19/15.
 */
public interface Singleton {
    void addListener(EventListener listener);
    void fireEvent();
}
