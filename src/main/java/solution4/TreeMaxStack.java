package solution4;

import java.util.Stack;

public class TreeMaxStack <T extends Comparable<T>> implements MaxStack<T> {
    private Stack<T> stackAll = new Stack<>();
    private Stack<T> stackMax = new Stack<>();

    @Override
    public void push(T toPush) {
        stackAll.push(toPush);
        if (stackMax.empty() || toPush.compareTo(stackMax.peek()) >= 0) {
            stackMax.push(toPush);
        }
    }

    @Override
    public T peek() {
        return stackAll.peek(); //return null if empty
    }

    @Override
    public T pop() {
        T res = stackAll.pop(); //throw EmptyStackException if empty
        if (res.equals(stackMax.peek())) {
            stackMax.pop();
        }
        return res;
    }

    @Override
    public T peekMax() {
        return stackMax.peek();
    }

    @Override
    public T popMax() {
        // Store all elements pushed after current max element to a temp stack
        Stack<T> temp = new Stack<>();
        while (!stackAll.empty() && !stackAll.peek().equals(stackMax.peek())) {
            temp.push(stackAll.pop());
        }
        // remove current max element from both stacks
        T res = stackMax.pop(); //throw EmptyStackException if empty
        stackAll.pop();
        // push back all elements
        while (!temp.empty()) {
            push(temp.pop());
        }
        return res;
    }
}
