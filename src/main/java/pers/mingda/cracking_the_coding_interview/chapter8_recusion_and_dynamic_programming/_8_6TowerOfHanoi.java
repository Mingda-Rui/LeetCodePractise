package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _8_6TowerOfHanoi {
    private static final int TOWER_SIZE = 3;

    public void playGame(int nDisks) {
        HanoiTowerGame game = new HanoiTowerGame();
        game.initiateNewGame(TOWER_SIZE, nDisks);
        solveGame(game, 0, 2, nDisks);
    }

    public void solveGame(HanoiTowerGame game, int fromTower, int toTower, int numOfDisks) {
        if (numOfDisks == 1) {
            game.moveDisk(fromTower, toTower);
        }
        int spareTower = getSpareTower(fromTower, toTower);
        solveGame(game, fromTower, spareTower, numOfDisks - 1);
        game.moveDisk(fromTower, toTower);
        solveGame(game, spareTower, toTower, numOfDisks - 1);
    }

    private int getSpareTower(int fromTower, int toTower) {
        Set<Integer> set = IntStream.range(0, TOWER_SIZE).boxed().collect(Collectors.toSet());
        set.removeAll(Set.of(fromTower, toTower));
        return set.iterator().next();
    }
}

class HanoiTowerGame {
    private HanoiTower[] columns;

    public void initiateNewGame(int totalTowers, int totalDisks) {
        this.columns = new HanoiTower[totalTowers];
        IntStream.range(0, totalTowers).forEach(i -> columns[i] = new HanoiTower(0));
        columns[0].setup(totalDisks);
    }

    public void moveDisk(int from, int to) {
        HanoiDisk disk = columns[from].removeDisk();
        columns[to].placeDisk(disk);
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

    public void placeDisk(HanoiDisk hanoiDisk) {
        HanoiDisk topDisk = disks.peek();
        if (topDisk.size() >= hanoiDisk.size()) {
            throw new IndexOutOfBoundsException("Can not place the disk with size %d onto a smaller disk size %d".formatted(hanoiDisk.size(), topDisk.size()));
        }
        disks.push(hanoiDisk);
    }

    public HanoiDisk removeDisk() {
        if (disks.empty()) {
            throw new IllegalStateException("The column is empty");
        }
        return disks.pop();
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }
}

record HanoiDisk(int size) {
}


