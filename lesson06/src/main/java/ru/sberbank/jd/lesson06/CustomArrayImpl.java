package ru.sberbank.jd.lesson06;

import java.util.Arrays;
import java.util.Collection;

public class CustomArrayImpl<T> implements CustomArray<T> {
    private Object[] item;
    private int capacity;

    public CustomArrayImpl() {
        item = new Object[10];
        capacity = 10;
    }

    public CustomArrayImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else if (capacity == 0) {
            item = new Object[]{};
        } else {
            item = new Object[capacity];
            this.capacity = capacity;
        }
    }



    /*public CustomArrayImpl(Collection<? extends T> c) {
        item = new Object[capacity];
    }*/


    public int size() {
        return item.length;
    }


    public boolean isEmpty() {
        return capacity == 0;
    }

    /**
     * Add single item.
     *
     * @param item
     */

    public boolean add(T item) {

        return true;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */

    public boolean addAll(T[] items) {
        return false;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */

    public boolean addAll(Collection<T> items) {
        return false;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */

    public boolean addAll(int index, T[] items) {
        return false;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */

    public T get(int index) {
        return null;
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */

    public T set(int index, T item) {
        return null;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public void remove(int index) {

    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    public boolean remove(T item) {
        return false;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    public boolean contains(T item) {
        for (int i = 0; i < this.item.length; i ++ ){
            if (item.equals(this.item[i])){
                return true;
            }
        }
            return false;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */

    public int indexOf(T item) {
        for (int i = 0; i < this.item.length; i++){
            if (this.item[i] == item){
                return 1;
            }
        }
        return 0;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */

    public void ensureCapacity(int newElementsCount) {

    }

    /**
     * Get current capacity.
     */

    public int getCapacity() {
        return 0;
    }

    /**
     * Reverse list.
     */

    public void reverse() {
        Object[] temp = new Object[item.length];
        int index = temp.length - 1;
        for (int i = 0; i < item.length; i++, index--) {
            temp[index] = item[i];
        }
        item = temp;
    }

    @Override
    public String toString() {
        return "CustomArrayImpl{" +
                "item=" + Arrays.toString(item) +
                '}';
    }

    /**
     * Get copy of current array.
     */

    public Object[] toArray() {
        return Arrays.copyOf(item, capacity);
    }
}
