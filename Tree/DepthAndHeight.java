package Tree;

import List.Position;

public class DepthAndHeight {
    
    public int depth (Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }


    // Runs in O(n^2)
    private int heightBad () { 
        int h = 0; 
        for (Position<E> p : positions())
            if (isExternal(p))
                h = Math.max(h, depth(p)); 
        return h; 
    }

    // Runs in O(n)
    public int height(Position<E> p) { 
        int h = 0; 
        for (Position<E> c : children(p)) 
            h = Math.max(h, 1 + height(c)); 
        return h; 
    }
}
