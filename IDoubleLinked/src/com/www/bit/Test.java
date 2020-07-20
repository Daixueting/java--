package com.www.bit;

/**
 * @PACKAGE_NAME: com.www.bit
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/9
 **/
public class Test {
    public static void main(String[] args) {
        IDoubleLinkedImpl iDoubleLinked=new IDoubleLinkedImpl();
        iDoubleLinked.addFirst(1);
        iDoubleLinked.addFirst(2);
        iDoubleLinked.addFirst(3);
        iDoubleLinked.addFirst(4);
        System.out.println(iDoubleLinked.getLength());
        iDoubleLinked.display();
        iDoubleLinked.addLast(5);
        iDoubleLinked.addLast(6);
        iDoubleLinked.addLast(7);
        iDoubleLinked.addLast(8);
        iDoubleLinked.display();
        iDoubleLinked.addindex(0,10);
        iDoubleLinked.addindex(iDoubleLinked.getLength(),10);
        iDoubleLinked.addindex(3,10);
        iDoubleLinked.display();
        iDoubleLinked.remove(2);
        iDoubleLinked.remove(3);
        iDoubleLinked.display();
        System.out.println(iDoubleLinked.getLength());
       iDoubleLinked.removeAllKey(10);
        iDoubleLinked.display();
    }
}
