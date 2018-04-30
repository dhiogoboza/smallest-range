package range.model;

import range.model.Item;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author dhiogoboza
 */
public class IntegerRange extends Range<Integer> {
    
    public IntegerRange(int listsSize) {
        super(listsSize);
    }

    public IntegerRange(int listsSize, Integer min, Integer max) {
        super(listsSize, min, max);
    }

    public void addItem(Item<Integer> item) {
        if (first) {
            min = item.getElement();
            max = item.getElement();
            first = false;
        }
        
        if (item.getElement() < min) {
            min = item.getElement();
        }

        if (item.getElement() > max) {
            max = item.getElement();
        }

        lists.add(item.getListId());
    }

    @Override
    public Integer size() {
        return 1 + max - min;
    }
    
    @Override
    public IntegerRange clone() {
        IntegerRange clone = new IntegerRange(listsSize, min, max);
        clone.reset();
        
        return clone;
    }
    
    @Override
    public boolean isGreaterOf(Range another) {
        return (max == null || min == null) || (size() > (Integer) another.size());
    }
}
