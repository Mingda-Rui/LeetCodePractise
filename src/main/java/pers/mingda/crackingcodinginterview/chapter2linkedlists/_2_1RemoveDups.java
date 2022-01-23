package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary bugger is not allowed?
 */

public class _2_1RemoveDups {
    public static void deleteDups(LinkedListNode n) {
        Set<Integer> set = new HashSet<>();
        set.add(n.data);
        while (n.next != null) {
            if (set.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                set.add(n.next.data);
                n = n.next;
            }
        }
    }

    public static void deleteDupsNoBuffer(LinkedListNode n) {
        while (n != null) {
            LinkedListNode previousRunner = n;
            LinkedListNode runner = n.next;            
            while (runner != null) {
                if (runner.data == n.data) {
                    previousRunner.next = runner.next;
                    runner = previousRunner.next;
                } else {
                    previousRunner = runner;
                    runner = runner.next;
                }
            }
            n = n.next;
        }
    }
}
