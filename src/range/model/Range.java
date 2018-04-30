package range.model;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author dhiogoboza
 * @param <T> element type
 */
public abstract class Range<T extends Comparable> {
    protected T min = null;
    protected T max = null;
    protected boolean first = true;

    protected int listsSize;
    protected final HashSet<T> lists = new HashSet<>();

    public Range(int listsSize) {
        this.listsSize = listsSize;
    }

    public Range(int listsSize, T min, T max) {
        this.listsSize = listsSize;
        this.min = min;
        this.max = max;
    }

    public boolean isComplete() {
        return lists.size() == listsSize;
    }

    public void reset() {
        lists.clear();
        first = true;
        max = null;
        min = null;
    }
    
    public void copy(Range another) {
        lists.clear();
        lists.addAll(another.lists);
        listsSize = another.listsSize;
        max = (T) another.max;
        min = (T) another.min;
    }

    @Override
    public String toString() {
        return "[" + min + ", " + max + ", " + size() + ", " + lists + ", " + isComplete() + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range another = (Range) obj;
            
            return Objects.equals(another.max, max) &&
                    Objects.equals(another.min, min) &&
                    listsSize == another.listsSize;
        }
        
        return false;
    }
    
    public abstract Range clone();
    public abstract void addItem(Item<T> item);
    public abstract T size();
    public abstract boolean isGreaterOf(Range another);

}
