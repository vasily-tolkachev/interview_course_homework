package linked_list;

import java.util.Iterator;

public class CircularDoubleLinkedList<E> implements ICircularDoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length = 0;

    public CircularDoubleLinkedList() {
        head = tail = new Node<>(null);
        head.previous = head.next = head;
    }

    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node(value);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        head.previous = tail;
        newNode.next = head;
        length++;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        Node<E> currentNode = node(index);
        Node<E> previousNode = currentNode.previous;
        Node<E> nextNode = currentNode.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        currentNode.previous = null;
        currentNode.next = null;
        length--;
        return true;
    }

    @Override
    public E head() {
        return head.next.value;
    }

    @Override
    public E tail() {
        return tail.value;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public E getAt(int index) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        return node(index).value;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (length >> 1)) {
            x = head.next;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = length - 1; i > index; i--) {
                x = x.previous;
            }
        }
        return x;
    }

    class Node<E> {
        private Node<E> previous;
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }
    }
}
