package linkedIn.design.maxstack;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
* Here's a not so good solution using a LinkedList and a PriorityQueue.
* It is an example of a Bad solution, since it doesn't meet the runtime criteria.
* It has poor performance for the pop() methods, because both PriorityQueue.remove(Object o)
* and list.remove(Object o) have O(n) performance for arbitrary elements.
 * */

public class PriorityQueueMaxStack<T extends Comparable<T>> implements MaxStack<T> {
    private LinkedList<T> stack;
    private PriorityQueue<T> pq;
    private static int DEFAULT_INITIAL_CAPACITY = 11;

    public PriorityQueueMaxStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public PriorityQueueMaxStack(int initialCapacity) {
        stack = new LinkedList<T>();
        pq = new PriorityQueue<T>(initialCapacity, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o2.compareTo(o1);
            }
        });
    }

    @Override
    public void push(T toPush) {
        if (toPush == null) {
            throw new NullPointerException();
        }
        stack.push(toPush);
        pq.offer(toPush);
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        T val = stack.pop();
        pq.remove(val);
        return val;
    }

    @Override
    public T peekMax() {
        return pq.peek();
    }

    @Override
    public T popMax() {
        if (stack.isEmpty()) {
            return null;
        }
        T val = pq.poll();
        stack.remove(val);
        return val;
    }
}

