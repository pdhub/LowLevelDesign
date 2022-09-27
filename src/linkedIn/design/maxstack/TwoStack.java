package linkedIn.design.maxstack;

import java.util.EmptyStackException;

public class TwoStack{
    /*@Override
    public void push(Comparable toPush) {
        Node<T> node = new Node<T>(toPush);
        node.down = stack;
        if (node.down != null) {
            node.down.up = node;
        }
        stack = node;
        heap.add(node);
    }

    @Override
    public Comparable peek() {
        checkNotEmpty();
        return stack.value;
    }

    @Override
    public Comparable pop() {
        checkNotEmpty();
        Node<T> node = stack;
        stack = node.down;
        if (stack != null) {
            stack.up = null;
        }
        heap.remove(node);
        return node.value;

    }

    @Override
    public Comparable peekMax() {
        checkNotEmpty();
        return heap.root().value;
    }

    @Override
    public Comparable popMax() {
        checkNotEmpty();
        Node<T> node = heap.root();
        if (node == stack) {
            stack = node.down;
        } else {
            node.up.down = node.down;
        }
        if (node.down != null) {
            node.down.up = node.up;
        }
        heap.remove(node);
        return node.value;
    }

    private void checkNotEmpty() {
        if (stack == null) {
            throw new EmptyStackException();
        }
    }*/
}
