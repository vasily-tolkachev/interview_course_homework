package linked_list;

import java.util.Iterator;

public class CircularDoubleLinkedList<E> implements ICircularDoubleLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int length = 0;

    public CircularDoubleLinkedList() {
        first = last = new Node<>(null);
        first.previous = last;
        first.next = last;
        last.previous = first;
        last.next = first;

    }

    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node(value);
        if (length == 0) {
            first.value = last.value = value;
        }
        last.next = newNode;
        newNode.previous = last;
        newNode.next = first;
        first.previous = newNode;
        last = newNode;
        length++;
        return true;
    }

    @Override
    public boolean delete(E data) {
        return false;
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public E getAt(long index) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        Node<E> x;
        if (index < (length >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = length - 1; i > index; i--) {
                x = x.previous;
            }
        }
        return x.value;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    class Node<E> {
        private Node<E> previous;
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public String w() {
            return "Node{" +
                    "previous=" + previous +
                    ", next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}
