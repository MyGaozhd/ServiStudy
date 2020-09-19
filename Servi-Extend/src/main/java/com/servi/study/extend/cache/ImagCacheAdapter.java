package com.servi.study.extend.cache;

import java.io.Serializable;

public abstract class ImagCacheAdapter<E extends Serializable> implements ICache<E> {

    @Override
    public E get(Comparable<E> c) {

        if (c == null || this.isEmpty()) {
            return null;
        }

        E[] items = this.get();
        for (E e : items) {
            if (c.compareTo(e) == 1) {
                return e;
            }
        }
        return null;
    }
}
