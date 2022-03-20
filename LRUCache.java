/**
 * @className: LRUCache
 * @description: LRU缓存机制
 * @author: carl
 * @date: 2021/8/15 15:14
 */

import java.util.HashMap;

/**
 * 思路：
 * 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
 * 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
 * 这样一来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1)O(1) 的时间内完成 get 或者 put 操作。
 */
public class LRUCache {
    class DListNode {
        int key, value;
        DListNode prev, next;

        private DListNode() {
        }

        private DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DListNode> cache = new HashMap();
    private int size;
    private int capacity;
    private DListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if (node == null) {
            DListNode newNode = new DListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DListNode tailNode = removeTail();
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DListNode removeTail() {
        DListNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }

    private void addToHead(DListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }
}
