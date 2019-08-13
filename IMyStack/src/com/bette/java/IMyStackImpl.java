package com.bette.java;

import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.bette.java
 * @NAME: IMyStackImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/12
 **//*
 栈是特殊的顺序表，只能头进头出
 */
public class IMyStackImpl implements IMyStack {
    private int[] elem;
    private  int top; //保存的是当前可以存放数据的下标
   // private  int usedSize;
    private static final int DEFAULT_SIZE=10; //栈的容量

    public IMyStackImpl(){
        this.elem=new int[DEFAULT_SIZE];
        this.top=0;
     //   this.usedSize=0;
    }
    @Override
    public void push(int item) {
        if (top==elem.length){
            elem= Arrays.copyOf(elem,elem.length*2);
        }
        elem[top]=item;
       this.top++;
    }

    @Override
    public int pop() {   //返回栈顶元素并出栈
        if (top==0){
            throw new UnsupportedOperationException("栈为空");
        }
        int sort=elem[top-1];  //top是下个可存放数据的位置，所以栈顶的元素为top-1
        top--;
        return sort;
    }

    @Override
    public int peek() {  //返回栈顶元素不出栈
        if (top==0){
            throw new UnsupportedOperationException("栈为空");
        }
        int sort=elem[top-1];
       // top--;
        return sort;
    }

    @Override
    public boolean empty() {
        if (top==0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
      return top;
    }

    public void display(){
        for (int i = 0; i <top ; i++) {
            System.out.print(elem[i]+"\t");
        }
        System.out.println();
    }
}
