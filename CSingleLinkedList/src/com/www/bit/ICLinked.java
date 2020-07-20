package com.www.bit;

/**
 * @PACKAGE_NAME: com.www.bit
 * @NAME: ICLinked
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/8
 **/
public interface ICLinked {
    //头插法
     void addFirst(int data);
    // 尾插法
     void addLast(int data);
    // 任意位置插入,第一个数据节点为0号下标
     boolean addindex(int index,int data);
    // 查找是否包含关键字key是否在单链表当中
     boolean contains(int key);
    // 删除第一次出现关键字为key的节点
    int remove(int key);
    // 删除所有值为key的节点
    void removeAllKey(int key);
    // 得到单链表的长度
      int getLength();
      void display();
      void clear();
     ICLinkedImpl.Node middleNode();
}
