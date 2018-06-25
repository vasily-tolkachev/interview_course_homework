package task2;

public interface ILinkedListStack<E> {

    E push(E item);

    E pop();

    boolean isEmpty();

    int size();

}
