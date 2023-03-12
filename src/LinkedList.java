package com.jakeespinosa;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    // O(1)
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;

    }

    // O(1)
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // O(1)
    public void deleteFirst() {
        // [20 -> 30]
        size--;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = null;
            last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
    }

    // O(n)
    public void deleteLast() {
        size--;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = null;
            last = null;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    // O(n)
    public int indexOf(int value) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // O(n)
    public boolean contains(int value) {
        return (indexOf(value) != -1);
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    private boolean isEmpty() {
        return (first == null);
    }

    // O(n)
    private Node getPrevious(Node node) {
        var current = first;
        while (current.next != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}