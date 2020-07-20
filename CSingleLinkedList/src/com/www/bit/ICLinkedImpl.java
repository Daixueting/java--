package com.www.bit;

/**
 * @PACKAGE_NAME: com.www.bit
 * @NAME: ICLinkedImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/8
 **/
/*
* 带头单链表就是头结点不存数据只存下个节点的地址
* 所以就表示内部类有两种构造方法
* 带头单链表的好处就是  插入和删除的时候不用考虑是不是头删
* 头结点不算 单链表的节点个数
* */
public class ICLinkedImpl implements ICLinked{
    public class Node{
        private int data;
        private Node next;

        public Node(){
            this.data=-1; //表示头结点不存数据
            this.next=null;
        }

        public Node(int data){
            this.data=data;
            this.next=null;
        }

        public int getData() {
            return data;
        }
    }

    public Node head;    //若是只有头结点 head.next应该等于head
    public  ICLinkedImpl(){
        this.head=new Node();
        this.head.next=this.head;
    }
    @Override
    public void addFirst(int data) {
     //不用分是不是第一次插入
        Node node=new Node(data);
        node .next=this.head.next;
        this.head.next=node;
    }

    @Override
    public void addLast(int data) {
   //先利用while()找到最后一个节点，在插入
        Node node=new Node(data);
        Node cur=this.head;
        while (cur.next!=head){
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
    }

    @Override
    public boolean addindex(int index, int data) {   //不用管是不是头插 尾插 还是第一次插入
        //这个要先判断index的合法性
        Node node=new Node(data);
        Node cur=this.head;
        if(index<0||index>getLength()){
            throw new UnsupportedOperationException("下表不合法");
        }
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
        return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head.next;
        while (cur.next!=null){

            if (cur.data==key){
                return true;
            }else{
                cur=cur.next;
            }

        }
        return false;
    }

    @Override
    public int remove(int key) {
        //首先要判断单链表是否为空，
        int oldData=0;
        Node pre=this.head;
        Node cur=this.head.next;
        if(pre.next==this.head){
            throw new UnsupportedOperationException("此单链表为空");
        }
        while (cur!=this.head){
            if(cur.data==key){
                oldData=cur.data;
                pre.next=cur.next;
                cur.next=pre.next;
                return oldData;
            }else{
                pre=pre.next;
                cur=pre.next;
            }

        }
        return -1; //表示单链表中没有这个数据的节点
    }

    @Override
    public void removeAllKey(int key) {
        Node pre=this.head;
        Node cur=this.head.next;
        if(pre.next==this.head){
            throw new UnsupportedOperationException("此单链表为空");
        }
        while (cur!=this.head){
            if(cur.data==key){
                pre.next=cur.next;
                cur=pre.next;
            }else{
                pre=cur;
                cur=pre.next;
            }

        }

    }

    @Override
    public int getLength() {
        Node cur=this.head.next;
        int count=0;
        while (cur!=this.head){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head.next;
        while(cur!=this.head){
            System.out.print(cur.data+"\t");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head.next != this.head) {
            Node cur = this.head.next;
            this.head.next=cur.next;
            cur.next=null;
        }
        this.head=null;
    }
  //面试问题

  //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
  public Node middleNode() {
  int a=getLength();
  Node cur=this.head.next;
  for (int i=0;i<a/2;i++){
      cur=cur.next;
  }
  return cur;
  }
}
