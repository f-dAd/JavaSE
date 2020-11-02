import java.util.Arrays;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-10-25 11:56
 **/
public class MyArrayList {
    public int[] elem;//数组
    public int usedSize;//有效数据的个数
    public static final int intCapacity = 10;//初始容量
    public MyArrayList() {
        this.elem = new int[intCapacity];
        this.usedSize = 0;
    }
    //删除第一次出现的关键字
    public void remove(int toRemove){
        int index = search(toRemove);
        if (index == -1){
            System.out.println("没有需要删除的数字！");
            return;
        }
        for (int i = index;i < this.usedSize; i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;//别忘了

    }
    public void display() {
        for (int i = 0;i < this.usedSize; i++){
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();

    }
    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0;i < this.usedSize; i++){
           if (this.elem[i] == toFind){
               return true;
           }
        }
        return false;

    }
    private  boolean isEmpty(){
        return this.usedSize == 0;
    }

    //获取pos位置的元素
    public int getPos(int pos){
        //1、顺序表是否为空 -1
        if (isEmpty()){
            throw new RuntimeException("顺序表为空！");//手动抛出异常
        }
        //2、pos 合法性
        if (pos < 0 || pos >= this.usedSize){
            throw new RuntimeException("pos位置不合法");
        }
        return this.elem[pos];

        //return pos位置的数据就可以了
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //查找某个元素的下标
    public int search(int toFind){
        for (int i = 0;i < this.usedSize; i++){
            if (this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    private boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    //在pos位置增加新元素
    public void add(int pos, int data){
        int i = this.usedSize - 1;
        //判断位置是否合理应该放在前面
        //如果判断数组空间是否已满放在前面，就会出现位置不合理没有插入数据
        //但数组空间还是进行扩充的现象

        //插入数据时一定要保证它有唯一的前驱
        // 大于usedSize 说明前面有空数据 不可以
        if (pos < 0 || pos > this.usedSize){
            throw new RuntimeException("pos位置不合法");
        }


        if (isFull()){
            //每当数组满的时候 ，将其扩充为原来的二倍
            //扩容相当于申请新的数组空间，原来的数组空间被回收
            this.elem = Arrays.copyOf(this.elem, 2*intCapacity);
        }

        while (i >= pos){
            this.elem[i+1] = this.elem[i];
            i--;
        }
        this.elem[pos] = data;
        this.usedSize++;//别忘了
    }
    //清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
    //更新pos位置的元素
    public void srtPos(int pos, int value){
        if (pos < 0 || pos >= this.usedSize){
            throw new RuntimeException("pos 位置不合法");
        }
        this.elem[pos] = value;
    }


    public static void main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        for (int i = 0;i < 10; i++){
            myArrayList1.add(i, i);
        }
        myArrayList1.display();
        myArrayList1.add(10,112);
        myArrayList1.display();
        System.out.println("--------------------------------");
        myArrayList1.remove(5);
        myArrayList1.clear();
        myArrayList1.display();
    }
}
