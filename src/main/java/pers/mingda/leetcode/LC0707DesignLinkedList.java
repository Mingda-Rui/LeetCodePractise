package pers.mingda.leetcode;

public class LC0707DesignLinkedList {

}

class MyLinkedList {

    int val;
    int size;
    MyLinkedList next;
    MyLinkedList prev;
    MyLinkedList head;
    MyLinkedList tail;

    public MyLinkedList() {
        size = 0;
    }

    private MyLinkedList(int val) {
        this();
        this.val = val;
    }

    private MyLinkedList(int val, MyLinkedList prev, MyLinkedList next) {
        this();
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public int get(int index) {
        MyLinkedList node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        MyLinkedList newHead = new MyLinkedList(val);
        if (head != null) {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        if (size == 0)
            tail = head;
        size++;
    }

    public void addAtTail(int val) {
        MyLinkedList newTail = new MyLinkedList(val);
        if(tail != null) {
            newTail.prev = tail;
            tail.next = newTail;
        }
        tail = newTail;
        if (size == 0)
            head = tail;
        size++;
    }

    private MyLinkedList getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        if (index < size / 2)
            return getFromHead(index);
        else
            return getFromTail(index);
    }

    private MyLinkedList getFromHead(int index) {
        MyLinkedList node = this.head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    private MyLinkedList getFromTail(int index) {
        MyLinkedList node = this.tail;
        int counterFromTail = size - index - 1;
        while (counterFromTail > 0) {
            node = node.prev;
            counterFromTail--;
        }
        return node;

    }

    public void addAtIndex(int index, int val) {
        if (index == 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else {
            MyLinkedList prevNode = getNode(index - 1);
            if (prevNode != null) {
                MyLinkedList nextNode = prevNode.next;
                MyLinkedList node = new MyLinkedList(val, prevNode, nextNode);
                prevNode.next = node;
                nextNode.prev = node;
                size++;
            }
        }

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            MyLinkedList oldHead = head;
            head = head.next;
            oldHead.next = null;
            if (head != null)
                head.prev = null;
            if (size == 1)
                tail = null;
        } else if (index == size - 1) {
            MyLinkedList oldTail = tail;
            tail = tail.prev;
            oldTail.prev = null;
            if (tail != null)
                tail.next = null;
            if (size == 1)
                head = null;
        } else {
            MyLinkedList prevNode = getNode(index - 1);
            if (prevNode == null || prevNode.next == null)
                return;
            MyLinkedList deleteNode = prevNode.next;
            MyLinkedList nextNode = deleteNode.next;

            prevNode.next = nextNode;
            deleteNode.prev = null;
            nextNode.prev = prevNode;
            deleteNode.next = null;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */