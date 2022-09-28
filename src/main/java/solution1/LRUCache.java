package solution1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    CacheDoublyLinkedNode head;
    CacheDoublyLinkedNode tail;
    Map<String, CacheDoublyLinkedNode> keyToLinkedList;
    public static final int QUEUE_SIZE = 5;

    public LRUCache() {
        keyToLinkedList = new HashMap<>();
    }

    public void printContents(){
        System.out.println("************************************");
        CacheDoublyLinkedNode tempTail = tail;
        while (tail!=null){
            System.out.println("{" + tail.key + "-" + tail.value + "}");
            tail = tail.next;
        }
        tail = tempTail;
        //System.out.println("******Contents of cache end******");
    }

    public String get(String key){
        String val = "";
        if (keyToLinkedList.containsKey(key)){
            CacheDoublyLinkedNode node = keyToLinkedList.get(key);
            val = node.value;
            remove(node);
            add(node);
        }else {
            System.out.println("Key does not exist");
        }
        return val;
    }

    public void put(String key, String value){
        if (keyToLinkedList.containsKey(key)){
            CacheDoublyLinkedNode keyNode = keyToLinkedList.get(key);
            remove(keyNode);
            add(keyNode);
        }else
            add(new CacheDoublyLinkedNode(key, value));
    }

    public void add(CacheDoublyLinkedNode cacheDoublyLinkedNode){
        if (head == null) {
            head = cacheDoublyLinkedNode;
            tail = cacheDoublyLinkedNode;
        }
        else{
            if(tail.next==null) {
                tail.next = head;
                head.prev = tail;
            }
            CacheDoublyLinkedNode prevHead = head;
            head.next = cacheDoublyLinkedNode;
            head = head.next;
            head.prev = prevHead;
            head.next = null;
        }
        keyToLinkedList.put(cacheDoublyLinkedNode.getValue(), cacheDoublyLinkedNode);
        resize();
    }

    private void resize() {
        if (keyToLinkedList.size() > QUEUE_SIZE){
            keyToLinkedList.remove(tail.getValue());
            tail = tail.next;
            tail.prev = null;
        }
    }

    private void remove(CacheDoublyLinkedNode cacheDoublyLinkedNode){
        keyToLinkedList.remove(cacheDoublyLinkedNode.getValue());
        if (tail.key == cacheDoublyLinkedNode.key) {
            tail = tail.next;
            tail.prev = null;
        }else{
            CacheDoublyLinkedNode prev = cacheDoublyLinkedNode.prev;
            CacheDoublyLinkedNode next = cacheDoublyLinkedNode.next;
            if (prev!=null) {
                prev.next = next;
            }
            if (next!=null) {
                next.prev = prev;
            }
            cacheDoublyLinkedNode.prev = null;
            cacheDoublyLinkedNode.next = null;
        }
    }

}
