package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.ArrayList;

public class _7_11FileSystem {
}

abstract class Entry {
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(String n, Directory p) {
        name = n;
        parent = p;
        created = System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
    }

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public abstract int size();

    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        else return parent.getFullPath() + "/" + name;
    }

    /* Getters and setters. */
    public long getCreationTime() {
        return created;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public void changeName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}

class File extends Entry {

    private String content;
    private int size;

    public File(String n, Directory p, int sz) {
        super(n, p);
        size = sz;
    }

    @Override
    public int size() {
        return size;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String c) {
        content = c;
    }
}

class Directory extends Entry {
    protected ArrayList<Entry> contents;

    public Directory(String n, Directory p) {
        super(n, p);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory d) {
                count++; // Directory counts as a file
                count += d.numberOfFiles();
            } else if (e instanceof File) {
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }

    protected ArrayList<Entry> getContents() {
        return contents;
    }
}
