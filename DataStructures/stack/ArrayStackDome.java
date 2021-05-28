package DataStructures.stack;

/**
 * 用数组模拟栈
 */
public class ArrayStackDome {
    public static void main(String[] args) {
        //test
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("栈顶数据为："+stack.pop());
        stack.list();

    }
}
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，用来模拟栈
    private int top = -1;//top 表示栈顶
    //创建构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    /**
     * 栈满
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }
    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     * 入栈
     */
    public void push(int value){
        //首先判断是否为满
        if (isFull()){
            System.out.println("此栈已满！无法加入数据。");
        }
        top++;
        stack[top] = value;
    }
    /**
     * 出栈,栈顶数据返回
     */
    public int pop(){
        //首先判断是否为空
        if (isEmpty()){
            throw new RuntimeException("数据为空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    /**
     * 显示数据
     */
    public void list(){
        if (isEmpty()) {
            throw new RuntimeException("数据为空");
        }
        //从栈顶开始打印数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
    /**
     * 判断计算符号优先级(假定返回的数字越大，计算的优先级越高)
     */
    public int priority(char oper) {
        if (oper == '+' || oper == '-'){
            return 0;
        }else if (oper == '*' || oper == '/'){
            return 1;
        }else {
            return -1;
        }
    }
    /**
     * 判断是数字还是符号
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    /**
     * 计算方法
     */
    public int cal(int num1,int num2,char oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//note:顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//note:顺序
                break;
        }
        return res;
    }
    /**
     * 显示栈顶数据（不出栈）
     */
    public int peek(){
        return stack[top];
    }
}
