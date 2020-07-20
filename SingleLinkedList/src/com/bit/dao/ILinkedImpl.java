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

    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }

    private Node head;   //始终是第一个节点

    public ILinkedImpl() {
        this.head = null;
    }

    @Override
    public void addFirst(int data) {  //头插分为第一次头插和不是第一次插入
        //第一次头插
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {   //不是头插
            node.next = this.head;
            this.head = node;
        }

    }

    @Override
    public void addLast(int data) {   //也分为第一次尾插和不是第一次尾插
        //第一次尾插
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {   //不是第一次尾插

            while (cur.next != null) {   //这个判断条件是需要找到cur是最后一个节点
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    @Override
    public boolean addindex(int index, int data) {  //这个插入需要找直接前驱插入
        //要分为头插，尾插，其他位置插入
        //首先跑判断index的合法性
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标位置不合法");
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == getLength()) {
            addLast(data);
        } else {
            Node node = new Node(data);
            Node cur = this.head; //用来找直接前驱
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            //应该先让node.next=cur.next;
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
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


    @Override
    public int remove(int key) {
        //删除 要分为删除第一个节点 和后面其他节点
        //删除后面节点的时候  是要找前驱删除
        Node pre = this.head; //表示要删除节点的前驱
        int oldData;
        //删除第一个节点
        if (this.head.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        while (pre.next != null) {
            if (pre.next.data == key) {
                oldData = pre.next.data;
                pre.next = pre.next.next;
                return oldData;
            } else {
                pre = pre.next;
            }
        }


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
        return -1; //表示链表中存在要删除的key
    }


//    @Override
//    public int remove(int key) {
//        Node pre=this.head;
//        Node cur=this.head.next;
//        int oldData=0;
//        //如果是首删，应该先检查，头结点是否等于key值得
//        if(this.head.data==key){
//            oldData=this.head.data;
//            this.head=this.head.next;
//            return oldData;
//        }
//        while(cur!=null){  //这个循环体是没有检查头节点是否等于key
//            if(cur.data==key){
//                oldData=cur.data;
//                pre.next=cur.next;
//                cur=pre.next;
//                return oldData;
//            }else{
//                pre=cur;
//                cur=pre.next;
//            }
//        }
//     return -1;     //表示链表中没有关键字key
//
//    }

    @Override
    public void removeAllKey(int key) {  //先检查后面的所有节点，在最后检查头结点
        Node pre = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {   //返回节点的个数
        Node cur = this.head;
        int a = 0;
        while (cur != null) {
            cur = cur.next;
            a++;
        }
        return a;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) { //判断条件应该是cur！=null，因为cur.next！=null表示的是cur是最后一个节点，但是最后一个节点也用该打印
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

    //下面都是面试问题
    public Node FindKthToTail(int k) {  //返回倒数第k个节点
        //先让fast走k-1步；然后fast为最后一个节点得到时候slow就是要返回的节点值
        if (k <= 0 || k > getLength()) {
            return null;
        }
        if (this.head == null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public void partition(int x) {  //【自己记得练习】
        //先创两个链表 一个放小于x，【尾插】一个放大x的，但是这两个链表的头和尾都要保存
        // 最后将三个连接起来
        //会有内存泄漏
        Node cur = this.head;
        Node cur1Start = null;  //放小于
        Node cur1End = null;  //放小于
        Node cur2Start = null;  //放大于
        Node cur2End = null;  //放大于
        while (cur != null) {
            Node curNext = cur.next;
            if (cur.data < x) {
                if (cur1Start == null) {
                    cur1Start = cur;
                    cur1End = cur;
                } else {  //尾插时头部动
                    cur1End.next = cur;
                    cur1End = cur;
                }

            } else {
                if (cur2Start == null) {
                    cur2Start = cur;
                    cur2End = cur;
                } else {  //尾插时头部动
                    cur2End.next = cur;
                    cur2End = cur;
                }

            }
            cur.next = null;
            cur = curNext;
        }
        //连接但是有可能第一段或者第二段没有数据
        if (cur1Start == null) {
            this.head = cur2Start;
        } else if (cur2Start == null) {
            this.head = cur1Start;
        } else {
            cur1End.next = cur2Start;
            this.head = cur1Start;

        }
    }

    //单链表的反转【可以用头插来反转】
    //用pre来保存cur的前驱，用curNext来保存cur的next值

    public void reverseList() {
        Node pre = null;
        Node cur = this.head;

        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                this.head = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
            //    curNext=curNext.next;
        }
        //this.head=cur;//出了循环的cur=null；

    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public void deleteDuplication() {
        //遍历链表 新建一个链表 将不重复的节点尾插到新的链表中
        Node node = new Node(-1);//新的虚拟头节点
        Node nodeHesd = node;
        Node cur = this.head;
 //       Node curNext = cur.next; //为了不空指针异常 所以要保证curNext是最后一个节点
        //这么写是保留了那个重复的节点，因为他俩相等的时候只能走了一步
//        while (curNext!=null){
//
//            if(cur.data!=curNext.data){
//                node.next=cur;//这个就想当于第一插入 还有尾插
//                node=cur;    //node是个尾结点
//                cur=cur.next;
//            }else{
//               cur=cur.next;
//
//            }
        while (cur!=null) {

            if (cur.next!= null && cur.data == cur.next.data) {
                //这个循环是保证多走几步 跳过所有重复的节点
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;//到这里不重复了
                node.next=cur;  //但是node.next在这里会一直被覆盖  //最后会被覆盖成null
            } else {
                node.next = cur;//这个就想当于第一插入 还有尾插
                node = cur;    //node是个尾结点
                cur = cur.next;
            }
        }
        this.head = nodeHesd.next;
    }

   //回文  fast每次走两步 slow每次走一步【等fast最后一个节点的时候则slow为中间的节点】
  //再将slow到fast这个部分的节点逆zhi
    //然后head往后走，fast往前走比较
    //还要分为奇数或者偶数
   public boolean chkPalindrome() {
    if (this.head==null){
        return false;
    }
    if(this.head.next==null){
        return true;
    }

    //奇数的时候

    Node fast=this.head;
    Node slow=this.head;
    while(fast!=null&&fast.next!=null){
        fast=fast.next.next;   //奇数的fast为最后一个节点，偶数的时候fast为null
        slow=slow.next;  //循环完成奇数的时候slow就是中间位置，偶数的时候slow为中间后面的节点
    }
    //将后面逆zhi
       Node cur=slow;
       Node cur1=slow.next;
       Node cur2=cur1.next;
         while (cur1!=null){

           //cur.next=null;
           cur1.next=cur;
           cur=cur1;
           cur1=cur2;
           if (cur2!=null){
               cur2=cur2.next;
           }
       }
         //逆zhi完成之后判断head和fast的data值是否相同，
       //若是判断偶数节点是否为回文结构，则不能用fast，应该用cur【逆zhi的时候用的前驱】
       while(cur!=this.head){
           if (cur.data!=this.head.data){
               return false;
           }
           //针对于偶数
           if (this.head.next==cur){
               return true;
           }
           this.head=this.head.next;
           cur=cur.next;
       }
       return true;
   }

   //建一个环
   public  void createCycle(){
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
   }


   //判断单链表是否有环
   public boolean hasCycle() {
   //fast走两步，slow走一步，如说相遇就说明有环
       Node fast=this.head;
       Node slow=this.head;
       while(fast!=null&&fast.next!=null){  //如果有环就是break出循环，如果没有环就会条件截止循环
           fast=fast.next.next;
           slow=slow.next;
           if(fast==slow){
               break;
           }
       }

       if (fast!=null&&slow!=null&&fast==slow){
           return true;
       }
       return false;
   }

     //返回入环的第一个节点
    //头节点到入口点和相遇点到入口点  相差的步数是一样的【】

    public Node detectCycle() {
    boolean sort=hasCycle();
    if(sort==false){
        return null;  //表示无环
    }
   // int count=0;
    Node fast=this.head;
    Node slow=this.head;
        while(fast!=null&&fast.next!=null){  //如果有环就是break出循环，如果没有环就会条件截止循环
            fast=fast.next.next;
            slow=slow.next;
      //      count++
            if(fast==slow){
                break;
            }
        }
        //然后让fast=this.head,，让fast和slow在继续走 想等的时候就是入口节点
        fast=this.head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}