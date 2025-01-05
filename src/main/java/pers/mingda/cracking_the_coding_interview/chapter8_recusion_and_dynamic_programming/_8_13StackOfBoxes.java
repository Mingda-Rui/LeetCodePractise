package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.*;

public class _8_13StackOfBoxes {
    public int stackBoxes(int numOfBoxes) {
        List<Box> boxes = new ArrayList<>(numOfBoxes);
        boxes.add(new Box());

        boxes.sort(Comparator.comparing(Box::getHeight).reversed());
        Map<Box, Integer> heightMap = new HashMap<>();
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = stackBoxes(boxes.subList(i, boxes.size()), heightMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int stackBoxes(List<Box> remainingBoxes, Map<Box, Integer> heightMap) {
        if (remainingBoxes.isEmpty()){
            return 0;
        }


        Box currentBox = remainingBoxes.getFirst();
        if (heightMap.containsKey(currentBox)) {
            return heightMap.get(currentBox);
        }
        int maxHeight = 0;
        for (int i = 1; i < remainingBoxes.size(); i++){
            Box nextBox = remainingBoxes.get(i);
            if (!nextBox.canStackOn(currentBox))
                continue;
            int height = currentBox.getHeight() + stackBoxes(remainingBoxes.subList(i, remainingBoxes.size()), heightMap);
            maxHeight = Math.max(maxHeight, height);
        }
        heightMap.put(currentBox, maxHeight);
        return maxHeight;
    }
}

class Box {
    int width;
    int depth;
    int height;

    public int getHeight() {
        return height;
    }

    public boolean canStackOn(Box buttomBox) {
        return buttomBox.height > height && buttomBox.width > width && buttomBox.depth > depth;
    }
}
