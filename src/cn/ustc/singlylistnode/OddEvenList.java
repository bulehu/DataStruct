package cn.ustc.singlylistnode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class OddEvenList {
    /*
    * 题目：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
    * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
    * 应当保持奇数节点和偶数节点的相对顺序。
    * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
    * 方法1：1.节点为空，1，2不需要处理
    *       2.使用双指针odd和even分别构成奇偶链表
    *       3.将奇链表的尾部和偶链表的头部相连
    * */
    public SinglyListNode oddEvenList(SinglyListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        SinglyListNode odd = head;
        SinglyListNode even = head.next;
        SinglyListNode headEven = even;

        while (odd.next != null && odd.next.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = headEven;

        return head;
    }

}
