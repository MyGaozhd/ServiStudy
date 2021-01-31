package com.servi.study.leetcode;

public class LeetCode_641 {
    private int capacity;
    private int size;
    private Node first;
    private Node last;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public LeetCode_641(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.next = first;
        if (first != null) {
            first.prev = node;
        }
        first = node;
        if (last == null) {
            last = node;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.prev = last;
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = node;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node nxt = first.next;
        if (nxt != null) {
            nxt.prev = null;
            first.next = null;
        } else {
            last = null;
        }
        first = nxt;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node pre = last.prev;
        if (pre != null) {
            pre.next = null;
            last.prev = null;
        } else {
            first = null;
        }
        last = pre;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return first == null ? -1 : first.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return last == null ? -1 : last.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("This deque is empty");
            return sb.toString();
        }
        Node p = first;
        for (int i = 0; i < size; i++) {
            sb.append("[").append(p.value).append("]");
            p = p.next;
        }
        sb.append(", first == ").append(getFront())
                .append(", last == ").append(getRear())
                .append(", size == ").append(size);
        return sb.toString();
    }
}
