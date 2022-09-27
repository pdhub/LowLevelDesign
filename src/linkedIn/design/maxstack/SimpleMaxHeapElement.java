package linkedIn.design.maxstack;


/** A MaxStack that uses a MaxHeap to implement peekMax and popMax. */



class SimpleMaxHeapElement<V extends Comparable<V>> extends MaxHeap.Element {

    final V value;

    SimpleMaxHeapElement(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(MaxHeap.Element item) {
        if (item == null) {
            return 1;
        }
        SimpleMaxHeapElement<V> that = (SimpleMaxHeapElement<V>) item;
        return (value == null)
                ? ((that.value == null) ? 0 : -1)
                : ((that.value == null) ? 1 : value.compareTo(that.value));
    }
}
