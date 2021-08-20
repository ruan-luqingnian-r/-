package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/8/20 10:12
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0;i < 12;i++){
            list.add("" + i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
