package com.atguigu.stack;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        String stdIn = "(1+((2+3)*(4*5)))";

        //表达式栈
        Stack<String> exps = new Stack<>();
        //数栈
        Stack<Integer> vals = new Stack<>();

        for (int i = 0; i < stdIn.length(); i++) {
            String s = String.valueOf(stdIn.charAt(i));
            //System.out.println(s);
            if(s.equals("(")){

            } else if (s.equals("+")) {
                exps.push(s);
            } else if (s.equals("-")) {
                exps.push(s);
            } else if (s.equals("*")) {
                exps.push(s);
            } else if (s.equals("/")) {
                exps.push(s);
            } else if (s.equals(")")){
                String exp = exps.pop();
                int val = vals.pop();

                if(exp.equals("+")){
                    val = vals.pop() + val;
                } else if (exp.equals("-")){
                    val = vals.pop() - val;
                } else if (exp.equals("*")){
                    val = vals.pop() * val;
                } else if (exp.equals("/")){
                    val = vals.pop() / val;
                }
                vals.push(val);
            } else {
                vals.push(Integer.valueOf(s));
            }
        }
        System.out.println(vals.pop());
    }
}
