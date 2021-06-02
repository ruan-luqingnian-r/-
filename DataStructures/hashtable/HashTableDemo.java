package DataStructures.hashtable;

import java.util.Scanner;

/**
 * @PackgeName: DataStructures.hashtable
 * @ClassName: HashTable
 * @Author: 小天才
 * Date: 2021/6/1 11:21
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 哈希表
 */
public class HashTableDemo{
    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTable = new HashTable(7);
        //创建简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    int i = scanner.nextInt();
                    hashTable.findEmpById(i);

                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }


    }

}
//定义员工类
class Emp{
    private int id;
    private String name;
    public Emp next;
    public Emp(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
//定义链表
class EmpLinkList{
    //头指针
    private Emp head;//默认为空

    /**
     * 添加员工方法
     */
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }else {
            Emp curEmp = head;
            while (true){
                if (curEmp.next == null){
                    //找到尾部
                    break;
                }
                curEmp = curEmp.next;
            }
            curEmp.next = emp;
        }
    }
    /**
     * 遍历链表信息
     */
    public void list(int no) {
        if(head == null) { //说明链表为空
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        } System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.getId(), curEmp.getName());
            if(curEmp.next == null) {//说明 curEmp 已经是最后结点
                break;
            } curEmp = curEmp.next; //后移， 遍历
        } System.out.println();
    }
    /**
     * 查找用户信息
     */
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.getId() == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
//创建哈希表管理多条连
class HashTable{
    private EmpLinkList[] empLinkLists;
    private int size;
    //创建构造器
    public HashTable(int size){
        this.size = size;
        empLinkLists = new EmpLinkList[size];
        //TODO//初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkLists[i] = new EmpLinkList();
        }
    }
    /**
     * 添加雇员
     */
    public void add(Emp emp){
        //根据员工id判断信息插入位置
        int empLinkedListNo = hashFun(emp.getId());
        empLinkLists[empLinkedListNo].add(emp);
    }
    /**
     * 散列函数(取模法)
     */
    public int hashFun(int id){
        return  id % size;
    }
    /**
     * 遍历哈希表
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkLists[i].list(i);
        }
    }
    /**
     * 查找雇员
     */
    public void findEmpById(int id){
        int hashFun = hashFun(id);
        Emp emp = empLinkLists[hashFun].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d 条链表中找到 雇员 id = %d \n", (hashFun + 1), id);
        }else {
            System.out.println("未找到");
        }
    }


}