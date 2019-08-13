package com.bette.java;

import com.bette.bit.IMyQueueImpl;
/**
 * @PACKAGE_NAME: com.bette.java
 * @NAME: TestMyStack
 * @USER: 代学婷
 * @AIM:  用队列实现栈，用两个队列来实现一个栈
 * @DATE: 2019/8/12
 **/
public class TestMyStack {
    //出栈：出的是不为空的队列
    //入栈：也存入到不为空的队列中
    private IMyQueueImpl myQueue1;
    private IMyQueueImpl myQueue2;
    private int usedSize;

    public TestMyStack(){
        myQueue1=new IMyQueueImpl();
        myQueue2=new IMyQueueImpl();
        this.usedSize=0;

    }

    //入栈：放在不为空的队列中
    public void push(int x) {
    if (myQueue1.empty()){
        myQueue1.add(x);
    } else if (myQueue2.empty()){
        myQueue2.add(x);
    }else{
        myQueue1.add(x);
    }
    this.usedSize++;
    }


    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data = 0;
        if(!myQueue2.empty()) {
            for (int i = 0; i < this.usedSize-1; i++) {
                myQueue1.add(myQueue2.poll());
            }
            data = myQueue2.poll();
            this.usedSize--;
            return data;
        }else {
            for (int i = 0; i < this.usedSize-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            data = myQueue1.poll();
            this.usedSize--;
            return data;
        }
    }
//    public int pop() {   //出栈出不为空的队列
//        int sort=0;
//        if (empty()){
//            throw new UnsupportedOperationException("栈为空");
//        }
//        if (!myQueue1.empty()){
//            //将出出来的数据存到另一个栈中 ，出usedSize-1个数据
//            for (int i = 0; i <this.usedSize-1; i++) {
//                myQueue2.add(myQueue1.poll());
//            }
//            sort=myQueue1.poll();
//          // return sort;
//        }else {
//            for (int i = 0; i <this.usedSize-1 ; i++) {
//                myQueue1.add(myQueue2.poll());
//            }
//            sort=myQueue2.poll();
//
//        }
//        this.usedSize--;
//        return sort;
//    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data = 0;
        if(!myQueue2.empty()) {
            for (int i = 0; i < this.usedSize; i++) {
                data = myQueue2.poll();
                myQueue1.add(data);
            }
            return data;
        }else {
            for (int i = 0; i < this.usedSize; i++) {
                data = myQueue1.poll();
                myQueue2.add(data);
            }
            return data;
        }
    }

//    public int top() {     //得到栈顶元素但是不出队列
//        int sort=0;
//        if (empty()){
//            throw new UnsupportedOperationException("栈为空");
//        }
//        if (myQueue1.empty()){
//            //将出出来的数据存到另一个栈中 ，出usedSize个数据 //因为不删除
//            for (int i = 0; i <this.usedSize; i++) {
//                sort=myQueue1.peek();
//                myQueue2.add(myQueue1.poll());
//            }
//
//            // return sort;
//        }else {
//            for (int i = 0; i <this.usedSize ; i++) {
//                sort=myQueue2.poll();
//                myQueue1.add(myQueue2.poll());
//            }
//        }
//        return sort;
//    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

    return this.usedSize==0;
    }

    public int size(){
     return this.usedSize;
    }

    public static void main(String[] args) {
       TestMyStack testMyStack=new TestMyStack();
       testMyStack.push(1);
       testMyStack.push(2);
       testMyStack.push(3);
       testMyStack.push(4);
        System.out.println(testMyStack.size());
        System.out.println(testMyStack.usedSize==0);
       System.out.println(testMyStack.pop());//得到栈顶元素但是出队列
        System.out.println(testMyStack.top());
        System.out.println(testMyStack.size());
    }
}
