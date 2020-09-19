package com.servi.study.extend.cache;

import java.io.Serializable;

/**
 * 影像平台cache接口
 *
 * @param <E>
 * @author gaozhdf@yonyou.com
 */
public interface ICache<E extends Serializable> {

    /**
     * 获得对应条件的元素
     *
     * @param condition
     * @return
     */
    public E get(String condition);

    /**
     * 获得对应条件的元素
     *
     * @param c
     * @return
     */
    public E get(Comparable<E> c);

    /**
     * 获得所有
     *
     * @return
     */
    public E[] get();

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    public boolean add(E e);

    /**
     * 批量添加元素
     *
     * @param e
     * @return
     */
    public boolean addAll(E[] args);

    /**
     * 移除某个元素
     *
     * @param e
     * @return
     */
    public boolean remove(E e);

    /**
     * 是否包含此元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e);

    /**
     * 当前缓存容量
     *
     * @return
     */
    public int size();

    /**
     * 当前缓存是否为空
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 清空当前缓存
     */
    public void clear();
}
