package solution1;

public class CacheDoublyLinkedNode {
    String value;
    CacheDoublyLinkedNode next;
    CacheDoublyLinkedNode prev;
    String key;

    public CacheDoublyLinkedNode(String value, CacheDoublyLinkedNode next, CacheDoublyLinkedNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CacheDoublyLinkedNode(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CacheDoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(CacheDoublyLinkedNode next) {
        this.next = next;
    }

    public CacheDoublyLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(CacheDoublyLinkedNode prev) {
        this.prev = prev;
    }
}
