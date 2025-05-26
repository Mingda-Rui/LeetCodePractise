package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC0841KeysAndRooms {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visitedRoom = new HashSet<>();

    visitedRoom.add(0);
    List<Integer> keys = new ArrayList<>(rooms.getFirst());

    visitRoom(rooms, visitedRoom, keys);
    return visitedRoom.size() == rooms.size();
  }

  private void visitRoom(
    List<List<Integer>> rooms,
    Set<Integer> visitedRooms,
    List<Integer> keys
  ) {
    if (keys.isEmpty()) {
      return;
    }

    int nextRoom = keys.getFirst();
    keys.removeFirst();

    visitedRooms.add(nextRoom);
    for (int key : rooms.get(nextRoom)) {
      if (!visitedRooms.contains(key)) {
        keys.add(key);
      }
    }
    visitRoom(rooms, visitedRooms, keys);
  }

  public boolean canVisitAllRoomsIterative(List<List<Integer>> rooms) {
    Set<Integer> visitedRooms = new HashSet<>();
    Queue<Integer> keys = new LinkedList<>();

    visitedRooms.add(0);
    keys.addAll(rooms.getFirst());

    while (!keys.isEmpty()) {
      int nextRoom = keys.poll();
      visitedRooms.add(nextRoom);
      for (int key : rooms.get(nextRoom)) {
        if (!visitedRooms.contains(key)) {
          keys.add(key);
        }
      }
    }
    return visitedRooms.size() == rooms.size();
  }
}
