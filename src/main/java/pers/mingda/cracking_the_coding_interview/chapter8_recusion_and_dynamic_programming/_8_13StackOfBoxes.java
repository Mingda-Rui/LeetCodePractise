package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Iterator;
import java.util.Set;

public class _8_13StackOfBoxes {
    private int stackBoxes(Box currentBox, Set<Box> remainingBoxes) {
        if (remainingBoxes.isEmpty()) {
            return currentBox.height;
        }
        Iterator<Box> iterator = remainingBoxes.iterator();
        int maxHeight = 0;
        while(iterator.hasNext()) {
            Box nextBox = iterator.next();
            if (!nextBox.canStackOn(currentBox)) {
                break;
            }
            remainingBoxes.remove(nextBox);
            int height = stackBoxes(nextBox, remainingBoxes);
            maxHeight = Math.max(maxHeight, height);
            remainingBoxes.add(nextBox);
        }
        return currentBox.height + maxHeight;
    }
}

class Box {
    int width;
    int depth;
    int height;

    public boolean canStackOn(Box buttomBox) {
        return buttomBox.height > height && buttomBox.width > width && buttomBox.depth > depth;
    }
}
