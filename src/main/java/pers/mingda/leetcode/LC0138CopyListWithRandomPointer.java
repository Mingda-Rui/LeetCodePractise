package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0138CopyListWithRandomPointer {
    public LC0138Node copyRandomList(LC0138Node head) {
        Map<LC0138Node, LC0138Node> map = new HashMap<>();
        LC0138Node dummyHead = new LC0138Node(-1);
        LC0138Node copy = copyByNext(head, dummyHead, map);

        while (head != null) {
            LC0138Node random = head.random;
            if (random != null) {
                copy.random = map.get(random);
            }
            head = head.next;
            copy = copy.next;
        }
        copy = dummyHead.next;
        dummyHead.next = null;
        return copy;

    }

    private LC0138Node copyByNext(LC0138Node origin, LC0138Node copy, Map<LC0138Node, LC0138Node> map) {
        if (origin == null)
            return origin;
        LC0138Node next = new LC0138Node(origin.val);
        map.put(origin, next);
        copy.next = next;
        copyByNext(origin.next, next, map);
        return next;
    }

    public LC0138Node copyRandomListZeroSpaceComplexity(LC0138Node head) {
        LC0138Node oriIte = head;
        while (oriIte != null) {
            LC0138Node LC0138Node = new LC0138Node(oriIte.val);
            LC0138Node.next = oriIte.next;
            oriIte.next = LC0138Node;
            oriIte = LC0138Node.next;
        }

        oriIte = head;
        while (oriIte != null) {
            LC0138Node oriRandom = oriIte.random;
            LC0138Node copy = oriIte.next;
            copy.random = oriRandom == null ? null : oriRandom.next;
            oriIte = copy.next;
        }

        LC0138Node dummyOri = new LC0138Node(-1);
        LC0138Node dummyCopy = new LC0138Node(-1);
        LC0138Node copydummyHead = dummyCopy;

        oriIte = head;
        while (oriIte != null) {
            dummyOri.next = oriIte;
            oriIte = oriIte.next;
            dummyCopy.next = oriIte;
            oriIte = oriIte.next;
            dummyOri = dummyOri.next;
            dummyCopy = dummyCopy.next;
        }
        dummyOri.next = null;

        return copydummyHead.next;
    }
}

class LC0138Node {
    int val;
    LC0138Node next;
    LC0138Node random;

    public LC0138Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
