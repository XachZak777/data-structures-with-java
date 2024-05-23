package dsHomework1;

import Deque.*;
import Queue.*;

public class QueueDeque<E> implements Deque<E> {

    private Queue<E> queue;
    private int capacity;

    public QueueDeque(int capacity) { 

        this.capacity = capacity;
        queue = new ArrayQueue<>(capacity);
    }

    @Override
    public int size () { return queue.size(); }

    @Override
    public boolean isEmpty () {return queue.isEmpty(); }

    @Override
    public E first() {
        return queue.first();
    }

    @Override
    public E last() {
        if (queue.isEmpty()) {
            return null;
        }
        E lastElement = null;
        int currentSize = queue.size();
        for (int i = 0; i < currentSize; i++) {
            E element = queue.dequeue();
            if (i == currentSize - 1) {
                lastElement = element;
            }
            queue.enqueue(element);
        }
        return lastElement;
    }

    @Override
    public void addFirst(E e) {
        if (queue.size() == capacity) {
            throw new IllegalStateException("Deque is full");
        }
        queue.enqueue(e);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

    @Override
    public void addLast(E e) {
        queue.enqueue(e);
    }

    @Override
    public E removeFirst() {
        return queue.dequeue();
    }

    @Override
    public E removeLast() {
        if (queue.isEmpty()) {
            return null;
        }
        E lastElement = null;
        int currentSize = queue.size();
        for (int i = 0; i < currentSize; i++) {
            E element = queue.dequeue();
            if (i < currentSize - 1) {
                queue.enqueue(element);
            } else {
                lastElement = element;
            }
        }
        return lastElement;
    }
}
