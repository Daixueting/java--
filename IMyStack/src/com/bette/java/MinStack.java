package com.bette.java;

/**
 * @PACKAGE_NAME: com.bette.java
 * @NAME: MinStack
 * @USER: 代学婷
 * @AIM: 最小栈，是由有个栈组成的，一个是用来存所有数据的，一个是用来存与自己栈顶比小的那个数据
 * @DATE: 2019/8/13
 **/
public class MinStack {
    private IMyStackImpl myStack;//用来存所有的数据
    private IMyStackImpl minStack;//用来存比栈顶小的数据
    public MinStack(){
        myStack=new IMyStackImpl();
        minStack=new IMyStackImpl();
    }

   public void push(int x) {
   myStack.push(x);
   if (minStack.empty()){//如果minStack为空 就直接放入，如果不为空就要和自己本身的栈顶元素想比较小于在放入
       minStack.push(x);
   }else{
       if (minStack.peek()>=x){
           minStack.push(x);
       }
   }
    }

    public void pop() {  //出栈，如果最小栈的栈顶元素等于myStack的栈顶元素，则就要出栈，否则不用出栈
     if (!myStack.empty()){
         int temp=myStack.pop();
         if (temp==minStack.peek()){
             minStack.pop();
         }
     }
    }

    public int top() {  //得到栈顶元素，但是不出栈
        if (!myStack.empty()){
            int temp=myStack.peek();
            return temp;
        }
        return -1; //栈为空
    }

    public int getMin() {
     if (minStack.empty()){
         return  -1;
     }
     return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(1);
        minStack.push(-2);
        minStack.push(5);
        minStack.push(8);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
