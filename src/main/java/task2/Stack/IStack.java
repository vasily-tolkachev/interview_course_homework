package task2.Stack;

public interface IStack<E> {

    E push(E item);

    E pop();

    boolean isEmpty();

    int size();

}
