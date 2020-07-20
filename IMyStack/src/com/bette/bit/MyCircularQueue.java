package com.bette.bit;

/**
 * @PACKAGE_NAME: com.bette.bit
 * @NAME: MyCircularQueue
 * @USER: 代学婷
 * @AIM:循环队列，基于数组实现，会浪费一个空间，先进先出
 * @DATE: 2019/8/13
 **/
public class MyCircularQueue {
    private int front;  //对头的下标,出队front++%数组长度；
    private int rear;   //队尾可存入数据的下标,入队rear++%elem.length；
    private int[] elem;  //数组
    private int usedSize; //数组有效个数
    private static final int DEFAULT_SIZE=10;

    public MyCircularQueue(){
        this.front=0;
        this.rear=0;
        this.usedSize=0;
        this.elem=new int[DEFAULT_SIZE];
    }

    public boolean enQueue(int value) { //入队
  //首先要判断队列是否为满
        if (isFull()){
            return false;
        }
        this.elem[this.rear]=value;  //
        this.rear=(this.rear+1)%elem.length;
        this.usedSize++;
        return true;
    }
    public boolean deQueue() { //出队
    //先判断队列是否为空
        if (isEmpty()){
            return false;
        }
        this.front=(this.front+1)%elem.length;
        this.usedSize--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {  //
        if (isEmpty()){
            return -1;
        }
     return elem[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        //rear有可能为O;
        if (rear==0){
            return elem[elem.length-1];
        }
      return elem[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
         return this.usedSize==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    //判为满的方法有两个1.看usedSize是否等于数组长度-1,
        // 2.rear+1%数组长度==front
        if ((this.rear+1)%elem.length==this.front){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue=new MyCircularQueue();
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(5);
       // myCircularQueue.display();

        System.out.println( myCircularQueue.deQueue());
       // myCircularQueue.display();
        System.out.println(myCircularQueue.Front());//4
        System.out.println(myCircularQueue.Front());//2
        System.out.println(myCircularQueue.Rear());//4
    }
}
