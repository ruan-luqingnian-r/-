package DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @PackgeName: DataStructures.stack
 * @ClassName: PolandNotation
 * @Author: 小天才
 * Date: 2021/5/26 16:14
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+((30+3)*4)-5";
        System.out.println("中缀表达式为："+expression);
        List<String> reversePolishNotation = getReversePolishNotation(expression);
        System.out.println("后缀表达式为："+reversePolishNotation);
        int calculate = calculate(reversePolishNotation);
        System.out.println("计算结果为:"+calculate);

    }
    //将逆波兰表达式的数据写入列表中
    public static List<String> getListString(String suffixExpression){
        ArrayList<String> strings = new ArrayList<>();
        //按照空格分割
        String[] split = suffixExpression.split(" ");
        for (String s : split) {
            strings.add(s);
        }
        return strings;
    }
    //完成逆波兰表达式的扫描
    public static int calculate(List<String> stringList){
        //创建一个栈
        Stack<String> strings = new Stack<>();
        int res = 0;
        //遍历list
        for (String s : stringList) {
            //这里使用正则表达式去除数
            if (s.matches("\\d+")){//匹配多位数
                //数字入栈
                strings.push(s);
            }else {//如歌是数值
                //去除栈中的数值（两个）进行计算计算后入栈
                int num2 = Integer.parseInt(strings.pop());
                int num1 = Integer.parseInt(strings.pop());

                switch (s){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                }
                strings.push(res + "");
            }
        }
        return Integer.parseInt(strings.pop());
    }
    //中缀表达式转后缀表达式（逆波兰表达式）
    public static List<String> getReversePolishNotation(String expression){
        //先将表达式写入列表
        ArrayList<String> midStrings = new ArrayList<>();
        int i = 0;//用于遍历字符串
        String str;//用于拼接多位数
        char ch;//每历遍到一个字符就放入
        do {
            //如果是非数字压入s1
            if ((ch = expression.charAt(i)) < 48 || (ch = expression.charAt(i)) > 57 ){
                midStrings.add(ch+"");
                i++;
            }else {//如果是一个数考虑多位数问题
                str = "";
                while (i < expression.length() && (ch=expression.charAt(i)) >= 48 && (ch=expression.charAt(i)) <= 57){
                    str =str + ch+ "";//先将当前字符拼接
                    i++;
                }
                midStrings.add(str);
            }
        }while (i<expression.length());
        //转逆波兰表达式
        /**
         * 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
         * 2) 从左至右扫描中缀表达式；
         * 3) 遇到操作数时，将其压s2；
         * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
         * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
         * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
         * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
         * 5) 遇到括号时：  (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
         * 6) 重复步骤2至5，直到表达式的最右边
         * 7) 将s1中剩余的运算符依次弹出并压入s2
         * 8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
         */
        Stack<String> s1 = new Stack<>();//符号栈
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : midStrings) {
            if (item.matches("\\d+")){//扫描到数字
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    String pop = s1.pop();
                    s2.add(pop);
                }
                s1.pop();//消除（
            }else {
                if (s1.isEmpty() || s1.peek().equals("(")){
                    s1.push(item);
                }else if (Operation.getValue(item) > Operation.getValue(s1.peek())){
                    s1.push(item);
                }else {
                    s2.add(s1.pop());
                    s1.push(item);
                }
            }
        }
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        midStrings = s2;

        return midStrings;
    }
    //比较优先级
}
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法， 返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}