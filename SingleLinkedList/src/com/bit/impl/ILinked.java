package com.bit.impl;

import com.bit.dao.ILinkedImpl;

/**
 * @PACKAGE_NAME: com.bit.impl
 * @NAME: ILinked
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/7
 **/
public interface ILinked {
    //头插法
    void addFirst(int data);
    // 尾插法
    void addLast(int data);
    // 任意位置插入,第一个数据节点为0号下标
    boolean addindex(int index,int data);
   //  查找是否包含关键字key是否在单链表当中
    boolean contains(int key);
    // 删除第一次出现关键字为key的节点
    int remove(int key);
  //  删除所有值为key的节点
    void removeAllKey(int key);
    // 得到单链表的长度
     int getLength();
     void display();
     void clear();
     ILinkedImpl.Node FindKthToTail(int k); //返回倒数第k个节点的值
     void partition(int x);  //基准
     void deleteDuplication(); //删除重复节点
     boolean chkPalindrome();  //回文
    boolean hasCycle();//判断是否有环
}
