package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        //中缀表达式转换为后缀表达式
        // 1 + ((2+3) * 4) - 5 => 1 2 3 + 4 * + 5 -
        // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        // [1,+,(,(,2,+,3,),*,4,),-,5] => Arraylist [1,2,3,+,4,*,+,5,-]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("infixExpressionList=" + infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("parseSuffixExpressionList=" + parseSuffixExpressionList);
        System.out.printf("expression=%d",calculate(parseSuffixExpressionList));


        System.out.println();
        //(3 + 4) * 5 - 6 = 29
        String suffixExpression = "3 4 + 5 * 6 -";

        //放到ArrayList中
        //将ArrayList 传递一个方法，遍历将ArrayList配合栈完成计算
        List<String> renList = getListString(suffixExpression);
        System.out.println("renList=" + renList);

        int res = calculate(renList);
        System.out.println("计算的结果=" + res);
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<String>();
        //Stack<String> s2 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        for (String item :
                ls) {
            //如果是一个数，入栈
            if(item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出栈, 消除小括号
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中缀表达式转换对应的List
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;//指针，用于遍历 中缀表达式字符串
        String str;//对多位数拼接工作
        char c;//每遍历一个字符，就放入c
        do{
            //如果c是一个非数字，需要加入到ls
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            } else {
                str = "";//str 重置
                while (i < s.length() && (c=s.charAt(i)) >=48 && (c=s.charAt(i)) <= 57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());

        return ls;
    }

    //将表达式，依次将数据和运算符放入ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele :
                split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item :
                ls) {
            if (item.matches("\\d+")){
                stack.add(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 *num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//返回一个运算符优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
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

