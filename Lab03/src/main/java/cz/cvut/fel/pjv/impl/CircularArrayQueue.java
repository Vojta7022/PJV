package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Queue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {

    private final String[] elements;
    private int head;
    private int tail;
    private final int capacity;
    private int size;

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        elements = new String[5];
        head = 0;
        tail = 0;
        capacity = 5;
        size = 0;
    }

    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     *
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        elements = new String[capacity];
        head = 0;
        tail = 0;
        this.capacity = capacity;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if (obj == null) {
            return false;
        }
        if (isFull()) {
            return false;
        }

        elements[tail] = obj;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String result = elements[head];
        head = (head + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public Collection<String> getElements() {
        Collection<String> result = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            result.add(elements[(head + i) % capacity]);
        }

        return result;
    }

    @Override
    public void printAllElements() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[(head + i) % capacity]);
        }
    }
}
