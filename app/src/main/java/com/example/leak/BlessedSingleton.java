package com.example.leak;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sergeyd on 11/19/15.
 */
public class BlessedSingleton implements Singleton {
    private List<WeakReference<EventListener>> listeners = new ArrayList<>();

    @Override
    public void addListener(EventListener listener) {
            listeners.add(new WeakReference<>(listener));
    }

    @Override
    public void fireEvent() {
        for (Iterator<WeakReference<EventListener>> iterator = listeners.iterator(); iterator.hasNext();) {
            EventListener listener = iterator.next().get();
            if (listener == null) {
                iterator.remove();
            } else {
                listener.onEvent();
            }
        }
    }
}
