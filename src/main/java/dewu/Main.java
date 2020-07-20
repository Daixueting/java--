package dewu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //加载Spring的配置文件，初始化上下文，生成Bean对象。。
       ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");

       //这里新增
        //通过名字获取Bean对象
//        Object o=context.getBean("myName");
//        System.out.println(o.getClass());
//        System.out.println(o);  //打印小比特
//
//        Object duck=context.getBean("丑小鸭");
//        System.out.println(duck.getClass());
//        System.out.println(duck);
//
//        Object duckShop=context.getBean("烤鸭店");
//        System.out.println(duckShop.getClass());
//        System.out.println(duckShop);
}
}
