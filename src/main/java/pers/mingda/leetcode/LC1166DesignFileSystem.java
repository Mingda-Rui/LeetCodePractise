package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1166DesignFileSystem {}

class FileSystem {

  File root;

  public FileSystem() {
    root = new File("/", 0);
  }

  public boolean createPath(String path, int value) {
    String[] paths = path.trim().split("/");
    File currentLevel = root;
    for (int i = 1; i < paths.length - 1; i++) {
      String currentPath = paths[i];
      if (!currentLevel.map.containsKey(currentPath)) return false;
      currentLevel = currentLevel.map.get(currentPath);
    }
    String lowestLevelPath = paths[paths.length - 1];
    if (currentLevel.map.containsKey(lowestLevelPath)) return false;
    File lowestLevel = new File(lowestLevelPath, value);
    currentLevel.map.put(lowestLevelPath, lowestLevel);
    return true;
  }

  public int get(String path) {
    String[] paths = path.trim().split("/");
    File currentLevel = root;
    for (int i = 1; i < paths.length; i++) {
      String currentPath = paths[i];
      if (!currentLevel.map.containsKey(currentPath)) return -1;
      currentLevel = currentLevel.map.get(currentPath);
    }
    return currentLevel.value;
  }
}

class File {

  String path;
  int value;
  Map<String, File> map;

  public File(String path, int value) {
    this.path = path;
    this.value = value;
    this.map = new HashMap<>();
  }
}

class HashMapFileSystem {

  Map<String, Integer> map;

  public HashMapFileSystem() {
    this.map = new HashMap<>();
  }

  public boolean createPath(String path, int value) {
    if (path == null || path.isEmpty() || "/".equals(path.trim())) return false;
    if (map.containsKey(path)) return false;
    int lastSlashIndex = path.lastIndexOf("/");
    String parentPath = path.substring(0, lastSlashIndex);
    if (!parentPath.isEmpty() && !map.containsKey(parentPath)) return false;
    map.put(path, value);
    return true;
  }

  public int get(String path) {
    return map.getOrDefault(path, -1);
  }
}
/**
 * Your FileSystem object will be instantiated and called as such: FileSystem obj = new
 * FileSystem(); boolean param_1 = obj.createPath(path,value); int param_2 = obj.get(path);
 */
