package pers.mingda.leetcode;

public class LC0707DesignLinkedList {

}

class MyLinkedList {
    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        Node oldHead = head;
        head = new Node(val);
        head.next = oldHead;
        if (oldHead != null)
            oldHead.prev = head;
        if (size == 0)
            tail = head;
        size++;
    }

    public void addAtTail(int val) {
        Node oldTail = tail;
        tail = new Node(val);
        tail.prev = oldTail;
        if (oldTail != null)
            oldTail.next = tail;
        if (size == 0)
            head = tail;
        size++;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        if (index < size / 2)
            return getFromHead(index);
        else
            return getFromTail(index);
    }

    private Node getFromHead(int index) {
        Node node = this.head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    private Node getFromTail(int index) {
        Node node = this.tail;
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
            Node prevNode = getNode(index - 1);
            if (prevNode != null) {
                Node nextNode = prevNode.next;
                Node node = new Node(val, prevNode, nextNode);
                prevNode.next = node;
                nextNode.prev = node;
                size++;
            }
        }

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            Node oldHead = head;
            head = head.next;
            oldHead.next = null;
            if (head != null)
                head.prev = null;
            if (size == 1)
                tail = null;
        } else if (index == size - 1) {
            Node oldTail = tail;
            tail = tail.prev;
            oldTail.prev = null;
            if (tail != null)
                tail.next = null;
            if (size == 1)
                head = null;
        } else {
            Node prevNode = getNode(index - 1);
            if (prevNode == null || prevNode.next == null)
                return;
            Node deleteNode = prevNode.next;
            Node nextNode = deleteNode.next;

            prevNode.next = nextNode;
            deleteNode.prev = null;
            nextNode.prev = prevNode;
            deleteNode.next = null;
        }
        size--;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next) {
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