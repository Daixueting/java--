package com.bette.java;


import java.util.Scanner;

/**
     * @PACKAGE_NAME: com.bette.java
     * @NAME: Test
     * @USER: 代学婷
     * @AIM:
     * @DATE: 2019/8/12
     **/

    class Solution {
        //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        //所有的左括号入栈，如果没有左括号直接返回fasle
        //如果遇到对应的右括号，则出栈，如果不对应则返回false，如果对应继续匹配，直至栈为空为止
        public boolean isValid(String str) {
            char[] stack=new char[str.length()];
            int top=0;
            //然后开始入栈
            for (int i = 0; i <str.length() ; i++) {
                //等于左括号的时候入栈
                if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                    stack[top]=str.charAt(i);
                    top++;
                }else{//表示为右括号
                    //top=0时有可能表示为一开始为右括号，也有可能表示的是右括号多余左括号
                    if(top==0){
                        return false;
                    }
                    //将左括号拿出来和右括号进行匹配，如果比配左括号出栈，如果右括号不匹配则返回false
                    if(stack[top-1]=='('&&str.charAt(i)==')'||stack[top-1]=='['&&str.charAt(i)==']'
                            ||stack[top-1]=='{'&&str.charAt(i)=='}'){   //在上面top等于0的时候top-1是越界的
                        top--;
                    }else{
                        return false;
                    }
                }
            }
            if (top!=0){  //表示左括号比较多
                return false;
            }
            return true;
        }
    }

    public class Test {
    public static void main(String[] args) {
        IMyStackImpl iMyStack=new IMyStackImpl();
        iMyStack.push(1);
        iMyStack.push(2);
        iMyStack.push(3);
        iMyStack.push(4);
        iMyStack.push(5);
        iMyStack.display();
        System.out.println(iMyStack.pop());
        iMyStack.display();
        System.out.println(iMyStack.peek());
        iMyStack.display();
        System.out.println(iMyStack.empty());
        System.out.println(iMyStack.size());
        System.out.println("======================");
        Solution solution=new Solution();
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(solution.isValid(str));
    }
}
