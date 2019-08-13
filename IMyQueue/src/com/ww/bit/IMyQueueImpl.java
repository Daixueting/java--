package com.ww.bit;

/**
 * @PACKAGE_NAME: com.ww.bit
 * @NAME: IMyQueueImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/12
 **/

/*
* 队列是特殊单链表。尾进头出
* */
public class IMyQueueImpl implements IMyQueue {

    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

    } private Node head;  //指向单链表的头
    private Node last;  //指向单链表的尾

    public IMyQueueImpl() {
        this.head=null;
        this.last=null;
    }
    @Override
    public boolean empty() {
        if(this.head==null){
            return true;
        }
        return false;
    }

    @Override
    public int peek() {  // 返回队首元素，但不出队列
        if (empty()==true){
            throw  new UnsupportedOperationException("队列为空，没有队首元素");
        }
        int sort=this.head.data;
        return sort;
    }

    @Override
    public int poll() {  //返回队首元素，并出队
        if (empty()==true){
            throw  new UnsupportedOperationException("队列为空，没有队首元素");
        }
        int sort=this.head.data;
        this.head=this.head.next;
        return sort;
    }

    @Override
    public void add(int item) {  //插入采用尾插
        Node cur=new Node(item);
     if (this.head==null){
         this.head=cur;
         this.last=cur;
     }else{
         this.last.next=cur;
         this.last=cur;
     }
    }

    @Override
    public int size() {
        Node cur =this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    public void display(){
        Node cur =this.head;
      // int count=0;
        while(cur!=null){
            System.out.print(cur.data+"\t");
            cur=cur.next;
        }
        System.out.println();
    }
}
