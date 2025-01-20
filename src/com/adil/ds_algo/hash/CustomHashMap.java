package com.adil.ds_algo.hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private int nodes;
    private int bucketSize;
    private LinkedList<Node<K, V>>[] buckets;

    public CustomHashMap() {
        this.bucketSize = 4;
        this.buckets = new LinkedList[bucketSize];
        for(int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        int bucketIndex = hash(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            buckets[bucketIndex].add(new Node(key, value));
            nodes++;
        } else {
            buckets[bucketIndex].get(dataIndex).value = value;
        }

        double loadFactor = (double) nodes / bucketSize;
        if (loadFactor > 2) {
            rehash();
        }
    }

    public V get(K key) {
        int bucketIndex = hash(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            return buckets[bucketIndex].get(dataIndex).value;
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = hash(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            return false;
        } else {
            return true;
        }
    }

    public V remove(K key) {
        int bucketIndex = hash(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            nodes--;
            return buckets[bucketIndex].remove(dataIndex).value;
        }
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            LinkedList<Node<K, V>> ll = buckets[i];
            for (int j = 0; j < ll.size(); j++) {
                keys.add(ll.get(j).key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    private int searchInLL(K key, int index) {
        LinkedList<Node<K, V>> ll = buckets[index];
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return i; // itemIndex
            }
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Node<K, V>>[] oldBucket = buckets;
        bucketSize = bucketSize * 2;
        buckets = new LinkedList[bucketSize];

        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node<K, V>> ll : oldBucket) {
            for (Node<K, V> node : ll) {
                put(node.key, node.value);
            }
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % bucketSize;
    }
}
