package com.bit.dao;

import com.bit.impl.ILinked;

/**
 * @PACKAGE_NAME: com.bit.dao
 * @NAME: ILinkedImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/7
 **/
    //无头单向非循环链表实现:就弄一个构造函数
    //若是有头节点 ，则头结点的data不存数据，next指向第一个节点的位置
    //不带头节点的单链表一定要考虑到  头结点的插入和删除
public class ILinkedImpl implements ILinked {
    //用成员内部类来表示节点

   public class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;   //始终是第一个节点
    public ILinkedImpl(){
        this.head=null;
    }
    @Override
    public void addFirst(int data) {  //头插分为第一次头插和不是第一次插入
     //第一次头插
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
        }else{   //不是头插
            node.next=this.head;
            this.head=node;
        }

    }

    @Override
    public void addLast(int data) {   //也分为第一次尾插和不是第一次尾插
        //第一次尾插
        Node node=new Node(data);
       Node cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{   //不是第一次尾插

           while (cur.next!=null){   //这个判断条件是需要找到cur是最后一个节点
               cur=cur.next;
           }
           cur.next=node;
        }

    }

    @Override
    public boolean addindex(int index, int data) {  //这个插入需要找直接前驱插入
        //要分为头插，尾插，其他位置插入
        //首先跑判断index的合法性
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标位置不合法");
        }
        if(index==0){
            addFirst(data);
        }else if(index==getLength()){
            addLast(data);
        }else {
            Node node=new Node(data);
            Node cur=this.head; //用来找直接前驱
            for (int i = 0; i <index-1 ; i++) {
                cur=cur.next;
            }
            //应该先让node=cur.next;
            node=cur.next;
            cur.next=node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


//    @Override
//    public int remove(int key) {
//        int  oldData=0;
//        Node pre=searchPre(key);
//        if (pre==this.head&&pre.data==key){
//            oldData=this.head.data;
//            this.head=this.head.next;
//            return oldData;
//        }
//        if (pre==null){
//            return -1; //表示没有找到
//        }
//        oldData=pre.next.data;
//
//          pre.next =pre.next.next; //这种写法有空指针异常的错误
////        Node delNode=pre.next;
////        pre.next=delNode.next;
//     return oldData;
//
//    }
//
//    //这个方法中来找删除节点的前驱
//    private Node searchPre(int key){
//        Node pre=this.head;
//        if (pre.data==key){
//            return this.head;
//        }while (pre.next!=null){
//            if (pre.next.data==key){
//                return pre;
//            }
//            pre=pre.next;
//        }
//        return null;
//    }

//    @Override
//    public int remove(int key) {
//        //删除 要分为删除第一个节点 和后面其他节点
//        //删除后面节点的时候  是要找前驱删除
//   Node pre=this.head; //表示要删除节点的前驱
//   int oldData;
//        //删除第一个节点
//        if(this.head.data==key){
//        oldData=this.head.data;
//            this.head=this.head.next;
//
//            return oldData;
//        }
//            while (pre.next!=null){
//                if(pre.next.data==key){  //表示pre.next 就是我们要删除的节点
//                    oldData=pre.next.data;
//                    pre.next=pre.next.next;
//                    return oldData;
//                }else{
//                    pre=pre.next;
//                }
//            }
//
//       return -1; //表示链表中存在要删除的key
//    }


    @Override
    public int remove(int key) {
        Node pre=this.head;
        Node cur=this.head.next;
        int oldData=0;
        while(cur!=null){
            if(cur.data==key){
                oldData=cur.data;
                pre.next=cur.next;
                cur=pre.next;
                return oldData;
            }else{
                pre=cur;
                cur=pre.next;
            }
        }
        if(this.head.data==key){
            oldData=this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        return -1; //表示链表中没有key值得关键字
    }

    @Override
    public void removeAllKey(int key) {  //先检查后面的所有节点，在最后检查头结点
       Node pre=this.head;
       Node cur=this.head.next;
       while(cur!=null){
           if(cur.data==key){
               pre.next=cur.next;
               cur=pre.next;
           }else{
               pre=cur;
               cur=pre.next;
           }
       }
      if(this.head.data==key){
          this.head=this.head.next;
      }
    }

    @Override
    public int getLength() {   //返回节点的个数
     Node cur=this.head;
     int a=0;
     while(cur!=null){
         cur=cur.next;
         a++;
     }
        return a;
    }

    @Override
    public void display() {
    Node cur=this.head;
    while (cur!=null){ //判断条件应该是cur！=null，因为cur.next！=null表示的是cur是最后一个节点，但是最后一个节点也用该打印
         System.out.print(cur.data+"\t");
        cur=cur.next;
    }
        System.out.println();
    }

    @Override
    public void clear() {
    while(this.head!=null){
        Node cur=this.head.next;
        this.head.next=null;
        this.head=cur;
    }
    }
}
