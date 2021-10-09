package 练习.java927;

/**
 * @Author: ruan
 * Date: 2021/10/7 13:10
 * @Description: 哈希表
 */
public class MyHashTable<K,V> {

    /**
     * 创建数组用来存放节点
     */
    private Node<K,V>[] table;
    /**
     * 当前Map中节点的个数
     */
    private int size;

    /**
     * 向Map中添加数据
     * @param key 添加节点元素的key
     * @param value 添加节点元素的value
     */
    public void put(K key,V value){
        //默认初始化容量为 1 << 4  16
        if (table == null || table.length == 0){
            //数组为空，无数据，默认初始化容量为16
            table = new Node[16];
        }
        //创建一个新的节点
        Node<K, V> newNode = new Node<>(key, value, null, null);
        //通过key来计算节点Node应该放的位置
        int index = hash(key);
        //判断该位置是否有数据
        if (table[index] == null){
            //该位置为空，直接插入节点
            table[index] = newNode;
        }else {
            //如果不为空，则遍历链表，将新节点添加到最后
            //获取首节点
            Node<K, V> firstNode = table[index];
            Node<K, V> currentPreviousNode;//该节点永远指向当前节点的上一个节点
            //遍历链表
            while (true){
                if (newNode.getKey().equals(firstNode.getKey())){
                    //覆盖旧制
                    firstNode.setValue(newNode.getValue());
                    return;
                }
                currentPreviousNode = firstNode;//记录当前节点
                if (firstNode.getNext() == null) break;
                firstNode = firstNode.getNext();
            }
            //此时找到节点的最后一个
            firstNode.setNext(newNode);
            firstNode.getNext().setPre(currentPreviousNode);
        }
        //长度+1
        size++;
    }

    /**
     * 删除节点
     * @param key key
     * @return 被删除的值
     */
    public V remove(K key){
        //根据key值获取value
        Node<K, V> node = getNodeFromKey(key);
        //获取上一个和下一个节点
        Node<K, V> next = node.getNext();
        Node<K, V> pre = node.getPre();
        V value = node.getValue();

        if (next == null && pre == null){
            //上下都是空，说明只有这一个节点
            table[hash(key)] = null;
        }else if (pre == null){
            //上一个为空，说明为第一个
            node = next;
            node.setPre(null);
            table[hash(key)] = node;
        }else if (next == null){
            //下一个为空，说明是最后一个
            pre.setNext(null);
        }else {
            //中间节点
            next.setPre(pre);
            pre.setNext(next);
        }
        size--;
        return value;
    }

    /**
     * 根据key修改其对应的value
     *
     * @param key   与指定值相关联的键
     * @param value 与指定键相关联的值
     * @return 修改前的值
     */
    public V replace(K key, V value) {
        Node<K, V> node = getNodeFromKey(key);//通过key获取节点
        if(node == null)return null;//如果没有获取到节点直接返回null
        //如果没有返回null，说明下面的情况都是正常的
        V oldValue = node.getValue();//获取当前节点的value
        node.setValue(value);//设置当前节点的value为外界指定的
        return oldValue;//返回修改前的value
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node<K, V> node;
        //直接调用内部封装的方法，获取节点之后获取节点对应的值，并返回
        return (node = getNodeFromKey(key)) == null ? null : node.getValue();
    }

    public int getSize() {
        return size;
    }

    /**
     * 根据节点的key获取对应的节点对象
     * 如果没有找到key对应的节点，会返回null
     * @param key key
     * @return Value
     */
    private Node<K, V> getNodeFromKey(K key) {
        //根据key值计算hash值
        int index = hash(key);
        if (table[index] == null){
            return null;
        }
        //获取首届点
        Node<K, V> firstNode = table[index];

        //遍历链表
        while (true){
            if (firstNode.getKey().equals(key)){
                return firstNode;
            }
            if (firstNode.getNext() == null) break;
            firstNode = firstNode.getNext();
        }
        return null;
    }

    /**
     * 计算节点应该放在数组中的哪个地方
     *
     * @param key 根据key计算索引位置
     * @return 计算完成的索引位置
     */
    private int hash(K key) {
        //保证数组的长度为2的整数幂   %->除法效率较低   &->位运算符效率高
        //key.hashCode() & (table.length - 1);
        return key == null ? 0 : key.hashCode() & (table.length - 1);
    }

    /**
     * 构造一个双向链表
     * @param <K> key
     * @param <V> value
     */
    private final class Node<K,V>{
        /**
         * 节点中的key
         */
        private K key;
        /**
         * 节点中的value
         */
        private V value;
        /**
         * 指向上一个节点
         */
        private Node<K,V> pre;
        /**
         * 指向下一个节点
         */
        private Node<K,V> next;
        /**
         * 创建构造方法
         */
        public Node(K key, V value, Node<K, V> pre, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        /**
         * get/set 方法
         */
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getPre() {
            return pre;
        }

        public void setPre(Node<K, V> pre) {
            this.pre = pre;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
