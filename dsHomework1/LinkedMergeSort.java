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

    public static <T> Node<T>[] splitList(Node<T> head) {
        if (head == null) return new Node[]{null, null};
        
        Node<T> oddHead = head;
        Node<T> evenHead = head.next;
        Node<T> odd = oddHead;
        Node<T> even = evenHead;
        
        while (odd != null && even != null) {
            if (odd.next != null) odd.next = odd.next.next;
            if (even.next != null) even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        
        return new Node[]{oddHead, evenHead};
    }

    public static Node<Integer> mergeLists(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        Node<Integer> mergedHead;
        if (l1.getElement() < l2.getElement()) {
            mergedHead = l1;
            l1 = l1.next;
        } else {
            mergedHead = l2;
            l2 = l2.next;
        }
        
        Node<Integer> current = mergedHead;
        while (l1 != null && l2 != null) {
            if (l1.getElement() < l2.getElement()) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return mergedHead;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Split the list into odd and even
        Node<Integer>[] split = splitList(head);
        Node<Integer> lodd = split[0];
        Node<Integer> leven = split[1];
        
        // Recursively sort both halves
        lodd = mergeSort(lodd);
        leven = mergeSort(leven);
        
        // Merge the sorted halves
        return mergeLists(lodd, leven);
    }
}
