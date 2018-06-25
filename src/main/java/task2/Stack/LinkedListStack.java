package task2.Stack;

public class LinkedListStack<E> implements IStack<E> {

    private Node<E> top;
    private int size = 0;

    public LinkedListStack() {
        top = new Node<>(null);
    }

    @Override
    public E push(E value) {
        Node<E> newNode = new Node(value);
        newNode.next = top.next;
        top.next = newNode;
        size++;
        return newNode.value;
    }

    @Override
    public E pop() {
        Node<E> topNode = top.next;
        top.next = topNode.next;
        topNode.next = null;
        size--;
        return topNode.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        Node<E> item = top.next;
        for (int i = 0; i < size; i++) {
            builder.append(item.value).append(" ");
            item = item.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
