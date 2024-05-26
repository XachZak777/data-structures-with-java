package dsHomework2;

import java.util.*;

public class ArrayListE<E> extends ArrayList<E> {

    private class ArrayIterator implements ListIterator<E> {
        private int cursor;       // index of next element to return
        private int lastRet = -1; // index of last element returned; -1 if no such

        ArrayIterator(int index) {
            cursor = index;
        }

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            int i = cursor;
            if (i >= size())
                throw new NoSuchElementException();
            cursor = i + 1;
            return get(lastRet = i);
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public E previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i;
            return get(lastRet = i);
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                ArrayListWithListIterator.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                ArrayListWithListIterator.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            try {
                int i = cursor;
                ArrayListWithListIterator.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ArrayIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index);
        return new ArrayIterator(index);
    }

    public static void main(String[] args) {
        ArrayListWithListIterator<Integer> list = new ArrayListWithListIterator<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> it = list.listIterator();
        System.out.println("Traversing the list in forward direction:");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("Traversing the list in backward direction:");
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        it = list.listIterator(2); // Start iteration at index 2
        System.out.println("Starting iteration at index 2:");
        System.out.println("Next element: " + it.next());  // Should print element at index 2
        System.out.println("Previous element: " + it.previous());  // Should go back to index 2 and print element at index 2

        // Demonstrate add, set, and remove operations
        it.add(10);  // Add element before current position
        System.out.println("List after adding 10 at index 2: " + list);

        it.next(); // Move cursor to element 3
        it.set(20);  // Set element at current cursor position
        System.out.println("List after setting element at current cursor to 20: " + list);

        it.previous(); // Move cursor back to 3
        it.remove();  // Remove element at current cursor position
        System.out.println("List after removing element at current cursor: " + list);
    }
}

