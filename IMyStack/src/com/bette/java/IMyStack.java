package com.bette.java;

/**
 * @PACKAGE_NAME: com.bette
 * @NAME: IMyStack
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/12
 **/
public interface IMyStack {
     // 将 item 压入栈中
     void push(int item);
    // 返回栈顶元素，并且出栈
     int pop();

    // 返回栈顶元素，但不出栈
     int peek();
    // 判断这个栈是否为空栈
     boolean empty();
    // 返回元素个数
     int size();
}
