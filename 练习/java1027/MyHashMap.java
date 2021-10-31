package 练习.java1027;

/**
 * @Author: ruan
 * Date: 2021/10/28 11:06
 * @Description:
 */
public class MyHashMap<K, V> {

    /**
     * 创建节点数组来存放链表数据
     */
    private Node<K, V>[] table;
    /**
     * Map中的节点数量
     */
    private int size;

    /**
     * 计算节点应该放在数组中的哪个地方
     * @param key 根据key计算索引位置
     * @return 计算完成的索引位置
     */
    private int hash(K key){
        return key == null ? 0 : key.hashCode() & (table.length - 1);
    }

    /**
     * 插入数据
     * @param key key
     * @param value value
     */
    public void put(K key, V value){
        //如果为空先初始化数组
        if (table == null || table.length == 0){
            table = new Node[16];
        }
        //创建一个新的节点
        Node<K, V> newNode = new Node<>(key, value, null, null);
        //通过key计算hash值
        int index = hash(key);
        //判断数组中该槽位是否为空
        if (table[index] == null){
            //该位置为空，直接插入数据
            table[index] = newNode;
        }else {
            //不为空，遍历节点找到末尾
            //获取首节点用于辅助遍历
            Node<K, V> firstNode = table[index];
            //遍历链表
            while (firstNode.next != null){
                //如果有重复的key覆盖旧值
                if (newNode.key.equals(firstNode.key)){
                    firstNode.value = newNode.value;
                }
                firstNode = firstNode.next;
            }
            //此时找到最后一个节点
            firstNode.next = newNode;
            newNode.pre = firstNode;
        }
        size++;
    }

    /**
     * 根据key值查找节点
     * @param key key
     * @return 节点值
     */
    private Node<K, V> getNodeFromKey(K key){
        int index = hash(key);
        Node<K, V> node = table[index];
        if (node == null){
            return null;
        }
        //如果不为空，遍历链表找到节点值
        while (node.next != null){
            if (node.key.equals(key)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 根据Key值删除对应的节点
     * @param key key
     * @return 被删除的节点
     */
    public V remove(K key){
        //获取该节点
        Node<K, V> node = getNodeFromKey(key);
        V value = node.value;
        //判断节点所在的位置
        if (node.next == null && node.pre == null){
            //上下都为空，只有本身一个节点
            table[hash(key)] = null;
        }else if (node.pre == null){
            //上一个为空，说明该节点是第一个
            node = node.next;
            node.pre = null;
            table[hash(key)] = node;
        }else if (node.next == null){
            //下一个为空，说明为最后一个
            node.pre.next = null;
        }else {
            //中间节点
            node.pre = node.next;
            node.next.pre = node.pre;
        }
        return value;
    }

    /**
     * 根据key值修改节点
     * @param key key
     * @param value 新value
     * @return 修改前的值
     */
    public V replace(K key, V value){
        //通过key找到节点
        Node<K, V> node = getNodeFromKey(key);
        if (node == null) return null;
        //如果不为空，修改相关值
        V v = node.value;
        node.value = value;
        return v;
    }

    /**
     * 根据key值查找节点
     * @param key key
     * @return value
     */
    public V get(K key){
        Node<K, V> node = getNodeFromKey(key);
        return node == null ? null : node.value;
    }

    /**
     * 获取size
     * @return 节点数量
     */
    public int size(){
        return size;
    }



    /**
     * 创建一个双向链表，用于存放数据
     * @param <K> key
     * @param <V> value
     */
    private final class Node<K, V>{
        /**
         * 节点中的key
         */
        private K key;
        /**
         * 节点中的Value
         */
        private V value;
        /**
         * 指向上一个节点
         */
        private Node<K, V> next;
        /**
         * 指向下一个节点
         */
        private Node<K, V> pre;

        /**
         * 构造方法
         */
        public Node(K key, V value, Node<K, V> next, Node<K, V> pre){
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
}
