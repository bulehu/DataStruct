package cn.ustc.singlylistnode;
/*执行用时：
        12 ms
        , 在所有 Java 提交中击败了
        66.93%
        的用户
        内存消耗：
        39.5 MB
        , 在所有 Java 提交中击败了
        5.06%
        的用户
       */

class MyLinkedList {

    int size; // 0 -- n

    //SinglyListNode head = new SinglyListNode(); // 此种写法错误，链表遍历时最后会输出0
    SinglyListNode head = null;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /*public int length() {
        int length = 0;
        SinglyListNode p = head;
        while (p != null) {
            length ++;
            p = p.next;
        }
        return length;
    }*/

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        SinglyListNode p;
        p = head;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SinglyListNode listNode = new SinglyListNode(val); // 创建加入的节结点

        if (head != null) {
            listNode.next = head;// 新节点的指针域指向当前链表的头节点
        }
        head = listNode; // 将插入的节点作为新的头节点
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        SinglyListNode listNode = new SinglyListNode(val);

        if(head == null) {
            head = listNode;
            size ++;
//            listNode.next = null; // 冗余
        return;
        }
        SinglyListNode p = head;
            /*while (p != null) {
                if (p.next == null) {
                    p.next = listNode;
                    listNode.next = null;
                    p = null; //循环终止条件
                }else {
                    p = p.next;
                }
            }*/
        while (p.next != null) {
            p = p.next;  // 遍历到尾节点位置
        }
        p.next =listNode;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index > size - 1) {
            return;
        }

        SinglyListNode listNode = new SinglyListNode(val);
        SinglyListNode p = head;

        // 遍历到节点要插入位置的前一个位置
        while (index - 1 > 0) {
            p = p.next;
            index --;
        }

        listNode.next = p.next;
        p.next = listNode;
        size ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size --;
            return;
        }

        SinglyListNode p = head;
        SinglyListNode tempNode;

        while (index - 1 > 0) {
            p = p.next;
            index --;
        }

        tempNode = p.next.next;
        p.next = tempNode;
        size --;
    }
}
