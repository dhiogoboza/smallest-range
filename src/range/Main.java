package range;

import range.model.IntegerRange;
import range.model.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dhiogoboza
 */
public class Main {
    public final static boolean DEBUG = true;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Item> list1 = Arrays.asList(new Item(1, 4), new Item(1, 10),
                new Item(1, 15), new Item(1, 24),
                new Item(1, 26));
        
        List<Item> list2 = Arrays.asList(new Item(2, 0), new Item(2, 9),
                new Item(2, 12), new Item(2, 20));
        
        List<Item> list3 = Arrays.asList(new Item(3, 5), new Item(3, 18),
                new Item(3, 22), new Item(3, 30));
        
        List<Item> list4 = Arrays.asList(new Item(4, 6));
        
        List<List<Item>> items = new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        items.add(list4);
        
        IntegerRange integerRange = new IntegerRange(4);
        
        RangeCalculator.calcRange(items, integerRange);
    }
    
}
