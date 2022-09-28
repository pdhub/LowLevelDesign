package linkedIn.design.maxstack;

import java.util.ArrayList;
import java.util.List;

class MaxHeap<E extends MaxHeap.Element> {

    static abstract class Element implements Comparable<Element> {
        // MaxHeap will not pass null or an object of the wrong type to compareTo.
        int index = -1;
    }

    private final List<E> heap = new ArrayList<>();

    E root() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    void add(E element) {
        if (element == null || element.index >= 0) {
            throw new IllegalArgumentException();
        }
        element.index = heap.size();
        heap.add(element);
        bubbleUp(element);
    }

    void remove(E element) {
        if (element == null || element.index < 0 || element != heap.get(element.index)) {
            throw new IllegalArgumentException();
        }
        E moved = heap.remove(heap.size() - 1);
        if (moved != element) {
            moved.index = element.index;
            heap.set(moved.index, moved);
            if (!bubbleUp(moved)) {
                bubbleDown(moved);
            }
        }
        element.index = -1;
    }

    private boolean bubbleUp(E element) {
        E parent = parent(element);
        if (element.index == 0 || compare(element, parent) < 0) {
            return false;
        }
        do {
            swap(element, parent);
            parent = parent(element);
        } while (element.index != 0 && compare(element, parent) > 0);
        return true;
    }

    private void bubbleDown(E element) {
        while (true) {
            E left = leftChild(element);
            E right = rightChild(element);
            if (compare(element, left) < 0) {
                swap(element, (compare(left, right) < 0) ? right : left);
            } else if (compare(element, right) < 0) {
                swap(element, right);
            } else {
                break;
            }
        }
    }

    private int compare(Element x, Element y) {
        // Callers will not pass x == null.
        return (x == y) ? 0 : (y == null) ? 1 : x.compareTo(y);
    }

    private void swap(E x, E y) {
        int temp = x.index;
        x.index = y.index;
        y.index = temp;
        heap.set(x.index, x);
        heap.set(y.index, y);
    }

    private E parent(Element child) {
        return heap.get((child.index - 1) / 2); // rounded down
    }

    private E leftChild(Element parent) {
        int index = (parent.index * 2) + 1;
        return (index < heap.size()) ? heap.get(index) : null;
    }

    private E rightChild(Element parent) {
        int index = (parent.index * 2) + 2;
        return (index < heap.size()) ? heap.get(index) : null;
    }
}


