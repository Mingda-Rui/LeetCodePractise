package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2402MeetingRoomsIII {}

class LC2402Solution {
  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparingInt(i -> i[0]));

    Comparator<LC2402RoomAvailability> usedRoomComparator =
        (a1, a2) ->
            Math.toIntExact(
                a1.availability() == a2.availability()
                    ? a1.room() - a2.room()
                    : a1.availability() - a2.availability());
    Queue<LC2402RoomAvailability> usedRooms = new PriorityQueue<>(usedRoomComparator);
    Queue<Integer> unusedRooms = new PriorityQueue<>();
    int[] meetingCounts = new int[n];

    for (int i = 0; i < n; i++) {
      unusedRooms.add(i);
    }

    for (int[] meeting : meetings) {
      while (!usedRooms.isEmpty() && usedRooms.peek().availability() <= meeting[0]) {
        LC2402RoomAvailability ra = usedRooms.remove();
        unusedRooms.add(ra.room());
      }

      if (!unusedRooms.isEmpty()) {
        int room = unusedRooms.remove();
        meetingCounts[room]++;
        usedRooms.add(new LC2402RoomAvailability(room, meeting[1]));
      } else {
        LC2402RoomAvailability ra = usedRooms.remove();
        int room = ra.room();
        int duration = meeting[1] - meeting[0];
        meetingCounts[room]++;
        usedRooms.add(new LC2402RoomAvailability(room, ra.availability() + duration));
      }
    }

    int room = 0;
    int maxMeetings = 0;
    for (int i = 0; i < n; i++) {
      if (meetingCounts[i] > maxMeetings) {
        room = i;
        maxMeetings = meetingCounts[i];
      }
    }
    return room;
  }
}

record LC2402RoomAvailability(int room, long availability) {}
