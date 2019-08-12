package com.www.bit;

/**
 * @PACKAGE_NAME: com.www.bit
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/8
 **/
public class Test {
    public static void main(String[] args) {
        ICLinkedImpl icLinked=new ICLinkedImpl();
        icLinked.addFirst(1);
        icLinked.addFirst(2);
        icLinked.addFirst(3);
        icLinked.addFirst(4);
        icLinked.addLast(6);
        icLinked.addLast(7);
        icLinked.addLast(8);
        icLinked.addLast(9);
        icLinked.addLast(10);
        icLinked.display();
        System.out.println(icLinked.getLength()+"====================");
        icLinked.addindex(2,0);
        icLinked.addindex(0,11);
        icLinked.addindex(icLinked.getLength(),0);
        icLinked.display();
        icLinked.remove(1);
        icLinked.remove(2);
        icLinked.display();
        System.out.println("============================");
        icLinked.removeAllKey(0);
        icLinked.display();
        System.out.println("====================");
        System.out.println(icLinked.contains(3));
        System.out.println("=======================================");
      //  icLinked.clear();
        //icLinked.display();
        ICLinkedImpl.Node cur=icLinked.middleNode();
        System.out.println(cur.getData());
    }
}
