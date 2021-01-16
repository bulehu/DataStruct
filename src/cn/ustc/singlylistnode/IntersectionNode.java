package cn.ustc.singlylistnode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionNode {
    /*
    * 判断单链表是否相交，若相交则返回相交的入口节点，否则返回null
    * 方法：如果有两个长短链表，让长链表先走到跟短链表长度统一，然后一起走到相等的节点，即为相交的节点处
    * 误区：节点相等是地址相等，而非值相等。注意值相等和引用相等的区别
    * */
    public SinglyListNode getIntersectionNode(SinglyListNode headA, SinglyListNode headB) {
        int lengthA = getLength(headA); // 获取链表长度
        int lengthB = getLength(headB);
        // 链表长度统一
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA --;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB --;
        }
        // 判断节点引用值相等处，若无相等节点则最终遍历到null值
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    // 获取链表长度的方法
    public int getLength(SinglyListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length ++;
            listNode = listNode.next;
        }
        return length;
    }
}
