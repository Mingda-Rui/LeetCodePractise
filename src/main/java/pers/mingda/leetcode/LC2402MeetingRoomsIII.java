package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2402MeetingRoomsIII {}

class LC2402Solution {
  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparingInt(i -> i[0]));

    Queue<LC2402MeetingRoom> pq = new PriorityQueue<>((m1, m2) -> Math.toIntExact(m1.end() == m2.end() ? m1.room() - m2.room() : m1.end() - m2.end()));
    int[] meetingCounts = new int[n];
    boolean[] occupiedRooms = new boolean[n];

    for (int i = 0; i < meetings.length; i++) {
      int[] meeting = meetings[i];
      while (!pq.isEmpty() && pq.peek().end() <= meeting[0]) {
        LC2402MeetingRoom finishedMeeting = pq.remove();
        int finishedRoom = finishedMeeting.room();
        occupiedRooms[finishedRoom] = false;
      }

      if (pq.size() < n){
        int room = getNextRoom(occupiedRooms);
        meetingCounts[room]++;
        occupiedRooms[room] = true;
        pq.add(new LC2402MeetingRoom(meeting[0], meeting[1], room));
      } else {
        LC2402MeetingRoom prevMr = pq.remove();
        int room = prevMr.room();
        long adjustTime = Math.max(0, prevMr.end() - meeting[0]);

        int duration = meeting[1] - meeting[0];
        meetingCounts[room]++;
        pq.add(new LC2402MeetingRoom(prevMr.end(), prevMr.end() + duration, room));
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

  private int getNextRoom(boolean[] occupiedRooms) {
    for (int i = 0; i < occupiedRooms.length; i++) {
      if (!occupiedRooms[i]) {
        return i;
      }
    }
    return -1;
  }
}

record LC2402MeetingRoom(long start, long end, int room) {}