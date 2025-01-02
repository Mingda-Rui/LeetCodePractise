package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Stack;
import java.util.stream.IntStream;

public class _8_6TowerOfHanoi {
    private static final int TOWER_SIZE = 3;

    public void playGame(int nDisks) {
        HanoiTowerGame game = new HanoiTowerGame();
        game.initiateNewGame(TOWER_SIZE, nDisks);
    }

}

class HanoiTowerGame {
    private HanoiTower[] columns;

    public void initiateNewGame(int totalTowers, int totalDisks) {
        this.columns = new HanoiTower[totalTowers];
        IntStream.range(0, totalTowers).forEach(i -> columns[i] = new HanoiTower(0));
        columns[0].setup(totalDisks);
    }

    public int getTowerSize() {
        return columns.length;
    }

    public HanoiTower getFirstTower() {
        return columns[0];
    }

    public HanoiTower getLastTower() {
        return columns[columns.length - 1];
    }
}

class HanoiTower {
    private final Stack<HanoiDisk> disks;

    public HanoiTower(int numOfDisks) {
        disks = new Stack<>();
        setup(numOfDisks);
    }

    public void setup(int totalDisks) {
        if (!disks.empty()) {
            disks.clear();
        }
        IntStream.rangeClosed(1, totalDisks).forEach(size -> disks.push(new HanoiDisk(size)));
    }

    public boolean placeDisk(HanoiDisk hanoiDisk) {
        HanoiDisk topDisk = disks.peek();
        if (topDisk.size() >= hanoiDisk.size()) {
            return false;
        }
        disks.push(hanoiDisk);
        return true;
    }

    public HanoiDisk removeDisk() {
        if (disks.empty()) {
            throw new IllegalStateException("The column is empty");
        }
        return disks.pop();
    }
}

record HanoiDisk(int size) {
}


