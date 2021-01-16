package cn.ustc.singlylistnode;

public class RemoveNthFromEnd {
    /*
    * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    * */
    public SinglyListNode removeNthFromEnd(SinglyListNode head, int n) {
        int devLength = getLength(head) - n;
        if (devLength == 0) {
            head = head.next;
            return head;
        }
        SinglyListNode p = head;
        while (--devLength > 0) {
            p = p.next;
        }

        p.next = p.next.next;
        return head;
    }
    public int getLength(SinglyListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length ++;
            listNode = listNode.next;
        }
        return length;
    }
}
