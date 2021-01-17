package cn.ustc.singlylistnode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {
   /*
   * 题目：反转单链表
   * 方法1：一种解决方案是按原始顺序迭代结点，并将它们逐个移动到列表的头部
   * */
    public SinglyListNode reverseList(SinglyListNode head) {
        // 1.判断是否为空节点或单节点情形，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }
        // 2.不满足情形1的话，则：
        SinglyListNode constHead = head; // 声明每次移动节点后产生的新链表的头节点
        SinglyListNode p; // 用于置换节点
        //   移动节点，但是仅存最后一个节点时需要单独移动，head为最初链表的头节点，值随着移动并不发生改变
        while (head.next.next != null) {
            p = head.next; // 记录head的下一个节点
            head.next = head.next.next; // 改变指针
            p.next = constHead; // 指向头节点
            constHead = p; // 更新头节点
        }
        // 3.对链表的最后一个节点进行移动
        head.next.next = constHead;
        p = head.next;
        head.next = null;
        constHead = p;

        return constHead;
    }
}
