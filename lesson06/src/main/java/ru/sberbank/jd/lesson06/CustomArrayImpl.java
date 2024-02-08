package ru.sberbank.jd.lesson06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Class is a dynamic array and implements the CustomArray interface.
 */

public class CustomArrayImpl<T> implements CustomArray<T> {
    /**
     * Array of objects.
     */
    private Object[] items;
    /**
     * Number of objects in the array.
     */
    private int size = 0;

    /**
     * Default Constructor.
     */
    public CustomArrayImpl() {
        items = new Object[10];
    }

    /**
     * The constructor takes a number to specify capacity.
     *
     * @param capacity size array
     */
    public CustomArrayImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else if (capacity == 0) {
            items = new Object[]{};
        } else {
            items = new Object[capacity];
        }
    }

    /**
     * The constructor accepts another collection.
     *
     * @param c collection
     */
    public CustomArrayImpl(Collection<? extends T> c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        items = c.toArray();
        size = c.size();
    }

    /**
     * the size.
     *
     * @return int.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if it is empty.
     *
     * @return boolean.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item Object T
     * @return boolean
     */
    public boolean add(T item) {
        ensureCapacity(this.items.length * 2);
        this.items[size] = item;
        size++;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items array Object T
     * @return boolean
     * @throws IllegalArgumentException if parameter items is null
     */
    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        if ((this.items.length - size - items.length) < 0) {
            ensureCapacity(this.items.length * 2);
        }
        System.arraycopy(items, 0, this.items, size, items.length);
        size += items.length;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items collection
     * @return boolean
     * @throws IllegalArgumentException if parameter items is null
     */
    public boolean addAll(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        addAll((T[]) items.toArray());
        return true;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @return boolean
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    public boolean addAll(int index, T[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if ((this.items.length - size - items.length) <= 0) {
            ensureCapacity(this.items.length * 2);
        }
        System.arraycopy(items, 0, this.items, index, items.length);
        size = (index + items.length > size) ? index + items.length : size;
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @return an object by index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) items[index];
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item  Object T
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public T set(int index, T item) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object temp = this.items[index];
        this.items[index] = item;
        return (T) temp;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] temp = new String[this.items.length];
        int count = size;
        int update = 0;
        int updateTemp = 0;
        while (update < count) {
            if (update != index) {
                temp[updateTemp] = this.items[update];
                updateTemp++;
            }
            update++;
        }
        size--;
        this.items = temp;
    }


    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    public boolean remove(T item) {
        Object[] temp = new String[this.items.length];
        boolean result = false;
        int index = 0;
        int indexTemp = 0;
        int count = size;
        while (index < count) {
            if (result) {
                temp[indexTemp] = this.items[index];
                indexTemp++;
            } else if (!this.items[index].equals(item)) {
                temp[indexTemp] = this.items[index];
                indexTemp++;
            } else {
                result = true;
                size--;
            }
            index++;
        }
        this.items = temp;
        return result;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false depending on the result of the check
     */
    public boolean contains(T item) {
        for (Object o : this.items) {
            if (item.equals(o)) {
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
        for (int index = 0; index < size; index++) {
            if (Objects.equals(this.items[index], item)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    public void ensureCapacity(int newElementsCount) {
        if (newElementsCount <= 0) {
            throw new IllegalArgumentException();
        }
        if (size == items.length) {
            Object[] tempItem = new Object[newElementsCount];
            System.arraycopy(items, 0, tempItem, 0, size);
            items = tempItem;
        }
    }

    /**
     * Get current capacity.
     *
     * @return int capacity
     */
    public int getCapacity() {
        return items.length;
    }

    /**
     * Reverse list.
     */
    public void reverse() {
        int tempSize = size;
        for (int index = 0; index < size / 2; index++) {
            T temp = (T) items[tempSize - 1];
            items[tempSize - 1] = items[index];
            items[index] = temp;
            tempSize--;
        }
    }

    /**
     * In general,
     * the toString method returns a string that "textually represents" this object.
     * The result should be a concise but informative representation that is easy
     * for a person to read.
     *
     * @return Returns a string representation of the object.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size - 1; i++) {
            sb.append(items[i]).append(", ");
        }
        sb.append(items[size - 1]).append(']');
        return sb.toString();
    }

    /**
     * Get copy of current array.
     */
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }
}
