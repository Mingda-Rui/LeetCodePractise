package pers.mingda.leetcode;

public class LC1095FindInMountainArray {}

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface LC1095MountainArray {
  int get(int index);
  int length();
}

class LC1097Solution {

  public int findInMountainArray(int target, LC1095MountainArray mountainArr) {
    int peakIndex = findPeak(mountainArr);
    int leftHeight = findHeight(mountainArr, 0, peakIndex, target, true);
    if (leftHeight != -1) {
      return leftHeight;
    }
    return findHeight(mountainArr, peakIndex, mountainArr.length(), target, false);
  }

  private int findPeak(LC1095MountainArray mountainArr) {
    int head = 0;
    int tail = mountainArr.length();

    while (head + 1 < tail) {
      int mid = (head + tail) / 2;
      int height = mountainArr.get(mid);
      int preHeight = mountainArr.get(mid - 1);
      if (height > preHeight) {
        head = mid;
      } else {
        tail = mid;
      }
    }

    return head;
  }

  private int findHeight(
    LC1095MountainArray mountainArr,
    int head,
    int tail,
    int height,
    boolean upHeel
  ) {
    while (head < tail) {
      int mid = (head + tail) / 2;
      int midHeight = mountainArr.get(mid);
      if (midHeight == height) {
        return mid;
      } else if (midHeight > height) {
        if (upHeel) {
          tail = mid;
        } else {
          head = mid + 1;
        }
      } else {
        if (upHeel) {
          head = mid + 1;
        } else {
          tail = mid;
        }
      }
    }
    return -1;
  }
}
