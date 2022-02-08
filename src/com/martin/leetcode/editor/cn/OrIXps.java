//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 哈希表 链表 双向链表 👍 19 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class OrIXps{

    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, Node> map;
    private int cap = 0;
    private Node root;
    private Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        root = new Node();
        tail = new Node();
        root.next = tail;
        tail.pre = root;
    }
    
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            value = node.value;
            moveToTail(node);
        }
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if (map.size() >= cap) {
                Node dNode = root.next;
                deleteNode(dNode);
                map.remove(dNode.key);
            }

            Node node = new Node(key, value);
            createNode(node);
            map.put(key, node);
        }
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }

    private void createNode(Node node) {
        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
    }

    private void moveToTail(Node node) {
        deleteNode(node);
        createNode(node);
    }

    private void printNode() {
        Node dummy = root.next;
        while (dummy != null) {
            System.out.print(dummy + "-->");
            dummy = dummy.next;
        }
        System.out.println();
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}