package cn.ustc.singlylistnode;

public class HasCycle {
    /*
    * 判断链表中是否有环，此环为链尾链接到其他节点
    * 方法：获取链表长度进行遍历，直到找不到链尾指向null的节点
    * @head：头节点
    * */
    public boolean hasCycle(SinglyListNode head) {
        int count = 10000;
        while (head != null && count >= 0) {
            head = head.next;
            count --;
        }
        if (count >= 0) {
            return true;
        }else {
            return false;
        }
    }
}
