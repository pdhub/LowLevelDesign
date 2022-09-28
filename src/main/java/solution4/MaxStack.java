package solution4;

public interface MaxStack<T extends Comparable> {
    public void push(T toPush);
    public T peek();
    public T pop();
    public T peekMax();
    public T popMax();
}

