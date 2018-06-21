package linked_list;

public interface ICircularDoubleLinkedList<E> extends Iterable<E> {

    boolean add(E value);

    boolean delete(int index);

    E head();

    E tail();

    int length();

    E getAt(int index);


}
