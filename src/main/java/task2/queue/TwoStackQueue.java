package task2.queue;

import task2.stack.ArrayStack;
import task2.stack.IStack;
import task2.stack.LinkedListStack;

public class TwoStackQueue<E> implements IQueue<E> {

    private IStack<E> firstStack = new LinkedListStack<>();
    private IStack<E> secondStack = new ArrayStack<>();
    private int size;

    @Override
    public E enqueue(E item) {
        return firstStack.push(item);
    }

    @Override
    public E dequeue() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
        return secondStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return firstStack.size() + secondStack.size();
    }
}
