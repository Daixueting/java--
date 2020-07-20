package com.www.bit;

/**
 * @PACKAGE_NAME: com.www.bit
 * @NAME: IDoubleLinkedImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/9
 **/
//不带头的双向链表
public class IDoubleLinkedImpl implements IDoubleLinked {

    public class Node{
        private int data;
        private Node pre;
        private Node next;

        public Node(int data){
            this.data=data;
            this.pre=null;
            this.next=null;
        }
    }
    private Node head;
    private Node last;  //标志尾节点
    public  IDoubleLinkedImpl(){
        this.head=null;
        this.last=null;
    }


    @Override
    public void addFirst(int data) {  //因为带头节点 所以要分第一次插入和后面多次插入
        //头插的时候 last不变
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            this.head.pre=node;
            this.head=node;
        }

    }

    @Override
    public void addLast(int data) {
     //尾插的时候head不变
        //第一次插入
        Node node=new Node(data);
        if (this.head==null){
            this.head=node;
            this.last=node;
        }else {
            node.pre=this.last;
            this.last.next=node;
            this.last=node;
        }

    }

    @Override
    public boolean addindex(int index, int data) {  //不需要知道前驱
        //但是这个也要分头插，和尾插
        //首先要检查index的合法性
        if(index<0||index>getLength()){
            throw new UnsupportedOperationException("插入位置不合法");
        }
        //判断是不是为头插
        if (index==0){
            addFirst(data);
            return true;
        }
        //尾插
        if (index==getLength()){
            addLast(data);
            return true;
        }
        //其他位置插入，要先找到插入的位置,然后插入到这个位置的前面
        Node node=new Node(data);
        Node cur=this.head;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        //插入操作
        node.next=cur;
        node.pre=cur.pre;
        cur.pre.next=node;
        cur.pre=node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        //先判断链表是否为空
        if(this.head==null){
            return false;
        }
        Node cur=this.head;
        while (cur!=null){
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
        //先判断链表不为空
        if (this.head==null){
            throw new UnsupportedOperationException("链表为空");
        }
        //分为头删，中间删除和尾删
        int oldData=0;
        //头删
        if (this.head.data==key){
            oldData=this.head.data;
            this.head=this.head.next;
            this.head.pre=null;
            return oldData;
        }else if (this.last.data==key){
            oldData=this.last.data;
            this.last=this.last.pre;
            this.last.next=null;
            return oldData;
        }
        Node cur=this.head;//这个就是要被删除的节点，不用找前驱
        //中间删除
        while (cur!=null){
            if (cur.data==key){
                oldData=cur.data;
                cur.pre.next=cur.next;
                cur.next.pre=cur.pre;
                return oldData;
            }else {
                cur=cur.next;
            }
        }
        return -1;//表示没有删除
    }

    @Override
    public void removeAllKey(int key) {
        //先判断链表不为空
        if (this.head==null){
            throw new UnsupportedOperationException("链表为空");
        }
        //分为头删，中间删除和尾删
        //头删

        Node cur=this.head;//这个就是要被删除的节点，不用找前驱
        while(cur != null) {
            if(cur.data == key){
                //删除的节点是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                }else {
                    cur.pre.next = cur.next;
                    if(cur.next != null) {
                        cur.next.pre = cur.pre;
                    }else{
                        //删除最后一个节点，last需要指回来。
                        this.last = cur.pre;
                    }
                }
                //return oldData;
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        Node cur=this.head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
   Node cur=this.head;
   while (cur!=null){
       System.out.print(cur.data+"\t");
       cur=cur.next;
   }
        System.out.println();
    }

    @Override
    public void clear() {
   while (this.head!=null){
       Node node=this.head.next;
       this.head.next=null;
       this.head.pre=null;  //因为最后last会指向一个前驱
       this.head=node;
   }
   this.last=null;
    }
}
