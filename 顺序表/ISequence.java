/**
 * @PACKAGE_NAME: PACKAGE_NAME
 * @NAME: ISequence
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/6
 **/
public interface ISequence {
    //在pos位置插入val
    boolean add(int pos,Object data);
    //查找关键字key 找到返回key的下标，没有返回null;
    int search(Object key);
    // 查找是否包含关键字key是否在顺序表当中(这个和search有点冲突)
     boolean contains(Object key);
    // 得到pos位置的值
    Object getPos(int pos);
    // 删除第一次出现的关键字key
    Object remove(Object key);
    //删除所有关键字key
    Object removeAll(Object key);
    //得到顺序表的长度
    int size();
    // 打印顺序表
    void display();
    // 清空顺序表以防内存泄漏
     void clear();
}
