package 练习;

/**
 * @Author: ruan
 * Date: 2021/10/9 14:17
 * @Description: hashTable
 */
public class MyHashTable<K, V> {

    /**
     * 创建数组用于存放数据
     */
    private Node<K, V>[] table = new Node[16];
    /**
     * 数据量大小
     */
    private int size;

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void put(K key,V value){
        //创建新节点
        Node<K, V> newNode = new Node<>(key,value,null,null);
        //根据key值获取插入槽位数据
        int index = hash(key);
        //判断次槽位是否有数据
        if (table[index] == null){
            //没有直接插入
            table[index] = newNode;
        }else {
            //如果有数据,遍历链表找到末位插入
            //获取辅助节点
            Node<K, V> temp = table[index];
            while (true){
                if (temp.key == key){
                    temp.value = value;
                    return;
                }
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.pre = temp;
        }
    }

    /**
     * 删除数据
     * @param key
     * @return
     */
    public Node<K, V> remove(K key){
        //根据key获取对应的Node
        Node<K, V> node = getNodeFromKey(key);
        if (node.next == null && node.pre == null){
            //上下都是空说明只有一个节点
            table[hash(key)] = null;
        }else if (node.next == null){
            //下一个为空，最后一个数据
            node.pre.next = null;
        }else if (node.pre == null){
            //上一个为空，第一个数据
            table[hash(key)] = node.next;
        }else {
            //中间数据
            node.pre = node.next;
            node.next.pre = node.pre;
        }
        return node;
    }

    public V replace(K key , V value){
        //根据key值获取节点
        Node<K, V> node = getNodeFromKey(key);
        if (node == null){
            return null;
        }
        V v = node.value;
        node.value = value;
        return v;
    }

    public V get(K key){
        Node<K, V> node = getNodeFromKey(key);
        return  node == null ? null : node.value;
    }



    /**
     * 根据key获取对应的hash值
     * @param key
     * @return
     */
    private int hash(K key){
        return key == null ? 0 : key.hashCode() & (table.length - 1);
    }

    /**
     * 根据key值获取对应的节点
     * @param key
     * @return
     */
    private Node<K, V> getNodeFromKey(K key){
        Node<K, V> node = table[hash(key)];
        if (node == null){
            return null;
        }
        //创建辅助节点用于遍历整个链表
        Node<K, V> temp = node;
        while (true){
            if (temp.key == key){
                return temp;
            }
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 创建双向链表，用于保存数据
     * @param <K>
     * @param <V>
     */
    private final class Node<K, V>{
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
