package range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import range.model.Item;
import range.model.Range;

/**
 *
 * @author dhiogoboza
 */
public class RangeCalculator {
    private static final boolean DEBUG = Main.DEBUG;
    
    public static void calcRange(List<List<Item>> items, Range result) {
        List<Item> allItems = new ArrayList<Item>() {{
            for (List<Item> list: items) {
                addAll(list);
            }
        }};
        
        Collections.sort(allItems);
        
        Range currentRange;
        result.reset();
        
        Item item;
        for (int i = 0; i < allItems.size(); i++) {
            currentRange = result.clone();
            currentRange.reset();
            
            for (int j = i; j < allItems.size(); j++) {
                item = allItems.get(j);
                if (DEBUG) {
                    System.out.println("Item: " + item);
                }
                currentRange.addItem(item);

                if (currentRange.isComplete()) {
                    if (DEBUG) {
                        System.out.println("Range completed: " + currentRange);
                    }
                    
                    if (result.isGreaterOf(currentRange)) {
                        result.copy(currentRange);
                    }
                    
                    currentRange.reset();
                }
            }
            
            if (currentRange.isComplete() && result.isGreaterOf(currentRange)) {
                if (DEBUG) {
                    System.out.println("Range completed: " + currentRange);
                }
                
                result.copy(currentRange);
            }
            
            if (DEBUG) {
                System.out.println("------------");
            }
        }
        
        System.out.println("Result: " + result);
    }
    
}
