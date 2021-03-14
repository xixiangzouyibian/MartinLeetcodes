//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。 
//
// 实现 MyHashSet 类： 
//
// 
// void add(key) 向哈希集合中插入值 key 。 
// bool contains(key) 返回哈希集合中是否存在这个值 key 。 
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
// 
//
// 示例： 
//
// 
//输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
//", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//输出：
//[null, null, null, true, false, null, true, null, false]
//
//解释：
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除） 
//
// 
//
// 提示： 
//
// 
// 0 <= key <= 106 
// 最多调用 104 次 add、remove 和 contains 。 
// 
//
// 
//
// 进阶：你可以不使用内建的哈希集合库解决此问题吗？ 
// Related Topics 设计 哈希表 
// 👍 132 👎 0


package com.martin.leetcode.editor.cn;


public class DesignHashset{

    //leetcode submit region begin(Prohibit modification and deletion)
/*class MyHashSet {

    int[] cache;

    *//** Initialize your data structure here. *//*
    public MyHashSet() {
        cache = new int[31251];
    }
    
    public void add(int key) {
        cache[key >> 5] |= 1 << (key % 32);
    }
    
    public void remove(int key) {
        cache[key >> 5] &= ~(1 << (key % 32));
    }
    
    *//** Returns true if this set contains the specified element *//*
    public boolean contains(int key) {
        return ((cache[key >> 5] >> key % 32) & 1) == 1;
    }
}*/

class MyHashSet {

    Node[] cache;
    int size = 10000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        cache = new Node[size];
    }

    public void add(int key) {
        int index = hash(key);
        Node head = cache[index];
        if (head == null) {
            head = new Node();
            cache[index] = head;
        } else {
            Node cursor = head.next;
            while (cursor != null) {
                if (cursor.key == key) return; // exist
                cursor = cursor.next;
            }
        }

        Node node = new Node(key);
        node.next = head.next;
        head.next = node;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = cache[index];
        if (head != null) {
            Node cursor = head.next;
            Node pre = head;
            while (cursor != null) {
                if (cursor.key == key) {
                    pre.next = cursor.next; // delete
                    cursor.next = null;
                }
                pre = cursor;
                cursor = cursor.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        Node head = cache[index];
        if (head != null) {
            Node cursor = head.next;
            while (cursor != null) {
                if (cursor.key == key) return true;
                cursor = cursor.next;
            }
        }
        return false;
    }

    class Node {
        int key;
        Node next;
        Node() {}
        Node(int key) {
            this.key = key;
        }
    }

    private int hash(int key) {
        int hash = Integer.hashCode(key);
        hash ^= hash >>> 16;
        return hash % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
