import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-10-25 16:01
 **/
class Node {
    public int data;
    //next是用来指向一个节点的 故应该用node类型
    //例如 Person person = new Person()
    //此时person是对象的引用
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class MyLinkedList {
    public Node head;//保存单链表的头节点的引用  null

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head == null){
            this.head = node;
            return;
        }
        //找的是最后一个节点
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    private Node searchIndex(int index){
        //对index进行合法检查
        if (index < 0 || index > this.size()){
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++){
            cur = cur.next;
        }
        return cur;

    }
    //在任意位置插入一个元素
    public void addIndex(int index, int data){

        if (index == 0){
           this.addFirst(data);
           return;
        }
        if (index == this.size()){
            this.addLast(data);
            return;
        }
        Node node = new Node(data);

        Node cur = this.searchIndex(index);
        //定义一个cur，走index - 1步，
        //如果index == 0 相当于头插法
        //如果index == size 相当于尾插法
        //其他，找到要插入位置的前一个，进行插入】+
        node.next = cur.next;
        cur.next = node;

    }
    private Node searchPrev(int key){
        Node prev = this.head;
        while (prev.next !=null){
            if (prev.next.data == key){
                return prev;
            }else {
                prev = prev.next;
            }
        }
        return null;

    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null){
            System.out.println("根本没有这个节点");
            return;
        }
        prev.next = prev.next.next;
    }
    //删除关键字为key的所有节点
    public void removeAllKey(int key){
        if (this.head == null){
            return;
        }
        Node prev = this.head;
        Node cur = prev.next;
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
           //删完之后prev不动 cur先走一步
           //防止cur.next仍是目标节点的情况
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key){
            this.head = this.head.next;
        }
    }
    public void clear(){
        this.head = null;
    }
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
//        while (fast.next != null && fast != null){  错误写法 当fast为空时 fast.next越界
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node findKthToAll(int k){
        if (k < 0){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k - 1 > 0){
            if (fast.next != null){
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }

        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null){
            if (cur.data < x){
                //第一次插入
                if (bs == null){
                    bs = cur;
                    be = cur;

                }
                else {
                    be.next = cur;
                    be = be.next;
                }

            }else {
                if (as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }

            }
            cur = cur.next;
        }
        if (as != null){
            ae.next = null;
        }
        if (bs == null){
            return as;
        }
        be.next = as;
        //1、判断bs是否为空 如果bs == null 返回 as
        //2、如果bs不为空 需要进行拼接
        //3、如果ae不为空 ae的next需要置为空

        return bs;

    }
    public Node deleteDuplication(){
        Node cur = this.head;
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (cur != null){
            if (cur.next != null && cur.data == cur.next.data){
                while (cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;//多走一步
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
    public boolean chkPalindorme(){
        //单链表为空 肯定不是回文
        if (this.head == null){
            return false;
        }
        //只有头结点自己，必然是回文结构
        if (this.head.next == null){
            return true;
        }
        //1、找到单链表的中间节点
        Node fast = this.head;
        Node slow = this.head;
        if (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、开始翻转单链表的后半部分  slow肯定在中间位置
        Node cur = slow.next;
        //Node curNext = cur.next;这样写错误,cur这里有可能为空
        while (cur != null){
            Node curNext = cur.next;
            cur.next = slow;
            cur = curNext;
        }
        //slow 是最后一个节点了
        //开始一个从头走  一个从尾巴走
        while (slow != this.head){
            if (slow.data == this.head.data){
                return false;
            }
            if (this.head.next == slow){
                return true;//判断为偶数的情况
            }
            slow = slow.next;
            this.head = this.head.next;
        }

        return true;
    }
    public boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast == null && fast.next == null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast != slow){
                return true;
            }

        }
        return false;
    }
    public Node detectCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast == null && fast.next == null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }

        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while (fast != slow){
            fast =fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node reverseList(){
        Node newHead = null;
        Node cur = this.head;
        Node prev = null;
        while (cur != null){
            Node curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void display2(Node newHead){
        Node cur = newHead;//翻转后头结点改变了
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();

    }

    //打印单链表
     public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
         System.out.println();

     }
     //查找是否包含关键字key是否在单链表中
     public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
     }
     //得到单链表的长度
     public int size(){
        int size = 0;
         Node cur = this.head;
         while (cur != null){
             size++;
             cur = cur.next;
         }
         return size;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(10);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(11);
        myLinkedList.addLast(10);
        myLinkedList.display();
        System.out.println(myLinkedList.hasCycle());
        myLinkedList.clear();


    }


}
