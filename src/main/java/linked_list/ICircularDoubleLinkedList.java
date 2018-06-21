package linked_list;

public interface ICircularDoubleLinkedList<E> extends Iterable<E> {

    boolean add(E value);

    boolean delete(E data);

    Node<E> first();

    Node<E> last();

    int length();

    E getAt(long index);

    class Node<E> {
        private Node<E> previous;
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
    }
}
