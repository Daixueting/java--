package com.bette.bit;

import com.bette.java.IMyStackImpl;

/**
 * @PACKAGE_NAME: com.bette.bit
 * @NAME: TestMyQueue
 * @USER: 代学婷
 * @AIM: 用两个栈实现队列,入队是将数据入到空的栈中，出队是将数据出到另一个栈中，队列是先进先出
 * @DATE: 2019/8/12
 **/
public class TestMyQueue {
    private IMyStackImpl myStack1;
    private IMyStackImpl myStack2;
    public TestMyQueue() {
        myStack1 = new IMyStackImpl();
        myStack2 = new IMyStackImpl();
    }

    //入队放到第一个栈里面
    public void push(int x) {
        myStack1.push(x);
    }

    //出队：===》
    public int pop() {
        if (myStack2.empty()){
            while (!myStack1.empty()){
                myStack2.push(myStack1.pop());
            }
        }
        int temp=-1;
        if (!myStack2.empty()){
            temp=myStack2.pop();
        }
        return temp;
//        if(myStack2.empty()){
//            //把s1里面的数据全部放入s2.s1里面的数据就发生了倒序
//            while(!myStack1.empty()) {
//                myStack2.push(myStack1.pop());
//            }
//        }
//        int tmp = -1;
//        if(!myStack2.empty()){
//            //直接弹出s2栈顶元素
//            tmp = myStack2.pop();
//        }
//        return tmp;
    }
    //得到队头的元素
    public int peek() {
        int data = 0;
        if(myStack2.empty()) {
            while (!myStack1.empty()){
                myStack2.push(myStack1.pop());
            }
        }
        data = myStack2.peek();
        return data;

    }

    public boolean empty() {
        if(myStack1.empty() && myStack2.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TestMyQueue testMyQueue=new TestMyQueue();
        testMyQueue.push(10);
        testMyQueue.push(11);
        testMyQueue.push(12);
        testMyQueue.push(13);
        System.out.println(testMyQueue.peek());
        testMyQueue.push(15);
        System.out.println(testMyQueue.peek());
        System.out.println(testMyQueue.pop());
        System.out.println(testMyQueue.peek());
    }
}
