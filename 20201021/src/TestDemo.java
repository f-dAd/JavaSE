import java.util.Arrays;


public class TestDemo {
    public static void craetCut(Node headA, Node headB){
        headA.next = headB.next.next;
    }
    public static Node mergeTwoLists(Node headA, Node headB){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null){
            if (headA.data < headB.data){
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if (headA != null){
            tmp.next = headA;
        }
        if (headB != null){
            tmp.next = headB;
        }
        return newHead.next;
    }
    public static Node getIntersectionNode(Node headA, Node headB){
        //1、求长度走差值步
        Node pl = headA;
        Node ps = headB;
        int lenA = 0;
        int lenB = 0;
        int len = 0;
        while (pl != null){
           pl = pl.next;
           lenA++;
        }
        while (ps != null){
            ps = ps.next;
            lenB++;
        }
        pl = headA;
        ps = headB;
        len = lenA - lenB;
        if (len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        //一定是pl指向的最长的单链表
        for (int i = 0; i < len; i++){
            pl = pl.next;
        }
        //ps 和 pl 一定是在同一个起跑线上
        //别忘了不相交情况
        while (ps != pl && pl != null && ps != null){
            pl = pl.next;
            ps = ps.next;
        }
        if (ps != pl && pl != null ){
            return pl;
        }
        while (ps != pl ){
            pl = pl.next;
            ps = ps.next;
        }
        if (pl != null ){
            return pl;
        }
        return null;

    }
    public static void main(String[] args) {
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addFirst(1);
        myLinkedList2.addFirst(1);
        myLinkedList2.addFirst(2);
        myLinkedList2.addFirst(1);

        myLinkedList2.display();
        myLinkedList2.clear();
        System.out.println("111111111111111");
    }
}


