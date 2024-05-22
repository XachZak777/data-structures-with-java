package Stack;

import List.SinglyLikedList;

public class LinkedStack<E> implements Stack<E> {

    private SinglyLikedList<E> list = new SinglyLikedList<>();

    public LinkedStack () {}

    public int size () { return list.size(); }

    public boolean isEmpty () { return list.isEmpty(); }

    public void push (E e) { list.addFirst(e); }

    public E top () { return list.first(); }

    public E pop () { return list.removeFirst(); }

    public static <E> void reverse (E[] data) {
        Stack<E> buffer = new ArrayStack<>(data.length);

        for (int i = 0; i < data.length; i++)
            buffer.push(data[i]);
        for (int i = 0; i < data.length; i++)
            data[i] = buffer.pop();
    }

}
