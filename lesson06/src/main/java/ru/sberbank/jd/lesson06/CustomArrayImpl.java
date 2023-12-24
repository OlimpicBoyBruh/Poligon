package ru.sberbank.jd.lesson06;

import java.util.Arrays;
import java.util.Collection;

/**
 * Class is a dynamic array and implements the CustomArray interface.
 */

public class CustomArrayImpl<T> implements CustomArray<T> {
    /**
     * Array of objects.
     */
    private Object[] item;
    /**
     * Number of objects in the array.
     */
    private int size = 0;

    /**
     * Default Constructor.
     */
    public CustomArrayImpl() {
        item = new Object[10];
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
            item = new Object[]{};
        } else {
            item = new Object[capacity];
        }
    }

    /**
     * The constructor accepts another collection.
     *
     * @param c collection
     */

    public CustomArrayImpl(Collection<? extends T> c) {
        item = c.toArray();
        size = c.size();
    }

    /**
     * Returns the size.
     */

    public int size() {
        return size;
    }

    /**
     * Checks if it is empty.
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item Object T
     */

    public boolean add(T item) {
        try {
            this.item[size] = item;
            size++;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            ensureCapacity(this.item.length * 2);
            this.item[size] = item;
            size++;
            return true;
        }

    }

    /**
     * Add all items.
     *
     * @param items array Object T
     * @throws IllegalArgumentException if parameter items is null
     */

    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        if ((this.item.length - size - items.length) < 0) {
            ensureCapacity(this.item.length * 2);
        }
        System.arraycopy(items, 0, this.item, size, items.length);
        size += items.length;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items collection
     * @throws IllegalArgumentException if parameter items is null
     */

    public boolean addAll(Collection<T> items) {
        addAll((T[]) items.toArray());
        return true;
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
        if (items == null) {
            throw new IllegalArgumentException();
        }
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if ((this.item.length - size - items.length) <= 0) {
            ensureCapacity(this.item.length * 2);
        }
        System.arraycopy(items, 0, this.item, index, items.length);
        size = (index + items.length > size) ? index + items.length : size;
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) item[index];
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
        Object temp = this.item[index];
        this.item[index] = item;
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
        Object[] temp = new String[this.item.length];
        int count = size;
        int update = 0;
        int updateTemp = 0;
        while (update < count) {
            if (update != index) {
                temp[updateTemp] = this.item[update];
                updateTemp++;
            }
            update++;
        }
        size--;
        this.item = temp;
    }


    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    public boolean remove(T item) {
        Object[] temp = new String[this.item.length];
        boolean result = false;
        int index = 0;
        int indexTemp = 0;
        int count = size;
        while (index < count) {
            if (result) {
                temp[indexTemp] = this.item[index];
                indexTemp++;
            } else if (!this.item[index].equals(item)) {
                temp[indexTemp] = this.item[index];
                indexTemp++;
            } else {
                result = true;
                size--;
            }
            index++;
        }
        this.item = temp;
        return result;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    public boolean contains(T item) {
        for (Object o : this.item) {
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
            if (item.equals(this.item[index])) {
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
        Object[] tempItem = new Object[newElementsCount];
        if (size >= 0) {
            System.arraycopy(item, 0, tempItem, 0, size);
        }
        item = tempItem;
    }

    /**
     * Get current capacity.
     */

    public int getCapacity() {
        return item.length;
    }

    /**
     * Reverse list.
     */

    public void reverse() {
        Object[] temp = new Object[item.length];
        int index = size - 1;
        for (int i = 0; i < size; i++, index--) {
            temp[i] = item[index];
        }
        this.item = temp;
    }

    @Override
    public String toString() {
        Object[] tempArray = toArray();
        return Arrays.toString(tempArray);
    }

    /**
     * Get copy of current array.
     */

    public Object[] toArray() {
        return Arrays.copyOf(item, size);
    }
}