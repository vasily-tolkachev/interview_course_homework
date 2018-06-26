package task2.stack;

public interface IStack<E> {

    E push(E item);

    E pop();

    E peek();

    boolean isEmpty();

    int size();

}
