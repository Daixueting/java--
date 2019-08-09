package com.bit.Test;

import com.bit.dao.ILinkedImpl;

/**
 * @PACKAGE_NAME: com.bit.Test
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/7
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ILinkedImpl iLinked=new ILinkedImpl();

        iLinked.addLast(1);
        iLinked.addLast(1);
        iLinked.addFirst(10);
        iLinked.addFirst(18);
        iLinked.addFirst(78);
        iLinked.addFirst(99);
        iLinked.display();
        iLinked.addindex(1,88);
        iLinked.addLast(100);
        iLinked.addindex(0,2);
        iLinked.display();
        System.out.println(iLinked.contains(100));
     //   iLinked.remove(78);
        iLinked.remove(99);
        iLinked.remove(100);
        iLinked.display();
        iLinked.removeAllKey(1);
        iLinked.display();
        Thread.sleep(1000);
        System.out.println("===========================");
        iLinked.clear();
        iLinked.display();
    }

}
