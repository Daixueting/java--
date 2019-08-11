
import java.util.Arrays;

/**
 * @PACKAGE_NAME: PACKAGE_NAME
 * @NAME: SequenceImpl
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/6
 **/

//顺序表特别麻烦的就是 插入和删除一定要移位

public class SequenceImpl implements  ISequence{
    //顺序表就是有一个数组和一个标志数字组成
    private  Object[] elemData;
    private  int usedSize;
    private static final int DEFAULT_CAPACITY=10;

    public SequenceImpl() {
        this.elemData = new Object[DEFAULT_CAPACITY];
        this.usedSize = usedSize;
    }


    @Override
    public boolean add(int pos, Object data) {
        //再就是要检查插入位置是否合法（插入位置不越界）,保证插入位置要有唯一的前驱和不能小于0
        //因为插入数据是Object类型，所以也要判断插入数据是否合理
        //首先要检查要插入的位置是否被占,然后挪动数据
        //放入数据，且usedSize++
        if(pos<0||pos>this.usedSize){
            System.out.println("插入位置不合理");
            return false;
        }
        if(data==null){
            throw new UnsupportedOperationException("要插入的数据不能为null");
        }
        if(this.usedSize==this.elemData.length){
           //进行扩容
            this.elemData=Arrays.copyOf(this.elemData,this.elemData.length*2);
        }
        //这个是要进行移位
        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elemData[i+1]=this.elemData[i];
        }
        this.elemData[pos]=data;
        this.usedSize++;
        return true;
    }

    @Override
    public int search(Object key) {
        //这个是返回查找到的第一个关键词的位置
        //首先要判断的是顺序表和key是否为空
        //定义一个变量i来记录关键字的位置并返回，若是没有找到则返回-1
        if(key==null){
            throw new UnsupportedOperationException("传入参数不能为null");
        }
        if(this.usedSize==0){
            return -1;
        }
        int i=0;
        for (;i<this.usedSize;i++){
            if(this.elemData[i].equals(key)){   //注意要用equals（）来比较
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean contains(Object key) {
        if(-1!=search(key)) {
            return true;
        }
        return false;
    }



    @Override
    public Object getPos(int pos) {  //得到pos位置的值
        //首先要判断pos的合法性（大于0或者小于usedSize）
        //在判断顺序表是否为空
        //然后在直接返回pos位置的值
        if(pos<0||pos>this.usedSize){
            return "查找位置不合理";
        }
        if(this.usedSize==0){
            return "数组为空";
        }

        return this.elemData[pos];
    }


    @Override
    public Object remove(Object key) {  //删除顺序表中key，只删除第一次出现的key
        //首先要检查key的合法性，和顺序表不能为空
        //先判断顺序表中是否包含key，调用seach（），返回-1不包含
        //若是包含 在调用seach（）函数，来找到key的位置
        //然后利用for循环来进行移位【往前移位】,记得要将最后一个空位进行赋值null的操作
        //最后usedSize--;
        if(key==null){
            throw new UnsupportedOperationException("要删除的数据不能为空");
        }
        if(this.usedSize==0){
            return null;
        }
        int sort=search(key);
        if (sort==-1){
            return null;
        }
        //移位
        for (int i = sort; i <this.usedSize-1 ; i++) {  //因为要往前移动一位，所以最后一个数字不用移动
              this.elemData[i]=this.elemData[i+1];
        }
        //移动完成之后一定要记得给最后一个位置赋值为null
        this.elemData[usedSize-1]=null;
        this.usedSize--;
        return true;


//        if(key==null){
//            throw new UnsupportedOperationException("不能将null作为删除的参数");
//        }
//        int i=search(key);
//        if(i==-1){
//            return null;
//        }
//        Object oldData=this.elemData[i];
//        //利用for循环进行删除操作
//        for (; i <this.usedSize-1 ; i++) {
//           this.elemData[i]=this.elemData[i+1]; //这个循环赋值完之后  最后一个位置没有被赋值，所以一定要进行赋空值操作
//        }
//        this.elemData[i+1]=null;
//        this.usedSize--;
//        return oldData;
    }

    @Override
    public Object removeAll(Object key) {
        //先判断这个顺序表中是否包含了key
        //先检测key的合法性
        //在找出key的所有下标，进行删除
        //记得没删除一次，usedSize都要进行一次减减,且最后一位要进行赋空值操作
        if(key==null){
            throw new UnsupportedOperationException("不能将null作为删除的参数");
        }


        return true;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elemData[i]+"\t");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elemData[i]=null;

        }
        this.usedSize =0;
    }


}
