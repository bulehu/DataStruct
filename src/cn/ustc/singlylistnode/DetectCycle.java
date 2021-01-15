package cn.ustc.singlylistnode;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class DetectCycle {
    /*
    * 判断单链表是否有环，若有环则返回环入口的节点，否则返回null
    * 思路：使用双指针
    * */
    public SinglyListNode detectCycle(SinglyListNode head) {
        if (head == null) return null; // 判断是否有节点
        SinglyListNode fastNode = head; // 快指针，每次走两步
        SinglyListNode slowNode = head; // 慢指针，每次走一步
        // 判断链表是否有环，fastNode != null 判断条件必要，否则会出现null.null的空指针情况
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            // 判断第一次相遇位置
            if (slowNode == fastNode) {
                // 第一次相遇后，让慢指针slowNode继续在环上运动，此时使用头节点走到与慢指针相遇的位置即为入口位置
                while (head != slowNode) {
                    head = head.next;
                    slowNode = slowNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}
