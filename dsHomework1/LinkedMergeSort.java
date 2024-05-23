package dsHomework1;

public class LinkedMergeSort<E> {
    
    private static class Node <E> {
        
        private E element;
        
        private Node<E> next;
        
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement () { return element; }

        public Node<E> getNext () { return next; }

        public void setNext (Node<E> n) { next = n; }

    } 

    public static <E> void printList (Node<E> node) {
        Node<E> current = node;
        while (current.next != null) {
            System.out.print(current.getElement() + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static <T> Node<T> arrayToList(T[] array) {
        if (array.length == 0) return null;
        Node<T> head = new Node<>(array[0], null);
        Node<T> current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new Node<>(array[i], null);
            current = current.next;
        }
        return head;
    }

    // public static void main(String[] args) {
    //     LinkedMergeSort<String> list = new LinkedMergeSort<String>();
    //     String[] a = {"A", "B", "C", "D", "E"};
    //     arrayToList(a);

    //     System.out.println(a);
    // }
}
