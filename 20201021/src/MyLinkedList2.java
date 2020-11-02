/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-10-27 16:25
 **/

class Node2 {
    public int data;
    //next是用来指向一个节点的 故应该用node类型
    //例如 Person person = new Person()
    //此时person是对象的引用
    public Node2 prev;
    public Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class MyLinkedList2 {
    public Node2 head;//保存单链表的头节点的引用  null
    public Node2 tail;//保存单链表的尾节点的引用  null
    public void addFirst(int data){
        Node2 node = new Node2(data);
        if (this.head == null && this.tail == null){
            this.head = node;
            this.tail = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }



    }
    public void addLast(int data) {
        Node2 node = new Node2(data);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    public boolean contains(int key){
        Node2 cur = this.head;
        while (cur != null){
            cur = cur.next;//别忘了 要不然会死循环
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }
    public int size(){
        Node2 cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;//别忘了 要不然会死循环
        }
        return count;
    }
    private void checkIndex(int index){
        if (index < 0 || index > size()){
            throw new RuntimeException("index 不合法");
        }
    }
    private Node2 searchIndex(int index){
        Node2 cur = this.head;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入节点，第一个数据节点为0号下标
    public void addIndex(int index, int data){
        checkIndex(index);

        if (index == 0){
            addFirst(data);
            return ;
        }
        if (index == size()){
            addLast(data);
            return ;
        }
        Node2 cur = searchIndex(index);
        Node2 node = new Node2(data);
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur.next;
        cur.prev = node;

    }
    public int remove(int key){
        Node2 cur = this.head;
        while (cur != null){
            if (cur.data == key){
                int oldData = cur.data;
                if (cur == this.head){
                    this.head = this.head.next;
                    if (this.head != null){
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        //删除的是尾巴节点 只需要移动tail
                        this.tail = cur.prev;
                    }

                }
                return oldData;
            }else {
                cur = cur.next;
            }
        }
        return -1;
    }
    public void removeAllKey(int key){
        Node2 cur = this.head;
        while (cur != null){
            if (cur.data == key){
                if (cur == this.head){
                    this.head = this.head.next;
                    if (this.head != null){
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        //删除的是尾巴节点 只需要移动tail
                        this.tail = cur.prev;
                    }
                }
            }
                cur = cur.next;
        }
    }

    public void display(){
        Node2 cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;//别忘了 要不然会死循环
        }
        System.out.println();
    }
    public void clear(){
        //        while (this.head != null){
//            Node2 cur = this.head;
//            this.head.prev = null;
//            this.head.next = null;
//            this.head = cur;
//        } this.head = null;

        this.tail = null;
    }
}
