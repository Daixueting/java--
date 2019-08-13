package com.ww.bit;

/**
 * @PACKAGE_NAME: com.ww.bit
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/12
 **/
public class Test {
    public static void main(String[] args) {
        IMyQueueImpl iMyQueue=new IMyQueueImpl();
        System.out.println(iMyQueue.empty());
        iMyQueue.add(1);
        iMyQueue.add(2);
        iMyQueue.add(3);
        iMyQueue.add(4);
        iMyQueue.add(5);
        iMyQueue.add(6);
        iMyQueue.display();
        System.out.println(iMyQueue.size());
        System.out.println(iMyQueue.peek()); //不出d队列
        iMyQueue.display();
        System.out.println(iMyQueue.poll());  //出
        System.out.println(iMyQueue.poll());  //出
        System.out.println(iMyQueue.poll());  //出

        iMyQueue.display();
    }
}
