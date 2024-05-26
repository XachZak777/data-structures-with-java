package dsHomework2;

import java.util.Iterator;
import List.*;



    
public class PositionalSorting {

    public static void selectionSort(LinkedPositionalList<Character> list) {
        Position<Character> marker = list.first();
        while (marker != null && list.after(marker) != null) {
            Position<Character> smallest = marker;
            Position<Character> current = list.after(marker);

            while (current != null) {
                if (current.getElement().compareTo(smallest.getElement()) < 0) {
                    smallest = current;
                }
                current = list.after(current);
            }
            if (smallest != marker) {
                Character smallestValue = list.remove(smallest);
                list.addBefore(marker, smallestValue);
            }
            marker = list.after(marker);
        }
    }

    public static void insertionSort(LinkedPositionalList<Character> list) {
        Position<Character> marker = list.first();
        while (marker != null && list.after(marker) != null) {
            Position<Character> pivot = list.after(marker);
            Character value = list.remove(pivot);
            Position<Character> current = marker;

            while (current != null && value.compareTo(current.getElement()) < 0) {
                current = list.before(current);
            }
            if (current == null) {
                list.addFirst(value);
            } else {
                list.addAfter(current, value);
            }
            marker = list.after(marker);
        }
    }

    public static void bubbleSort(LinkedPositionalList<Character> list) {
        boolean sorted;
        do {
            sorted = true;
            Position<Character> current = list.first();

            while (current != null && list.after(current) != null) {
                Position<Character> next = list.after(current);
                if (current.getElement().compareTo(next.getElement()) > 0) {
                    Character nextValue = list.remove(next);
                    list.addBefore(current, nextValue);
                    sorted = false;
                }
                current = list.after(current);
            }
        } while (!sorted);
    }

    public static void main(String[] args) {
        LinkedPositionalList<Character> list = new LinkedPositionalList<>();
        list.addLast('d');
        list.addLast('a');
        list.addLast('c');
        list.addLast('b');

        System.out.println("Original List:");
        printList(list);

        selectionSort(list);
        System.out.println("\nList after Selection Sort:");
        printList(list);

        list = new LinkedPositionalList<>();
        list.addLast('d');
        list.addLast('a');
        list.addLast('c');
        list.addLast('b');

        insertionSort(list);
        System.out.println("\nList after Insertion Sort:");
        printList(list);

        list = new LinkedPositionalList<>();
        list.addLast('d');
        list.addLast('a');
        list.addLast('c');
        list.addLast('b');

        bubbleSort(list);
        System.out.println("\nList after Bubble Sort:");
        printList(list);
    }

    private static void printList(LinkedPositionalList<Character> list) {
        Iterator<Character> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
