package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {
        //String expression = "3+2*6-2";
        //String expression = "30+20*6-2";
        String expression = "7-2*3+1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么做相应处理
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);

                        //把结果入数栈
                        numStack.push(res);
                        //将当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //优先级大于栈中的操作符，直接入栈
                        operStack.push(ch);
                    }
                }else{
                    //为空直接入符号栈
                    operStack.push(ch);
                }
            } else {
                //数则直接入栈
                //numStack.push(ch - 48);
                //处理多位数时，不能发现是一个数立即入栈，因为他可能是多位数
                //在处理数 需要向expression的表达式的index 后再看一位，如果是数就进行扫描，如果是符号才入栈
                //需要定义变量字符串，用于拼接

                //处理多位数
                keepNum += ch;

                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                } else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            //让index+1，判断是否扫描到expression最后
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        //表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字 结果
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression,res2);
    }
}

class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //返回当前栈顶的值，但不是真正弹出栈
    public int peek(){
        return stack[top];
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //判断运算符优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
            default:
                break;
        }
        return res;
    }
}