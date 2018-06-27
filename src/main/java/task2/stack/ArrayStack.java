package task2.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements IStack<E> {

    private E[] array;
    private int size = 0;

    public ArrayStack() {
        this.array = (E[]) new Object[10];
    }

    private void resize(int newCapacity) {
        E[] newArray =(E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public E push(E item) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[size++] = item;
        return item;
    }

    @Override
    public E pop() {
        if (size == 0) throw new EmptyStackException();
        E item = array[--size];
        if (size > 0 && size == array.length/4) resize(array.length/2);
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) throw new EmptyStackException();
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
