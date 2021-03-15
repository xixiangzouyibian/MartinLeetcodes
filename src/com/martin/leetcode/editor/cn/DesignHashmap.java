//不使用任何内建的哈希表库设计一个哈希映射 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
// get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
// remove(key)：如果映射中存在这个键，删除这个数值对。 
// 
//
// 
//示例： 
//
// MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);          
//hashMap.put(2, 2);         
//hashMap.get(1);            // 返回 1
//hashMap.get(3);            // 返回 -1 (未找到)
//hashMap.put(2, 1);         // 更新已有的值
//hashMap.get(2);            // 返回 1 
//hashMap.remove(2);         // 删除键为2的数据
//hashMap.get(2);            // 返回 -1 (未找到) 
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希库。 
// 
// Related Topics 设计 哈希表 
// 👍 113 👎 0


package com.martin.leetcode.editor.cn;


public class DesignHashmap{
//    public static void main(String[] args) {
//       Solution solution = new DesignHashmap().new Solution();
//    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*class MyHashMap {

    private int DEFAULT_CAP = 2069;
    private Bucket[] buckets;

    *//** Initialize your data structure here. *//*
    public MyHashMap() {
        buckets = new Bucket[DEFAULT_CAP];
    }
    
    *//** value will always be non-negative. *//*
    public void put(int key, int value) {
        int index = key % DEFAULT_CAP;
        if (buckets[index] == null) {
            buckets[index] = new Bucket();
        }
        buckets[index].put(key, value);
    }
    
    *//** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key *//*
    public int get(int key) {
        int index = key % DEFAULT_CAP;
        if (buckets[index] == null) return -1;

        return buckets[index].get(key);
    }
    
    *//** Removes the mapping of the specified value key if this map contains a mapping for the key *//*
    public void remove(int key) {
        int index = key % DEFAULT_CAP;
        if (buckets[index] == null) return;
        buckets[index].remove(key);
    }
}

class Bucket {

    private List<Node<Integer, Integer>> bucket;

    public Bucket() {
        bucket = new LinkedList<>();
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node = seekNode(key);
        if (node == null) {
            bucket.add(new Node<>(key, value));
        } else {
            node.v = value;
        }
    }

    public int get(int key) {
        Node<Integer, Integer> node = seekNode(key);
        if (node != null) return node.v;
        return -1;
    }

    public void remove(int key) {
        Node<Integer, Integer> node = seekNode(key);
        if (node != null) {
            bucket.remove(node);
        }
    }

    private Node<Integer, Integer> seekNode(int key) {
        for (Node<Integer, Integer> node : bucket) {
            if (node.k == key) {
                return node;
            }
        }
        return null;
    }

    class Node<K, V> {
        private K k;
        private V v;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}*/

class MyHashMap {

    Node[] nodes;
    int size = 13333;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % size;
        while (nodes[index] != null) {
            if (nodes[index].key == key) {
                nodes[index].value = value;
                nodes[index].isDeleted = false;
                return;
            }
            index = (index + 1) % size;
        }
        nodes[index] = new Node(key, value, false);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % size;
        while (nodes[index] != null) {
            if (nodes[index].key == key && !nodes[index].isDeleted) {
                return nodes[index].value;
            }
            index = (index + 1) % size;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % size;
        while (nodes[index] != null) {
            if (nodes[index].key == key) {
                nodes[index].isDeleted = true;
            }
            index = (index + 1) % size;
        }
    }

    class Node {
        int key;
        int value;
        boolean isDeleted;
        Node(int key, int value, boolean isDeleted) {
            this.key = key;
            this.value = value;
            this.isDeleted = isDeleted;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
