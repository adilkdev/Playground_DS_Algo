package com.adil.ds_algo.stack.medium;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}

public class LRU {
    public int capacity;
    Map<Integer, Node> map = new HashMap<>();
    public Node head, tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int data) {
        if(map.containsKey(data)) {
            Node node = map.get(data);
            remove(node);
            insert(node);
            return node.data;
        } else
            return -1;
    }

    public void put(int value) {
        if(map.containsKey(value)) {
            remove(map.get(value));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(value));
    }

    public void insert(Node node) {
        map.put(node.data, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public void remove(Node node) {
        map.remove(node.data);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void printQ() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data);
            cur = cur.next;
        }
    }

}
