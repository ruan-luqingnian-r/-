package 练习;

/**
 * @Author: ruan
 * Date: 2021/10/8 13:00
 * @Description: 手写简单的哈希表
 */
public class MyHashTable<K,V> {
    //创建数组用于存放
    private Node<K,V>[] table;




    /**
     * 创建节点
     */
    private static final class Node<K,V>{

        private K key;

        private V value;

        private Node next;

        private Node pre;

        public Node(K key, V value, Node next, Node pre) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
}
