package DataStructures.stack;

/**
 * @PackgeName: DataStructures.stack
 * @ClassName: Calculator
 * @Author: 小天才
 * Date: 2021/5/26 9:44
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 计算器
 */
public class Calculator {
    public static void main(String[] args) {
        //根据之前模拟的栈完成
        String expression = "90+2*6-2*12/12";
        //创建两个栈（数栈，符号栈）
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack poerStack = new ArrayStack(10);
        //定义索引用于扫描数值
        int index = 0;
        int num1 = 0;//接收计算数值
        int num2 = 0;
        char oper = ' ';//接收符号
        char ch = ' ';//保存接收的符号
        int res = 0;
        String keepNumber = "";//用于拼接多位数

        //开始循环扫描
        while (true){
            //单独取消计算式中的每一个值
            ch = expression.substring(index,index + 1).charAt(0);
            //判断ch是什么做出相应的操作
            if (poerStack.isOper(ch)){//如果是运算符
                //判断栈是否为空
                if (!poerStack.isEmpty()){
                    //判断优先级
                    if (poerStack.priority(ch) <= poerStack.priority((char) poerStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) poerStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //结果入数栈
                        numStack.push(res);
                        //当前符号入符号栈
                        poerStack.push(ch);
                    }else {
                        //如果当前符号优先级大于栈内符号优先级
                        //直接入栈
                        poerStack.push(ch);
                    }

                }else {
                    poerStack.push(ch);
                }
            }else {//如果是数,直接入数栈
                //numStack.push(ch - 48);
                //如果是最后一位直接入栈
                if (index == (expression.length() - 1) ){
                    numStack.push(ch);
                }else {
                    keepNumber = keepNumber + ch;
                    //判断下一个是不是数字
                    if(poerStack.isOper(expression.substring(index + 1,index + 2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNumber));
                        keepNumber = "";
                    }
                }

            }
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        while (true){
            //如果符号栈为空则会得到计算结果
            if (poerStack.isEmpty()){
                break;
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = (char) poerStack.pop();
                res = numStack.cal(num1,num2,oper);
                numStack.push(res);
            }
        }
        System.out.printf("表达式%s=%d",expression,numStack.pop());

    }
}

