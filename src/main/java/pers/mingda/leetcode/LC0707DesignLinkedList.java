package pers.mingda.leetcode;

public class LC0707DesignLinkedList {}

class MyDoublyLinkedList {
    int size;
    LC0707Node head;
    LC0707Node tail;

    public MyDoublyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        LC0707Node LC0707Node = getLC0707Node(index);
        return LC0707Node == null ? -1 : LC0707Node.val;
    }

    public void addAtHead(int val) {
        LC0707Node oldHead = head;
        head = new LC0707Node(val);
        head.next = oldHead;
        if (oldHead != null) oldHead.prev = head;
        if (size == 0) tail = head;
        size++;
    }

    public void addAtTail(int val) {
        LC0707Node oldTail = tail;
        tail = new LC0707Node(val);
        tail.prev = oldTail;
        if (oldTail != null) oldTail.next = tail;
        if (size == 0) head = tail;
        size++;
    }

    private LC0707Node getLC0707Node(int index) {
        if (index < 0 || index >= size) return null;
        if (index < size / 2) return getFromHead(index);
        else return getFromTail(index);
    }

    private LC0707Node getFromHead(int index) {
        LC0707Node LC0707Node = this.head;
        while (index > 0) {
            LC0707Node = LC0707Node.next;
            index--;
        }
        return LC0707Node;
    }

    private LC0707Node getFromTail(int index) {
        LC0707Node LC0707Node = this.tail;
        int counterFromTail = size - index - 1;
        while (counterFromTail > 0) {
            LC0707Node = LC0707Node.prev;
            counterFromTail--;
        }
        return LC0707Node;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            LC0707Node prevLC0707Node = getLC0707Node(index - 1);
            if (prevLC0707Node != null) {
                LC0707Node nextLC0707Node = prevLC0707Node.next;
                LC0707Node LC0707Node = new LC0707Node(val, prevLC0707Node, nextLC0707Node);
                prevLC0707Node.next = LC0707Node;
                nextLC0707Node.prev = LC0707Node;
                size++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            LC0707Node oldHead = head;
            head = head.next;
            oldHead.next = null;
            if (head != null) head.prev = null;
            if (size == 1) tail = null;
        } else if (index == size - 1) {
            LC0707Node oldTail = tail;
            tail = tail.prev;
            oldTail.prev = null;
            if (tail != null) tail.next = null;
            if (size == 1) head = null;
        } else {
            LC0707Node prevLC0707Node = getLC0707Node(index - 1);
            if (prevLC0707Node == null || prevLC0707Node.next == null) return;
            LC0707Node deleteLC0707Node = prevLC0707Node.next;
            LC0707Node nextLC0707Node = deleteLC0707Node.next;

            prevLC0707Node.next = nextLC0707Node;
            deleteLC0707Node.prev = null;
            nextLC0707Node.prev = prevLC0707Node;
            deleteLC0707Node.next = null;
        }
        size--;
    }
}

class MySinglyLinkedList {

    int size;
    LC0707Node head;
    LC0707Node tail;

    public MySinglyLinkedList() {}

    public int get(int index) {
        if (!checkIndex(index)) return -1;
        return getLC0707Node(index).val;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    private LC0707Node getLC0707Node(int index) {
        LC0707Node LC0707Node = head;
        while (index > 0) {
            LC0707Node = LC0707Node.next;
            index--;
        }
        return LC0707Node;
    }

    public void addAtHead(int val) {
        head = new LC0707Node(val, head);
        size++;
        if (size == 1) tail = head;
    }

    public void addAtTail(int val) {
        LC0707Node oldTail = tail;
        tail = new LC0707Node(val);
        if (size == 0) head = tail;
        else oldTail.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (checkIndex(index)) {
            LC0707Node prev = getLC0707Node(index - 1);
            LC0707Node LC0707Node = new LC0707Node(val, prev.next);
            prev.next = LC0707Node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (!checkIndex(index)) return;
        if (index == 0) {
            LC0707Node oldHead = head;
            head = head.next;
            oldHead.next = null;
        } else {
            LC0707Node prev = getLC0707Node(index - 1);
            LC0707Node deleted = prev.next;
            prev.next = deleted.next;
            deleted.next = null;
            if (index == size - 1) tail = prev;
        }
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
    }
}

class LC0707Node {
    int val;
    LC0707Node next;
    LC0707Node prev;

    public LC0707Node(int val) {
        this.val = val;
    }

    // for singly list
    public LC0707Node(int val, LC0707Node next) {
        this(val, null, next);
    }

    public LC0707Node(int val, LC0707Node prev, LC0707Node next) {
        this(val);
        this.prev = prev;
        this.next = next;
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
