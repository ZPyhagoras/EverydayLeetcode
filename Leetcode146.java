import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {
    class DoubleLinkedNode {
        int key, val;
        DoubleLinkedNode prev, next;
        public DoubleLinkedNode() {}
        public DoubleLinkedNode(int _key, int _val) {
            key = _key; val = _val;
        }
    }

    private int size, cap;
    private DoubleLinkedNode head, tail;
    private Map<Integer, DoubleLinkedNode> pageMap;

    public Leetcode146(int capacity) {
        pageMap = new HashMap<>();
        size = 0;  
        cap = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    void deleteNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    void moveToHead(DoubleLinkedNode node) {
        deleteNode(node);
        addToHead(node);
    }

    private int removeTail() {
        DoubleLinkedNode res = tail.prev;
        deleteNode(res);
        return res.key;
    }
    
    public int get(int key) {
        DoubleLinkedNode tmpNode = pageMap.get(key);
        if (tmpNode == null) {
            return -1;
        }
        else {
            moveToHead(tmpNode);
            return tmpNode.val;
        }
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode tmpNode = pageMap.get(key);
        if (tmpNode == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            pageMap.put(key, newNode);
            addToHead(newNode);
            size += 1;
            if (size > cap) {
                pageMap.remove(removeTail());
                size--;
            }
        }
        else {
            tmpNode.val = value;
            moveToHead(tmpNode);
        }
    }
    /*
    Queue<Integer> pageQueue;
    Map<Integer, Integer> pageMap;
    int cacheCapacity;
    public Leetcode146(int capacity) {
        pageMap = new HashMap<>();
        pageQueue = new LinkedList<>();
        cacheCapacity = capacity;
    }
    
    public int get(int key) {
        if (pageMap.containsKey(key)){
            pageQueue.remove(key);
            pageQueue.add(key);
        }
        return pageMap.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (pageMap.containsKey(key)) {
            pageQueue.remove(key);
        }
        else if (cacheCapacity == 0) {
            pageMap.remove(pageQueue.poll());
        }
        else {
            cacheCapacity--;
        }
        pageQueue.add(key);
        pageMap.put(key, value);
    }
    */
}