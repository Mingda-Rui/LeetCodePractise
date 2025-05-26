package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

public class LinkedListNode {

  protected LinkedListNode next;
  protected int data;

  public LinkedListNode(LinkedListNode next, int data) {
    this.next = next;
    this.data = data;
  }
}
