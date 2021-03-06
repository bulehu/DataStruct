package cn.ustc.singlylistnode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveElements {
    /*
    * 题目：删除链表中等于给定值 val 的所有节点
    * 方法1：使用双指针cur和pre，最初cur和pre的位置都在head处，之后cur的位置总是比pre的步数少1；
    *       cur用于记录要删除pre节点的前一个位置信息；
    * 方法1细节：头节点head的更新，如果删除的是头节点，让头节点后移就行
    * */
    public SinglyListNode removeElements(SinglyListNode head, int val) {
        SinglyListNode cur = head; // cur与pre在head同一起点处
        SinglyListNode pre = head;
        // pre到达null处删除过程介绍
        while (pre != null) {
            // 更新头节点
            if (head.val == val) {
                head = head.next;
            }
            // 更新双指针和链表
            if (pre.val != val) {
                cur = pre;
            }else {
                cur.next = pre.next;
            }
            pre = pre.next;
        }
        return head;
    }

    /*
    * 方法二：等同于双指针，但更加简洁
    * */
    public SinglyListNode removeElements2(SinglyListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return head;
        SinglyListNode prev = head;
        //确保当前结点后还有结点
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
