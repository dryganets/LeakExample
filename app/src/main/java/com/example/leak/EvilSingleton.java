package com.example.leak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sergeyd on 11/16/15.
 *
 *  (                      )
 * |\    _,--------._    / |
 * | `.,'            `. /  |
 * `  '              ,-'   '
 * \/_         _   (     /
 * (,-.`.    ,',-.`. `__,'
 * |/#\ ),-','#\`= ,'.` |
 * `._/)  -'.\_,'   ) ))|
 * /  (_.)\     .   -'//
 * (  /\____/\    ) )`'\
 * \ |V----V||  ' ,    \
 *|`- -- -'   ,'   \  \      _____
 * ___    |         .'    \ \  `._,-'     `-
 * `.__,`---^---'       \ ` -'
 * -.______  \ . /  ______,-
 * `.     ,'            ap
 */
public class EvilSingleton implements Singleton {
    List<EventListener> listeners = new ArrayList<>();

    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void fireEvent() {
        for (Iterator<EventListener> iterator = listeners.iterator();iterator.hasNext();) {
            EventListener listener = iterator.next();
            listener.onEvent();
        }
    }
}
