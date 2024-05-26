package dsHomework2;

import java.util.List;

public class BinarySearch {
    
    // Efficiency O(log n)
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midElement = list.get(mid);

            int comparison = midElement.compareTo(target);
            if (comparison == 0) 
                return mid;  // target found
             else if (comparison < 0) 
                left = mid + 1;  // target is in the right half
            else 
                right = mid - 1;  // target is in the left half
        }
        return -1;  // target not found
    }
}
