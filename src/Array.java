package com.jakeespinosa;

public class Array {
    private int[] items;
    private int itemCount;

    public Array(int size) {
        items = new int[size];
    }

    public void print() {
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        itemCount++;
        if (itemCount <= items.length) {
            items[itemCount -1] = item;
        } else {
            var newItems = new int[itemCount];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            newItems[itemCount - 1] = item;
            items = newItems;
        }
    }

    public void delete(int index) {
        if (index > itemCount - 1) {
            throw new IllegalArgumentException();
        }
        itemCount--;
        for (int i = index; i < itemCount; i++) {
            items[i] = items[i + 1];
        }
    }
    
    public int indexOf(int item) {
        for (int i = 1; i < itemCount; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
