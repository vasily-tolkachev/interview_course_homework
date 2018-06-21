package linked_list;

public interface ICircularDoubleLinkedList<E> extends Iterable<E> {

    boolean add(E value);

    boolean delete(E data);

    E first();

    E last();

    int length();

    E getAt(long index);


}
