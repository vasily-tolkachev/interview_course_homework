package task2.queue;

public interface IQueue<E> {

    E enqueue(E item);

    E dequeue();

    boolean isEmpty();

    int size();

}
