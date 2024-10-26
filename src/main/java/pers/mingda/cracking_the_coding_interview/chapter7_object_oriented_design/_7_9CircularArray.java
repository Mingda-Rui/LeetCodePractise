package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.Iterator;

public class _7_9CircularArray {
}

class CircularArray<T> implements Iterable<T> {

    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert (int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>();
    }

    private class CircularArrayIterator<E> implements Iterator<E> {

        /* current reflects the offset from the rotated head, not from the actual
         * start of the raw array. */
        private int _current = -1;
        private E[] _items;

        public CircularArrayIterator() {}

        @Override
        public boolean hasNext() {
            return _current < _items.length - 1;
        }

        @Override
        public E next() {
            _current++;
            return _items[convert(_current)];
        }

        private int convert (int index) {
            if (index < 0) {
                index += _items.length;
            }
            return (head + index) % _items.length;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}

