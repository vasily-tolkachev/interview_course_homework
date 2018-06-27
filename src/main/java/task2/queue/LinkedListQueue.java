package task2.queue;

import java.util.EmptyStackException;

public class LinkedListQueue<E> implements IQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedListQueue() {
        first = last = new Node<>(null);
    }

    @Override
    public E enqueue(E value) {
        if (size != 0) {
            Node<E> old = last;
            last = new Node<>(value);
            old.next = last;
        } else {
            last = first = new Node<>(value);
        }
        size++;
        return last.value;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node<E> item = first;
        first = item.next;
        item.next = null;
        size--;
        return item.value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    class Node<E> {
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> item = first.next;
        for (int i = 0; i < size; i++) {
            builder.append(item.value).append(" ");
            item = item.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
